<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<header>
		<nav
			class="navbar navbar-expand-lg navbar-light cor-especial border-bottom">
			<button class="btn cor-botao border" id="botao-recolhe">
				<i class="icones-cabecalho fas fa-bars"></i>
			</button>

			<button class="navbar-toggler cor-botao border" type="button"
				data-toggle="collapse" data-target="#menu-deslogar"
				aria-controls="menu-deslogar" aria-expanded="false"
				aria-label="Toggle navigation">
				<i class="icones-cabecalho fas fa-sign-out-alt"></i>
			</button>

			<div class="collapse navbar-collapse" id="menu-deslogar">
				<ul class="navbar-nav ml-auto mt-2 mt-lg-0">
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false"> <i class="icones-cabecalho fas fa-user"></i>
					</a>
						<div class="dropdown-menu dropdown-menu-right"
							aria-labelledby="navbarDropdown">
							<a class="dropdown-item" href="login.html">Deslogar</a>
						</div>
					</li>
				</ul>
			</div>
		</nav>
	</header>
</body>
</html>