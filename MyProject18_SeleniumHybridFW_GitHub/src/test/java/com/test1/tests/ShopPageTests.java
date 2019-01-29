package com.test1.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test1.util.DataDrivenHelper;

public class ShopPageTests extends TestBase{
	
	@Test
	public void testPageTitle()
	{
		
		String actualTitle = homePG.clickShopLink().getTitle();
		
		Assert.assertEquals(actualTitle, 
				"Products | ABSoft Trainings – E-Commerce test web site",
				"Title is not correct");
	}
	
	  @Test(dataProvider="dataProvider")
	  public void testApplyingSortOrder(String sortOrder)
	  {
		  
		  String actualSortOrder =  homePG.clickShopLink()
							  			.setSortOrder(sortOrder)
							  			.getSortOrder();
		  
		  Assert.assertTrue(actualSortOrder.equals(sortOrder), 
				  				"Sort order is not applied properly");
	  }
	  
}
