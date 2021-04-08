package labassignment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.snu.ids.kkma.index.Keyword;
import org.snu.ids.kkma.index.KeywordExtractor;
import org.snu.ids.kkma.index.KeywordList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class searcher {
	
	searcher(String inputPost, String inputQuery) throws ClassNotFoundException, IOException, ParserConfigurationException, SAXException {
		
		CalcSim(inputPost,inputQuery);
		System.out.println("0");
		
	}
	
		
	public void CalcSim(String Post, String Query) throws IOException, ClassNotFoundException, ParserConfigurationException, SAXException{
		String query = Query;
		
		KeywordExtractor ke1 = new KeywordExtractor();
		
		KeywordList kl1 = ke1.extractKeyword(query, true);
		
		/*for(int i=0;i<kl1.size();i++) {
			Keyword kwrd = kl1.get(i);
			System.out.println(kwrd.getString() + "\t" + kwrd.getCnt());
			// 꼬꼬마   1   테스트   2 .....
		}*/  
		
		//라면  1    면   1  분말   1  스프  1
		
		ArrayList<String> queryWord = new ArrayList<String>();
		ArrayList<Integer> queryCount = new ArrayList<Integer>();
		
		
		
		for(int i=0;i<kl1.size();i++) {
			Keyword kwrd = kl1.get(i);
			queryWord.add(kwrd.getString());
			queryCount.add(kwrd.getCnt());
		}
		//입력받은 query를 단어와 횟수 나눠서 각각의 arrayList에 저장
		
		//System.out.println(queryWord); 라면 면 분말 스프
		//System.out.println(queryCount); 1 1 1 1 
		
		
		String inputFile = Post; 
				//"C:\\Users\\dusk3\\Desktop\\index.post";
		
		FileInputStream fileStream = new FileInputStream(inputFile);
		ObjectInputStream objectInputStream = new ObjectInputStream(fileStream);
		
		Object object = objectInputStream.readObject();
		objectInputStream.close();
		
		HashMap hashMap = (HashMap) object;
		Iterator<String> it = hashMap.keySet().iterator();
		
		
		double[] totalImportant = new double[5];
		
		for(String a : queryWord) {
			if(hashMap.containsKey(a)) {
				ArrayList<Double> arraylist = (ArrayList<Double>) hashMap.get(a);
				Iterator<Double> ait2 = arraylist.iterator();
				
				int numm = queryCount.get(queryWord.indexOf(a));
				
				ArrayList<Double> docNum = new ArrayList<Double>();
	    		ArrayList<Double> docCount = new ArrayList<Double>();
		    	while(ait2.hasNext()) {
		    		docNum.add(ait2.next());
		    		docCount.add(ait2.next());
		    	}
		    	
		    	if(docNum.contains(0.0)) {
		    		Double temp = docCount.get(docNum.indexOf(0.0));
		    		totalImportant[0]+= numm*temp;
		    	}
		    	if(docNum.contains(1.0)) {
		    		Double temp = docCount.get(docNum.indexOf(1.0));
		    		totalImportant[1]+=numm*temp;
		    	}
		    	if(docNum.contains(2.0)) {
		    		Double temp = docCount.get(docNum.indexOf(2.0));
		    		totalImportant[2]+=numm*temp;
		    	}
		    	if(docNum.contains(3.0)) {
		    		Double temp = docCount.get(docNum.indexOf(3.0));
		    		totalImportant[3]+=numm*temp;
		    	}
		    	if(docNum.contains(4.0)) {
		    		Double temp = docCount.get(docNum.indexOf(4.0));
		    		totalImportant[4]+=numm*temp;
		    	}
		    	
		    	
		    	
			}
		}
		
		//System.out.println(totalImportant[0]);
		//System.out.println(totalImportant[1]);
		//System.out.println(totalImportant[2]);
		//System.out.println(totalImportant[3]);
		//System.out.println(totalImportant[4]);
		
		////////////////////////////////////////////////
		
		String collection = "C:\\Users\\dusk3\\Desktop\\collection.xml";
		
		File xmlFile = new File(collection);

		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		Document document = builder.parse(xmlFile);
		Element root = document.getDocumentElement();
		
		NodeList n1 = root.getElementsByTagName("doc");
		//System.out.println(root.getTagName()); ->docs
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
		
		NodeList nodelist0 = docElement0.getElementsByTagName("title");
		NodeList nodelist1 = docElement1.getElementsByTagName("title");
		NodeList nodelist2 = docElement2.getElementsByTagName("title");
		NodeList nodelist3 = docElement3.getElementsByTagName("title");
		NodeList nodelist4 = docElement4.getElementsByTagName("title");
		
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
		//System.out.println(bodyElement.getTextContent()); ->title내용 나옴
		
		//System.out.println(bodyElement0.getTextContent());
		//System.out.println(bodyElement1.getTextContent());
		//System.out.println(bodyElement2.getTextContent());
		//System.out.println(bodyElement3.getTextContent());
		//System.out.println(bodyElement4.getTextContent());
		
		
		double[] compareArray = new double[5];
		int[] confirm = new int[5];
		
		for(int j=0;j<5;j++) {
			compareArray[j] = totalImportant[j];
		}
		
		Arrays.sort(compareArray);
		
		int rank=1;
		
		for(int k=4;k>1;k--) {
					
			if(compareArray[k] == totalImportant[0]) {
				if(confirm[0]==0) {
					confirm[0]=1;
					System.out.println(rank + "순위 : " + bodyElement0.getTextContent());
					rank++;
					continue;
				}
				else {}
			}
			if(compareArray[k] == totalImportant[1]) {
				if(confirm[1]==0) {
					confirm[1]=1;
					System.out.println(rank + "순위 : " + bodyElement1.getTextContent());
					rank++;
					continue;
				}
				else {}
			}
			if(compareArray[k] == totalImportant[2]) {
				if(confirm[2]==0) {
					confirm[2]=1;
					System.out.println(rank + "순위 : " + bodyElement2.getTextContent());
					rank++;
					continue;   				
				}
				else {}
			}
			if(compareArray[k] == totalImportant[3]) {
				if(confirm[3]==0) {
					confirm[3]=1;
					System.out.println(rank + "순위 : " + bodyElement3.getTextContent());
					rank++;
					continue;   				
				}
				else {}
			}
			if(compareArray[k] == totalImportant[4]) {
				if(confirm[4]==0) {
					confirm[4]=1;
					System.out.println(rank + "순위 : " + bodyElement4.getTextContent());
					rank++;
					continue;   				
				}
				else {}
			}
		}
	}
	
	
	
	
}
