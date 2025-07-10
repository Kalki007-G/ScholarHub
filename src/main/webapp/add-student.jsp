<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Add Student</title>
    <style>
        body { font-family: Arial; padding: 30px; }
        form { max-width: 400px; margin: auto; }
        input[type=text], input[type=email] {
            width: 100%; padding: 8px; margin: 8px 0; border: 1px solid #aaa; border-radius: 4px;
        }
        input[type=submit], a.btn {
            padding: 8px 15px; background: green; color: white; border: none; border-radius: 4px;
            text-decoration: none; display: inline-block; margin-top: 10px;
        }
        a.btn { background: gray; margin-left: 10px; }
    </style>
</head>
<body>
    <h2 align="center">Add Student</h2>
    <form action="add" method="post">
        <input type="text" name="name" placeholder="Name" required />
        <input type="email" name="email" placeholder="Email" required />
        <input type="text" name="course" placeholder="Course" required />
        <input type="submit" value="Submit" />
        <a href="list" class="btn">Back</a>
    </form>
</body>
</html>
