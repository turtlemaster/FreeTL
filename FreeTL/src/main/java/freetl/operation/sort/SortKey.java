package freetl.operation.sort;

public class SortKey {

    @SuppressWarnings("UnusedDeclaration")
    public enum Order { ASCENDING, DESCENDING }

    private String fieldName;
    private Order order;

    public SortKey(String fieldName, Order order) {
        this.fieldName = fieldName;
        this.order = order;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Order getOrder() {
        return order;
    }
}


