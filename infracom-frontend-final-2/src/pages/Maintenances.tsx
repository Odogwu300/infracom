import Layout from "../components/Layout";
import axiosInstance from "../api/axiosInstance";
import { useEffect, useState } from "react";
import { pushToast } from "../components/Toast";
interface MaintenanceRow{ id:number; description:string; status:string; reportedAt:string; scheduledAt:string; }
const ENDPOINT='/maintenances';
export default function Maintenances(){ const [rows,setRows]=useState<MaintenanceRow[]>([]); const fetchData=async()=>{ try{ const r=await axiosInstance.get<MaintenanceRow[]>(ENDPOINT); setRows(r.data);}catch(e){pushToast('Err','error')} }; useEffect(()=>{fetchData()},[]); return (<Layout><h2 className="text-2xl font-semibold mb-4">Maintenances</h2><div className="bg-white border rounded overflow-auto"><table className="w-full"><thead className="bg-gray-100"><tr><th className="border px-3 py-2">ID</th><th className="border px-3 py-2">Description</th><th className="border px-3 py-2">Statut</th><th className="border px-3 py-2">Déclaré</th><th className="border px-3 py-2">Prévu</th></tr></thead><tbody>{rows.map(r=>(<tr key={r.id} className="hover:bg-gray-50"><td className="border px-3 py-2">{r.id}</td><td className="border px-3 py-2">{r.description}</td><td className="border px-3 py-2">{r.status}</td><td className="border px-3 py-2">{r.reportedAt}</td><td className="border px-3 py-2">{r.scheduledAt}</td></tr>))}</tbody></table></div></Layout>); }
