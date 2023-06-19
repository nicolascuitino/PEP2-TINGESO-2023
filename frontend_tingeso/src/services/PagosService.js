import axios from "axios";

const PROVEEDOR_URL = "http://localhost:8080/pagos";

class PagosService {
    getPagos(){
        return axios.get(PROVEEDOR_URL);
    }

   
}

export default new PagosService()