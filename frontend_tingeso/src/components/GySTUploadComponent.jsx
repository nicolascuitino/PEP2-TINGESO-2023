import React, { Component } from "react";
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import GySTUploadService from "../services/GySTUploadService";
import styled from "styled-components";

class GySTUploadComponent extends Component{
  constructor(props) {
    super(props);
    this.state = {
      file: null,
    };
    this.onFileChange = this.onFileChange.bind(this);
  }

  onFileChange(event) {
    this.setState({ file: event.target.files[0] });
  }
  
  onFileUpload = () => {
    
    const formData = new FormData();
    formData.append("file", this.state.file);
    GySTUploadService.CargarArchivo(formData).then((res) => {
    });
      
  };

  render() {
    return (
      <div className="home">
        <Styles>
        <header class="header">
          <div class="logo">
            <h1>MilkStgo</h1>
          </div>
          <nav>
          </nav>
          <a class="btn" href="/"><button>Volver al menú principal</button></a>
          <a class="btn-2" href="/pagos"><button>Calcular planilla de pagos</button></a>
        </header>
          <div class="f">
            <div class="container">
              <h1><b>Cargar el archivo de grasa y solidos totales</b></h1>
              <Row className="mt-4">
                <Col col="12">
                  <Form.Group className="mb-3" controlId="formFileLg">
                    <Form.Control type="file" size="lg" onChange={this.onFileChange} />
                  </Form.Group>
                  <Button varian="primary" onClick={this.onFileUpload}>
                    Cargar el archivo a la Base de Datos</Button>
                </Col>
              </Row>
            </div>
          </div>
          <br>
          </br>
          <hr>
          </hr>
          <div class="form1">
            <h5><b>Recuerde que debe cargar un archivo Excel de extensión .csv!</b></h5>
          </div>
        </Styles>
      </div>
    );
  }
}

export default GySTUploadComponent;


const Styles = styled.div`
.container{
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  margin: 2%;
}
.f{
  margin-top: 40px;
  border: 3px solid rgb(162, 161, 161);
  padding: 40px;
  padding-top: 10px;
  border-radius: 40px;
  margin-left: 300px;
  margin-right: 300px;
}
@media(max-width: 1200px){
  .f{margin-left: 200px;
    margin-right: 200px;}
  
}
.form1{
  border: 1px solid rgb(82, 82, 173);
  padding: 30px;
  border-radius: 30px;
  margin-left: 300px;
  margin-right: 300px;
}
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