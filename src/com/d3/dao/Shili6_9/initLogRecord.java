package com.d3.dao.Shili6_9;

import org.apache.log4j.PropertyConfigurator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class initLogRecord {
    public static void initLog() throws IOException {
        FileInputStream fileInputStream=null;
        try {
            Properties properties=new Properties();
            fileInputStream=new FileInputStream("src/log4j.properties");
            properties.load(fileInputStream);
            PropertyConfigurator.configure(properties);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(fileInputStream!=null){
                try {
                    fileInputStream.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
