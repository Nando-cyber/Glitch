<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="Header.jsp">
	<jsp:param name="pageTitle" value="Home"/>
</jsp:include>


<div id="pagina">
	<div>
		<h1>Gestore catalogo</h1>
	</div><br>
	<div>
		<div class="table-responsive">
    		<h3>Lista Offerte</h3>
				<table class="table table-striped table-hover my-5">
					<thead>
						<tr>
							<th>Codice</th>
							<th>Nome/Modello</th>
							<th>Prezzo</th>
							<th>Offerta</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${Consoles}" var="console">
						<td><c:out value="${console.id}"/></td>
						<td><c:out value="${console.modello}"/></td>
		                <td><c:out value="${console.prezzo}"/></td>
		                <td>
		                	<button type="submit">Aggiungi</button>
		                </td>	
						<c:forEach items="${Videogiochi}" var="videogiochi">
							<tr class="text-center">
								<td><c:out value="${videogiochi.id}"/></td>
								<td><c:out value="${videogiochi.nome}"/></td>
		                  		<td><c:out value="${videogiochi.prezzo}"/></td>	
		                  		<td>
		                  			<button type="submit">Aggiungi</button>
		                  		</td>							
							</tr>
						</c:forEach>
					</c:forEach>
					</tbody>
				</table>
    	</div>

	<div class="container" style="background-color: #ffffff;">
		<h2
			style="margin: 15px; margin-top: 8%; background-color: rgba(251, 251, 251, 0);">Gestione
			offerte</h2>
	</div>
	<div class="container" style="color: rgb(255, 255, 255);">
		<div class="col-lg-11 offset-lg-1" id="agg-videogioco"
			style="width: 100%;">
			<form id="tex-fo">
				<h4 class="text-center d-lg-flex justify-content-lg-center"
					style="color: rgb(0, 0, 0);">Inserisci nuova offerta</h4>
				<div class="form-group">
					<input class="form-control" type="text"
						style="font-family: Barlow, sans-serif;" placeholder="Nome" />
				</div>
				<div class="form-group">
					<input class="form-control" type="text"
						style="font-family: Barlow, sans-serif;"
						placeholder="Percentuale sconto" />
				</div>
				<div class="form-group">
					<input class="form-control" type="text"
						style="font-family: Barlow, sans-serif;" placeholder="Categoria" />
				</div>
				<div id="button-c-c">
					<button class="btn float-right" id="button-c" type="button"
						style="background-color: rgb(173, 38, 220);">Applica
						offerta</button>
				</div>
			</form>
		</div>
	</div>
	
	
</div>
</div>



<%@include file="Footer.html" %> 