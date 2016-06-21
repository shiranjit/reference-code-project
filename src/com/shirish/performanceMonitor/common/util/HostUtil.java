package com.shirish.performanceMonitor.common.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

import com.shirish.performanceMonitor.common.AFCLogger;

/**
 * 
 * @author t556427
 *
 */
public class HostUtil {
	
	private static AFCLogger log = AFCLogger.getLogger(HostUtil.class);

	public static String getHostName() {
		String hostName = null;
		try {
			InetAddress iAddress = InetAddress.getLocalHost();
			hostName = iAddress.getHostName();
		} catch (UnknownHostException uhe) {
			log.warn("UnknownHostException while obtaining the host name", uhe);
		}
		return hostName;
	}

}
