<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<%@ include file="header.jsp"%>
</head>
<body>
	<main class="d-flex" id="recolhe-menu">

		<!-- Menu Lateral -->
		<%@ include file="menu-aside.jsp"%>
		<!-- Fim Menu Lateral -->

		<!-- Conte�do da P�gina -->
		<section id="conteudo-pagina">

			<!-- Menu para deslogar -->
			<%@ include file="menu-top.jsp"%>
			<!-- Fim Menu para Deslogar -->

			<!-- Conte�do Principal -->
			<div class="container-fluid">
				<h1 class="mt-4">Dashboard</h1>
				<ol class="breadcrumb mb-4">
					<li class="breadcrumb-item active">Dashboard</li>
				</ol>
				<div class="container pb-5">
					<div class="row justify-content-around">
						<article class="card mb-2" style="width: 22rem;">
							<div class="card-body">
								<h5 class="cartao-titulo card-title">
									<i class="icone-cartao fas fa-running"></i> Exerc�cios
								</h5>
								<p class="cartao-texto card-text">00:45:17</p>
								<a href="#" data-toggle="modal" data-target="#modalExercicio"
									class="btn cor-botao">Adicionar</a>
							</div>
						</article>
						<article class="card mb-2" style="width: 22rem;">
							<div class="card-body">
								<h5 class="cartao-titulo card-title">
									<i class="icone-cartao fas fa-utensils"></i> Calorias
								</h5>
								<p class="cartao-texto card-text">2000 kcal</p>
								<a href="#" data-toggle="modal" data-target="#modalAlimento"
									class="btn cor-botao">Adicionar</a>
							</div>
						</article>
						<article class="card mb-2" style="width: 22rem;">
							<div class="card-body">
								<h5 class="cartao-titulo card-title">
									<i class="icone-cartao fas fa-weight"></i> Peso
								</h5>
								<p class="cartao-texto card-text">65 kg</p>
								<a href="#" data-toggle="modal" data-target="#modalPeso"
									class="btn cor-botao">Adicionar</a>
							</div>
						</article>
						<article class="card mb-2" style="width: 22rem;">
							<div class="card-body">
								<h5 class="cartao-titulo card-title text-left">
									<img src="resources/img/blood-pressure-black.svg"
										class="icone-pressao-arterial-preto"> Press�o Arterial
								</h5>
								<p class="cartao-texto card-text">120 / 80 mmHg</p>
								<a href="#" data-toggle="modal" data-target="#modalPressao"
									class="btn cor-botao">Adicionar</a>
							</div>
						</article>
					</div>
					<div class="row mt-4">
						<div class="col-xl-6">
							<article class="card mb-4">
								<div class="cartao-titulo card-header">
									<i class="icone-cartao fas fa-running"></i>Atividades
									Realizadas
								</div>
								<div class="card-body">
									<canvas id="myAreaChart" width="100%" height="50"></canvas>
								</div>
							</article>
						</div>
						<div class="col-xl-6">
							<article class="card mb-4">
								<div class="cartao-titulo card-header">
									<i class="icone-cartao fas fa-weight"></i>Evolu��o do Peso
								</div>
								<div class="card-body">
									<canvas id="myBarChart" width="100%" height="50"></canvas>
								</div>
							</article>
						</div>
					</div>
				</div>
			</div>
			<!-- Fim Cont�udo Principal-->

		</section>
		<!-- Fim Cont�udo P�gina -->

	</main>
	<%@ include file="footer.jsp"%>

	<!-- Modais Exerc�cios, Alimentos e Peso -->
	<%@ include file="physical-activity-modal.jsp"%>
	<%@ include file="food-modal.jsp"%>
	<%@ include file="weight-modal.jsp"%>
	<%@ include file="blood-pressure-modal.jsp"%>
	<!-- Fim dos Modais -->

</body>