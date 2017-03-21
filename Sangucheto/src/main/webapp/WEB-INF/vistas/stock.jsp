<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
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
		       			</tr>
		       		</c:if>
		       		</c:forEach>
		       			
		      	</tbody>
		    </table>
		    	
		 </div>
	
		<div class="form-group">
		
			<button class="btn btn-success">Agregar</button>
		
			<button class="btn btn-warning">Modificar</button>
			
			<button class="btn btn-danger">Eliminar</button>
		
		</div>

		
		</c:forEach>
	
	</div>
	
	
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="js/jquery-1.11.3.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>
</body>
</html>