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
		<br>
	    <ul class="nav nav-pills" role="tablist">
	        <li role="presentation"><a href=".">Home</a></li>
	        <li role="presentation" class="active"><a href="sangucheto">Arma tu Sangucheto</a></li>
	        <li role="presentation"><a href="stock">Administrar Stock</a></li>
     	</ul>
		<c:forEach items="INGREDIENTE,CONDIMENTO" var="tipo">
			<div class="page-header">			
				<h1>Agregar ${tipo.toLowerCase()}s</h1>			
			</div>				
			<div class="container form-group">	
				<form action="agregarIngrediente" method="POST" class="form">				
					<div class="col-md-6 form-group">								
					<select class="form-control" name="ingredienteAgregado">				
						<c:forEach items="${stock}" var="item">						
							<c:if test="${item.key.tipo.toString().equals(tipo)}">						
								<option value="${item.key.nombre}">${item.key.nombre} - $ ${item.key.precio}</option>
							</c:if>						
						</c:forEach>					
					</select>					
					</div>		
					<div class="col-md-4 form-group">
	      				<input type="text" class="form-control" placeholder="Cantidad" name="cantidad">	  				
	      			</div>					
					<div class="col-md-2 form-group">					
						<button class="btn btn-primary">Agregar</button>					
					</div>				
				</form>				
			</div>		
		</c:forEach>		
		<div class="page-header">			
			<h1>Mi Sangucheto</h1>			
		</div>		
	    <table class="table table-striped">	    
			<thead>
	        	<tr>
	        		<th class="col-sm-2">Cantidad</th>
	          		<th class="col-sm-3">Nombre</th>
	          		<th class="col-sm-3">P. Unitario</th>
	          		<th class="col-sm-3">P. Total</th>
	          		<th class="col-sm-1">Accion</th>
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
	    <h2 align="right"><small>Subtotal:</small> $ ${sangucheto.getPrecio()}</h2>	
	    <c:if test="${mensaje != null}">
		    <div class="alert alert-${tipoMensaje}" role="alert">
	       		${mensaje}
	      	</div>
      	</c:if>
	</div>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="js/jquery-1.11.3.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>
</body>
</html>