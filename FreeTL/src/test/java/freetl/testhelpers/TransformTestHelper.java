package freetl.testhelpers;

import freetl.operation.Route;
import freetl.operation.Step;
import freetl.operation.Transform;
import freetl.util.RouteCollection;
import freetl.util.StepCollection;

import java.util.List;

public class TransformTestHelper {

    public static Transform nonCyclicTransform() {

        StepCollection stepCollection = StepCollectionTestHelper.stepCollection();
        List<Step> steps = stepCollection.getSteps();


        Route route0 = new Route(steps.get(0).getParameters().getId(), steps.get(1).getParameters().getId());
        Route route1 = new Route(steps.get(1).getParameters().getId(), steps.get(2).getParameters().getId());

        RouteCollection routes = new RouteCollection();
        routes.addRoute(route0);
        routes.addRoute(route1);

        return  new Transform(stepCollection, routes);

    }
}
