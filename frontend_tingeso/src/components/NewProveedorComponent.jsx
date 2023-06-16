import React, { Component } from "react";
import styled from "styled-components";
import ProveedorService from "../services/ProveedorService";


class NewProveedorComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            codigo: '',
            nombre: '',
            categoria: '',
            retencion: ''
        }
        this.changeCodigoHander = this.changeCodigoHander.bind(this);
        this.changeNombreHandler = this.changeNombreHandler.bind(this);
        this.changeCategoriaHandler = this.changeCategoriaHandler.bind(this);
        this.changeRetencionHandler = this.changeRetencionHandler.bind(this);
        this.saveProveedor = this.saveProveedor.bind(this);
    }

    saveProveedor = (e) => {
        e.preventDefault();
        let proveedor = {codigo: this.state.codigo,
                         nombre: this.state.nombre,
                         categoria: this.state.categoria,
                         retencion: this.state.retencion};

        ProveedorService.createProveedor(proveedor);
    }

    changeCodigoHander= (event) => {
        this.setState({codigo: event.target.value});
    }

    changeNombreHandler= (event) => {
        this.setState({nombre: event.target.value});
    }

    changeCategoriaHandler= (event) => {
        this.setState({categoria: event.target.value});
    }

    changeRetencionHandler= (event) => {
        this.setState({retencion: event.target.value});
    }


    render(){
        return(
            <div className="home">
                <Styles>
                <header class="header">
                    <div class="logo">
                        <h1>MilkStgo</h1>
                    </div>
                    <nav>
                    </nav>
                    <a class="btn" href="/"><button>Volver al menú principal</button></a>
                    <a class="btn-2" href="/listar"><button>Ver proveedores</button></a>
                </header>
                <div class = "container">
                <div class = "row">
                    <div class = "col-lg-6 col-md-6 col-sm-6 container justify-content-center card">
                        <h1 class = "text-center"> Ingrese el nuevo proveedor</h1>
                        <div class = "card-body">
                            <form>
                                <div className = "form-group">
                                    <label> Codigo proveedor</label>
                                    <input
                                            placeholder = "Ingrese el codigo"
                                            name ="codigo"
                                            className = "form-control"
                                            value = {this.state.codigo} onChange={this.changeCodigoHander}
                                    />
                                </div>
                                <div className = "form-group">
                                    <label> Nombre proveedor</label>
                                    <input
                                            placeholder = "Ingrese el nombre"
                                            name ="nombre"
                                            className = "form-control"
                                            value = {this.state.nombre} onChange={this.changeNombreHandler}
                                    />
                                </div>
                                <div className = "form-group">
                                    <label> Categoria proveedor</label>
                                    <input
                                            placeholder = "Ingrese la categoria"
                                            name ="categoria"
                                            className = "form-control"
                                            value = {this.state.categoria} onChange={this.changeCategoriaHandler}
                                    />
                                </div>
                                <div className = "form-group">
                                    <label> Retencion proveedor</label>
                                    <input
                                            placeholder = "Ingrese la retencion"
                                            name ="retencion"
                                            className = "form-control"
                                            value = {this.state.retencion} onChange={this.changeRetencionHandler}
                                    />
                                </div>

                                <div class = "box-footer">
                                    <button className = "btn btn-primary" onClick={this.saveProveedor}>
                                        Subir
                                    </button>

                                </div>
                            </form>

                        </div>
                    </div>
                </div>
                </div>
                </Styles>
            </div>
            
        )
    }
}

export default NewProveedorComponent;

const Styles = styled.div`

.header{
    background-color: #1b3039;
    display: flex;
    justify-content: flex-end;
    align-items: center;
    height: 85px;
    padding: 5px 10%;
  }
  .header .logo{
    margin-right: auto;
    color: white;
    font-family: 'Pacifico',serif;
  }
  .header .btn button{
    margin-left: 20px;
    font-weight: 700;
    color: #1b3039;
    padding: 9px 25px;
    background: #eceff1;
    border: none;
    border-radius: 50px;
    cursor: pointer;
    transition: all 0.3s ease 0s;
  }
  .header .btn button:hover{
    background-color: #e2f1f8;
    color: #ffbc0e;
    transform: scale(1.1);
  }
  .header .btn-2 button {
    margin-left: 20px;
    font-weight: 700;
    color: #1b3039;
    padding: 9px 25px;
    background: #eceff1;
    border: none;
    border-radius: 50px;
    cursor: pointer;
    transition: all 0.3s ease 0s;
  }
  .header .btn-2 button:hover{
    background-color: #e2f1f8;
    color: #ffbc0e;
    transform: scale(1.1);
  }
  `