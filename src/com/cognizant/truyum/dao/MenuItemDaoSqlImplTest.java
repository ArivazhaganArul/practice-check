package com.cognizant.truyum.dao;

import java.text.ParseException;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoSqlImplTest {

	public static void main(String[] args) throws ClassNotFoundException, ParseException {
		System.out.println("====Admin List====");
		testGetMenuItemAdmin();
		System.out.println("====Customer List====");
		testGetCustomerItem();

		testModifyMenuItem();
		System.out.println("====Modified List====");
		testGetMenuItemAdmin();
	}

	public static void testGetMenuItemAdmin() throws ClassNotFoundException {

		MenuItemDaoSqlImpl menu = new MenuItemDaoSqlImpl();

		List<MenuItem> menuItem = menu.getMenuListAdmin();

		for (MenuItem m : menuItem) {

			System.out.println(m);

		}

	}

	public static void testGetCustomerItem() throws ClassNotFoundException {

		MenuItemDaoSqlImpl menu = new MenuItemDaoSqlImpl();

		List<MenuItem> menuItem = menu.getMenuItemListCustomer();

		for (MenuItem m : menuItem) {

			System.out.println(m);

		}

	}

	private static void testModifyMenuItem() throws ParseException {

		MenuItemDaoSqlImpl menu = new MenuItemDaoSqlImpl();
		MenuItem menuItem = new MenuItem(1, "Biriyani", 50.00f, true, DateUtil.convertToDate("11/12/2019"),
				"Main Course", false);

		menu.modifyMenuItem(menuItem);

	}
}
