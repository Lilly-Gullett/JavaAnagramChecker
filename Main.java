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
  
  public static void main(String[] args) {
    System.out.println(AlphabetizeInput("Tom Marvolo Riddle"));
  }
}