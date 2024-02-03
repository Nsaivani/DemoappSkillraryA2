package genericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class contains reusable method to perform java related operation
 * @author SAIVANI
 */

public class JavaUtility {
	
	public String getCurrentTime() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yy_mm_ss");
		return sdf.format(date);
	}

}
