package com.skyrain.software.io;

import com.skyrain.software.dxf.beans.DxfAttribute;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Read dxf file to java object.
 */

public class DxfReader {

    /**
     * Read dxf file to object list.
     *
     * @param dxf dxf file.
     * @return return dxf attr list.
     * @throws IOException
     */
    public List<DxfAttribute> dxf2Obj(String dxf) throws IOException {
        List<DxfAttribute> attrs = new ArrayList<>();
        FileReader fileReader = new FileReader(new File(dxf));
        BufferedReader reader = new BufferedReader(fileReader);
        String key, value;
        while ((key = reader.readLine()) != null && (value = reader.readLine()) != null) {
            key = key.replaceAll(" ", "");
            DxfAttribute attr = new DxfAttribute();
            attr.setGroupCode(Integer.parseInt(key));
            attr.setGroupValue(value);
            attrs.add(attr);
        }
        fileReader.close();
        reader.close();
        return attrs;
    }
}
