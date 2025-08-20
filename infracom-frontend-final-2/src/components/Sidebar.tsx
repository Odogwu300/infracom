import { NavLink } from "react-router-dom";
export default function Sidebar(){ const links = [{name:'Dashboard',path:'/dashboard'},{name:'Infrastructures',path:'/infrastructures'},{name:'Équipements',path:'/equipements'},{name:'Usagers',path:'/usagers'},{name:'Affectations',path:'/affectations'},{name:'Paiements',path:'/paiements'},{name:'Maintenances',path:'/maintenances'},{name:'Notifications',path:'/notifications'}];
  return (<aside className="bg-gray-800 text-white w-60 min-h-screen p-4"><nav className="flex flex-col gap-2">{links.map(l=>(<NavLink key={l.name} to={l.path} className={({isActive})=>`p-2 rounded hover:bg-gray-700 ${isActive?'bg-gray-700 font-bold':''}`}>{l.name}</NavLink>))}</nav></aside>);
}
