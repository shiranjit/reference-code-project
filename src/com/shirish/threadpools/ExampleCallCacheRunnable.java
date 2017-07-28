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

import java.lang.management.ManagementFactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.shirish.appMonitor.common.stopwatch.ApStopwatch;
import com.shirish.caching.example.HashMessageCache;

/**
 * @author shirish
 * @Feb 28, 2016
 *
 */
public class ExampleCallCacheRunnable implements Runnable {
	Log logger = LogFactory.getLog(ExampleCallCacheRunnable.class);

	private final String name;
	private final String indata;
	private final String key;

	/**
	 * 
	 */
	public ExampleCallCacheRunnable(String name, String key, String indata) {
		this.name = name;
		this.indata = indata;
		this.key = key;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {

		try {
			com.sun.management.OperatingSystemMXBean os = (com.sun.management.OperatingSystemMXBean) ManagementFactory
					.getOperatingSystemMXBean();
			double cpusload = os.getProcessCpuLoad();
			double sysload = os.getSystemCpuLoad();
			ApStopwatch sw = new ApStopwatch(ExampleCallCacheRunnable.class, name);
			sw.start();

			boolean ispublish = HashMessageCache.getInstance().find(key, indata);
			// System.out.println("ispublsh:" +ispublish);
			sw.stop();

			double cpusloadafter = os.getProcessCpuLoad();
			double sysloadafter = os.getSystemCpuLoad();

			logger.info(" took: " + sw.toString() + " CPU Process Start: " + cpusload + " CPU system Start: "
					+ sysload + " CPU Process after: " + cpusloadafter  + " CPU Sys after: " + sysloadafter);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String getName() {

		return name;
	}

}
