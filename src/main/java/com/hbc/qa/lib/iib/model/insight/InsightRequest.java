/**
 * © HBC Shared Services QA 2018. All rights reserved.
 * CONFIDENTIAL AND PROPRIETARY INFORMATION OF HBC.
 */
package com.hbc.qa.lib.iib.model.insight;

public class InsightRequest extends Insight {
	private String insightTypeId;

	public InsightRequest() {
	}

	@SuppressWarnings("serial")
	public InsightRequest(String timeStamp, String insightTypeId, String tenantId) {
		super(timeStamp, tenantId, insightTypeId);
		this.insightTypeId = insightTypeId;
	}

	public InsightRequest(String title, String description, String insightTypeId, String tenantId, String status, String severity) {
		super(title, description, tenantId, status);
		this.insightTypeId = insightTypeId;
	}

	public InsightRequest(InsightRequest insightRequest) {
		this(insightRequest.getTitle(), insightRequest.getDescription(), insightRequest.getInsightTypeId(), insightRequest.getTenantId(), insightRequest.getStatus(), insightRequest.getSeverity());
	}

	public String getInsightTypeId() {
		return insightTypeId;
	}

	public void setInsightTypeId(String insightTypeId) {
		this.insightTypeId = insightTypeId;
	}

	public String getTenantId() {
		return this.tenantId;
	}

}