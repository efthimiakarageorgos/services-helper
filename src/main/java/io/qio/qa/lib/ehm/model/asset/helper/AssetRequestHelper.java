/**
 * © Qio Technologies Ltd. 2016. All rights reserved.
 * CONFIDENTIAL AND PROPRIETARY INFORMATION OF QIO TECHNOLOGIES LTD.
 */
package io.qio.qa.lib.ehm.model.asset.helper;


import io.qio.qa.lib.ehm.common.APITestUtil;
import io.qio.qa.lib.ehm.common.AssetTypeUtil;
import io.qio.qa.lib.ehm.common.TenantUtil;
import io.qio.qa.lib.ehm.model.asset.AssetRequest;
import io.qio.qa.lib.ehm.model.assetType.AssetType;
import io.qio.qa.lib.ehm.model.assetType.helper.AttributeDataType;
import io.qio.qa.lib.ehm.model.assetType.helper.ParameterDataType;
import io.qio.qa.lib.ehm.model.tenant.Tenant;

public class AssetRequestHelper {
	AssetRequest asset = null;
	AssetTypeUtil assetTypeUtil = null;
	TenantUtil tenantUtil = null;

	private void initDefaultAsset() {
		java.util.Date date = new java.util.Date();
		String timestamp = Long.toString(date.getTime());
		asset = new AssetRequest(timestamp, "", "");
	}

	public AssetRequest getAssetWithPredefinedAssetTypeAndTenant(String assetTypeId, String tenantId) {
		initDefaultAsset();
		asset.setAssetType(assetTypeId);
		asset.setTenant(tenantId);
		return asset;
	}

	public AssetRequest getAssetWithCreatingAssetTypeAndTenant(String assetTypeFlavor, AttributeDataType attributeDataType, ParameterDataType parameterDataType) {
		assetTypeUtil = new AssetTypeUtil();
		tenantUtil = new TenantUtil();

		AssetType assetType = assetTypeUtil.createAssetType(assetTypeFlavor, attributeDataType, parameterDataType);
		String assetTypeId = APITestUtil.getElementId(assetType.get_links().getSelfLink().getHref());

		Tenant tenant = tenantUtil.createTenant();
		String tenantId = tenant.getTenantId();

		return getAssetWithPredefinedAssetTypeAndTenant(assetTypeId, tenantId);
	}
}