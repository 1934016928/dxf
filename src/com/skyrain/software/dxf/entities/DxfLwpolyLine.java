package com.skyrain.software.dxf.entities;

import java.util.List;

public class DxfLwpolyLine extends DxfEntity {

    private int pointCount;
    private boolean lineClosed;
    private double offset;
    private List<DxfPoint> points;

    public int getPointCount() {
        return pointCount;
    }

    public void setPointCount(int pointCount) {
        this.pointCount = pointCount;
    }

    public boolean isLineClosed() {
        return lineClosed;
    }

    public void setLineClosed(boolean lineClosed) {
        this.lineClosed = lineClosed;
    }

    public double getOffset() {
        return offset;
    }

    public void setOffset(double offset) {
        this.offset = offset;
    }

    public List<DxfPoint> getPoints() {
        return points;
    }

    public void setPoints(List<DxfPoint> points) {
        this.points = points;
    }
}
