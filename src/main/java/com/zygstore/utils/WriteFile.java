package com.zygstore.utils;

import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class WriteFile {
    private static final String FILE_ENCODING ="UTF-8";
    private String fileName;
    private FileWriter fw;
    private ArrayList<String> listOfLiinesToWrite;

    public WriteFile(String fileName, ArrayList<String> listOfLiinesToWrite) throws IOException {
        this.fileName = fileName;
        this.listOfLiinesToWrite = listOfLiinesToWrite;
    }

    public void writeToFile() throws IOException {
        FileOutputStream outputStream = new FileOutputStream(fileName);

        for (int i = 0; i < listOfLiinesToWrite.size(); i++) {
            String line = listOfLiinesToWrite.get(i) + "\n";
            byte[] strToBytes = line.getBytes(Charset.forName(FILE_ENCODING));
            outputStream.write(strToBytes);
        }
        outputStream.close();
    }


}
