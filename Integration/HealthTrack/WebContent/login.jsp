<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<%@ include file="header.jsp"%>
</head>
<body id="bodyLogin">
	<div class="card" id="card-tela-login">
		<div class="card-body">
			<h5 class="card-title text-center text-light cartao-texto">
				<i class="icones-login fas fa-heartbeat"></i> Health Track
			</h5>
			<form>
				<div class="form-group">
					<label for="">Email</label> <input type="email"
						class="form-control" placeholder="Insira o seu E-mail">
				</div>
				<div class="form-group">
					<label for="">Senha</label> <input type="password"
						class="form-control" placeholder="Insira a sua senha">
				</div>
				<div class="form-group form-check">
					<input type="checkbox" class="form-check-input"> <label
						class="form-check-label" for="exampleCheck1">Lembrar-me</label>
				</div>
				<a href="home.jsp" type="submit" class="btn mb-2 cor-botao">Entrar</a>
				<div class="form-group">
					<small>N�o possui uma conta? <a href="#"
						data-toggle="modal" data-target="#modalCadastro">Cadastra-se
							aqui</a>.
					</small>
				</div>
				<div class="form-group">
					<a href="home.jsp" class="btn btn-primary btn-block text-left"><i
						class="icones-login fab fa-facebook-square"></i> Entrar usando o
						Facebook</a>
				</div>
				<div class="form-group">
					<a href="home.jsp" class="btn btn-danger btn-block text-left"><i
						class="icones-login fab fa-google"></i> Entrar usando o Google</a>
				</div>
			</form>
		</div>
	</div>

	<!-- Modal Cadastro Usu�rio Dados  -->
	<%@ include file="login-modal-user-data.jsp"%>
	<!-- Fim do Modal Cadastro Usu�rio Dados -->

	<!-- Modal Cadastro Usu�rio Informa��es Pessoais -->
	<%@ include file="login-modal-user-info.jsp"%>
	<!-- Fim do Modal Modal Cadastro Usu�rio Informa��es Pessoais -->

	<script src="resources/js/jquery.min.js"></script>
	<script src="resources/js/bootstrap/bootstrap.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"
		crossorigin="anonymous"></script>
	<script src="resources/js/javascript.js"></script>
</body>
</html>