package com.skyrain.software.dxf.beans;

import com.skyrain.software.dxf.entities.DxfBlock;

import java.util.List;

public class DxfBlockEntity {

    private String entHandle;
    private String softPon;
    private String subClass;
    private String layerName;
    private String subType;
    private List<DxfBlock> blocks;

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

    public List<DxfBlock> getBlocks() {
        return blocks;
    }

    public void setBlocks(List<DxfBlock> blocks) {
        this.blocks = blocks;
    }
}
