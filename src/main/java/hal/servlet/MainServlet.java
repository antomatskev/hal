package hal.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import hal.dao.IllnessDao;
import hal.dao.PaymentDao;
import hal.dao.PersonDao;
import hal.model.Illness;
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
public class MainServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private final PersonDao personDao;
    private final IllnessDao illnessDao;
    private final PaymentDao paymentDao;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        personDao = new PersonDao();
        illnessDao = new IllnessDao();
        paymentDao = new PaymentDao();
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
                    newPerson(request, response);
                    break;
                case "/insertPerson":
                    insertPerson(request, response);
                    break;
                case "/deletePerson":
                    deletePerson(request, response);
                    break;
                case "/editPerson":
                    editPerson(request, response);
                    break;
                case "/updatePerson":
                    updatePerson(request, response);
                    break;
                case "/listPerson":
                    listPerson(request, response);
                    break;
                case "/newSL":
                    newSL(request, response);
                    break;
                case "/insertSL":
                    insertSL(request, response);
                    break;
                case "/deleteSL":
                    deleteSL(request, response);
                    break;
                case "/editSL":
                    editSL(request, response);
                    break;
                case "/updateSL":
                    updateSL(request, response);
                    break;
                case "/listSL":
                    listSL(request, response);
                    break;
                case "/listPayment":
                    listPayment(request, response);
                    break;
                default:
                    showMain(request, response);
                    break;
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new ServletException(e);
        }
    }

    private void newPerson(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("person-form.jsp");
        dispatcher.forward(request, response);
    }

    private void editPerson(HttpServletRequest request, HttpServletResponse response)
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
        response.sendRedirect("listPerson");
    }

    private void updatePerson(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ClassNotFoundException {
        Long id = Long.parseLong(request.getParameter("id"));
        personDao.update(new Person(id, request.getParameter("personalCode"), request.getParameter("firstName"), request.getParameter("lastName"),
                request.getParameter("address"), request.getParameter("email"), request.getParameter("bankAccount"), request.getParameter("insurance")));
        response.sendRedirect("listPerson");
    }

    private void deletePerson(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ClassNotFoundException {
        Long id = Long.parseLong(request.getParameter("id"));
        personDao.delete(id);
        response.sendRedirect("listPerson");

    }

    private void listPerson(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException, ClassNotFoundException {
        List<Person> list = personDao.getAll();
        request.setAttribute("personList", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("person-list.jsp");
        dispatcher.forward(request, response);
    }

    private void newSL(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("illness-form.jsp");
        dispatcher.forward(request, response);
    }

    private void editSL(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException, ClassNotFoundException {
        Long id = Long.parseLong(request.getParameter("id"));
        Illness foundIllness = illnessDao.getById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("illness-form.jsp");
        request.setAttribute("person", foundIllness);
        dispatcher.forward(request, response);

    }

    private void insertSL(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ClassNotFoundException {
        illnessDao.create(new Illness(Long.parseLong(request.getParameter("personId")), request.getParameter("startDate"),
                request.getParameter("endDate"), request.getParameter("diagnosis"), request.getParameter("medicalDoctor"),
                request.getParameter("notes")));
        response.sendRedirect("listSL");
    }

    private void updateSL(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ClassNotFoundException {
        Long id = Long.parseLong(request.getParameter("id"));
        illnessDao.update(new Illness(id, Long.parseLong(request.getParameter("personId")), request.getParameter("startDate"),
                request.getParameter("endDate"), request.getParameter("diagnosis"), request.getParameter("medicalDoctor"),
                request.getParameter("notes")));
        response.sendRedirect("listSL");
    }

    private void deleteSL(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ClassNotFoundException {
        Long id = Long.parseLong(request.getParameter("id"));
        illnessDao.delete(id);
        response.sendRedirect("listSL");

    }

    private void listSL(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException, ClassNotFoundException {
        List<Illness> list = illnessDao.getAll();
        request.setAttribute("slList", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("illness-list.jsp");
        dispatcher.forward(request, response);
    }

    private void listPayment(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException, ClassNotFoundException {
//        List<Person> list = personDao.getAll();
//        request.setAttribute("paymentList", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("payment-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showMain(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException, ClassNotFoundException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("person-list.jsp");
        dispatcher.forward(request, response);
    }

}
