package com.skyrain.software.dxf.entities;

public class DxfLine extends DxfEntity {

    private DxfPoint start;
    private DxfPoint end;

    public DxfPoint getStart() {
        return start;
    }

    public void setStart(DxfPoint start) {
        this.start = start;
    }

    public DxfPoint getEnd() {
        return end;
    }

    public void setEnd(DxfPoint end) {
        this.end = end;
    }
}
