<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
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
				<h1 class="mt-4">Gerenciar Alimentos</h1>
				<ol class="breadcrumb mb-4">
					<li class="breadcrumb-item"><a href="home.jsp">Dashboard</a></li>
					<li class="breadcrumb-item active">Gerenciar Alimentos</li>
				</ol>
				<div class="card mb-4">
					<div class="card-header cartao-titulo">
						<i class="icone-cartao fas fa-drumstick-bite"></i> Lista de Alimentos
					</div>
					<div class="card-body">
						<div class="table-responsive">
							<table class="table table-bordered" id="" width="100%"
								cellspacing="0">
								<thead>
									<tr>
										<th>Nome</th>
										<th>Descri��o</th>
										<th>Tipo de Medida</th>
										<th>Quantidade</th>
										<th>Calorias</th>
										<th colspan="2">A��es</th>
									</tr>
								</thead>
								<tfoot>
									<tr>
										<th>Nome</th>
										<th>Descri��o</th>
										<th>Tipo de Medida</th>
										<th>Quantidade</th>
										<th>Calorias</th>
										<th colspan="2">A��es</th>
									</tr>
								</tfoot>
								<tbody>
									<tr>
										<td>Lorem ipsum dolor sit amet consectetur</td>
										<td>Magni provident placeat a eum corrupti mollitia fuga.</td>
										<td>XXX g ou ml</td>
										<td>XXX</td>
										<td>XXX cal</td>
										<td class="border-right-0">
											<button type="button" class="btn cor-botao"
												data-toggle="modal" data-target="#modalAlimento">
												<i class="fas fa-edit"></i>
											</button>
										</td>
										<td class="border-left-0">
											<button type="button" class="btn btn-danger">
												<i class="fas fa-trash"></i>
											</button>
										</td>
									</tr>
									<tr>
										<td>Lorem ipsum dolor sit amet consectetur</td>
										<td>Magni provident placeat a eum corrupti mollitia fuga.</td>
										<td>XXX g ou ml</td>
										<td>XXX</td>
										<td>XXX cal</td>
										<td class="border-right-0">
											<button type="button" class="btn cor-botao"
												data-toggle="modal" data-target="#modalAlimento">
												<i class="fas fa-edit"></i>
											</button>
										</td>
										<td class="border-left-0">
											<button type="button" class="btn btn-danger">
												<i class="fas fa-trash"></i>
											</button>
										</td>
									</tr>
									<tr>
										<td>Lorem ipsum dolor sit amet consectetur</td>
										<td>Magni provident placeat a eum corrupti mollitia fuga.</td>
										<td>XXX g ou ml</td>
										<td>XXX</td>
										<td>XXX cal</td>
										<td class="border-right-0">
											<button type="button" class="btn cor-botao"
												data-toggle="modal" data-target="#modalAlimento">
												<i class="fas fa-edit"></i>
											</button>
										</td>
										<td class="border-left-0">
											<button type="button" class="btn btn-danger">
												<i class="fas fa-trash"></i>
											</button>
										</td>
									</tr>
									<tr>
										<td>Lorem ipsum dolor sit amet consectetur</td>
										<td>Magni provident placeat a eum corrupti mollitia fuga.</td>
										<td>XXX g ou ml</td>
										<td>XXX</td>
										<td>XXX cal</td>
										<td class="border-right-0">
											<button type="button" class="btn cor-botao"
												data-toggle="modal" data-target="#modalAlimento">
												<i class="fas fa-edit"></i>
											</button>
										</td>
										<td class="border-left-0">
											<button type="button" class="btn btn-danger">
												<i class="fas fa-trash"></i>
											</button>
										</td>
									</tr>
									<tr>
										<td>Lorem ipsum dolor sit amet consectetur</td>
										<td>Magni provident placeat a eum corrupti mollitia fuga.</td>
										<td>XXX g ou ml</td>
										<td>XXX</td>
										<td>XXX cal</td>
										<td class="border-right-0">
											<button type="button" class="btn cor-botao"
												data-toggle="modal" data-target="#modalAlimento">
												<i class="fas fa-edit"></i>
											</button>
										</td>
										<td class="border-left-0">
											<button type="button" class="btn btn-danger">
												<i class="fas fa-trash"></i>
											</button>
										</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>

			<!-- Fim Conte�do Principal -->

		</section>
		<!-- Fim Cont�udo da P�gina -->
	</main>

	<%@ include file="footer.jsp"%>

	<!-- Modal Alimentos -->
	<%@ include file="food-modal.jsp"%>
	<!-- Fim Modal Alimentos -->
</body>
</html>