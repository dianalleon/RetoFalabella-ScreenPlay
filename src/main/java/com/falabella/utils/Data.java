package com.falabella.utils;

import java.io.IOException;
import java.util.List;
import java.util.Map;
public class Data {

    public static List<Map<String, String>> extractTo(){

        List<Map<String, String>> data;

        try {
            data= Excel.leerDatosDeHojaDeExcel("src/main/resources/Data/Data.xlsx","datos");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return data;
    }
}
