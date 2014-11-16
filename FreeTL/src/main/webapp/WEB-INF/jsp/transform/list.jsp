<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>


  <c:forEach var="i" items="${transforms}">
  <p>


    <c:url value="/controller/transform/${i.id}" var="my_url">
    </c:url>
    <a href="${my_url}">${i.name}</a>

    <c:url value="/controller/transform/${i.id}/edit" var="edit_url">
    </c:url>
      <a href="${edit_url}">Edit</a>
 </p>
 </c:forEach>




