<%@ attribute name="type" required="true" %>
<%@ attribute name="path" required="true" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:set var="isEditScreen" value="${request.url.endsWith('edit')}" />

<c:choose>
  <c:when test="${isEditScreen}">
    <form:input type="${type}" path="${path}" />
  </c:when>
  <c:otherwise>
    value of the field
  </c:otherwise>
</c:choose>