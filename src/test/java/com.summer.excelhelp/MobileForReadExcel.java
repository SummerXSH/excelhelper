package com.summer.excelhelp;

import com.summer.excelhelper.annotation.ImportField;

/**
 * @author xiashanhao
 * @date 2019-04-26 21:03
 */
public class MobileForReadExcel {

    private String mobile;

    @ImportField(index = 3)
    private String province;

    private String city;

    private String cardType;

    private String isExist;


    public String getMobile() {
        return mobile;
    }


    @ImportField(index = 0)
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @ImportField(index = 1)
    public void setCity(String city) {
        this.city = city;
    }

    @ImportField(index = 2)
    public void setCardType(String cardType) {
        this.cardType = cardType;
    }


    @Override
    public String toString() {
        return "MobileForReadExcel{" +
                "mobile='" + mobile + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", cardType='" + cardType + '\'' +
                ", isExist='" + isExist + '\'' +
                '}';
    }
}
