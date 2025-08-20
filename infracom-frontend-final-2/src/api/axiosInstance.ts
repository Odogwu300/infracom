import axios from "axios";

// Création d'une instance Axios avec la nouvelle URL de base
const api = axios.create({
  baseURL: "http://localhost:9092/api", // Mise à jour de l'URL
});

// Intercepteur pour ajouter le token aux en-têtes des requêtes
api.interceptors.request.use(
  (config) => {
    const token = localStorage.getItem("token");
    if (token && config.headers) {
      config.headers.Authorization = `Bearer ${token}`;
    }
    return config;
  },
  (error) => Promise.reject(error)
);

export default api;