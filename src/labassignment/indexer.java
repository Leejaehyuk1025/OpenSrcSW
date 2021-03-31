package labassignment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import javax.xml.parsers.*;
import org.w3c.dom.*;

import org.snu.ids.kkma.index.KeywordExtractor;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class indexer {
	
	indexer(String input) throws ParserConfigurationException, SAXException, IOException{
		
		String inputFile = input;
    	//"C:\\Users\\dusk3\\Desktop\\keyword.xml"
		String output = "C:\\Users\\dusk3\\Desktop\\index.post";
		
    	File xmlFile = new File(inputFile);

    	DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
    	DocumentBuilder builder = builderFactory.newDocumentBuilder();
    	Document document = builder.parse(xmlFile);
    	Element root = document.getDocumentElement();
    	//System.out.println(root.getTagName()); ->docs
    	    	
    	ArrayList<String> name0 = new ArrayList<String>();
    	ArrayList<String> number0 = new ArrayList<String>();
    	ArrayList<String> name1 = new ArrayList<String>();
    	ArrayList<String> number1 = new ArrayList<String>();
    	ArrayList<String> name2 = new ArrayList<String>();
    	ArrayList<String> number2 = new ArrayList<String>();
    	ArrayList<String> name3 = new ArrayList<String>();
    	ArrayList<String> number3 = new ArrayList<String>();
    	ArrayList<String> name4 = new ArrayList<String>();
    	ArrayList<String> number4 = new ArrayList<String>();
    	
    	ArrayList<String> totalname = new ArrayList<String>();
    	
    	
    	NodeList n1 = root.getElementsByTagName("doc");
    	
    	Node docNode0 = n1.item(0);
    	Node docNode1 = n1.item(1);
    	Node docNode2 = n1.item(2);
    	Node docNode3 = n1.item(3);
    	Node docNode4 = n1.item(4);
    	
    	Element docElement0 = (Element)docNode0;
    	Element docElement1 = (Element)docNode1;
    	Element docElement2 = (Element)docNode2;
    	Element docElement3 = (Element)docNode3;
    	Element docElement4 = (Element)docNode4;
    	
    	//System.out.println(docElement.getTextContent());
    
    	NodeList nodelist0 = docElement0.getElementsByTagName("body");
    	NodeList nodelist1 = docElement1.getElementsByTagName("body");
    	NodeList nodelist2 = docElement2.getElementsByTagName("body");
    	NodeList nodelist3 = docElement3.getElementsByTagName("body");
    	NodeList nodelist4 = docElement4.getElementsByTagName("body");
    	
    	Node bodyNode0 = nodelist0.item(0);
    	Node bodyNode1 = nodelist1.item(0);
    	Node bodyNode2 = nodelist2.item(0);
    	Node bodyNode3 = nodelist3.item(0);
    	Node bodyNode4 = nodelist4.item(0);
    	
    	Element bodyElement0 = (Element)bodyNode0;
    	Element bodyElement1 = (Element)bodyNode1;
    	Element bodyElement2 = (Element)bodyNode2;
    	Element bodyElement3 = (Element)bodyNode3;
    	Element bodyElement4 = (Element)bodyNode4;
    	//System.out.println(bodyElement.getTextContent()); ->body내용 나옴
    	
    	String a = bodyElement0.getTextContent(); //body내용을 String타입 변수에 저장
    	String[] splitA = a.split("#");           // #을 기준으로 문자열 자른다. -> 떡:16, 밀:3, ...이렇게 배열에 저장 
    	for(String b : splitA) {          
        	String[] splitB = b.split(":");       // :을 기준으로 문자열 자른다 -> 첫번째요소에는 떡, 두번째요소에는 16 ...
        	name0.add(splitB[0]);       
        	totalname.add(splitB[0]);             // 통합네임에 저장. 중복제거한 총 이름들이 저장되는곳
        	number0.add(splitB[1]);
        }
    	
    	a = bodyElement1.getTextContent();
    	splitA = a.split("#");
    	for(String b : splitA) {
        	String[] splitB = b.split(":");
        	name1.add(splitB[0]);
        	totalname.add(splitB[0]);
        	number1.add(splitB[1]);
        }
    	
    	a = bodyElement2.getTextContent();
    	splitA = a.split("#");
    	for(String b : splitA) {
        	String[] splitB = b.split(":");
        	name2.add(splitB[0]);
        	totalname.add(splitB[0]);
        	number2.add(splitB[1]);
        }
    	
    	a = bodyElement3.getTextContent();
    	splitA = a.split("#");
    	for(String b : splitA) {
        	String[] splitB = b.split(":");
        	name3.add(splitB[0]);
        	totalname.add(splitB[0]);
        	number3.add(splitB[1]);
        }
    	
    	a = bodyElement4.getTextContent();
    	splitA = a.split("#");
    	for(String b : splitA) {
        	String[] splitB = b.split(":");
        	name4.add(splitB[0]);
        	totalname.add(splitB[0]);
        	number4.add(splitB[1]);
        }
    	
    	
    	HashMap<String, ArrayList<Double>> hashmap = new HashMap<String, ArrayList<Double>>();
    	
    	for(String k : totalname) {
    		int count =0;
    		ArrayList<Double> temp = new ArrayList<Double>();
    		
    		if(name0.contains(k)) count++;
    		if(name1.contains(k)) count++;
    		if(name2.contains(k)) count++;
    		if(name3.contains(k)) count++;
    		if(name4.contains(k)) count++;
    		
    		if(name0.contains(k)) {
    			int tempnum = name0.indexOf(k);
    			int findit = Integer.valueOf(number0.get(tempnum));
    			temp.add(0.0);
    			double cutting = findit*(Math.log(5)-Math.log(count));
    			temp.add((double)Math.round(cutting*100)/100);
    		}
    		if(name1.contains(k)) {
    			int tempnum = name1.indexOf(k);
    			int findit = Integer.valueOf(number1.get(tempnum));
    			temp.add(1.0);
    			double cutting = findit*(Math.log(5)-Math.log(count));
    			temp.add((double)Math.round(cutting*100)/100);
    		}
    		if(name2.contains(k)) {
    			int tempnum = name2.indexOf(k);
    			int findit = Integer.valueOf(number2.get(tempnum));
    			temp.add(2.0);
    			double cutting = findit*(Math.log(5)-Math.log(count));
    			temp.add((double)Math.round(cutting*100)/100);
    		}
    		if(name3.contains(k)) {
    			int tempnum = name3.indexOf(k);
    			int findit = Integer.valueOf(number3.get(tempnum));
    			temp.add(3.0);
    			double cutting = findit*(Math.log(5)-Math.log(count));
    			temp.add((double)Math.round(cutting*100)/100);
    		}
    		if(name4.contains(k)) {
    			int tempnum = name4.indexOf(k);
    			int findit = Integer.valueOf(number4.get(tempnum));
    			temp.add(4.0);
    			double cutting = findit*(Math.log(5)-Math.log(count));
    			temp.add((double)Math.round(cutting*100)/100);
    		}
    		
    		hashmap.put(k, temp);
    		
    	}
    	
    	
    	/*for(String ajaj:hashmap.keySet()) {
    		ArrayList<Double> ar = hashmap.get(ajaj);
    		System.out.println("[Key]:"+ajaj+"[Value]:"+ar);
    	}*/ 
    	//출력잘되나 확인.
    	
    	
    	
    	FileOutputStream fileStream = new FileOutputStream(output);
    	
    	ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileStream); 
    		
    	objectOutputStream.writeObject(hashmap);
    	
    	objectOutputStream.close();
    
		
		
	}
	
	
	
}
