<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>


    <h1>${transform.name}</h1>
    <script> $(document).ready(setIconPosition);</script>

    <h4>Steps</h4>
    <c:forEach var="step" items="${transform.stepCollection}">
       <div class="step">

           <c:url value="/controller/transform/${transform.id}/step/${step.id}/edit" var="step_url"> </c:url>

           <a href="${step_url}">
               <img src="/public/images/icons/${step.stepType}.png" />
           </a>
           <p>${step.name}</p>

       </div>


    </c:forEach>

    <c:url value="/controller/transform/${transform.id}/step/new" var="step_url"> </c:url>
    <a href="${step_url}">Add Step</a>
    </br>


      <c:url value="/controller/transform/${transform.id}/run" var="run_url"> </c:url>
      <a href="${run_url}">Run</a>
