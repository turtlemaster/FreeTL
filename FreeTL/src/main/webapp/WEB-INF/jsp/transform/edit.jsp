<%@ page isELIgnored="false" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="pt" tagdir="/WEB-INF/tags/" %>


  <form:form commandName = "transform" action="confirm" method="post" id="editTransformForm">

          <td>Name:</td>
          <td><form:input type="text" path="name" /></td>
          <td><pt:input   type="text" path="name" /></td>
          </br>
          <c:url value="/controller/step/0/edit" var="step_url">

          </c:url>
          <a href="${step_url}">Add Step</a>
          </br>



          <input type="submit" value="Save Changes" />
   </form:form>