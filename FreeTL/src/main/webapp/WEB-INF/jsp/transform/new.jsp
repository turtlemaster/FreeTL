<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>



 <form:form commandName = "transform" action="0/confirm" method="post" id="newTransformForm">
         <td>Name:</td>
         <td><input name="Name" type="text"/></td>
         </br>
         <input type="submit" value="Save Changes" />

 </form:form>