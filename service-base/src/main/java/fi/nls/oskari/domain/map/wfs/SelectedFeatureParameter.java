package fi.nls.oskari.domain.map.wfs;

import fi.nls.oskari.domain.map.JSONLocalizedTitle;

public class SelectedFeatureParameter extends JSONLocalizedTitle {
	private int id;
	private int selectedFeatureTypeId;
	private FeatureParameter featureParameter;
	private WFSLayerView wfsLayerView;
	
	@Override
	public String toString() {
		return "SelectedFeatureParameter [featureParameter=" + featureParameter
				+ ", id=" + id + ", selectedFeatureTypeId="
				+ selectedFeatureTypeId + ", titleEn=" + getTitle("en") + ", titleFi="
				+ getTitle("fi") + ", titleSv=" + getTitle("sv") + ", wfsLayerView="
				+ wfsLayerView + "]";
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSelectedFeatureTypeId() {
		return selectedFeatureTypeId;
	}
	public void setSelectedFeatureTypeId(int selectedFeatureTypeId) {
		this.selectedFeatureTypeId = selectedFeatureTypeId;
	}
	public FeatureParameter getFeatureParameter() {
		return featureParameter;
	}
	public void setFeatureParameter(FeatureParameter featureParameter) {
		this.featureParameter = featureParameter;
	}
	public WFSLayerView getWfsLayerView() {
		return wfsLayerView;
	}
	public void setWfsLayerView(WFSLayerView wfsLayerView) {
		this.wfsLayerView = wfsLayerView;
	}
}
