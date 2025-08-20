import { createContext, useContext, useState, ReactNode } from "react";
import { jwtDecode } from "jwt-decode";

interface User {
  username: string;
  roles: string[];
}

interface JwtPayload {
  sub: string;        // username
  roles: string[];    // roles
}

interface AuthContextType {
  user: User | null;
  login: (token: string) => void;
  logout: () => void;
}

const AuthContext = createContext<AuthContextType | undefined>(undefined);

export const AuthProvider = ({ children }: { children: ReactNode }) => {
  const [user, setUser] = useState<User | null>(
    JSON.parse(localStorage.getItem("user") || "null")
  );

  const login = (token: string) => {
    localStorage.setItem("token", token);

    try {
      const decoded: JwtPayload = jwtDecode(token);
      const newUser: User = {
        username: decoded.sub,
        roles: decoded.roles || [],
      };
      localStorage.setItem("user", JSON.stringify(newUser));
      setUser(newUser);
    } catch (err) {
      console.error("Erreur décodage JWT :", err);
      logout();
    }
  };

  const logout = () => {
    localStorage.removeItem("token");
    localStorage.removeItem("user");
    setUser(null);
  };

  return (
    <AuthContext.Provider value={{ user, login, logout }}>
      {children}
    </AuthContext.Provider>
  );
};

export const useAuth = () => {
  const ctx = useContext(AuthContext);
  if (!ctx) throw new Error("useAuth must be used within AuthProvider");
  return ctx;
};
