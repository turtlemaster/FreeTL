 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ page isELIgnored="false" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


 Transform

   <form:form commandName = "transform" action="commit" method="post" id="processTransformForm">

           <td>Name:</td>
           <td>${transform.name}</td>
           <input type="submit" value="Save Changes" />
    </form:form>

