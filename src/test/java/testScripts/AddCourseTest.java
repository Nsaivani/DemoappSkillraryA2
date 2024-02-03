package testScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericUtilities.BaseClass;
import genericUtilities.IConstantPath;
//This Class Verifies Whether the user is able to add course application

public class AddCourseTest extends BaseClass{
	SoftAssert soft = new SoftAssert();
	@Test
	public void addCourseTest() {
		
		home.clickCoursesTab();
		home.clickCoursesListLink();
		soft.assertEquals(courseList.getPageHeader(),"Course List");
		courseList.clickNewButton();
		soft.assertEquals(addCourse.getPageHeader(), "");
		
		Map<String,String> map = excel.readFromExcel("Add Course");
		addCourse.setName(map.get("Name"));
		addCourse.selectCategory(web,map.get("Category"));
		addCourse.setPrice(map.get("Price"));
		addCourse.uploadPhoto(map.get("Photo"));
		addCourse.setDescription(map.get("Description"), web);
		addCourse.clickSave();
		
		soft.assertEquals(courseList.getSuccessMessage(), "Success!");
		courseList.deleteCourse(web, map.get("Name"));
		soft.assertEquals(courseList.getSuccessMessage(),"Success!");
		
		if(courseList.getSuccessMessage().equals("Success!"))
			excel.updateTestStatus("Add COurse","Pass", IConstantPath.EXCEL_PATH);
		else
			excel.updateTestStatus("Add Course", "Fail", IConstantPath.EXCEL_PATH);
		
		soft.assertAll();
	}

}
