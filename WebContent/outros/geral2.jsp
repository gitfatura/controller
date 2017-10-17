<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="UTF-8">
    <title>Geral</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initialscale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/paging.css">
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/paging.js"></script>
    <style type="text/css">
    	
    	td {
			font-family: 'Courier New';
			font-size: 13px;
		}
    	
    </style>
    
    
    
</head>
<body style="background-color:  #f4f3ef">

<div class="container" style="max-width:500px;margin:40px auto; font-family: 'Courier New'">

    <ul class="list-group">
        <li class="list-group-item">Mostrando todas transacoes</li>
        
        <li class="list-group-item list-group-item-success">Receitas  <fmt:formatNumber value="${somar}" type="currency"/> 
        	<a href="#" data-toggle="modal" data-target="#exampleModalLong" style="margin-left: 30%;"><span class="badge badge-pill badge-info">Info</span></a>
        </li>
        
        <li class="list-group-item list-group-item-info">Despesas <fmt:formatNumber value="${somad}" type="currency"/></li>
        
    </ul></br>


    <p>Geral</p>

    <div style="max-height:300px;overflow:auto;">

    <table class="table table-hover">
        <tbody id="myTable">
		<c:forEach var="dispesa" items="${dispesas}">
			<tr>
				<td>${dispesa.categoria}</td>
				<td><fmt:formatNumber value="${dispesa.valor}" type="currency"/></td>
			</tr>
		</c:forEach>
        </tbody>
    </table>

    </div>

</div>



<!-- Modal -->
<div class="modal fade" id="exampleModalLong" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle" style="font-family: 'Courier New'">Todas receitas</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      
        <table class="table table-hover">
        	<tbody>
					<tr>
						<td>Economias</td>
						<td>R$500,00</td>
						<td>09/10/2017</td>
					</tr>
					<tr>
						<td>Economias</td>
						<td>R$500,00</td>
						<td>09/10/2017</td>
					</tr>
					<tr>
						<td>Economias</td>
						<td>R$500,00</td>
						<td>09/10/2017</td>
					</tr>
					<tr>
						<td>Economias</td>
						<td>R$500,00</td>
						<td>09/10/2017</td>
					</tr>
					<tr>
						<td>Economias</td>
						<td>R$500,00</td>
						<td>09/10/2017</td>
					</tr>
					<tr>
						<td>Economias</td>
						<td>R$500,00</td>
						<td>09/10/2017</td>
					</tr>
					<tr>
						<td>Economias</td>
						<td>R$500,00</td>
						<td>09/10/2017</td>
					</tr>
					<tr>
						<td>Economias</td>
						<td>R$500,00</td>
						<td>09/10/2017</td>
					</tr>
					
					
					    
        	</tbody>
    	</table>
    
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
        
     	<!--<button type="button" class="btn btn-primary">Save changes</button>-->
     
      </div>
    </div>
  </div>
</div>


<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/paging.js"></script>
</body>
</html>