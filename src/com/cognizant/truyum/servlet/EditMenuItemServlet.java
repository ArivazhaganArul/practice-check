package com.cognizant.truyum.servlet;

import java.io.IOException;

import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import com.cognizant.truyum.dao.MenuItemDao;


import com.cognizant.truyum.dao.MenuItemDaoSqlImpl;
import com.cognizant.truyum.model.MenuItem;

import com.cognizant.truyum.util.DateUtil;

/**
 * Servlet implementation class EditMenuItemServlet
 */
@WebServlet("/EditMenuItem")
public class EditMenuItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditMenuItemServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try
			{
				
				long id = Long.parseLong(request.getParameter("id"));
				String name = request.getParameter("title");
				float price = Float.parseFloat(request.getParameter("price"));
				boolean active = request.getParameter("inStock").equals("Yes"); 
				Date dateOfLaunch = DateUtil.convertToDate(request.getParameter("dateOfLaunch"));
				String category = request.getParameter("category");
				boolean freeDelivery = request.getParameter("freeDelivery") != null ;
				MenuItem menuItem = new MenuItem(id, name, price, active, dateOfLaunch, category, freeDelivery);
				MenuItemDao menuItemDao = new MenuItemDaoSqlImpl();
				menuItemDao.modifyMenuItem(menuItem);
				request.setAttribute("msg", "Menu Item Details Saved Successfully.");
				RequestDispatcher rd = request.getRequestDispatcher("edit-menu-item-status.jsp");
				
				rd.forward(request, response);
				
				
			
			}
			catch (Exception e){
				
			}

	}
}