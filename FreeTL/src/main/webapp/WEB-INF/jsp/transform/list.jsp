<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>


  <c:forEach var="i" items="${filenames}">
  <p>

    <c:url value="/controller/transform/view" var="my_url">
        <c:param name="filename" value="${i}" />
    </c:url>

    <a href="${my_url}">${i}</a>


 </p>
 </c:forEach>




