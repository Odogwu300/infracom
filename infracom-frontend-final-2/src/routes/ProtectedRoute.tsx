import { ReactNode } from "react";
import { Navigate } from "react-router-dom";
import { useAuth } from "../context/AuthContext";

// Interface pour les props du composant
interface ProtectedRouteProps {
  children: ReactNode;
}

// Composant pour protéger les routes
export default function ProtectedRoute({ children }: ProtectedRouteProps) {
  const { token } = useAuth();
  
  // Si pas de token, redirige vers la page de login
  if (!token) return <Navigate to="/login" replace />;
  
  // Sinon, affiche les enfants (contenu de la route protégée)
  return <>{children}</>;
}