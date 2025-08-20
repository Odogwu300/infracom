import './register.css';
import React, { useState } from "react";
import image from "../icone/market.jpg";
import logo from "../icone/logo.png";
import { Link, useNavigate } from "react-router-dom";
import api from "../api/axiosInstance";
import { FaUserShield } from 'react-icons/fa';
import { BsFillShieldLockFill } from 'react-icons/bs';
import { AiOutlineSwapRight } from "react-icons/ai";

export default function Register() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [confirmPassword, setConfirmPassword] = useState("");
  const [error, setError] = useState<string | null>(null);
  const [success, setSuccess] = useState<string | null>(null);
  const navigate = useNavigate();

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    setError(null);
    setSuccess(null);

    if (password !== confirmPassword) {
      setError("Les mots de passe ne correspondent pas.");
      return;
    }

    try {
      await api.post("/auth/signup", { username, password });
      setSuccess("Inscription réussie ! Vous pouvez maintenant vous connecter.");
      setTimeout(() => navigate("/login"), 2000);
    } catch (err: any) {
      setError(
        err.response?.data?.message || "Échec de l'inscription. Veuillez réessayer."
      );
    }
  };

  return (
    <div className="registerPage flex">
      <div className="container flex">

        {/* Partie gauche avec l’image */}
        <div className="photoDiv">
          <img src={image} alt="infrastructure" />
          <div className='textDiv'>
            <h2 className='title'>Infracom</h2>
            <p>Une bonne gestion pour tous</p>
          </div>

          <div className='footerDiv flex'>
            <span className='text'>Vous avez déjà un compte?</span>
            <Link to={'/login'}>
              <button className='btn'>Connexion</button>
            </Link>
          </div>
        </div>

        {/* Partie droite avec le formulaire */}
        <div className="formDiv fex">
          <div className='headerDiv'>
            <img src={logo} alt="mon Logo" />
            <h3>Bienvenue</h3>
          </div>

          <form onSubmit={handleSubmit} className='form grid'>

            <div className='inputDiv'>
              <label htmlFor="username">Nom d'utilisateur</label>
              <div className='input flex'>
                <FaUserShield className='icon'/>
                <input id="username" type="text" value={username}
                  onChange={(e) => setUsername(e.target.value)}
                  placeholder='Entrez votre nom' required />
              </div>
            </div>

            <div className='inputDiv'>
              <label htmlFor="password">Mot de passe</label>
              <div className='input flex'>
                <BsFillShieldLockFill className='icon'/>
                <input id="password" type="password" value={password}
                  onChange={(e) => setPassword(e.target.value)}
                  placeholder='Entrez votre mot de passe' required />
              </div>
            </div>

            <div className='inputDiv'>
              <label htmlFor="confirmPassword">Confirmer le mot de passe</label>
              <div className='input flex'>
                <BsFillShieldLockFill className='icon'/>
                <input id="confirmPassword" type="password" value={confirmPassword}
                  onChange={(e) => setConfirmPassword(e.target.value)}
                  placeholder="Confirmer le mot de passe" required />
              </div>
            </div>

            {error && <p className="text-red-500 text-sm">{error}</p>}
            {success && <p className="text-green-500 text-sm">{success}</p>}

            <button type='submit' className='btn flex'>
              <span>S'inscrire</span>
              <AiOutlineSwapRight className='icon'/>
            </button>

            <span className='forgotPassword'>
              Mot de passe oublié? <a href="">Cliquez ici</a>
            </span>
          </form>
        </div>
      </div>
    </div>
  );
}
