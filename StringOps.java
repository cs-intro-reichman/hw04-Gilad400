public class StringOps {
    ////////////////////////////////////////////////////////////
    //////                                               ///////
    //////              Reminder:                        ///////
    //////        allowed methods                        ///////
    //////                                               ///////
    //////        1.charAt(int index)                    ///////
    //////        2.length()                             ///////
    //////        3.substring(int start)                 ///////
    //////        4.substring(int start,int ends)        ///////
    //////        5.indexOf(String str)                  ///////
    //////                                               ///////
    //////        The rest are not allowed !             ///////
    //////        if you want to use a different         ///////
    //////        method, and you can implement          ///////
    //////        it using material from the course      ///////
    //////        you need to implement a version of     ///////
    //////        the function by yourself.              ///////
    //////                                               ///////
    //////        see example for substring              ///////
    //////        in Recitation 3 question 5             ///////
    //////                                               ///////
    ////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        
    }

    public static String capVowelsLowRest (String string) {
        String res = "";
        char[] vowels = {'a','e','i','o','u','A','E','I','O','U'};
        boolean isVowel = false;
        
        for(int i = 0; i < string.length(); i++){
            for(int j = 0; j < vowels.length; j++){
                if (string.charAt(i) == vowels[j]) {
                    if ((string.charAt(i) >= 97) && (string.charAt(i) <= 122)) {
                        res += (char)(string.charAt(i) - 32);
                    }else{
                        res += (char)string.charAt(i);
                    }
                    isVowel = true;
                }
            }
            if((string.charAt(i) >= 65) && (string.charAt(i) <= 90) && !isVowel){
                res += (char)(string.charAt(i) + 32);
            }else if ((string.charAt(i) >= 97) && (string.charAt(i) <= 122) && !isVowel) {
                res += string.charAt(i);
            }else if (!isVowel) {
                res += " ";
            }
            isVowel = false;
        }
        return res;
    }

    public static String camelCase (String string) {
        String res = "";
        int index = 0;
        //Check where is the first word start
        while (index < string.length()) {
            if (string.charAt(index) != 32) {
                break;
            }
            index++;
        }
        //Modify the first word
        res += lowercaseFirstWord(string, index);
        //Update the index
        index += res.length();
        //Modify the rest of the words in the sentence
        while (index < string.length()) {
            if (string.charAt(index) != 32) {
                String temp = middleWord(string, index);
                res += temp;
                index += temp.length();
            } 
            index++;
        }
        return res;
    }

    public static int[] allIndexOf (String string, char chr) {
        int count = 0;
        for(int i = 0; i < string.length(); i++){
            if (string.charAt(i) == chr) {
                count++;
            }
        }
        int[] allTheIndex = new int[count];
        int index = 0;
        for(int j = 0; j < string.length(); j++){
            if (string.charAt(j) == chr) {
                allTheIndex[index++] = j;
            }
        }
        return allTheIndex;
    }

    private static String lowercaseFirstWord (String string, int index){
        String firstWord = "";
        while(index < string.length() && (string.charAt(index) != 32)){
            if ((string.charAt(index) >= 65) && (string.charAt(index) <= 90)) {
                firstWord += (char)(string.charAt(index) + 32);
            } else {
                firstWord += (char)string.charAt(index);
            }
            index++;    
        }
        return firstWord;
    }

    private static String middleWord (String string, int index){
        String middleWord = "";
        //Firs letter
        if ((string.charAt(index) >= 97) && (string.charAt(index) <= 122)) {
            middleWord += (char)(string.charAt(index) - 32);
        }else {
            middleWord += (char)string.charAt(index);
        }
        index++;
        //All the rest
        while(index < string.length() && (string.charAt(index) != 32)){
            if ((string.charAt(index) >= 65) && (string.charAt(index) <= 90)) {
                middleWord += (char)(string.charAt(index) + 32);
            } else {
                middleWord += (char)string.charAt(index);
            }
            index++;    
        }
        return middleWord;
    }
    
}
