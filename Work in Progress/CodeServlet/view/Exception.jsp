<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isErrorPage="true"%>
<jsp:include page="Header.jsp">
	<jsp:param name="pageTitle" value="Errore" />
</jsp:include>


<div id="pagina">
	<div class="container-fluid">
		<div class="row">
			<label>Errore!</label>
			<section>
				
				<h4><%= exception.getMessage() %></h4>
				<a href="BaseServlet"><span
				class="glyphicon glyphicon-arrow-left" aria-hidden="true"></span>&#160;&#160;Clicca
				qui per tornare alla home!</a>
			</section>

			
		</div>
	</div>
</div>



<%@include file="Footer.html"%>