<%-- 
    Document   : BuscaClienteTeste
    Created on : 17/10/2014, 17:41:26
    Author     : lucas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form>
            <input type="text" name="nome" placeholder="Insira o nome do Cliente" />
        </form>
        <div id="carregando"></div>
        <table>
            <tbody>
                           
            </tbody>
        </table>
        <script type="text/javascript" src="library/js/jquery-1.11.1.min.js"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                $('input[name=nome]').keypress(function () {
                    $("tbody").html("");
                    $.ajax({
                        url: 'BuscaCliente',
                        type: 'POST',
                        dataType: 'json',
                        data: {nome: $('input[name=nome]').val()},
                        beforeSend: function () {
                            $("tbody").html('<img src="library/img/gif-load.gif" />');
                        },
                        success: function (data) {
                        var corpo = '<tr><td>ID</td><td>NOME</td><td>CPF</td></tr> ';
                        for (var i = 0, length = data.length; i < length; i++) {
                            var cliente = data[i];
                            corpo += "<tr>";
                            corpo += "<td>" + cliente.id + "</td>";
                            corpo += "<td>" + cliente.nome + "</td>";
                            corpo += "<td>" + cliente.cpf + "</td>";
                            corpo += "</tr>";
                        }
                        $("tbody").html(corpo);
                    }
                  });
                });
            });
        </script>
    </body>
</html>
