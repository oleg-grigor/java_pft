package ru.stqa.pft.mantis.tests;

import org.testng.annotations.Test;

import java.io.IOException;

public class ResetPasswordTests extends TestBase{
  @Test
  public void testResetPassword() throws IOException {
    app.newSession().login("root", "root");



  }
}
