/*
// refactor the class to adhere to the SRP principle

import java.io.*;
import java.util.*;

class Element {
    Integer field1;
    Double field2;
    String field3;

    public Element(Integer field1, Double field2, String field3) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
    }
}

public class SRP {
    // it will act as a repository for the elements

    List<Element> elements;

    public SRP() {
        this.elements = new ArrayList<Element>();
    }

    public void addElement(Element element) {
        this.elements.add(element);
    }

    public Element createElement(Integer field1, Double field2, String field3) {
        return new Element(field1, field2, field3);
    }

    public void updateElement(Integer field, Element element) {
        for (int i = 0; i < this.elements.size(); i++)
            if (Objects.equals(this.elements.get(i).field1, field)) {
                this.elements.set(i, element);
                return;
            }
    }

    public void removeElement(Integer field) {
        for (int i = 0; i < this.elements.size(); i++)
            if (this.elements.get(i).field1.equals(field)) {
                this.elements.remove(i);
                return;
            }
    }

    public Element readElement(Integer field) {
        for (int i = 0; i < this.elements.size(); i++)
            if (this.elements.get(i).field1.equals(field)) {
                return this.elements.get(i);
            }
        return null;
    }

    public void printElement(Element element) {
        System.out.println("Element(" + element.field1 + ", " + element.field2 + ", " + element.field3 + ")");
    }

    public void printElements() {
        for(int i = 0; i < this.elements.size(); i++)
            this.printElement(this.elements.get(i));
    }

    public void saveToFile(String filepath) throws IOException {
        File fileOut = new File(filepath);
        fileOut.createNewFile();
        FileOutputStream fos = new FileOutputStream(fileOut);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        DataOutputStream dos = new DataOutputStream(bos);

        for (int i = 0; i<this.elements.size(); i++) {
            Element el = this.elements.get(i);
            dos.writeUTF(el.field1 + "," + el.field2 + "," + el.field3 + "\n");
        }

        dos.close();
        bos.close();
        fos.close();
    }

    public void loadFromFile (String filepath) throws IOException {
        String load;
        File fileIn = new File(filepath);
        FileInputStream fis = new FileInputStream(fileIn);
        DataInputStream dis = new DataInputStream(fis);

        load = dis.readUTF();

        // .. process loading

    }

    public Integer getMatchesField1(Integer field1) {
        Integer res = 0;
        for (Element e: this.elements)
            if(e.field1.equals(field1))
                res++;
        return res;
    }

    public Integer getMatchesField2(Double field2) {
        Integer res = 0;
        for (Element e: this.elements)
            if(e.field2.equals(field2))
                res++;
        return res;
    }

    public Integer getMatchesField3(String field3) {
        Integer res = 0;
        for (Element e: this.elements)
            if(e.field3.equals(field3))
                res++;
        return res;
    }

    public Integer getSize() {
        return this.elements.size();
    }

    public List<Element> getElements() {
        ArrayList<Element> copy = new ArrayList<Element>(this.elements.size());
        Collections.copy(copy, this.elements);
        return copy;
    }

    public Integer sumField1() {
        Integer res = 0;
        for(Element e: this.elements)
            res += e.field1;
        return res;
    }

    public Double sumField2() {
        Double res = 0d;
        for(Element e:this.elements)
            res += e.field2;
        return res;
    }
}
*/

// keep only necessary methods that adhere to the functionality of a repository
// a repository only implements CRUD operations, and save/load to/from object if it enables this
// so we keep only the constructor, addElement, updateElement, readElement, deleteElement, getSize, getElements, saveToFile and loadFromFile


// the rest are non-specific and require separate classes, such as Stats from the sumField* and getMatches* functions
// and printer for print* function

import java.io.*;
import java.util.*;

class Element {
    Integer integerField;
    Double doubleField;
    String stringField;

    public Element(Integer integerField, Double doubleField, String stringField) {
        this.integerField = integerField;
        this.doubleField = doubleField;
        this.stringField = stringField;
    }
}

class ElementStatistics {

    public Integer getMatchesField1(Integer integerField, List<Element> elements) {
        Integer result = 0;

        for (Element element : elements) {
            if (element.integerField.equals(integerField)) {
                result++;
            }
        }

        return result;
    }

    public Integer getMatchesField2(Double doubleField, List<Element> elements) {
        Integer result = 0;

        for (Element element : elements) {
            if (element.doubleField.equals(doubleField)) {
                result++;
            }
        }

        return result;
    }

    public Integer getMatchesField3(String stringField, List<Element> elements) {
        Integer result = 0;

        for (Element element : elements) {
            if (element.stringField.equals(stringField)) {
                result++;
            }
        }

        return result;
    }

    public Integer sumField1(List<Element> elements) {
        Integer result = 0;

        for(Element element : elements) {
            result += element.integerField;
        }

        return result;
    }

    public Double sumField2(List<Element> elements) {
        Double result = 0d;

        for(Element element : elements) {
            result += element.doubleField;
        }

        return result;
    }
}

class Printer {

    public void printElement(Element element) {
        System.out.println("Element(" + element.integerField + ", " + element.doubleField + ", " + element.stringField + ")");
    }

    public void printElements(List<Element> elements) {
        for (Element element : elements) {
            this.printElement(element);
        }
    }
}

class SRP {
    List<Element> elements;

    public SRP() {
        this.elements = new ArrayList<Element>();
    }

    public void addElement(Element element) {
        this.elements.add(element);
    }

    public void updateElement(Integer integerField, Element element) {
        for (Integer i = 0; i < this.elements.size(); i++) {
            if (this.elements.get(i).integerField.equals(integerField)) {
                this.elements.set(i, element);
                return;
            }
        }
    }

    public void removeElement(Integer integerField) {
        for (Integer i = 0; i < this.elements.size(); i++) {
            if (this.elements.get(i).integerField.equals(integerField)) {
                this.elements.remove(i);
                return;
            }
        }
    }

    public Element readElement(Integer integerField) {
        for (Integer i = 0; i < this.elements.size(); i++) {
            if (this.elements.get(i).integerField.equals(integerField)) {
                return this.elements.get(i);
            }
        }
        return null;
    }

    public void saveToFile(String filepath) throws IOException {
        File fileOut = new File(filepath);
        fileOut.createNewFile();
        FileOutputStream fos = new FileOutputStream(fileOut);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        DataOutputStream dos = new DataOutputStream(bos);

        for (Integer i = 0; i < this.elements.size(); i++) {
            Element el = this.elements.get(i);
            dos.writeUTF(el.integerField + "," + el.doubleField + "," + el.stringField + "\n");
        }

        dos.close();
        bos.close();
        fos.close();
    }

    public void loadFromFile(String filepath) throws IOException {
        String load;
        File fileIn = new File(filepath);
        FileInputStream fis = new FileInputStream(fileIn);
        DataInputStream dis = new DataInputStream(fis);

        load = dis.readUTF();

        // .. process loading

    }

    public Integer getSize() {
        return this.elements.size();
    }

    public List<Element> getElements() {
        ArrayList<Element> copy = new ArrayList<Element>(this.elements.size());
        Collections.copy(copy, this.elements);
        return copy;
    }
}