<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
            <c:if test="${not empty msg }">
              <div class="alert alert-success">${msg}</div>
            </c:if>
            <c:if test="${not empty err }">
              <div class="alert alert-danger">${err}</div>
            </c:if>
          <ol class="breadcrumb mb-4">
            <li class="breadcrumb-item"><a href="home.jsp">Dashboard</a></li>
            <li class="breadcrumb-item active">Gerenciar Press�o Arterial</li>
          </ol>
          <div class="card mb-4">
            <div class="card-header cartao-titulo">
              <img src="resources/img/blood-pressure-black.svg" class="icone-pressao-arterial-preto"> Lista de Medi��es de Press�o
            </div>
            <div class="card-body">
              <div class="table-responsive text-center">
                <table class="table table-bordered" id="" width="100%" cellspacing="0">
                  <thead>
                    <tr>
                      <th>Data</th>
                      <th>Press�o arterial sist�lica</th>
                      <th>Press�o arterial diast�lica</th>
                      <th>A��es</th>
                    </tr>
                  </thead>
                  <tbody>
                    <c:forEach items="${bloodPressures}" var="bloodPressure">
                      <tr>
                        <td>${ bloodPressure.getDateTimePretty() }</td>
                        <td>${ bloodPressure.getSystolicValue() }</td>
                        <td>${ bloodPressure.getDiastolicValue() }</td>
                        <td class="border-right-0">
                          <c:url value="blood_pressure" var="link">
                            <c:param name="action" value="update"/>
                            <c:param name="id" value="${ bloodPressure.getId() }"/>
                          </c:url>
                          <a class="btn cor-botao" href="${ link }" role="button" data-toggle="modal" data-target="#modalPressao">
                            <i class="fas fa-edit"></i>						  
                          </a>
                        </td>
                        <td class="border-left-0">
                          <c:url value="blood_pressure" var="link">
                            <c:param name="action" value="delete"/>
                            <c:param name="id" value="${ bloodPressure.getId() }"/>
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
              <a href="#" data-toggle="modal" data-target="#modalPressao" class="btn cor-botao">Adicionar</a>
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
