/**
 * 
 */
package com.teeznar.poi.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author shirish
 *
 */
public class TestPoiTest {

	private TestPoi testXlsRead;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		testXlsRead = new TestPoi();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		
		try {
			testXlsRead.test();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("errored");
		}
		
	}

}
