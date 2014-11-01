package freetl.operation.sort;

import freetl.util.FieldInfo;
import freetl.util.Record;

import java.util.List;


public class RecordComparator implements java.util.Comparator<Record> {
    private List<SortKey> sortKeys;
    private List<FieldInfo> fieldInfos;

    public RecordComparator(List<SortKey> sortKeys, List<FieldInfo> fieldInfos) {
        if (sortKeys == null || fieldInfos == null) {
            throw new IllegalArgumentException("Sortkeys and FieldTypes are required");
        }
        this.sortKeys = sortKeys;
        this.fieldInfos = fieldInfos;
    }

    @Override
    public int compare(Record r1, Record r2) {
        Object r1Type;
        Object r2Type;

        for (SortKey key : sortKeys) {

            int multiplier = key.getOrder().equals(SortKey.Order.ASCENDING) ? 1 : -1;

            FieldInfo match = null;
            int index = 0;
            for (int i = 0; i < fieldInfos.size(); i++) {
                if (key.getFieldName().equals(fieldInfos.get(i).getFieldname())) {
                    match = fieldInfos.get(i);
                    index = i;
                    break;
                }
            }

            int compare = 0;
            if (match != null) {

                r1Type = r1.getField(index);
                r2Type = r2.getField(index);

                if (r1Type instanceof Comparable) {
                    //noinspection unchecked
                    compare = ((Comparable) r1Type).compareTo(r2Type);
                } else {
                    throw new RuntimeException("Unexpected type: " + r1Type.getClass().getSimpleName());
                }
            }

            if (compare > 0) {
                return multiplier;
            } else if (compare < 0) {
                return -1 * multiplier;
            }

        }

        return 0;
    }
}
