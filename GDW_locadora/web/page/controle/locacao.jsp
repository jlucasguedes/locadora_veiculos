<%-- 
    Document   : locacao
    Created on : 12/10/2014, 16:20:16
    Author     : lucas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Locadora</title>
        <link rel="stylesheet" type="text/css" href="library/css/style.css" />        
        <link rel="stylesheet" type="text/css" href="library/bootstrap/css/bootstrap.min.css" />
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
        <div id="container">

            <!-- Nav tabs -->
            <ul class="nav nav-tabs" role="tablist">
                <li class="active"><a href="#home" role="tab" data-toggle="tab">1º Passo - Cliente</a></li>
                <li><a href="#profile" role="tab" data-toggle="tab">2º Passo - Veículo</a></li>
                <li><a href="#messages" role="tab" data-toggle="tab">3º Passo - Datas</a></li>
                <li><a href="#settings" role="tab" data-toggle="tab">4º - Finalizando Locação</a></li>
            </ul>

            <!-- Tab panes -->
            <form method="GET" action="#">
                <div class="tab-content">
                    <div class="tab-pane active" id="home">
                        <label for="">Nome do Cliente:</label>
                        <input type="text" name="nome" placeholder="Nome"/>
                    </div>
                    <div class="tab-pane" id="profile">2</div>
                    <div class="tab-pane" id="messages">3</div>
                    <div class="tab-pane" id="settings">4</div>
                </div>
            </form>
        </div>
        <script type="text/javascript" src="library/js/jquery-1.11.1.min.js"></script>
        <script type="text/javascript" src="library/bootstrap/js/bootstrap.min.js"></script>
        <script type="text/javascript" >
             $("input[name=nome]").autocomplete({
                source: function (request, response) {
                    $.ajax({
                        url: 'BuscaCliente',
                        dataType: "json",
                        data: {
                            name_startsWith: request.term,
                            type: 'country'
                        },
                        success: function (data) {
                            response($.map(data, function (item) {
                                return {
                                    label: item,
                                    value: item
                                }
                            }));
                        }
                    });
                },
                autoFocus: true,
                minLength: 0
            });

        </script>
    </body>
</html>
