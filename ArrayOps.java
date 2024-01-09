public class ArrayOps {
    public static void main(String[] args) {
    
        
    }
    
    public static int findMissingInt (int [] array) {
        int[] correctArray = new int[array.length + 1];
        for(int i = 0; i <= array.length; i++){
            correctArray[i] = i;
        }
        for(int j = 0; j < correctArray.length; j++){
            for(int k = 0; k < array.length; k++){
                if (array[k] == correctArray[j]) {
                    break;
                }
                if (k == array.length -1) {
                    return correctArray[j];
                }
            }
        }
        return -1;
    }

    public static int secondMaxValue(int [] array) {
        int max1 = 0;
        int max1Index = 0;
        int max2 = 0;
        for(int i = 0; i < array.length; i++){
            if (array[i] > max1) {
                max1 = array[i];
                max1Index = i;
            }
        }
        for(int j = 0; j < array.length; j++){
            if (array[j] > max2 && max1Index != j) {
                max2 = array[j];
                
            }
        }
        return max2;
    }

    public static boolean containsTheSameElements(int [] array1,int [] array2) {
        boolean ans = false;
        //Check if array 1 contain the same numbers as array 2
        for(int i = 0; i < array1.length; i++){
            for(int j = 0; j < array2.length; j++){
                if (array1[i] == array2[j]) {
                    ans = true;
                }
            }
            if (!ans) {
                return false;
            }
            ans = false;
        }
        //Check if array 2 contain the same numbers as array 1
        ans = false;
        for(int i = 0; i < array2.length; i++){
            for(int j = 0; j < array1.length; j++){
                if (array2[i] == array1[j]) {
                    ans = true;
                }
            }
            if (!ans) {
                return false;
            }
            ans = false;
        }
        return true;
    }

    public static boolean isSorted(int [] array) {
        // Check if the array is sorted increasingly
        boolean increasingly = true;
        for(int i = 0; i < array.length -1 && increasingly; i++){
            if (array[i] <= array[i + 1]) {
                increasingly = true;
            }else{
                increasingly = false;
            }
        }
        // Check if the array is sorted decreasingly
        boolean decreasingly = true;
        for(int j = 0; j < array.length -1 && decreasingly; j++){
            if (array[j] >= array[j + 1]) {
                decreasingly = true;
            }else{
                decreasingly = false;
            }
        }
        if (decreasingly) {
            return decreasingly;
        }else{
            return increasingly;
        }
    }

}
