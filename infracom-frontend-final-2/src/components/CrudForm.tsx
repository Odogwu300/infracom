import { useEffect, useState } from "react";
type Field = { name:string; label:string; type:'string'|'number'|'date'|'select'|'file'; options?:{label:string,value:any}[] };
export default function CrudForm<T>({ initial, fields, onSubmit, submitLabel='Enregistrer' }: { initial:Partial<T>; fields:Field[]; onSubmit:(values:any, files?:Record<string,File>)=>Promise<void>|void; submitLabel?:string }){
  const [values,setValues] = useState<any>(initial || {});
  const [files,setFiles] = useState<Record<string,File>>({});
  useEffect(()=>{ setValues(initial || {}); }, [initial]);
  const handleChange = (name:string, v:any) => setValues((s:any)=>({ ...s, [name]: v }));
  return (<form onSubmit={e=>{ e.preventDefault(); onSubmit(values, files); }} className="space-y-3">
    {fields.map(f=> (<div key={f.name} className="flex flex-col"><label className="text-sm text-gray-700 mb-1">{f.label}</label>{f.type==='select'? (<select value={values[f.name] ?? ''} onChange={e=>handleChange(f.name, e.target.value)} className="border p-2 rounded"><option value=''>— Sélectionner —</option>{f.options?.map(o=>(<option key={o.value} value={o.value}>{o.label}</option>))}</select>) : f.type==='file'? (<input type="file" onChange={e=>{ if(e.target.files && e.target.files[0]) setFiles(s=>({ ...s, [f.name]: e.target.files![0] })); }} />) : (<input type={f.type==='number'?'number': f.type==='date'?'date':'text'} value={values[f.name] ?? ''} onChange={e=> handleChange(f.name, f.type==='number'? Number(e.target.value) : e.target.value)} className="border p-2 rounded" />)}</div>))}
    <button className="bg-blue-600 text-white px-4 py-2 rounded hover:bg-blue-700">{submitLabel}</button>
  </form>);
}
