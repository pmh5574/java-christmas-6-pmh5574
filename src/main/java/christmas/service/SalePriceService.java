package christmas.service;

import christmas.common.util.PriceUtil;
import christmas.view.OutputView;
import java.text.NumberFormat;

public class SalePriceService {
    public boolean saleCheckAndPrice(Integer daySale, Integer specialSale, String dayPrint, Integer menuSalePrice, Integer giftSale, NumberFormat numberFormat, Integer totalPrice, OutputView outputView) {
        if (saleCheck(daySale, specialSale, dayPrint, menuSalePrice, giftSale, numberFormat, totalPrice, outputView)) {
            return false;
        }
        return true;
    }

    private boolean saleCheck(Integer daySale, Integer specialSale, String dayPrint, Integer menuSalePrice,
                              Integer giftSale, NumberFormat numberFormat, Integer totalPrice, OutputView outputView) {
        if (totalPrice <= PriceUtil.MIN_PRICE.getNumber()) {
            outputView.totalPriceCheck(PriceUtil.ZERO.getNumber());
            return true;
        }
        outputView.totalPriceCheck((daySale + menuSalePrice + specialSale + giftSale));
        saleList(daySale, specialSale, dayPrint, menuSalePrice, giftSale, numberFormat, outputView);
        return false;
    }

    private void saleList(Integer daySale, Integer specialSale, String dayPrint, Integer menuSalePrice,
                           Integer giftSale, NumberFormat numberFormat, OutputView outputView) {
        daySale(daySale, numberFormat, outputView);
        menuSalePrice(dayPrint, menuSalePrice, numberFormat, outputView);
        specialSale(specialSale, numberFormat, outputView);
        giftSale(giftSale, numberFormat, outputView);
    }

    private void giftSale(Integer giftSale, NumberFormat numberFormat, OutputView outputView) {
        if (zeroCheck(giftSale)) {
            outputView.giftSale(numberFormat.format(giftSale));
        }
    }

    private void specialSale(Integer specialSale, NumberFormat numberFormat, OutputView outputView) {
        if (zeroCheck(specialSale)) {
            outputView.specialSale(numberFormat.format(specialSale));
        }
    }

    private void menuSalePrice(String dayPrint, Integer menuSalePrice, NumberFormat numberFormat, OutputView outputView) {
        if (zeroCheck(menuSalePrice)) {
            outputView.weekSale(dayPrint, numberFormat.format(menuSalePrice));
        }
    }

    private void daySale(Integer daySale, NumberFormat numberFormat, OutputView outputView) {
        if (zeroCheck(daySale)) {
            outputView.dDaySale(numberFormat.format(daySale));
        }
    }

    private boolean zeroCheck(Integer price) {
        if (price > PriceUtil.ZERO.getNumber()) {
            return true;
        }
        return false;
    }
}
