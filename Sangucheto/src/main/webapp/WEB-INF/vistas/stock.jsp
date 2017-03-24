<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Stock</title>

<link href="css/estilos.css" rel="stylesheet"/>
<link href="https://fonts.googleapis.com/css?family=Dosis|Indie+Flower|Nova+Oval" rel="stylesheet">

<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="cremita-fondo">
	<br>
	<div class="container">
		<ul class="nav nav-pills" role="tablist">
	        <li role="presentation"><a href=".">Home</a></li>
	        <li role="presentation"><a href="sangucheto">Arma tu Sangucheto</a></li>
	        <li role="presentation" class="active"><a href="stock">Administrar Stock</a></li>
     	</ul>

     	<div class="col-md-12 page-header text-center margen-abajo">
     		<h1 class="indie-font muy-grande color-sangucheto">Stock</h1>	
     	</div>
	
		<c:forEach items="INGREDIENTE,CONDIMENTO" var="tipo">
		
			<div class="page-header">			
				<h1>Lista de ${tipo.toLowerCase()}s</h1>			
			</div>	
		
		    <table class="table">
		    
				<thead>
		        	<tr>
		          		<th>Nombre</th>
		          		<th>Precio</th>
		          		<th>Cantidad</th>
		          		<th>Accion</th>
		        	</tr>
		      	</thead>
		      	<tbody>
		      		
		      		<c:forEach items="${stock}" var="item">
		      		<c:if test="${item.key.tipo.toString().equals(tipo)}">
		        		<tr>
				        	<td class="col-sm-3">${item.key.nombre}</td>
				          	<td class="col-sm-3">$ ${item.key.precio}</td>
				          	<td class="col-sm-3">${item.value}</td>
				          	<td class="col-sm-3">	
				          		<div class="btn-group">
								  <button type="button" class="btn btn-warning dropdown-toggle" data-toggle="dropdown">
								  	Agregar <span class="caret"></span>
								  </button>
								  <ul class="dropdown-menu" role="menu">
								  	<div class="col-lg-12">
									    <form:form action="stockModificado" modelAttribute="ingrediente" method="POST">
							    			<div class="form-group">
								    			<form:input type="hidden" path="nombre" value="${item.key.nombre}" readonly="true" class="form-control"/>
								    		</div>
								    		<div class="form-group">									 
								    			<label for="cantidad" class="label-control"></label><strong>Cantidad:</strong></label> 
								    		</div>
								    		<div class="form-group">	
								    			<input id="cantidad" type="number" name="cantidadAIngresar" class="form-control" value="0" />
								    		</div>
								    		<div class="form-group">	
								    			<button type="submit" class="btn btn-primary form-control">Aceptar</button>
								    		</div>
									  	</form:form>
								  	</div>
								  </ul>
								</div>
								<div class="btn-group">
								  <button type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown">
								 	 Eliminar <span class="caret"></span>
								  </button>
									<ul class="dropdown-menu" role="menu">
										<div class="col-lg-12">
											<form:form action="ingredienteEliminado" modelAttribute="ingrediente" method="POST">
												<div class="form-group">
													<form:input type="hidden" path="nombre" value="${item.key.nombre}" readonly="true" class="form-control"/>
												</div>
												<div class="form-group">
													<label for="aceptar" class="label-control"><strong>�Eliminar Ingrediente?</strong> </label>
												</div>
									    		<div class="form-group">
									    			<button type="submit" class="btn btn-primary form-control">Aceptar</button>
									    		</div>							    		
									  		</form:form>
										</div>
								  	</ul>
								</div>
								</td>
		       				</tr> 
		       			</c:if>
		       		</c:forEach>
		      	</tbody>
		    </table>
       			<div class="btn-group">
					<button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
						Agregar nuevo ${tipo.toLowerCase()} <span class="caret"></span>
					</button> 
					<ul class="dropdown-menu" role="menu">
						<div class="col-lg-12">
							<form:form  action="ingredienteAgregado" modelAttribute="ingrediente" method="POST">
								<div class="form-group"></div>
								<div class="form-group">
									<label class="label-control"><strong>Ingrediente:</strong></label>
								</div>
								<div class="form-group">
									<form:input path="nombre" placeholder="Nombre" class="form-control"/>
								</div>
								<div class="form-group">
									<input type="number" name="precio" placeholder="Precio" class="form-control"/>
								</div>
								<div class="form-group">
									<form:input path="tipo" style="display: none;" value="${tipo}" class="form-control"/>
								</div>
								<div class="form-group">
									<button type="submit" class="btn btn-primary form-control">Aceptar</button>
								</div>															
							</form:form>
						</div>
					</ul>
				</div>
		</c:forEach>
		<br>
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