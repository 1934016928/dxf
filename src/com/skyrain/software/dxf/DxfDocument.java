package com.skyrain.software.dxf;

public class DxfDocument {

    private DxfHeader header;
    private DxfClasses classes;
    private DxfTables tables;
    private DxfBlocks blocks;
    private DxfEntities entities;
    private DxfObjects objects;

    public DxfHeader getHeader() {
        return header;
    }

    public void setHeader(DxfHeader header) {
        this.header = header;
    }

    public DxfClasses getClasses() {
        return classes;
    }

    public void setClasses(DxfClasses classes) {
        this.classes = classes;
    }

    public DxfTables getTables() {
        return tables;
    }

    public void setTables(DxfTables tables) {
        this.tables = tables;
    }

    public DxfBlocks getBlocks() {
        return blocks;
    }

    public void setBlocks(DxfBlocks blocks) {
        this.blocks = blocks;
    }

    public DxfEntities getEntities() {
        return entities;
    }

    public void setEntities(DxfEntities entities) {
        this.entities = entities;
    }

    public DxfObjects getObjects() {
        return objects;
    }

    public void setObjects(DxfObjects objects) {
        this.objects = objects;
    }
}
