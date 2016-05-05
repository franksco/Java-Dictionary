import org.junit.*;
import static org.junit.Assert.*;

public class DefinitionTest {
  @After
  public void tearDown() {
    Definition.clear();
    Word.clear();
  }

  @Test
  public void Definition_instantiatesCorrectly_true() {
    Definition testDefinition = new Definition("a small breed of horse");
    assertEquals(true, testDefinition instanceof Definition);
  }

  @Test
  public void getName_DefinitionInstantiatesWithName_a_small_breed_of_horse() {
    Definition testDefinition = new Definition("a small breed of horse");
    assertEquals("a small breed of horse", testDefinition.getDescription());
  }

  @Test
  public void all_returnsAllInstancesOfDefinition_true() {
    Definition firstDefinition = new Definition("a small breed of horse");
    Definition secondDefinition = new Definition("miniature replica of something");
    assertTrue(Definition.all().contains(firstDefinition));
    assertTrue(Definition.all().contains(secondDefinition));
  }

  @Test
  public void clear_emptiesAllDefinitionsFromList_0() {
    Definition testDefinition = new Definition("a small breed of horse");
    Definition.clear();
    assertEquals(Definition.all().size(), 0);
  }

  @Test
  public void getId_DefinitionsInstantiateWithAnId_1() {
    Definition.clear();

    Definition testDefinition = new Definition("a small breed of horse");
    assertEquals(1, testDefinition.getId());
  }

  @Test
  public void find_returnsDefinitionWithSameId_secondDefinition() {
    Definition firstDefinition = new Definition("a small breed of horse");
    Definition secondDefinition = new Definition("miniature replica of something");
    assertEquals(Definition.find(secondDefinition.getId()), secondDefinition);
  }

  @Test
  public void find_returnsNullWhenNoDefinitionFound_null() {
    assertTrue(Definition.find(999) == null);
  }

  @Test
  public void getWords_initiallyReturnsEmptyList_ArrayList() {
    Definition testDefinition = new Definition("a small breed of horse");
    assertEquals(0, testDefinition.getWords().size());
  }

  @Test
  public void addWord_addsWordToList_true() {
  Word testWord = new Word("Pony");
  Definition testDefinition = new Definition("a small breed of horse");
  testDefinition.addWord(testWord);
  assertTrue(testDefinition.getWords().contains(testWord));
  }
}
