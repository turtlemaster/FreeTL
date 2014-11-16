package freetl.operation;

import freetl.vo.step.StepVO;

import java.lang.reflect.Constructor;
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
    public Step getStep(StepVO stepVO) {
        if (stepVO == null) {
            return null;
        }

        String voClassName = stepVO.getClass().getName();
        if (!lookupMap.containsKey(voClassName)) {
            populateLookupMap(voClassName);
        }

        try {

            Class<? extends Step> stepClass = lookupMap.get(voClassName);
            Constructor<? extends Step> constructor = stepClass.getConstructor(stepVO.getClass());
            Step step = constructor.newInstance(stepVO);
            return step;
        } catch (Exception e) {
            throw new RuntimeException(String.format("Error creating a new %s", lookupMap.get(voClassName)), e);
        }
    }

    @SuppressWarnings("unchecked")
    private void populateLookupMap(String voClassName) {
        String  stepClassName = voClassName.substring(0, voClassName.length() - 6);
        stepClassName = stepClassName.replaceAll("freetl.vo.step", "freetl.runner");
        Class clazz;
        try {
            clazz = Class.forName(stepClassName);
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException(String.format("Class %s was not found.", stepClassName), e);
        }

        if (!Step.class.isAssignableFrom(clazz)) {
            throw new RuntimeException(String.format("%s is not subclass of %s", clazz, Step.class));
        }

        lookupMap.put(voClassName, clazz);
    }
}
