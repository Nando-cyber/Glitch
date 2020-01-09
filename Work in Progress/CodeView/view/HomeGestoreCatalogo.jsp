<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="Header.jsp">
	<jsp:param name="pageTitle" value="Home"/>
</jsp:include>


<div class="container">
	<div class="intro">
		<h2 class="text-center">Prodotti in evidenza</h2>
		<p class="text-center">In anteprima per gli utenti di Glitch tutte
			le nuove uscite del 2020 presenti sul mercato</p>
	</div>
	<div class="row articles">
		<div class="col-sm-6 col-md-4 item" id="volantino">
			<a href="DB.jpg" data-lightbox="photos"><img class="img-fluid" src="DB.jpg" /></a>
			<h3 class="name"><br />
				<strong>Dragon Ball Z Kakarot</strong><br /><br />
			</h3>
			<p class="description">	<br />
				<strong>Piattaforme:</strong> PS4, Xbox One, PC Windows<br />
				<strong>Uscita</strong>: 17 gennaio 2020<br /><br />
			</p>
		</div>
		<div class="col-sm-6 col-md-4 item" id="volantino">
			<a href="DG.jpg" data-lightbox="photos"><img class="img-fluid" src="DG.jpg" /></a>
			<h3 class="name"><br />
				<strong>Darksiders Genesis</strong><br /><br />
			</h3>
			<p class="description">	<br />
				<strong>Piattaforme:</strong> PS4, Xbox One, Nintendo Switch<br />
				<strong>Uscita</strong>: 14 febbraio 2020<br /><br />
			</p>
		</div>
		<div class="col-sm-6 col-md-4 item" id="volantino">
			<a href="FF.jpg" data-lightbox="photos"><img class="img-fluid" src="FF.jpg" /></a>
			<h3 class="name"><br />
				<strong>Final Fantasy VII Remake</strong><br /><br />
			</h3>
			<p class="description">	<br />
				<strong>Piattaforme:</strong> PS4<br />
				<strong>Uscita</strong>: 3 marzo 2020<br /><br />
			</p>
		</div>
	</div>
</div>

<div class="features-boxed">
	<!-- Button per filtrare i prodotti del catalogo -->
	<div class="container text-monospace d-lg-flex justify-content-lg-center visible">
		<div role="group" class="btn-group">
			<button class="btn btn-primary" type="button">Catalogo</button>
			<button class="btn btn-primary" type="button">Console</button>
			<button class="btn btn-primary" type="button">Videogiochi</button>
		</div>
	</div>
	<div id="myCatalogo" class="container">
		<div class="intro"></div>
		<div class="row justify-content-center features">
		<!-- Due cicli per visualizzare sia i videogiochi sia le console -->
		 <c:forEach items="${videogiochi}" var="videogiochi">
			<div class="col-sm-6 col-md-5 col-lg-4 item">
				<div class="box">
					<img class="img-fluid" id="img-catalogo" src="${videogiochi.immagine}" />
					<h3 class="name"><c:out value="${videogiochi.nome}" /></h3>
					<p class="description"><c:out value="${videogiochi.genere}" /></p>
					<p class="description"><c:out value="${videogiochi.piattaforma}" /></p>
					<p class="description"><c:out value="${videogiochi.prezzo}" />€</p>
               		<form action=" ">
						<input type="hidden" name="videogiocoId" value="${videogiochi.codice}"><br>
						<input type="submit" class="bottone" value="Rimuovi prodotto">  
               		</form>	
				</div>
			</div>
		</c:forEach>
		<c:forEach items="${console}" var="videogiochi">
			<div class="col-sm-6 col-md-5 col-lg-4 item">
				<div class="box">
					<img class="img-fluid" id="img-catalogo" src="${console.immagine}" />
					<h3 class="name"><c:out value="${console.modello}" /></h3>
					<p class="description"><c:out value="${console.casaProduttrice}" /></p>
					<p class="description"><c:out value="${console.prezzo}" />€</p>     
                 	<form action=" ">
						<input type="hidden" name="consoleId" value="${console.codice}"><br>
						<input type="submit" class="bottone" value="Rimuovi prodotto">  
                 	</form>	
				</div>
			</div>
		</c:forEach>
		</div>
	</div>
	<div class="container" id="paginazione">
		<nav>
			<ul class="pagination">
				<li class="page-item"><a class="page-link" href="#" aria-label="Previous"><span aria-hidden="true">«</span></a></li>
				<li class="page-item"><a class="page-link" href="#">1</a></li>
				<li class="page-item"><a class="page-link" href="#">2</a></li>
				<li class="page-item"><a class="page-link" href="#">3</a></li>
				<li class="page-item"><a class="page-link" href="#">4</a></li>
				<li class="page-item"><a class="page-link" href="#">5</a></li>
				<li class="page-item"><a class="page-link" href="#" aria-label="Next"><span aria-hidden="true">»</span></a></li>
			</ul>
		</nav>
	</div>
</div>



<%@include file="Footer.html" %> 