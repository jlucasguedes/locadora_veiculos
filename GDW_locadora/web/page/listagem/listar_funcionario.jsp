<%-- 
    Document   : newjsp
    Created on : 03/11/2014, 20:24:40
    Author     : lucas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="funcionario" scope="request" class="gdw.locadora.model.Funcionario" />
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema Locadora</title>
        <link rel="stylesheet" type="text/css" media="all" href="library/bootstrap/css/bootstrap.min.css" />
        <link rel="stylesheet" type="text/css" media="all" href="library/bootstrap/css/bootstrap-submenu.css" />
        <link rel="stylesheet" type="text/css" media="all" href="library/datatable/css/jquery.dataTables.min.css" />
        <link rel="stylesheet" type="text/css" media="all" href="library/datatable/css/dataTables.bootstrap.css" />
        <style type="text/css">
            html, body { height: 100%; }
            section.container { padding-top: 60px; text-align: center; width: 100%; height: 100%; background: #ddd; }
            #content-main { padding: 120px 0 10px 0; }
            #perfil-completo tbody tr td:nth-child(1) { font-weight: bold; }
            #perfil-completo td { border: none; }
            

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
            <div class="row" id="content-main">
                <div class="col-md-12">
                    <table class="table table-hover table-striped" cellspacing="0" width="100%" id="table-cliente">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>NOME</th>
                                <th>CPF</th>
                                <th>TELEFONE</th>
                                <th>OPÇOES</th>
                            </tr>
                        </thead>
                        <tfoot>
                            <tr>
                                <th>ID</th>
                                <th>NOME</th>
                                <th>CPF</th>
                                <th>TELEFONE</th>
                                <th>OPÇOES</th>
                            </tr>
                        </tfoot>
                        <tbody>
                            <c:forEach items="${funcionarios}" var="funcionario">
                                <tr>
                                    <td>${funcionario.id}</td>
                                    <td>${funcionario.nome}</td>
                                    <td>${funcionario.cpf}</td>
                                    <td>${funcionario.telefone}</td>
                                    <td>
                                        <div class="btn-group">
                                            <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                                                <i class="glyphicon glyphicon-plus"></i> <span class="caret"></span>
                                            </button>
                                            <ul class="dropdown-menu" style="width: 40px">
                                                <li>                                                   
                                                    <a href="#" data-toggle="modal" data-target="#modalClienteID${funcionario.id}" ><i class="glyphicon glyphicon-user"></i> Perfil Completo</a>
                                                </li>
                                                <li>
                                                </li>
                                            </ul>
                                        </div>
                                    </td>
                                </tr>                            
                            </c:forEach>
                        </tbody>
                    </table>
                    <c:forEach items="${funcionarios}" var="funcionario">
                        <!-- Modal -->
                        <div class="modal fade" id="modalClienteID${funcionario.id}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Fechar</span></button>
                                        <h4 class="modal-title" id="myModalLabel">${funcionario.nome}</h4>
                                    </div>
                                    <div class="modal-body">
                                        <table class="table table-condensed" id="perfil-completo">
                                            <tbody>
                                                <tr>
                                                    <td>Nome: </td>
                                                    <td>${funcionario.nome}</td>
                                                </tr>
                                                <tr>
                                                    <td>Data de nascimento: </td>                                                    
                                                    <td><fmt:formatDate pattern="dd/MM/yyyy" value="${funcionario.dataDeNascimento}"/></td>
                                                </tr>
                                                <tr>
                                                    <td>CPF: </td>
                                                    <td>${funcionario.cpf}</td>
                                                </tr>
                                                <tr>
                                                    <td>RG: </td>
                                                    <td>${funcionario.rg}</td>
                                                </tr>
                                                <tr>
                                                    <td>Endereço: </td>
                                                    <td>${funcionario.endereco}</td>
                                                </tr>
                                                <tr>
                                                    <td>Telefone: </td>
                                                    <td>${funcionario.telefone}</td>
                                                </tr>
                                                <tr>
                                                    <td>Data de Admissão: </td>
                                                    <td><fmt:formatDate pattern="dd/MM/yyyy" value="${funcionario.dataDeAdmissao}"/></td>
                                                </tr>
                                                <tr>
                                                    <td>Salário: </td>
                                                    <td>${funcionario.salario}</td>
                                                </tr>
                                            </tbody>
                                        </table>                                        
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>

                </div>
                <script type="text/javascript" language="javascript" src="library/js/jquery-1.11.1.min.js"></script>
                <script type="text/javascript" language="javascript" src="library/bootstrap/js/bootstrap.min.js"></script>
                <script type="text/javascript" language="javascript" src="library/js/jquery.maskedinput.min.js"></script>  
                <script type="text/javascript" language="javascript" src="library/datatable/js/jquery.dataTables.min.js"></script>  
                <script type="text/javascript" language="javascript" src="library/datatable/js/dataTables.bootstrap.js"></script>  
                <script type="text/javascript">
                    $(document).ready(function () {
                        $("#inputDataNascimento").mask("99/99/9999", {placeholder: "dd/mm/aaaa"});
                        $("#inputCPF").mask("999.999.999-99", {placeholder: " "});
                        $("#inputPesquisaCPF").mask("999.999.999-99", {placeholder: " "});
                        $("#inputTelefone").mask("(99) 9999-9999", {placeholder: " "});

                        $("#table-cliente").dataTable({
                            "pagingType": "full_numbers",
                            "language": {
                                "sProcessing": "Processando...",
                                "sLengthMenu": "Mostrar _MENU_ registros",
                                "sZeroRecords": "Nenhum registro foi encontrado",
                                "sEmptyTable": "Nenhum registro existente",
                                "sInfo": "Mostrando _START_ a _END_ de _TOTAL_ registros",
                                "sInfoEmpty": "Mostrando _START_ a _END_ de _TOTAL_ registros",
                                "sInfoFiltered": "(filtrado de um total de _MAX_ registros)",
                                "sInfoPostFix": "",
                                "sSearch": "Buscar:",
                                "sUrl": "",
                                "sInfoThousands": ",",
                                "sLoadingRecords": "Carregando...",
                                "oPaginate": {
                                    "sFirst": "Primeiro",
                                    "sLast": "Ultimo",
                                    "sNext": "Proximo",
                                    "sPrevious": "Anterior"
                                },
                                "oAria": {
                                    "sSortAscending": ": Activar para ordenar la columna de manera ascendente",
                                    "sSortDescending": ": Activar para ordenar la columna de manera descendente"
                                }
                            }
                        });

                        $("#pesquisarClientePorCPF").click(function () {

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

                                    $("#inputID").val(cliente.id);
                                    $("#inputNome").val(cliente.nome);
                                    $("#inputDataNascimento").val(cliente.data_nascimento);
                                    $("#inputCPF").val(cliente.cpf);
                                    $("#inputRG").val(cliente.rg);
                                    $("#inputEndereco").val(cliente.endereco);
                                    $("#inputTelefone").val(cliente.telefone);
                                    $("#inputCNH").val(cliente.cnh);
                                }
                            });
                            /*event.preventDefault();*/
                        });

                    });
                </script>
                </body>
                </html>
