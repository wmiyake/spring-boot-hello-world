package com.techtejendra.property;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class GetTimestamp {
	
	private static String timestamp_file;
	
	static {
		System.out.println("--------------OBTENDO timestamp_file");
		try {
			InputStream f1 = GetTimestamp.class.getClassLoader().getResourceAsStream("application.properties");
	        Properties prop = new Properties();
	        prop.load(f1);
	        timestamp_file = prop.getProperty("timestamp_file");
	        System.out.println("---------------- timestamp_file = "+timestamp_file);
		} catch (IOException ex) {
            ex.printStackTrace();
        }
	}
	
	public String read() {
		String timestamp;
		try {

			InputStream input = new FileInputStream(timestamp_file);
            Properties prop = new Properties();

            prop.load(input);

            timestamp = prop.getProperty("timestamp");

        } catch (IOException ex) {
        	System.out.println("Problema na leitura do arquivo --> "+timestamp_file);
        	timestamp = "NONE";
        }
				
		return timestamp;
	}
	
	public void write(String timestamp) {
		try {
			
			OutputStream output = new FileOutputStream(timestamp_file);
            Properties prop = new Properties();

            prop.setProperty("timestamp", timestamp);

            prop.store(output, null);

            System.out.println("Mais Recente timestamp  "+timestamp+" definir como arquivo");

        } catch (IOException io) {
        	System.out.println("Problema ao gravar arquivo --> "+timestamp_file);
        }
	}

    public static void main(String[] args) {
    	GetTimestamp app2= new GetTimestamp();
    }

}
