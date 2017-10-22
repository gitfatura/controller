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

	<div class="container" style="max-width:400px;margin:60px auto;">
	    
	    <header>
	        <p style="font-family: serif;">Atualizacao da despesa</p>
	    </header>
	    
	    <form role="form" action="update-despesa" method="post">
	        <input type="hidden" name="id" value="${despesa.id}">
	        <div class="form-group">
	            <input type="text" name="valor"  value="R$ ${despesa.valor}" class="form-control"  style="font-family: 'Courier New'; font-size: 15px" placeholder="Valor R$.." required="required">
	        </div>
			
	        <div class="form-group">
	            <select name="categoria" class="form-control" style="font-family: 'Courier New'; font-size: 15px" required="required">
	              <option selected="selected" value="${despesa.idcategoria}">${despesa.descricao}</option>
	                <c:forEach var="des" items="${categoriasdespesas}">
	                		<option value="${des.id}">${des.descricao}</option>
	                </c:forEach>
	            </select>
	        </div>
	
	        <div class="form-group">
	            <input type="date" name="data" value="${despesa.data}" class="form-control"  placeholder="Data" style="font-family: 'Courier New'" required="required">
	        </div>
	         
	        <button type="submit" class="btn btn-default">Registrar</button>
	        
	    </form>
	    
	</div>
	
 </body>
</html>