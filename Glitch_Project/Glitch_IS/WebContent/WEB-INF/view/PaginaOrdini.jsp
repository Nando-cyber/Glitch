<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="Header.jsp">
	<jsp:param name="pageTitle" value="Home"/>
</jsp:include>


<div id="pagina">
	<div class="container">
		<div class="intro">
			<h2 class="text-center">I miei ordini</h2>
		</div>
	</div>
	
	<div class="container">
		<div class="table-responsive" style="padding-bottom: 5%;">
			<table class="table">
				<thead>
					<tr>
						<th>Codice</th>
						<th>Data acquisto</th>
						<th>Totale pagato</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${ordini}" var="ordini">
						<tr>
							<td><c:out value="${ordini.ordineId}" /></td>
							<td><c:out value="${ordini.dataOrdinazione}" /></td>
							<td><c:out value="${ordini.prezzoTot}" /></td>
							<td></td>
							<td><a href="#" ><i	class="fa fa-info-circle"></i> Clicca qui</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>



<%@include file="Footer.html" %>