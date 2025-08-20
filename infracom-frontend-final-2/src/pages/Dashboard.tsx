import Layout from "../components/Layout";
import axiosInstance from "../api/axiosInstance";
import { useEffect, useState } from "react";
export default function Dashboard(){
  const [stats,setStats] = useState<any>({});
  useEffect(()=>{ const load = async ()=>{ try{ const [o,p] = await Promise.all([axiosInstance.get('/api/statistiques/occupations'), axiosInstance.get('/api/statistiques/paiements')]); setStats({occupations:o.data,paiements:p.data}); }catch(e){} }; load(); }, []);
  return (<Layout><h2 className="text-2xl font-semibold mb-4">Tableau de bord</h2><div className="grid grid-cols-1 md:grid-cols-2 gap-4"><div className="bg-white p-4 rounded border"><h3 className="font-semibold mb-2">Occupations</h3><pre className="text-sm">{JSON.stringify(stats.occupations,null,2)}</pre></div><div className="bg-white p-4 rounded border"><h3 className="font-semibold mb-2">Paiements</h3><pre className="text-sm">{JSON.stringify(stats.paiements,null,2)}</pre></div></div></Layout>);
}
