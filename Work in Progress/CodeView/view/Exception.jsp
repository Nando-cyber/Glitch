<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isErrorPage="true"%>
<jsp:include page="Header.jsp">
	<jsp:param name="pageTitle" value="Errore"/>
</jsp:include>

<div class="main-container">
 <div class="container-fluid">
 	 <div class="col-sm-12 col-md-12 col-lg-12 item">
		<section class="testoCar">
			<h1><%= exception.getMessage() %></h1>
			<a href="BaseServlet" style="font-size: 1.5 vw"><span class="glyphicon glyphicon-arrow-left" aria-hidden="true"></span>&#160;&#160;Torna alla Home</a>
		</section>
	 </div>
   </div>
</div>
	
<%@include file="Footer.html"%>