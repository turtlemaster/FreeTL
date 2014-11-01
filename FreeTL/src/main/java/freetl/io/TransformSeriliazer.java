package freetl.io;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import freetl.operation.*;
import freetl.util.RouteCollection;
import freetl.util.StepCollection;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransformSeriliazer<T extends AbstractStep.AbstractParameters>  {

    public static final String STEP_KEY = "Steps";
    public static final String ROUTE_KEY = "Routes";

    public String serializeTransform(Transform t)throws IOException {

        //routes to string
        //step params to string
        //combine string


        StepParameterSerializer parameterSerializer = new StepParameterSerializer();
        List<Step> steps = t.getStepCollection().getSteps();
        List<T> parameters = new ArrayList<T>();

        for(Step s : steps) {
            parameters.add((T) s.getParameters());
        }
        String stepParameterString = parameterSerializer.serializeStepParameters(parameters);

        RouteSerializer<Route> rSerializer = new RouteSerializer<Route>();
        List<Route> routes = t.getRouteCollection().getRoutes();
        String routeString = rSerializer.serializeRoutes(routes);


        Map<String, String> saveItems = new HashMap<String, String>();
        saveItems.put(ROUTE_KEY, routeString);
        saveItems.put(STEP_KEY, stepParameterString);

        ObjectMapper mapper = new ObjectMapper();

        return mapper.writeValueAsString(saveItems);
    }

    public Transform deserializeTransform(String transformString) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> savedItems = mapper.readValue(
                transformString,
                mapper.getTypeFactory().constructMapType(HashMap.class, String.class, String.class));

        String routesString = savedItems.get(ROUTE_KEY);
        String parametersString = savedItems.get(STEP_KEY);


        StepParameterSerializer stepParameterSerializer = new StepParameterSerializer();
        List<T> parameters = stepParameterSerializer.deserializeStepParameters(parametersString);
        StepCollection steps = new StepCollection();



        for (T p : parameters) {
           steps.addStep(StepFactory.getInstance().getStep(p));
        }


        RouteSerializer rSerializer = new RouteSerializer();

        List<Route> routeList = rSerializer.deseriliazeRoutes(routesString);
        RouteCollection routes = new RouteCollection();
        routes.addRoutes(routeList);


        return new Transform(steps, routes);
    }

}
