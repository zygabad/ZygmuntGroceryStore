package com.zygstore.dto;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.zygstore.business.MenuProductsBean;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */
//@ManagedBean(name = "productMenuBean", eager = true)
//@SessionScoped
//    @Component
public class MenuProductsDTO {
    final static Logger logger = Logger.getLogger(MenuProductsBean.class);
    private String prodMenuItem1;
    private String prodMenuItem2;
    private String prodMenuItem3;
    private String prodMenuItem4;
    private String prodMenuItem5;
    private String prodMenuItem6;
    private String prodMenuItem7;
    private String prodMenuItem8;
    private String prodMenuItem9;
    private String prodMenuItem10;
    private String prodMenuItem11;

    public MenuProductsDTO(String prodMenuItem1, String prodMenuItem2, String prodMenuItem3, String prodMenuItem4, String prodMenuItem5,
                           String prodMenuItem6, String prodMenuItem7, String prodMenuItem8, String prodMenuItem9, String prodMenuItem10,
                           String prodMenuItem11) {
        this.prodMenuItem1 = prodMenuItem1;
        this.prodMenuItem2 = prodMenuItem2;
        this.prodMenuItem3 = prodMenuItem3;
        this.prodMenuItem4 = prodMenuItem4;
        this.prodMenuItem5 = prodMenuItem5;
        this.prodMenuItem6 = prodMenuItem6;
        this.prodMenuItem7 = prodMenuItem7;
        this.prodMenuItem8 = prodMenuItem8;
        this.prodMenuItem9 = prodMenuItem9;
        this.prodMenuItem10 = prodMenuItem10;
        this.prodMenuItem11 = prodMenuItem11;
        logger.info("MenuProductsDTO initialized!");
    }



    public String getProdMenuItem1() {
        return prodMenuItem1;
    }

    public String getProdMenuItem2() {
        return prodMenuItem2;
    }

    public String getProdMenuItem3() {
        return prodMenuItem3;
    }

    public String getProdMenuItem4() {
        return prodMenuItem4;
    }

    public String getProdMenuItem5() {
        return prodMenuItem5;
    }

    public String getProdMenuItem6() {
        return prodMenuItem6;
    }

    public String getProdMenuItem7() {
        return prodMenuItem7;
    }

    public String getProdMenuItem8() {
        return prodMenuItem8;
    }

    public String getProdMenuItem9() {
        return prodMenuItem9;
    }

    public String getProdMenuItem10() {
        return prodMenuItem10;
    }

    public String getProdMenuItem11() {
        return prodMenuItem11;
    }
}
