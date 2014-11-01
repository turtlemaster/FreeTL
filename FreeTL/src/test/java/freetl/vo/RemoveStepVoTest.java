package freetl.vo;

import freetl.util.PersistenceManager;
import freetl.vo.step.StepVO;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class RemoveStepVoTest {


    @Test
    public void whenAStepVOIsRemovedFromTransformItShouldNoLongerBeInDatabase() {

        EntityManager em = PersistenceManager.getEntityManager();

        Query q = em.createQuery("SELECT t FROM TransformVO t WHERE t.name  = :name");
        q.setParameter("name",  "SuperTurtle");

        List<TransformVO> transformList = q.getResultList();

        for (TransformVO t : transformList) {
            System.out.println(t.getId());
            System.out.println(t.getName());

        }


        TransformVO transformVO = transformList.get(0);

        List<StepVO> steps = transformVO.getStepCollection();
        StepVO stepForRemoval = steps.get(0);
        transformVO.removeStepVO(stepForRemoval);




        em.getTransaction().begin();
        em.remove(stepForRemoval);
        em.merge(transformVO);
        em.getTransaction().commit();



        Query q2 = em.createQuery("SELECT s FROM StepVO s WHERE s.name  = :name");
        q2.setParameter("name",  "HopHopHop");
        List<StepVO> stepVOs = q2.getResultList();
        StepVO stepEdit = stepVOs.get(0);

        stepEdit.setName("Booger");


        em.getTransaction().begin();
        em.merge(stepEdit);
        em.getTransaction().commit();

        em.close();

    }
}