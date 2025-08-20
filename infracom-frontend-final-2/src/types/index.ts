export interface User { id:number; username:string; roles:string[]; email?:string; }
export interface JwtResponse { token:string; username:string; roles:string[]; id?:number; user?:User; }
