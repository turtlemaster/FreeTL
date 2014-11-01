package freetl.io;

import org.junit.Test;
import freetl.util.DataCollection;
import freetl.util.FieldInfo;
import freetl.exceptions.StepException;
import freetl.operation.Route;
import freetl.operation.Step;
import freetl.operation.StepFactory;
import freetl.operation.Transform;
import freetl.operation.input.CSVInput;
import freetl.operation.output.CSVOutput;
import freetl.operation.remove.RetainCols;
import freetl.operation.util.StartStep;
import freetl.testhelpers.StepCollectionTestHelper;
import freetl.util.RouteCollection;
import freetl.util.StepCollection;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SaveFeatureTest {


    @Test
    public void whenYouSaveATransformToATextFileTheFileShouldContainTheTransformData () throws IOException {
        StepCollection stepCollection = StepCollectionTestHelper.stepCollection();
        List<Step> steps = stepCollection.getSteps();

        Route route0 = new Route(steps.get(0).getParameters().getId(), steps.get(1).getParameters().getId());
        Route route1 = new Route(steps.get(1).getParameters().getId(), steps.get(2).getParameters().getId());



        RouteCollection routes =  new RouteCollection();
        routes.addRoute(route0);
        routes.addRoute(route1);



        Transform t = new Transform(stepCollection, routes);


        SaveFeature saver = new SaveFeature();
        saver.saveFileToDisk(t, "TransformTestFile.txt");

    }

    @Test
    public void generateTransform () throws StepException {


          System.out.printf("Testing ---\n");

        String filename = "test/java/resources/simple.csv";
        String filename2 = "test/java/resources//testoutput.csv";



        List<String> names = new ArrayList<String>();

        String name1 = "Name";
        names.add(name1);
        String name2 = "Candy";
         names.add(name2);




        DataCollection data = null;

        List<FieldInfo> fieldInfos = new ArrayList<FieldInfo>();
        fieldInfos.add(new FieldInfo("Name", String.class, false, null));
        fieldInfos.add(new FieldInfo("Colour", String.class, false, null));
        fieldInfos.add(new FieldInfo("Candy", String.class, false, null));
        fieldInfos.add(new FieldInfo("Number", Integer.class, false, null));
        fieldInfos.add(new FieldInfo("Date", Date.class, true, "MMM d, yy"));
        fieldInfos.add(new FieldInfo("Ants", Number.class, true, "#.##"));


        List<FieldInfo> fieldTypes2 = new ArrayList<FieldInfo>();
        fieldTypes2.add(new FieldInfo("Name", String.class, false, null));
        fieldTypes2.add(new FieldInfo("Colour", String.class, false, null));
        fieldTypes2.add(new FieldInfo("Candy", String.class, false, null));
        fieldTypes2.add(new FieldInfo("Number", Integer.class, false, null));
        fieldTypes2.add(new FieldInfo("Date", Date.class, true, "EEE, MMM d, ''yy"));
        fieldTypes2.add(new FieldInfo("Ants", Number.class, true, "#.0000"));


        Step step0 = StepFactory.getInstance().getStep(new StartStep.Parameters());

        StepFactory stepFactory = StepFactory.getInstance();
        Step step1 = stepFactory.getStep(new CSVInput.Parameters(filename, false, fieldInfos));
        Step step2 = stepFactory.getStep(new RetainCols.Parameters(names));
        Step step3 = stepFactory.getStep(new CSVOutput.Parameters(filename2, fieldTypes2));

       // Step step1 = new CSVInput(new CSVInput.Parameters(filename, false, fieldTypes));
       // Step step2 = new RetainCols(new RetainCols.Parameters(names));
       // Step step3 = new CSVOutput(new CSVOutput.Parameters(filename2, fieldTypes2));


        StepCollection steps = new StepCollection();
        steps.addStep(step0);
        steps.addStep(step1);
        steps.addStep(step2);
        steps.addStep(step3);

        Route route0 = new Route(step0.getParameters().getId(), step1.getParameters().getId());
        Route route1 = new Route(step1.getParameters().getId(), step2.getParameters().getId());
        Route route2 = new Route(step2.getParameters().getId(), step3.getParameters().getId());


        RouteCollection routes =  new RouteCollection();
        routes.addRoute(route0);
        routes.addRoute(route1);
        routes.addRoute(route2);


      Transform t = new Transform(steps, routes);

        SaveFeature saver = new SaveFeature();
        try {
            saver.saveFileToDisk(t, "GeneratedTransformTestFile.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
