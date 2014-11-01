package freetl.operation;

import java.util.HashMap;
import java.util.Map;

public class StepFactory {
    private static StepFactory instance = new StepFactory();

    private Map<String, Class<? extends Step>> lookupMap;

    protected StepFactory() {
        lookupMap = new HashMap<String, Class<? extends Step>>();
    }

    public static StepFactory getInstance() {
        return instance;
    }

    @SuppressWarnings("unchecked")
    public Step getStep(Step.Parameters parameters) {
        if (parameters == null) {
            return null;
        }

        String parameterClassName = parameters.getClass().getName();
        if (!lookupMap.containsKey(parameterClassName)) {
            populateLookupMap(parameterClassName);
        }

        try {
            Step step = lookupMap.get(parameterClassName).newInstance();
            step.setParameters(parameters);

            return step;
        } catch (Exception e) {
            throw new RuntimeException(String.format("Error creating a new %s", lookupMap.get(parameterClassName)), e);
        }
    }

    @SuppressWarnings("unchecked")
    private void populateLookupMap(String parameterClassName) {
        String className = parameterClassName.substring(0, parameterClassName.indexOf("$"));
        Class clazz;
        try {
            clazz = Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException(String.format("Class %s was not found.", className), e);
        }

        if (!Step.class.isAssignableFrom(clazz)) {
            throw new RuntimeException(String.format("%s is not subclass of %s", clazz, Step.class));
        }

        lookupMap.put(parameterClassName, clazz);
    }
}
