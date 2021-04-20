package labassignment;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public class midterm {
	public static void main(String[] args) throws ClassNotFoundException, ParserConfigurationException{
	
		/*if(args[0] == "-f") {
			if(args[2] == "-q") {
				String input1 = args[1];
				String input2 = args[3];
				genSnippet a = new genSnippet(input1,input2);
				
				
			}
		}*/
		
		String input = "C:\\Users\\dusk3\\Desktop\\input.txt";
		
		File dir = new File(input);
		//"C:\\Users\\dusk3\\Desktop\\OpenSW_week2\\week2_html"
		dir.toString();
		File files[] = dir.listFiles();
		System.out.println(dir);
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
	
		Document doc = docBuilder.newDocument();
	
	}
}
