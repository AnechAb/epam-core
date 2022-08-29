package com.epam.se07.stax;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class StAXStudentElementsParser {

    public void process(XMLStreamReader reader) throws XMLStreamException {

        while (reader.hasNext()) {
            switch (reader.next()) {
                case XMLStreamConstants.START_ELEMENT:
                    StudentElements element = StudentElements.valueOf(reader.getLocalName().toUpperCase());
                    writeStudentFeature(element);
                    studentInfoHandle(element, reader);
                    break;

                case XMLStreamConstants.CHARACTERS:
                    writeText(reader.getText());
                    break;
            }
        }
    }

    private void studentInfoHandle(StudentElements enumName, XMLStreamReader reader) {
        switch (enumName) {
            case STUDENTS:
                this.writeTitle();
                break;
            case STUDENT: {
                String login = reader.getAttributeValue(null, StudentElements.LOGIN
                        .name().toLowerCase());
                String faculty = reader.getAttributeValue(null,
                        StudentElements.FACULTY.name().toLowerCase());
                writeStudent(login, faculty);
            }
            break;
            case ADDRESS:
                writeAddress();
                break;
        }
    }

    public void writeTitle() {
        System.out.println("StudentElements:");
    }

    public void writeStudent(String... args) {
        System.out.println("Student: Login: " + args[0] + " Faculty: " + args[1]);
    }

    public void writeAddress() {
        System.out.println(" Address: ");
    }

    public void writeStudentFeature(StudentElements element) {
        switch (element) {
            case STREET:
                System.out.print(" Street: ");
                break;
            case CITY:
                System.out.print(" City: ");
                break;
            case COUNTRY:
                System.out.print("Country: ");
                break;
            case TELEPHONE:
                System.out.print(" Telephone: ");
                break;
            case NAME:
                System.out.print("Name: ");
                break;
        }
    }

    public void writeText(String text) {
        System.out.println(text.trim());
    }
}