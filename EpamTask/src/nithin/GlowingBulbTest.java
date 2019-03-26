package nithin;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GlowingBulbTest {

	@Test
	void test() {
		assertEquals(1094775,new GlowingBulbs().findBulb("0100000000100000001000100000101000001000",684817));
	}

}
