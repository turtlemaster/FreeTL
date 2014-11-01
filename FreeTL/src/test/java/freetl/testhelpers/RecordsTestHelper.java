package freetl.testhelpers;

import freetl.util.Record;

import java.util.ArrayList;
import java.util.List;

public class RecordsTestHelper {

    public static Record newSimpleRecord(String firstName, String lastName, int age) {
        List<Object> data = new ArrayList<Object>();
        data.add(firstName);
        data.add(lastName);
        data.add(age);
        return new Record(data);
    }

  public static Record newEmployeeRecord(String firstName, Integer wage, Integer raise, Integer newWage, Double hoursWorked, Double daysWorked, Double totalHours ){
      List<Object> data = new ArrayList<Object>();
      data.add(firstName);
      data.add(wage);
      data.add(raise);
      data.add(newWage);
      data.add(hoursWorked);
      data.add(daysWorked);
      data.add(totalHours);
      return new Record(data);
    }

    public static Record newNumbersRecord() {
        List<Object> data = new ArrayList<Object>();
        data.add(Integer.valueOf(1));
        data.add(Integer.valueOf(2));
        data.add(Integer.valueOf(0));
        data.add(Double.valueOf(11.5));
        data.add(Double.valueOf(12.5));
        data.add(Double.valueOf(13.5));
        return new Record(data);
    }

    public static Record newNumbersRecord(Number... numbers) {
        List<Object> data = new ArrayList<Object>();

        for (Number n : numbers) {
            data.add(n);
        }
        return new Record(data);
    }
}
