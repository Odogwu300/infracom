import './Login.css'; // Assurez-vous d'avoir un fichier CSS pour le style
import React, { useState } from "react";
import image from "../icone/market.jpg"; // Assurez-vous que le chemin est correct
import logo from "../icone/logo.png";
import { Link, useNavigate } from "react-router-dom";
import { useAuth } from "../context/AuthContext";
import api from "../api/axiosInstance";
import { FaUserShield } from 'react-icons/fa';
import { BsFillShieldLockFill } from 'react-icons/bs';
import { AiOutlineSwapRight } from "react-icons/ai";

export default function Login() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState<string | null>(null);
  const { login } = useAuth();
  const navigate = useNavigate();

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    setError(null);

    try {
      console.log("Envoi de la requête POST à:", api.defaults.baseURL + "/auth/signin");
      const res = await api.post("/auth/signin", { username, password }, { timeout: 10000 });
      console.log("Réponse complète:", res);
      
      const token = res.data.token ?? res.data; // s'adapte selon la structure backend
      if (!token || typeof token !== "string") {
        throw new Error("Aucun token valide reçu. Réponse: " + JSON.stringify(res.data));
      }

      login(token);
      navigate("/dashboard");
    } catch (err: any) {
      console.error("Erreur détaillée:", {
        message: err.message,
        response: err.response?.data,
        status: err.response?.status,
        config: err.config,
      });
      setError(
        "Échec de la connexion. Vérifiez vos identifiants ou contactez un administrateur. " +
        (err.message === "timeout of 10000ms exceeded" ? "Délai d'attente dépassé" : err.response?.data?.message || err.message)
      );
    }
  };

  return (
    <div className="loginPage flex">
      <div className="container flex">

        <div className="photoDiv">
          <img src={image} alt="infrastructure" />
          <div className='textDiv'>
            <h2 className='title'>Infracom</h2>
            <p>Une bonne gestion pour tous</p>
          </div>

          <div className='footerDiv flex'>
            <span className='text'>Vous n'avez pas de compte</span>
            <Link to={'/register'}>
              <button className='btn'>Inscrivez-vous</button>
            </Link>
          </div>
        </div>

        <div className="formDiv flex">
          <div className='headerDiv'>
            <img src={logo} alt="mon Logo" />
            <h3>Bienvenue</h3>
          </div>

          <form onSubmit={handleSubmit} className='form grid'>
            <span className='showMessage'>le statut de connexion ira ici</span>
            
            <div className='inputDiv'>
              <label htmlFor="username">Nom d'utilisateur</label>
              <div className='input flex'>
                <FaUserShield className='icon'/>
                <input 
                  type="text" 
                  id='username' 
                  value={username}
                  onChange={(e) => setUsername(e.target.value)} 
                  placeholder='Enter username'
                  autoComplete="username"
                  required 
                />
              </div>
            </div>

            <div className='inputDiv'>
              <label htmlFor="password">Mot de passe</label>
              <div className='input flex'>
                <BsFillShieldLockFill className='icon'/>
                <input 
                  type="password" 
                  id='password' 
                  value={password}
                  onChange={(e) => setPassword(e.target.value)} 
                  placeholder='Enter password'
                  autoComplete="current-password"
                  required 
                />
              </div>
            </div>

            {error && <p className="text-red-500 text-sm">{error}</p>}
            
            <button type='submit' className='btn flex'>
              <span>Connexion</span>
              <AiOutlineSwapRight className='icon'/>
            </button>

            <span className='forgotPassword'>
              Mot de passe oublié? <a href="#">Clique ici</a>
            </span>
          </form>

        </div>  
      </div>
    </div>
  );
}
