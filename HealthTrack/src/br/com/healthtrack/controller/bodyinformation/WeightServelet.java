package br.com.healthtrack.controller.bodyinformation;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.healthtrack.bean.bodyinformation.Weight;
import br.com.healthtrack.dao.DAOFactory;
import br.com.healthtrack.dao.bodyinformation.WeightDAO;
import br.com.healthtrack.exception.DBException;

@WebServlet("/weight")
public class WeightServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private WeightDAO dao;
	
	@Override
	public void init() throws ServletException {
		super.init();
		dao = DAOFactory.getWeightDAO();
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");

		switch (action) {
		case "list":
			list(request, response);
			break;

		case "delete":
			delete(request, response);
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");

		switch (action) {
		case "create":
			create(request, response);
			break;

		case "update":
			update(request, response);
			break;

		}
	}

	private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			double value    = Double.parseDouble(request.getParameter("value"));
			String date     = request.getParameter("date");
			String time     = request.getParameter("time");
			String dateTime = date + " " + time;
			
			Weight weight = new Weight(1, value, dateTime);

			dao.create(weight);

			request.setAttribute("msg", "Peso cadastrada!");

		} catch(DBException db) {
			db.printStackTrace();
			request.setAttribute("err", "Erro ao cadastrar");
			request.getRequestDispatcher("weight.jsp").forward(request, response);

		} catch(Exception e){
			e.printStackTrace();
			request.setAttribute("err","Por favor, valide os dados");
			request.getRequestDispatcher("weight.jsp").forward(request, response);
		}

		list(request, response);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		try {
			dao.destroy(id);
			request.setAttribute("msg", "Peso removida!");

		} catch (DBException db) {
			db.printStackTrace();
			request.setAttribute("err", "Erro ao remover");

		} finally {
			list(request, response);
		}
	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Weight> list = dao.getAll();

		request.setAttribute("weights", list);
		request.getRequestDispatcher("weight.jsp").forward(request, response);
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
