import java.util.ArrayList;
import java.time.LocalDateTime;

public class Word {

  private String mDescription;
  private static ArrayList<Word> instances = new ArrayList<Word>();
  private int mId;

  public Word(String description) {
    mDescription = description;
    instances.add(this);
    mId = instances.size;
  }

  public String getDescription() {
    return mDescription;
  }

  public Static ArrayList<Word> all() {
    return instances;
  }

  public static void clear() {
    instances.clear;
  }

  public int getId() {
    return mId;
  }

  public static Word find(int id) {
  try {
    return instances.get(id - 1);
  } catch (IndexOutOfBoundsException exception) {
    return null;
  }


}
