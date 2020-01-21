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
    		<h3>Lista Console</h3>
				<table class="table table-striped table-hover my-5">
					<thead>
						<tr>
							<th>Codice</th>
							<th>Modello</th>
							<th>Produttore</th>
							<th>Prezzo</th>
							<th>Rimozione</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${Consoles}" var="console">
							<tr class="text-center">
								<td><c:out value="${console.id}"/></td>
								<td><c:out value="${console.modello}"/></td>
								<td><c:out value="${console.casaProduttrice}"/></td>
		                  		<td><c:out value="${console.prezzo}"/></td>
		                  		<td>
		                  			<button type="submit">Rimuovi</button>
		                  		</td>
							</tr>
					</c:forEach>
					</tbody>
				</table>
				
    		<h3>Lista Videogiochi</h3>
				<table class="table table-striped table-hover my-5">
					<thead>
						<tr>
							<th>Codice</th>
							<th>Nome</th>
							<th>Genere</th>
							<th>Prezzo</th>
							<th>Rimozione</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${Videogiochi}" var="videogiochi">
							<tr class="text-center">
								<td><c:out value="${videogiochi.id}"/></td>
								<td><c:out value="${videogiochi.nome}"/></td>
								<td><c:out value="${videogiochi.genere}"/></td>
		                  		<td><c:out value="${videogiochi.prezzo}"/></td>
		                  		<td>
		                  			<button type="submit">Rimuovi</button>
		                  		</td>
							</tr>
					</c:forEach>
					</tbody>
				</table>
    	</div>
	
	</div>
	
	<div class="container-fluid">
		<h3>Nuovi prodotti</h3>
	</div><br>
	<div class="container-fluid">
		<a class="text-left" href="#agg-console" style="background-color: #ffffff; color: rgb(18, 10, 10);">
			<i class="fa fa-plus-circle" style="color: rgb(31, 133, 54);"></i> Aggiungi console</a>
	</div>
	<div class="container-fluid">
		<a class="text-left" href="#agg-videogioco"
			style="background-color: #ffffff; color: rgb(18, 10, 10);"><i
			class="fa fa-plus-circle" style="color: rgb(31, 133, 54);"></i>
			 Aggiungi  videogioco</a>
	</div>
	<div class="container-fluid">
		<div class="col-lg-10 offset-lg-1" id="agg-console" style="width: 100%;">
			<form id="tex-fo">
				<h4 class="text-center d-lg-flex justify-content-lg-center">Console</h4>
				<div class="form-group">
					<input class="form-control" type="text" placeholder="Modello" />
				</div>
				<div class="form-group">
					<input class="form-control" type="text" placeholder="Casa produttrice" />
				</div>
				<div class="form-group">
					<input class="form-control" type="text" placeholder="Immagine" />
				</div>
				<div class="form-group">
					<input class="form-control" type="text" placeholder="Prezzo" />
				</div>
				<div class="form-group" id="tex-fo">
					<textarea class="form-control" placeholder="Descrizione"></textarea>
				</div>
				<div id="button-c-c">
					<button class="btn float-right" id="button-c" type="button" 
					style="background-color: rgb(173, 38, 220);">inserisci console</button>
				</div>
			</form>
		</div>
		<div class="col-lg-11 offset-lg-1" id="agg-videogioco" style="padding-top: 5%">
			<form id="tex-fo">
				<h4 class="text-center d-lg-flex justify-content-lg-center">Videogioco</h4>
				<div class="form-group">
					<input class="form-control" type="text" placeholder="Nome" />
				</div>
				<div class="form-group">
					<input class="form-control" type="text" placeholder="Genere" />
				</div>
				<div class="form-group">
					<input class="form-control" type="text" placeholder="Piattaforma" />
				</div>
				<div class="form-group">
					<input class="form-control" type="text" placeholder="Immagine" />
				</div>
				<div class="form-group">
					<input class="form-control" type="text" placeholder="Prezzo" />
				</div>
				<div class="form-group" id="tex-fo">
					<textarea class="form-control" placeholder="Descrizione"></textarea>
				</div>
				<div id="button-c-c">
					<button class="btn float-right" id="button-c" type="button"
						style="background-color: rgb(173, 38, 220);">inserisci Videogioco</button>
				</div>
			</form>
		</div>
	</div>
</div>



<%@include file="Footer.html" %> 