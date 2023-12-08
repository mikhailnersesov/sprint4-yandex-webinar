# Sprint 4
# Patterns for UI Tests:
* Plain style (Selenium): everything in one file
* Page Object: each page is separate class object
* Page Object fluent interface:
boolean notFoundImageDisplayed = new MainPage(webDriver)
  .openPage()
  .clickOrderStatusButton()
  .enterOrderNumber("1234")
  .clickGoButton()
  .isNotFoundImageDisplyed();
* Loadable component pattern: class to load and checkLoad
* Page Factory:
  @FindBy(xpath = "//button[text()='Статус заказа']")
  private WebElement orderStatusButton;
  PageFactory.initElements(webDriver,this);
* Page component (extention of Page Object): parts of the page (not full page) are unique :menu. Usefull in ELFI: several parts are used in different pages (serach views, popUps)
  public class FaqComponent extends BaseComponent


* Page elements pattern (yandex framework)
* screen play pattern

