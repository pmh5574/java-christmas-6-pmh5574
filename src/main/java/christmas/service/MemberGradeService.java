package christmas.service;

import christmas.common.util.GradeUtil;
import christmas.common.util.PriceUtil;

public class MemberGradeService {
    public String getGrade(Integer totalSalePrice) {
        String grade = GradeUtil.NO.getData();
        if (totalSalePrice >= PriceUtil.STAR.getNumber()) {
            grade = GradeUtil.STAR.getData();
        }
        if (totalSalePrice >= PriceUtil.TREE.getNumber()) {
            grade = GradeUtil.TREE.getData();
        }
        if (totalSalePrice >= PriceUtil.SANTA.getNumber()) {
            grade = GradeUtil.SANTA.getData();
        }

        return grade;
    }
}
