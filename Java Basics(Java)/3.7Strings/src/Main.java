
public class Main {

	public static void main(String[] args) {
		String str1 = "HellO";
		String str2 = " there is a quiet Mouse";
		String str3 = "I am happy  ";
		
		System.out.println("Algo 1");
		findNumberofVowelsAndConsonants(str1);
		findNumberofVowelsAndConsonants(str2);
		findNumberofVowelsAndConsonants(str3);
		
		System.out.println("Algo 2 (Ascii)");
		findNumberofVowelsAndConsonantsWithAscii(str1);
		findNumberofVowelsAndConsonantsWithAscii(str2);
		findNumberofVowelsAndConsonantsWithAscii(str3);
	}
	public static void findNumberofVowelsAndConsonants(String input) {
		int vowelsCount = 0;
		int consonantCount = 0;
		String vowels = "aeiouy";
		String normalized = (input.toLowerCase().trim());
		char[] inputCharArray = normalized.toCharArray();
		
		for(char c : inputCharArray) {
			if(vowels.indexOf(c) != -1) {
				vowelsCount++;
			}else if (c != ' ') {
				consonantCount++;
			}
		}
		System.out.println("Vowels: "+ vowelsCount + " in " + input);
		System.out.println("Consonants: "+ consonantCount + " in " + input);
		System.out.println();
	}
	public static void findNumberofVowelsAndConsonantsWithAscii(String input) {
		int vowelsCount = 0;
		int consonantCount = 0;
		String vowels = "aeiouyAEIOUY";
		
		for(int i = 0; i <input.length(); i++) {
			int asciiValue = (int) input.charAt(i);//retrieve ascii value
			
					//65-90 uppercase letters				97-122 lowercase letters
			if((asciiValue <= 90 && asciiValue >= 65) ||(asciiValue <= 122 && asciiValue >= 97)) {
				
				if(vowels.contains(Character.toString(input.charAt(i)))) {
					vowelsCount++;
				}else {
					consonantCount++;
				}
			}
		}
		System.out.println("Vowels: "+ vowelsCount + " in " + input);
		System.out.println("Consonants: "+ consonantCount + " in " + input);
		System.out.println();
		
	}

}
