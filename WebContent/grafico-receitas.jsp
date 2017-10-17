<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initialscale=1">
    
    <script type="text/javascript" src="js/loader.js"></script>
    
    
</head>
<body style="background-color:  #F8EBE1">
	<jsp:include page="home.jsp"/>

		  <script type="text/javascript">
		  
		    google.charts.load("current", {packages:['corechart']});
		    google.charts.setOnLoadCallback(drawChart);
		  
		    function drawChart() {
		      var data = google.visualization.arrayToDataTable([
		        ["Element", "", { role: "style" } ],
		        ["Janeiro", 120000, "#b87333"],
		        ["Fevereiro", 200, "silver"],
		        ["Marco", 3000, "gold"],
		        ["Abril", 40000, "color: #e5e4e2"],
		        ["Maio", 50000, "color: #e5e4e2"],
		        ["Junho", 130000, "color: #e5e4e2"],
		        ["Julho", 70000, "color: #e5e4e2"],
		        ["Agosto", 80000, "color: #e5e4e2"],
		        ["Setembro", 30000, "color: #e5e4e2"],
		        ["Outubro", 100000, "color: #e5e4e2"],
		        ["Novembro", 110000, "color: #e5e4e2"],
		        ["Dezembro", 120000, "color: #e5e4e2"]
		        
		      ]);
		
		      var view = new google.visualization.DataView(data);
		      view.setColumns([0, 1,
		                       { calc: "stringify",
		                         sourceColumn: 1,
		                         type: "string",
		                         role: "annotation" },
		                       2]);
		
		      var options = {
		        title: "Receita mensal",
		        width: 800,
		        height: 450,
		        bar: {groupWidth: "95%"},
		        legend: { position: "none" },
		      };
		      var chart = new google.visualization.ColumnChart(document.getElementById("columnchart_values"));
		      chart.draw(view, options);
		   }
		    
	  </script>
	
	<div id="columnchart_values" style="max-width: 900px; padding: 4%; margin: auto;">
	</div>
 
</body>
</html>