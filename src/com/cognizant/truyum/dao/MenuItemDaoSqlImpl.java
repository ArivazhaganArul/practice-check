package com.cognizant.truyum.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.Connection;

import java.sql.PreparedStatement;

import com.cognizant.truyum.model.MenuItem;

public class MenuItemDaoSqlImpl implements MenuItemDao {

	public List<MenuItem> getMenuListAdmin() {
		List<MenuItem> menuItemList = new ArrayList<>();
		MenuItem mn;
		try {

			Connection con = ConnectionHandler.getConnection();

			PreparedStatement ps = con.prepareStatement("Select * from menu_item");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				long id = rs.getInt("me_id");

				String name = rs.getString("me_name");

				float price = rs.getFloat("me_price");

				boolean active = false;

				if (rs.getString("me_active").equalsIgnoreCase("YES")) {

					active = true;

				}

				Date dateOfLaunch = rs.getDate("me_date_Of_Launch");

				String category = rs.getString("me_category");

				boolean free_delivery = false;

				if (rs.getString("me_free_delivery").equalsIgnoreCase("YES")) {

					free_delivery = true;

				}

				mn = new MenuItem(id, name, price, active, dateOfLaunch, category, free_delivery);

				menuItemList.add(mn);

			}

		} catch (SQLException e) {

		
			e.printStackTrace();

		}
		
		return menuItemList;
	}

	public List<MenuItem> getMenuItemListCustomer() {

		List<MenuItem> al = new ArrayList<>();

		MenuItem m;

		try {

			Connection con = ConnectionHandler.getConnection();
			String sql = "Select * from menu_item " + "where me_active='yes' " + "and "
					+ "me_date_of_launch <= curdate()";
			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				long id = rs.getInt("me_id");

				String name = rs.getString("me_name");

				float price = rs.getFloat("me_price");

				boolean active = false;

				if (rs.getString("me_active").equalsIgnoreCase("YES")) {

					active = true;

				}

				Date dateOfLaunch = rs.getDate("me_date_of_launch");

				String category = rs.getString("me_category");

				boolean free_delivery = false;

				if (rs.getString("me_free_delivery").equalsIgnoreCase("YES")) {

					free_delivery = true;

				}
				m = new MenuItem(id, name, price, active, dateOfLaunch, category, free_delivery);

				al.add(m);

			}

		} catch (SQLException e) {

			
			e.printStackTrace();

		}

		return al;

	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {

		Connection con = ConnectionHandler.getConnection();

		try {

			String sql = "update menu_item " + "set me_name=?," + "me_price=?," + "me_active=?,"
					+ "me_date_of_launch=?," + "me_free_delivery=?," + "me_category=? " + "where me_id=?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, menuItem.getName());

			ps.setFloat(2, menuItem.getPrice());

			if (menuItem.isActive()) {

				ps.setString(3, "Yes");

			} else {

				ps.setString(3, "No");

			}

			ps.setDate(4, new java.sql.Date(menuItem

					.getDateOfLaunch().getTime()));

			if (menuItem.isFreeDelivery()) {

				ps.setString(5, "Yes");

			} else {

				ps.setString(5, "No");

			}

			ps.setString(6, menuItem.getCategory());

			ps.setLong(7, menuItem.getId());

			ps.executeUpdate();

		} catch (SQLException sq) {

			sq.printStackTrace();

		} finally {

			try {

				con.close();

			} catch (Exception e) {

				e.printStackTrace();

			}

		}

	}

	@Override
	public MenuItem getMenuItem(long MenuItemId) {
		// TODO Auto-generated method stub

		Connection con = ConnectionHandler.getConnection();

		ResultSet resultSet;

		MenuItem menuItem = null;

		if (con != null) {

			try {

				String sql = "select * from menu_item where me_id=?";

				PreparedStatement ps = con

						.prepareStatement(sql);

				ps.setLong(1, MenuItemId);

				resultSet = ps.executeQuery();

				boolean active, freeDelivery;

				Date date_of_launch;

				while (resultSet.next()) {

					String name = resultSet.getString(2);

					float price = resultSet.getFloat(3);

					String isActive = resultSet.getString(4);

					date_of_launch = resultSet.getDate(5);

					String category = resultSet.getString(6);

					String isFreeDelivery = resultSet.getString(7);

					if (isActive != null && isActive.equals("Yes"))

						active = true;

					else

						active = false;

					if (isFreeDelivery != null && isFreeDelivery.equals("Yes"))

						freeDelivery = true;

					else

						freeDelivery = false;

					menuItem = new MenuItem(MenuItemId, name, price,

							active, date_of_launch, category,

							freeDelivery);

				}

			} catch (SQLException e) {

				// TODO Auto-generated catch block

				e.printStackTrace();

			} finally {

				try {

					con.close();

				} catch (SQLException e) {

					// TODO Auto-generated catch block

					e.printStackTrace();

				}

			}

		}

		return menuItem;

	}

}
