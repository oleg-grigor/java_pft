package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;

public class AdminHelper extends HelperBase {

  public AdminHelper(ApplicationManager app) {
    super(app);
  }

  public void login() {
    wd.get(app.getProperty("web.baseUrl") + "/login_page.php");
    type(By.name("username"), "administrator");
    click(By.cssSelector("input[value='Login']"));
    type(By.name("password"), "root");
    click(By.cssSelector("input[value='Login']"));
  }

  public void manageUsers() {
    //wd.findElement(By.xpath("//div[@id='sidebar']/ul/li[6]/a/i")).click();
    click(By.xpath("//div[@id='sidebar']/ul/li[6]/a/i"));
    click(By.linkText("Manage Users"));
  }

  public void initPasswordReset(int idToDelete) {
    click(By.cssSelector("[href$='user_id=" + idToDelete + "']"));
    click(By.cssSelector("input[value='Reset Password']"));
  }

  public void changePassword(String confirmationLink, String newPassword) {
    wd.get(confirmationLink);
    type(By.name("password"), newPassword);
    type(By.name("password_confirm"), newPassword);
    click(By.cssSelector("span.bigger-110"));
  }
}
