/**

The MIT License (MIT)

Copyright (c) 2015 Shirish Ranjit

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE. 

 */
package com.shirish.threadpools;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.shirish.appMonitor.common.stopwatch.ApStopwatch;

/**
 * @author shirish
 * @Feb 28, 2016
 *
 */
public class ExampleCallCacheExecutorServiceTest {

	private ExampleCallCacheExecutorService ees;

	/**
	 * 
	 * @throws java.lang.Exception
	 *             void
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	/**
	 * 
	 * @throws java.lang.Exception
	 *             void
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {

	}

	/**
	 * 
	 * @throws java.lang.Exception
	 *             void
	 */
	@Before
	public void setUp() throws Exception {
		ees = new ExampleCallCacheExecutorService();
		}

	/**
	 * 
	 * @throws java.lang.Exception
	 *             void
	 */
	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void test() {

		try {
			Thread.sleep(30000);
			ApStopwatch sw = new ApStopwatch(this.getClass(), "test");
			sw.start();
			ees.startExample(91000);
			Thread.sleep(2000);
			
//			ees.startExample(1000);
//			Thread.sleep(2000);
//			
//			ees.startExample(7000);
//			Thread.sleep(2000);
//			
//			ees.startExample(14000);
//			Thread.sleep(2000);
//			
//			ees.startExample(30000);
//			Thread.sleep(2000);
//			
//			ees.startExample(60000);
//			Thread.sleep(2000);
//			
//			ees.startExample(140000);
//			Thread.sleep(2000);
			
			sw.stop();
			System.out.println(sw.toString());
			
			Thread.sleep(2000);
			
		} catch (Exception e) {
			e.printStackTrace();
			fail("Not yet implemented");

		}

	}

}
