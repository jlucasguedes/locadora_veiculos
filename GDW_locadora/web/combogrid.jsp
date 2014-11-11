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
        <title>ComboGrid</title>
        <link rel="stylesheet" type="text/css" media="screen" href="/resources/css/smoothness/jquery-ui-1.10.1.custom.css"/>
        <script type="text/javascript" src="library/combogrid/resources/jquery/jquery-1.9.1.min.js"></script>
        <script type="text/javascript" src="library/combogrid/resources/jquery/jquery-ui-1.10.1.custom.min.js"></script>
        <link rel="stylesheet" type="text/css" media="screen" href="library/combogrid/resources/css/smoothness/jquery.ui.combogrid.css"/>
        <script type="text/javascript" src="library/combogrid/resources/plugin/jquery.ui.combogrid.js"></script>
        <script>
            jQuery(document).ready(function () {
                $("#project").combogrid({
                    
                    debug: true,
                    colModel: [{'columnName': 'id', 'width': '10', 'label': 'ID'},
                        {'columnName': 'nome', 'width': '45', 'label': 'NOME'},
                        {'columnName': 'cpf', 'width': '45', 'label': 'CPF'}
                    ],
                    url: 'BuscaCliente',
                    select: function (event, ui) {
                        $("#project").val(ui.item.name);
                        return false;
                    }
                });
            });
        </script>
    </head>
    <body>
        <input size="30" id="project" class="ui-autocomplete-input" autocomplete="off" role="textbox" aria-autocomplete="list" aria-haspopup="true">
    </body>
</html>
