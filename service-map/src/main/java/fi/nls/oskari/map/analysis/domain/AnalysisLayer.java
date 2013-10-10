package fi.nls.oskari.map.analysis.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import fi.nls.oskari.domain.map.analysis.Analysis;

public class AnalysisLayer {
    private final String type = "analysislayer";
    private int id = 0;
    private String name = "";
    private String subtitle = "";
    private String inputType = "";
    private String inputAnalysisId = null;
    
    private String orgName = "";
    private String inspire = "";
    private Integer opacity;
    private Double minScale;
    private Double maxScale;
    private List<String> fields = new ArrayList<String>();
    private List<String> locales = new ArrayList<String>();
    private Map<String, String> fieldsMap = new ConcurrentHashMap<String, String>();

    private List<String> aggreFunctions;
    private String style;
    private String wpsUrl = "";
    private String wpsName = "";
    private String method = "";
    private String result = "";
    private long wpsLayerId = 0;
    private AnalysisMethodParams analysisMethodParams;
    private String filter;

    public String getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getInputType() {
        return inputType;
    }

    public void setInputType(String inputType) {
        this.inputType = inputType;
    }

    public String getInputAnalysisId() {
        return inputAnalysisId;
    }

    public void setInputAnalysisId(String inputAnalysisId) {
        this.inputAnalysisId = inputAnalysisId;
    }
    

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getInspire() {
        return inspire;
    }

    public void setInspire(String inspire) {
        this.inspire = inspire;
    }

    public Integer getOpacity() {
        return opacity;
    }

    public void setOpacity(Integer opacity) {
        this.opacity = opacity;
    }

    public Double getMinScale() {
        return minScale;
    }

    public void setMinScale(Double double1) {
        this.minScale = double1;
    }

    public Double getMaxScale() {
        return maxScale;
    }

    public void setMaxScale(Double double1) {
        this.maxScale = double1;
    }

    public List<String> getFields() {
        return fields;
    }

    public void setFields(List<String> fields) {
        this.fields = fields;
    }

    public List<String> getLocales() {
        return locales;
    }

    public void setLocales(List<String> locales) {
        this.locales = locales;
    }

    public Map<String, String> getFieldsMap() {
        return fieldsMap;
    }

    public void setFieldsMap(Map<String, String> fieldsMap) {
        this.fieldsMap = fieldsMap;
    }

    public List<String> getAggreFunctions() {
        return aggreFunctions;
    }

    public void setAggreFunctions(List<String> aggreFunctions) {
        this.aggreFunctions = aggreFunctions;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public AnalysisMethodParams getAnalysisMethodParams() {
        return analysisMethodParams;
    }

    public void setAnalysisMethodParams(
            AnalysisMethodParams analysisMethodParams) {
        this.analysisMethodParams = analysisMethodParams;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getWpsUrl() {
        return wpsUrl;
    }

    public void setWpsUrl(String wpsUrl) {
        this.wpsUrl = wpsUrl;
    }

    public String getWpsName() {
        return wpsName;
    }

    public void setWpsName(String wpsName) {
        this.wpsName = wpsName;
    }

    public long getWpsLayerId() {
        return wpsLayerId;
    }

    public void setWpsLayerId(long wpsLayerId) {
        this.wpsLayerId = wpsLayerId;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public JSONObject getJSON() throws JSONException {
        JSONObject json = new JSONObject();
        json.put("id", this.getId());
        json.put("type", this.getType());

        json.put("name", this.getName());
        json.put("subtitle", this.getSubtitle());
        json.put("orgName", this.getOrgName());
        json.put("inspire", this.getInspire());

        json.put("opacity", this.getOpacity());
        json.put("minScale", this.getMinScale());
        json.put("maxScale", this.getMaxScale());
        JSONArray fields = new JSONArray();
        for (String field : this.getFields()) {
            fields.put(field);
        }
        json.put("fields", fields);
        JSONArray locales = new JSONArray();
        for (String locale : this.getLocales()) {
            locales.put(locale);
        }
        json.put("locales", locales);
        json.put("wpsUrl", this.getWpsUrl());
        json.put("wpsName", this.getWpsName());
        json.put("wpsLayerId", this.getWpsLayerId());
        json.put("result", this.getResult());

        return json;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public String getFilter() {
        return filter;
    }

    public void setFieldMapping(Analysis analysis) {
        if (analysis != null) {
            for (int j = 1; j < 11; j++) {
                String colx = analysis.getColx(j);
                if (colx != null && !colx.isEmpty()) {
                    if (colx.indexOf("=") != -1) {
                        this.fieldsMap.put(colx.split("=")[0],
                                colx.split("=")[1]);
                    }
                }

            }

        }
    }

    public void setLocaleFields(Analysis analysis) {
       
        if (analysis != null) {
            this.locales.clear();
            // Fixed 1st is ID
            this.locales.add("ID");
            for (int j = 1; j < 11; j++) {
                String colx = analysis.getColx(j);
                if (colx != null && !colx.isEmpty()) {
                    if (colx.indexOf("=") != -1) {
                        this.locales.add(colx.split("=")[1]);
                    }
                }

            }

        }

    }

    public void setNativeFields(Analysis analysis) {
        
        if (analysis != null) {
            this.fields.clear();
            // Fixed 1st is ID
            this.fields.add("ID");
            for (int j = 1; j < 11; j++) {
                String colx = analysis.getColx(j);
                if (colx != null && !colx.isEmpty()) {
                    if (colx.indexOf("=") != -1) {
                        this.fields.add(colx.split("=")[0]);
                    }
                }

            }

        }
    }

}