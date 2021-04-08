package labassignment;

import java.lang.Object;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.snu.ids.kkma.index.Keyword;
import org.snu.ids.kkma.index.KeywordExtractor;
import org.snu.ids.kkma.index.KeywordList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.InputSource;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;


 
public class kuir {
    public static void main(String[] args) throws IOException, TransformerException, ParserConfigurationException, SAXException, XPathExpressionException, ClassNotFoundException{
    	
    	    	
    	
    	if(args[0].equals("-c")) {
    		makeCollection a = new makeCollection(args[1]);
    	}
    	else if(args[0].equals("-k")) {
    		makeKeyword b = new makeKeyword(args[1]);
    	}
    	else if(args[0].equals("-i")) {
    		indexer c = new indexer(args[1]);
    	}
    	else if(args[0].equals("-s")) {
    		if(args[2].equals("-q")) {
    			searcher s = new searcher(args[1], args[3]);
    		}
    	}
    	else {
    		System.out.println("올바르지 않은 명령");
    	}
    	
		
    }
}

