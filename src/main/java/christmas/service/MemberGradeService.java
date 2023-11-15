package christmas.service;

public class MemberGradeService {
    public String getGrade(Integer totalSalePrice) {
        String grade = "없음";
        if (totalSalePrice > 5000) {
            grade = "별";
        }
        if (totalSalePrice > 10000) {
            grade = "트리";
        }
        if (totalSalePrice > 20000) {
            grade = "산타";
        }

        return grade;
    }
}
