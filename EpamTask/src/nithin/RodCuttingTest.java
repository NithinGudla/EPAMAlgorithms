package nithin;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RodCuttingTest {

	@Test
	void test() {
		RodCutting rodCutting = new RodCutting();
		int output = rodCutting.calculateSpecialRods(322916);
		assertEquals(17,output);
	}

}
