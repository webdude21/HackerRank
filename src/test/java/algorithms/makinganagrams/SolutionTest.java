package algorithms.makinganagrams;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

	@Test
	void numberNeeded() {
		Assertions.assertEquals(4, Solution.numberNeeded("cde", "abc"));
	}
}
