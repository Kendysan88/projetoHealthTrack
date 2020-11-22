package br.com.healthtrack.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.healthtrack.bean.PhysicalActivityBySeries;
import br.com.healthtrack.dao.DAOFactory;
import br.com.healthtrack.dao.PhysicalActivityDAO;
import br.com.healthtrack.exception.DBException;

/**
 * Servlet implementation class PhysicalActivityServelet
 */
@WebServlet("/physicalActivity")
public class PhysicalActivityServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private PhysicalActivityDAO dao;

	@Override
	public void init() throws ServletException {
		super.init();
		dao = DAOFactory.getPhysicalActivityDAO();
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
			
			int id             		   	= Integer.parseInt(request.getParameter("id"));
			String activityName        	= request.getParameter("activityName");
			String activityType        	= request.getParameter("activityType");
			LocalDateTime date			= request.getParameter("date");
			LocalDateTime startTime		= request.getParameter("startTime");
			LocalDateTime endTime		= request.getParameter("endTime");
			double calories    			= Double.parseDouble(request.getParameter("calories"));
			double distance    			= Double.parseDouble(request.getParameter("distance"));
			int series				    = Integer.parseInt(request.getParameter("series"));
			int repetitions			    = Integer.parseInt(request.getParameter("repetitions"));
			double liftedWeight			= Double.parseDouble(request.getParameter("liftedWeight"));

			PhysicalActivityBySeries activity = new PhysicalActivityBySeries(id, activityName, date, startTime, endTime, calories, activityType, distance, series, repetitions, liftedWeight);

			dao.create(activity);

			request.setAttribute("msg", "Atividade Física cadastrada!");

		} catch(DBException db) {
			db.printStackTrace();
			request.setAttribute("err", "Erro ao cadastrar");
			request.getRequestDispatcher("food.jsp").forward(request, response);

		} catch(Exception e){
			e.printStackTrace();
			request.setAttribute("err","Por favor, valide os dados");
			request.getRequestDispatcher("food.jsp").forward(request, response);
		}

		list(request, response);
	}
	
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		try {
			dao.destroy(id);
			request.setAttribute("msg", "Atividade Física Removida!");

		} catch (DBException db) {
			db.printStackTrace();
			request.setAttribute("err", "Erro ao remover");

		} finally {
			list(request, response);
		}
	}
	
	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<PhysicalActivityBySeries> list = dao.getAll();

		request.setAttribute("physicalActivity", list);
		request.getRequestDispatcher("physical-activity.jsp").forward(request, response);
	}
	
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int id             		   	= Integer.parseInt(request.getParameter("id"));
			String activityName        	= request.getParameter("activityName");
			String activityType        	= request.getParameter("activityType");
			LocalDateTime date			= request.getParameter("date");
			LocalDateTime startTime		= request.getParameter("startTime");
			LocalDateTime endTime		= request.getParameter("endTime");
			double calories    			= Double.parseDouble(request.getParameter("calories"));
			double distance    			= Double.parseDouble(request.getParameter("distance"));
			int series				    = Integer.parseInt(request.getParameter("series"));
			int repetitions			    = Integer.parseInt(request.getParameter("repetitions"));
			double liftedWeight			= Double.parseDouble(request.getParameter("liftedWeight"));


			PhysicalActivityBySeries activity = new PhysicalActivityBySeries(id, activityName, date, startTime, endTime, calories, activityType, distance, series, repetitions, liftedWeight);

			dao.update(activity);

			request.setAttribute("msg", "Atividade Física atualizada!");

		} catch(DBException db) {
			db.printStackTrace();
			request.setAttribute("err", "Erro ao atualizar");
			request.getRequestDispatcher("food.jsp").forward(request, response);

		} catch(Exception e){
			e.printStackTrace();
			request.setAttribute("err","Por favor, valide os dados");
			request.getRequestDispatcher("food.jsp").forward(request, response);
		}

		list(request, response);
	}

}
