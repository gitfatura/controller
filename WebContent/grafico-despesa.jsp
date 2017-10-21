
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE>
<html>
<head>
	<meta charset="UTF-8">
	<title>Grafico Dispesas</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<script type="text/javascript" src="js/jsapi.js"></script>
	<script type="text/javascript">


// Carrega a API de visualiza��o e o pacote piechart.
	google.load('visualization', '1.0', {
        'packages' : [ 'corechart' ]
    });
 
   // Defina uma chamada de retorno para executar quando a API de visualiza��o do Google � carregada.
    google.setOnLoadCallback(drawChart);
 
	 // Callback que cria e preenche uma tabela de dados,
    // cria o gr�fico de pizza, passa nos dados e
    // desenha.
    function drawChart() {
 
    		// Crie a tabela de dados.
             var data = google.visualization.arrayToDataTable([
                                                              ['Country', 'Area(square km)'],
                                                              <c:forEach items="${despesas}" var="d">
                                                                  [ '${d.descricao}', ${d.valor} ],
                                                              </c:forEach>
                                                        ]);
 
          // Definir op��es de gr�fico
        var options = {
            'title' : 'Despesas mesnal', //set um titulo para o chart
            is3D : true, // renderizar o Google Pie Chart como 3D
            pieSliceText: 'label', //no r�tulo de exibi��o de mouse hover ou nome do pa�s
            tooltip :  {showColorCode: true}, // se deseja exibir o c�digo de cores para um pa�s no mouse
            'width' : 900, //largura do Google Pie Chart
            'height' : 500 //altura do Google Pie Chart
        };
 
        // Instanciar e desenhar nosso gr�fico, passando em algumas op��es.

        var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
        chart.draw(data, options);
    }
</script>
</head>
<body>
<jsp:include page="home.jsp"/>
	<!-- Essa e a div que mostra o chart -->
 	
	<div id="chart_div" class="container" style="max-width: 900px; padding: 10px; margin-left:auto; margin-right: auto; height: 500px; margin-top: 1%; font-family: 'Courier New';">
	
	</div>
</body>
</html>