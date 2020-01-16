<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="Header.jsp">
	<jsp:param name="pageTitle" value="Home"/>
</jsp:include>

<div class="article-list">
	<div class="container">
		<div class="intro">
			<h2 class="text-center">Richiedi assistenza</h2>
			<p class="text-center">Hai avuto un problema con una consegna? 
			Il tuo ordine non è arrivato o non era ciò che avevi richiesto?
			Siamo qui per rispondere a tutte le tue domande.</p>
		</div>
	</div>
	<div id="contatti" class="contact-clean">
		<form method="post">
			<h2 class="text-center">Contattaci</h2>
			<div class="form-group">
				<input class="form-control is-invalid" type="text" name="email"
					placeholder="Nome" />
			</div>
			<div class="form-group">
				<input class="form-control" type="email" name="message"
					placeholder="E-mail" rows="14" />
			</div>
			<div class="form-group">
				<textarea class="form-control" name="message"
					placeholder="Messaggio" rows="14"></textarea>
			</div>
			<div class="form-group">
				<button class="btn btn-primary" type="submit">invia</button>
			</div>
		</form>
	</div>
</div>



<%@include file="Footer.html" %>