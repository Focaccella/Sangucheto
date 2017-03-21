<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/stock.css" />
<title>Stock</title>

<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

	<br>

	<div class="container">
	
		<c:forEach items="INGREDIENTE,CONDIMENTO" var="tipo">
		
		<div class="panel panel-default">
		
			<div class="panel-heading">LISTA DE ${tipo}S</div>
		
		    <table class="table">
		    
				<thead>
		        	<tr>
		          		<th>Nombre</th>
		          		<th>Precio</th>
		          		<th>Tipo</th>
		          		<th>Cantidad</th>
		          		<th>Accion</th>
		        	</tr>
		      	</thead>
		      	<tbody>
		      		
		      		<c:forEach items="${stock}" var="item">
		      		<c:if test="${item.key.tipo.toString().equals(tipo)}">
		        		<tr>
				        		<td>${item.key.nombre}</td>
				          		<td>$ ${item.key.precio}</td>
				          		<td>${item.key.tipo}</td>
				          		<td>${item.value}</td>
				          		<td>
				          		
								<div class="btn-group">
								  <button type="button" class="btn btn-primary dropdown-toggle"
								          data-toggle="dropdown">
								   	Agregar <span class="caret"></span>
								  </button> 
								  <ul class="dropdown-menu" role="menu">
								    <li><strong>Cantidad:</strong> <input id="txtIngreso" name="cantidadIngresada" type="text" name="fname"><a href="#">Aceptar</a></li>
								  </ul>
								</div>
								
				          		<div class="btn-group">
								  <button type="button" class="btn btn-warning dropdown-toggle"
								          data-toggle="dropdown">
								   	Modificar <span class="caret"></span>
								  </button>
								  <ul class="dropdown-menu" role="menu">
								    <li><strong>Cantidad:</strong> <input id="txtIngreso" name="cantidadIngresada" type="text" name="fname"><a href="#">Aceptar</a></li>
								  </ul>
								</div>
								 
								<div class="btn-group">
								  <button type="button" class="btn btn-danger dropdown-toggle"
								          data-toggle="dropdown">
								   	Eliminar <span class="caret"></span>
								  </button>
									<ul class="dropdown-menu" role="menu">
								  		<li><strong>Cantidad:</strong> <input id="txtIngreso" name="cantidadIngresada" type="text" name="fname"><a href="#">Aceptar</a></li>
								  	</ul>
								</div>
				          		
				          		
				          				
				          		<!--<div class="form-group">
										<button onclick="myFunction(<?=$item.key.nombre?>)" class="drop btn btn-success">Agregar</button>
										<div id=item.key.nombre class="dropdown-content">
    										<form:form class="drop" action="/stockRecibido" modelAttribute="ingrediente" method="POST">
						    				<div class="margen">
										  		<strong>Cantidad:</strong> <input id="txtIngreso" name="cantidadIngresada" type="text" name="fname">
										  		<button type="submit" class="btn btn-primary">Aceptar</button>
											</div>
										</form:form>
									</div>
									<button class="btn btn-warning">Modificar</button>
			
									<button class="btn btn-danger">Eliminar</button>
									
								</div>-->
								
								</td>
		       			</tr>
		       			
		       			
		       		</c:if>
		       		</c:forEach>
		       			
		      	</tbody>
		    </table>
		    	
		 </div>

		
		</c:forEach>
	
	</div>
	
	<script src="js/stock.js"></script>
	
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="js/jquery-1.11.3.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>
</body>
</html>