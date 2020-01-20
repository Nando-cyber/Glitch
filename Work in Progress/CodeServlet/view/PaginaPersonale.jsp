<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="Header.jsp">
	<jsp:param name="pageTitle" value="Home"/>
</jsp:include>


<div class="article-list">
	<div class="container">
		<div class="intro">
			<h2 class="text-center">Pagina personale</h2>
		</div>
	</div>
	<div class="container">
		<h3>Modifica profilo</h3>
	</div>
	<div class="container">
		<div class="intro"></div>
	</div>
	<form action="GestioneProfiloServlet" method="post" style="width: 70%; padding: 20px; margin-left: 15%; background-color: #c8fcf8; margin-bottom: 5%;">
		<div class="form-group d-lg-flex justify-content-lg-start">
			<span><c:out value="${utente.nome}" /></span>
		</div>
		<div class="form-group d-lg-flex justify-content-lg-start">
			<span class="d-lg-flex justify-content-lg-start"><c:out value="${utente.cognome}" /></span>
		</div>
		<div class="form-group">
			<input class="form-control" type="email" name="email" placeholder="${utente.email}" />
		</div>
		<div class="form-group">
			<input class="form-control" type="text" name="citta" placeholder="${utente.citta}" />
		</div>
		<div class="form-group">
			<input class="form-control" type="text" name="provincia" placeholder="${utente.provincia}" />
		</div>
		<div class="form-group">
			<input class="form-control" type="text" name="via" placeholder="${utente.via}" />
		</div>
		<div class="form-group">
			<input class="form-control" type="text" name="numero" placeholder="${utente.numero}" />
		</div>
		<div class="form-group">
			<input class="form-control" type="text" name="CAP" placeholder="${utente.cap}" />
		</div>
		<div class="form-group">
			<span class="d-lg-flex justify-content-lg-start"><c:out value="${utente.username}" /></span>
		</div>
		<div class="form-group">
			<input class="form-control" type="password" name="password" placeholder="${utente.password}" />
		</div>
		<div class="container">
		<input type="hidden" name="operazione" value="modifica">
			<input class="btn btn-primary" type="submit"
				style="background-color: rgb(215, 23, 104);" value="Conferma modifiche" >
		</div>
	</form>
	<div class="container">
		<hr />
	</div>
	<div class="container">
		<h3 style="padding-top: 8%;">Rimuovi profilo</h3>
	</div>
	<div class="container" style="padding: 5%;">
	<form action="GestioneProfiloServlet" method="post" >
		<input type="hidden" name="operazione" value="rimozione">
		<input class="btn btn-primary" type="submit" value="Elimina profilo">
		</form>
	</div>
	<div class="container">
		<div class="intro"></div>
	</div>
	<div class="container">
		<div class="intro"></div>
	</div>
	<div class="container">
		<div class="intro"></div>
	</div>
</div>



<%@include file="Footer.html" %>