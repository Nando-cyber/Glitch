<%@ page session="true" language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no" />
	<title>GLITCH</title>
	<!-- link per i file css -->
	<link rel="stylesheet" href="styles.css">
	<link rel="stylesheet" href="footer.css">
	<!-- link per BOOTSRAP 4 -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
  	<!-- link SweetAlert2 -->
  	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
</head>


<body>
	<div>
		<nav
			class="navbar navbar-light navbar-expand-md navigation-clean-search">
			<div class="container-fluid">
				<img class="image-holder" src="GlitchLogo.png" style="width: 90px" />
				<button data-toggle="collapse" data-target="#navcol-3" class="navbar-toggler">
					<span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse image-holder" id="navcol-3" src="GlitchLogo.png">
					<ul class="nav navbar-nav">
						<li role="presentation" class="nav-item"><a class="nav-link"
							href="team.bsdesign">Chi siamo</a></li>
						<li role="presentation" class="nav-item"><a class="nav-link"
							href="#contatti">Contatti</a></li>
					</ul>
					<ul class="nav navbar-nav">
						<li role="presentation" class="nav-item"></li>
					</ul>
					<!-- Barra di ricerca -->
					<form class="form-inline mr-auto" target="_self">
						<div class="form-group">
							<label for="search-field"><span class="glyphicon glyphicon-search"></span></label>
							<input type="search" class="form-control search-field" id="search-field" name="cerca" />
						</div>
					</form>
					
					<!-- Opzioni per i vari tipi di utente del sito -->
					<c:choose>
						<c:when test="${utente == null}">
							<span class="navbar-text"><a class="login" href="#" data-toggle="modal" data-target="#myLogin">Accedi</a></span>
							<a class="btn btn-light action-button" role="button"
								data-toggle="modal" data-target="#myRegistrazione">Registrati</a>
						 </c:when>
						 <c:otherwise>		
							<c:if test="${ utente != null && utente.ruolo == null }">
								<div class="dropdown show d-lg-flex" style="margin: 0px; margin-right: 25px;">
									<a data-toggle="dropdown" aria-expanded="true" class="dropdown-toggle text-left" href="#"><i class="fa fa-user-circle"></i>Ciao, ${utente.cognome}</a>
									<div role="menu" class="dropdown-menu show">
										<a role="presentation" class="dropdown-item d-lg-flex" href="#">Pagina personale</a>
										<a role="presentation" class="dropdown-item" href="#">I miei ordini</a>
										<a role="presentation" class="dropdown-item" href="#">Le mie notifiche <span class="glyphicon glyphicon-comment"></span><span class="badge badge-notify">3</span></a>
										<a role="presentation" class="dropdown-item d-lg-flex" href="#">Logout</a>
									</div>
								</div>
								<a class="btn btn-light action-button" role="button" ><i class="fa fa-shopping-cart"></i>Carrello</a>
							</c:if>
      	
							<c:if test="${ utente.ruolo != null }">
								<div class="dropdown show d-lg-flex" style="margin: 0px; margin-right: 25px;">
									<a data-toggle="dropdown" aria-expanded="true" class="dropdown-toggle text-left" href="#"><i class="fa fa-user-circle"></i>Ciao, ${utente.cognome}</a>
									<div role="menu" class="dropdown-menu show">
										<a role="presentation" class="dropdown-item d-lg-flex" href="#">Pagina personale</a>
										<a role="presentation" class="dropdown-item" href="#">I miei ordini</a>
										<a role="presentation" class="dropdown-item" href="#">Le mie notifiche <span class="glyphicon glyphicon-comment"></span><span class="badge badge-notify">3</span></a>
										<c:if test="${ ruolo.isGestoreAccount }">
											<a role="presentation" class="dropdown-item d-lg-flex" href="#">Gestore catalogo</a></c:if>
										<c:if test="${ ruoloisGestoreCatalogo }">
											<a data-toggle="dropdown" aria-expanded="true" class="dropdown-toggle text-left" href="#">Gestore prodotti</a></c:if>
											<div role="menu" class="dropdown-menu show">
												<a role="presentation" class="dropdown-item" href="#">Gestione prodotti</a>
												<a role="presentation" class="dropdown-item" href="#">Gestione offeret</a>
											</div>
										<c:if test="${ ruolo.isGestoreAssistenza }">
											<a role="presentation" class="dropdown-item" href="#">Gestore assistenza</a></c:if>
										<a role="presentation" class="dropdown-item d-lg-flex" href="#">Logout</a>
									</div>
								</div>
								<a class="btn btn-light action-button" role="button" action=" "><i class="fa fa-shopping-cart"></i>Carrello</a>
							</c:if>
               			</c:otherwise>
					</c:choose>
				</div>
			</div>
		</nav>
	</div>

</body>
</html>