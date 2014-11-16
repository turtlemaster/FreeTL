 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ page isELIgnored="false" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


  <h2>CSV Input Step</h2>
  <form:form commandName = "step" action="confirm" method="post" id="editForm">

        <input type="hidden" name="removedIds" value="" id="removedIds"/>
        <input type="hidden" name="transformName" value="${transform.name}"/>

        Step Name: <form:input path="name"/>
        </br>
        Filename:  <form:input path ="filename"/>
        </br>

         <c:forEach var="fieldInfo" items ="fieldInfoList">
                <form input path="name"/>
                <form input path="type"/>

         </c:forEach>



        <input type="submit" value="Submit"/>


    </form:form>
</div>