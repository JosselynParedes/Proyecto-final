<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"/>
    <%@include file="./libs/Bootstrap.html" %>
    <%@include file="./libs/DialogMessages.html"%>
    <link href="Styles/Styles.css" rel="stylesheet" type="text/css"/>
    <script src="js/procedures.js"></script>
    <title>Procedimientos Almacenados</title>
</head>
<body id="background">
<div>
    <%@include file="./libs/Navs.html" %>
</div>
<br>
<br>
<br>
<div class="container text-center">
    <h1 class="mb-4 animate__animated animate__bounce">Validar tipo de cuenta de correo</h1>
    <div class="row justify-content-center">
        <div class="col-4">
            <form action="procedures/correoEst" id="correoEst" onsubmit="callProcedure(event, this)">

                <div class="form-floating mb-3">
                    <input type="text" class="form-control"
                           name="nui"
                           id="insertNui"
                           placeholder="Ingrese el NUI"/>
                    <label for="insertNui">Ingrese el NUI</label>
                </div>
            </form>
        </div>
        <div class="col-2">
            <button class="button" form="correoEst">
                <span class="button-content" 
                      style="color: white">
                    Validar
                </span>
            </button>
        </div>
    </div>
    <div>
        <p id="response"></p>
    </div>
</div>
</body>
</html>
