import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyWordCount {
    public static final String fileName = "data/fit.txt";
    private List<String> words = new ArrayList<>();
    public MyWordCount() { try {
        this.words.addAll(Utils.loadWords(fileName));
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    }
    public List<WordCount> getWordCounts() {

        List<WordCount> wordCounts = new ArrayList<>();
        Set<String> uniqueWords = new HashSet<>();

        for (String word : words) {
            if (uniqueWords.contains(word)) {
                // The word is already in the set, find and update its count
                for (WordCount wordCount : wordCounts) {
                    if (wordCount.getWord().equals(word)) {
                        wordCount.incrementCount();
                        break;
                    }
                }
            } else {
                // The word is not in the set, add it to the set and wordCounts list
                uniqueWords.add(word);
                wordCounts.add(new WordCount(word, 1));
            }
        }

        // Sort the list of WordCount objects by frequency in descending order
        wordCounts.sort((a, b) -> Integer.compare(b.getCount(), a.getCount()));

        return wordCounts;

    }
    public Set<String> getUniqueWords() {
        Set<String> list = new HashSet<>();
        for (String word: words) {
            list.add(word);
        }
        return list;

    }
    public Set<String>  getDistinctWords() {
        Set<String> distinctWords = new HashSet<>(words);
        return distinctWords;

    }
    public Set<WordCount> exportWordCounts() {
        Set<String> uniqueWords = new HashSet<>();
        List<WordCount> wordCounts = new ArrayList<>();

        for (String word : words) {
            if (uniqueWords.contains(word)) {
                // Word is already in the set, find its WordCount and update count
                for (WordCount wc : wordCounts) {
                    if (wc.getWord().equals(word)) {
                        wc.incrementCount();
                        break;
                    }
                }
            } else {
                // Word is encountered for the first time
                uniqueWords.add(word);
                wordCounts.add(new WordCount(word, 1));
            }
        }

        return new HashSet<>(wordCounts);

    }
    public Set<WordCount> exportWordCountsOrderByOccurence() {
        List<WordCount> wordCounts = new ArrayList<>();
        Set<String> uniqueWords = new HashSet<>();

        for (String word : words) {
            if (uniqueWords.contains(word)) {
                // The word is already in the set, find and update its count
                for (WordCount wordCount : wordCounts) {
                    if (wordCount.getWord().equals(word)) {
                        wordCount.incrementCount();
                        break;
                    }
                }
            } else {
                // The word is not in the set, add it to the set and wordCounts list
                uniqueWords.add(word);
                wordCounts.add(new WordCount(word, 1));
            }
        }

        // Sort the list of WordCount objects by frequency in descending order
        wordCounts.sort((a, b) -> Integer.compare(b.getCount(), a.getCount()));

        return new HashSet<>(wordCounts);

    }
    public Set<WordCount> filterWords(String pattern) {
        Set<WordCount> list = new HashSet<>();
        for (String word: words) {
            if(!word.matches(pattern)){
                boolean found = false;
                for (WordCount wc : list) {
                    if (wc.getWord().equals(word)) {
                        wc.incrementCount();
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    list.add(new WordCount(word, 1));
                }
            }
        }
        return new HashSet<>(list);
    }
    public static void main(String[] args) {
        MyWordCount wordCounter = new MyWordCount();
//        List<WordCount> wordCounts = wordCounter.getWordCounts();
//
//        for (WordCount wordCount : wordCounts) {
//            System.out.println(wordCount.getWord() + ": " + wordCount.getCount());
//        }
        Set<WordCount> list = new HashSet<>();
        list = wordCounter.filterWords("Nong");
        for (WordCount set: list
             ) {
            System.out.print( set + " ");

        }
    }
}
