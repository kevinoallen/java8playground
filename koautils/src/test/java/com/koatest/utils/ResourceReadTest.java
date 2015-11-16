package com.koatest.utils;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Test
public class ResourceReadTest {

	private ResourceRead fixture;
	
	@BeforeMethod
	public void setup() {
		fixture = new ResourceRead();
	}
	
	
	@DataProvider(name="resourceTestDP")
	public Object[][] getTestDP() {
		return new Object[][] {
			{null, new String[] {"Fred","John","Francine","Franco","Jeffery","George","Gina","Turk","Mathew"}},
			{"F.*", new String[] {"Fred","Francine","Franco"}},
		};
	}
	
	@Test(dataProvider="resourceTestDP")
	public void testResourceRead(String regex, String[] expected) throws IOException {
		List<String> actual = fixture.readLines("resources.txt", regex);
		assertEquals(actual, Arrays.asList(expected));
		actual.forEach(System.out::println);
	}
}
