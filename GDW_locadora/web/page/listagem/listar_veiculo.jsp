<%-- 
    Document   : newjsp
    Created on : 03/11/2014, 20:24:40
    Author     : lucas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="veiculo" scope="request" class="gdw.locadora.model.Veiculo" />
<jsp:useBean id="itemConfortoSeguranca" scope="request" class="gdw.locadora.model.ItemConfortoSeguranca" />
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
            #perfil-completo tbody tr td.negrito:nth-child(1) { font-weight: bold; }
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
                                <th>PLACA</th>
                                <th>RENAVAM</th>
                                <th>CHASSI</th>
                                <th>MARCA</th>
                                <th>MODELO</th>
                                <th>OPÇÕES</th>
                            </tr>
                        </thead>
                        <tfoot>
                            <tr>
                                <th>ID</th>
                                <th>PLACA</th>
                                <th>RENAVAM</th>
                                <th>CHASSI</th>
                                <th>MARCA</th>
                                <th>MODELO</th>
                                <th>OPÇÕES</th>
                            </tr>
                        </tfoot>
                        <tbody>
                            <c:forEach items="${veiculos}" var="veiculo">
                                <tr>
                                    <td>${veiculo.id}</td>
                                    <td>${veiculo.placa}</td>
                                    <td>${veiculo.renavam}</td>
                                    <td>${veiculo.chassi}</td>
                                    <td>${veiculo.marca.nomeMarca}</td>
                                    <td>${veiculo.modelo.nomeModelo}</td>
                                    <td>
                                        <div class="btn-group">
                                            <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                                                <i class="glyphicon glyphicon-plus"></i> <span class="caret"></span>
                                            </button>
                                            <ul class="dropdown-menu" style="width: 40px">
                                                <li>                                                   
                                                    <a href="#" data-toggle="modal" data-target="#modalClienteID${veiculo.id}" ><i class="glyphicon glyphicon-user"></i> Perfil Completo</a>
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
                    <c:forEach items="${veiculos}" var="veiculo">
                        <!-- Modal -->
                        <div class="modal fade" id="modalClienteID${veiculo.id}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Fechar</span></button>
                                        <h4 class="modal-title" id="myModalLabel">Veículo ID: ${veiculo.id}</h4>
                                    </div>
                                    <div class="modal-body">
                                        <table class="table table-condensed" id="perfil-completo">
                                            <tbody>
                                                <tr>
                                                    <td class="negrito">ID: </td>
                                                    <td>${veiculo.id}</td>
                                                </tr>
                                                <tr>
                                                    <td class="negrito">Placa: </td>
                                                    <td>${veiculo.placa}</td>
                                                </tr>
                                                <tr>
                                                    <td class="negrito">Renavam: </td>                                                    
                                                    <td>${veiculo.renavam}</td>
                                                </tr>
                                                <tr>
                                                    <td class="negrito">Chassi: </td>
                                                    <td>${veiculo.chassi}</td>
                                                </tr>
                                                <tr>
                                                    <td class="negrito">Marca: </td>
                                                    <td>${veiculo.marca.nomeMarca}</td>
                                                </tr>
                                                <tr>
                                                    <td class="negrito">Modelo: </td>
                                                    <td>${veiculo.modelo.nomeModelo}</td>
                                                </tr>
                                                <tr>
                                                    <td class="negrito">Motorizacao: </td>
                                                    <td>${veiculo.motorizacao.motorizacao}</td>
                                                </tr>
                                                <tr>
                                                    <td rowspan="${veiculo.ics.size()+1}" class="negrito">Itens Conforto e Segurança</td>                                                    
                                                </tr>
                                                <c:forEach items="${veiculo.ics}" var="itemConfortoSeguranca">
                                                    <tr>
                                                        <td class="sem-negrito">${itemConfortoSeguranca.descricao}</td>
                                                    </tr>
                                                </c:forEach>

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
