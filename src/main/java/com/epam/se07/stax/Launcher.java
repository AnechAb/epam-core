package com.epam.se07.stax;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;

public class Launcher {

    public static void main(String[] args) throws Exception {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader reader = factory.createXMLStreamReader(Launcher.class.getResourceAsStream("students.xml"));
        new StAXStudentElementsParser().process(reader);
    }
}
