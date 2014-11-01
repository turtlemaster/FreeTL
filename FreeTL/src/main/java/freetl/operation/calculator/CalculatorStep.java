package freetl.operation.calculator;

import freetl.descriptor.StepDescriptor;
import freetl.util.DataCollection;
import freetl.util.Record;
import freetl.exceptions.StepException;
import freetl.operation.AbstractStep;
import freetl.util.Calculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalculatorStep extends AbstractStep<CalculatorStep.Parameters> {
    private static final Map<OperationType, BinaryOperationFunction> OPERATIONS;

    static {
        OPERATIONS = new HashMap<OperationType, BinaryOperationFunction>();
        OPERATIONS.put(OperationType.ADD, new AddFunction());
        OPERATIONS.put(OperationType.SUBTRACT, new SubtractFunction());
        OPERATIONS.put(OperationType.MULTIPLY, new MultiplyFunction());
        OPERATIONS.put(OperationType.DIVIDE, new DivideFunction());
    }


    public CalculatorStep() {
    }

    @Override
    public DataCollection run(DataCollection data) throws StepException {

        //List<String> fieldNames = parameters.colsToPerformOperationOn;
        String destination = parameters.destinationCol;

        List<Integer> colIndex = new ArrayList<Integer>();
        for (String fieldName : parameters.colsToPerformOperationOn) {
            for (int i = 0; i < data.getFieldInfos().size(); i++) {
                if (data.getFieldInfos().get(i).getFieldname().equals(fieldName)) {
                    colIndex.add(i);
                }
            }
        }

        Integer resultIndex = null;
        for (int i = 0; i < data.getFieldInfos().size(); i++) {
            if (data.getFieldInfos().get(i).getFieldname().equals(destination)) {
                resultIndex = i;
                break;
            }


        }


        List<Record> recordList = data.getRecordList();
        Calculator calc = new Calculator();
        Record currentRecord;

        for (Record aRecordList : recordList) {
            currentRecord = aRecordList;

            BinaryOperationFunction func = OPERATIONS.get(parameters.operation);
            Number result = func.performOperation(calc, (Number) currentRecord.getField(colIndex.get(0)), (Number) currentRecord.getField(colIndex.get(1)));

            if (resultIndex != null) {
                currentRecord.setField(resultIndex, result);
            } else if (destination == null) {
                currentRecord.addField(result);
            } else {
                throw new IllegalArgumentException("Invalid Column Destination");
            }
        }


        return null;


    }

    @Override
    public StepDescriptor getDescriptor() {

        /*private List<String> colsToPerformOperationOn;
        private OperationType operation;
        private String destinationCol;*/

        return null;
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
        return "CalculatorStep{" +
                "parameters=" + parameters +
                '}';
    }

    public static class Parameters extends AbstractStep.AbstractParameters{

        private List<String> colsToPerformOperationOn;
        private OperationType operation;
        private String destinationCol;

        public Parameters(List<String> colsToPerformOperationOn, OperationType operation, String destinationCol) {
            this.colsToPerformOperationOn = colsToPerformOperationOn;
            this.operation = operation;
            this.destinationCol = destinationCol;

        }

        public List<String> getColsToPerformOperationOn() {
            return colsToPerformOperationOn;
        }

        public void setColsToPerformOperationOn(List<String> colsToPerformOperationOn) {
            this.colsToPerformOperationOn = colsToPerformOperationOn;
        }

        public OperationType getOperation() {
            return operation;
        }

        public void setOperation(OperationType operation) {
            this.operation = operation;
        }

        public String getDestinationCol() {
            return destinationCol;
        }

        public void setDestinationCol(String destinationCol) {
            this.destinationCol = destinationCol;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Parameters that = (Parameters) o;

            if (colsToPerformOperationOn != null ? !colsToPerformOperationOn.equals(that.colsToPerformOperationOn) : that.colsToPerformOperationOn != null)
                return false;
            if (destinationCol != null ? !destinationCol.equals(that.destinationCol) : that.destinationCol != null)
                return false;
            if (operation != that.operation) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = colsToPerformOperationOn != null ? colsToPerformOperationOn.hashCode() : 0;
            result = 31 * result + (operation != null ? operation.hashCode() : 0);
            result = 31 * result + (destinationCol != null ? destinationCol.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return "Parameters{" +
                    "colsToPerformOperationOn=" + colsToPerformOperationOn +
                    ", operation=" + operation +
                    ", destinationCol='" + destinationCol + '\'' +
                    '}';
        }
    }

    private static interface BinaryOperationFunction {
         Number performOperation(Calculator calc, Number n1, Number n2);
    }

    private static class AddFunction implements BinaryOperationFunction {
        public Number performOperation(Calculator calc, Number n1, Number n2) {
            return calc.performSum(n1, n2);
        }

    }

    private static class SubtractFunction implements BinaryOperationFunction {
        public Number performOperation(Calculator calc, Number n1, Number n2) {
            return calc.performSubtraction(n1, n2);
        }

    }

    private static class MultiplyFunction implements BinaryOperationFunction {
        public Number performOperation(Calculator calc, Number n1, Number n2) {
            return calc.performMultiplication(n1, n2);
        }

    }

    private static class DivideFunction implements BinaryOperationFunction {
        public Number performOperation(Calculator calc, Number n1, Number n2) {
            return calc.performDivision(n1, n2);
        }
    }



}
