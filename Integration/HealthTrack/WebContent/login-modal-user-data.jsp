<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="modal fade" id="modalCadastro" data-backdrop="static"
		tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
		aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="modalCadastro">Criar Conta</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<ul
						class="nav mb-2 nav-pills flex-column flex-sm-row justify-content-center">
						<li class="nav-item"><a class="nav-link cor-botao rounded"
							href="#"><span class="badge badge-dark">1</span> Dados do
								Usu�rio</a></li>
						<li class="nav-item"><a class="nav-link" href="#"
							data-toggle="modal" data-target="#modalCadastro2"
							data-dismiss="modal"><span class="badge badge-dark">2</span>
								Informa��es do Usu�rio</a></li>
					</ul>
					<form>
						<div class="form-group">
							<label for="">Nome do Usu�rio</label> <input type="text"
								class="form-control" placeholder="Insira o seu nome">
						</div>
						<div class="form-group">
							<label for="">Email</label> <input type="email"
								class="form-control" placeholder="Insira um email v�lido">
						</div>
						<div class="form-group">
							<label for="">Senha</label> <input type="password"
								class="form-control" placeholder="Crie uma senha">
						</div>
						<div class="form-group">
							<label for="">Confirme a senha</label> <input type="password"
								class="form-control" placeholder="Confirme a sua senha">
						</div>
						<div class="form-group">
							<small>J� possui uma conta? <a href="login.jsp">Acesse
									o painel</a>.
							</small>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn cor-botao btn-block"
						data-toggle="modal" data-target="#modalCadastro2"
						data-dismiss="modal">Pr�ximo</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>