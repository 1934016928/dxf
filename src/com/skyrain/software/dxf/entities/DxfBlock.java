package com.skyrain.software.dxf.entities;

import java.util.List;

public class DxfBlock {

    private String entHandle;
    private String softPon;
    private String subClass;
    private String layerName;
    private String subType;
    private String blcName;
    private int entBits;
    private DxfPoint point;
    private String othName;
    private String entText;
    private List<DxfEntity> entities;

    public String getEntHandle() {
        return entHandle;
    }

    public void setEntHandle(String entHandle) {
        this.entHandle = entHandle;
    }

    public String getSoftPon() {
        return softPon;
    }

    public void setSoftPon(String softPon) {
        this.softPon = softPon;
    }

    public String getSubClass() {
        return subClass;
    }

    public void setSubClass(String subClass) {
        this.subClass = subClass;
    }

    public String getLayerName() {
        return layerName;
    }

    public void setLayerName(String layerName) {
        this.layerName = layerName;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public String getBlcName() {
        return blcName;
    }

    public void setBlcName(String blcName) {
        this.blcName = blcName;
    }

    public int getEntBits() {
        return entBits;
    }

    public void setEntBits(int entBits) {
        this.entBits = entBits;
    }

    public DxfPoint getPoint() {
        return point;
    }

    public void setPoint(DxfPoint point) {
        this.point = point;
    }

    public String getOthName() {
        return othName;
    }

    public void setOthName(String othName) {
        this.othName = othName;
    }

    public String getEntText() {
        return entText;
    }

    public void setEntText(String entText) {
        this.entText = entText;
    }

    public List<DxfEntity> getEntities() {
        return entities;
    }

    public void setEntities(List<DxfEntity> entities) {
        this.entities = entities;
    }
}
