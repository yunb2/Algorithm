package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 암호만들기 {

    static int L, C;
    static char[] chars;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        L = Integer.parseInt(str[0]);
        C = Integer.parseInt(str[1]);

        chars = new char[C];
        str = br.readLine().split(" ");
        for(int i=0; i<C; ++i) chars[i] = str[i].charAt(0);
        Arrays.sort(chars);

        // a c i s t w
        for(int i=0; i<C; ++i) {
            int vowel = ((isVowel(chars[i])? 1 : 0));
            int consonant = ((isVowel(chars[i])? 0 : 1));
            dfs(1, i, vowel, consonant, chars[i]+"");
        }

    }

    public static void dfs(int index, int charIndex, int vowel, int consonant, String pwd) {

        if(index >= L) {
            if(vowel >= 1 && consonant >= 2) System.out.println(pwd);
            return;
        }

        for(int i=charIndex+1; i<C; ++i) {
            dfs(index+1, i, vowel + ((isVowel(chars[i])? 1 : 0)), consonant + ((isVowel(chars[i])? 0 : 1)), pwd+chars[i]);
        }

    }

    public static boolean isVowel(char c) {
        switch (c) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                return true;
            default:
                return false;
        }
    }

}
