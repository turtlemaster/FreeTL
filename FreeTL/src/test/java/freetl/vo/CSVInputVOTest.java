package freetl.vo;

import freetl.testhelpers.FieldInfoListTestHelper;
import freetl.util.FieldInfo;
import freetl.util.PersistenceManager;
import freetl.vo.step.CSVInputStepVO;
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


       List<FieldInfo> fieldInfoList = FieldInfoListTestHelper.threeItemFieldTypeList();

        transformVO.addStepVO(stepVO1);

        EntityManager em = PersistenceManager.getEntityManager();
        em.getTransaction().begin();
        em.persist(transformVO);
        em.getTransaction().commit();

        em.close();



    }


}
