package com.shirish.performanceMonitor.common.model;


/**
 * 
 * @author shirish ranjit
 * @version 1.0
 * 
 */

public class PerfMonRecord extends AFCBaseModelAt {
	private static final long serialVersionUID = -7618822097207938376L;
	public static final int DEBUG = 0;
	private int level = DEBUG;
	public static final int TRACE = 1;

	private long id;

	private String threadName;

	private long startTime;

	private long stopTime;

	private String uuid;

	private String clientAppId;

	private String clientRqstId;

	private String userId;

	private String platformCd;

	private String environmentCd;

	private String contextNm;

	private String hostNm;

	private String entityNm;

	private String criteriaCd;

	private String componentNm;

	private String taskNm;

	private String resourceAllocatedSw;

	private int availResourceCnt;

	private int maxResourceCnt;

	private long startTs;

	private long endTs;

	private int callLvlNum;

	private String callNumTxt;

	private String archivePurgeCd = "N";

	private String description;
	

	public String getArchivePurgeCd() {
		return archivePurgeCd;
	}

	public void setArchivePurgeCd(String archivePurgeCd) {
		this.archivePurgeCd = archivePurgeCd;
	}

	/**
	 * 
	 * @return nano seconds
	 */
	public long getTimeSpentNum() {
		return stopTime - startTime;
	}

	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public long getStopTime() {
		return stopTime;
	}

	public void setStopTime(long stopTime) {
		this.stopTime = stopTime;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getThreadName() {
		return threadName;
	}

	public void setThreadName(String threadName) {
		this.threadName = threadName;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public boolean validate() {
		return true;
	}

	public String getCallNumTxt() {
		return callNumTxt;
	}

	public void setCallNumTxt(String hierarchyNumber) {
		this.callNumTxt = hierarchyNumber;
	}

	public int getCallLvlNum() {
		return callLvlNum;
	}

	public void setCallLvlNum(int hierarchyLevel) {
		this.callLvlNum = hierarchyLevel;
	}


	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getClientAppId() {
		return clientAppId;
	}

	public void setClientAppId(String clientAppId) {
		this.clientAppId = clientAppId;
	}

	public String getClientRqstId() {
		return clientRqstId;
	}

	public void setClientRqstId(String clientRqstId) {
		this.clientRqstId = clientRqstId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPlatformCd() {
		return platformCd;
	}

	public void setPlatformCd(String platformCd) {
		this.platformCd = platformCd;
	}

	public String getEnvironmentCd() {
		return environmentCd;
	}

	public void setEnvironmentCd(String environmentCd) {
		this.environmentCd = environmentCd;
	}

	public String getContextNm() {
		return contextNm;
	}

	public void setContextNm(String contextNm) {
		this.contextNm = contextNm;
	}

	public String getHostNm() {
		return hostNm;
	}

	public void setHostNm(String hostNm) {
		this.hostNm = hostNm;
	}

	public String getEntityNm() {
		return entityNm;
	}

	public void setEntityNm(String entityNm) {
		this.entityNm = entityNm;
	}

	public String getCriteriaCd() {
		return criteriaCd;
	}

	public void setCriteriaCd(String criteriaCd) {
		this.criteriaCd = criteriaCd;
	}

	public String getComponentNm() {
		return componentNm;
	}

	public void setComponentNm(String componentNm) {
		this.componentNm = componentNm;
	}

	public String getTaskNm() {
		return taskNm;
	}

	public void setTaskNm(String taskNm) {
		this.taskNm = taskNm;
	}

	public String getResourceAllocatedSw() {
		return resourceAllocatedSw;
	}

	public void setResourceAllocatedSw(String resourceAllocatedSw) {
		this.resourceAllocatedSw = resourceAllocatedSw;
	}

	public int getAvailResourceCnt() {
		return availResourceCnt;
	}

	public void setAvailResourceCnt(int availResourceCnt) {
		this.availResourceCnt = availResourceCnt;
	}

	public int getMaxResourceCnt() {
		return maxResourceCnt;
	}

	public void setMaxResourceCnt(int maxResourceCnt) {
		this.maxResourceCnt = maxResourceCnt;
	}

	public long getStartTs() {
		return startTs;
	}

	public void setStartTs(long startTs) {
		this.startTs = startTs;
	}

	public long getEndTs() {
		return endTs;
	}

	public void setEndTs(long endTs) {
		this.endTs = endTs;

	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		String hierarchyLevelStr = this.getCallLvlNum() == 0 ? "" : "" + 4
				* this.getCallLvlNum();
		String tempStr = String.format("%" + hierarchyLevelStr + "s", "");
		StringBuilder workNameSB = new StringBuilder();
		if (this.getCallNumTxt()==null || "".equals(this.getCallNumTxt())) {
			workNameSB
			        .append("Thread Name ")
			        .append(getThreadName())
			        .append(" Call ")
					.append(this.componentNm)
					.append(" - ")
					.append(description == null ? this.getTaskNm()
							: description);
		} else {
			workNameSB
					.append(tempStr)
					.append(this.getCallNumTxt())
					.append(" ")
					.append("Call ")
					.append(this.componentNm)
					.append(" - ")
					.append(description == null ? this.getTaskNm()
							: description);
		}

		StringBuilder asStringSB = new StringBuilder();

		long costs = stopTime - startTime;
		if (startTime == stopTime && startTime == 0) {
			asStringSB.append("[Thread Name:").append(threadName)
					.append("]\t[Record Sequence ID:")
					.append(String.format("%5d", id)).append("]\t[Work Name:")
					.append(workNameSB).append("]\t");
		} else {
			asStringSB.append("[Thread Name:").append(threadName)
					.append("]\t[Record Sequence ID:")
					.append(String.format("%5d", id)).append("]\t[Work Name:")
					.append(workNameSB).append("]\tTakes(nano Sec):")
					.append(costs);
		}
		return asStringSB.toString();
	}

}
