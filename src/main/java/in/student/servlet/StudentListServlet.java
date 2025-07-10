package in.student.servlet;

import in.student.dao.StudentDAO;
import in.student.model.Student;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/list")
public class StudentListServlet extends HttpServlet {
    private StudentDAO studentDAO;

    public void init() {
        studentDAO = new StudentDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Student> list = studentDAO.selectAllStudents();
            request.setAttribute("studentList", list);
            RequestDispatcher rd = request.getRequestDispatcher("list-students.jsp");
            rd.forward(request, response);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}
