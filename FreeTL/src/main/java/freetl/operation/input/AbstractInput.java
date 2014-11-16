package freetl.operation.input;

import freetl.util.FieldInfo;
import freetl.exceptions.StepException;
import freetl.operation.AbstractStep;
import freetl.vo.FieldInfoVO;
import freetl.vo.step.StepVO;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class AbstractInput<T extends StepVO, U extends AbstractStep.AbstractParameters> extends AbstractStep<T, U> {


    protected AbstractInput() {
    }

    protected AbstractInput(T stepVO) {
        super(stepVO);
    }

    protected Object convertToDataType(FieldInfoVO ft, String s) throws ParseException, StepException {


        switch (ft.getType()) {
            case DATE: {
                SimpleDateFormat formatter = new SimpleDateFormat(ft.getFormat());
                return formatter.parse(s);
            }

            case INTEGER:
                return Integer.valueOf(s);

            case NUMBER: {
                DecimalFormat formatter = new DecimalFormat(ft.getFormat());
                return formatter.parse(s);
            }

            case STRING:{
                return s;
            }

            default:{
                throw new StepException("Unknown data type.");
            }
        }

    }
}
