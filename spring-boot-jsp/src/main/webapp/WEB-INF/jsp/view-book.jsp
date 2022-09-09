<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>View Book</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>ISBN</th>
				<th>Name</th>
				<th>Author</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${books}" var="book">
				<tr>
					<td>${book.isbn}</td>
					<td>${book.name}</td>
					<td>${book.author}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>