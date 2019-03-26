package nithin;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.*
;
class DescendingWeightsTest {

	@Test
	void test() {
		int a[] = {1,2,3,4,5};
		List<Integer> myList = new ArrayList<Integer>();
		myList.add(1);
		myList.add(3);
		myList.add(5);
		myList.add(2);
		myList.add(4);
		
		assertEquals(myList,new DescendingWeights().solve(5,2,a));
		
	}

}
