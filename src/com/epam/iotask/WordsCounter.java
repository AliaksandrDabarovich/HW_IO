package com.epam.iotask;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordsCounter {
    private List<String> dataForCount;

    public WordsCounter(List<String> dataForCount) {
        this.dataForCount = dataForCount;
    }

    public List<String> getDataForCount() {
        return dataForCount;
    }

    public void setDataForCount(List<String> dataForCount) {
        this.dataForCount = dataForCount;
    }

    public Map<String, Integer> count() {
        int firstResult = 1;
        Map<String, Integer> resultMap = new HashMap<>();

        for (String data : dataForCount) {
            String pattern = "abstract|assert|boolean|break|byte|case|catch|char|class|const|continue|default|do|double|else|enum|extends|final|finally|float|for|goto|if|implements|import|instaceof|int|interface|long|native|new|package|private|protected|public|return|short|static|strictfp|super|switch|synchronized|this|throw|throws|transient|try|void|volatile|while";

            Pattern p = Pattern.compile(pattern);
            Matcher m = p.matcher(data);

            while (m.find()) {
                String wordResult = m.group();
                if (resultMap.containsKey(wordResult)) {
                    int currentValue = resultMap.get(wordResult);
                    resultMap.put(wordResult, ++currentValue);
                } else {
                    resultMap.put(wordResult, firstResult);
                }
            }
        }

        return resultMap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WordsCounter)) return false;
        WordsCounter that = (WordsCounter) o;
        return Objects.equals(getDataForCount(), that.getDataForCount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDataForCount());
    }

    @Override
    public String toString() {
        return "WordsCounter{" +
                "dataForCount=" + dataForCount +
                '}';
    }
}
