/**
 * © Qio Technologies Ltd. 2016. All rights reserved.
 * CONFIDENTIAL AND PROPRIETARY INFORMATION OF QIO TECHNOLOGIES LTD.
 */
package io.qio.qa.lib.ehm.model.activityType.helper;


import io.qio.qa.lib.ehm.model.activityType.ActivityType;

public class ActivityTypeHelper {
	ActivityType activityType = null;

	/*
	 * This method is invoked from each of the following methods to make sure every time a new ActivityType is created with a unique timestamp.
	 */
	private void initDefaultActivityType() {
		java.util.Date date = new java.util.Date();
		String timestamp = Long.toString(date.getTime());
		activityType = new ActivityType(timestamp);
	}

	public ActivityType getActivityType() {
		initDefaultActivityType();
		return activityType;
	}

}