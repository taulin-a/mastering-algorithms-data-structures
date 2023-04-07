package mastering.datastructures.string;

public class StringExampleMain {
    public static void main(String[] args) {
        var str = new StringADT(new char[]{'T', 'E', 'S', 'T', 'E', '\0'});

        System.out.println("Length of string: " + str.getLength());

        System.out.println(str.getValue());

        str.toLowercase();

        System.out.println(str.getValue());

        str.toUppercase();

        System.out.println(str.getValue());

        var str2 = new StringADT(new char[]{'t', '3', 'S', 'T', 'e', '\0'});

        str2.toggleCase();

        System.out.println(str2.getValue());

        var str3 = new StringADT(new char[]{'H', 'o', 'w', ' ', 'a', 'r', 'e', ' ', ' ', 'y', 'o', 'u', '\0'});

        str3.countVowelsAndConsonants();

        System.out.println("Num of words: " + str3.getWordCount());


        var str4 = new StringADT(new char[]{'H', 'o', 'w', ' ', 'a', 'r', 'e', ' ', ' ', 'y', 'o', 'u', '!', '\0'});
        System.out.println("Has special characters? " + (str4.hasSpecialCharacters() ? "yes" : "no"));

        str4.reverse();

        System.out.println(str4.getValue());

        str4.reverseTranscribe();

        System.out.println(str4.getValue());


        var str5 = new StringADT(new char[]{'l', 'i', 'r', 'i', 'l', '\0'});

        System.out.println("Is palindrome: " + str5.isPalindrome());
        System.out.println("Is palindrome: " + str5.isPalindromeOptimal());

        //str5.findDuplicates();
        str5.findDuplicatesBitwise();

        var str6 = new StringADT(new char[]{'r', 'i', 'l', 'i', 'l', '\0'});

        System.out.println("Is " + str5.getValue() + " anagram of " + str6.getValue() + ": " + str5.isAnagramOf(str6));

        var str7 = new StringADT(new char[]{'a', 'b', 'c', '\0'});
        str7.permutateSwap();

    }
}
