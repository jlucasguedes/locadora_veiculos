<%-- 
    Document   : newjsp
    Created on : 03/11/2014, 20:24:40
    Author     : lucas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema Locadora</title>
        <link rel="stylesheet" type="text/css" media="all" href="library/bootstrap/css/bootstrap.min.css" />
        <link rel="stylesheet" type="text/css" media="all" href="library/bootstrap/css/bootstrap-submenu.css" />
        <script type="text/javascript" language="javascript" src="library/js/jquery-1.11.1.min.js"></script>
        <script type="text/javascript" language="javascript" src="library/bootstrap/js/bootstrap.min.js"></script>
        <style type="text/css">
            html, body { height: 100%; }
            section.container { padding-top: 60px; text-align: center; width: 100%; height: 100%; background: #ddd; }
        </style>
    </head>
    <body>        
        <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
            <div class="container-fluid">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">Sistema Locadora</a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="${pageContext.request.contextPath}">INICIO</a></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">1 - CADASTRO <span class="caret"></span></a>
                            <ul class="dropdown-menu" role="menu">
                                <li class="dropdown-submenu">
                                    <a href="#" data-toogle="dropdown" class="dropdown-toggle">1.1 - Cadastro de Cliente</a>
                                    <ul class="dropdown-menu">
                                        <li><a href="Controller?acao=Redirecionamento&page=cadastro_cliente">1.1.1 - Cadastrar Cliente</a></li>
                                        <li class="divider"></li>
                                        <li><a href="Controller?acao=Redirecionamento&page=editar_cliente">1.1.2 - Editar Cliente</a></li>
                                        <li class="divider"></li>
                                        <li><a href="Controller?acao=Redirecionamento&page=listar_cliente">1.1.3 - Listar Clientes</a></li>                                        
                                    </ul>
                                </li>
                                <li class="divider"></li>
                                <li class="dropdown-submenu">
                                    <a href="#" data-toogle="dropdown" class="dropdown-toggle">1.2 - Cadastro de Funcionário</a>
                                    <ul class="dropdown-menu">
                                        <li><a href="Controller?acao=Redirecionamento&page=cadastro_funcionario">1.2.1 - Cadastrar Funcionário</a></li>
                                        <li class="divider"></li>
                                        <li><a href="Controller?acao=Redirecionamento&page=editar_funcionario">1.2.2 - Editar Funcionário</a></li>
                                        <li class="divider"></li>
                                        <li><a href="Controller?acao=Redirecionamento&page=listar_funcionario">1.2.3 - Listar Funcionários</a></li>                                        
                                    </ul>
                                </li>
                                <li class="divider"></li>
                                <li class="dropdown-submenu">
                                    <a href="#" data-toogle="dropdown" class="dropdown-toggle">1.3 - Cadastro de Veículo</a>
                                    <ul class="dropdown-menu">
                                        <li><a href="Controller?acao=Redirecionamento&page=cadastro_veiculo">1.3.1 - Cadastrar Veículo</a></li>
                                        <li class="divider"></li>
                                        <li><a href="#">1.3.2 - Editar Veículo</a></li>
                                        <li class="divider"></li>
                                        <li><a href="Controller?acao=Redirecionamento&page=listar_veiculo">1.3.3 - Listar Veículos</a></li>                                        
                                    </ul>
                                </li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">3 - CONSULTA <span class="caret"></span></a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="#">3.1 - Consultar Veículo</a></li>
                                <li class="divider"></li>
                                <li><a href="#">3.2 - Listar Locações</a></li>
                            </ul>
                        </li>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>
        <section class="container">
            <h1>SISTEMA LOCADORA TRABALHO JDBC 201401</h1>            
        </section>
    </body>
</html>
