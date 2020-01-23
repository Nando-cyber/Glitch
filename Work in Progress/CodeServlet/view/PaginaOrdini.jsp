<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="Header.jsp">
	<jsp:param name="pageTitle" value="Home"/>
</jsp:include>


<div class="article-list">
	<div class="container">
		<div class="intro">
			<h2 class="text-center">I miei ordini</h2>
		</div>
	</div>
	<div class="container">
		<div class="table-responsive" style="padding-bottom: 5%;">
			<table class="table">
				<thead>
					<tr style="background-color: #c4fff8;">
						<th>CODICE </th>
						<th>DATA ACQUISTO</th>
						<th>TOTALE </th>
						<th>DETTAGLI</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${ordine}" var="ordine">
						<tr>
							<td><c:out value="${ordine.id}" /></td>
							<td><c:out value="${ordine.dataOrdinazione}" /></td>
							<td><c:out value="${ordine.prezzoTot}" /></td>
							<td></td>
							<td><a href="#" ><i	class="fa fa-info-circle"></i> Clicca qui</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
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
	<div class="container">
		<div class="intro"></div>
	</div>
</div>



<%@include file="Footer.html" %>