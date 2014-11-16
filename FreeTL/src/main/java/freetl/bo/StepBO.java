package freetl.bo;

import freetl.operation.Step;
import freetl.util.PersistenceManager;
import freetl.vo.TransformVO;
import freetl.vo.step.StepVO;

import javax.persistence.EntityManager;

public class StepBO {

        public Step newStep(StepVO stepVO){

              return null;
        }



        public StepVO loadStep(int id) {

            EntityManager em = PersistenceManager.getEntityManager();
            return em.find(StepVO.class, id);
        }





    }
