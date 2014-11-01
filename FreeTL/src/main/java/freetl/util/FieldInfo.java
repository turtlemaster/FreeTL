package freetl.util;


public class FieldInfo {

    private String fieldname;
    private Class type;
    private Boolean usesFormat;
    private String format;



    public FieldInfo() {
        fieldname = "n/a";
        type = String.class;
        usesFormat = false;
        format = null;
    }

    public FieldInfo(String fieldname, Class type, Boolean usesFormat, String format) {
        this.fieldname = fieldname;
        this.type = type;
        this.usesFormat = usesFormat;
        this.format = format;
    }

    public String getFieldname() {
        return fieldname;
    }

    public void setFieldname(String fieldname) {
        this.fieldname = fieldname;
    }

    public Class getType() {
        return type;
    }

    public void setType(Class type) {
        this.type = type;
    }

    public Boolean getUsesFormat() {
        return usesFormat;
    }

    public void setUsesFormat(Boolean usesFormat) {
        this.usesFormat = usesFormat;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public String toString() {
        return "FieldType{" +
                "fieldname='" + fieldname + '\'' +
                ", type=" + type +
                ", usesFormat=" + usesFormat +
                ", format='" + format + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FieldInfo fieldInfo = (FieldInfo) o;

        if (fieldname != null ? !fieldname.equals(fieldInfo.fieldname) : fieldInfo.fieldname != null) return false;
        if (format != null ? !format.equals(fieldInfo.format) : fieldInfo.format != null) return false;
        if (type != null ? !type.equals(fieldInfo.type) : fieldInfo.type != null) return false;
        if (usesFormat != null ? !usesFormat.equals(fieldInfo.usesFormat) : fieldInfo.usesFormat != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = fieldname != null ? fieldname.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (usesFormat != null ? usesFormat.hashCode() : 0);
        result = 31 * result + (format != null ? format.hashCode() : 0);
        return result;
    }
}
