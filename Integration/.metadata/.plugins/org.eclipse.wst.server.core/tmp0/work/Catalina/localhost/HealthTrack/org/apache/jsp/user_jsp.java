/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.39
 * Generated at: 2020-11-06 01:03:55 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class user_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(5);
    _jspx_dependants.put("/footer.jsp", Long.valueOf(1604619995508L));
    _jspx_dependants.put("/menu-aside.jsp", Long.valueOf(1604623433422L));
    _jspx_dependants.put("/user-modal.jsp", Long.valueOf(1604619995559L));
    _jspx_dependants.put("/menu-top.jsp", Long.valueOf(1604619995511L));
    _jspx_dependants.put("/header.jsp", Long.valueOf(1604619995509L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"ISO-8859-1\">\r\n");
      out.write("<title>Usuário</title>\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"ISO-8859-1\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"resources/css/bootstrap/bootstrap.min.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"resources/css/index.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.7.0/css/all.css\" integrity=\"sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ\" crossorigin=\"anonymous\">\r\n");
      out.write("<link href=\"https://fonts.googleapis.com/css2?family=Roboto+Slab:wght@500&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<main class=\"d-flex\" id=\"recolhe-menu\">\r\n");
      out.write("\r\n");
      out.write("\t\t<!-- Menu Lateral -->\r\n");
      out.write("\t\t");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"ISO-8859-1\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<aside class=\"cor-especial border-right\" id=\"menu-lateral\">\r\n");
      out.write("\t\t<div class=\"menu-lateral-posicao\">\r\n");
      out.write("\t\t\t<div class=\"text-center\">\r\n");
      out.write("\t\t\t\t<p class=\"titulo-menu-lateral\">\r\n");
      out.write("\t\t\t\t\t<i class=\"icones-cabecalho fas fa-heartbeat\"></i> Health Track\r\n");
      out.write("\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t<img src=\"resources/img/avatar.png\"\r\n");
      out.write("\t\t\t\t\tclass=\"img-fluid p-1 rounded-circle\" alt=\"Foto do Usuário\">\r\n");
      out.write("\t\t\t\t<p>Nome do Usuário</p>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<ul class=\"list-group list-group-flush\">\r\n");
      out.write("\t\t\t<li><a href=\"home.jsp\"\r\n");
      out.write("\t\t\t\tclass=\"lista-lateral cor-especial list-group-item\"> <i\r\n");
      out.write("\t\t\t\t\tclass=\"icones-menu-lateral fas fa-home\"></i>\r\n");
      out.write("\t\t\t\t\t<p>Dashboard</p>\r\n");
      out.write("\t\t\t</a></li>\r\n");
      out.write("\t\t\t<li><a href=\"user.jsp\"\r\n");
      out.write("\t\t\t\tclass=\"lista-lateral cor-especial list-group-item\"> <i\r\n");
      out.write("\t\t\t\t\tclass=\"icones-menu-lateral fas fa-user\"></i>\r\n");
      out.write("\t\t\t\t\t<p>Perfil</p>\r\n");
      out.write("\t\t\t</a></li>\r\n");
      out.write("\t\t\t<li><a href=\"weight.jsp\"\r\n");
      out.write("\t\t\t\tclass=\"lista-lateral cor-especial list-group-item\"> <i\r\n");
      out.write("\t\t\t\t\tclass=\"icones-menu-lateral fas fa-weight\"></i>\r\n");
      out.write("\t\t\t\t\t<p>Gerenciar Peso</p>\r\n");
      out.write("\t\t\t</a></li>\r\n");
      out.write("\t\t\t<li><a href=\"blood-pressure.jsp\"\r\n");
      out.write("\t\t\t\tclass=\"lista-lateral cor-especial list-group-item\"> <img\r\n");
      out.write("\t\t\t\t\tsrc=\"resources/img/blood-pressure-white.svg\"\r\n");
      out.write("\t\t\t\t\tclass=\"icone-pressao-arterial-branco\">\r\n");
      out.write("\t\t\t\t\t<p>Gerenciar Pressão Arterial</p>\r\n");
      out.write("\t\t\t</a></li>\r\n");
      out.write("\t\t\t<li><a href=\"physical-activity.jsp\"\r\n");
      out.write("\t\t\t\tclass=\"lista-lateral cor-especial list-group-item\"> <i\r\n");
      out.write("\t\t\t\t\tclass=\"icones-menu-lateral fas fa-dumbbell\"></i>\r\n");
      out.write("\t\t\t\t\t<p>Gerenciar Atividades</p>\r\n");
      out.write("\t\t\t</a></li>\r\n");
      out.write("\t\t\t<li><a href=\"food.jsp\"\r\n");
      out.write("\t\t\t\tclass=\"lista-lateral cor-especial list-group-item\"> <i\r\n");
      out.write("\t\t\t\t\tclass=\"icones-menu-lateral fas fa-drumstick-bite\"></i>\r\n");
      out.write("\t\t\t\t\t<p>Gerenciar Alimentos</p>\r\n");
      out.write("\t\t\t</a></li>\r\n");
      out.write("\t\t\t<li><a href=\"meal.jsp\"\r\n");
      out.write("\t\t\t\tclass=\"lista-lateral cor-especial list-group-item\"> <i\r\n");
      out.write("\t\t\t\t\tclass=\"icones-menu-lateral fas fa-utensils\"></i>\r\n");
      out.write("\t\t\t\t\t<p>Gerenciar Refeições</p>\r\n");
      out.write("\t\t\t</a></li>\r\n");
      out.write("\t\t\t<li><a href=\"bmi.jsp\"\r\n");
      out.write("\t\t\t\tclass=\"lista-lateral cor-especial list-group-item\"> <i\r\n");
      out.write("\t\t\t\t\tclass=\"icones-menu-lateral fas fa-calculator\"></i>\r\n");
      out.write("\t\t\t\t\t<p>Calcular IMC</p>\r\n");
      out.write("\t\t\t</a></li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t</aside>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("\t\t<!-- Fim Menu Lateral -->\r\n");
      out.write("\r\n");
      out.write("\t\t<!-- Conteúdo da Página -->\r\n");
      out.write("\t\t<section id=\"conteudo-pagina\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t<!-- Menu para deslogar -->\r\n");
      out.write("\t\t\t");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"ISO-8859-1\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<header>\r\n");
      out.write("\t\t<nav\r\n");
      out.write("\t\t\tclass=\"navbar navbar-expand-lg navbar-light cor-especial border-bottom\">\r\n");
      out.write("\t\t\t<button class=\"btn cor-botao border\" id=\"botao-recolhe\">\r\n");
      out.write("\t\t\t\t<i class=\"icones-cabecalho fas fa-bars\"></i>\r\n");
      out.write("\t\t\t</button>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<button class=\"navbar-toggler cor-botao border\" type=\"button\"\r\n");
      out.write("\t\t\t\tdata-toggle=\"collapse\" data-target=\"#menu-deslogar\"\r\n");
      out.write("\t\t\t\taria-controls=\"menu-deslogar\" aria-expanded=\"false\"\r\n");
      out.write("\t\t\t\taria-label=\"Toggle navigation\">\r\n");
      out.write("\t\t\t\t<i class=\"icones-cabecalho fas fa-sign-out-alt\"></i>\r\n");
      out.write("\t\t\t</button>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div class=\"collapse navbar-collapse\" id=\"menu-deslogar\">\r\n");
      out.write("\t\t\t\t<ul class=\"navbar-nav ml-auto mt-2 mt-lg-0\">\r\n");
      out.write("\t\t\t\t\t<li class=\"nav-item dropdown\"><a\r\n");
      out.write("\t\t\t\t\t\tclass=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\"\r\n");
      out.write("\t\t\t\t\t\trole=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\"\r\n");
      out.write("\t\t\t\t\t\taria-expanded=\"false\"> <i class=\"icones-cabecalho fas fa-user\"></i>\r\n");
      out.write("\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"dropdown-menu dropdown-menu-right\"\r\n");
      out.write("\t\t\t\t\t\t\taria-labelledby=\"navbarDropdown\">\r\n");
      out.write("\t\t\t\t\t\t\t<a class=\"dropdown-item\" href=\"login.html\">Deslogar</a>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</nav>\r\n");
      out.write("\t</header>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("\t\t\t<!-- Fim Menu para Deslogar -->\r\n");
      out.write("\r\n");
      out.write("\t\t\t<!-- Conteúdo Principal -->\r\n");
      out.write("\t\t\t<div class=\"container-fluid\">\r\n");
      out.write("\t\t\t\t<h1 class=\"mt-4\">Perfil</h1>\r\n");
      out.write("\t\t\t\t<ol class=\"breadcrumb mb-4\">\r\n");
      out.write("\t\t\t\t\t<li class=\"breadcrumb-item\"><a href=\"home.jsp\">Dashboard</a></li>\r\n");
      out.write("\t\t\t\t\t<li class=\"breadcrumb-item active\">Perfil</li>\r\n");
      out.write("\t\t\t\t</ol>\r\n");
      out.write("\t\t\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t\t\t<div class=\"row justify-content-left\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"card mb-4\" style=\"max-width: 1024px;\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"row no-gutters\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"col-md-4\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"text-center\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<img src=\"resources/img/avatar.png\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tclass=\"img-fluid p-1 rounded-circle\" alt=\"Foto do Usuário\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<h6>Coloque uma foto...</h6>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"custom-file ml-3 overlay\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"file\" class=\"custom-file-input\" id=\"customFile\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\tname=\"filename\"> <label\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\tclass=\"custom-file-label mr-4 text-left\" for=\"customFile\"></label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"row m-3 text-center\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<button type=\"button\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tclass=\"btn mr-2 mb-2 btn-block cor-botao icones-menu-lateral\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tdata-toggle=\"modal\" data-target=\"#modalPerfil\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<i class=\"fas fa-edit\"></i> Editar Dados\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"col-md-8\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"card-body\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<h5 class=\"card-title cor-especial cartao-titulo-perfil\">Dados\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tUsuário</h5>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"col-md-6\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<label>ID do Usuário</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"col-md-6\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<p>XXXXXXXXXXXXXXXXX</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"col-md-6\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<label>Nome</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"col-md-6\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<p>Nome do Usuário</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"col-md-6\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<label>Email</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"col-md-6\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<p>email@email.com</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"col-md-6\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<label>Telefone</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"col-md-6\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<p>(XX) XXXXX - XXXX</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<p class=\"card-text\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<small class=\"text-muted\">Última atualização foi a 3\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tminutos atrás</small>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<h5 class=\"card-title cor-especial cartao-titulo-perfil\">Informações\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tdo Usuário</h5>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"col-md-6\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<label>Sexo</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"col-md-6\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<p>Lorem ipsum dolor sit amet</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"col-md-6\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<label>Nascimento</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"col-md-6\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<p>XX/XX/XXXX</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"col-md-6\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<label>Altura</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"col-md-6\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<p>XX,X m ou XXX cm</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"col-md-6\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<label>Peso</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"col-md-6\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<p>XX,X kg</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<h5 class=\"card-title cor-especial cartao-titulo-perfil\">Nível\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tde Atividade</h5>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"row justify-content-center\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"col-md-4\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<button type=\"button\" class=\"btn mr-3 mb-2 cor-botao\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<i class=\"fas fa-male\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<span>Sedentário</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"col-md-4\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<button type=\"button\" class=\"btn mr-3 mb-2 btn-primary\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<i class=\"fas fa-walking\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<span>Pouco Ativo</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"col-md-4\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<button type=\"button\" class=\"btn mr-3 mb-2 btn-primary\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<i class=\"fas fa-running\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<span>Muito Ativo</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<!-- Fim Conteúdo Principal -->\r\n");
      out.write("\r\n");
      out.write("\t\t</section>\r\n");
      out.write("\t\t<!-- Fim Contéudo da Página -->\r\n");
      out.write("\t</main>\r\n");
      out.write("\r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"ISO-8859-1\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <script src=\"resources/js/jquery.min.js\"></script>\r\n");
      out.write("    <script src=\"resources/js/bootstrap/bootstrap.min.js\"></script>    \r\n");
      out.write("    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("    <script src=\"resources/js/javascript.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<!-- Modal Usuário -->\r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"ISO-8859-1\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"modal fade\" id=\"modalPerfil\" data-backdrop=\"static\"\r\n");
      out.write("\t\ttabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\"\r\n");
      out.write("\t\taria-hidden=\"true\">\r\n");
      out.write("\t\t<div class=\"modal-dialog\">\r\n");
      out.write("\t\t\t<div class=\"modal-content\">\r\n");
      out.write("\t\t\t\t<div class=\"modal-header\">\r\n");
      out.write("\t\t\t\t\t<h5 class=\"modal-title\" id=\"modalPerfil\">Editar Dados</h5>\r\n");
      out.write("\t\t\t\t\t<button type=\"button\" class=\"close\" data-dismiss=\"modal\"\r\n");
      out.write("\t\t\t\t\t\taria-label=\"Close\">\r\n");
      out.write("\t\t\t\t\t\t<span aria-hidden=\"true\">&times;</span>\r\n");
      out.write("\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"modal-body\">\r\n");
      out.write("\t\t\t\t\t<form>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"\">Nome do Usuário</label> <input type=\"text\" name=\"\"\r\n");
      out.write("\t\t\t\t\t\t\t\tid=\"\" class=\"form-control\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"\">Email</label> <input type=\"email\" name=\"\" id=\"\"\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"form-control\">\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"\">Telefone</label> <input type=\"tel\" name=\"\" id=\"\"\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"form-control\" placeholder=\"Telefone para Contato\">\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"\">Peso</label> <input type=\"text\" name=\"\" id=\"\"\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"form-control\">\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"\">Altura</label> <input type=\"text\" name=\"\" id=\"\"\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"form-control\">\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"\">Sexo</label> <select name=\"\" id=\"\"\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"form-control\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<option selected>Escolha...</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t<option>...</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t<option>...</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t<option>...</option>\r\n");
      out.write("\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"modal-footer\">\r\n");
      out.write("\t\t\t\t\t<button type=\"button\" class=\"btn btn-secondary\"\r\n");
      out.write("\t\t\t\t\t\tdata-dismiss=\"modal\">Fechar</button>\r\n");
      out.write("\t\t\t\t\t<button type=\"button\" class=\"btn btn-primary\">Atualizar</button>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("\t<!-- Fim Modal  -->\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
