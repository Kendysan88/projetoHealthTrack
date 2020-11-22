<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1">
    <title>Peso</title>
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
        <h1 class="mt-4">Gerenciar Peso</h1>
          <c:if test="${not empty msg }">
            <div class="alert alert-success">${msg}</div>
          </c:if>
          <c:if test="${not empty err }">
            <div class="alert alert-danger">${err}</div>
          </c:if>
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
              <table class="table table-bordered" id="" width="100%" cellspacing="0">
                <thead>
                  <tr>
                    <th>Data</th>
                    <th>Peso</th>
                    <th>Ações</th>
                  </tr>
                </thead>
                <tbody>
                  <c:forEach items="${weights}" var="weight">
                    <tr>
                      <td>${ weight.getDateTimePretty() }</td>
                      <td>${ weight.getValuePretty() }</td>
                      <td class="border-right-0">
                        <c:url value="weight" var="link">
                          <c:param name="action" value="update"/>
                          <c:param name="id" value="${ weight.getId() }"/>
                        </c:url>
                        <a class="btn cor-botao" href="${ link }" role="button" data-toggle="modal" data-target="#modalPressao">
                          <i class="fas fa-edit"></i>						  
                        </a>
                      </td>
                      <td class="border-left-0">
                        <c:url value="weight" var="link">
                          <c:param name="action" value="delete"/>
                          <c:param name="id" value="${ weight.getId() }"/>
                        </c:url>
                        <a class="btn btn-danger" href="${ link }" role="button">
                          <i class="fas fa-trash"></i>						  
                        </a>
                      </td>

                      <td>
                        <button type="button" class="btn m-2 cor-botao" data-target="#modalPeso" data-toggle="modal">
                          <i class="fas fa-edit"></i>
                        </button>
                        <button type="button" class="btn m-2 btn-danger">
                          <i class="fas fa-trash"></i>
                        </button>
                      </td>
                    </tr>
                  </c:forEach>
                </tbody>
              </table>
            </div>
          </div>
          <div class="card-body">
            <a href="#" data-toggle="modal" data-target="#modalPeso" class="btn cor-botao">Adicionar</a>
          </div>
        </div>
      </div>

    <!-- Fim Conteúdo Principal -->
    </section>
  <!-- Fim Contéudo da Página -->
  </main>

  <%@ include file="footer.jsp"%>

  <!-- Modal XXXXXXXXX -->
  <%@ include file="weight-modal.jsp"%>
  <!-- Fim XXXXXXXXXXX -->
  </body>
</html>