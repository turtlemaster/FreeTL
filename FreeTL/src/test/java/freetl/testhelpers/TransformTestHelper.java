package freetl.testhelpers;

import freetl.operation.Route;
import freetl.operation.Step;
import freetl.operation.Transform;
import freetl.util.RouteCollection;
import freetl.util.StepCollection;
import freetl.vo.FieldInfoVO;
import freetl.vo.TransformVO;
import freetl.vo.step.operation.input.CSVInputStepVO;
import freetl.vo.type.DataType;

import java.util.List;

public class TransformTestHelper {

    public static Transform nonCyclicTransform() {

        StepCollection stepCollection = StepCollectionTestHelper.stepCollection();
        List<Step> steps = stepCollection.getSteps();


        Route route0 = new Route(steps.get(0).getStepVOId(), steps.get(1).getStepVOId());
        Route route1 = new Route(steps.get(1).getStepVOId(), steps.get(2).getStepVOId());

        RouteCollection routes = new RouteCollection();
        routes.addRoute(route0);
        routes.addRoute(route1);

        return  new Transform(null, routes);

    }

    public static TransformVO singleStepTrasnsformVO(){

        TransformVO transformVO = new TransformVO();
        transformVO.setName("SuperTurtle");

        CSVInputStepVO stepVO1 = new CSVInputStepVO();
        stepVO1.setName("Stepperoo");
        FieldInfoVO fieldInfoVO1 = new FieldInfoVO();
        fieldInfoVO1.setName("Pupperoni");
        fieldInfoVO1.setFormat("mm/dd/yy");
        fieldInfoVO1.setUsesFormat(true);
        fieldInfoVO1.setType(DataType.DATE);

        stepVO1.addFieldInfoVO(fieldInfoVO1);
        transformVO.addStepVO(stepVO1);


        return transformVO;


    }
}
