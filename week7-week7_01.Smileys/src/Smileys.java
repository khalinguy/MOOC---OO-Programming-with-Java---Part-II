public class Smileys {
 
    public static void main(String[] args) {
        printWithSmileys("Method");
        printWithSmileys("Beerbottle");
        printWithSmileys("Interface");
        // Test your method at least with the following
        // printWithSmileys("Method");
        // printWithSmileys("Beerbottle");
        // printWithSmileys("Interface");
    }
    
    private static void printWithSmileys (String characterString){
        int number;
        if (characterString.length() % 2 == 0){
            number = (characterString.length()+ 2)/2 ;
            firstLastRows(number);
            System.out.print(":) " + characterString + " :)");
            System.out.println("");
            firstLastRows(number);
        } else {
            number = (characterString.length()+ 2)/2 + 1;
            firstLastRows(number);
            System.out.print(":) " + characterString + "  :)");
            System.out.println("");
            firstLastRows(number);
        }
    }
    private static void firstLastRows (int number){
        System.out.print(":)");
        for (int i = 0; i < number ; i++){
            System.out.print(":)");
        }
        System.out.print(":)");
        System.out.println("");
    }
}