package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImplTest {

	public static void main(String[] args) throws CartEmptyException {

		testAddCartItem();

		testRemoveCartItem();

		testGetAllCartItems();

	}

	static void testAddCartItem() throws CartEmptyException {

		CartDao cartDao = new CartDaoSqlImpl();

		cartDao.addCartItem(1, 1);

		cartDao.addCartItem(1, 2);

		List<MenuItem> menuItemList = cartDao.getAllCartItems(1);

	}

	static void testGetAllCartItems() throws CartEmptyException {

		CartDao cartDao = new CartDaoSqlImpl();

		List<MenuItem> menuItemList = cartDao.getAllCartItems(1);
		for (MenuItem menuItem : menuItemList) {
			System.out.println(menuItem);
		}

	}

	static void testRemoveCartItem() throws CartEmptyException {

		CartDao cartDao = new CartDaoSqlImpl();

		

		try {

			cartDao.removeCartItem(1, 4);

			List<MenuItem> menuItemList = cartDao.getAllCartItems(1);

		} catch (Exception e) {

			throw new CartEmptyException("Cart is empty");

		}

	}

}
