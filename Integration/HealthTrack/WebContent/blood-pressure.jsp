<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Press�o Sangu�nea</title>
<%@ include file="header.jsp"%>
</head>
<body>
	<main class="d-flex" id="recolhe-menu">
	
		<!-- Menu Lateral -->
		<%@ include file="menu-aside.jsp"%>
		<!-- Fim-->

		<!-- Conte�do da P�gina -->
		<section id="conteudo-pagina">
		
			<!-- Menu para deslogar -->
			<%@ include file="menu-top.jsp"%>
			<!-- Fim -->

			<!-- Conte�do Principal -->
			<div class="container-fluid">
				<h1 class="mt-4">Gerenciar Press�o Arterial</h1>
				<ol class="breadcrumb mb-4">
					<li class="breadcrumb-item"><a href="home.jsp">Dashboard</a></li>
					<li class="breadcrumb-item active">Gerenciar Press�o Arterial</li>
				</ol>
				<div class="card mb-4">
					<div class="card-header cartao-titulo">
						<img src="resources/img/blood-pressure-black.svg"
					class="icone-pressao-arterial-preto"> Lista de Medi��es de
						Press�o
					</div>
					<div class="card-body">
						<div class="table-responsive text-center">
							<table class="table table-bordered" id="" width="100%"
								cellspacing="0">
								<thead>
									<tr>
										<th>Data</th>
										<th>Press�o arterial sist�lica</th>
										<th>Press�o arterial diast�lica</th>
										<th>A��es</th>
									</tr>
								</thead>
								<tfoot>
									<tr>
										<th>Data</th>
										<th>Press�o arterial sist�lica</th>
										<th>Press�o arterial diast�lica</th>
										<th>A��es</th>
									</tr>
								</tfoot>
								<tbody>
									<tr>
										<td>XX / XX / XXXX</td>
										<td>XX, X mmHg</td>
										<td>XX, X mmHg</td>
										<td>
											<button type="button" class="btn m-2 cor-botao"
												data-target="#modalPressao" data-toggle="modal">
												<i class="fas fa-edit"></i>
											</button>
											<button type="button" class="btn m-2 btn-danger">
												<i class="fas fa-trash"></i>
											</button>
										</td>
									</tr>
									<tr>
										<td>XX / XX / XXXX</td>
										<td>XX, X mmHg</td>
										<td>XX, X mmHg</td>
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
										<td>XX, X mmHg</td>
										<td>XX, X mmHg</td>
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
										<td>XX, X mmHg</td>
										<td>XX, X mmHg</td>
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
										<td>XX, X mmHg</td>
										<td>XX, X mmHg</td>
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
			<!-- Fim -->
		</section>
		<!-- Fim -->
	</main>
	
	<%@ include file="footer.jsp"%>
	
	<!-- Modal Press�o Sangu�nea -->
	<%@ include file="blood-pressure-modal.jsp"%>
	<!-- Fim Modal Press�o Sangu�nea -->	
</body>
</html>