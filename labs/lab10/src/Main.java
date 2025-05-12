import Flyweight.TextEditor;

public class Main {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        editor.add('h', "Times New Roman", 12, false, false, false);
        editor.add('e', "Times New Roman", 12, false, false, false);
        editor.add('y', "Times New Roman", 12, false, false, false);
        editor.add('!', "Arial", 16, true, false, false);

        Boolean result = System.identityHashCode(editor.getCharacter(0).returnFormat()) == System.identityHashCode(editor.getCharacter(1).returnFormat());
        // as close to address-of operator as possible - to demonstrate that the formats are indeed shared
        System.out.println("Do formats for the first characters match? - " + result);
        editor.display();
    }
}
