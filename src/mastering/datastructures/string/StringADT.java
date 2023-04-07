package mastering.datastructures.string;

import java.util.Arrays;

public class StringADT {
    private static final int UPPER_LOWER_SHIFT_VALUE = 32;

    private char[] chars;

    public StringADT(char[] chars) {
        this.chars = chars;
    }

    public int getLength() {
        var i = 0;
        while (chars[i] != '\0') i++;

        return i;
    }

    public char get(int index) {
        return chars[index];
    }

    public void toLowercase() {
        for (int i = 0; i < getLength(); i++) {
            chars[i] += UPPER_LOWER_SHIFT_VALUE;
        }
    }

    public void toUppercase() {
        for (int i = 0; i < getLength(); i++) {
            chars[i] -= UPPER_LOWER_SHIFT_VALUE;
        }
    }

    public void toggleCase() {
        for (int i = 0; chars[i] != '\0'; i++) {
            if (chars[i] >= 65 && chars[i] <= 90) {
                chars[i] += UPPER_LOWER_SHIFT_VALUE;
            } else if (chars[i] >= 'a' && chars[i] <= 122) {
                chars[i] -= 32;
            }
        }
    }

    public void countVowelsAndConsonants() {
        var vowels = 0;
        var consonants = 0;
        for (int i = 0; chars[i] != '\0'; i++) {
            if (chars[i] == 'A' || chars[i] == 'a'
                    || chars[i] == 'E' || chars[i] == 'e'
                    || chars[i] == 'I' || chars[i] == 'i'
                    || chars[i] == 'O' || chars[i] == 'o'
                    || chars[i] == 'U' || chars[i] == 'u') {
                vowels++;
            } else if ((chars[i] >= 'A' && chars[i] <= 'Z')
                    || (chars[i] >= 'a' && chars[i] <= 'z')) {
                consonants++;
            }
        }

        System.out.println("Vowels: " + vowels + " - Consonants: " + consonants);
    }

    public int getWordCount() {
        var words = 0;
        for (int i = 0; chars[i] != '\0'; i++) {
            if (chars[i] == ' ' && i >= 1 && chars[i - 1] != ' ') {
                words++;
            }
        }

        return ++words;
    }

    public String getValue() {
        return new String(Arrays.copyOfRange(chars, 0, getLength()));
    }

    public boolean hasSpecialCharacters() {
        for (int i = 0; chars[i] != '\0'; i++) {
            if (!(chars[i] >= 65 && chars[i] <= 90)
                    && !(chars[i] >= 97 && chars[i] <= 122)
                    && !(chars[i] >= 48 && chars[i] <= 57)) {
                return true;
            }
        }

        return false;
    }

    public void reverse() {
        var len = getLength();
        var newArray = new char[len + 1];

        for (int i = 0, j = len - 1; i < len; i++, j--) {
            newArray[i] = chars[j];
        }

        newArray[len] = '\0';

        chars = newArray;
    }

    public void reverseTranscribe() {
        var len = getLength();
        char aux;

        for (int i = 0, j = len - 1; i < j; i++, j--) {
            aux = chars[i];
            chars[i] = chars[j];
            chars[j] = aux;
        }
    }

    public int compare(StringADT str) {
        int i;
        for (i = 0; chars[i] != '\0' && str.get(i) != '\0'; i++) {
            if (chars[i] != str.get(i))
                break;
        }

        if (chars[i] == str.get(i)) {
            return 0;
        } else if (chars[i] < str.get(i)) {
            return -1;
        } else {
            return 1;
        }
    }

    public int compareIgnoreCase() {
        // TODO
        return 0;
    }

    public boolean isPalindrome() {
        var str2 = new StringADT(chars.clone());

        str2.reverse();

        return compare(str2) == 0;
    }

    public boolean isPalindromeOptimal() {
        for (int i = 0, j = getLength() - 1; i < j; i++, j--) {
            if (chars[i] != chars[j]) {
                return false;
            }
        }

        return true;
    }

    public void findDuplicates() {
        var auxArray = chars.clone();
        final var len = getLength();

        for (int i = 0; i < (len - 1); i++) {
            if (auxArray[i] == '\0')
                continue;

            var count = 1;
            for (int j = i + 1; j < len; j++) {
                if (auxArray[i] == auxArray[j]) {
                    count++;
                    auxArray[j] = '\0';
                }
            }

            if (count > 1) {
                System.out.println("Duplicate element found: " + auxArray[i] + " - duplicated times: " + count);
            }
        }
    }

    public void findDuplicatesHashTable() {
        var hashTable = new int[26];
        Arrays.fill(hashTable, 0);

        for (char c : chars) {
            if (c == '\0') break;

            hashTable[c - 97]++;
        }

        for (int i = 0; i < hashTable.length; i++) {
            if (hashTable[i] > 1) {
                System.out.println("Duplicated element found: " + ((char) (i + 97)));
            }
        }
    }

    public void findDuplicatesBitwise() {
        long h = 0L, x = 0L;

        for (int i = 0; chars[i] != '\0'; i++) {
            x = 1L;
            x = x << (chars[i] - 97);
            if ((x & h) > 0) {
                System.out.println("Duplicated element found: " + chars[i]);
            } else {
                h = x | h;
            }
        }
    }

    public boolean isAnagramOf(StringADT str) {
        var hashTable = new int[26];
        Arrays.fill(hashTable, 0);

        if (getLength() != str.getLength())
            return false;

        for (int i = 0; chars[i] != '\0'; i++) {
            hashTable[chars[i] - 97]++;
        }

        for (int j = 0; str.get(j) != '\0'; j++) {
            hashTable[str.get(j) - 97]--;

            if (hashTable[str.get(j) - 97] < 0)
                return false;
        }

        for (int i : hashTable) {
            if (i != 0) return false;
        }

        return true;
    }

    public void permutate() {
        int a[] = new int[chars.length];
        Arrays.fill(a, 0);

        char res[] = new char[chars.length];

        doPermutate(0, a, res);
    }

    public void permutateSwap() {
        doPermutate2(chars.clone(), 0, chars.length - 1);
    }

    private void doPermutate(int k, int a[], char[] res) {
        if (chars[k] == '\0') {
            res[k] = '\0';
            System.out.println(res);
            return;
        }

        for (int i = 0; chars[i] != '\0'; i++) {
            if (a[i] == 0) {
                res[k] = chars[i];
                a[i] = 1;
                doPermutate(k + 1, a, res);
                a[i] = 0;
            }
        }
    }

    private void doPermutate2(char[] str, int l, int h) {
        if (l == h) {
            System.out.println(str);
            return;
        }

        char aux;

        for (int i = l; str[i] != '\0'; i++) {
            aux = str[l];
            str[l] = str[i];
            str[i] = aux;
            doPermutate2(str, l + 1, h);
            aux = str[l];
            str[l] = str[i];
            str[i] = aux;
        }
    }
}
