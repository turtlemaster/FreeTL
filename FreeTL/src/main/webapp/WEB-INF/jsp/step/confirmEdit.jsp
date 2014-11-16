 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ page isELIgnored="false" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<p>Confirm Step</p>
 <form:form commandName = "step" action="commit" method="post" id="processEditStep">
     <p>Name: ${step.name}</p>


     <input type="submit" value="Save Changes" />

    </form:form>