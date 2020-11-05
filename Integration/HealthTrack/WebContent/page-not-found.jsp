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
			 <div class="container-fluid text-center mt-4">
			  <img src="resources/img/page-not-found2-404.png">
                <h1 class="mt-4">Oopss... P�gina N�o Encontrada...</h1>
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
