package com.demo.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileConvtors {
	public void convertFile(String inputPath,String outputpath,String newdataFormat) {

		File inputfile = new File(inputPath);
		File outputFile = new File(outputpath);

		BufferedReader reader = null;
		FileWriter writer= null;
		try {

		reader = new BufferedReader(new FileReader(inputfile));
		writer = new FileWriter(outputFile);
		String line;

		while((line = reader.readLine()) != null) {
		writer.write(line);
		writer.write(System.lineSeparator());


		}


		} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}finally {

		try {
		writer.flush();
		writer.close();
		reader.close();
		} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}

		}




		}

		public static void main(String[] args) {
		// TODO Auto-generated method stub



		FileConvtors conertor = new FileConvtors();
		conertor.convertFile("D:\\FileConvtors\\dates.txt", "D:\\FileConvtors\\dates.txt", "dd-MM-yyyy");

		}


}
