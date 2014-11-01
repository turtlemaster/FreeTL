package freetl.io;

import org.junit.Assert;
import org.junit.Test;
import freetl.operation.Route;
import freetl.operation.Step;
import freetl.operation.Transform;
import freetl.testhelpers.StepCollectionTestHelper;
import freetl.util.RouteCollection;
import freetl.util.StepCollection;

import java.io.IOException;
import java.util.List;

public class TransformSerializerTest {


    @Test
    public void whenATransformIsSerializedTheResultRouteCollectionAndStepCollectionShouldMatchTheTransform() throws IOException {

        StepCollection stepCollection = StepCollectionTestHelper.stepCollection();
        List<Step> steps = stepCollection.getSteps();



        Route route0 = new Route(steps.get(0).getParameters().getId(), steps.get(1).getParameters().getId());
        Route route1 = new Route(steps.get(1).getParameters().getId(), steps.get(2).getParameters().getId());



        RouteCollection routes =  new RouteCollection();
        routes.addRoute(route0);
        routes.addRoute(route1);

        Transform t = new Transform(stepCollection, routes);

        TransformSeriliazer transformSeriliazer = new TransformSeriliazer();

        String serializedTransform = transformSeriliazer.serializeTransform(t);
        Transform loadedTransform = transformSeriliazer.deserializeTransform(serializedTransform);

        Assert.assertEquals(t,loadedTransform);





    }
}
