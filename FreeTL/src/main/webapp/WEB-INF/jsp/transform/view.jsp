<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>


    <script> $(document).ready(setIconPosition);</script>

    <c:forEach var="descriptor" items="${stepDescriptors}">
     <div id = "${descriptor.UUID}" class="step">



                <c:url value="/controller/step/edit" var="my_url">
                        <c:param name="filename" value="${filename}" />
                        <c:param name="id" value="${descriptor.UUID}" />
                </c:url>

                <a href="${my_url}">
                   <img src="/public/images/icons/${descriptor.stepLabel}.png" />
                </a>

     </div>

       </c:forEach>



