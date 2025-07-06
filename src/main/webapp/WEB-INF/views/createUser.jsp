<%@ page contentType="text/html;charset=UTF-8" %>
<html><body>
<h2>Create User</h2>
<form action="/users/save" method="post">
Name: <input type="text" name="name"/><br/>
Email: <input type="text" name="email"/><br/>
<input type="submit" value="Save"/>
</form>
</body></html>