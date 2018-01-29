package com.skyrain.software;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.skyrain.software.dxf.DxfDocument;
import com.skyrain.software.resolve.DxfRvlFile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        long time = System.currentTimeMillis();
        PrintWriter writer = new PrintWriter(new FileWriter(new File("/home/var_rain/files/dxf.json")));
        String dxf = "/home/var_rain/files/libdxfrw/dwg2dxf/test.dxf";
//        String dxf = "/home/var_rain/files/news.dxf";
        DxfRvlFile reso = new DxfRvlFile();
        DxfDocument document = reso.resolve(dxf);
//        System.out.println(new Gson().toJson(document));
        Gson json = new GsonBuilder().setPrettyPrinting().create();
        writer.write(json.toJson(document));
        writer.flush();
        writer.close();
        System.out.println("Options was ok. use time: " + (System.currentTimeMillis() - time) + "ms");
    }
}
