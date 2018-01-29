package com.skyrain.software.dxf.beans;

public class DxfAttribute {

    private int groupCode;
    private String groupValue;

    public DxfAttribute() {

    }

    public DxfAttribute(int groupCode, String groupValue) {
        this.groupCode = groupCode;
        this.groupValue = groupValue;
    }

    public int getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(int groupCode) {
        this.groupCode = groupCode;
    }

    public String getGroupValue() {
        return groupValue;
    }

    public void setGroupValue(String groupValue) {
        this.groupValue = groupValue;
    }
}
