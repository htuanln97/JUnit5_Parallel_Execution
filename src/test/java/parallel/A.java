package parallel;

import org.junit.jupiter.api.Test;

public class A {
	@Test
	public void test1() throws Exception {
		System.out.println("A.test1() start => " + Thread.currentThread().getName());
		Thread.sleep(500);
		System.out.println("A.test1() end => " + Thread.currentThread().getName());
	}

	@Test
	public void test2() throws Exception {
		System.out.println("A.test2() start => " + Thread.currentThread().getName());
		Thread.sleep(500);
		System.out.println("A.test2() end => " + Thread.currentThread().getName());
	}
}
