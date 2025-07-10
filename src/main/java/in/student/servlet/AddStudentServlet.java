package in.student.servlet;

import in.student.dao.StudentDAO;
import in.student.model.Student;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/add")
public class AddStudentServlet extends HttpServlet {
    private StudentDAO studentDAO;

    public void init() {
        studentDAO = new StudentDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String course = request.getParameter("course");

        Student student = new Student();
        student.setName(name);
        student.setEmail(email);
        student.setCourse(course);

        try {
            studentDAO.insertStudent(student);
        } catch (SQLException e) {
            throw new ServletException(e);
        }

        response.sendRedirect("list");
    }
}
