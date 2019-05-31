package com.zygstore.business;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.zygstore.config.Context;
import com.zygstore.dto.MenuProductsDTO;
import com.zygstore.service.MenuProductsService;
import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */
@ManagedBean(name = "menuProductsBean", eager = true)
@SessionScoped
public class MenuProductsBean{
    private String displayField;
    private Context context;
    final static Logger logger = Logger.getLogger(MenuProductsBean.class);

    MenuProductsService menuProductsService;

    private MenuProductsDTO menuProductsDTO;

//    @PostConstruct
//    public void postConstract(){
//        ctx.getBean("menuProductsDTO");
//    }

    public MenuProductsBean() {
        System.out.println("MenuProductsBean zainicjalizowany !");
        logger.info("MenuProductsBean initialized!");
        displayField = "TEST_CHECK";
        this.displayField = displayField;

        //        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(CLASSPATH);

//        MenuProductsDTO menuProductsDTO = ctx.getBean(MenuProductsDTO.class);

//        logger.info("Values of first item:" + menuProductsDTO.getProdMenuItem1().toString());
    }

    public void initPage() {
       menuProductsDTO = menuProductsService.getMenuProductsDTO();
        //menuProductsDTO
    }

    public MenuProductsDTO getMenuProductsDTO() {
        return menuProductsDTO;
    }

    public String getDisplayField() {
        return displayField;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public Context getContext() {
        return context;
    }

    public void setMenuProductsService(MenuProductsService menuProductsService) {
        this.menuProductsService = menuProductsService;
    }


}
