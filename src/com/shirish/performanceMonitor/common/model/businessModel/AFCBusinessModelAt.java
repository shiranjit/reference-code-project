/**
 * 
 */
package com.shirish.performanceMonitor.common.model.businessModel;

import com.shirish.performanceMonitor.common.model.AFCObjectId;

/**
 * @author t556427
 *
 */
public abstract class AFCBusinessModelAt {
	
	protected AFCObjectId objectId = new AFCObjectId();

	
	public AFCObjectId getObjectId() {
		return objectId;
	}

	public void setObjectId(AFCObjectId objectId) {
		this.objectId = objectId;
	}
	


}
