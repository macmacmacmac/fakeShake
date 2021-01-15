import java.util.HashMap;
import java.util.ArrayList;
public class MimicShake {
    private static HashMap<String, ArrayList<String>> wordsThatFollow = ParseShake.wordsThatFollow();

    public static String mimicForThisManyLines(int numberOfWords, String firstWord){
        String returnString = firstWord;
        StringBuilder shakeBuilder = new StringBuilder(); 
        shakeBuilder.append(firstWord);

        String lastWord = firstWord; //will use lastWord to figure out nextWord
        /* use this if you want to have lines
        while(numberOfLines != 0){
            int numberOfWordsInThisLine = 0;
            while(numberOfWordsInThisLine < 10){
                String nextWord = ParseShake.pickWordFrom(wordsThatFollow.get(lastWord)); 
                shakeBuilder.append(" " + nextWord);
                lastWord = nextWord;
                numberOfWordsInThisLine+=1;
            }
            numberOfLines -=1;
            shakeBuilder.append("\n");
        }
        */
            while(numberOfWords > 0){
                String nextWord = ParseShake.pickWordFrom(wordsThatFollow.get(lastWord)); 
                shakeBuilder.append(" " + nextWord);
                lastWord = nextWord;
                numberOfWords-=1;
            }
        returnString = shakeBuilder.toString();
        return returnString;
    }
}
