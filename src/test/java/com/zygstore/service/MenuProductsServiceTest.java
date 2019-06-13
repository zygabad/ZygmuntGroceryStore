package com.zygstore.service;

import java.util.ArrayList;


import static org.junit.Assert.assertEquals;

import com.zygstore.dto.MenuProductsDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */

public class MenuProductsServiceTest {

    @Test
    public void getAllMenuItemsDTO() {
        //given
        MenuProductsService menuProductsService = new MenuProductsService();
        ArrayList<String> linesFromFile = new ArrayList<>();
        linesFromFile.add("1;0;Elektronika;");

        //when
        ArrayList<MenuProductsDTO> result = menuProductsService.getAllMenuItemsDTO(linesFromFile);

        //then
        MenuProductsDTO menuProductsDTO = result.get(0);
        assertEquals(Long.valueOf(1L), menuProductsDTO.getID());
        assertEquals(Long.valueOf(0L), menuProductsDTO.getParentId());
        assertEquals("Elektronika", menuProductsDTO.getText());
    }
}