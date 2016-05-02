import java.util.ArrayList;

public class Definition {
  private String mName;
  private static ArrayList<Definition> instances = new ArrayList<Definition>();
  private int mId;
  private ArrayList<Word> mWords;

  public Definition(String name) {
    mName = name;
    instances.add(this);
    mId = instances.size();
    mWords = new ArrayList<Word>();
  }

  public String getName() {
    return mName;
  }

  public static ArrayList<Definition> all() {
    return instances;
  }

  public static void clear() {
    instances.clear();
  }

  public int getId() {
    return mId;
  }

  public static Definition find(int id) {
    try {
      return instances.get(id - 1);
    } catch (IndexOutOfBoundsException e) {
      return null;
    }
  }

  public ArrayList<Word> getWords() {
    return mWords;
  }

  public void addWord(Word word) {
    mWords.add(word);
  }

}
