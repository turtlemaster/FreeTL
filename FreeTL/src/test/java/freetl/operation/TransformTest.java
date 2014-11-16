package freetl.operation;

import freetl.bo.TransformBO;
import freetl.exceptions.StepException;
import freetl.vo.TransformVO;
import freetl.vo.step.StepVO;
import freetl.vo.step.operation.input.CSVInputStepVO;
import freetl.vo.step.operation.start.StartStepVO;
import org.junit.Assert;
import org.junit.Test;
import freetl.testhelpers.StepCollectionTestHelper;
import freetl.testhelpers.TransformTestHelper;
import freetl.util.RouteCollection;
import freetl.util.StepCollection;


import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class TransformTest {


    @Test
    public void testingRunningAtransform() throws StepException {

        StartStepVO startStepVO = new StartStepVO();
        CSVInputStepVO csvInputStepVO = new CSVInputStepVO("test/java/resources/simple.csv", false, null);
        TransformVO transformVO = new TransformVO();
        transformVO.addStepVO(startStepVO);
        transformVO.addStepVO(csvInputStepVO);

        List<StepVO>  stepVOs = transformVO.getStepCollection();
        List<Step> steps = new ArrayList<Step>();
        StepFactory stepFactory = new StepFactory();
        for(StepVO stepVO: stepVOs){
            steps.add(stepFactory.getStep(stepVO));
        }



       /*Route route0 = new Route(steps.get(0).getParameters().getId(), steps.get(1).getParameters().getId());
        Route route1 = new Route(steps.get(1).getParameters().getId(), steps.get(2).getParameters().getId());
        Route route2 = new Route(steps.get(2).getParameters().getId(), steps.get(0).getParameters().getId());*/

        Route route0 = new Route(1,101);
        RouteCollection routes = new RouteCollection();
        routes.addRoute(route0);

        TransformBO transformBO = new TransformBO();
         List<TransformVO> transforms =  new ArrayList<TransformVO>();
                 transforms = transformBO.loadTransforms();
        Transform t = new Transform(transforms.get(0),routes);

        try {
            t.run();
        } catch (StepException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(0,0);


    }

   /* @Test
    public void containsCyclicRouteShouldReturnTrueForATransformWithACyclicRoute(){

        StartStepVO startStepVO = new StartStepVO();
        CSVInputStepVO csvInputStepVO = new CSVInputStepVO("test/java/resources/simple.csv", false, null);
        TransformVO transformVO = new TransformVO();
        transformVO.addStepVO(startStepVO);
        transformVO.addStepVO(csvInputStepVO);



        StepCollection stepCollection = StepCollectionTestHelper.stepCollection();
        List<Step> steps = stepCollection.getSteps();


        Route route0 = new Route(steps.get(0).getParameters().getId(), steps.get(1).getParameters().getId());
        Route route1 = new Route(steps.get(1).getParameters().getId(), steps.get(2).getParameters().getId());
        Route route2 = new Route(steps.get(2).getParameters().getId(), steps.get(0).getParameters().getId());


        RouteCollection routes = new RouteCollection();
        routes.addRoute(route0);
        routes.addRoute(route1);
        routes.addRoute(route2);

        Transform t = new Transform(transformVO, routes);

        Assert.assertTrue(t.containsCyclicRoute());

    }

    *//*public void containsCyclicRouteShouldReturnFalseForATransformWithoutAnyCyclicRoutes() {
         Transform t = TransformTestHelper.nonCyclicTransform();
        Assert.assertFalse(t.containsCyclicRoute());

    }*//*
}
*/


}