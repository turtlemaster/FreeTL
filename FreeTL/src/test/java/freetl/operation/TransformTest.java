package freetl.operation;

import org.junit.Assert;
import org.junit.Test;
import freetl.testhelpers.StepCollectionTestHelper;
import freetl.testhelpers.TransformTestHelper;
import freetl.util.RouteCollection;
import freetl.util.StepCollection;


import java.util.List;

public class TransformTest {

    @Test
    public void containsCyclicRouteShouldReturnTrueForATransformWithACyclicRoute(){
        StepCollection stepCollection = StepCollectionTestHelper.stepCollection();
        List<Step> steps = stepCollection.getSteps();


        Route route0 = new Route(steps.get(0).getParameters().getId(), steps.get(1).getParameters().getId());
        Route route1 = new Route(steps.get(1).getParameters().getId(), steps.get(2).getParameters().getId());
        Route route2 = new Route(steps.get(2).getParameters().getId(), steps.get(0).getParameters().getId());


        RouteCollection routes = new RouteCollection();
        routes.addRoute(route0);
        routes.addRoute(route1);
        routes.addRoute(route2);

        Transform t = new Transform(stepCollection, routes);

        Assert.assertTrue(t.containsCyclicRoute());

    }

    public void containsCyclicRouteShouldReturnFalseForATransformWithoutAnyCyclicRoutes() {
         Transform t = TransformTestHelper.nonCyclicTransform();
        Assert.assertFalse(t.containsCyclicRoute());

    }
}
