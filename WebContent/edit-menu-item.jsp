<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Edit Menu Item</title>
<link rel="stylesheet" type="text/CSS" href="./style/style.css" />
<script src="./js/script.js" type="text/javascript"></script>
</head>
<body>
	<header> <span id="head">truYum</span> <img
		src="./images/truyum-logo-light.png" /> <a id="nav-menu"
		href="ShowMenuItemListAdmin">Menu</a> </header>
	<div>
		<h2 class="content">Edit Menu Items</h2>

		<form class="content" name="form" method="post"
			onsubmit="return validation()" action="EditMenuItem?id=${menuItem.id}">

			<table>

				<tr>
					<td><label for="name-left"><b>Name</b></label>
					</td>
				</tr>

				<tr>
					<td colspan="4"><input type="text" name="title" id="name-left"
						value="${menuItem.name}"></td>
				</tr>

				<tr>
					<td class="menu-space"><label for="al-right"><b>Price(Rs.)</b></label></td>
					<td class="menu-space"><b>Active</b></td>
					<td class="menu-space"><label for="dol"><b>DateofLaunch</b></label></td>
					<td class="menu-space"><label for="category"><b>Category</b></label></td>
				</tr>

				<tr>
					<td><input type="text" name="price" id="al-right" value="${menuItem.price}" /></td>
					
					<td><input type="radio" name="inStock" value="Yes" id="Yes"
						<c:if test="${menuItem.active eq 'true'}">Checked</c:if>><label
						for="Yes">Yes </label> <label for="No"><input type="radio"
							name="inStock" value="No" id="No"
							<c:if test="${menuItem.active eq 'false'}">Checked</c:if>>No</label>
					</td> 
					
					<td><input type="text" id="dol" name="dateOfLaunch" value=<fmt:formatDate type="date" pattern="dd/MM/yyyy" value="${menuItem.dateOfLaunch}" />></td>
					
					<td><select name="category" id="category">
							<option value="${menuItem.category}">${menuItem.category}</option>
							<option value="Starters">Starters</option>
							<option value="Main course">Main Course</option>
							<option value="Dessert">Dessert</option>
							<option value="Drinks">Drinks</option>
					</select></td>
				</tr>

				<tr>
					<td><label for="Free Delivery"><input type="checkbox" id="Free Delivery" name="freeDelivery"
						<c:if test="${menuItem.freeDelivery eq 'true'}">Checked</c:if>
						<c:if test="${menuItem.freeDelivery eq 'false'}"></c:if>>Free Delivery</label></td>
				</tr>

				<tr>
					<td><input type="submit" class="button" value="Save"></td>
				</tr>

			</table>
		</form>
	</div>
	<footer> <span id="text-margin">Copyright @ 2019</span> </footer>
</body>
</html>
