import java.util.*;

class Main {
  static String AlphabetizeInput(String input) {
    ArrayList <Character> list = new ArrayList<Character>();
    char[] letters = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    for (int i = 0; i < input.length(); i++) {
      char character = input.charAt(i);
      int properCharacter = Arrays.binarySearch(letters, character);
      if (properCharacter > 0) {
        list.add(character);
      }
    }
    Collections.sort(list);
    String sortedString= new String();
    for(char l:list){
      sortedString +=l;
    }
    return sortedString;
  }
  
  static Boolean CheckForMatch(String inputA, String inputB) {
    return inputA.equals(inputB);
  }
  
  static String Rerun() {
    Scanner input = new Scanner(System.in);
    String rerunValue ="";
    while (!rerunValue.equals("Y") && !rerunValue.equals("N")) {
      System.out.println("\nWould you like to test a new set? (Y/N)");
      rerunValue = input.nextLine().toUpperCase();
      if (rerunValue.equals("Y")) {
        System.out.println("Wonderful! I will restart the program for you./n");
      } else if (rerunValue.equals("N")) {
        System.out.println("Thank you for using this program. Goodbye!");
      } else {
        System.out.println("I'm sorry, I need a Y or N response.");
      }
    }
    return rerunValue;
  }
  
  public static void main(String[] args) {
    System.out.println("This program was coded with Java by Lilly Gullett for the Introduction to Java Programming course by Sophia.\nThis program takes 2 English words or phrases and determines if one is an anagram for the other.\nI hope you enjoy!");
    Scanner input = new Scanner(System.in);
    String rerunValue = "";
    while (!rerunValue.equals("N")) {
      System.out.println("\nPlease enter your first word or phrase.\nHit enter when you are done");
      String inputA = input.nextLine();
      System.out.println("\nPlease enter your second word or phrase.\nHit enter when you are done");
      String inputB = input.nextLine();
      String alphabeticalInputA = AlphabetizeInput(inputB.toLowerCase());
      String alphabeticalInputB = AlphabetizeInput(inputA.toLowerCase());
      System.out.println();
      if (alphabeticalInputA.equals("") || alphabeticalInputB.equals("")) {
        System.out.println("At least one of your phrases contianed no alphabetical characters.\nThis tool is only able to check for anagrams using characters from the English alphabet.");
      } else {
        Boolean match =CheckForMatch(alphabeticalInputA, alphabeticalInputB);
        if (match == true) {
          System.out.println("\'"+ inputA +"\' is an anagram for \'"+ inputB +"\'.");
        } else {
          System.out.println("\'"+ inputA +"\' is not an anagram for \'"+ inputB +"\'.");
        }
      }
      rerunValue = Rerun();
    }
  }
}