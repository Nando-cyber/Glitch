<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="Header.jsp">
	<jsp:param name="pageTitle" value="Home"/>
</jsp:include>


<div id="pagina" class="features-boxed" style="margin-top: 0px;">
	<div class="container">
		<h1 style="font-family: 'Arbutus Slab', serif; margin-top: 0px;">Carrello</h1>
	</div>
	<div class="container">
		<c:forEach items="${carrello.prodotti}" var="pc">
		<div class="row justify-content-center features" style="background-color: rgba(255, 255, 255, 0);">
			<div class="col d-sm-flex d-md-flex">
				<a href="${pc.prodotto.immagine}" data-lightbox="photos">
					<img class="img-fluid d-lg-flex justify-content-lg-start" id="img-carrello" src="${pc.prodotto.immagine}" />
				</a>
				<a href="${pc.prodotto.immagine}" data-lightbox="photos"></a>
				<c:if test="${pq.prodotto.classe == 'Videogioco'}">
					<label class="text-monospace border rounded-0 border-white d-sm-flex d-md-flex d-lg-flex justify-content-lg-center align-items-lg-start">
					${pq.prodotto.nome}</label>
            	</c:if>
            	<c:if test="${pq.prodotto.classe == 'Console'}">
               		<label class="text-monospace border rounded-0 border-white d-sm-flex d-md-flex d-lg-flex justify-content-lg-center align-items-lg-start">
					${pq.prodotto.modello}</label>
				</c:if>
				<label class="text-monospace text-center border rounded-0 border-white d-sm-flex d-md-flex d-lg-flex justify-content-lg-center align-items-lg-start">
					Prezzo: ${pc.prezzoTot} &euro;</label> 
				<form action=" " method="get">	
					<label class="text-monospace border rounded-0 border-white d-sm-flex d-md-flex d-lg-flex justify-content-lg-center align-items-lg-start">
					Quantità: <input type="hidden" name="prodId" value="${pc.prodotto.id}">
						<!-- <input class="form-control-sm d-sm-flex d-md-flex d-lg-flex" type="number" placeholder="1" min="1" max="50" value="1" />  -->
						<input type="number" name="quantita" value="${pc.quantita}" min="0" max="50" class="form-control-sm d-sm-flex d-md-flex d-lg-flex"> 
						<input type="submit" value="Aggiorna" class="bottone">
					</label>
				</form>
				<form action=" " method="get">
					<!-- <button class="btn btn-primary btn-sm d-sm-flex ml-auto" type="button">Rimuovi</button>  -->
					<input type="hidden" name="prodId" value="${pc.prodotto.id}">
					<input type="hidden" name="setNum" value="0">
					<input type="submit" value="Rimuovi" class="btn-default bottone">
				</form>
			</div>
		</div>
		<hr />
		</c:forEach>
	</div>
	<div class="container text-right">
		<button class="btn btn-primary" type="button"
			style="margin: 15px; background-color: rgb(215, 23, 104);">Acquista</button>
	</div>
	<!-- Carrello nel caso non vi siano inseriti prodotti -->
	<div class="container">
 		<c:if test="${empty carrello.prodotti}">
 			<div class="row">
				<section class="testoCar">
				<h2>Nessun articolo nel carrello</h2>
				<a href="BaseServlet" style="font-size: 1.5vw"><span class="glyphicon glyphicon-arrow-left" aria-hidden="true"></span>&#160;&#160;Torna alla Home per continuare il tuo Shopping</a>
			</section>
		</div>
 		</c:if>
 		<c:if test="${not empty carrello.prodotti}">
 			<div class="row">
				<h2 style="font-size: 2.5vw;">Totale: <c:out value="${carrello.prezzoTotProdotti}"></c:out> &euro;</h2>		
				<form action="CompletaAcquisto" method="get">
					<input type="submit" value="Completa acquisto" class="btn-default bottone">
				</form>
			</div>
 		</c:if>
 	</div>
</div>



<%@include file="Footer.html" %> 