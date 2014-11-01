package freetl.io;

import freetl.testhelpers.FieldInfoListTestHelper;
import org.junit.Assert;
import org.junit.Test;
import freetl.operation.Route;
import freetl.operation.Step;
import freetl.operation.StepFactory;
import freetl.operation.input.CSVInput;
import freetl.operation.output.CSVOutput;
import freetl.operation.util.StartStep;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class RouteSerializerTest {

    @Test
    public void LoadedRouteShouldEqualTheSavedRoute () throws IOException {

        //Step step0 = new StartStep();
        Step step0 = StepFactory.getInstance().getStep(new StartStep.Parameters());
        CSVInput step1 = (CSVInput) StepFactory.getInstance().getStep(new CSVInput.Parameters("CSV Test", false, FieldInfoListTestHelper.employeeFieldInfoList()));

        Route route0 = new Route(step0.getParameters().getId(), step1.getParameters().getId());

        RouteSerializer serializer = new RouteSerializer();

        String serializedIds = serializer.serializeRoute(route0);
        Route loadedRoute = serializer.deseriliazeRoute(serializedIds);

        Assert.assertEquals(route0, loadedRoute);
}

    @Test
    public void whenRoutesAreSerializedThenDeseriazliedTheDeserializedRoutesShouldMatchTheRoutes () throws IOException {

        Step step0 = StepFactory.getInstance().getStep(new StartStep.Parameters());
        CSVInput step1 = (CSVInput) StepFactory.getInstance().getStep(new CSVInput.Parameters("CSV Test", false, FieldInfoListTestHelper.employeeFieldInfoList()));
        CSVOutput step2 = (CSVOutput) StepFactory.getInstance().getStep(new CSVOutput.Parameters("Name", FieldInfoListTestHelper.employeeFieldInfoList()));

        Route route0 = new Route(step0.getParameters().getId(), step1.getParameters().getId());
        Route route1 = new Route(step1.getParameters().getId(), step2.getParameters().getId());

        List<Route> routes = new ArrayList<Route>();
        routes.add(route0);
        routes.add(route1);

        RouteSerializer serializer = new RouteSerializer();

        String serializedRoutes = serializer.serializeRoutes(routes);
        List deserializedRoutes = serializer.deseriliazeRoutes(serializedRoutes);

        Assert.assertEquals(routes, deserializedRoutes);
    }
}
