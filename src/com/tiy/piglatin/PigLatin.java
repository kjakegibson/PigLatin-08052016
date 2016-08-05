package com.tiy.piglatin;

import java.util.Scanner;

public class PigLatin {
	
	//Worked on by Michael Donnelly, Keith, Gibson, Kavita Somavarapu, & John Suchocki
    //Credit to Ami Shah for pointing out a break statement was missing.... /facepalm
    
      public static void main(String[] args) {
    	  
    	  System.out.println("Please to enter a sentence for ultra pig latin super funtime!"
    	  		+ "\nNO SPECIAL CHARACTERS, NUMBERS OR PUNCTUATION ALLOWED :D :D :D:");
            
            //Takes user input, converts to string builder, breaks into words, deposits into array
            Scanner pigLatin = new Scanner(System.in);
            String userSentence = pigLatin.nextLine();
            userSentence = userSentence.toLowerCase();
            
            userSentence = userSentence.replaceAll("\\s+"," ");
            String[] sentenceWords = userSentence.split(" ");
            
            
            int wordArrayLength = sentenceWords.length;
            
            String[] convertedWords = new String[wordArrayLength];
            
            /*for (int i = 0; i < wordArrayLength; i++) {
                System.out.println(sentenceWords[i]);
            }*/
            pigLatin.close();
            
            //loops through all words in the array of words
            for (int word = 0; word < wordArrayLength; word++) {
                String currentWord = sentenceWords[word];
                StringBuilder currentWordSB = new StringBuilder(currentWord);
                int numberChars = currentWordSB.length();
                
                
                
                //loops through each letter of individual words looking for the first vowel
                for (int letter = 0; letter <= numberChars; letter++) {
                    char isThisVowel = currentWordSB.charAt(letter);
                    switch (isThisVowel) {
                    case 'a':
                    case 'e':
                    case 'i':
                    case 'o':
                    case 'u':
                        if (letter == 0) {
                            convertedWords[word] = currentWordSB + "yay";
                        } else {
                            String currentWordSnippet = currentWordSB.substring(0, letter);
                            currentWordSB.delete(0,  letter);
                            convertedWords[word] = currentWordSB.toString() + currentWordSnippet + "ay";
                        }
                        break;
                        
                    default:
                        if (letter == (numberChars - 1)) {
                            convertedWords[word] = currentWordSB.toString();
                        } else {
                            continue;
                        }
                        break;  
                    }
                    break;
                }
            
            }
            
            //prints out original input in Pig Latin
            for (int wordPrint = 0; wordPrint < convertedWords.length; wordPrint++) {
                System.out.print(convertedWords[wordPrint] + " ");
            }
            
            }
            
        }