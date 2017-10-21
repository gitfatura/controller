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
	        <li class="list-group-item">Mostrando todas despesas</li>
	        
	    </ul>
	
	    <div class="card" style="max-height:400px;overflow:auto;">
	    <table class="table table-hover">
	        <tbody id="myTable">
			<c:forEach var="despesa" items="${despesas}">
				<tr>
					<td>${despesa.id}</td>
					<td><a href="<c:url value="/busca-despesa?id=${despesa.id}"/>">${despesa.descricao}</a></td>
					<td><fmt:formatNumber value="${despesa.valor}" type="currency"/></td>
					<td><fmt:formatDate value="${despesa.data}"/></td>
					<td><a href="<c:url value="/remover-despesa?id=${despesa.id}"/>" class="close" aria-label="Close" onclick="return confirm('Deseja excluir ${despesa.descricao}');" ><span aria-hidden="true">&times;</span></a></td>
				</tr>
			</c:forEach>
	        </tbody>
	    </table>
	
	    </div>
	
	</div>

 </body>
</html>