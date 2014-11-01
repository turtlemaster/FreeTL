 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ page isELIgnored="false" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


  <h2>CSV Input Step</h2>
  <form:form commandName = "descriptor" action="confirmEdit" method="post" id="editForm">


        <input type="hidden" name="removedIds" value="" id="removedIds"/>
        <input type="hidden" name="transformName" value="${transformName}"/>

         <c:forEach var="parameter" items="${descriptor.stepParameterDescriptorList}" varStatus="status">
                    <c:choose>
                        <c:when test="${'Filename:' == parameter.name}">
                           Filename: <form:input path="stepParameterDescriptorList[${status.index}].value" />

                        </c:when>

                        <c:when test="${'Header' == parameter.name}">
                             Has Header:  <form:checkbox path="stepParameterDescriptorList[${status.index}].value" value = "true"/>
                            </br>
                        </c:when>

                        <c:when test="${'FieldTypes' == parameter.name}">
                          Field Types:
                          <hr size="1" />

                            <c:forEach var="fieldtype" items="${parameter.value}" varStatus="fieldTypeStatus">


                              <div id = "fieldtype_${fieldTypeStatus.index}">
                                Name:   <form:input path="stepParameterDescriptorList[${status.index}].value[${fieldTypeStatus.index}].fieldname" />
                                Format: <form:input path="stepParameterDescriptorList[${status.index}].value[${fieldTypeStatus.index}].format" />
                                <div class = "remove" onclick="removeFieldType('fieldtype_${fieldTypeStatus.index}')">Remove</div>

                              </div>



                                 </br>

                            </c:forEach>
                        </c:when>

                    </c:choose>


         </c:forEach>








        <input type="button" value="Submit" onclick="submitForm();"/>


    </form:form>
</div>