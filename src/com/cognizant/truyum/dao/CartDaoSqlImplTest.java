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

		CartDaoSqlImpl cartDaoSqlImpl = new CartDaoSqlImpl();

		CartDao cartDao = cartDaoSqlImpl;

		cartDao.addCartItem(1, 4);

		cartDao.addCartItem(1, 3);

		List<MenuItem> menuItemList = cartDao.getAllCartItems(1);

	}

	static void testGetAllCartItems() throws CartEmptyException {

		CartDaoSqlImpl cartDaoSqlImpl = new CartDaoSqlImpl();

		CartDao cartDao = cartDaoSqlImpl;

		List<MenuItem> menuItemList = cartDao.getAllCartItems(1);

		System.out.println("MenuItem list :" + menuItemList);

	}

	static void testRemoveCartItem() throws CartEmptyException {

		CartDaoSqlImpl cartDaoSqlImpl = new CartDaoSqlImpl();

		CartDao cartDao = cartDaoSqlImpl;

		try {

			cartDao.removeCartItem(1, 4);

			List<MenuItem> menuItemList = cartDao.getAllCartItems(1);

		} catch (Exception e) {

			throw new CartEmptyException("Cart is empty");

		}

	}

}
