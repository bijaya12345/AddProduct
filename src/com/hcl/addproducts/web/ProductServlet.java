package com.hcl.addproducts.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hcl.addproducts.dao.ProductDAO;
import com.hcl.addproducts.model.Product;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ProductDAO productDao = new ProductDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		switch (action) {
		case "/new":
			showNewForm(request, response);
			break;
		case ("/update"):
			try {
				updateProduct(request, response);
			} catch (SQLException | IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		case "/insert":
			try {
				insertProduct(request, response);
			} catch (SQLException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		default:
			try {
				listProduct(request, response);
			} catch (SQLException | IOException | ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
	}

	@SuppressWarnings("unused")
	private void updateProduct(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String name = request.getParameter("pro_name");
		String price = request.getParameter("pro_price");
		double price2 = Double.parseDouble(price);
		String department = request.getParameter("pro_dept");
		Product newProduct = new Product(name, price2, department);
		productDao.updateUser(newProduct);
		response.sendRedirect("list");
	}

	private void listProduct(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Product> listUser = productDao.getAllProducts();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("product-list.jsp");
		dispatcher.forward(request, response);
	}

	private void insertProduct(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String name = request.getParameter("pro_name");
		String price = request.getParameter("pro_price");
		double price2 = Double.parseDouble(price);
		String department = request.getParameter("pro_dept");
		Product newProduct = new Product(name, price2, department);
		productDao.saveProduct(newProduct);
		response.sendRedirect("list");
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("product-form.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
