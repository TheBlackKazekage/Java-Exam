package com.company;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        uniqueChars();
        longestWord();
        extractArrayList();
        displayLinkedList();
        compareSets();
        compareTreeSet();
        checkPassword();
        compareString();
//        removeDuplicates();
//        anagramCheck();
    }

    //Implement an algorithm to find the kth to last element of a singly linked list using an iterative solution


    //Implement an algorithm to determine if a string has all unique characters. Do not use additional data structures
    private static void uniqueChars(){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string to check if it has unique characters: ");
        String str = input.nextLine();
        input.close();

        boolean status = false;

        start:
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);

            for(int j = 0; j < str.length(); j++){
                if(i != j){
                    if(str.charAt(j) == c){
                        status = true;
                        break start;
                    }
                }
            }
        }
        if (!status) {
            System.out.println("This string has unique characters");
        } else {
            System.out.println("This string doesn't have unique characters");
        }
    }

    //Write a Java program to find the longest word in a text file
    private static void longestWord(){
        try {
            FileReader reader = new FileReader("file.txt");
            Scanner input = new Scanner(reader);
            int longest = 0;
            String longestWord = "";
            String str;

            while (input.hasNext()) {
                str = input.next();
                int len = str.length();
                if (len > longest) {
                    longest = len;
                    longestWord = str;
                }
            }

            System.out.println("Longest word = " + longestWord + " size = " + longest);

        } catch (IOException e) {
            e.getMessage();
        }
    }

    //Write a Java program to extract a portion of a array list
    private static void extractArrayList(){
        ArrayList<String> list = new ArrayList<>();

        System.out.print("How many values do you want in the array list?: ");
        int size = Integer.parseInt(getInput());

        System.out.println("Enter values into an array list: ");
        for(int i = 0; i < size; i++){
            list.add(getInput());
        }

        System.out.println("What portion of the arrayList do you want to extract: ");
        System.out.print("Start: ");
        int start = Integer.parseInt(getInput());
        System.out.print("End: ");
        int end = Integer.parseInt(getInput());

        String[] arr = list.toArray(new String[0]);

        ArrayList<String> newList = new ArrayList<>(Arrays.asList(arr).subList(start, end + 1));

        System.out.println(newList);
    }

    //Write a Java program to display the elements and their positions in a linked list
    private static void displayLinkedList(){
        LinkedList<String> list = new LinkedList<>();
        Scanner input = new Scanner(System.in);
        System.out.println("How many elements do you want to add into the linked list: ");
        int size = input.nextInt();
        System.out.println("Enter the elements: ");
        for(int i = 1; i <= size; i++){
            String a = input.nextLine();
            list.add(i, a);
        }

        System.out.println("The elements in the linked list include: ");
        for(int i = 1; i <= size; i++){
            System.out.println(i + " " + list.get(i));
        }
    }

    //Write a Java program to compare two sets and retain elements which are same on both sets
    private static void compareSets(){
        Set<String> set1 = new TreeSet<>();
        Set<String> set2 = new TreeSet<>();

        Scanner input = new Scanner(System.in);
        System.out.println("How many elements do you want to add into the tree sets: ");
        int size = input.nextInt();

        System.out.println("Enter the elements in set 1: ");
        for(int i = 0; i < size; i++){
            String a = input.nextLine();
            set1.add(a);
        }

        System.out.println("Enter the elements in set 2: ");
        for(int i = 0; i < size; i++){
            String a = input.nextLine();
            set2.add(a);
        }

        Iterator it = set1.iterator();
        while(it.hasNext()){
            if(set2.contains(it.next())){
                set1.remove(it.next());
            }else{
                System.out.println(it.next());
            }
        }

        Iterator it2 = set2.iterator();
        while(it2.hasNext()){
            if(set1.contains(it2.next())){
                set2.remove(it2.next());
            }
            System.out.println(it2.next());
        }
    }

    //Write a Java program to compare two tree sets
    private static void compareTreeSet(){
        TreeSet<String> set1 = new TreeSet<>();
        TreeSet<String> set2 = new TreeSet<>();

        Scanner input = new Scanner(System.in);
        System.out.println("How many elements do you want to add into the tree sets: ");
        int size = input.nextInt();

        System.out.println("Enter the elements in set 1: ");
        for(int i = 1; i <= size; i++){
            String a = input.nextLine();
            set1.add(a);
        }

        System.out.println("Enter the elements in set 2: ");
        for(int i = 1; i <= size; i++){
            String a = input.nextLine();
            set2.add(a);
        }

        System.out.println("Tree Set 1: ");
        Iterator it = set1.iterator();
        while(it.hasNext()){
            if(set2.contains(it.next())){
                set1.remove(it.next());
            }else{
                System.out.println(it.next());
            }
        }

        System.out.println("Tree Set 2: ");
        Iterator it2 = set2.iterator();
        while(it2.hasNext()){
            if(set1.contains(it2.next())){
                set2.remove(it2.next());
            }
            System.out.println(it2.next());
        }
    }

    //Write a Java method to check whether a string is a valid password.
    //Password rules:
    //A password must have at least ten characters.
    //A password consists of only letters and digits.
    //A password must contain at least two digits
    private static void checkPassword(){
        Scanner input = new Scanner(System.in);
        System.out.println("Password rules:\n" +
                "A password must have at least ten characters.\n" +
                "A password consists of only letters and digits.\n" +
                "A password must contain at least two digits");
        System.out.print("Enter a password: ");
        String password = input.nextLine();
        boolean status = true;
        int digits = 0;

        while(status){
            if(password.length() == 10){
                for(int i = 0; i < password.length(); i++){
                    char c = password.charAt(i);
                    if(Character.isLetter(c) || Character.isDigit(c)){
                        if(Character.isDigit(c)){
                            digits++;
                        }
                    }
                }
                if(digits > 1){
                    status = false;
                }else{
                    System.out.println("Invalid password... Try again");
                }
            }
        }
    }

    //Write a Java program to compare a given string to the specified string buffer
    private static void compareString(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String str = input.nextLine();

        System.out.println("Enter a string: ");
        String str2 = input.nextLine();

        StringBuffer buffer = new StringBuffer(str);


        System.out.println("Comparing string 2 to buffer: ");
        boolean status = str2.contentEquals(buffer);
        System.out.println(status);
    }

    //Write a program to remove duplicates from an array in Java without using the Java Collection API
    private static void removeDuplicates(){
        Scanner input = new Scanner(System.in);
        System.out.println("Size of array: ");
        int size = input.nextInt();
        int[] arr = new int[size];

        System.out.println("Enter int values: ");
        for(int i = 0; i < size; i++){
            arr[i] = input.nextInt();
        }

        for(int j = 0; j < size; j++){
            int k = arr[j];
            for(int g = 0; g < size; g++){
                if(j != g){
                    if(k == arr[g]){
                        arr[g] = Integer.parseInt(null);
                    }
                }
            }
        }

        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }

    }

    //Write a program to check if two given String is Anagram of each other. Your function should return true if two Strings are Anagram, false otherwise. A string is said to be an anagram if it contains same characters and same length but in different order e.g. army and Mary are anagrams
    private static void anagramCheck(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter 1st word: ");
        String word1 = input.nextLine();
        System.out.println("Enter 2nd word: ");
        String word2 = input.nextLine();

        int counter = 0;

        if(word1.length() == word2.length()){
            for(int i = 0; i < word1.length(); i++){
                for(int j = 0; j < word2.length(); j++){
                    if(word1.charAt(i) == word2.charAt(j)){
                        counter++;
                        break;
                    }
                }
            }
            if(counter == word1.length()){
                System.out.println("Anagrams");
            }

        }else{
            System.out.println("Not anagram");
        }
    }

    //Write a Java program to print all permutations of a given String. For example, if given String is "GOD" then your program should print all 6 permutations of this string e.g. "GOD", "OGD", "DOG", "GDO", "ODG", and "DGO".
    private static void stringPermutations(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String str = input.nextLine();

        System.out.println("Permutations include: " + "\n" + str);
        for(int i = 0; i < str.length(); i++){
            
        }
    }


    private static String getInput(){
        String result = null;
        try{
            BufferedReader input1 = new BufferedReader(new InputStreamReader(System.in));
            result = input1.readLine();

        }catch (IOException e){
            e.getMessage();
        }

        return result;
    }
}
