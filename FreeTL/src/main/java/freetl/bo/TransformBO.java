package freetl.bo;

import freetl.operation.Transform;
import freetl.util.PersistenceManager;
import freetl.util.RouteCollection;
import freetl.vo.TransformVO;
import freetl.vo.step.operation.start.StartStepVO;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class TransformBO {

    public Transform  newTransform(TransformVO transformVO, RouteCollection routes){

         return null;

    }

    public TransformVO newTransformVO() {

        TransformVO transformVO = new TransformVO();
        transformVO.addStepVO(new StartStepVO());
        return transformVO;

    }

    public TransformVO loadTransform(int id) {

        EntityManager em = PersistenceManager.getEntityManager();
        return em.find(TransformVO.class, id);


    }

    public List<TransformVO> loadTransforms() {

        EntityManager em = PersistenceManager.getEntityManager();
        Query q = em.createQuery("SELECT t FROM TransformVO t");

        return q.getResultList();
    }

    public void saveTransform(TransformVO transformVO) {

        EntityManager em = PersistenceManager.getEntityManager();
        em.getTransaction().begin();

        if (transformVO.getId() == 0) {
            em.persist(transformVO);
        } else {
            em.merge(transformVO);
        }
        em.getTransaction().commit();

        em.close();

    }


}
