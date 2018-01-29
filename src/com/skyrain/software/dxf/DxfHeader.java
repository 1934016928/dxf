package com.skyrain.software.dxf;

import com.skyrain.software.dxf.beans.DxfPair;

import java.util.List;

public class DxfHeader {

    private List<DxfPair> vars;

    public List<DxfPair> getVars() {
        return vars;
    }

    public void setVars(List<DxfPair> vars) {
        this.vars = vars;
    }
}
