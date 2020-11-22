<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="modal fade" id="modalCadastro2" data-backdrop="static"
		tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
		aria-hidden="true">
		<div
			class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="modalCadastro2">Criar Conta</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<ul
						class="nav mb-2 nav-pillsflex-column flex-sm-row justify-content-center">
						<li class="nav-item"><a class="nav-link" href="#"
							data-toggle="modal" data-target="#modalCadastro"
							data-dismiss="modal"><span class="badge badge-dark">1</span>
								Dados do Usuário</a></li>
						<li class="nav-item"><a class="nav-link cor-botao rounded"
							href="#"><span class="badge badge-dark">2</span> Informações
								do Usuário</a></li>
					</ul>
					<form>
						<div class="form-group">
							<label for="">Altura (cm)</label> <input type="text"
								class="form-control" placeholder="Insira a sua altura (cm)">
						</div>
						<div class="form-group">
							<label for="inputZip">Peso (kg)</label> <input type="text"
								class="form-control" placeholder="Insira o seu peso (kg)">
						</div>
						<div class="form-group">
							<label for="">Telefone</label> <input type="tel"
								class="form-control" placeholder="Telefone para Contato">
						</div>
						<div class="form-group">
							<label for="">Gênero</label> <select class="form-control">
								<option selected>Escolha...</option>
								<option>...</option>
								<option>...</option>
								<option>...</option>
							</select>
						</div>
						<div class="form-group">
							<label for="">Data de Nascimento</label> <input type="date"
								class="form-control"
								placeholder="Coloque a sua data de nascimento">
						</div>
						<div class="form-group">
							<small>Já possui uma conta? <a href="login.jsp">Acesse
									o painel</a>.
							</small>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary" data-toggle="modal"
						data-target="#modalCadastro" data-dismiss="modal">Voltar</button>
					<a href="home.html" class="btn cor-botao text-light">Inscrever-se</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>