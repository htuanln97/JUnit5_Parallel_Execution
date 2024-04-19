package synchronization;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceLock;

public class ResourceLockTest {
	private List<String> resources;

	@BeforeEach
	void before() {
		resources = new ArrayList<>();
		resources.add("test");
	}

	@AfterEach
	void after() {
		resources.clear();
	}

	@Test
	@ResourceLock(value = "resources")
	public void test1() throws Exception {
		System.out.println("ParallelResourceLockUnitTest.test1() start => " + Thread.currentThread().getName());
		resources.add("first");
		System.out.println(resources);
		Thread.sleep(500);
		System.out.println("ParallelResourceLockUnitTest.test1() end => " + Thread.currentThread().getName());
	}

	@Test
	@ResourceLock(value = "resources")
	public void test2() throws Exception {
		System.out.println("ParallelResourceLockUnitTest.test2() start => " + Thread.currentThread().getName());
		resources.add("second");
		System.out.println(resources);
		Thread.sleep(500);
		System.out.println("ParallelResourceLockUnitTest.test2() end => " + Thread.currentThread().getName());
	}
}
