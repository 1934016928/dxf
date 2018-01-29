package com.skyrain.software.dxf.entities;

public class DxfCircle extends DxfEntity {

    private DxfPoint center;
    private double radius;

    public DxfPoint getCenter() {
        return center;
    }

    public void setCenter(DxfPoint center) {
        this.center = center;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
