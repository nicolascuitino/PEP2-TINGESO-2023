import logo from './logo.svg';
import './App.css';
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Menu from './components/MenuComponent';
import IndexComponent from './components/IndexComponent';
import NewProveedorComponent from './components/NewProveedorComponent';
import AcopioUploadComponent from './components/AcopioUploadComponent';
import GySTUploadComponent from './components/GySTUploadComponent';
import PagosComponent from './components/PagosComponent';

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Menu />} />
          <Route path="/listar" element={<IndexComponent />} />
          <Route path="/new-proveedor" element={<NewProveedorComponent />} />
          <Route path="/fileUpload" element={<AcopioUploadComponent />} />
          <Route path="/detailsUpload" element={<GySTUploadComponent />} />
          <Route path="/pagos" element={<PagosComponent />} />

        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
