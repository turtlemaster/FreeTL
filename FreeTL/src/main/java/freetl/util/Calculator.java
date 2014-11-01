package freetl.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculator {


    public Number performSum(Number... numbers) {

        Accumulator accumulator = new Accumulator();


        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == null) {
                return null;
            }
            accumulator.add(numbers[i]);

        }
        return accumulator.result();


    }

    public Number performSubtraction(Number operand1, Number operand2) {

        Accumulator accumulator = new Accumulator();

        if (operand1 == null || operand2 == null) {
            return null;
        }

        accumulator.add(operand1);
        accumulator.subtract(operand2);
        return accumulator.result();

    }

    public Number performMultiplication(Number operand1, Number operand2) {

        Accumulator accumulator = new Accumulator();

        if (operand1 == null || operand2 == null) {
            return null;
        }

        accumulator.add(operand1);
        accumulator.multiply(operand2);
        return accumulator.result();

    }

    public Number performDivision(Number operand1, Number operand2) {
        Accumulator accumulator = new Accumulator();

        if (operand1 == null || operand2 == null) {
            return null;
        }

        accumulator.add(operand1);
        accumulator.divide(operand2);
        return accumulator.result();
    }

    private static class Accumulator {

        private Class mode = Integer.class;
        private BigDecimal value;
        private boolean inErrorState = false;

        private Accumulator() {
            value = BigDecimal.ZERO;
        }

        private void add(Number number) {

            if (inErrorState) {
                return;
            }

            supportAccumulation(number.getClass());
            if (number instanceof Integer) {
                value = value.add(BigDecimal.valueOf((Integer) number));
            } else if (number instanceof Double) {
                value = value.add(BigDecimal.valueOf((Double) number));
            } else {
                throw new IllegalArgumentException("Wrong data type!");

            }


        }

        private void subtract(Number number) {

            if (inErrorState) {
                return;
            }

            supportAccumulation(number.getClass());
            if (number instanceof Integer) {
                value = value.subtract(BigDecimal.valueOf((Integer) number));
            } else if (number instanceof Double) {
                value = value.subtract(BigDecimal.valueOf((Double) number));
            } else {
                throw new IllegalArgumentException("Wrong data type!");

            }
        }

        public void multiply(Number number) {
            if (inErrorState) {
                return;
            }

            supportAccumulation(number.getClass());
            if (number instanceof Integer) {
                value = value.multiply(BigDecimal.valueOf((Integer) number));
            } else if (number instanceof Double) {
                value = value.multiply(BigDecimal.valueOf((Double) number));
            } else {
                throw new IllegalArgumentException("Wrong data type!");

            }
        }


        public void divide(Number number) {
            if(inErrorState) {
                return;
            }

            BigDecimal divisor = null;

            supportAccumulation(number.getClass());
            if (number instanceof Integer) {
                divisor = BigDecimal.valueOf((Integer) number);
            } else if (number instanceof Double) {
                divisor = BigDecimal.valueOf((Double) number);
            } else {
                throw new IllegalArgumentException("Wrong data type!");
            }

            try {
                value = value.divide(divisor, 10, RoundingMode.HALF_UP);
            } catch  (ArithmeticException e) {
                inErrorState = true;
            }

        }

        private void supportAccumulation(Class<? extends Number> clazz) {
            if (clazz.equals(Integer.class)) {
            } else if (clazz.equals(Double.class)) {
                mode = Double.class;
            }
        }

        private boolean isIntegerMode() {
            return mode.equals(Integer.class);
        }

        private boolean isDoubleMode() {
            return mode.equals(Double.class);
        }

        public Number result() {
            Number result = null;


            if (inErrorState) {
                return null;
            }

            if (isIntegerMode()) {
                result = new Integer(value.intValue());
            } else if (isDoubleMode()) {
                result = new Double(value.doubleValue());

            } else {
                throw new IllegalStateException("Incorrrect mode");
            }


            return result;  //To change body of created methods use File | Settings | File Templates.
        }
    }
}
