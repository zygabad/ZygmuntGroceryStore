package com.zygstore.service;

import com.zygstore.dto.MenuProductsDTO;
import com.zygstore.dto.MenuProductsHorizontalSubMenuDTO;
import com.zygstore.dto.MenuProductsSubMenuDTO;
import com.zygstore.dto.MenuProductsVerticalSubMenuDTO;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */

public class MenuProductsService {
    //@Autowired
    MenuProductsDTO menuProductsDTO;
    MenuProductsVerticalSubMenuDTO menuProductsVerticalSubMenuDTO;
    MenuProductsSubMenuDTO menuProductsSubMenuDTO;
    MenuProductsHorizontalSubMenuDTO menuProductsHorizontalSubMenuDTO;


    public MenuProductsDTO getMenuProductsDTO() {
        MenuProductsDTO menuProductsDTO = new MenuProductsDTO("Elektronika", "Telefony i Smartwatche",
            "Telewizory i RTV", "AGD", "Dom", "Ogród", "Dziecko", "Zdriowie i Uroda", "Moto", "Hobby", "Usługi");
        return menuProductsDTO;
    }

    public MenuProductsSubMenuDTO getMenuProductsSubMenuDTO() {
        MenuProductsSubMenuDTO menuProductsSubMenuDTO = new MenuProductsSubMenuDTO("TEST!!!");
        return menuProductsSubMenuDTO;
    }

        public MenuProductsVerticalSubMenuDTO getMenuProductsVerticalSubMenuDTO() {
        MenuProductsVerticalSubMenuDTO menuProductsVerticalSubMenuDTO = new MenuProductsVerticalSubMenuDTO("Laptopy | Tablety","Komputery i servery","Części PC"
                ,"Dla graczy","Peryferia PC","Sieci i komunikacja","Inteligentny dom","Oprogramowanie"
                ,"Akcesoria | Eksploatacja","Foto | Video","Biuro | Firma","Rozwiązania profesjonalne");
        return menuProductsVerticalSubMenuDTO;
    }

    public MenuProductsVerticalSubMenuDTO getMenuProductsVerticalSubMenuDTO2() {
        MenuProductsVerticalSubMenuDTO menuProductsVerticalSubMenuDTO = new MenuProductsVerticalSubMenuDTO("Telefony i Smartfony","Akcesoria GSM"
                ,"Telefonia VoIP","Telefonia analogowa","Smartwatche i zegarki");
        return menuProductsVerticalSubMenuDTO;
    }

    public MenuProductsHorizontalSubMenuDTO getMenuProductsHorizontalSubMenuDTO() {
        MenuProductsHorizontalSubMenuDTO menuProductsHorizontalSubMenuDTO = new MenuProductsHorizontalSubMenuDTO("Laptopy","Laptopy Apple Macbook"
                ,"Microsoft Surface","Akcesoria do laptopów"
                ,"Tablety","Akcesoria do tabletów","Czytniki e-book","Akcesoria do czytników");
        return menuProductsHorizontalSubMenuDTO;
    }
}
