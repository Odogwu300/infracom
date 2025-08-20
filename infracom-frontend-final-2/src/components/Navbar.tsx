import { useAuth } from "../context/AuthContext";
import { useNavigate, Link } from "react-router-dom";
export default function Navbar(){ const { user, logout } = useAuth(); const navigate = useNavigate();
  return (<header className="bg-blue-600 text-white flex justify-between items-center p-4 shadow"><Link to="/dashboard" className="text-xl font-bold">Infracom</Link><div className="flex items-center gap-4"><span className="hidden sm:inline">{user?.username}</span><button onClick={()=>{logout();navigate('/login')}} className="bg-red-500 px-3 py-1 rounded hover:bg-red-600">Déconnexion</button></div></header>);
}
