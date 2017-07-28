/**
 * 
 */
package com.shirish.caching.example;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * EBCMesageCache
 * <p>
 * This class is responsible for validating the object and returning the result
 * whether to update or not
 * 
 * @author p565337
 * @version 3.7.3
 * @since 30-3-2017
 */
public enum HashMessageCache {

	INSTANCE;
	private final Map<String, String> messageMap = new HashMap<String, String>();
	private final Log LOG = LogFactory.getLog(HashMessageCache.class.getCanonicalName());

	private static MessageDigest md;
	/**
	 * 
	 */
	static {
		try {
			md = MessageDigest.getInstance("SHA-512");
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("cannot initialize SHA-512 hash function", e);
		}
	}

	/**
	 * This method is for getting the instance
	 * 
	 * @return
	 */
	public synchronized static HashMessageCache getInstance() {
		return INSTANCE;
	}

	/**
	 * This method will validate the hash code and return the result
	 * 
	 * @param fgoEbcServiceDataModel
	 * @return boolean
	 */
	public boolean doWeNeedToPublishEBCMessage(String value) {
		//boolean isDataSame = find(fgoEbcServiceDataModel.getWssAccountNumber().trim(), value);
		// this will be reverse of same data that is if the data is same, then
		// we do not need to publish
		return false;
	}

	/**
	 * This method will calculate the hash code of a string and returns it
	 * 
	 * @param inData
	 * @return String
	 * @throws Exception
	 */
	private String makeHashQuick(String inData) throws Exception {
		byte data[] = inData.getBytes();
		String hash = new BigInteger(1, md.digest(data)).toString(16);
		return hash;
	}

	/**
	 * This method will find whether the value is present or not in the map
	 * 
	 * @param lists
	 * @param indata
	 */
	public boolean find(String key, String indata) {
		boolean isDataSame = false;
		try {
			String hashcode = makeHashQuick(indata);
			String value = messageMap.get(key);
			if (null != value) {
				String mapValueHashcode = makeHashQuick(value);
				if (hashcode.equals(mapValueHashcode)) {
					isDataSame = true;
					LOG.debug("input and stored same: " + indata.toString() + "  : " + value.toString());

				} else {
					// Adding string value to map instead of hashcode
					messageMap.put(key, indata);

				}
			} else {
				// Adding string value to map instead of hashcode
				messageMap.put(key, indata);

			}
		} catch (Exception e) {

			LOG.error("Exception while validating the EBC Message from cache and exception message is : ", e);
		}
		return isDataSame;

	}

}
