
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<script type="text/javascript" src="js/loader.js"></script>
	
	
</head>
<body style="background-color:  #F8EBE1">
	<jsp:include page="/home.jsp"/>
		<c:forEach var="rec" items="${receitas}">
		<script type="text/javascript">
		
		    google.charts.load('current', {'packages':['corechart']});
		    google.charts.setOnLoadCallback(drawChart);
		
		    function drawChart() {
			
		        var data = google.visualization.arrayToDataTable([
		        		
		            ['',''],
		           
		            ['Aluguel', 40],
		            ['Gasolina',      150],
		            ['Mercado',  400],
		            ['Parcela moto', 10],
		            ['Aluguel', 300],
		            ['Gasolina',      120]
		            
		                        
		        ]);
		
		        var options = {
		            title: '9 de outubro 2017'
		        };
		
		        var chart = new google.visualization.PieChart(document.getElementById('piechart'));
		
		        chart.draw(data, options);
		    }
		</script>
 </c:forEach>
		<div id="piechart" class="container" style="max-width:900px; padding: 6px; margin-left:auto; margin-right: auto; height: 400px; margin-top: 5%; font-family: 'Courier New';">
		</div>
    
 </body>
</html>