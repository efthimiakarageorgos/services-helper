/**
 * © HBC Shared Services QA 2018. All rights reserved.
 * CONFIDENTIAL AND PROPRIETARY INFORMATION OF HBC.
 */
package com.hbc.qa.lib.iib.model.insight.helper;

import com.hbc.qa.lib.iib.common.TokenUtil;
import com.hbc.qa.lib.iib.model.token.TokenRequest;
import com.hbc.qa.lib.iib.model.token.helper.AttributeDataType;
import com.hbc.qa.lib.iib.common.TenantUtil;
import com.hbc.qa.lib.iib.model.insight.InsightRequest;
import com.hbc.qa.lib.iib.model.tenant.Tenant;
import static com.hbc.qa.lib.common.BaseHelper.getCurrentTimeStamp;

public class InsightRequestHelper {
	InsightRequest insight = null;
	TokenUtil tokenUtil = null;
	TenantUtil tenantUtil = null;


	private void initDefaultInsight(String insightTypeId, String tenantId) {
		insight = new InsightRequest(getCurrentTimeStamp(), insightTypeId, tenantId);
	}

	public InsightRequest getInsightWithPredefinedInsightTypeAndTenant(String insightTypeId, String tenantId) {
		initDefaultInsight(insightTypeId, tenantId);
		return insight;
	}

	public InsightRequest getInsightWithCreatingInsightTypeAndTenant(String insightTypeFlavor, AttributeDataType attributeDataType) {
		tokenUtil = new TokenUtil();
		tenantUtil = new TenantUtil();

		TokenRequest tokenRequest = tokenUtil.createInsightType(insightTypeFlavor);

		Tenant tenant = tenantUtil.createTenant();
		String tenantId = tenant.getTenantId();

		return getInsightWithPredefinedInsightTypeAndTenant("insightTypeId", tenantId);
	}
}