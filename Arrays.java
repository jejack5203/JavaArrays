/*
Jodie Jackson
Java Arrays
*/

public class Arrays {
    public static void main(String[] args) {
        if (args.length < 3) { //checks to make sure atleast 3 arguments are entered
            System.out.println("Error! needs at least 3 arguments");
            System.exit(-1);
        }
        String input = args[0]; 

        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
        System.out.println();

        StringBuilder concatArgs = new StringBuilder(); //create a stringbuilder to concatenate the array of strings with spaces
        for (int i = 0; i < args.length; i++) {
            concatArgs.append(args[i]);
            if (i < args.length - 1) {
                concatArgs.append(" ");
            }
        }
        System.out.println("After concatenation: "); 
        System.out.println(concatArgs.toString());
        System.out.println();

        sortAlg(args, 0, args.length - 1); //calls sorting algorithm method to sort the array of inputs

        System.out.println("Sorted array: ");

        for (int i = 0; i < args.length; i++) {
            System.out.print(args[i] + " ");
        }
        System.out.println();
        StringBuilder copyArrayinSB = new StringBuilder(); //creates a stringbuilder to copy array elements
        for(int i = 0; i < args.length; i++){
        	String copyArray = args[i];
        	copyArrayinSB.append(copyArray).append(" ");
        }
        System.out.println();
        System.out.println("Array String Builder: "); 
        String[] words = copyArrayinSB.toString().split(" "); //split the stringbuilder into individual words
        for(int i = 0; i < words.length; i++){
        	System.out.println(words[i]);
        }
        	System.out.println();
        	System.out.println("Concatentated String Builder: ");
        	System.out.println(copyArrayinSB.toString()); //concatenate that split stringbuilder
        
    }

    public static void sortAlg(String[] arr, int left, int right) { //algorithm to sort a array of strings 
        if (left < right) { //check if array has more than 1 input 
            int mid = (left + right) / 2; //finding the middle index
            sortAlg(arr, left, mid); // uses recursive method to sort the left and right halves
            sortAlg(arr, mid + 1, right);
            combineArr(arr, left, mid, right); //merge together both halves
        }
    }

    public static void combineArr(String[] arr, int left, int mid, int right) { //merges 2 sorted arrays into 1 array
        int n1 = mid - left + 1; //represents the size of 2 arrays
        int n2 = right - mid;

        String[] leftArr = new String[n1]; //temp arrays to hold words/values of 2 arrays
        String[] rightArr = new String[n2];

        for (int i = 0; i < n1; ++i) { //copies input into temp arrays
            leftArr[i] = arr[left + i];
        }
        for (int j = 0; j < n2; ++j) {
            rightArr[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) { //merges temp array back into 1 arr
            if (leftArr[i].compareTo(rightArr[j]) <= 0) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < n1) { //copies remaining words of both 2 sorted arrays into the 1 original arr
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }
}
