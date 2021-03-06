package freetl.runner.operation.input;

import au.com.bytecode.opencsv.CSVReader;
import freetl.descriptor.StepDescriptor;
import freetl.descriptor.StepParameterDescriptor;
import freetl.operation.input.AbstractInput;
import freetl.util.DataCollection;
import freetl.util.FieldInfo;
import freetl.util.Record;
import freetl.exceptions.StepException;
import freetl.operation.AbstractStep;
import freetl.util.ListUtil;
import freetl.vo.FieldInfoVO;
import freetl.vo.step.operation.input.CSVInputStepVO;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVInput extends AbstractInput<CSVInputStepVO, CSVInput.Parameters> {

    public CSVInput() { }

    public CSVInput(CSVInputStepVO stepVO) {
        super(stepVO);
    }

    @Override
    public DataCollection run(DataCollection data)  throws StepException {

        try {
            FileReader fileReader = new FileReader(stepVO.getFilename());
            CSVReader csvReader = new CSVReader(fileReader, ',', '"');
            DataCollection csvData = new DataCollection();

            String[] csvLine = csvReader.readNext();
            for (int i = 0; i < csvLine.length; i++) {
                csvLine[i] = csvLine[i].trim();
            }


            if (stepVO.getFieldInfoList() == null) {
                if (stepVO.hasHeader()) {
                    csvData.setFieldInfos(createFieldTypesFromHeader(csvLine));
                    csvLine = csvReader.readNext();
                } else {
                    csvData.setFieldInfos(createFieldsTypesForNumberOfColumns(csvLine.length));
                }
            }

            else {
                if (stepVO.hasHeader()) {
                    csvLine = csvReader.readNext();

                }

                csvData.setFieldInfos(stepVO.getFieldInfoList());
            }





            while (csvLine != null) {
                List<Object> processedCSVLine = new ArrayList<Object>();

                List<String> csvLineAsList = new ArrayList<String>();
                csvLineAsList.addAll(Arrays.asList(csvLine));
                csvLineAsList = ListUtil.trimElements(csvLineAsList);

                for(int i = 0; i < csvLineAsList.size(); i++) {
                    FieldInfoVO ft = stepVO.getFieldInfoList().get(i);

                    processedCSVLine.add(this.convertToDataType(ft, csvLineAsList.get(i)));
                }

                csvData.add(new Record(processedCSVLine));

                csvLine = csvReader.readNext();

            }

            return csvData;
        } catch (Exception e) {
            throw new StepException(e);
        }
    }




    protected List<FieldInfoVO> createFieldsTypesForNumberOfColumns(int length) {
        List<FieldInfoVO> fieldInfoVOs = new ArrayList<FieldInfoVO>();
        for(int i = 0; i < length; i++){
            FieldInfoVO newFieldInfo = new FieldInfoVO();
            newFieldInfo.setName(String.valueOf(i + 1));
            fieldInfoVOs.add(newFieldInfo);


        }

        return fieldInfoVOs;
    }

    protected List<FieldInfoVO> createFieldTypesFromHeader(String[] cols) {
        List<FieldInfoVO> fieldInfoVOs = new ArrayList<FieldInfoVO>();
        for (String col : cols) {
            FieldInfoVO newFieldInfo = new FieldInfoVO();
            newFieldInfo.setName(col);
            fieldInfoVOs.add(newFieldInfo);

        }


        return fieldInfoVOs;
    }

    public CSVInputStepVO getStepVO() {
        return stepVO;
    }

    public void setStepVO(CSVInputStepVO stepVO) {
        this.stepVO = stepVO;
    }

    public void addFieldType(FieldInfo fieldInfo, int index) {
        parameters.fieldInfos.add(index, fieldInfo);
    }

    public void removeFieldType(int index) {
        parameters.fieldInfos.remove(index);
    }

    public boolean hasHeader() {return parameters.isHasHeader();}

    @Override
    public StepDescriptor getDescriptor() {

        List<StepParameterDescriptor> params = new ArrayList<StepParameterDescriptor>();


        params.add(new StepParameterDescriptor("Filename:", parameters.filename));
        if(parameters.isHasHeader()) {
            params.add(new StepParameterDescriptor("Header", "true"));
        }
        else {params.add(new StepParameterDescriptor("Header", "false")); }

        List<FieldInfo> fieldTypesCopy = new ArrayList<FieldInfo>(parameters.fieldInfos);
        params.add(new StepParameterDescriptor("FieldTypes", fieldTypesCopy));


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
        return "CSVInput{" +
                "parameters=" + parameters +
                '}';
    }
    public static class Parameters extends AbstractStep.AbstractParameters{
        private String filename;
        private boolean hasHeader;
        private List<FieldInfo> fieldInfos;

        public Parameters() {

        }

        public Parameters(String filename, boolean hasHeader, List<FieldInfo> fieldInfos) {
            this.filename = filename;
            this.hasHeader = hasHeader;
            this.fieldInfos = fieldInfos;
        }



        public String getFilename() {
            return filename;
        }

        public boolean isHasHeader() {return hasHeader; }

        public List<FieldInfo> getFieldInfos() {
            return fieldInfos;
        }

        public void setFilename(String filename) {
            this.filename = filename;
        }

        public void setHasHeader(boolean hasHeader) {
            this.hasHeader = hasHeader;
        }

        public void setFieldInfos(List<FieldInfo> fieldInfos) {
            this.fieldInfos = fieldInfos;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Parameters that = (Parameters) o;

            if (hasHeader != that.hasHeader) return false;
            if (fieldInfos != null ? !fieldInfos.equals(that.fieldInfos) : that.fieldInfos != null) return false;
            if (filename != null ? !filename.equals(that.filename) : that.filename != null) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = filename != null ? filename.hashCode() : 0;
            result = 31 * result + (hasHeader ? 1 : 0);
            result = 31 * result + (fieldInfos != null ? fieldInfos.hashCode() : 0);
            return result;
        }


        @Override
        public String toString() {
            return "Parameters{" +
                    "filename='" + filename + '\'' +
                    ", hasHeader=" + hasHeader +
                    ", fieldTypes=" + fieldInfos +
                    '}';
        }
    }


}
