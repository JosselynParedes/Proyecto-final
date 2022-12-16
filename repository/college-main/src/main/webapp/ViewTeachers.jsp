<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profesores</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"/>
        <%@include file="./libs/Bootstrap.html"%>
        <%@include file="./libs/DialogMessages.html" %>
        <link href="Styles/Styles.css" rel="stylesheet" type="text/css"/>
        <script src="js/Methods.js"></script>
    </head>
    <body id="background">
        <div>
            <%@include file="./libs/Navs.html"%>
        </div>
        <div>
            <main>
                <br>
                <br>
                <header>
                    <h1 align="center" style="font-family: Roboto; color: #141c27" class="animate__animated animate__bounce">
                        Control para Docentes</h1>
                </header>
                <br>
                <br>
                <center>
                    <section>
                        <button class="button"
                                data-bs-toggle="modal" 
                                data-bs-target="#insertTeachers">
                            <span class="button-content">Insertar nuevo
                            Docente </span>
                        </button>
                    </section>
                </center>
            </main>
            <br>
            <div class="container" align="center" style="font-family: Roboto">
                <table
                    id="table"
                    data-locale="es-ES"
                    data-url="/college/teachers"
                    data-toggle="table"
                    data-filter-control="true"
                    data-height = "500"
                    data-show-columns="true"
                    data-search="true"
                    data-show-export="true">
                    <thead>
                        <tr>
                            <th data-field="nui"><center>NUI</center></th>
                            <th data-field="firstName"><center>Nombre</center></th>
                            <th data-field="lastName"><center>Apellido</center></th>
                            <th data-field="mailAddress"><center>Correo</center></th>
                            <th data-field="operate" data-formatter="operations" 
                                data-width="222"><center>Acción</center></th>
                        </tr>
                    </thead>
                </table>  
            </div>
        </div>
        <footer>
            <div>
                <div class="container">
                    <div class="row">
                        <div class="col-md-6">
                            <label>INSTITUTO TÉCNICO SUPERIOR QUITO METROPOLITANO</label>
                        </div>
                        <div class="col-md-6" style="text-align: left">
                            <label>
                                Desarrollado por:   Joao Jaramillo, José Luis Frías y Daniel Parrales
                            </label>
                        </div>
                    </div>
                </div>
            </div>
        </footer>
        <%@include file="./libs/ModalsTeachers.html"%>
    </body>
</html>