package com.zygstore.utils;

import java.io.IOException;


import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */

public class ReadKomputronikSiteTest {

    //TODO test integracyjny z tego ponizszego
    public void getLinesFromFile() throws IOException {
        //given
        String expectedFirstLineInFile = "1;null;Elektronika;https://www.komputronik.pl/category/14508/elektronika.html";
        ReadKomputronikSite readKomputronikSite = new ReadKomputronikSite();

        //when
        String result = readKomputronikSite.getLinesFromFile().get(0);

        //then
        assertEquals(expectedFirstLineInFile, result);
    }



}