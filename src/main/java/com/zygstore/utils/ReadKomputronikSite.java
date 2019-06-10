package com.zygstore.utils;

import java.io.IOException;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */

public class ReadKomputronikSite {
    private static final String WEB_STIE = "https://www.komputronik.pl/";
    private static final String TREE_ROOT_HTML_ELEMENT = "ul.menu-tree";
    Document x = Jsoup.connect("https://www.komputronik.pl/").get();
    private Document doc;
    private String title;
    private Element tree;

    public ReadKomputronikSite() throws IOException {
        this.doc = Jsoup.connect(WEB_STIE).get();
        this.title = doc.title();
        this.tree = doc.select(TREE_ROOT_HTML_ELEMENT).first();
    }

    public Document getDoc() {
        return doc;
    }

    public String getTitle() {
        return title;
    }

    public Element getTree() {
        return tree;
    }
}
