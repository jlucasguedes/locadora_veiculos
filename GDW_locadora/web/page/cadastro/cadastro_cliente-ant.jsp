<%-- 
    Document   : cadastro_cliente
    Created on : 04/10/2014, 22:20:39
    Author     : lucas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                <form class="form_edit" method="GET" action="Controller">                    
                    <input type="hidden" name="acao" value="CadastrarCliente" />
                    <table cellpadding="10px">
                        <thead>
                            <tr>
                                <th colspan="2">Cadastrar novo Cliente</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td><label for="">Nome:</label></td>
                                <td><input type="text" name="nome" placeholder="Nome"/></td>
                            </tr>
                            <tr>
                                <td><label for="">Data de Nascimento:</label></td>
                                <td><input type="text" name="data_nascimento" placeholder="Data de Nascimento"/></td>
                            </tr>
                            <tr>
                                <td><label for="">CPF:</label></td>
                                <td><input type="text" name="cpf" placeholder="CPF"/></td>
                            </tr>
                            <tr>
                                <td><label for="">RG:</label></td>
                                <td><input type="text" name="rg" placeholder="RG"/></td>
                            </tr>
                            <tr>
                                <td><label for="">Endereço:</label></td>
                                <td><input type="text" name="endereco" placeholder="Logradouro, Bairro, Número"/></td>
                            </tr>
                            <tr>
                                <td><label for="">Telefone:</label></td>
                                <td><input type="text" name="telefone" placeholder="Telefone"/></td>
                            </tr>
                            <tr>
                                <td><label for="">CNH:</label></td>
                                <td><input type="text" name="cnh" placeholder="CNH  "/></td>
                            </tr>
                            <tr>
                                <td colspan="2"><button type="submit">Cadastrar</button></td>
                            </tr>
                        </tbody>
                    </table>
                </form>
            </div>
        </div>
    </body>
</html>
