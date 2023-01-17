package hr.algebra.java2.bingoproject.utils;

import hr.algebra.java2.bingoproject.model.SerializableGame;
import javafx.scene.control.Alert;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

public class XMLUtility {

    public static void saveXML(List<String> listOfButtonText_player, List<String> listOfButtonStyle_player,
                               List<String> listOfButtonText_computer, List<String> listOfButtonStyle_computer,
                               List<Integer> listOfExtractedNumbers){

        try {
            DocumentBuilderFactory documentBuilderFactory
                    = DocumentBuilderFactory.newInstance();

            DocumentBuilder documentBuilder
                    = documentBuilderFactory.newDocumentBuilder();
            Document xmlDocument = documentBuilder.newDocument();


            Element rootElementGame = xmlDocument.createElement("Game");
            xmlDocument.appendChild(rootElementGame);

            Element game_Element = xmlDocument.createElement("ListOfExtractedNumbers");
            Node game_TextNode = xmlDocument.createTextNode(listOfExtractedNumbers.toString());
            game_Element.appendChild(game_TextNode);
            rootElementGame.appendChild(game_Element);


            Element listOfButtonText_Player_Element = xmlDocument.createElement("ListOfButtonText_Player");
            Node listOfButtonText_Player_TextNode = xmlDocument.createTextNode(listOfButtonText_player.toString());
            listOfButtonText_Player_Element.appendChild(listOfButtonText_Player_TextNode);
            rootElementGame.appendChild(listOfButtonText_Player_Element);

            Element listOfButtonStyle_player_Element = xmlDocument.createElement("listOfButtonStyle_Player");
            Node listOfButtonStyle_player_TextNode = xmlDocument.createTextNode(listOfButtonStyle_player.toString());
            listOfButtonStyle_player_Element.appendChild(listOfButtonStyle_player_TextNode);
            rootElementGame.appendChild(listOfButtonStyle_player_Element);


            Element listOfButtonText_computer_Element = xmlDocument.createElement("ListOfButtonText_Computer");
            Node listOfButtonText_computer_TextNode = xmlDocument.createTextNode(listOfButtonText_computer.toString());
            listOfButtonText_computer_Element.appendChild(listOfButtonText_computer_TextNode);
            rootElementGame.appendChild(listOfButtonText_computer_Element);

            Element listOfButtonStyle_computer_Element = xmlDocument.createElement("listOfButtonStyle_Computer");
            Node listOfButtonStyle_computer_TextNode = xmlDocument.createTextNode(listOfButtonStyle_computer.toString());
            listOfButtonStyle_computer_Element.appendChild(listOfButtonStyle_computer_TextNode);
            rootElementGame.appendChild(listOfButtonStyle_computer_Element);



            Transformer transformer = TransformerFactory.newInstance().newTransformer();

            Source xmlSource = new DOMSource(xmlDocument);
            Result xmlResult = new StreamResult(new File("Bingo5X5.xml"));

            transformer.transform(xmlSource, xmlResult);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("XML file created!");
            alert.setHeaderText("XML file was successfully created!");
            alert.setContentText("File 'Bingo5X5.xml' was created!");

            alert.showAndWait();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static SerializableGame loadXML() {

        SerializableGame serializableGame = null;
        try {
            File bingo5X5File = new File("Bingo5X5.xml");
            InputStream bingo5X5Stream = new FileInputStream(bingo5X5File);

            DocumentBuilder parser = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document xmlDocument = parser.parse(bingo5X5Stream);

            String rootNodeName = xmlDocument.getDocumentElement().getNodeName();
            NodeList nodeList = xmlDocument.getElementsByTagName("Game");

            for (int i = 0; i < nodeList.getLength(); i++) {

                Node gameNode = nodeList.item(i);

                if (gameNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element gameElement = (Element) gameNode;

                    String listOfExtractedNumbers = gameElement
                            .getElementsByTagName("ListOfExtractedNumbers")
                            .item(0)
                            .getTextContent();
                    System.out.println("ListOfExtractedNumbers: " + listOfExtractedNumbers);


                    String listOfButtonText_player = gameElement
                            .getElementsByTagName("ListOfButtonText_Player")
                            .item(0)
                            .getTextContent();
                    System.out.println("ListOfButtonText_Player: " + listOfButtonText_player);


                    String listOfButtonStyle_player = gameElement
                            .getElementsByTagName("listOfButtonStyle_Player")
                            .item(0)
                            .getTextContent();
                    System.out.println("ListOfButtonStyle_player: " + listOfButtonStyle_player);


                    String listOfButtonText_computer = gameElement
                            .getElementsByTagName("ListOfButtonText_Computer")
                            .item(0)
                            .getTextContent();
                    System.out.println("ListOfButtonText_Computer: " + listOfButtonText_computer);


                    String listOfButtonStyle_computer = gameElement
                            .getElementsByTagName("listOfButtonStyle_Computer")
                            .item(0)
                            .getTextContent();
                    System.out.println("ListOfButtonStyle_Computer: " + listOfButtonStyle_computer);


                    serializableGame = new SerializableGame(listOfButtonText_player, listOfButtonStyle_player,
                            listOfButtonText_computer, listOfButtonStyle_computer, listOfExtractedNumbers);
                }
            }


        } catch (Exception e) {
            System.out.println("An error occurred while reading from the file!");
        }

        return serializableGame;
    }
}
