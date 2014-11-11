<%-- 
    Document   : index
    Created on : 04/10/2014, 16:16:24
    Author     : lucas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Locadora</title>
        <link rel="stylesheet" type="text/css" href="library/css/style.css" />        
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
                    </li>
                    <li><a href="#">CONTROLES</a>
                        <ul>
                            <li><a href="Controller?acao=Redirecionamento&page=locacao">Locação de Veículo</a></li>
                        </ul>
                    </li>
                </ul>
            </nav>
        </div>
    </body>
</html>
