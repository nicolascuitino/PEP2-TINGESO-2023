import axios from "axios";

const PROVEEDOR_URL = "http://localhost:8080/proveedor/";

class ProveedorService {
    getProveedores(){
        return axios.get(PROVEEDOR_URL + '/getall');
    }

    createProveedor(proveedor){
        return axios.post(PROVEEDOR_URL, proveedor);
    }
}

export default new ProveedorService()