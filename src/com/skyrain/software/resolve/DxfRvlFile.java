package com.skyrain.software.resolve;

import com.skyrain.software.dxf.DxfBlocks;
import com.skyrain.software.dxf.DxfDocument;
import com.skyrain.software.dxf.DxfHeader;
import com.skyrain.software.dxf.beans.DxfAttribute;
import com.skyrain.software.dxf.beans.DxfBlockEntity;
import com.skyrain.software.dxf.beans.DxfPair;
import com.skyrain.software.dxf.entities.DxfPoint;
import com.skyrain.software.enums.DxfSection;
import com.skyrain.software.enums.DxfTags;
import com.skyrain.software.io.DxfReader;
import com.skyrain.software.tools.Traverse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Resolve dxf file.
 */

public class DxfRvlFile {

    private List<DxfAttribute> dxf;
    private DxfReader reader;

    /**
     * Init objects.
     */
    public DxfRvlFile() {
        reader = new DxfReader();
    }

    /**
     * Begin start resolve dxf file.
     *
     * @param file dxf file path.
     * @return return DxfDocument object.
     */
    public DxfDocument resolve(String file) {
        try {
            dxf = reader.dxf2Obj(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return startResolve();
    }

    /**
     * Begin resolve dxf object list.
     *
     * @return return DxfDocument object.
     */
    private DxfDocument startResolve() {
        DxfDocument doc = new DxfDocument();
        doc.setHeader(this.resolveHeader(this.splitOfSection(DxfSection.HEADER)));
        doc.setBlocks(this.resolveBlocks(this.splitOfSection(DxfSection.BLOCKS)));
//        for (DxfAttribute attribute : this.splitOfSection(DxfSection.BLOCKS)) {
//            System.out.println("\"" + attribute.getGroupCode() + "\":\"" + attribute.getGroupValue() + "\"");
//        }
        return doc;
    }

    /**
     * Resolve dxf blocks.
     *
     * @param dxf dxf object list.
     * @return return DxfBlocks object.
     */
    private DxfBlocks resolveBlocks(List<DxfAttribute> dxf) {
        DxfBlocks blocks = new DxfBlocks();
        List<DxfBlockEntity> entities = new ArrayList<>();
        List<DxfAttribute> blcEntity = new ArrayList<>();
        DxfRvlGraph graph = new DxfRvlGraph();
        for (DxfAttribute attribute : dxf) {
            if (attribute.getGroupCode() == 0 && attribute.getGroupValue().equals(DxfTags.SECTION.name())) continue;
            if (attribute.getGroupCode() == 0 && attribute.getGroupValue().equals(DxfTags.ENDSEC.name())) continue;
            if (attribute.getGroupCode() == 2 && attribute.getGroupValue().equals(DxfSection.BLOCKS.name())) continue;
            if (attribute.getGroupCode() == 0 && attribute.getGroupValue().equals(DxfTags.BLOCK.name())) {
                if (blcEntity.size() != 0) {
                    entities.add(graph.rvlBlockEntity(blcEntity));
                    blcEntity.clear();
                }
            }
            blcEntity.add(attribute);
        }
        if (blcEntity.size() != 0) entities.add(graph.rvlBlockEntity(blcEntity));
        blocks.setBlockEntities(entities);
        return blocks;
    }

    /**
     * Resolve dxf header.
     *
     * @param dxf dxf object list.
     * @return return DxfHeader object.
     */
    private DxfHeader resolveHeader(List<DxfAttribute> dxf) {
        DxfHeader header = new DxfHeader();
        List<DxfPair> pairs = new ArrayList<>();
        Traverse traverse = new Traverse(dxf);
        DxfAttribute attr1 = null, attr2;
        traverse.begin();
        while (traverse.hasNext()) {
            if (attr1 == null) attr1 = traverse.next().obj();
            if (!traverse.hasNext()) break;
            attr2 = traverse.next().obj();
            if (attr1.getGroupValue().equals(DxfTags.SECTION.name())) {
                attr1 = null;
            } else if (attr2.getGroupCode() != 10) {
                DxfPair pair = new DxfPair();
                pair.setName(attr1.getGroupValue());
                pair.setValue(attr2.getGroupValue());
                pairs.add(pair);
                attr1 = null;
            } else {
                DxfPair pair = new DxfPair();
                pair.setName(attr1.getGroupValue());
                DxfPoint point = new DxfPoint();
                point.setX(Double.parseDouble(attr2.getGroupValue()));
                point.setY(Double.parseDouble(traverse.next().obj().getGroupValue()));
                attr1 = traverse.next().obj();
                if (attr1.getGroupCode() == 30) {
                    point.setY(Double.parseDouble(attr1.getGroupValue()));
                    attr1 = null;
                }
                pair.setValue(point);
                pairs.add(pair);
            }
        }
        traverse.end();
        header.setVars(pairs);
        return header;
    }

    /**
     * Split object list with tag.
     *
     * @param tag split tag.
     * @return return dxf object list split  with tag.
     */
    private List<DxfAttribute> splitOfSection(DxfSection tag) {
        List<DxfAttribute> part = new ArrayList<>();
        int subStart = 0, subEnd = 0;
        for (int i = 0; i < dxf.size(); i++) {
            DxfAttribute attribute = dxf.get(i);
            if (attribute.getGroupCode() == 0 && attribute.getGroupValue().equals(DxfTags.SECTION.name())) {
                DxfAttribute name = dxf.get(i + 1);
                if (name.getGroupCode() == 2 && name.getGroupValue().equals(tag.name())) {
                    part.add(attribute);
                    subStart = i;
                }
            } else if (attribute.getGroupCode() == 0 && attribute.getGroupValue().equals(DxfTags.ENDSEC.name())) {
                if (part.size() > 0) {
                    part.add(attribute);
                    subEnd = i + 1;
                    break;
                }
            } else {
                if (part.size() > 0) {
                    part.add(attribute);
                }
            }
        }
        if (part.size() > 0) dxf.subList(subStart, subEnd).clear();
        return part;
    }
}
