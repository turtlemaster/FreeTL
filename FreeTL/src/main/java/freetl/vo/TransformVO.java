package freetl.vo;

import freetl.vo.step.StepVO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="ft_transform")
public class TransformVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;
                                    // StepVO.transform  : TransformVO
    @OneToMany(mappedBy = "transform", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<StepVO> stepCollection;


    public TransformVO() {
        stepCollection = new ArrayList<StepVO>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<StepVO> getStepCollection() { return stepCollection;}

    public void setStepCollection(List<StepVO> stepCollection) {
        this.stepCollection = stepCollection;
    }

    public void addStepVO(StepVO stepVO) {

        stepVO.setTransform(this);
        stepCollection.add(stepVO);

    }

    public void removeStepVO(StepVO stepVO) {

        stepCollection.remove(stepVO);
    }

    public StepVO getStepVO(int stepId) {
        for (StepVO step : stepCollection) {
            if (step.getId() == stepId) {
                return step;
            }
        }

       return null;
    }

    public void replaceStep(StepVO stepVO, int stepId) {
        int index = -1;

        for (int i = 0; i < stepCollection.size(); i++) {
            if(stepCollection.get(i).getId() == stepId) {
                index = i;
                break;
            }
        }

        stepCollection.set(index, stepVO);

    }
}
