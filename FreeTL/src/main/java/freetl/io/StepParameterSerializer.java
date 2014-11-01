package freetl.io;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import freetl.operation.AbstractStep;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StepParameterSerializer<T extends AbstractStep.AbstractParameters> {


    public StepParameterSerializer() {}

    public String serializeStepParameters(List<T> stepParameters) throws IOException {
        List<String> stringList = new ArrayList<String>();
        ObjectMapper mapper = new ObjectMapper();

        for (T parameter : stepParameters) {
            String type = parameter.getClass().getName();
            String saveString = serializeStepParameter(mapper, parameter);
            stringList.add(type + "|" + saveString);
        }

         return mapper.writeValueAsString(stringList);

    }

    public List<T> deserializeStepParameters(String stepParameters) throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        List<String> stringList = mapper.readValue(
                stepParameters,
                mapper.getTypeFactory().constructCollectionType(List.class, String.class));

        List<T> parameterList = new ArrayList<T>();

        for (String s : stringList) {
             String type = s.substring(0, s.indexOf("|"));
             String data = s.substring(s.indexOf("|")+1);
            T parameter;
            try {
                parameter = deserializeStepParameter(mapper, data, (Class<T>) Class.forName(type));
            } catch (ClassNotFoundException e) {
                throw new IOException(e);
            }
            parameterList.add(parameter);
        }


        return parameterList;
    }

    // --------------------------------------------------------------------------------------------
    protected String serializeStepParameter(ObjectMapper mapper, T stepParameter) throws IOException {


        return mapper.writeValueAsString(stepParameter);
    }

    protected T deserializeStepParameter(ObjectMapper mapper, String stringStepParameter, Class<T> clazz) throws IOException {

        return mapper.readValue(stringStepParameter, clazz);
    }



}
