import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class WordReader {
  //an ArrayList of all the words in words.txt
  private ArrayList<String> wordList;

  //intitalizes the ArrayList and adds all words into the List
  public WordReader() {
    wordList = new ArrayList<String>();
    BufferedReader br = null;
    try {
      br = new BufferedReader(new FileReader("words.txt"));
      String line;

      while((line = br.readLine()) != null) {
        wordList.add(line);
      }
    } catch (IOException e) {
        //e.printStackTrace();
      System.out.println("File not found!");
      }
    finally {
      try {
        br.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  //returns a random word from wordList
  public String getRandomWord() {
    int randIndex = (int) (Math.random() * wordList.size());
    return wordList.get(randIndex);
  }

  //returns a random list of num words
  public ArrayList<String> getRandomWords(int num) {
    ArrayList<String> randList = new ArrayList<String>();
    for(int i = 0; i < num; i++) {
      int randIndex = (int) (Math.random() * wordList.size());
      randList.add(wordList.get(randIndex));
    }
    return randList;
  }
}