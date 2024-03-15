import java.util.*;

public class TarekMap {

    public Map<Character, List<String>> Maps;
    public List<Character> Characters;

    public TarekMap () {
      Maps = new HashMap<>();
    }
    void sortCharacter (){

           Maps.forEach((key, words) -> Collections.sort(words)); 
    }

    void addWords(char Key, List<String> words){
       if (Maps.containsKey(Key)) {

            System.out.println(Key + ": Duplicate Key");

        } else {
            Maps.put(Key, words);
        }
    }

    void printWords(){
         Maps.forEach((Key,Words)-> System.out.println("This Is Key = " + Key + "" +" Words: " + Words));
    }

    void printOneCharacter(char letter){
        Maps.forEach((Key, value) -> {
        if (Character.toUpperCase(Key) == Character.toUpperCase(letter)) {
            System.out.println("Key = " + Key + ", Value = " + value);
        }
    });
    }
      public static void main(String[] args) {

        TarekMap myMap = new TarekMap();
         List<String> myList = new ArrayList<>();

        myList.add("Tarek");
        myList.add("Ali");
        myList.add("Mohamed");
        myList.add("Ahmed");
        myList.add("Hany");
        myList.add("Waled");

        myMap.addWords('T', myList); 
        myMap.printWords(); 
        myMap.sortCharacter(); 
        myMap.printWords(); 
        myMap.printOneCharacter('T');
                
    }
}