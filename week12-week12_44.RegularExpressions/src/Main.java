import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        System.out.print("Give a string:");
        Scanner reader = new Scanner(System.in);
        String answer = reader.nextLine();
        
        System.out.println(isAWeekDay(answer));
        System.out.println(allVowels(answer));
        System.out.println(clockTime(answer));
    }
    
    public static boolean isAWeekDay (String string){
        return string.matches("mon|tue|wed|thu|fri|sat|sun");
    }
    
    public static boolean allVowels(String string){
        return string.matches("(a|i|e|u|o|ö|ä)+");
    }
    
    public static boolean clockTime(String string){
        if (string.matches("([01][0-9]|2[0-3])(:[0-5][0-9]){2}")){
            return true;
        }
        return false;
    }
}
