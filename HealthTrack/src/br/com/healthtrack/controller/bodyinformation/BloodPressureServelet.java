package br.com.healthtrack.controller.bodyinformation;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.healthtrack.bean.bodyinformation.BloodPressure;
import br.com.healthtrack.dao.DAOFactory;
import br.com.healthtrack.dao.bodyinformation.BloodPressureDAO;
import br.com.healthtrack.exception.DBException;

@WebServlet("/blood_pressure")
public class BloodPressureServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BloodPressureDAO dao;
       
	@Override
	public void init() throws ServletException {
		super.init();
		dao = DAOFactory.getBloodPressureDAO();
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
			int diastolicValue    = Integer.parseInt(request.getParameter("diastolicValue"));
			int systolicValue     = Integer.parseInt(request.getParameter("systolicValue"));
			String date           = request.getParameter("date");
			String time           = request.getParameter("time");
			String dateTime       = date + " " + time;
			
			BloodPressure pressure = new BloodPressure(1, systolicValue, diastolicValue, dateTime);

			dao.create(pressure);

			request.setAttribute("msg", "Pressão cadastrada!");

		} catch(DBException db) {
			db.printStackTrace();
			request.setAttribute("err", "Erro ao cadastrar");
			request.getRequestDispatcher("blood-pressure.jsp").forward(request, response);

		} catch(Exception e){
			e.printStackTrace();
			request.setAttribute("err","Por favor, valide os dados");
			request.getRequestDispatcher("blood-pressure.jsp").forward(request, response);
		}

		list(request, response);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		try {
			dao.destroy(id);
			request.setAttribute("msg", "Pressão removida!");

		} catch (DBException db) {
			db.printStackTrace();
			request.setAttribute("err", "Erro ao remover");

		} finally {
			list(request, response);
		}
	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<BloodPressure> list = dao.getAll();

		request.setAttribute("bloodPressures", list);
		request.getRequestDispatcher("blood-pressure.jsp").forward(request, response);
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
