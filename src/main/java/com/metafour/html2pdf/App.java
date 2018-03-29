package com.metafour.html2pdf;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.w3c.tidy.Tidy;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.lowagie.text.DocumentException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws DocumentException, IOException {
    	 doConversion();
    }
    
    public static void doConversion() throws DocumentException, IOException {
      OutputStream os = new FileOutputStream("src/label/interlink.pdf");
   	  OutputStream newFile = new FileOutputStream("src/label/interlinkPretty.xhtml");
   	  InputStream is = new FileInputStream("src/label/interlink.html");
   	  ITextRenderer renderer = new ITextRenderer();
   	  Tidy tidy = new Tidy();
   	  tidy.setXHTML(true);
   	  tidy.setTrimEmptyElements(true);
   	  tidy.setDropProprietaryAttributes(true);
   	  tidy.parse(is,newFile);
   	  renderer.setDocument("src/label/interlinkPretty.xhtml");
   	  renderer.layout();
   	  renderer.createPDF(os);
   	  newFile.close();
   	  os.close();
    }
    
}
