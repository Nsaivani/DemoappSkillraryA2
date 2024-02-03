package testScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericUtilities.BaseClass;
import genericUtilities.IConstantPath;

public class AddCategoryTest extends BaseClass {
	
	@Test
	public void addCategoryTest() throws InterruptedException {
		SoftAssert soft = new SoftAssert();
		home.clickCoursesTab();
		home.clickCategoryLink();
		soft.assertEquals(category.getPageHeader(), "Category");
		
		category.clickNewButton();
		Thread.sleep(5000);
		soft.assertEquals(addCategory.getPageHeader(), "Add New Category");
		Map<String, String> map = excel.readFromExcel("Add category");
		addCategory.setName(map.get("Name"));
		addCategory.clickSave();
		soft.assertEquals(category.getSuccessMessage(),"Success!");
		Thread.sleep(5000);
		category.deleteCategory(web, map.get("Name"));
		Thread.sleep(5000);
	     soft.assertEquals(category.getSuccessMessage(),"Success!");
	     if(category.getSuccessMessage().equals("Success!"))
	    	 excel.updateTestStatus("Add Category","Pass", IConstantPath.EXCEL_PATH);
	     else
	    	 excel.updateTestStatus("Add Category", "Fail", IConstantPath.EXCEL_PATH);
	     
	     soft.assertAll();
	}

}
