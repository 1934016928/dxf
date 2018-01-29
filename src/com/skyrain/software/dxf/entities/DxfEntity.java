package com.skyrain.software.dxf.entities;

public class DxfEntity {

    private String entHandle;
    private String softPon;
    private String subClass;
    private String layerName;
    private String lineType;
    private int colorNum;
    private String lineWidth;
    private String subType;

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

    public String getLineType() {
        return lineType;
    }

    public void setLineType(String lineType) {
        this.lineType = lineType;
    }

    public int getColorNum() {
        return colorNum;
    }

    public void setColorNum(int colorNum) {
        this.colorNum = colorNum;
    }

    public String getLineWidth() {
        return lineWidth;
    }

    public void setLineWidth(String lineWidth) {
        this.lineWidth = lineWidth;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }
}
