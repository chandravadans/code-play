package com.cv.codepad.symantec.round2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Chandravadan on 5/3/2017.
 */
public class Question1 {
    public static void main(String[] args) {
        //String s = "The quick brown fox jumps over the lazy dog named Charlie.";
        //String s = "Hello world.";
        //String s = "Hello World";
        //String s = "Hello";
        //String s = "Hello.";
        //String s = "hello.";
        //String s = "I had pizza today for lunch.";
        String s = "I finished my B.Tech. in 2008.";
        System.out.println(reverseWords(s));

    }

    static String reverseWords(String sentence) {

        if (sentence == null) {
            return null;
        }

        boolean endsWithDot = false;
        if (sentence.endsWith(".")) {
            endsWithDot = true;
            sentence = sentence.substring(0, sentence.length() -1);
        }

        List<Integer> dotIndices = new ArrayList<>();
        for(int i=0; i < sentence.length(); i++) {
            if (sentence.charAt(i) == '.') {
                dotIndices.add(i);
            }
        }

        sentence = sentence.replaceAll("\\.","");

        String[] words = sentence.split(" ");
        StringBuilder reversedSentence = new StringBuilder();

        for (String word : words) {
            String reversedWord = "";
            Stack<Character> wordStack = new Stack<>();
            for (Character c : word.toCharArray()) {
                if (c == word.charAt(0) && word.length() > 1) {
                    wordStack.push(Character.toLowerCase(c));
                } else if (Character.toUpperCase(word.charAt(0)) == word.charAt(0) && word.endsWith(""+c)) {
                    wordStack.push(Character.toUpperCase(c));
                } else  {
                    wordStack.push(c);
                }
            }
            while (!wordStack.isEmpty()) {
                reversedWord = reversedWord + String.valueOf(wordStack.pop());
            }
            reversedSentence.append(reversedWord + " ");
        }


        reversedSentence.setLength(reversedSentence.length()-1);

        for(Integer i : dotIndices) {
            reversedSentence.insert(i,".");
        }

        if (endsWithDot) {
            reversedSentence.append('.');
        }
        return reversedSentence.toString();
    }
}
