package freetl.util;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

    Calculator calc;

    @Before
    public void setup() {
        calc = new Calculator();
    }

    @Test
    public void addingZeroIntegersShouldReturnZero() {
        Assert.assertEquals(Integer.valueOf(0), calc.performSum(0));
    }



    @Test
    public void addingOneIntegerShouldReturnInteger() {
        Integer i = Integer.valueOf(1);
        Assert.assertEquals(i, calc.performSum(i));
    }

    @Test
    public void addingNIntegerShouldReturnInteger() {
        Integer i = Integer.valueOf(1);
        Integer j = Integer.valueOf(2);
        Integer k = Integer.valueOf(3);

        Assert.assertEquals(Integer.valueOf(6), calc.performSum(i, j, k));
    }

    @Test
    public void addingZeroDoublesShouldReturnZero() {
        Assert.assertEquals(Integer.valueOf(0), calc.performSum(0));
    }

    @Test
    public void addingOneDoublesShouldReturnDouble() {
        Double i = Double.valueOf(1.5);
        Assert.assertEquals(i, calc.performSum(i));
    }

    @Test
    public void addingNDoublesShouldReturnDouble() {
        Double i = Double.valueOf(1.5);
        Double j = Double.valueOf(2.5);
        Double k = Double.valueOf(3.5);

        Assert.assertEquals(Double.valueOf(7.5), calc.performSum(i, j, k));
    }

    @Test
    public void addingOneDoubleAndOneIntegerShouldReturnDouble() {
        Integer i = Integer.valueOf(1);
        Double j = Double.valueOf(2.5);

        Assert.assertEquals(Double.valueOf(3.5), calc.performSum(i, j));
    }


    @Test
    public void addingOneNumberAndNullShouldReturnNull() {
        Integer i = Integer.valueOf(1);
        Integer j = null;

        Assert.assertNull(calc.performSum(i, j));
    }

    @Test
    public void subtractOneIntegerShouldReturnNull(){
        Integer i = 3;
        Assert.assertNull(calc.performSubtraction(i, null));
     }

    @Test
    public void subtractTwoIntegersShouldReturnInteger(){
        Integer i = 1;
        Integer j = 5;

        Assert.assertEquals(Integer.valueOf(4), calc.performSubtraction(j,i));
    }

    @Test
    public void subtractOneDoubleShouldReturnNull(){
        Double i = Double.valueOf(1.5);
        Assert.assertNull(calc.performSubtraction(i, null));

    }

    @Test
    public void subtractingTwoDoublesShouldReturnDouble() {
        Double i = Double.valueOf(1.5);
        Double j = Double.valueOf(2.0);


        Assert.assertEquals(Double.valueOf(0.5), calc.performSubtraction(j, i));
    }

    @Test
    public void subtractingIntFromDoubleShouldReturnDouble(){
        Integer i = 3;
        Double j = 7.0;
        Assert.assertEquals(Double.valueOf(4.0), calc.performSubtraction(j, i));
    }

    @Test
    public void subtractingDoubleFromIntShouldReturnDouble(){
        Integer i = 6;
        Double j = 4.5;
        Assert.assertEquals(Double.valueOf(1.5), calc.performSubtraction(i, j));
    }

    @Test
    public void multiplyingTwoIntegersShouldReturnInt(){
        Integer i = 3;
        Integer j = 4;
        Assert.assertEquals(Integer.valueOf(12), calc.performMultiplication(j,i));

    }

    @Test
    public void  multiplyingTwoDoublesShouldReturnDouble(){
        Double i  = 3.0;
        Double j = 1.1;
        Assert.assertEquals(3.3, calc.performMultiplication(j, i).doubleValue(), 0.0003);
    }

     @Test
    public void multiplyingIntegerAndDoubleShouldReturnDouble(){
         Integer i = 4;
         Double j = 2.0;
         Assert.assertEquals(8.0, calc.performMultiplication(j, i).doubleValue(), 0.0003);


     }

    @Test
    public void multiplyingIntegerByZeroShouldReturnZero() {
        Integer i = 0;
        Integer j = 4;
        Assert.assertEquals(Integer.valueOf(0), calc.performMultiplication(j,i));
    }

    @Test
    public void dividingIntegerByZeroShouldGiveError() {
        Integer i = 4;
        Integer j = 0;
        Assert.assertNull(calc.performDivision(i,j));
    }

    @Test
    public void dividingBigIntegerByLittleIntegerShouldReturnInteger() {
        Integer i = 5;
        Integer j = 4;
        Assert.assertEquals(Integer.valueOf(1), calc.performDivision(i,j));


    }

    @Test
    public void dividingLittleIntegerByBigIntegerShouldReturnInteger() {
        Integer i = 4;
        Integer j = 5;
        Assert.assertEquals(Integer.valueOf(0), calc.performDivision(i,j));


    }

    @Test
    public void dividingDoubleByDoubleShouldReturnDouble(){
        Double i  = 3.0;
        Double j = 1.0;
        Assert.assertEquals(0.3333333333, calc.performDivision(j, i).doubleValue(), 0.0003);
    }

    @Test
    public void dividingIntegerByDoubleShouldReturnDouble() {
        Integer i = 4;
        Double j = 2.0;
        Assert.assertEquals(2.0, calc.performDivision(i, j).doubleValue(), 0.0003);

    }

}
