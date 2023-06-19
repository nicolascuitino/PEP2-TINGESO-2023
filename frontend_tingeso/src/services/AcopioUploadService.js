import axios from "axios";

const API_URL = "http://localhost:8080/acopio/fileUpload";

class AcopioUploadService{
    
    CargarArchivo(file){
        return axios.post(API_URL, file);
    }
}

export default new AcopioUploadService()