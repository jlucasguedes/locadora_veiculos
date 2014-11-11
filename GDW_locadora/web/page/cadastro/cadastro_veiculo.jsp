<%-- 
    Document   : newjsp
    Created on : 03/11/2014, 20:24:40
    Author     : lucas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="marca" scope="request" class="gdw.locadora.model.Marca" />
<jsp:useBean id="itemConfortoSeguranca" scope="request" class="gdw.locadora.model.ItemConfortoSeguranca" />
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
            #content-main { padding: 10px 0 10px 0; }
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
                    <a class="navbar-brand" href="${pageContext.request.contextPath}">Sistema Locadora</a>
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
        <br />
        <br />
        <br />
        <div class="container">
            <div class="row" id="content-main">
                <div class="col-md-12">
                    <h2 class="col-sm-offset-2">Cadastrar Veículo</h2>
                    <form class="form-horizontal" action="Controller" method="POST">
                        <input type="hidden" name="acao" value="CadastrarVeiculo" />                        
                        <div class="form-group">
                            <label for="inputPlaca" class="col-sm-2 control-label">Placa: </label>
                            <div class="col-sm-6">
                                <input type="text" id="inputPlaca" class="form-control" name="placa" placeholder="Placa" />
                            </div> 
                        </div>
                        <div class="form-group">
                            <label for="inputRenavam" class="col-sm-2 control-label">Renavam: </label>
                            <div class="col-sm-6">
                                <input type="text" id="inputRenavam" class="form-control" name="renavam" placeholder="Renavam"/>
                            </div> 
                        </div>
                        <div class="form-group">
                            <label for="inputChassi" class="col-sm-2 control-label">Chassi: </label>
                            <div class="col-sm-6">
                                <input type="text" id="inputChassi" class="form-control" name="chassi" placeholder="Chassi"/>
                            </div> 
                        </div>
                        <div class="form-group">
                            <label for="selectMarca" class="col-sm-2 control-label">Marca: </label>
                            <div class="col-sm-6">
                                <select name="marca" class="form-control" id="selectMarca">
                                    <option value="0" disabled="disabled"> ---- SELECIONE A MARCA ---- </option>
                                    <c:forEach items="${marcas}" var="marca">
                                        <option value="${marca.id}">${marca.nomeMarca}</option>
                                    </c:forEach>
                                </select>
                            </div> 
                        </div>
                        <div class="form-group">
                            <label for="selectModelo" class="col-sm-2 control-label">Modelo: </label>
                            <div class="col-sm-6">
                                <select name="modelo" id="selectModelo" class="form-control">
                                    <option value="0" disabled="disabled"> ---- SELECIONE O MODELO ---- </option>
                                </select>
                            </div> 
                        </div>
                        <div class="form-group">
                            <label for="selectMotorizacao" class="col-sm-2 control-label">Motorização: </label>
                            <div class="col-sm-6">
                                <select name="motorizacao" id="selectModelo" class="form-control" id="selectMotorizacao">
                                    <option value="0" disabled="disabled"> ---- SELECIONE O MOTORIZAÇÃO ---- </option>
                                </select>
                            </div> 
                        </div>                        
                        <div class="form-group">
                            <label for="inputItensConfortoSeguranca" class="col-sm-2 control-label">Itens de Conforto e Segurança: </label>
                            <div class="col-sm-6">
                                <c:forEach items="${icses}" var="itemConfortoSeguranca">
                                    <div class="input-group">
                                        <input class="checkbox-inline" name="ics" type="checkbox" value="${itemConfortoSeguranca.id}" /> ${itemConfortoSeguranca.descricao}                                     
                                    </div>
                                </c:forEach>
                            </div> 
                        </div>
                        <div class="form-group">                            
                            <div class="col-sm-offset-2 col-sm-6">
                                <button type="submit" class="btn btn-primary">Cadastrar</button>
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
                $("select[name=marca]").val(0);
                $("select[name=modelo]").val(0);
                $("select[name=motorizacao]").val(0);
                // Evento change no campo tipo  
                $("select[name=marca]").change(
                        function () {
                            // Exibimos no campo marca antes de concluirmos
                            $("select[name=modelo]").html('<option value=""> ---- CARREGANDO... ---- </option>');
                            // Exibimos no campo marca antes de selecionamos a marca, serve também em caso
                            // do usuario ja ter selecionado o tipo e resolveu trocar, com isso limpamos a
                            // seleção antiga caso tenha feito.
                            $("select[name=motorizacao]").html('<option value=""> ---- AGUARDANDO O MODELO... ---- </option>');
                            // Passando tipo por parametro para a pagina ajax-marca.php
                            $.ajax({
                                url: "Controller?acao=AjaxModelo",
                                type: 'POST',
                                data: {marca_id: $("select[name=marca]").val()},
                                datatype: 'json',
                                success: function (data) {
                                    var corpo = '<option value="0"> ---- SELECIONE O MODELO ---- </option>';
                                    for (var i = 0, length = data.length; i < length; i++) {
                                        var modelo = data[i];
                                        corpo += "<option value=" + modelo.id + ">" + modelo.nome_modelo + "</option>";
                                    }

                                    $("select[name=modelo]").html(corpo);
                                }
                            });
                        }
                );
                // Evento change no campo marca 
                $("select[name=modelo]").change(function () {
                    // Exibimos no campo modelo antes de concluirmos
                    $("select[name=motorizacao]").html('<option value=""> ---- CARREGANDO... ---- </option>');
                    // Passando marca por parametro para a pagina ajax-modelo.php
                    $.ajax({
                        url: "Controller?acao=AjaxMotorizacao",
                        type: 'POST',
                        data: {modelo_id: $("select[name=modelo]").val()},
                        datatype: 'json',
                        success: function (data) {
                            var corpo = '<option value="0"> ---- SELECIONE A MOTORIZAÇÃO ---- </option>';
                            for (var i = 0, length = data.length; i < length; i++) {
                                var motorizacao = data[i];
                                corpo += "<option value=" + motorizacao.id + ">" + motorizacao.motorizacao + "</option>";
                            }

                            $("select[name=motorizacao]").html(corpo);
                        }
                    });

                });

            });
        </script>
    </body>
</html>
