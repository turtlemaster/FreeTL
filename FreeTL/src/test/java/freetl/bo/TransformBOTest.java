package freetl.bo;

import freetl.testhelpers.TransformTestHelper;
import freetl.util.PersistenceManager;
import freetl.vo.TransformVO;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.EntityManager;
import java.util.List;

public class TransformBOTest {

   /* @Test
    public void whenTransformsAreLoadedFromTheDatabaseTheListShouldContainTheSameNumberOfTransformsAsTheDatabase(){

        TransformVO transformVO = TransformTestHelper.singleStepTrasnsformVO();
        EntityManager em = PersistenceManager.getEntityManager();
        em.getTransaction().begin();


        em.persist(transformVO);
        em.getTransaction().commit();
        em.close();


        TransformBO transformBO = new TransformBO();
        List<TransformVO> transformVOs = transformBO.loadTransformVOs();
        Assert.assertEquals(transformVOs.size(), 1);

    }*/
}
