package com.skyrain.software.tools;

import com.skyrain.software.dxf.beans.DxfAttribute;

import java.util.List;

public class Traverse {

    private int num;
    private int size;
    private List<DxfAttribute> attributes;
    private DxfAttribute attribute;

    /**
     * Init objects.
     *
     * @param objs dxf object list.
     */
    public Traverse(List<DxfAttribute> objs) {
        this.attributes = objs;
    }

    /**
     * Start read list.
     */
    public void begin() {
        this.num = 0;
        this.size = attributes.size();
    }

    /**
     * Can read next object.
     *
     * @return true and false.
     */
    public boolean hasNext() {
        return num != size;
    }

    /**
     * Get next object.
     *
     * @return return DxfAttribute.
     */
    public Traverse next() {
        this.attribute = attributes.get(num);
        num++;
        return this;
    }

    /**
     * Get object.
     *
     * @return DxfAttribute.
     */
    public DxfAttribute obj() {
        return this.attribute;
    }

    /**
     * Stop read.
     */
    public void end() {
        this.num = 0;
        this.size = 0;
        this.attributes = null;
    }
}
