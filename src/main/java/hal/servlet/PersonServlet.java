package hal.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import hal.dao.PersonDao;
import hal.model.Person;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PersonServlet
 */
@WebServlet("/")
public class PersonServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private final PersonDao personDao;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonServlet() {
        personDao = new PersonDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String action = request.getServletPath();
        try {
            switch (action) {
                case "/newPerson":
                    showNewPersonForm(request, response);
                    break;
                case "/insertPerson":
                    insertPerson(request, response);
                    break;
                case "/deletePerson":
                    deletePerson(request, response);
                    break;
                case "/editPerson":
                    showEditPersonForm(request, response);
                    break;
                case "/updatePerson":
                    updatePerson(request, response);
                    break;
                default:
                    listPerson(request, response);
                    break;
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new ServletException(e);
        }
    }

    private void showNewPersonForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("person-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditPersonForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException, ClassNotFoundException {
        Long id = Long.parseLong(request.getParameter("id"));
        Person foundPerson = personDao.getById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("person-form.jsp");
        request.setAttribute("person", foundPerson);
        dispatcher.forward(request, response);

    }

    private void insertPerson(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ClassNotFoundException {
        personDao.create(new Person(request.getParameter("personalCode"), request.getParameter("firstName"), request.getParameter("lastName"),
                request.getParameter("address"), request.getParameter("email"), request.getParameter("bankAccount"), request.getParameter("insurance")));
        response.sendRedirect("list");
    }

    private void updatePerson(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ClassNotFoundException {
        Long id = Long.parseLong(request.getParameter("id"));
        personDao.update(new Person(id, request.getParameter("personalCode"), request.getParameter("firstName"), request.getParameter("lastName"),
                request.getParameter("address"), request.getParameter("email"), request.getParameter("bankAccount"), request.getParameter("insurance")));
        response.sendRedirect("list");
    }

    private void deletePerson(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ClassNotFoundException {
        Long id = Long.parseLong(request.getParameter("id"));
        personDao.delete(id);
        response.sendRedirect("list");

    }

    private void listPerson(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException, ClassNotFoundException {
        List<Person> list = personDao.getAll();
        request.setAttribute("personList", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("person-list.jsp");
        dispatcher.forward(request, response);
    }

}
