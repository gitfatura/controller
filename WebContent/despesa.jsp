<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initialscale=1">
 </head>
<body style="background-color:  #F8EBE1">
	
	<jsp:include page="home.jsp"/>

		<div class="container" id="cdi" style="max-width:400px;margin:60px auto;">
		
		    <header>
		        <p style="font-family: serif;">Nova despesa</p>
		    </header>
		
		    <form role="form" action="adiciona-despesa" method="post">
		        
		        <div class="form-group">
		            <input type="text" class="form-control" name="valor" required="required"  style="font-family: 'Courier New'; font-size: 15px" placeholder="Valor R$..">
		        </div>
		
		        <div class="form-group">
		            <select class="form-control" name="categoria" style="font-family: 'Courier New'; font-size: 15px" required="required">
		                <option value="" selected disabled>Despesa indefinida</option>
		                <c:forEach var="catedispesas" items="${categoriasdespesas}">
		                		<option value="${catedispesas.id}">${catedispesas.descricao}</option>
		                </c:forEach>
		            </select>
		        </div>
		
		        <div class="form-group">
		            <input type="date" name="data" placeholder="00-00-0000" class="form-control"  placeholder="Data" style="font-family: 'Courier New'" required="required">
		        </div>
		        
		        <button type="submit" id="registrar" class="btn btn-default">Registrar</button>
		       		        
		       </form>
		    	
		</div>
	 </body>
</html>