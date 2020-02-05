package com.zygstore.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


import org.springframework.core.io.ClassPathResource;

public class CVSFileUtils {
    String fileEncoding;

    public CVSFileUtils() {
    }

    public List<String> getList(String filePath) {
        List<String> list = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new ClassPathResource(filePath).getInputStream(), fileEncoding));
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
        return list;
    }
//TODO sprawdz jak zrobic to annotacja i pozbyc sie settera
    public void setFileEncoding(String fileEncoding) {
        this.fileEncoding = fileEncoding;
    }
}

