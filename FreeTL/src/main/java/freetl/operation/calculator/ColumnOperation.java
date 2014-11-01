package freetl.operation.calculator;

import java.util.List;

public interface ColumnOperation<T> {
    T performOperation(List<T> parameters);
}
