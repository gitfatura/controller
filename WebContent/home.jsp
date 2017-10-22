<!DOCTYPE html>
<html lang="pt-br">
<head>

    <meta charset="UTF-8">
    <title>Home</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/style.css">
	
</head>
<body style="background-color: #F8EBE1">
    
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
	  		<a class="navbar-brand" href="#"></a>
	 	
	 	 <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
	    	<span class="navbar-toggler-icon"></span>
	  	</button>
		
		  <div class="collapse navbar-collapse" id="navbarNavDropdown">
		     <ul class="navbar-nav mr-auto">
		        
		        <li class="nav-item">
		            <a class="nav-link " href="home.jsp" style="font-family: 'serif'">Home</a>
		        </li>
		        
		        <li class="nav-item active dropdown">
		            <a class="nav-link  dropdown-toggle"  href="#"  style="font-family: 'serif'" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Receita</a>
		            <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
		            		<a class="dropdown-item" href="./nova-receita">Nova receita</a>		
         			 	<a class="dropdown-item" href="./receitas">Todas receitas</a>
        				</div>
		            
		        </li>
		        <li class="nav-item active dropdown">
		            
		            <a class="nav-link dropdown-toggle" href="#" style="font-family: serif" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Despesa</a>
		            <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
		            		<a class="dropdown-item" href="./nova-despesa">Nova despesa</a>
         			 	<a class="dropdown-item" href="./busca-despesas">Todas despesas</a>
        				</div>
		            
		        </li>
		        
		        
		       
		        
		        <li class="nav-item active dropdown">
		            
		            <a class="nav-link dropdown-toggle" href="#" style="font-family: serif" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Graficos</a>
		            <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
		            
         			 	<a class="dropdown-item" href="./grafico-despesa">Grafico despesa</a>
          				<a class="dropdown-item" href="./grafico-receita">Grafico receita</a>
        				</div>
		            
		        </li>
		        
		        <li class="nav-item active dropdown">
		            
		            <a class="nav-link dropdown-toggle" href="#" style="font-family: serif" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Categorias</a>
		            <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
		            
         			 	<a class="dropdown-item"  href="./nova-categoria-receita">Categoria / receita </a>
          				<a class="dropdown-item" href="./nova-categoria-despesa">Categoria / despesa</a>
        				</div>
		            
		        </li>
		        
		         <li class="nav-item active">
		            <a class="nav-link" href="./geral" style="font-family: serif">Geral</a>
		        </li>
		         
				 				 				
		    </ul>
		     
		  </div>
	</nav>

<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.min.js"></script>    

</body>
</html>