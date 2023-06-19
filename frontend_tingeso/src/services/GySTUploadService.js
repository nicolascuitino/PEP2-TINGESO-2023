import axios from "axios";

const API_URL = "http://localhost:8080/details/detailsUpload";

class GySTUploadService{
    
    CargarArchivo(file){
        return axios.post(API_URL, file);
    }
}

export default new GySTUploadService()