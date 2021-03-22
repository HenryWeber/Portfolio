import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        HashMap<String, Integer> wordToNum = new HashMap();

        //PUT (insert)
        wordToNum.put("ONE", 1);
        wordToNum.put("TWO", 2);
        wordToNum.put("THREE", 3);
        wordToNum.put("FOUR", 4);
        wordToNum.put("FIVE", 5);

        //Get value from key
        System.out.println(wordToNum.get("THREE"));

        System.out.println(wordToNum.values());
        System.out.println(wordToNum.keySet());

        //Remove with key value
        System.out.println(wordToNum.remove("FOUR"));
        
        System.out.println(wordToNum.values());
        System.out.println(wordToNum.keySet());


        // Common Use of HashMaps: Which character is the most repeated?
        String s = "phonebook";
        HashMap<Character, Integer> hashMap = new HashMap();
        
        //iterate through String
        for (int i = 0; i < s.length(); i++) {
           
        	//retrieve each character
        	Character currentChar = s.charAt(i);
            if (hashMap.containsKey(currentChar)) {
                
            	// increment hashmap by 1
                hashMap.put(currentChar, hashMap.get(currentChar) + 1);
            } else {
                // if not in hashmap become 1
                hashMap.put(currentChar, 1);
            }
        }

        Character mostRepeated = ' ';
        int max = 0;
        for (Character key : hashMap.keySet()) {
           
        	int currentValue = hashMap.get(key);
            if (currentValue > max) {
                mostRepeated = key;
                max = currentValue;
            }
        }

        System.out.println("Most Repeated: " + mostRepeated + " | Times: " + max);

    }
}
