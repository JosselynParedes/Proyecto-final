<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="./libs/Bootstrap.html" %>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"/>
    <link href="Styles/Styles.css" rel="stylesheet" type="text/css"/>
    <title>Login</title>
</head>
<body id="background">
<header>
    <h1 class="text-center" style="padding: 6rem 0">
        <img src="img/Logo_dark.png" alt="logo ITSQMET" style="width:300px; height:150px"/>
        <br>
        Bienvenido a COLLEGE</h1>
</header>
<div class="container-fluid">
    <section class="w-100 p-4 d-flex justify-content-center pb-4">
        <div style="width: 26rem" id="loginAndRegister">
            <!-- Pills navs -->
            <nav class="nav nav-pills nav-justified">
                <button
                        class="nav-link active primary"
                        id="pills-home-tab"
                        data-bs-toggle="pill"
                        data-bs-target="#pills-login"
                        type="button"
                        role="tab"
                        aria-controls="pills-login"
                        aria-selected="true"
                >
                    Iniciar Sesión
                </button>
                <button
                        class="nav-link"
                        id="pills-profile-tab"
                        data-bs-toggle="pill"
                        data-bs-target="#pills-register"
                        type="button"
                        role="tab"
                        aria-controls="pills-register"
                        aria-selected="false"
                >
                    Registrase
                </button>
            </nav>
            <!-- Pills navs -->

            <!-- Pills content -->
            <div class="tab-content">
                <div
                        class="tab-pane fade active show"
                        id="pills-login"
                        role="tabpanel"
                        aria-labelledby="tab-login"
                >
                    <form method="get" action="login">
                        <p class="text-center mt-3">Por favor, ingrese a su cuenta</p>

                        <!-- Email input -->
                        <div class="form-floating mb-3">
                            <input
                                    type="email"
                                    class="form-control"
                                    name="mail"
                                    id="loginEmail"
                                    placeholder="name@example.com"
                            />
                            <label for="loginEmail">Correo Electrónico</label>
                        </div>

                        <!-- Password input -->
                        <div class="form-floating mb-3">
                            <input
                                    type="password"
                                    class="form-control"
                                    name="pass"
                                    id="loginPassword"
                                    placeholder="Password"
                            />
                            <label for="loginPassword">Contraseña</label>
                        </div>

                        <!-- Submit button -->
                        <button type="submit" class="btn btn-primary btn-block mb-3">
                            Ingresar
                        </button>
                    </form>
                </div>
                <div
                        class="tab-pane fade"
                        id="pills-register"
                        role="tabpanel"
                        aria-labelledby="tab-register"
                >
                    <form action="login" method="post">
                        <p class="text-center">Por favor, ingrese a sus datos</p>
                                                <!-- Email input -->
                        <div class="form-floating mb-3">
                            <input
                                    type="email"
                                    class="form-control"
                                    id="registerEmail"
                                    placeholder="name@example.com"
                                    name="mail"
                            />
                            <label for="registerEmail">Email address</label>
                        </div>

                        <!-- Password input -->
                        <div class="form-floating mb-3">
                            <input
                                    type="password"
                                    class="form-control"
                                    id="registerPassword"
                                    placeholder="Password"
                                    name="pass"
                            />
                            <label for="registerPassword">Password</label>
                        </div>
                        <!-- Submit button -->
                        <button type="submit" class="btn btn-primary btn-block mb-3">
                            Registrarse
                        </button>
                    </form>
                </div>
            </div>
            <!-- Pills content -->
        </div>
    </section>
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
                        Desarrollado por: Joao Jaramillo, José Luis Frías y Daniel Parrales
                    </label>
                </div>
            </div>
        </div>
    </div>
</footer>
</body>
</html>
