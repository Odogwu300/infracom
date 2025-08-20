import { useEffect, useState } from "react";
let pushFn: (msg:string, kind?:'info'|'success'|'error') => void = () => {};
export function pushToast(msg:string, kind:'info'|'success'|'error'='info'){ pushFn(msg, kind); }
export default function ToastContainer(){ const [toasts, setToasts] = useState<{id:number,msg:string,kind:string}[]>([]);
  useEffect(()=>{ pushFn = (msg, kind='info')=> { const id = Date.now()+Math.floor(Math.random()*1000); setToasts(t=>[...t,{id,msg,kind}]); setTimeout(()=> setToasts(t=>t.filter(x=>x.id!==id)), 4000); }; return ()=>{ pushFn = ()=>{}; } }, []);
  return (<div className="fixed bottom-4 right-4 flex flex-col gap-2 z-50">{toasts.map(t=> (<div key={t.id} className={`px-4 py-2 rounded shadow ${t.kind==='error'?'bg-red-100 text-red-800':'bg-white text-gray-800'}`}>{t.msg}</div>))}</div>);
}
