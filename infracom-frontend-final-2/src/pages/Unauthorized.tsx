import { Link } from "react-router-dom";

export default function Unauthorized() {
  return (
    <div className="flex flex-col items-center justify-center min-h-screen bg-gray-100">
      <div className="bg-white p-8 rounded shadow-md text-center">
        <h1 className="text-3xl font-bold text-red-600 mb-4">Accès refusé</h1>
        <p className="mb-6 text-gray-700">
          Vous n'avez pas les permissions nécessaires pour accéder à cette page.
        </p>
        <Link
          to="/dashboard"
          className="px-4 py-2 bg-blue-600 text-white rounded hover:bg-blue-700"
        >
          Retour au tableau de bord
        </Link>
      </div>
    </div>
  );
}
