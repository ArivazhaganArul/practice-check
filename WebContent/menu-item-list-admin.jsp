<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Admin Menu Item List</title>
<link rel="stylesheet" type="text/CSS" href="./style/style.css" />
</head>
<body>
	<header> <span id="head">truYum</span> <img
		src="./images/truyum-logo-light.png" /> <a id="nav-menu"
		href="ShowMenuItemListAdmin">Menu</a> </header>
	<div>
		<h2 class="content">Menu Items</h2>
		<table class="content">
			<tr>
				<th class="title-name">Name</th>
				<th class="title-price">Price</th>
				<th class="title-text">Active</th>
				<th class="title-text">Date of Launch</th>
				<th class="title-text">Category</th>
				<th class="title-text">Free Delivery</th>
				<th class="title-text">Action</th>
			</tr>
			<c:forEach items="${menuItemList}" var="menuItem">
				<tr>
					<td class="title-name">${menuItem.name}</td>
					<td class="title-price">Rs.${menuItem.price}</td>
					<td class="title-text"><c:if test="${menuItem.active}">Yes</c:if> <c:if test="${!menuItem.active}">No</c:if></td>
					<td class="title-text"><fmt:formatDate  pattern="dd/MM/yyyy"
							value="${menuItem.dateOfLaunch}" /></td>
					<td class="title-text">${menuItem.category}</td>
					<td class="title-text"><c:if test="${menuItem.freeDelivery}">yes</c:if>
						<c:if test="${!menuItem.freeDelivery}">No</c:if></td>
					<td class="title-text"><a
						href="ShowEditMenuItem?mid=${menuItem.id}">Edit</a></td>
				</tr>

			</c:forEach>

		</table>
	</div>
	<footer> <span id="text-margin">Copyright © 2019</span> </footer>
</body>
</html>
