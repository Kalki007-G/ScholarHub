<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="in.student.model.Student" %>
<%
    Student s = (Student) request.getAttribute("student");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Student</title>
    <style>
        body { font-family: Arial; padding: 30px; }
        form { max-width: 400px; margin: auto; }
        input[type=text], input[type=email] {
            width: 100%; padding: 8px; margin: 8px 0; border: 1px solid #aaa; border-radius: 4px;
        }
        input[type=submit], a.btn {
            padding: 8px 15px; background: orange; color: white; border: none; border-radius: 4px;
            text-decoration: none; display: inline-block; margin-top: 10px;
        }
        a.btn { background: gray; margin-left: 10px; }
    </style>
</head>
<body>
    <h2 align="center">Edit Student</h2>
    <form action="edit" method="post">
        <input type="hidden" name="id" value="<%= s.getId() %>" />
        <input type="text" name="name" value="<%= s.getName() %>" required />
        <input type="email" name="email" value="<%= s.getEmail() %>" required />
        <input type="text" name="course" value="<%= s.getCourse() %>" required />
        <input type="submit" value="Update" />
        <a href="list" class="btn">Cancel</a>
    </form>
</body>
</html>
