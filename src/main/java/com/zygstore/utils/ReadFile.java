package com.zygstore.utils;

import com.sun.org.apache.xerces.internal.xs.StringList;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class ReadFile {
    private BufferedReader reader;
    private List<String> list = new LinkedList<>();

    private String filePath;

    public ReadFile(String filePath) {
        this.filePath = filePath;

    }

    public List<String> getList() {
        {
            readLines(filePath);
        }
        return list;
    }

    private void readLines(String filePath) {
        try {
            reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();
            while (line != null) {
                list.add(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

