import java.util.HashMap;
import java.lang.StringBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;


public class ParseShake{
    public static String shakeToString(){
      String returnString ="";
      StringBuilder shakeBuilder = new StringBuilder();
      try{
        File file = new File("shakespeare.txt"); //makes file object
        FileReader inputFile = new FileReader(file); //assign file object to file reader
        BufferedReader lineReader = new BufferedReader(inputFile); //assign buffered reader to file reader
        String line;
        while ((line = lineReader.readLine()) != null) {
            shakeBuilder.append(" " + line); //using stringbuilder to read the file since string+= copies string over everytime, so it's a o^n complexity
        }
        inputFile.close();
        lineReader.close();
      }
      catch(IOException e){e.printStackTrace();}

      returnString = shakeBuilder.toString()
      .replaceAll("\\,","").replaceAll("\\;","").replaceAll("\\:","")
      .replaceAll("\\[","").replaceAll("\\]","").replaceAll("\\'","")
      .replaceAll("\\(","").replaceAll("\\)","").replaceAll("\\-","");
      
      return returnString;
    }

    public static String[] shakeStringToArray(){
      String[] shake = shakeToString().split("\\s+");
      return shake;
    }

    public static HashMap<String , ArrayList<String>> wordsThatFollow(){                        //this builds a hashmap of a word and all wordsd that followed this word at one point (with duplicates)
      HashMap<String , ArrayList<String>> returnMap = new HashMap<String , ArrayList<String>>();
      String[] shakeArray = shakeStringToArray();
      
      for(int i = 0; i< shakeArray.length-2; i++){
        String currentWord = shakeArray[i];
        String nextWord = shakeArray[i+1];
        if(returnMap.get(currentWord)==null){
          returnMap.put(currentWord, new ArrayList<String>(Arrays.asList(nextWord)));
        }
        else{
          ArrayList<String> s = returnMap.get(currentWord);
          s.add(nextWord);
          returnMap.put(currentWord,s);
        }
      }
      return(returnMap);
    }

    public static String pickWordFrom(ArrayList<String> wordsToPickFrom){ //picks a random word from a list of words to pick. since the array has duplicate words
      String returnString = "";                                     //proportional to how often they appear, randomly picking by index should work
      
      Random randomNumber = new Random();                           //not best randomness(?)--->doesnt get close to real random until further out
      int index = randomNumber.nextInt(wordsToPickFrom.size());
      returnString = wordsToPickFrom.get(index);

      return returnString;
    }
    public static HashMap<String, Integer> wordCount(ArrayList<String> words){ //doesn't really get used but nice to have
      HashMap<String, Integer> returnMap  = new HashMap<String, Integer>();
      for(String s : words){
          if(returnMap.get(s)==null){
              returnMap.put(s,1);
          }
          else{
              int i = returnMap.get(s);
              returnMap.put(s,i+1);
          }
      }
      return(returnMap);
    }
}

