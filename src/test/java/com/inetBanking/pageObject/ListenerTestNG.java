package com.inetBanking.pageObject;

import org.junit.Assert;
import org.testng.annotations.Test;

public class ListenerTestNG {
  @Test
  public void LoginTest() {
	  
	 System.out.println("Login by Email"); 
	 
	 Assert.assertEquals("purvi", "purvi"); //True
  }
  
  @Test
  
  public void LoginTest1() {
	  
	  System.out.println("Login by facebook");
	  
	  Assert.assertEquals("Brahmbhatt", "purvi");
  }
  
}
