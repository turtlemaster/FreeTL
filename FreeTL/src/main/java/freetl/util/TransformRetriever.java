package freetl.util;

import freetl.io.LoadFeature;
import freetl.descriptor.StepDescriptor;
import freetl.operation.Route;
import freetl.operation.Step;
import freetl.operation.Transform;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TransformRetriever {


    public Transform getTransform(String filename) throws IOException {
        LoadFeature loadFeature = new LoadFeature();
        Transform t = loadFeature.loadTransformFromFile("/Users/turtlemaster/Programming/FreeTL/src/test/resources/" + filename);
        return t;

    }

    public List<StepDescriptor> getStepDescriptors(Transform t) {
        StepCollection stepCollection = t.getStepCollection();
        Step startStep = stepCollection.getStartStep();
        List<Step> steps = stepCollection.getSteps();


        List<StepDescriptor> descriptors = new ArrayList<StepDescriptor>();

        for (Step s : steps) {
            descriptors.add(s.getDescriptor());
        }
        return descriptors;

    }

    public List<Route> getRoutes(Transform t) {
        RouteCollection routeCollection = t.getRouteCollection();
        return routeCollection.getRoutes();
    }

    public List<String> getIds(List<StepDescriptor> descriptors) {
        List<String> ids = new ArrayList<String>();
        for (StepDescriptor descriptor : descriptors) {
            ids.add(descriptor.getUUID());
        }

        return ids;
    }


}
