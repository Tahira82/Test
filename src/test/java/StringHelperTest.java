import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.extedo.helper.StringHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class StringHelperTest {
	
	private StringHelper helper;
	
	@BeforeEach
	public void beforeEach() throws Exception{

		String path = getClass().getResource("sample.txt").getPath();
		helper = new StringHelper(path);
		helper.process();
	}

	@Test
	public void shouldReturnStringList() {
		
		List<String> listToCheck = new ArrayList<String>() {
			private static final long serialVersionUID = 1L;{ 
				add("x is 1.");
			}
		};
		
		assertEquals(listToCheck,  helper.getAllStrings());
	}

	@Test
	public void shoudlReturnAllComments() {
		List<String> listToCheck = new ArrayList<String>() {
			private static final long serialVersionUID = 1L;{ 
				add(" indented four spaces");
			}
		};
		
		assertEquals(listToCheck,  helper.getAllComents());
	}


	@Test
	public void shouldReturnTotalStringCounts() {
		List<String> dataList = helper.getAllStrings();
		double stringCount = helper.getCount(dataList);
		
		assertEquals(7, stringCount);
	}

	@Test
	public void shouldReturnTotalCommentCoutnts() {
		List<String> dataList = helper.getAllComents();
		double stringCount = helper.getCount(dataList);
		
		assertEquals(21, stringCount);

	}
}
