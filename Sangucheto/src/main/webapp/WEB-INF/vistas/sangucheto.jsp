<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Armar Sangucheto</title>

<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

	<div class="container">
	
		<c:forEach items="INGREDIENTE,CONDIMENTO" var="tipo">
	
			<div class="page-header">
			
				<h1>Agregar ${tipo.toLowerCase()}s</h1>
			
			</div>	
			
			<div class="container form-group">	
				
				<div class="col-md-6">
								
				<select class="form-control">
				
					<c:forEach items="${stock}" var="item">
						
						<c:if test="${item.key.tipo.toString().equals(tipo)}">
						
							<option>${item.key.nombre}</option>
						
						</c:if>
						
					</c:forEach>
					
				</select>
				
				</div>
				
				<div class="col-md-4">
				
      					<input type="text" class="form-control" placeholder="Cantidad">
      					
  				</div>
				
				<div class="col-md-2">
				
					<button class="btn btn-primary">Agregar</button>
				
				</div>
				
			</div>
		
		</c:forEach>
		
		<div class="page-header">
			
			<h1>Mi Sangucheto</h1>
			
		</div>
		
	    <table class="table">
	    
			<thead>
	        	<tr>
	        		<th>Cantidad</th>
	          		<th>Nombre</th>
	          		<th>P. Unitario</th>
	          		<th>P. Total</th>
	          		<th>Accion</th>
	        	</tr>
	      	</thead>
	      	<tbody>
	      		
	      		<c:forEach items="${sangucheto.ingredientes}" var="item">
	        		<tr>
	        			<td>${item.value}</td>
			        	<td>${item.key.nombre}</td>
			          	<td>$ ${item.key.precio}</td>
			          	<td>$ ${item.key.precio * item.value}</td>
			          	
			          	<td>	
							<div class="btn-group">
							  <button type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown">
							  Eliminar <span class="caret"></span>
							  </button>
								<ul class="dropdown-menu" role="menu">
							  		<form:form action="eliminarIngrediente" modelAttribute="ingrediente" method="POST">
							    		<li><strong>¿Eliminar Ingrediente?</strong> <form:input style="display: none;" path="nombre" value="${item.key.nombre}" readonly="true"/>
							    		<button type="submit" class="btn btn-primary">Aceptar</button></li>
							  		</form:form>
							  	</ul>
							</div>
						</td>
	       			</tr>
	       			
	       		</c:forEach>
	      	</tbody>
	    </table>
	    
	    <h1>$ ${sangucheto.getPrecio()}</h1>
	
	</div>
	

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="js/jquery-1.11.3.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>
</body>
</html>