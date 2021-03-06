<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Usu�rio</title>
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
				<h1 class="mt-4">Perfil</h1>
				<ol class="breadcrumb mb-4">
					<li class="breadcrumb-item"><a href="home.jsp">Dashboard</a></li>
					<li class="breadcrumb-item active">Perfil</li>
				</ol>
				<div class="container">
					<div class="row justify-content-left">
						<div class="card mb-4" style="max-width: 1024px;">
							<div class="row no-gutters">
								<div class="col-md-4">
									<label>
										<div class="text-center">
											<img src="resources/img/avatar.png"
												class="img-fluid p-1 rounded-circle" alt="Foto do Usu�rio">
											<h6>Coloque uma foto...</h6>
											<div class="custom-file ml-3 overlay">
												<input type="file" class="custom-file-input" id="customFile"
													name="filename"> <label
													class="custom-file-label mr-4 text-left" for="customFile"></label>
											</div>
										</div>
									</label>
									<div class="row m-3 text-center">
										<button type="button"
											class="btn mr-2 mb-2 btn-block cor-botao icones-menu-lateral"
											data-toggle="modal" data-target="#modalPerfil">
											<i class="fas fa-edit"></i> Editar Dados
										</button>
									</div>
								</div>
								<div class="col-md-8">
									<div class="card-body">
										<h5 class="card-title cor-especial cartao-titulo-perfil">Dados
											Usu�rio</h5>
										<div class="row">
											<div class="col-md-6">
												<label>ID do Usu�rio</label>
											</div>
											<div class="col-md-6">
												<p>XXXXXXXXXXXXXXXXX</p>
											</div>
										</div>
										<div class="row">
											<div class="col-md-6">
												<label>Nome</label>
											</div>
											<div class="col-md-6">
												<p>Nome do Usu�rio</p>
											</div>
										</div>
										<div class="row">
											<div class="col-md-6">
												<label>Email</label>
											</div>
											<div class="col-md-6">
												<p>email@email.com</p>
											</div>
										</div>
										<div class="row">
											<div class="col-md-6">
												<label>Telefone</label>
											</div>
											<div class="col-md-6">
												<p>(XX) XXXXX - XXXX</p>
											</div>
										</div>
										<p class="card-text">
											<small class="text-muted">�ltima atualiza��o foi a 3
												minutos atr�s</small>
										</p>
										<h5 class="card-title cor-especial cartao-titulo-perfil">Informa��es
											do Usu�rio</h5>
										<div class="row">
											<div class="col-md-6">
												<label>Sexo</label>
											</div>
											<div class="col-md-6">
												<p>Lorem ipsum dolor sit amet</p>
											</div>
										</div>
										<div class="row">
											<div class="col-md-6">
												<label>Nascimento</label>
											</div>
											<div class="col-md-6">
												<p>XX/XX/XXXX</p>
											</div>
										</div>
										<div class="row">
											<div class="col-md-6">
												<label>Altura</label>
											</div>
											<div class="col-md-6">
												<p>XX,X m ou XXX cm</p>
											</div>
										</div>
										<div class="row">
											<div class="col-md-6">
												<label>Peso</label>
											</div>
											<div class="col-md-6">
												<p>XX,X kg</p>
											</div>
										</div>
										<h5 class="card-title cor-especial cartao-titulo-perfil">N�vel
											de Atividade</h5>
										<div class="row justify-content-center">
											<div class="col-md-4">
												<button type="button" class="btn mr-3 mb-2 cor-botao">
													<i class="fas fa-male"></i>
												</button>
												<span>Sedent�rio</span>
											</div>
											<div class="col-md-4">
												<button type="button" class="btn mr-3 mb-2 btn-primary">
													<i class="fas fa-walking"></i>
												</button>
												<span>Pouco Ativo</span>
											</div>
											<div class="col-md-4">
												<button type="button" class="btn mr-3 mb-2 btn-primary">
													<i class="fas fa-running"></i>
												</button>
												<span>Muito Ativo</span>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

			<!-- Fim Conte�do Principal -->

		</section>
		<!-- Fim Cont�udo da P�gina -->
	</main>

	<%@ include file="footer.jsp"%>

	<!-- Modal Usu�rio -->
	<%@ include file="user-modal.jsp"%>
	<!-- Fim Modal  -->
</body>
</html>