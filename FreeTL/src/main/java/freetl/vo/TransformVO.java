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

    public List<StepVO> getStepCollection() { return stepCollection;
    }

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


}
