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
				<h1 class="mt-4">Gerenciar Peso</h1>
				<ol class="breadcrumb mb-4">
					<li class="breadcrumb-item"><a href="home.jsp">Dashboard</a></li>
					<li class="breadcrumb-item active">Gerenciar Peso</li>
				</ol>
				<div class="card mb-4">
					<div class="card-header cartao-titulo">
						<i class="icone-cartao fas fa-weight"></i> Lista de Pesagens
					</div>
					<div class="card-body">
						<div class="table-responsive text-center">
							<table class="table table-bordered" id="" width="100%"
								cellspacing="0">
								<thead>
									<tr>
										<th>Data</th>
										<th>Peso</th>
										<th>IMC</th>
										<th>A��es</th>
									</tr>
								</thead>
								<tfoot>
									<tr>
										<th>Data</th>
										<th>Peso</th>
										<th>IMC</th>
										<th>A��es</th>
									</tr>
								</tfoot>
								<tbody>
									<tr>
										<td>XX / XX / XXXX</td>
										<td>XX, X kg</td>
										<td>XX, X</td>
										<td>
											<button type="button" class="btn m-2 cor-botao"
												data-target="#modalPeso" data-toggle="modal">
												<i class="fas fa-edit"></i>
											</button>
											<button type="button" class="btn m-2 btn-danger">
												<i class="fas fa-trash"></i>
											</button>
										</td>
									</tr>
									<tr>
										<td>XX / XX / XXXX</td>
										<td>XX, X kg</td>
										<td>XX, X</td>
										<td>
											<button type="button" class="btn m-2 cor-botao">
												<i class="fas fa-edit"></i>
											</button>
											<button type="button" class="btn m-2 btn-danger">
												<i class="fas fa-trash"></i>
											</button>
										</td>
									</tr>
									<tr>
										<td>XX / XX / XXXX</td>
										<td>XX, X kg</td>
										<td>XX, X</td>
										<td>
											<button type="button" class="btn m-2 cor-botao">
												<i class="fas fa-edit"></i>
											</button>
											<button type="button" class="btn m-2 btn-danger">
												<i class="fas fa-trash"></i>
											</button>
										</td>
									</tr>
									<tr>
										<td>XX / XX / XXXX</td>
										<td>XX, X kg</td>
										<td>XX, X</td>
										<td>
											<button type="button" class="btn m-2 cor-botao">
												<i class="fas fa-edit"></i>
											</button>
											<button type="button" class="btn m-2 btn-danger">
												<i class="fas fa-trash"></i>
											</button>
										</td>
									</tr>
									<tr>
										<td>XX / XX / XXXX</td>
										<td>XX, X kg</td>
										<td>XX, X</td>
										<td>
											<button type="button" class="btn m-2 cor-botao">
												<i class="fas fa-edit"></i>
											</button>
											<button type="button" class="btn m-2 btn-danger">
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

	<!-- Modal XXXXXXXXX -->
	<%@ include file="weight-modal.jsp"%>
	<!-- Fim XXXXXXXXXXX -->
</body>
</html>