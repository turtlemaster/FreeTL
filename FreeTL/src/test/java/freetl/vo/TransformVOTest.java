package freetl.vo;

import freetl.util.PersistenceManager;
import freetl.vo.step.CSVInputStepVO;
import freetl.vo.type.DataType;
import org.junit.Test;
import org.relaxng.datatype.Datatype;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

public class TransformVOTest {

    @Test
    public void whenATransformVOIsSavedToTheDatabaseTheLoadedTransformVOShouldHaveTheSameData(){

        TransformVO transformVO = new TransformVO();
        transformVO.setName("SuperTurtle");

        CSVInputStepVO stepVO1 = new CSVInputStepVO();
        stepVO1.setName("Stepperoo");
        transformVO.addStepVO(stepVO1);

        FieldInfoVO fieldInfoVO1 = new FieldInfoVO();
        fieldInfoVO1.setName("Pupperoni");
        fieldInfoVO1.setFormat("mm/dd/yy");
        fieldInfoVO1.setUsesFormat(true);
        fieldInfoVO1.setType(DataType.DATE);

        stepVO1.addFieldInfoVO(fieldInfoVO1);







        EntityManager em = PersistenceManager.getEntityManager();
        em.getTransaction().begin();
        em.persist(transformVO);
        em.getTransaction().commit();


        Query q = em.createQuery("SELECT t FROM TransformVO t WHERE t.name  = :name");
        q.setParameter("name",  "SuperTurtle");

        List<TransformVO> transformList = q.getResultList();
        for (TransformVO t : transformList) {
            System.out.println(t.getId());
            System.out.println(t.getName());

        }
        System.out.println("Size: " + transformList.size());


      /*  transformList.get(0).setName("OceanBlues");


        em.getTransaction().begin();
        em.merge(transformList.get(0));
        em.getTransaction().commit();

        Query ocean = em.createQuery("SELECT t FROM TransformVO t WHERE t.id = :id");
        ocean.setParameter("id",  transformList.get(0).getId());

        transformList = ocean.getResultList();
        for (TransformVO t : transformList) {
            System.out.println(t.getId());
            System.out.println(t.getName());

        }
        System.out.println("Size: " + transformList.size());
*/

        em.close();



    }


    public void clearDatabase(){

        EntityManager em = PersistenceManager.getEntityManager();

        Query q = em.createQuery("SELECT t FROM TransformVO t WHERE t.name  = :name");
        q.setParameter("name",  "SuperTurtle");

        List<TransformVO> transformList = q.getResultList();
        for (TransformVO t : transformList) {
            em.getTransaction().begin();
           em.remove(t);
           em.getTransaction().commit();

        }


        Query ocean = em.createQuery("SELECT t FROM TransformVO t WHERE t.name = :name");
        ocean.setParameter("name",  "OceanBlues");

        transformList = ocean.getResultList();
        for (TransformVO t : transformList) {
            em.getTransaction().begin();
            em.remove(t);
            em.getTransaction().commit();
        }



        em.close();

    }
}
