package com.demo.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileConverter {
	public void convertFile(String inputPath, String outputPath, String newDateFormat) {
		File inputFile=new File(inputPath);
		File outputFile=new File(outputPath);
		
		BufferedReader reader;
		
		FileWriter writer =null;
		BufferedReader reader1=null;
		SimpleDateFormat sdfOld= new SimpleDateFormat("MMM dd,yyyy");
		SimpleDateFormat sdfNew=new SimpleDateFormat(newDateFormat);
		try {
			reader1=new BufferedReader(new FileReader(inputFile));
			
			writer=new FileWriter(outputFile);
			String line;
			while((line=reader1.readLine())!=null) {
				
				Date date=sdfOld.parse(line);
				String newFormatDate= sdfNew.format(date);
				//System.out.println(date);
				//process the data
				writer.write(newFormatDate);
				writer.write(System.lineSeparator());
			}
			
		}catch(FileNotFoundException e) {
			//e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
			
			} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			finally {
				try {
			
				writer.flush();
				writer.close();
				reader1.close();
				}
			
			catch(IOException e) {
			   e.printStackTrace();
			}
				
				}
			}
		




	

	public static void main(String[] args) {
		FileConverter converter=new FileConverter();
		converter.convertFile("D:\\FileConverter\\dates.txt","D:\\FileConverter\\dates_new.txt", "dd-mm-yyyy");
		

	}

}
