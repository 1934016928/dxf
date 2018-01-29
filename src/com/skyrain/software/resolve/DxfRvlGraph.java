package com.skyrain.software.resolve;

import com.skyrain.software.dxf.beans.DxfAttribute;
import com.skyrain.software.dxf.beans.DxfBlockEntity;
import com.skyrain.software.dxf.entities.DxfBlock;
import com.skyrain.software.dxf.entities.DxfEntity;
import com.skyrain.software.dxf.entities.DxfLine;
import com.skyrain.software.dxf.entities.DxfPoint;
import com.skyrain.software.enums.DxfTags;

import java.util.ArrayList;
import java.util.List;

public class DxfRvlGraph {

    /**
     * Resolve block entity.
     *
     * @param dxf dxf object list.
     * @return return DxfBlockEntity object.
     */
    public DxfBlockEntity rvlBlockEntity(List<DxfAttribute> dxf) {
        DxfBlockEntity entity = new DxfBlockEntity();
        List<DxfBlock> blocks = new ArrayList<>();
        List<DxfAttribute> atts = new ArrayList<>();
        for (DxfAttribute attribute : dxf) {
            if (attribute.getGroupCode() == 0 && attribute.getGroupValue().equals(DxfTags.ENDBLK.name())) {
                if (atts.size() != 0) {
                    blocks.add(rvlBlock(atts));
                    atts.clear();
                }
            }
            atts.add(attribute);
        }
        if (atts.size() != 0) {
            entity = rvlBlcEntityAttr(atts, entity);
        }
        entity.setBlocks(blocks);
        return entity;
    }

    /**
     * Resolve block entity attribute.
     *
     * @param dxf    dxf object list.
     * @param entity DxfBlockEntity object.
     * @return return DxfBlockEntity object.
     */
    private DxfBlockEntity rvlBlcEntityAttr(List<DxfAttribute> dxf, DxfBlockEntity entity) {
        for (DxfAttribute att : dxf) {
            if (att.getGroupCode() == 5) {
                entity.setEntHandle(att.getGroupValue());
            } else if (att.getGroupCode() == 330) {
                entity.setSoftPon(att.getGroupValue());
            } else if (att.getGroupCode() == 100) {
                if (entity.getSubClass() == null || entity.getSubClass().equals("")) {
                    entity.setSubClass(att.getGroupValue());
                } else {
                    entity.setSubType(att.getGroupValue());
                }
            } else if (att.getGroupCode() == 8) {
                entity.setLayerName(att.getGroupValue());
            }
        }
        return entity;
    }

    /**
     * Resolve dxf block objects.
     *
     * @param dxf dxf object list.
     * @return return DxfBlock object.
     */
    private DxfBlock rvlBlock(List<DxfAttribute> dxf) {
        DxfBlock block = null;
        List<DxfEntity> entities = new ArrayList<>();
        List<DxfAttribute> attrs = new ArrayList<>();
        for (DxfAttribute attribute : dxf) {
            if (attribute.getGroupCode() == 0 && attribute.getGroupValue().equals(DxfTags.BLOCK.name())) continue;
            if (attribute.getGroupCode() == 0 && block == null && attrs.size() != 0) {
                block = rvlBlockAttr(attrs);
                attrs.clear();
            }
            if (attribute.getGroupCode() == 0) {
                if (attrs.size() != 0) {
                    entities.add(rvlEntity(attrs));
                }
            }
            attrs.add(attribute);
        }
        if (block != null) {
            if (attrs.size() != 0) {
                entities.add(rvlEntity(attrs));
            }
        } else {
            block = rvlBlockAttr(attrs);
        }
        block.setEntities(entities);
        return block;
    }

    private DxfEntity rvlEntity(List<DxfAttribute> dxf) {
        DxfEntity entity;

        return null;
    }

    private DxfLine rvlLine(List<DxfAttribute> dxf) {

        return null;
    }

    /**
     * Resolve dxf block attribute.
     *
     * @param dxf dxf object list.
     * @return return DxfBlock object.
     */
    private DxfBlock rvlBlockAttr(List<DxfAttribute> dxf) {
        DxfBlock block = new DxfBlock();
        DxfPoint point = null;
        for (DxfAttribute attribute : dxf) {
            if (attribute.getGroupCode() == 5) {
                block.setEntHandle(attribute.getGroupValue());
            } else if (attribute.getGroupCode() == 330) {
                block.setSoftPon(attribute.getGroupValue());
            } else if (attribute.getGroupCode() == 100) {
                if (block.getSubClass() == null || block.getSubClass().equals("")) {
                    block.setSubClass(attribute.getGroupValue());
                } else {
                    block.setSubType(attribute.getGroupValue());
                }
            } else if (attribute.getGroupCode() == 8) {
                block.setLayerName(attribute.getGroupValue());
            } else if (attribute.getGroupCode() == 2) {
                block.setBlcName(attribute.getGroupValue());
            } else if (attribute.getGroupCode() == 70) {
                block.setEntBits(Integer.parseInt(attribute.getGroupValue().replaceAll(" ", "")));
            } else if (attribute.getGroupCode() == 10) {
                point = new DxfPoint();
                point.setX(Double.parseDouble(attribute.getGroupValue()));
            } else if (attribute.getGroupCode() == 20) {
                if (point != null) {
                    point.setY(Double.parseDouble(attribute.getGroupValue()));
                }
            } else if (attribute.getGroupCode() == 30) {
                if (point != null) {
                    point.setZ(Double.parseDouble(attribute.getGroupValue()));
                }
            } else if (attribute.getGroupCode() == 3) {
                if (point != null) {
                    block.setPoint(point);
                }
                block.setOthName(attribute.getGroupValue());
            } else if (attribute.getGroupCode() == 1) {
                block.setEntText(attribute.getGroupValue());
            }
        }
        return block;
    }
}
