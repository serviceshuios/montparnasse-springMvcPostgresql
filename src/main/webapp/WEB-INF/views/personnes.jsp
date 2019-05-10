<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/style.css">
<title>Insert title here</title>
</head>
<body>
	<h2>CRUD PERSONNES</h2>
	<div>
		<f:form modelAttribute="personne" method="POST" action="savePersonne">
			<table>
				<tr>
					<td><f:hidden path="id"/> </td>
				</tr>
				<tr>
					<td>NOM:</td>
					<td><f:input path="nom" /></td>
					<td><f:errors path="nom" cssClass="error"/></td>
				</tr>
				<tr>
					<td>PRENOM:</td>
					<td><f:input path="prenom" /></td>
					<td><f:errors path="prenom" cssClass="error"/></td>
				</tr>
				<tr>
					<td>AGE:</td>
					<td><f:input path="age" /></td>
					<td><f:errors path="age" cssClass="error"/></td>
				</tr>
				<tr>
					<td><input type="submit" value="enregistrer" /></td>
				</tr>
			</table>
		</f:form>
	</div>
	<div id="listProduits">
		<table class="table1">
			<tr>
				<th>ID</th>
				<th>NOM</th>
				<th>PRENOM</th>
				<th>AGE</th>
				<th>SUPPRIMER</th>
				<th>MODIFIER</th>
			</tr>
			<c:forEach var="p" items="${personnes}">
				<tr>
					<td>${p.id}</td>
					<td>${p.nom}</td>
					<td>${p.prenom}</td>
					<td>${p.age}</td>
					<td><a href="deletePersonne?id=${p.id}">supprimer</a></td>
					<td><a href="editPersonne?id=${p.id}">editer</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>