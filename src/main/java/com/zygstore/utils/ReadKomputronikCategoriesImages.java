package com.zygstore.utils;

import java.io.IOException;
import java.util.ArrayList;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */

public class ReadKomputronikCategoriesImages {
    private String WEB_STIE = "https://www.komputronik.pl/";
    private static final String TREE_ROOT_HTML_ELEMENT = "ul.menu-tree";
    private ArrayList<String> linesFromFile = new ArrayList<>();
    private Document doc;
    private String title;
    private Element tree;

    public ReadKomputronikCategoriesImages(String WEB_STIE) {
        this.WEB_STIE = WEB_STIE;
    }

    private ArrayList<String> getCSVLinesFromKomputronik(String WEB_STIE) throws IOException {
        doc = Jsoup.connect(WEB_STIE).get();
        title = doc.title();
        tree = doc.select(TREE_ROOT_HTML_ELEMENT).first();

        String html = tree.childNode(0).toString();
        Document doc = Jsoup.parse(html);
        Element link = doc.select("a").first();

        return linesFromFile;
    }
}
