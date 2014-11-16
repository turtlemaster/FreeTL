<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form commandName = "step" action="confirm" method="post" id="editStep">
    <td>Name:</td>
    <td><form:input path="name" /></td>

    <input type="submit" value="Save Changes" />

   </form:form>