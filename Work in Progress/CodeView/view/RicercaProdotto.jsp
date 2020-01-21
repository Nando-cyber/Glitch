<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="Header.jsp">
	<jsp:param name="pageTitle" value="RicercaServlet"/>
</jsp:include>
 
 <div id="pagina">
 	<div class="container-fluid">
 		<div class="col-sm-12 ">
 			<h1>Risultato ricerca</h1>
 			<hr>
 				<c:if test="${ricerca == 'Videogioco'}">
 					<div >
            		<div class="col-md-6 col-xs-6">
               			<a href="${ricerca.immagine}" target="_blank">
               				<img src="${ricerca.immagine}" alt="${ricerca.nome}">
               			</a>          
            		</div>
            		<div class="padding-txt col-md-6 col-xs-6">
                 		<label><c:out value="${ricerca.nome}" /></label><br>
                 		<label><c:out value="${ricerca.genere}" /></label><br>
                 		<label><c:out value="${ricerca.prezzo}" />€</label><br>
                 		<label><c:out value="${ricerca.descrizione}" /></label><br>
                 		<c:choose>
                 			<c:when test="${utente == null}">
                 				<form>
									<input type="hidden" name="prodId" value="${ricerca.id}">
									<input type="submit" class="bottone not-allowed" value="Aggiungi al carrello" disabled="disabled">  
                 				</form>
                 			</c:when>
                 		<c:otherwise>
                 			
                 		</c:otherwise>
                 		</c:choose>           
             		</div>
         		</div>
   				</c:if>
 				<c:if test="${ricerca == 'Console'}">
 					<div class="row" style="padding-top: 40px">
            			<div class="col-md-6 col-xs-6">
               				<a href="${ricerca.immagine}" target="_blank">
               					<img id="myImg" src="${ricerca.immagine}" alt="${ricerca.modello}">
               				</a>
            			</div>
            			<div class="padding-txt col-md-6 col-xs-6">
                 			<label><c:out value="${ricerca.modello}" /></label><br>
                 			<label><c:out value="${ricerca.produttore}" /></label><br>
                 			<label><c:out value="${ricerca.prezzo}" />€</label><br>
                 			<label><c:out value="${ricerca.descrizione}" /></label><br>
                 			<c:choose>
                 			<c:when test="${utente == null}">
                 				<form>
									<input type="hidden" name="prodId" value="${ricerca.codice}">
									<input type="submit" class="bottone not-allowed" value="Aggiungi al carrello" disabled="disabled">  
                 				</form>
                 			</c:when>
                 			<c:otherwise>
                 				


                 			</c:otherwise>
                 			</c:choose>           
             			</div>
         			</div>
   					</c:if>
   			</div>
   			<div class="col-md-12 col-xs-12">	
   			<c:if test="${ricerca == null}">
				<div style="padding: 20%">
					<h2>Siamo spiacenti. Non abbiamo prodotti con questo nome.</h2>
					<img alt="gameOver" style="max-width: 100%"
						src="https://cdn5.vectorstock.com/i/1000x1000/94/64/game-over-games-screen-glitch-computer-video-vector-22579464.jpg"><br><br>
					<a href="BaseServlet">Torna alla Home a dare uno sguardo</a><br>
				</div>
   			</c:if>
		</div>
	</div>
</div>
		
		
		
<%@include file="Footer.html"%>