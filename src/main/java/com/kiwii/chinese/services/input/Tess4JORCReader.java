package com.kiwii.chinese.services.input;

import java.awt.image.BufferedImage;
import java.io.File;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class Tess4JORCReader implements ORCReader {

	
	@Override
	public String read(BufferedImage source) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String read(File source){
		Tesseract reader = Tesseract.getInstance();	
		String text = null;
		try{
			text = reader.doOCR(source);
		}catch(TesseractException e){
			
		}
		return text; 
	}
	
	public static void main(String[] args){
		System.out.println(new Tess4JORCReader().read(new File("/home/yi/Downloads/Tess4J/eurotext.gif")));
	}

}
