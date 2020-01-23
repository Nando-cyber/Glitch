<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="Header.jsp">
	<jsp:param name="pageTitle" value="Home"/>
</jsp:include>


<!-- Tabella che mostra la lista delle richieste di assistenza -->
<div class="article-list">
    <div class="container">
        <div class="intro">
            <h2 class="text-center">Gestione assistenza</h2>
        </div>
    </div>
    <div class="container text-monospace d-lg-flex justify-content-lg-center visible">
        <div class="table-responsive">
            <table class="table">
                <thead>
                    <tr style="background-color: #c4fff8;">
                        <th>E-MAIL UTENTE</th>
                        <th>E-MAIL DESTINATARIO</th>
                        <th>STATO E-MAIL</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${richiesta}" var="richiesta">
                    <tr>
                        <td><c:out value="${richiesta.utenteEmail}" /></td>
                        <td><c:out value="${richiesta.destinatario}" /></td>
                        <td><a href="#" style="color: rgb(0,0,0);"><c:out value="${richiesta.stato}" /></a></td>
                    </tr>
                 </c:forEach>  
                </tbody>
            </table>
        </div>
    </div>
</div>

<!-- Form usato dal Gestore assistenza per rispondere ai clienti -->
<div class="contact-clean">
    <form method="post" action=" ">
        <h2 class="text-center">Risposta</h2>
        <div class="form-group"><input class="form-control d-lg-flex" type="text" name="utente" placeholder="Utente" style="width: 100%;" /></div>
        <div class="form-group"><input class="form-control d-lg-flex" type="text" name="oggetto" placeholder="Oggetto" style="width: 100%;" /></div>
        <div class="form-group"><textarea class="form-control" name="message" placeholder="Messaggio di risposta" rows="14" style="width: 100%;"></textarea></div>
        <div class="form-group"><button class="btn btn-primary" type="submit">Invio</button></div>
    </form>
</div>



<%@include file="Footer.html" %> 