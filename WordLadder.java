//

import java.util.*;
import java.io.*;

public class WordLadder {

    //Creates method to read from dictionary using file location
    public static ArrayList<String> getDict() throws IOException {
        ArrayList<String> dictionary = new ArrayList<String>();
        //Replace file location with your own
        RandomAccessFile file = new RandomAccessFile("C:/Users/ayush/OneDrive/Code/WordLadder/dictionary.txt", "r");
        String str;
        while((str = file.readLine()) != null) {
            dictionary.add(str.toLowerCase());
        }
        file.close();

        return dictionary;
    }

    private static ArrayList<String> findOneDiff(String startWord, ArrayList<String> dict) {
        //Find words in the dictionary that differ by only one letter from the startWord
        ArrayList<String> y = new ArrayList<String>();
        for(String word: dict) {
            int count = 0;
            if(word.length() == startWord.length()) {
                for(int i = 0; i < startWord.length(); i++) {
                    if(word.charAt(i) != startWord.charAt(i)) {
                        count++;
                    }
                    //If the amount of differences goes past one, then we can break because the word won't work anyway
                    if(count > 1) {break;}
                }

            }
            //We can add the word if there is exactly one difference
            if(count == 1) {y.add(word);}
        }
        return y;
    }

    private static Queue<Stack<String>> wordLadder(Queue<Stack<String>> sladder, String end, Queue<Stack<String>> results, ArrayList<String> dict) {
        //Find world ladders
        while(!sladder.isEmpty()) {
            //Removes sladder because we just want to add the final ladders, not the individual steps
            Stack<String> st = sladder.poll();
            String lw = st.peek();

            //Passes lw into findOneDiff
            ArrayList<String> differ = findOneDiff(lw, dict);
            for(String word: differ) {
                //Makes sure we don't use words already in our ladder
                if(!st.contains(word)) {
                    Stack<String> nst = new Stack<String>();
                    nst.addAll(st);
                    nst.push(word);
                    if(word.equals(end)) {
                        results.offer(nst); //Found a ladder that works
                        return sladder;
                    } else {
                        sladder.offer(nst); //Continue working on this ladder
                    }
                }
            }
        }
        return null;
    }

    public static void main (String[] args) throws IOException {

        //Returns dictionary into this ArrayList
        ArrayList<String> dict = getDict();

        //Initializes a start and end word
        String startWord = "";
        String endWord = "";

        //Replace file location with your own
        RandomAccessFile file = new RandomAccessFile("C:/Users/ayush/OneDrive/Code/WordLadder/input.txt", "r");

        String str = "";
        while((str = file.readLine()) != null) {
            String[] arrOfStr = str.split(" ", 2);
            startWord = arrOfStr[0];
            endWord = arrOfStr[1];

            //Initializes a Queue of Stack<String> for all ladders (even if they don't end up working)
            Queue<Stack<String>> ladders = new LinkedList<Stack<String>>();

            //Initializes a Queue of Stack<String> for all ladders that do work
            Queue<Stack<String>> results = new LinkedList<Stack<String>>();

            Stack<String> s = new Stack<String>();
            s.push(startWord); //Adds the start word onto the stack
            ladders.offer(s); //Add the stack to the queue of ladders

            if(startWord.equals(endWord)) {
                System.out.println("[" + startWord + ", " + endWord + "]");
            }
            else {
                //Finds word ladders from start to end
                wordLadder(ladders, endWord, results, dict);

                if(results.size() == 0) {
                    System.out.println("There are no ladders between " + startWord + " and " + endWord);
                }
                else {
                    System.out.println("Found the shortest ladder! -->: " + results.peek());
                }
            }



            //Code to print all ladders (commented out due to bad time efficency)
            /*System.out.println();

            System.out.println("All ladders:");
            for(Stack st: results) {
                System.out.println(st);
            } */
        }
        file.close();


    }
}