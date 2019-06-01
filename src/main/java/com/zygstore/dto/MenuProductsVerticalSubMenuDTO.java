package com.zygstore.dto;

import com.zygstore.business.MenuProductsBean;
import org.apache.log4j.Logger;

public class MenuProductsVerticalSubMenuDTO {
    final static Logger logger = Logger.getLogger(MenuProductsBean.class);
    private String prodVerticalSubMenuItem1;
    private String prodVerticalSubMenuItem2;
    private String prodVerticalSubMenuItem3;
    private String prodVerticalSubMenuItem4;
    private String prodVerticalSubMenuItem5;
    private String prodVerticalSubMenuItem6;
    private String prodVerticalSubMenuItem7;
    private String prodVerticalSubMenuItem8;
    private String prodVerticalSubMenuItem9;
    private String prodVerticalSubMenuItem10;
    private String prodVerticalSubMenuItem11;
    private String prodVerticalSubMenuItem12;

    public MenuProductsVerticalSubMenuDTO(String prodVerticalSubMenuItem1, String prodVerticalSubMenuItem2, String prodVerticalSubMenuItem3, String prodVerticalSubMenuItem4, String prodVerticalSubMenuItem5, String prodVerticalSubMenuItem6, String prodVerticalSubMenuItem7, String prodVerticalSubMenuItem8, String prodVerticalSubMenuItem9, String prodVerticalSubMenuItem10, String prodVerticalSubMenuItem11, String prodVerticalSubMenuItem12) {
        this.prodVerticalSubMenuItem1 = prodVerticalSubMenuItem1;
        this.prodVerticalSubMenuItem2 = prodVerticalSubMenuItem2;
        this.prodVerticalSubMenuItem3 = prodVerticalSubMenuItem3;
        this.prodVerticalSubMenuItem4 = prodVerticalSubMenuItem4;
        this.prodVerticalSubMenuItem5 = prodVerticalSubMenuItem5;
        this.prodVerticalSubMenuItem6 = prodVerticalSubMenuItem6;
        this.prodVerticalSubMenuItem7 = prodVerticalSubMenuItem7;
        this.prodVerticalSubMenuItem8 = prodVerticalSubMenuItem8;
        this.prodVerticalSubMenuItem9 = prodVerticalSubMenuItem9;
        this.prodVerticalSubMenuItem10 = prodVerticalSubMenuItem10;
        this.prodVerticalSubMenuItem11 = prodVerticalSubMenuItem11;
        this.prodVerticalSubMenuItem12 = prodVerticalSubMenuItem12;
        logger.info("MenuProductsVerticalSubMenuDTO initialized!");
    }

    public MenuProductsVerticalSubMenuDTO(String prodVerticalSubMenuItem1, String prodVerticalSubMenuItem2, String prodVerticalSubMenuItem3, String prodVerticalSubMenuItem4, String prodVerticalSubMenuItem5) {
        this.prodVerticalSubMenuItem1 = prodVerticalSubMenuItem1;
        this.prodVerticalSubMenuItem2 = prodVerticalSubMenuItem2;
        this.prodVerticalSubMenuItem3 = prodVerticalSubMenuItem3;
        this.prodVerticalSubMenuItem4 = prodVerticalSubMenuItem4;
        this.prodVerticalSubMenuItem5 = prodVerticalSubMenuItem5;
    }

    public String getProdVerticalSubMenuItem1() {
        return prodVerticalSubMenuItem1;
    }

    public String getProdVerticalSubMenuItem2() {
        return prodVerticalSubMenuItem2;
    }

    public String getProdVerticalSubMenuItem3() {
        return prodVerticalSubMenuItem3;
    }

    public String getProdVerticalSubMenuItem4() {
        return prodVerticalSubMenuItem4;
    }

    public String getProdVerticalSubMenuItem5() {
        return prodVerticalSubMenuItem5;
    }

    public String getProdVerticalSubMenuItem6() {
        return prodVerticalSubMenuItem6;
    }

    public String getProdVerticalSubMenuItem7() {
        return prodVerticalSubMenuItem7;
    }

    public String getProdVerticalSubMenuItem8() {
        return prodVerticalSubMenuItem8;
    }

    public String getProdVerticalSubMenuItem9() {
        return prodVerticalSubMenuItem9;
    }

    public String getProdVerticalSubMenuItem10() {
        return prodVerticalSubMenuItem10;
    }

    public String getProdVerticalSubMenuItem11() {
        return prodVerticalSubMenuItem11;
    }

    public String getProdVerticalSubMenuItem12() {
        return prodVerticalSubMenuItem12;
    }
}
