import org.junit.*;
import static org.junit.Assert.*;

public class WordTest {

  @After
  public void tearDown() {
    Word.clear();
  }

  @Test
  public void Word_initializesCorrectly_true() {
    Word testWord = new Word("Pony");
    assertEquals(true, testWord instanceof Word);
  }

  @Test
  public void Word_instantiatesWithDescription_String() {
    Word testWord = new Word("Pony");
    assertEquals("Pony", testWord.getDescription());
  }

  @Test
  public void all_returnsAllInstancesOfWord_True() {
    Word firstWord = new Word("Pony");
    Word secondWord = new Word("Toy");
    assertTrue(Word.all().contains(firstWord));
    assertTrue(Word.all().contains(secondWord));
  }

  @Test
  public void clear_emptiesAllWordsFromArrayList_0() {
    Word testWord = new Word("Pony");
    Word.clear();
    assertEquals(Word.all().size(), 0);
  }

  @Test
  public void getId_wordsInstantiateWithAnID_1() {
    Word.clear(); //THIS TEST WILL FAIL WITHOUT THIS LINE!
    Word testWord = new Word("Pony");
    assertEquals(1, testWord.getId());
  }

  @Test
  public void find_returnsWordWithSameId_secondWord() {
    Word firstWord = new Word("Pony");
    Word secondWord = new Word("Toy");
    assertEquals(Word.find(secondWord.getId()), secondWord);
  }

  @Test
  public void find_returnsNullWhenNoWordFound_null() {
    assertTrue(Word.find(999) == null);
  }

}
