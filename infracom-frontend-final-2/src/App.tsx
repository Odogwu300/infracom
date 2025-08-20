import { Routes, Route, Navigate } from "react-router-dom";
import { AuthProvider } from "./context/AuthContext";
import ProtectedRoute from "./routes/ProtectedRoute";

import Login from "./pages/Login";
import Dashboard from "./pages/Dashboard";
import Infrastructures from "./pages/Infrastructures";
import Equipements from "./pages/Equipements";
import Usagers from "./pages/Usagers";
import Affectations from "./pages/Affectations";
import Paiements from "./pages/Paiements";
import Maintenances from "./pages/Maintenances";
import Notifications from "./pages/Notifications";
import Unauthorized from "./pages/Unauthorized";

export default function App() {
  return (
    <AuthProvider>
      <Routes>
        {/* Public */}
        <Route path="/login" element={<Login />} />

        {/* Redirection racine */}
        <Route path="/" element={<Navigate to="/dashboard" replace />} />

        {/* Routes protégées accessibles à tous les utilisateurs connectés */}
        <Route
          path="/dashboard"
          element={
            <ProtectedRoute>
              <Dashboard />
            </ProtectedRoute>
          }
        />
        <Route
          path="/infrastructures"
          element={
            <ProtectedRoute>
              <Infrastructures />
            </ProtectedRoute>
          }
        />
        <Route
          path="/equipements"
          element={
            <ProtectedRoute>
              <Equipements />
            </ProtectedRoute>
          }
        />
        <Route
          path="/affectations"
          element={
            <ProtectedRoute>
              <Affectations />
            </ProtectedRoute>
          }
        />
        <Route
          path="/paiements"
          element={
            <ProtectedRoute>
              <Paiements />
            </ProtectedRoute>
          }
        />
        <Route
          path="/maintenances"
          element={
            <ProtectedRoute>
              <Maintenances />
            </ProtectedRoute>
          }
        />
        <Route
          path="/notifications"
          element={
            <ProtectedRoute>
              <Notifications />
            </ProtectedRoute>
          }
        />

        {/* Route protégée pour les usagers */}
        <Route
          path="/usagers"
          element={
            <ProtectedRoute>
              <Usagers />
            </ProtectedRoute>
          }
        />

        {/* Page accès refusé */}
        <Route path="/unauthorized" element={<Unauthorized />} />

        {/* Catch-all */}
        <Route path="*" element={<Navigate to="/login" replace />} />
      </Routes>
    </AuthProvider>
  );
}