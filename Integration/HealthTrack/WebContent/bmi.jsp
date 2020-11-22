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

		<!-- Conteúdo da Página -->
		<section id="conteudo-pagina">

			<!-- Menu para deslogar -->
			<%@ include file="menu-top.jsp"%>
			<!-- Fim Menu para Deslogar -->

			<!-- Conteúdo Principal -->
			<div class="container-fluid">
				<h1 class="mt-4">Calcular IMC</h1>
				<ol class="breadcrumb mb-4">
					<li class="breadcrumb-item"><a href="home.jsp">Dashboard</a></li>
					<li class="breadcrumb-item active">Calcular IMC</li>
				</ol>
				<div class="card mb-4">
					<div class="card-body">
						<p>IMC é a sigla para Índice de Massa Corpórea, parâmetro
							adotado pela Organização Mundial de Saúde para calcular o peso
							ideal de cada pessoa.</p>
						<p>O índice é calculado da seguinte maneira: divide-se o peso
							do paciente pela sua altura elevada ao quadrado. Diz-se que o
							indivíduo tem peso normal quando o resultado do IMC está entre
							18,5 e 24,9.</p>
						<p>Quer descobrir seu IMC? Insira seu peso e sua altura nos
							campos abaixo e compare com os índices da tabela. Importante:
							siga os exemplos e use pontos como separadores.</p>
						<form>
							<div class="form-row">
								<div class="form-group col-md-4">
									<label for="">Altura (ex.: 1.70)</label> 
									<input type="text" class="form-control" name="" id="height">
								</div>
								<div class="form-group col-md-4">
									<label for="">Peso (ex.: 69.2)</label> 
									<input type="text" class="form-control" name="" id="weight">
								</div>
							</div>
							<button type="button" class="btn cor-botao" data-toggle="modal" data-target="#bmiModal" onclick="bmi()">Calcular</button>
							<button type="reset" class="btn btn-secondary">Limpar</button>
						</form>

						<div class="table-responsive mt-2">
							<table class="table table-bordered" id="" width="100%"
								cellspacing="0">
								<thead>
									<tr>
										<td colspan="3">Veja a interpretação do IMC</td>
									</tr>
									<tr>
										<th>IMC</th>
										<th>Classificação</th>
										<th>Obesidade (Grau)</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>Menor que 18,5</td>
										<td>Magreza</td>
										<td>0</td>
									</tr>
									<tr>
										<td>Entre 18,5 e 24,9</td>
										<td>Normal</td>
										<td>0</td>
									</tr>
									<tr>
										<td>Entre 25,0 e 29,9</td>
										<td>Sobrepeso</td>
										<td>I</td>
									</tr>
									<tr>
										<td>Entre 30,0 e 39,9</td>
										<td>Obesidade</td>
										<td>II</td>
									</tr>
									<tr>
										<td>Maior que 40,0</td>
										<td>Obesidade Grave</td>
										<td>III</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
			<!-- Fim Conteúdo Principal -->

		</section>
		<!-- Fim Contéudo da Página -->
	</main>
	
	<!-- Modal -->
		<div class="modal fade" id="bmiModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header cor-botao">
		        <h5 class="modal-title" id="exampleModalLabel">Confirmação</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body text-center">
		        		<h1 id="result"></h1>
		      </div>

		    </div>
		  </div>
		</div>
	<!-- Fim Modal -->	
	<%@ include file="footer.jsp"%>
	<script>
		function bmi () {
			var height = Number(document.getElementById("height").value);
			var weight = Number(document.getElementById("weight").value);
			var result = weight / (height * height);
			document.getElementById("result").innerHTML = "Seu IMC é : " + result.toFixed(2);
			}	
	</script>
</body>
</html>