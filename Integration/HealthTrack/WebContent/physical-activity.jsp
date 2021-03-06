<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Atividade F�sica</title>
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
				<h1 class="mt-4">Gerenciar Atividades</h1>
				<ol class="breadcrumb mb-4">
					<li class="breadcrumb-item"><a href="home.jsp">Dashboard</a></li>
					<li class="breadcrumb-item active">Gerenciar Atividades</li>
				</ol>
				<div class="card mb-4">
					<div class="card-header cartao-titulo">
						<i class="icone-cartao fas fa-dumbbell"></i> Lista de Atividades
						F�sicas
					</div>
					<div class="card-body">
						<div class="table-responsive text-center">
							<table class="table table-bordered" id="" width="100%"
								cellspacing="0">
								<thead>
									<tr>
										<th>Atividade</th>
										<th>Tipo</th>
										<th>Data</th>
										<th>Tempo</th>
										<th>Calorias</th>
										<th>Dist�ncia</th>
										<th>S�ries, Repeti��es e Peso Levantado</th>
										<th colspan="2">A��es</th>
									</tr>
								</thead>
								<tfoot>
									<tr>
										<th>Atividade</th>
										<th>Tipo</th>
										<th>Data</th>
										<th>Tempo</th>
										<th>Calorias</th>
										<th>Dist�ncia</th>
										<th>S�ries, Repeti��es e Peso Levantado</th>
										<th colspan="2">A��es</th>
									</tr>
								</tfoot>
								<tbody>
									<tr>
										<td>Lorem ipsum dolor</td>
										<td>Corporis repellendus.</td>
										<td>XX / XX / XXXX</td>
										<td>XXX min</td>
										<td>XXX kcal</td>
										<td>XXX km</td>
										<td>XX S, XX Rep, XX kg</td>
										<td class="border-right-0">
											<button type="button" class="btn m-2 cor-botao"
												data-toggle="modal" data-target="#modalExercicio">
												<i class="fas fa-edit"></i>
											</button>
										</td>
										<td class="border-left-0">
											<button type="button" class="btn m-2 btn-danger">
												<i class="fas fa-trash"></i>
											</button>
										</td>
									</tr>
									<tr>
										<td>Lorem ipsum dolor</td>
										<td>Corporis repellendus.</td>
										<td>XX / XX / XXXX</td>
										<td>XXX min</td>
										<td>XXX kcal</td>
										<td>XXX km</td>
										<td>XX S, XX Rep, XX kg</td>
										<td class="border-right-0">
											<button type="button" class="btn m-2 cor-botao"
												data-toggle="modal" data-target="#modalExercicio">
												<i class="fas fa-edit"></i>
											</button>
										</td>
										<td class="border-left-0">
											<button type="button" class="btn m-2 btn-danger">
												<i class="fas fa-trash"></i>
											</button>
										</td>
									</tr>
									<tr>
										<td>Lorem ipsum dolor</td>
										<td>Corporis repellendus.</td>
										<td>XX / XX / XXXX</td>
										<td>XXX min</td>
										<td>XXX kcal</td>
										<td>XXX km</td>
										<td>XX S, XX Rep, XX kg</td>
										<td class="border-right-0">
											<button type="button" class="btn m-2 cor-botao"
												data-toggle="modal" data-target="#modalExercicio">
												<i class="fas fa-edit"></i>
											</button>
										</td>
										<td class="border-left-0">
											<button type="button" class="btn m-2 btn-danger">
												<i class="fas fa-trash"></i>
											</button>
										</td>
									</tr>
									<tr>
										<td>Lorem ipsum dolor</td>
										<td>Corporis repellendus.</td>
										<td>XX / XX / XXXX</td>
										<td>XXX min</td>
										<td>XXX kcal</td>
										<td>XXX km</td>
										<td>XX S, XX Rep, XX kg</td>
										<td class="border-right-0">
											<button type="button" class="btn m-2 cor-botao"
												data-toggle="modal" data-target="#modalExercicio">
												<i class="fas fa-edit"></i>
											</button>
										</td>
										<td class="border-left-0">
											<button type="button" class="btn m-2 btn-danger">
												<i class="fas fa-trash"></i>
											</button>
										</td>
									</tr>
									<tr>
										<td>Lorem ipsum dolor</td>
										<td>Corporis repellendus.</td>
										<td>XX / XX / XXXX</td>
										<td>XXX min</td>
										<td>XXX kcal</td>
										<td>XXX km</td>
										<td>XX S, XX Rep, XX kg</td>
										<td class="border-right-0">
											<button type="button" class="btn m-2 cor-botao"
												data-toggle="modal" data-target="#modalExercicio">
												<i class="fas fa-edit"></i>
											</button>
										</td>
										<td class="border-left-0">
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
			<!-- Fim Cont�udo Principal-->				
			
		</section>
		<!-- Fim Cont�udo P�gina -->			
				
	</main>
	<%@ include file="footer.jsp"%>
	
	 <!-- Modal Exerc�cios -->
	<%@ include file="physical-activity-modal.jsp"%>
	<!-- Fim do Modal -->
	
</body>
</html>