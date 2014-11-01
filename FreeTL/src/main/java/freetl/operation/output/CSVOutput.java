package freetl.operation.output;

import au.com.bytecode.opencsv.CSVWriter;
import freetl.descriptor.StepDescriptor;
import freetl.descriptor.StepParameterDescriptor;
import freetl.util.DataCollection;
import freetl.util.FieldInfo;
import freetl.util.Record;
import freetl.exceptions.StepException;
import freetl.operation.AbstractStep;

import java.io.FileWriter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CSVOutput extends AbstractStep<CSVOutput.Parameters> {


    public CSVOutput() { }

    @Override
    public DataCollection run(DataCollection data) throws StepException {

        CSVWriter writer = null;
        try {
            writer = new CSVWriter(new FileWriter(parameters.filename), ',');


            for (Record row : data) {

                List<Object> inputData = row.getData();
                List<String> outputData = new ArrayList<String>();

                for(int i = 0; i < inputData.size(); i++) {
                    String str = null;
                    FieldInfo ft = parameters.fieldInfos.get(i);
                    Class type = ft.getType();

                    if (type.equals(Date.class)){
                        SimpleDateFormat formatter = new SimpleDateFormat(ft.getFormat());
                        str = formatter.format(inputData.get(i));
                    }

                    else if (type.equals(Number.class)) {
                        DecimalFormat formatter = new DecimalFormat(ft.getFormat());
                        str = formatter.format(inputData.get(i));
                    }
                    else {
                        str = inputData.get(i).toString();
                    }

                    outputData.add(str);
                }

                String[] entries = outputData.toArray(new String[outputData.size()]);
                writer.writeNext(entries);
            }

            writer.close();

        } catch (Exception e) {
           throw new StepException(e);
        }

        return data;
    }

    @Override
    public StepDescriptor getDescriptor(){
        List<StepParameterDescriptor> params = new ArrayList<StepParameterDescriptor>();
        params.add(new StepParameterDescriptor("Filename", parameters.getFilename()));
        params.add(new StepParameterDescriptor("FieldTypes", "toil and Trouble"));
        return new StepDescriptor(params, getStepLabel(), parameters.getId());


    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractStep that = (AbstractStep) o;

        if (parameters != null ? !parameters.equals(that.getParameters()) : that.getParameters() != null) return false;

        return true;
    }


    @Override
    public int hashCode() {
        return parameters != null ? parameters.hashCode() : 0;
    }

    @Override
    public String
    toString() {
        return "StartStep{" +
                "parameters=" + parameters +
                '}';
    }

    public static class Parameters extends AbstractStep.AbstractParameters {
        private String filename;
        private List<FieldInfo> fieldInfos;

        public Parameters(String filename, List<FieldInfo> fieldInfos) {
            this.filename = filename;
            this.fieldInfos = fieldInfos;
        }

        public Parameters() {
        }

        public String getFilename() {
            return filename;
        }

        public void setFilename(String filename) {
            this.filename = filename;
        }

        public List<FieldInfo> getFieldInfos() {
            return fieldInfos;
        }

        public void setFieldInfos(List<FieldInfo> fieldInfos) {
            this.fieldInfos = fieldInfos;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Parameters that = (Parameters) o;

            if (fieldInfos != null ? !fieldInfos.equals(that.fieldInfos) : that.fieldInfos != null) return false;
            if (filename != null ? !filename.equals(that.filename) : that.filename != null) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = filename != null ? filename.hashCode() : 0;
            result = 31 * result + (fieldInfos != null ? fieldInfos.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return "Parameters{" +
                    "filename='" + filename + '\'' +
                    ", fieldTypes=" + fieldInfos +
                    '}';
        }
    }


}


