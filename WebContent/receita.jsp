<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="UTF-8">
    <title>Receita</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initialscale=1">

</head>
<body style="background-color:  #e3e0cf">
<jsp:include page="home.jsp"/>

	<div class="container" style="max-width:400px;margin:60px auto;">
	    
	    <header>
	        <p style="font-family: serif;">Nova receita</p>
	    </header>
	    
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

</body>
</html>