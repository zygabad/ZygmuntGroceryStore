package com.zygstore.utils;

import java.io.IOException;
import java.util.ArrayList;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;

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
        String id;
        String parentID;
        IdGenerator idGenerator = new IdGenerator();

        for (int i = 0; i < tree.childNodeSize(); i++) {
            id = Long.toString(idGenerator.generateNewId());
            parentID = "null";

            if (addElementToList(tree.childNode(i), parentID)) {
                String parentID2 = id;
                for (int j = 0; j < tree.childNode(i).childNode(3).childNodeSize(); j++) {
                    if (addElementToList(tree.childNode(i).childNode(3).childNode(j), parentID2)) {
                        String parentID3 = id;
                        for (int x = 0; x < tree.childNode(i).childNode(3).childNode(j).childNode(3).childNodes().size(); x++) {
                            addElementToList(tree.childNode(i).childNode(3).childNode(j).childNode(3).childNode(x), parentID3);
                        }
                    }
                }
            }
        }

        return linesFromFile;
    }

    private Boolean addElementToList(Node tree, String parentID3) {
        IdGenerator idGenerator = new IdGenerator();
        String html3 = tree.toString();
        Document doc3 = Jsoup.parse(html3);
        Element link3 = doc3.select("a").first();

        if (link3 != null) {
            String id = Long.toString(idGenerator.generateNewId());
            String titleThirdLink = link3.attr("title").toString();
            String urlThirdLink = link3.attr("href").toString();
            linesFromFile.add(id + ";" + parentID3 + ";" + titleThirdLink);
            return true;
        }
        return false;
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
