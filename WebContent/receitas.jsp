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
					<td><a href="<c:url value="/busca-receita?id=${receita.id}"/>">${receita.descricao}</a></td>
					<td><fmt:formatNumber value="${receita.valor}" type="currency"/></td>
					<td><fmt:formatDate value="${receita.data}"/></td>
					<td><a href="<c:url value="/remover-receita?id=${receita.id}"/>" class="close" aria-label="Close" onclick="return confirm('Deseja excluir ${receita.descricao}');" ><span aria-hidden="true">&times;</span></a></td>
				</tr>
			</c:forEach>
	        </tbody>
	    </table>
	
	    </div>
	
	</div>

 </body>
</html>