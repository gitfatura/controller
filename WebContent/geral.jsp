<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="UTF-8">
    <title>Geral</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initialscale=1">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/paging.css">
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/paging.js"></script>
    
</head>

<body style="background-color:  #F8EBE1">

<jsp:include page="home.jsp"/>

	<div class="container" style="max-width:900px;margin:40px auto; font-family: 'Courier New'">
	
	    <ul class="list-group">
	        <li class="list-group-item">Mostrando todas transacoes</li>
	        
	        <li class="list-group-item list-group-item-success">Receitas  <fmt:formatNumber value="${somareceitas}" type="currency"/> 
	        	<a href="./geral" data-toggle="modal" data-target="#exampleModalLong" style="margin-left: 1%;"><span class="badge badge-pill badge-info">Info</span></a>
	        </li>
	                
	        <li class="list-group-item list-group-item-info">Despesas <fmt:formatNumber value="${somadespesas}" type="currency"/></li>
	        
	    </ul>
	
		<div>
	    		<p style="margin: 10px">Geral</p>
		</div>
	    <div class="card" style="max-height:400px;overflow:auto;">
	    <table class="table table-hover">
	        <tbody id="myTable">
			<c:forEach var="despesa" items="${despesas}">
				<tr>
					<td>${despesa.descricao}</td>
					<td><fmt:formatNumber value="${despesa.valor}" type="currency"/></td>
					<td><fmt:formatDate value="${despesa.data}"/></td>
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
	        	<c:forEach var="receita" items="${receitas}">
						<tr>
							<td>${receita.descricao}</td>
							<td><fmt:formatNumber value="${receita.valor}" type="currency"/></td>
							<td><fmt:formatDate value="${receita.data}"/></td>
						</tr>
						
				</c:forEach>		
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

</body>
</html>