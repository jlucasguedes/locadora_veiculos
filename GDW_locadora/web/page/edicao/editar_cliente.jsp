<%-- 
    Document   : newjsp
    Created on : 03/11/2014, 20:24:40
    Author     : lucas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema Locadora</title>
        <link rel="stylesheet" type="text/css" media="all" href="library/bootstrap/css/bootstrap.min.css" />
        <link rel="stylesheet" type="text/css" media="all" href="library/bootstrap/css/bootstrap-submenu.css" />

        <style type="text/css">
            html, body { height: 100%; }
            section.container { padding-top: 60px; text-align: center; width: 100%; height: 100%; background: #ddd; }
            .container .row:nth-child(1){ padding: 80px 0 10px 0; border-bottom: 2px solid #ccc; }

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
                                        <li><a href="#">1.3.3 - Listar Veículos</a></li>                                        
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
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="col-sm-4">
                        <div class="input-group">
                            <input type="text" id="inputPesquisaCPF" class="form-control" placeholder="CPF" />
                            <span class="input-group-btn">
                                <button class="btn btn-primary" id="pesquisarClientePorCPF" type="button">Pesquisar</button>
                            </span>
                        </div><!-- /input-group -->
                    </div><!-- /.col-sm-6 -->
                </div>
            </div>
            <br />
            <br />
            <br />
            <div class="row" id="form-editar">
                <div class="col-md-12">
                    <h2 class="col-sm-offset-2">Editar Cliente</h2>
                    <form class="form-horizontal" action="Controller" method="POST">
                        <input type="hidden" name="acao" value="EditarCliente" />
                        <div class="form-group">
                            <label for="inputID" class="col-sm-2 control-label">ID: </label>
                            <div class="col-sm-6">
                                <input type="text" readonly=" "id="inputID" class="form-control" name="id" placeholder="ID" />
                            </div> 
                        </div>
                        <div class="form-group">
                            <label for="inputNome" class="col-sm-2 control-label">Nome: </label>
                            <div class="col-sm-6">
                                <input type="text" id="inputNome" class="form-control" name="nome" placeholder="Nome" />
                            </div> 
                        </div>
                        <div class="form-group">
                            <label for="inputDataNascimento" class="col-sm-2 control-label">Data de Nascimento: </label>
                            <div class="col-sm-6">
                                <input type="text" id="inputDataNascimento" class="form-control" name="data_nascimento" placeholder="Data de nascimento"/>
                            </div> 
                        </div>
                        <div class="form-group">
                            <label for="inputCPF" class="col-sm-2 control-label">CPF: </label>
                            <div class="col-sm-6">
                                <input type="text" id="inputCPF" class="form-control" name="cpf" placeholder="CPF"/>
                            </div> 
                        </div>
                        <div class="form-group">
                            <label for="inputRG" class="col-sm-2 control-label">RG: </label>
                            <div class="col-sm-6">
                                <input type="text" id="inputRG" class="form-control" name="rg" placeholder="RG"/>
                            </div> 
                        </div>
                        <div class="form-group">
                            <label for="inputEndereco" class="col-sm-2 control-label">Endereço: </label>
                            <div class="col-sm-6">
                                <input type="text" id="inputEndereco" class="form-control" name="endereco" placeholder="Endereço"/>
                            </div> 
                        </div>
                        <div class="form-group">
                            <label for="inputTelefone" class="col-sm-2 control-label">Telefone: </label>
                            <div class="col-sm-6">
                                <input type="text" id="inputTelefone" class="form-control" name="telefone" placeholder="Telefone"/>
                            </div> 
                        </div>
                        <div class="form-group">
                            <label for="inputCNH" class="col-sm-2 control-label">CNH: </label>
                            <div class="col-sm-6">
                                <input type="text" id="inputCNH" class="form-control" name="cnh" placeholder="CNH"/>
                            </div> 
                        </div>
                        <div class="form-group">                            
                            <div class="col-sm-offset-2 col-sm-6">
                                <button type="submit" class="btn btn-primary">Editar</button>
                            </div> 
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <script type="text/javascript" language="javascript" src="library/js/jquery-1.11.1.min.js"></script>
        <script type="text/javascript" language="javascript" src="library/bootstrap/js/bootstrap.min.js"></script>
        <script type="text/javascript" language="javascript" src="library/js/jquery.maskedinput.min.js"></script>  
        <script type="text/javascript">
            $(document).ready(function () {
                $("#inputDataNascimento").mask("99/99/9999", {placeholder: "dd/mm/aaaa"});
                $("#inputCPF").mask("999.999.999-99", {placeholder: " "});
                $("#inputPesquisaCPF").mask("999.999.999-99", {placeholder: " "});
                $("#inputTelefone").mask("(99) 9999-9999", {placeholder: " "});

                $("#pesquisarClientePorCPF").click(function () {
                    if ($("#inputPesquisaCPF").val() === "") {
                        $("#aviso").remove();
                        $("#form-editar").prepend('<div id="aviso" class="alert alert-danger" role="alert">Preencha o campo CPF.</div>');
                    }
                    else {
                        $("#aviso").remove();
                        $("#inputID").val("");
                        $("#inputNome").val("");
                        $("#inputDataNascimento").val("");
                        $("#inputCPF").val("");
                        $("#inputRG").val("");
                        $("#inputEndereco").val("");
                        $("#inputTelefone").val("");
                        $("#inputCNH").val("");

                        $.ajax({
                            url: "Controller?acao=AjaxBuscarClientePorCPF",
                            type: 'POST',
                            data: {cpf: $("#inputPesquisaCPF").val()},
                            datatype: 'json',
                            success: function (cliente) {
                                if (Object.keys(cliente).length > 1) {
                                    $("#inputID").val(cliente.id);
                                    $("#inputNome").val(cliente.nome);
                                    $("#inputDataNascimento").val(cliente.data_nascimento);
                                    $("#inputCPF").val(cliente.cpf);
                                    $("#inputRG").val(cliente.rg);
                                    $("#inputEndereco").val(cliente.endereco);
                                    $("#inputTelefone").val(cliente.telefone);
                                    $("#inputCNH").val(cliente.cnh);
                                } else {
                                    $("#aviso").remove();
                                    $("#form-editar").prepend('<div id="aviso" class="alert alert-danger" role="alert">' + cliente.erro + '</div>');
                                }
                            }
                        });
                    }
                });

            });
        </script>
    </body>
</html>
