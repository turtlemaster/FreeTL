package freetl.vo.input;

import freetl.testhelpers.FieldInfoListTestHelper;
import freetl.util.FieldInfo;
import freetl.util.PersistenceManager;
import freetl.vo.FieldInfoVO;
import freetl.vo.TransformVO;
import freetl.vo.step.operation.input.CSVInputStepVO;
import org.junit.Test;

import javax.persistence.EntityManager;
import java.util.List;

public class CSVInputVOTest {


    @Test
    public void testingCSVInputVOfeatures(){


        TransformVO transformVO = new TransformVO();
        transformVO.setName("CSVInputTurtle");

        CSVInputStepVO stepVO1 = new CSVInputStepVO();
        stepVO1.setName("StepCSV");


       List<FieldInfoVO> fieldInfoList = FieldInfoListTestHelper.employeeFieldInfoList();

        transformVO.addStepVO(stepVO1);

        EntityManager em = PersistenceManager.getEntityManager();
        em.getTransaction().begin();
        em.persist(transformVO);
        em.getTransaction().commit();

        em.close();



    }


}
