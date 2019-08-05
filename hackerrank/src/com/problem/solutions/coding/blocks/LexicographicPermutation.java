package hackerrank.src.com.hackerrank.solutions.coding.blocks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LexicographicPermutation {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        char[] str = input.toCharArray();
        Arrays.sort(str);
        permute(str);

    }


    public static void permute(char input[]) {
        Map<Character, Integer> countMap = new TreeMap<>();
        for (char ch : input) {
            countMap.compute(ch, (key, val) -> {
                if (val == null) {
                    return 1;
                } else {
                    return val + 1;
                }
            });
        }
        char str[] = new char[countMap.size()];
        int count[] = new int[countMap.size()];
        int index = 0;
        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            str[index] = entry.getKey();
            count[index] = entry.getValue();
            index++;
        }
        List<String> resultList = new ArrayList<>();
        char result[] = new char[input.length];
        permuteUtil(str, count, result, 0);

    }

    public static void permuteUtil(char str[], int count[], char result[], int level) {
        if (level == result.length) {
            printStr(result);
            return;
        }

        for(int i = 0; i < str.length; i++) {
            if(count[i] == 0) {
                continue;
            }
            result[level] = str[i];
            count[i]--;
            permuteUtil(str, count, result, level + 1);
            count[i]++;
        }
    }

//    private static void printCombination(char[] str, int i) {
//        if (i == str.length) {
//            printStr(str);
//            return;
//        }
//        for (int j = i; j < str.length; j++) {
//            if (shouldSwap(str,i,j)) {
//                swap(str, i, j);
//                printCombination(str, i + 1);
//                swap(str, i, j);
//            }
//        }
//    }
//
//    private static void swap(char[] str, int i, int j) {
//        char temp = str[i];
//        str[i] = str[j];
//        str[j] = temp;
//    }

    private static void printStr(char[] str) {
        System.out.println(String.valueOf(str));
    }

//    static boolean shouldSwap(char str[], int start, int curr) {
//        for (int i = start; i < curr; i++) {
//            if (str[i] == str[curr]) {
//                return false;
//            }
//        }
//        return true;
//    }
}
