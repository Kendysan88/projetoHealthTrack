<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

      <!-- Conteï¿½do da Pï¿½gina -->
      <section id="conteudo-pagina">

        <!-- Menu para deslogar -->
        <%@ include file="menu-top.jsp"%>
        <!-- Fim Menu para Deslogar -->

        <!-- Conteï¿½do Principal -->
        <div class="container-fluid">
          <h1 class="mt-4">Gerenciar Alimentos</h1>
          	<c:if test="${not empty msg }">
				<div class="alert alert-success">${msg}</div>
			</c:if>
			<c:if test="${not empty err }">
				<div class="alert alert-danger">${err}</div>
			</c:if>
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
                      <th>Descrição</th>
                      <th>Tipo de Medida</th>
                      <th>Quantidade</th>
                      <th>Calorias</th>
                      <th colspan="2">Ações</th>
                    </tr>
                  </thead>

                  <tbody>
                  	<c:forEach items="${foods}" var="food">
                  	  <tr>
                        <td>${ food.getName() }</td>
                        <td>${ food.getDescription() }</td>
                        <td>${ food.getAmountPretty() }</td>
                        <td>${ food.getAmount() }</td>
                        <td>${ food.getCaloriesPretty() }</td>
                        <td class="border-right-0">
                          <button type="button" class="btn cor-botao" data-toggle="modal" data-target="#modalAlimento">
                            <i class="fas fa-edit"></i>
                          </button>
                        </td>
                        <td class="border-left-0">
                          <c:url value="food" var="link">
							<c:param name="action" value="delete"/>
							<c:param name="id" value="${ food.getId() }"/>
						  </c:url>
						  <a class="btn btn-danger" href="${ link }" role="button">
						    <i class="fas fa-trash"></i>						  
						  </a>
                        </td>
                      </tr>
                  	</c:forEach>
                  </tbody>
                </table>
              </div>
            </div>
            <div class="card-body">
              <a href="#" data-toggle="modal" data-target="#modalAlimento" class="btn cor-botao">Adicionar</a>
            </div>
          </div>
        </div>

        <!-- Fim Conteï¿½do Principal -->

      </section>
      <!-- Fim Contï¿½udo da Pï¿½gina -->
    </main>

    <%@ include file="footer.jsp"%>

    <!-- Modal Alimentos -->
    <%@ include file="food-modal.jsp"%>
    <!-- Fim Modal Alimentos -->
  </body>
</html>
