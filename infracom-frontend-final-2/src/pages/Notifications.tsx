import Layout from "../components/Layout";
import axiosInstance from "../api/axiosInstance";
import { useEffect, useState } from "react";
import { pushToast } from "../components/Toast";
interface NotificationRow{ id:number; message:string; date:string; read:boolean; }
const ENDPOINT='/notifications';
export default function Notifications(){ const [rows,setRows]=useState<NotificationRow[]>([]); const fetchData=async()=>{ try{ const r=await axiosInstance.get<NotificationRow[]>(ENDPOINT); setRows(r.data);}catch(e){pushToast('Err','error')} }; useEffect(()=>{fetchData()},[]); return (<Layout><h2 className="text-2xl font-semibold mb-4">Notifications</h2><div className="bg-white border rounded overflow-auto"><table className="w-full"><thead className="bg-gray-100"><tr><th className="border px-3 py-2">ID</th><th className="border px-3 py-2">Message</th><th className="border px-3 py-2">Date</th><th className="border px-3 py-2">Lu</th></tr></thead><tbody>{rows.map(r=>(<tr key={r.id} className="hover:bg-gray-50"><td className="border px-3 py-2">{r.id}</td><td className="border px-3 py-2">{r.message}</td><td className="border px-3 py-2">{r.date}</td><td className="border px-3 py-2">{String(r.read)}</td></tr>))}</tbody></table></div></Layout>); }
