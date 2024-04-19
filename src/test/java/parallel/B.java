package parallel;

import org.junit.jupiter.api.Test;

public class B {
	@Test
	public void test1() throws Exception {
		System.out.println("B.test1() start => " + Thread.currentThread().getName());
		Thread.sleep(500);
		System.out.println("B.test1() end => " + Thread.currentThread().getName());
	}

	@Test
	public void test2() throws Exception {
		System.out.println("B.test2() start => " + Thread.currentThread().getName());
		Thread.sleep(500);
		System.out.println("B.test2() end => " + Thread.currentThread().getName());
	}
}
