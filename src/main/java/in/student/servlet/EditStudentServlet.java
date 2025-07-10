package in.student.servlet;

import in.student.dao.StudentDAO;
import in.student.model.Student;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/edit")
public class EditStudentServlet extends HttpServlet {
    private StudentDAO studentDAO;

    public void init() {
        studentDAO = new StudentDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            Student student = studentDAO.selectStudent(id);
            request.setAttribute("student", student);
            RequestDispatcher dispatcher = request.getRequestDispatcher("edit-student.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String course = request.getParameter("course");

        Student student = new Student(id, name, email, course);

        try {
            studentDAO.updateStudent(student);
        } catch (SQLException e) {
            throw new ServletException(e);
        }

        response.sendRedirect("list");
    }
}
