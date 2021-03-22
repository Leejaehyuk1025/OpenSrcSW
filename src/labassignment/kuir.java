package labassignment;

import java.lang.Object;
import java.io.IOException;
import java.io.InputStream;

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
    public static void main(String[] args) throws IOException, TransformerException, ParserConfigurationException, SAXException, XPathExpressionException{
    	
    	makeCollection a = new makeCollection();
    	makeKeyword b = new makeKeyword();
    	
    	/*File dir = new File("C:\\Users\\dusk3\\Desktop\\OpenSW_week2\\week2_html");
    	File files[] = dir.listFiles();
    	
    	DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
    	DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
    	
    	Document doc = docBuilder.newDocument();
    	
    	//docs element
    	Element docs = doc.createElement("docs");
    	doc.appendChild(docs);
    	
    	int number = 0;
    	
    	for(int i=0;i<files.length;i++) {
    		
        	//code element
        	Element code = doc.createElement("doc");
    		docs.appendChild(code);
    	
    		//attribute type = id
    		code.setAttribute("id", String.valueOf(number));
    		
    		org.jsoup.nodes.Document doc1 = Jsoup.parse(files[number], "UTF-8");
    		org.jsoup.nodes.Element content = doc1.getElementById("content");
    		org.jsoup.nodes.Document doc2 = Jsoup.parse(files[number], "UTF-8");
    		Elements content1 = doc2.getElementsByTag("title");
    		
    		//title element
    		Element title = doc.createElement("title");
    		title.appendChild(doc.createTextNode(content1.text()));
    		code.appendChild(title);
    	
    	
    		//body element
    		Element body = doc.createElement("body");
    		body.appendChild(doc.createTextNode(content.text()));
    		code.appendChild(body);
    	
    	
    		number++;
    	}
    	
    	
    	TransformerFactory transformerFactory = TransformerFactory.newInstance();
    	
    	Transformer transformer = transformerFactory.newTransformer();
    	transformer.setOutputProperty(OutputKeys.ENCODING,"UTF-8");

        DOMSource source = new DOMSource(doc);
    	StreamResult result = new StreamResult(new FileOutputStream(new File("C:\\Users\\dusk3\\collection.xml")));
    	
    	transformer.transform(source, result);
    	
    	///////////////////////////////////////////////////////////////////////////////////////////////////////
    	
    	String inputFile = "C:\\Users\\dusk3\\collection.xml";
    	String outputFile = "C:\\Users\\dusk3\\keyword.xml"; 
    	
    	Document docc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(inputFile));

    	// locate the node(s)
    	XPath xpath = XPathFactory.newInstance().newXPath(); */
    	// NodeList nodes = (NodeList)xpath.evaluate("//*/body", docc, XPathConstants.NODESET);
/////////////////////
    	
    	/*KeywordExtractor ke = new KeywordExtractor();
    	
    	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = factory.newDocumentBuilder();
		Document document = documentBuilder.parse(inputFile);
		
		Element root = document.getDocumentElement();
		NodeList childeren = root.getChildNodes();
		
		for(int i = 0; i < childeren.getLength(); i++){
			Node node1 = childeren.item(i);
			Element ele = (Element) node1;
			NodeList childeren2 = ele.getChildNodes();
			Element elele = (Element) childeren2.item(1);
			
			KeywordList kl = ke.extractKeyword(elele.getTextContent() , true);
	    	
			String a = "";
			
	    	for(int j=0 ; j<kl.size() ; j++) {
	    		Keyword kwrd = kl.get(j);
	    		a += kwrd.getString() + ":" + kwrd.getCnt() + "#";
	    	}
	    	
	    	nodes.item(i).setTextContent(a);
			
		}
		
		// save the result
    	Transformer xformer = TransformerFactory.newInstance().newTransformer();
    	xformer.transform(new DOMSource(docc), new StreamResult(new File(outputFile)));*/
		
    }
}

