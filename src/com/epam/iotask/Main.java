package com.epam.iotask;

import com.sun.org.apache.xpath.internal.compiler.Keywords;

import java.io.IOException;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String file1 = "C:\\Users\\Aliaksandr_Dabarovic\\text.txt";
        String file2 = "C:\\Users\\Aliaksandr_Dabarovic\\text2.txt";

        WordsReader wordsReader;
        WordsWriter wordsWriter;

        try {
            wordsReader = new WordsReader(file1);
            Map<String, Integer> result = wordsReader.read();

            wordsWriter = new WordsWriter(file2);
            wordsWriter.write(result);

        } catch (FileReaderException | FileWriterException e){
            System.out.println(e.getMessage());
        }

    }
}
