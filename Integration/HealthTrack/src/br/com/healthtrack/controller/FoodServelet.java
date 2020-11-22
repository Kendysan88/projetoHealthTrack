//package br.com.healthtrack.controller;
//
//import java.io.IOException;
//import java.util.List;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import br.com.healthtrack.bean.meal.Food;
//import br.com.healthtrack.dao.DAOFactory;
//import br.com.healthtrack.dao.meal.FoodDAO;
//import br.com.healthtrack.exception.DBException;
//
//@WebServlet("/food")
//public class FoodServelet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	private FoodDAO dao;
//
//	@Override
//	public void init() throws ServletException {
//		super.init();
//		dao = DAOFactory.getFoodDAO();
//	}
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String action = request.getParameter("action");
//
//		switch (action) {
//		case "list":
//			list(request, response);
//			break;
//
//		case "delete":
//			delete(request, response);
//			break;
//		}
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String action = request.getParameter("action");
//
//		switch (action) {
//		case "create":
//			create(request, response);
//			break;
//
//		case "update":
//			update(request, response);
//			break;
//
//		}
//	}
//
//	private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		try {
//			String name        = request.getParameter("name");
//			String unit        = request.getParameter("unit");
//			String description = request.getParameter("description");
//			double amount      = Double.parseDouble(request.getParameter("amount"));
//			double calories    = Double.parseDouble(request.getParameter("calories"));
//
//			Food food = new Food(amount, calories, name, unit, description);
//
//			dao.create(food);
//
//			request.setAttribute("msg", "Alimento cadastrado!");
//
//		} catch(DBException db) {
//			db.printStackTrace();
//			request.setAttribute("err", "Erro ao cadastrar");
//			request.getRequestDispatcher("food.jsp").forward(request, response);
//
//		} catch(Exception e){
//			e.printStackTrace();
//			request.setAttribute("err","Por favor, valide os dados");
//			request.getRequestDispatcher("food.jsp").forward(request, response);
//		}
//
//		list(request, response);
//	}
//
//	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		int id = Integer.parseInt(request.getParameter("id"));
//
//		try {
//			dao.destroy(id);
//			request.setAttribute("msg", "Alimento removido!");
//
//		} catch (DBException db) {
//			db.printStackTrace();
//			request.setAttribute("err", "Erro ao remover");
//
//		} finally {
//			list(request, response);
//		}
//	}
//
//	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		List<Food> list = dao.getAll();
//
//		request.setAttribute("foods", list);
//		request.getRequestDispatcher("food.jsp").forward(request, response);
//	}
//
//	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		try {
//			int id             = Integer.parseInt(request.getParameter("id"));
//			String name        = request.getParameter("name");
//			String unit        = request.getParameter("unit");
//			String description = request.getParameter("description");
//			double amount      = Double.parseDouble(request.getParameter("amount"));
//			double calories    = Double.parseDouble(request.getParameter("calories"));
//
//			Food food = new Food(id, amount, calories, name, unit, description);
//
//			dao.update(food);
//
//			request.setAttribute("msg", "Alimento atualizado!");
//
//		} catch(DBException db) {
//			db.printStackTrace();
//			request.setAttribute("err", "Erro ao atualizar");
//			request.getRequestDispatcher("food.jsp").forward(request, response);
//
//		} catch(Exception e){
//			e.printStackTrace();
//			request.setAttribute("err","Por favor, valide os dados");
//			request.getRequestDispatcher("food.jsp").forward(request, response);
//		}
//
//		list(request, response);
//	}
//}
