<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, in.student.model.Student" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student List</title>
    <style>
        body { font-family: Arial; padding: 30px; }
        table { width: 100%; border-collapse: collapse; }
        th, td { border: 1px solid #aaa; padding: 8px; text-align: left; }
        th { background: #f2f2f2; }
        .btn { padding: 5px 10px; text-decoration: none; border-radius: 4px; }
        .edit { background: orange; color: white; }
        .delete { background: crimson; color: white; }
        .add { background: green; color: white; padding: 8px 15px; float: right; }
    </style>
</head>
<body>
    <h2>Student List</h2>
    <a href="add-student.jsp" class="btn add">Add New</a>
    <br/><br/>
    <table>
        <thead>
            <tr>
                <th>ID</th><th>Name</th><th>Email</th><th>Course</th><th>Actions</th>
            </tr>
        </thead>
        <tbody>
        <%
            List<Student> list = (List<Student>) request.getAttribute("studentList");
            for (Student s : list) {
        %>
        <tr>
            <td><%= s.getId() %></td>
            <td><%= s.getName() %></td>
            <td><%= s.getEmail() %></td>
            <td><%= s.getCourse() %></td>
            <td>
                <a href="edit?id=<%= s.getId() %>" class="btn edit">Edit</a>
                <a href="delete?id=<%= s.getId() %>" class="btn delete" onclick="return confirm('Delete this student?')">Delete</a>
            </td>
        </tr>
        <% } %>
