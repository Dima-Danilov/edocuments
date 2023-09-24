<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html xmlns:form="http://www.w3.org/1999/xhtml">
<body>
<h2>Employee info</h2>
<form:form action="saveEmployee" modelAttribute="employee">

    <form:hidden path = "id"/>

    Name <form:input path = "name"/>
    <br><br>
    Surname <form:input path = "surname"/>
    <br><br>
    Department <form:input path = "department"/>
    <br><br>
    Salary <form:input path = "salary"/>
    <br><br>

    <input type="submit" value="OK">
</form:form>


</body>
</html>