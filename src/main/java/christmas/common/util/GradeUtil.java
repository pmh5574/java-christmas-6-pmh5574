package christmas.common.util;

public enum GradeUtil {
    NO("없음"),
    STAR("별"),
    TREE("트리"),
    SANTA("산타");

    private final String data;

    GradeUtil(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}
