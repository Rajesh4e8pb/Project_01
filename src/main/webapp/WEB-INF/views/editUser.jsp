<%@ page contentType="text/html;charset=UTF-8" %>
<html><body>
<h2>Edit User</h2>
<form action="/users/update/${user.id}" method="post">
Name: <input type="text" name="name" value="${user.name}"/><br/>
Email: <input type="text" name="email" value="${user.email}"/><br/>
<input type="submit" value="Update"/>
</form>
</body></html>