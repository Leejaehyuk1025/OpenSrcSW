package labassignment;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.snu.ids.kkma.index.Keyword;
import org.snu.ids.kkma.index.KeywordExtractor;
import org.snu.ids.kkma.index.KeywordList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class makeKeyword {

	makeKeyword(String input) throws SAXException, IOException, ParserConfigurationException, XPathExpressionException, TransformerFactoryConfigurationError, TransformerException{
		String inputFile = input;
		
		String outputFile = "C:\\Users\\dusk3\\Desktop\\keyword.xml"; 
	
		Document docc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(inputFile));

		// locate the node(s)
		XPath xpath = XPathFactory.newInstance().newXPath();
		NodeList nodes = (NodeList)xpath.evaluate("//*/body", docc, XPathConstants.NODESET);

	
		KeywordExtractor ke = new KeywordExtractor();
	
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
		xformer.transform(new DOMSource(docc), new StreamResult(new File(outputFile)));
		}
	
}

