package labassignment;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class genSnippet{
	
	genSnippet(String inputPost, String inputQuery) throws ClassNotFoundException, IOException, ParserConfigurationException, SAXException {
		
		String input = "C:\\Users\\dusk3\\Desktop\\input.txt";
		
		File dir = new File(input);
		//"C:\\Users\\dusk3\\Desktop\\OpenSW_week2\\week2_html"
		File files[] = dir.listFiles();
		
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
	
		Document doc = docBuilder.newDocument();
		
		System.out.println(doc);
		
	}
	
	
}