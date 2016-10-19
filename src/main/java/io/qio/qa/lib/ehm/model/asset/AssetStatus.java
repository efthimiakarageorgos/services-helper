/**
 * © Qio Technologies Ltd. 2016. All rights reserved.
 * CONFIDENTIAL AND PROPRIETARY INFORMATION OF QIO TECHNOLOGIES LTD.
 */
package io.qio.qa.lib.ehm.model.asset;

public enum AssetStatus {
	CONFIG_IN_PROGRESS("ConfigurationInProgress"),
	CONFIG_COMPLETE("ConfigurationComplete"),
	TESTING_IN_PROGRESS("TestingInProgress"),
	TESTING_COMPLETE("TestingComplete"),
	IN_SERVICE("InService"),
	OUT_OF_SERVICE("OutOfService"),
	DELETED("Deleted"),
	RETIRED("Retired"),
	CREATED("AssetCreated");
	
	private String realValue;

	private AssetStatus(String realValue) {
		this.realValue = realValue;
	}

	@Override
	public String toString() {
		return realValue;
	}
}