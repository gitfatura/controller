<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="UTF-8">
    <title>Receita</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initialscale=1">

</head>
<body style="background-color:  #F8EBE1">
<jsp:include page="home.jsp"/>

	<div class="container" style="max-width:400px;margin:60px auto;">
	    
	    <header>
	        <p style="font-family: serif;">Nova categoria / despesas</p>
	    </header>
	    
	    <form role="form" action="adiciona-categoria-despesa" method="post">
	        
	        <div class="form-group">
	            <input type="text" name="categoria" class="form-control"  style="font-family: 'Courier New'; font-size: 15px" placeholder="Informe categoria / despesas.." required="required">
	        </div>
	
	          	        
	        <button type="submit" class="btn btn-default">Registrar</button>
	        
	    </form>
	    
	</div>

</body>
</html>