package com.practice.unittest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class NumberOperationTest {
	private NumberOperation numberOperation;

	@BeforeClass
	public static void classSetup() {
		System.out.println("Setup ran for class");
//		numberOperation = new NumberOperation(100);
	}

	@Before
	public void setup() {
		System.out.println("Setup ran before each test method");
		numberOperation = new NumberOperation(100);
	}

	@Test
	public void testGetValue() {
		System.out.println("Setup ran before each test method");
		assertEquals(numberOperation.getValue(), 100, 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testIncrement() {
		numberOperation.increment(10);
		throw new IllegalArgumentException();
//		assertEquals(numberOperation.getValue(), 110, 0);
	}

	@Test
	public void testDecrement() {
		numberOperation.decrement(10);
		assertEquals(numberOperation.getValue(), 90, 0);
	}

}
