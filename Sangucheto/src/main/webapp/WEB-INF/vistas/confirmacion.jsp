<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
		<link href="https://fonts.googleapis.com/css?family=Arima+Madurai:500|Open+Sans+Condensed:300" rel="stylesheet">
		<link href="css/estilos.css" rel="stylesheet"/>
		
		<title>Confirmacion</title>
	</head>
	<body class="sans cremita-fondo" >

		<div class="col-md-8 text-center center-block float-none">
			<div class="col-md-12 col-xs-12 espacio-arriba">
				<img class="img-responsive display-en-linea col-xs-12 animated fadeIn" style="animation-delay: 0.5s;" src="images/sanguche-inicio.png"/>
				<h1 class="muy-grande col-md-12 col-xs-12 animated fadeIn" style="animation-delay: 1.5s;" >¡Gracias por su compra!</h1>
				<ul class=" lista-en-linea sacar-puntos grande separar">
					<c:forEach items="${sangucheto}" var="item">
						<li> ${item.value} x ${item.key.nombre} </li>
					</c:forEach>
					<li></li>
					<li> Valor: $ ${String.format("%.2f", preciofinal)} </li>
				</ul>
			</div>
		</div>
	</body>
</html>