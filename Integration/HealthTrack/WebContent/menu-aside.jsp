<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<aside class="cor-especial border-right" id="menu-lateral">
		<div class="menu-lateral-posicao">
			<div class="text-center">
				<p class="titulo-menu-lateral">
					<i class="icones-cabecalho fas fa-heartbeat"></i> Health Track
				</p>
				<img src="resources/img/avatar.png"
					class="img-fluid p-1 rounded-circle" alt="Foto do Usuário">
				<p>Nome do Usuário</p>
			</div>
		</div>
		<ul class="list-group list-group-flush">
			<li><a href="weight.jsp"
				class="lista-lateral cor-especial list-group-item"> <i
					class="icones-menu-lateral fas fa-weight"></i>
					<p>Gerenciar Peso</p>
			</a></li>
			<li><a href="blood-pressure.jsp"
				class="lista-lateral cor-especial list-group-item"> <img
					src="resources/img/blood-pressure-white.svg"
					class="icone-pressao-arterial-branco">
					<p>Gerenciar Pressão Arterial</p>
			</a></li>
			<li><a href="physical-activity.jsp"
				class="lista-lateral cor-especial list-group-item"> <i
					class="icones-menu-lateral fas fa-dumbbell"></i>
					<p>Gerenciar Atividades</p>
			</a></li>
			<li><a href="food.jsp"
				class="lista-lateral cor-especial list-group-item"> <i
					class="icones-menu-lateral fas fa-drumstick-bite"></i>
					<p>Gerenciar Alimentos</p>
			</a></li>
			<li><a href="meal.jsp"
				class="lista-lateral cor-especial list-group-item"> <i
					class="icones-menu-lateral fas fa-utensils"></i>
					<p>Gerenciar Refeições</p>
			</a></li>
			<li><a href="bmi.jsp"
				class="lista-lateral cor-especial list-group-item"> <i
					class="icones-menu-lateral fas fa-calculator"></i>
					<p>Calcular IMC</p>
			</a></li>
		</ul>
	</aside>
</body>
</html>