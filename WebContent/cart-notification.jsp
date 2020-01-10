<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
          <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
		<head>
            <title>Cart</title>
            <link rel="stylesheet" type="text/CSS" href="./style/style.css" />
		</head>    
        <body>
            <header>
                <span id="head" >truYum</span>
                <img src="./images/truyum-logo-light.png"/>
				<a id="nav-menu" href="ShowCart">Cart</a>
                <a id="nav-menu" href="ShowMenuItemListCustomer">Menu</a>
            </header>
                <div>
                    <h2 class="content" >Cart</h2> 
						<p id="center">Item removed from Cart successfully</p>
				<table class="content">
                        <tr>
                            <th class="title-name">Name</th>
                            <th class="title-text">Free Delivery</th>
                            <th class="title-price">Price</th>		  
                        </tr>
                        <c:forEach items="${menuItemListCustomer}" var="cartItems">
							<tr>
								<td class="title-name">${cartItems.name}</td>
								
								<td class="title-text"><c:if test="${cartItems.freeDelivery}">yes</c:if> <c:if test="${!cartItems.freeDelivery}">No</c:if></td>
									
								<td class="title-price">Rs.${cartItems.price}</td>
								
								
								
								<td class="title-text"><a
									href="RemoveCart?id=${cartItems.id}">Delete</a></td>
							</tr>

					
					</c:forEach>
					<tr>
						<th></th>
						<th class="title-name">Total</th>
						<th class="title-price">Rs.${total}</th>
						<th></th>
						</tr>
					</table>
                </div>            
            <footer>
				<span id="text-margin">Copyright © 2019</span>
			</footer>
        </body>
</html>
