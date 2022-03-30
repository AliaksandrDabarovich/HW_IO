package com.epam.iotask;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;

public class WordsWriter {
    private String path;

    public WordsWriter(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void write(Map<String, Integer> result) throws FileWriterException {
        BufferedWriter bufferedWriter = null;
        try {
            FileWriter writer = new FileWriter(path);
            bufferedWriter = new BufferedWriter(writer);

            for (Map.Entry<String, Integer> mapValue : result.entrySet()) {
                bufferedWriter.write(mapValue.getKey() + ": " + mapValue.getValue());
                bufferedWriter.newLine();
            }
        } catch (FileNotFoundException e) {
            throw new FileWriterException(e);
        } catch (IOException e) {
            throw new FileWriterException(e);
        } finally {
            try {
                if(bufferedWriter != null) {
                    bufferedWriter.close();
                }
            } catch (IOException e) {
                throw new FileWriterException(e);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WordsWriter)) return false;
        WordsWriter that = (WordsWriter) o;
        return Objects.equals(getPath(), that.getPath());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPath());
    }

    @Override
    public String toString() {
        return "WordsWriter{" +
                "path='" + path + '\'' +
                '}';
    }
}
