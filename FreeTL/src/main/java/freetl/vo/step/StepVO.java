package freetl.vo.step;

import freetl.util.FieldInfo;
import freetl.vo.FieldInfoVO;
import freetl.vo.TransformVO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "step_type")
@Table(name="ft_Step")
public abstract class StepVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "transform_id", insertable = true, updatable = false)
    TransformVO transform;

    @OneToMany(mappedBy = "step", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<FieldInfoVO> fieldInfoList;

    protected StepVO() {
        fieldInfoList = new ArrayList<FieldInfoVO>();
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

    public TransformVO getTransform() {
        return transform;
    }

    public void setTransform(TransformVO transform) {
        this.transform = transform;
    }

    public void addFieldInfoVO(FieldInfoVO fieldInfo){

       fieldInfo.setStep(this);
       fieldInfoList.add(fieldInfo); }

    public void removeFieldInfoVO(FieldInfoVO fieldInfo) { fieldInfoList.remove(fieldInfo); }

    public List<FieldInfoVO> getFieldInfoList() {
        return fieldInfoList;
    }

    public void setFieldInfoList(List<FieldInfoVO> fieldInfoList) {
        this.fieldInfoList = fieldInfoList;
    }
}
