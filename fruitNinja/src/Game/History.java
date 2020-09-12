package Game;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import Interfaces.IStrategy;



public class History {
	IStrategy Mode;
	int x ;
	int y ;
	private static History instance;
	public static History getInstance() {
		if (instance==null) {
			instance = new History();
		}
		return instance;
	}
	public void saveArcade(int scoree ) {
	
		 try {

			             DocumentBuilderFactory dbFactory =
				         DocumentBuilderFactory.newInstance();
				         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				         Document doc = dBuilder.newDocument();
				         
				         
				         Element rootElement = doc.createElement("ArcadeMode"); 
				         doc.appendChild(rootElement);
				         
				         Element highscore = doc.createElement("Highscore");
				         rootElement.appendChild(highscore); 
				         highscore.setAttribute("score", Integer.toString(scoree));
				         
				         
				         TransformerFactory transformerFactory = TransformerFactory.newInstance();
				         Transformer transformer = transformerFactory.newTransformer();
				         DOMSource source = new DOMSource(doc);
				         StreamResult result = new StreamResult(new File("save2.xml"));
				         transformer.transform(source, result);
				         
				         // Output to console for testing
				         //StreamResult consoleResult = new StreamResult(System.out);
				         //transformer.transform(source, consoleResult);
				      } catch (Exception e) {
				         e.printStackTrace();
				      }
				         
				         
			 
		 }
	public int loadArcade()
    
    { 
		try {
		 File inputFile = new File("save2.xml");
	     DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	     DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	     Document doc = dBuilder.parse(inputFile);
	     doc.getDocumentElement().normalize();
	     NodeList score = doc.getDocumentElement().getChildNodes();
	     Node highscore =score.item(0); 
	     if (highscore.getNodeType() == Node.ELEMENT_NODE) 
	     {
	          Element scoreElement = (Element) highscore;
	           x =  Integer.parseInt(scoreElement.getAttribute("score"));
	         
		  }
	    
		}
   	 catch (Exception e) {}
		return x ;
		
    }
	
	
	
	public void saveClassic( int scoree ) {
		
		 try {
			             DocumentBuilderFactory dbFactory =
				         DocumentBuilderFactory.newInstance();
				         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				         Document doc = dBuilder.newDocument();
				         
				         
				         Element rootElement = doc.createElement("ClassicMode"); 
				         doc.appendChild(rootElement);
				         
				         Element highscore = doc.createElement("Highscore");
				         rootElement.appendChild(highscore); 
				         highscore.setAttribute("score", Integer.toString(scoree));
				         
				         
				         TransformerFactory transformerFactory = TransformerFactory.newInstance();
				         Transformer transformer = transformerFactory.newTransformer();
				         DOMSource source = new DOMSource(doc);
				         StreamResult result = new StreamResult(new File("save1.xml"));
				         transformer.transform(source, result);
				         
				         // Output to console for testing
				         //StreamResult consoleResult = new StreamResult(System.out);
				         //transformer.transform(source, consoleResult);
				      } catch (Exception e) {
				         e.printStackTrace();
				      }
				         
				         
			 
		 }
	public int loadClassic()
   
   { 
		try {
		 File inputFile = new File("save1.xml");
	     DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	     DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	     Document doc = dBuilder.parse(inputFile);
	     doc.getDocumentElement().normalize();
	     NodeList score = doc.getDocumentElement().getChildNodes();
	     Node highscore =score.item(0); 
	     if (highscore.getNodeType() == Node.ELEMENT_NODE) 
	     {
	          Element scoreElement = (Element) highscore;
	           y =  Integer.parseInt(scoreElement.getAttribute("score"));
	         
		  }
	    
		}
  	 catch (Exception e) {}
		return y ;
		
   }	
		
		
	}
	


