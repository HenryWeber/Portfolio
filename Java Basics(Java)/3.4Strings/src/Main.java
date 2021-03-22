public class Main {

	// static doesn't change variable
	public static String reverseString(String s) {
		
		StringBuilder stringBuilder = new StringBuilder();
		
		for(int i = s.length() -1; i >= 0; i--) {
			stringBuilder.append(s.charAt(i));
		}
		
		return stringBuilder.toString();
	}
	
    public static void main(String[] args) {
    	// A p p l e s	characters
    	// 0 1 2 3 4 5	indexes
        String a = "Apples";
        String b = "Bananas";
        String o = "Oranges";
        String bp = "Banana Peels";
        String p = "Pears";
        String[] fruits = {a, b, o, bp, p};



        for(String f : fruits) {
            
        	//CHARAT
        	int index = 1;
        	System.out.println(f.charAt(index));
        	
        	//TOCHARARRAY
        	char[] charArray = f.toCharArray();
        	System.out.println("Char at "+ index + " : "+ charArray[index]);
        	
        	//INDEXOF
        	int indexOfLetterE = f.indexOf('e');//retrieves index of first found index
        	System.out.println(indexOfLetterE);
        	
        	//CONTAINS
        	f = f.toLowerCase();
        	if(f.contains("app")) {
        		System.out.println("Contains app: " + f);
        	}
        	
        	//SUBSTRING
        	System.out.println(f.substring(1,4));
        	
        	//REVERSE
        	System.out.println("Reverse: " + reverseString(f));
        	System.out.println();
        	
        	
      	
        	

        }


    }
}
