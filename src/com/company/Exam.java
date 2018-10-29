package com.company;

import java.util.Scanner;

public class Exam {
    public static void main(String[] args) {
        uniqueCharacters();
    }

    private static void uniqueCharacters(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String str = input.nextLine();

        boolean status = true;

        start:
        for(int i = 0; i < str.length(); i++){
            char a = str.charAt(i);
            for(int j = 0; j < str.length(); j++){
                if(i != j){
                    if(a == str.charAt(j)){
                        status = false;
                        break start;
                    }
                }
            }
        }

        if(status){
            System.out.println("Unique");
        }else{
            System.out.println("not unique");
        }
    }
}
