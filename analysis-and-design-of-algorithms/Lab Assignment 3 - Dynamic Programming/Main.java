//Egemen Balli 2 May 2023
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    private static final String[] KEYPAD = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static String convertWordToNumber(String word){
        String number = "";
        for(char c : word.toCharArray()){
            number += keyPad(c);
        }
        return number;
    }

    static int keyPad(char c){
        for (int index = 0; index < KEYPAD.length; index++) {
            if (KEYPAD[index].contains(String.valueOf(c))) return index;
        }
        return 0;
    }

    static String[] solve(String number, String[] words){
        ArrayList<Integer>[] indexArray = new ArrayList[]{new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>()};
        ArrayList<String> resultArray = new ArrayList<>();

        for (int i = 0; i < number.length(); i++) {
            int a = number.toCharArray()[i]-48;
            indexArray[a].add(i);
        }

        //convert words to number string
        String[] convertedWords = new String[words.length];
        for (int i = 0; i < words.length; i++) {
            convertedWords[i] = convertWordToNumber(words[i]);
        }

        boolean isFound = false;
        for (int a = 0; a < convertedWords.length; a++){
            for(int i = 0; i < convertedWords[a].length(); i++){
                if (isFound == true){
                    isFound = false;
                    break;
                }
                for(int index : indexArray[Character.getNumericValue(convertedWords[a].charAt(i))]){
                    int j = 0;
                    for(; j < convertedWords[a].length(); j++){
                        if(number.charAt(index + j) != convertedWords[a].charAt(j)){
                            break;
                        } else if (j==2) {
                            resultArray.add(words[a]);
                            isFound = true;
                        }
                    }
                }
            }
        }

        String[] result = new String[resultArray.size()];
        for(int i = 0; i < result.length; i++) result[i] = resultArray.get(i);
        return result;
    }

    public static void main(String[] args) {
        String number = "3662277";
        String[] words = {"foo", "bar", "baz", "foobar", "emo", "cap", "car", "cat"};

        System.out.println(Arrays.toString(solve(number, words)));
    }
}
