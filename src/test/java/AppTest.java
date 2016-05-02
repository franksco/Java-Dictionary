import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.fluentlenium.core.filter.FilterConstructor.*;
import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Word List!");
    assertThat(pageSource()).contains("View Word List");
    assertThat(pageSource()).contains("Add a New Word");
  }

  @Test
  public void wordIsCreatedTest() {
    goTo("http://localhost:4567/");
    click("a", withText("Add a new word"));
    fill("#description").with("Pony");
    submit(".btn");
    assertThat(pageSource()).contains("Your word has been saved.");
  }

  @Test
  public void wordIsDisplayedTest() {
    goTo("http://localhost:4567/words/new");
    fill("#description").with("Pony");
    submit(".btn");
    click("a", withText("View words"));
    assertThat(pageSource()).contains("Pony");
  }

  @Test
  public void multipleWordsAreDisplayedTest() {
    goTo("http://localhost:4567/words/new");
    fill("#description").with("Pony");
    submit(".btn");
    goTo("http://localhost:4567/words/new");
    fill("#description").with("Toy");
    submit(".btn");
    click("a", withText("View words"));
    assertThat(pageSource()).contains("Pony");
    assertThat(pageSource()).contains("Toy");
  }

  @Test
  public void wordShowPageDisplaysWord() {
    goTo("http://localhost:4567/words/new");
    fill("#description").with("Pony");
    submit(".btn");
    click("a", withText("View words"));
    click("a", withText("Pony"));
    assertThat(pageSource()).contains("Pony");
  }

  @Test
  public void wordNotFoundMessageShown() {
    goTo("http://localhost:4567/words/999");
    assertThat(pageSource()).contains("word not found");
  }

  @Test
  public void definitionIsCreatedTest() {
    goTo("http://localhost:4567/");
    click("a", withText("Add a New definition"));
    fill("#name").with("a small breed of horse");
    submit(".btn");
    assertThat(pageSource()).contains("Your definition has been saved.");
  }

  @Test
  public void definitionIsDisplayedTest() {
    goTo("http://localhost:4567/definitions/new");
    fill("#name").with("A small breed of horse");
    submit(".btn");
    click("a", withText("View definitions"));
    assertThat(pageSource()).contains("A small breed of horse");
  }

  @Test
  public void definitionShowPageDisplaysName() {
    goTo("http://localhost:4567/definitions/new");
    fill("#name").with("A small breed of horse");
    submit(".btn");
    click("a", withText("View definitions"));
    assertThat(pageSource()).contains("A small breed of horse");
  }

  @Test
  public void definitionWordsFormIsDisplayed() {
    goTo("http://localhost:4567/definitions/new");
    fill("#name").with("A small breed of horse");
    submit(".btn");
    click("a", withText("View definitions"));
    click("a", withText("Add a new word"));
    assertThat(pageSource()).contains("Add a definition to Pony");
  }
  // @Test
  // public void wordsIsAddedAndDisplayed() {
  //   goTo("http://localhost:4567/definitions/new");
  //   fill("#name").with("Banking");
  //   submit(".btn");
  //   click("a", withText("View definitions"));
  //   click("a", withText("Banking"));
  //   click("a", withText("Add a new word"));
  //   fill("#description").with("Deposit paycheck");
  //   submit(".btn");
  //   click("a", withText("View definitions"));
  //   click("a", withText("Banking"));
  //   assertThat(pageSource()).contains("Deposit paycheck");
  // }
}
