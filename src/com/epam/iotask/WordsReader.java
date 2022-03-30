package com.epam.iotask;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class WordsReader {
    private String path;

    public WordsReader(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Map<String, Integer> read() throws FileReaderException {
        Map<String, Integer> result = new HashMap<>();
        BufferedReader bufferedReader = null;
        try {
            FileReader fileReader = new FileReader(path);
            bufferedReader = new BufferedReader(fileReader);
            List<String> lines = new ArrayList<>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }

            WordsCounter wordsCounter = new WordsCounter(lines);
            result = wordsCounter.count();
        } catch (FileNotFoundException e) {
            throw new FileReaderException(e);
        } catch (IOException e) {
            throw new FileReaderException(e);
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    throw new FileReaderException(e);
                }
            }
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WordsReader)) return false;
        WordsReader that = (WordsReader) o;
        return Objects.equals(getPath(), that.getPath());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPath());
    }

    @Override
    public String toString() {
        return "WordsReader{" +
                "path='" + path + '\'' +
                '}';
    }
}
