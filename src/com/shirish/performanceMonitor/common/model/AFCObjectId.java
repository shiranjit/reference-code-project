/**
 * 
 */
package com.shirish.performanceMonitor.common.model;

/**
 * @author t556427
 * 
 */
public class AFCObjectId extends AFCBaseModelAt {

	private String encodedId;
	private String decodedId;

	/**
     * 
     */
	private static final long serialVersionUID = 7433649486178875339L;

	/**
     * 
     */
	public AFCObjectId() {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ssc.afc.common.model.AFCBaseModelAt#validate()
	 */
	@Override
	public boolean validate() {
		return true;
	}

	/**
	 * @return the encodedId
	 */
	public String getEncodedId() {
		if (encodedId == null) {
			processEncode();
		}
		return encodedId;
	}

	/**
	 * @param encodedId
	 *            the encodedId to set
	 */
	public void encodedId() {
		processEncode();
	}

	/**
	 * @param encodedId
	 *            the encodedId to set
	 */
	public void decodedId(String encodedId) {

		this.encodedId = encodedId;
		decodeid();
	}

	/**
	 * @return the decodedId
	 */
	public String getDecodedId() {
		return decodedId;
	}

	/**
	 * @param decodedId
	 *            the decodedId to set
	 */
	public void setDecodedId(String decodedId) {
		this.decodedId = decodedId;
	}

	/**
	 * This will return the key for the bo that we are putting in gen cache
	 * 
	 * @return
	 */
	public String getKeyForGenCach() {
		return this.decodedId;
	}

	private void processEncode() {
		// this is where we are going to play with tricks
		this.encodedId = decodedId;

	}

	private void decodeid() {
		// this is where we are going to do reverse trick
		this.decodedId = encodedId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((decodedId == null) ? 0 : decodedId.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof AFCObjectId)) {
			return false;
		}
		AFCObjectId other = (AFCObjectId) obj;
		if (decodedId == null) {
			if (other.decodedId != null) {
				return false;
			}
		} else if (!decodedId.equals(other.decodedId)) {
			return false;
		}
		return true;
	}

}
