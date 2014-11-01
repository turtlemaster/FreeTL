package freetl.operation.input;

import freetl.util.FieldInfo;
import freetl.exceptions.StepException;
import freetl.operation.AbstractStep;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class AbstractInput<T extends AbstractStep.AbstractParameters> extends AbstractStep<T> {
    protected Object convertToDataType(FieldInfo ft, String s) throws ParseException, StepException {
        Class type = ft.getType();

        if (type.equals(Integer.class)) {
            return Integer.valueOf(s);

        } else if (type.equals((String.class))) {
            return s;

        } else if (type.equals(Date.class)) {
            SimpleDateFormat formatter = new SimpleDateFormat(ft.getFormat());
            return formatter.parse(s);

        } else if (type.equals(Number.class)) {
            DecimalFormat formatter = new DecimalFormat(ft.getFormat());
            return formatter.parse(s);

        } else {
            throw new StepException("Unknown data type.");
        }

    }
}
