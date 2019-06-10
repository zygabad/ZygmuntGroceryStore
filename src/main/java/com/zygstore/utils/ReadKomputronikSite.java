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

public class ReadKomputronikSite {
    private static final String WEB_STIE = "https://www.komputronik.pl/";
    private static final String TREE_ROOT_HTML_ELEMENT = "ul.menu-tree";
    private ArrayList<String> linesFromFile = new ArrayList<>();
    private Document doc;
    private String title;
    private Element tree;

    public ReadKomputronikSite() throws IOException {
        this.doc = Jsoup.connect(WEB_STIE).get();
        this.title = doc.title();
        this.tree = doc.select(TREE_ROOT_HTML_ELEMENT).first();
        this.linesFromFile = getCSVLinesFromKomputronik(tree);
    }

    private ArrayList<String> getCSVLinesFromKomputronik(Element tree) {
        for (int i = 0; i < tree.childNodeSize(); i++) {
            String html = tree.childNode(i).toString();
            Document doc = Jsoup.parse(html);
            Element link = doc.select("a").first();
            if (link != null) {
                String title = link.attr("title").toString();
                String ulr = link.attr("href").toString();

                linesFromFile.add(Integer.toString(i) + ";" + "0" + ";" + title);
            }

        }


        return linesFromFile;
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

    public ArrayList<String> getLinesFromFile() {
        return linesFromFile;
    }


}
