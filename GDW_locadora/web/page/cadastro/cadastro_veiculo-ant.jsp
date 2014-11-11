<%-- 
    Document   : cadastro_veiculo
    Created on : 05/10/2014, 19:54:09
    Author     : Lucas
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="marca" scope="request" class="gdw.locadora.model.Marca" />
<jsp:useBean id="itemConfortoSeguranca" scope="request" class="gdw.locadora.model.ItemConfortoSeguranca" />
<!DOCTYPE html>
<html>
    <head>        
        <title>Locadora</title>
        <link rel="stylesheet" type="text/css" href="library/css/style.css" />        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <div id="main">
            <nav>
                <ul class="menu">
                    <li><a href="${pageContext.request.contextPath}">ÍNICIO</a></li>
                    <li class="dropdown">
                        <a href="">CADASTRO</a>
                        <ul class="submenu">
                            <li><a href="Controller?acao=Redirecionamento&page=cadastro_cliente">Cadastro de Cliente</a></li>
                            <li><a href="Controller?acao=Redirecionamento&page=cadastro_funcionario">Cadastro de Funcionário</a></li>
                            <li><a href="Controller?acao=Redirecionamento&page=cadastro_veiculo">Cadastro de Veículo</a></li>
                        </ul>
                    <li><a href="#">CONTROLES</a>
                        <ul>
                            <li><a href="Controller?acao=Redirecionamento&page=locacao">Locação de Veículo</a></li>
                        </ul>
                    </li>
                    </li>
                </ul>
            </nav>
            <div id="content">
                <form class="form_edit" method="POST" action="Controller">                    
                    <input type="hidden" name="acao" value="CadastrarVeiculo" />
                    <table cellpadding="10px">
                        <thead>
                            <tr>
                                <th colspan="2">Cadastrar novo Veículo</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td><label for="">Placa:</label></td>
                                <td><input type="text" name="placa" placeholder="Placa"/></td>
                            </tr>
                            <tr>
                                <td><label for="">Renavam:</label></td>
                                <td><input type="text" name="renavam" placeholder="Renavam"/></td>
                            </tr>
                            <tr>
                                <td><label for="">Chassi:</label></td>
                                <td><input type="text" name="chassi" placeholder="Chassi"/></td>
                            </tr>
                            <tr>
                                <td><label for="">Marca:</label></td>
                                <td>
                                    <select name="marca">
                                        <option value="0" disabled="disabled"> ---- SELECIONE A MARCA ---- </option>
                                        <c:forEach items="${marcas}" var="marca">
                                            <option value="${marca.id}">${marca.nomeMarca}</option>
                                        </c:forEach>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td><label for="">Modelo:</label></td>
                                <td>
                                    <select name="modelo">
                                        <option value="0" disabled="disabled"> ---- SELECIONE O MODELO ---- </option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td><label for="">Motorização:</label></td>
                                <td>
                                    <select name="motorizacao">
                                        <option value="0" disabled="disabled"> ---- SELECIONE O MOTORIZAÇÃO ---- </option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td rowspan="6"><label>Itens Conforto e Segurança</label></td>                                
                            </tr>
                            <c:forEach items="${icses}" var="itemConfortoSeguranca">
                                <tr>
                                    <td><input type="checkbox" name="ics" value="${itemConfortoSeguranca.id}" />${itemConfortoSeguranca.descricao}</td>
                                </tr>
                            </c:forEach>
                            <tr>
                                <td colspan="2"><button type="submit">Cadastrar</button></td>
                            </tr>
                        </tbody>
                    </table>
                </form>
            </div>
        </div>
        <div id="divCorpoHtml">       
        </div> 
        <script type="text/javascript" src="library/js/jquery-1.11.1.min.js"></script>
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


