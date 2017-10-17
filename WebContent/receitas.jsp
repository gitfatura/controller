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
	        <li class="list-group-item">Mostrando todas receitas</li>
	        
	    </ul>
	
	    <div class="card" style="max-height:400px;overflow:auto;">
	    <table class="table table-hover">
	        <tbody id="myTable">
			<c:forEach var="receita" items="${receitas}">
				<tr>
					<td><a href="#" data-toggle="modal" data-target="#exampleModalLong">${receita.descricao}</a></td>
					<td><fmt:formatNumber value="${receita.valor}" type="currency"/></td>
					<td><fmt:formatDate value="${receita.data}"/></td>
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
        <h5 class="modal-title" id="exampleModalLongTitle">Atualizacao receita</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        	 <form role="form" action="adiciona-receita" method="post">
	        
	        <div class="form-group">
	            <input type="text" name="valor" class="form-control"  style="font-family: 'Courier New'; font-size: 15px" placeholder="Valor R$.." required="required">
	        </div>
	
	        <div class="form-group">
	            <select name="categoria" class="form-control" style="font-family: 'Courier New'; font-size: 15px" required="required">
	                <option value="" selected disabled>Receita indefinida</option>
	                <c:forEach var="receita" items="${categoriasreceitas}">
	                		<option value="${receita.id}">${receita.descricao}</option>
	                </c:forEach>
	            </select>
	        </div>
	
	        <div class="form-group">
	            <input type="date" name="data" class="form-control"  placeholder="Data" style="font-family: 'Courier New'" required="required">
	        </div>
	        
	        <div class="form-group">
	            <input type="text" name="nota" class="form-control"  placeholder="Adiciona uma nota" style="font-family: 'Courier New'">
	        </div>
	        
	        <button type="submit" class="btn btn-default">Registrar</button>
	        
	    </form>
	        
	        
	                
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
      </div>
    </div>
  </div>
</div>
 
</body>
</html>