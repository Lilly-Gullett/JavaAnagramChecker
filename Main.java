import java.util.*;

class Main {
  //reorganizes the input string to use the same letters in alphabetical order
  static String AlphabetizeInput(String input) {
    //creates an ArrayList
    //ArrayList was chosen for looseness of length due to a changing length when spaces and punctuation is removed
    ArrayList <Character> list = new ArrayList<Character>();
    //list of letters used to check each letter input and remove anything not in the English alphabet
    char[] letters = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    //loops through the input string
    //moves all English alphabetical characters to the ArrayList for sorting
    for (int i = 0; i < input.length(); i++) {
      char character = input.charAt(i);
      //checks if the character is in the English alphabet list of letters above
      int properCharacter = Arrays.binarySearch(letters, character);
      //if statement ensures characters are only added to the ArrayList if they are in the alphabet
      //this dismisses numbers, punctuation, spaces, and non-english characters,
      if (properCharacter > 0) {
        list.add(character);
      }
    }
    //sorts the ArrayList into alphabetical order
    Collections.sort(list);
    //creates a string to return
    String sortedString= new String();
    //sets the now alphabetized list of input letters back into a string format
    for(char l:list){
      sortedString +=l;
    }
    return sortedString;
  }
  
  static Boolean CheckForMatch(String inputA, String inputB) {
    //checks if the input strings are the same and returns true or false accordingly
    return inputA.equals(inputB);
  }

  //takes user input and sets rerunValue variable according to user wants to run the program again or not
  static String Rerun() {
    //initializes user input
    Scanner input = new Scanner(System.in);
    //initializes rerunValue variable
    String rerunValue ="";
    //loops as long as the rerunValue is neither "Y" nor "N"
    //once the rerunValue is "Y" or "N", the question is answered and this loop breaks
    while (!rerunValue.equals("Y") && !rerunValue.equals("N")) {
      //prints question to user
      System.out.println("\nWould you like to test a new set? (Y/N)");
      //allows for user entry of "y" or "n"
      //toUpperCase() ensures case insensitivity
      rerunValue = input.nextLine().toUpperCase();
      //prints a message depending on what is entered
      if (rerunValue.equals("Y")) {
        System.out.println("Wonderful! I will restart the program for you./n");
      } else if (rerunValue.equals("N")) {
        System.out.println("Thank you for using this program. Goodbye!");
      } else {
        //this message will only trigger if the response is neither "Y" nor "N"
        //thanks to the loop above, question would be asked again after this message prints
        System.out.println("I'm sorry, I need a Y or N response.");
      }
    }
    //final rerunValue of "Y" or "N" is returned
    return rerunValue;
  }

  //The actual program
  public static void main(String[] args) {
    //Introductory statement to explain program to users
    System.out.println("This program was coded with Java by Lilly Gullett for the Introduction to Java Programming course by Sophia.\nThis program takes 2 English words or phrases and determines if one is an anagram for the other.\nI hope you enjoy!");
    //initializes the allowance for user input for program
    Scanner input = new Scanner(System.in);
    //initializes rerunValue variable for program
    String rerunValue = "";
    //loop will run as long as the rerunValue is not "N"
    while (!rerunValue.equals("N")) {
      //user instruction for input
      System.out.println("\nPlease enter your first word or phrase.\nHit enter when you are done");
      //allows a spot for the program to store whatever the user first enters
      //entry is complete when enter is pressed
      String inputA = input.nextLine();
      System.out.println("\nPlease enter your second word or phrase.");
      //allows a spot for the program to store user's second entry
      String inputB = input.nextLine();
      //the following two lines set both entries to lowercase to ensure case insensitivity
      //they also use the AlphabetizeInput method to reorganize the strings to a simple list of letters used in each input
      String alphabeticalInputA = AlphabetizeInput(inputB.toLowerCase());
      String alphabeticalInputB = AlphabetizeInput(inputA.toLowerCase());
      //adds an empty line for readability in print display
      System.out.println();
      //the AlphabetizeInput method will dismiss any characters entered by the user that are outside of the English Alphabet
      //if either of the user's entries does not include any alphabetical characters, the output variables will be an empty string
      if (alphabeticalInputA.equals("") || alphabeticalInputB.equals("")) {
        System.out.println("At least one of your phrases contianed no alphabetical characters.\nThis tool is only able to check for anagrams using characters from the English alphabet.");
      } else {
        //if both outputs are found to not be empty, the CheckForMatch method will be run
        //if one or both outputs are empty, the CheckForMatch method is skipped and the Rerun method is called instead
        //CheckForMatch method will return true if the alphabetized inputs are the same, false if they are not
        Boolean match =CheckForMatch(alphabeticalInputA, alphabeticalInputB);
        //if else statement determines how the user is told the lines are anagrams or not depending on match variable
        if (match == true) {
          System.out.println("\'"+ inputA +"\' is an anagram for \'"+ inputB +"\'.");
        } else {
          System.out.println("\'"+ inputA +"\' is not an anagram for \'"+ inputB +"\'.");
        }
      }
      //Rerun method is called within the loop to ensure that the value is set accordingly when the loop restarts
      rerunValue = Rerun();
    }
  }
}