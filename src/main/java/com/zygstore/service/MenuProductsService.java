package com.zygstore.service;

import com.zygstore.dto.MenuProductsDTO;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */

public class MenuProductsService {
    //@Autowired
    MenuProductsDTO menuProductsDTO;


    public MenuProductsDTO getMenuProductsDTO() {
        MenuProductsDTO menuProductsDTO = new MenuProductsDTO("Elektronika", "Telefony i Smartwatche",
            "Telewizory i RTV", "AGD", "Dom", "Ogród", "Dziecko", "Zdriowie i Uroda", "Moto", "Hobby", "Usługi");
        return menuProductsDTO;
    }
}
