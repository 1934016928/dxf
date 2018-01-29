package com.skyrain.software.dxf;

import com.skyrain.software.dxf.beans.DxfBlockEntity;

import java.util.List;

public class DxfBlocks {

    private List<DxfBlockEntity> blockEntities;

    public List<DxfBlockEntity> getBlockEntities() {
        return blockEntities;
    }

    public void setBlockEntities(List<DxfBlockEntity> blockEntities) {
        this.blockEntities = blockEntities;
    }
}
