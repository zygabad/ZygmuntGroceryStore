package com.zygstore.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


import org.springframework.core.io.ClassPathResource;

public class ReadCSVFileWithAllCategories {
    private static final String FILE_ENCODING = "UTF-8";
    private BufferedReader reader;
    private List<String> list = new ArrayList<>();
    private String filePath;

    public ReadCSVFileWithAllCategories(String filePath) {
        this.filePath = filePath;
    }

    private void readLines(String filePath) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new ClassPathResource(filePath).getInputStream(),FILE_ENCODING));
            String line = reader.readLine();
            while (line != null) {
                if ((!line.equals("ID;ParentID;Name")) && (!line.equals("")) && (!line.equals(" "))) {
                    list.add(line);
                }
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getList() {
        {
            readLines(filePath);
        }
        return (ArrayList<String>) list;
    }
}

