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
    Definition testDefinition = new Definition("Pony");
    assertEquals(true, testDefinition instanceof Definition);
  }

  @Test
  public void getName_DefinitionInstantiatesWithName_Pony() {
    Definition testDefinition = new Definition("Pony");
    assertEquals("Pony", testDefinition.getName());
  }

  @Test
  public void all_returnsAllInstancesOfDefinition_true() {
    Definition firstDefinition = new Definition("Pony");
    Definition secondDefinition = new Definition("Toy");
    assertTrue(Definition.all().contains(firstDefinition));
    assertTrue(Definition.all().contains(secondDefinition));
  }

  @Test
  public void clear_emptiesAllDefinitionsFromList_0() {
    Definition testDefinition = new Definition("Pony");
    Definition.clear();
    assertEquals(Definition.all().size(), 0);
  }

  @Test
  public void getId_DefinitionsInstantiateWithAnId_1() {
    Definition testDefinition = new Definition("Pony");
    assertEquals(1, testDefinition.getId());
  }

  @Test
  public void find_returnsDefinitionWithSameId_secondDefinition() {
    Definition firstDefinition = new Definition("Pony");
    Definition secondDefinition = new Definition("Toy");
    assertEquals(Definition.find(secondDefinition.getId()), secondDefinition);
  }

  @Test
  public void find_returnsNullWhenNoDefinitionFound_null() {
    assertTrue(Definition.find(999) == null);
  }
}
