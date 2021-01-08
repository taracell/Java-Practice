import java.util.*;

public class Questions {
    public static void main(String[] args){
        /*Question 1: Find the Bitwise AND of the array
        System.out.println("Question 1: Find Bitwise AND of the array");
        int num0  = getUserInputNumber();
        //call to array AND function
        System.out.println("BitwiseAND of the array: "+BitwiseAND.findAnd(getUserInputArray(num0)));

        //Question 2.  Find the missing element in an array of sequential numbers
        System.out.println("Question 2: Find the missing number in an array of sequential numbers, numbered 1 <= N");
        int num1 = getUserInputNumber();
        //call to findNumber function
        System.out.println("Find the missing number: "+FindMissingNumber.findNumber(getUserInputArray(num1), num1));

        //Question 3. Find the missing element in a sorted array of consecutive numbers
        System.out.println("Question 3. Find the missing element in a sorted array of consecutive numbers.");
        System.out.println("Enter in the desired length of an array:");
        int num2 = getUserInputNumber();
        //call to find missing element
        System.out.println("missing element for input array is: "+FindMissingNumber.findElement(getUserInputArray(num1), num2)+" (if -1, no missing element found)");

        //Question 4 Write a program to reverse an array or string
        System.out.println("Question 4: Write a program to reverse an array and string");
        //user input int array
        System.out.println("Enter in an integer array: ");
        System.out.println("Enter in the desired length of an array:");
        int num3 = getUserInputNumber();
        //call to reverse int array
        System.out.println("The reverse of your input array is: " + Arrays.toString(Reverse.reverseArray(getUserInputArray(num3), num3)));
        //call to reverse string
        System.out.println("The reverse of your string is: "+Reverse.reverseString(getUserInputString()));

        //Question 5: Given two non-negative long integers, x and y given x <= y, the task is to find bit-wise and of all integers from x and y, i.e., we need to compute value of x & (x+1) & … & (y-1) & y.7
        System.out.println("Question 5: Given two non-negative long integers, x and y given x <= y, the task is to find bit-wise and of all integers from x and y, i.e., we need to compute value of x & (x+1) & … & (y-1) & y.7");
        System.out.println("Enter in the desired range using two numbers, please enter the smallest number first and then the larger number to create a range:");
        int num4 = getUserInputNumber();
        int num5 = getUserInputNumber();
        System.out.println("Your bit-wise & of the range entered is: "+BitwiseAND.findAndOfRange(num4, num5));

        //Question 6: Find the duplicate number on a given integer array.
        System.out.println("Find the duplicate number on a given integer array.");
        System.out.println("Enter in the desired length of an array:");
        int num6 = getUserInputNumber();
        System.out.println("The duplicate number in your array is: " + Duplicate.findDuplicateInArray(
        getUserInputArray(num6), num6)+" (if -1, no missing element found)");

        //Question 7: Solve a postfix equation
        System.out.println("Solve a postfix equation");
        System.out.println("Postfix Eval (enter in something like 231*+9- which evaluates to -4 or 123+*8- which evaluate" +
                "s to -3: "+Solution.evaluatePostFix(getUserInputString()));

*/
        //Question 8: Solve for Coin change given a value N, find the number of ways to make change for N cents, if we have infinite supply of each of S = { S1, S2, .. , SM } valued coins.
        System.out.println("Solve for Coin Change: first enter in 2 numbers, the first to signify the total amount your coins will add to, second how many coins will you have:");
        int num7 = getUserInputNumber();
        int num8 = getUserInputNumber();
        System.out.println("The number of ways change can be given back from the input array is: "+Solution.count(getUserInputArray(num8), num7));


        //Question 9: Modify array by replacing every array element with minimum possible value of arr[j] + |j – i|
        System.out.println("Given an array arr[] of size N, the task is to find a value for each index such that the value at index i is arr[j] + |j – i| where 1 ≤ j ≤ N, the task is to find the minimum value for each index from 1 to N.");
        System.out.println("Enter in the desired length of an array:");
        int num9 = getUserInputNumber();
        System.out.println("The resulting array is: " + Arrays.toString(Solution.getMinimumValue(getUserInputArray(num9), num9)));
    }
    private static int getUserInputNumber(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number:");
        return input.nextInt();
    }

    private static int[] getUserInputArray(int num){
        Scanner input = new Scanner(System.in);
        int [] array = new int[num];
        System.out.println("Enter the " + num + " numbers now, using a space between each number.");

        //traverse through the numbers to input into an array for use
        for (int i = 0 ; i < array.length; i++ ) {
            array[i] = input.nextInt();
        }
        //print array out to check correct storage
        System.out.println("These are the numbers you have entered: " + Arrays.toString(array));
        return array;
    }

    private static String getUserInputString(){
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter in a string/word: ");
        return input.next();
    }

}

class BitwiseAND{
    //function to Find the Bitwise AND of the array
    public static int findAnd(int[] array) {
        int ans = array[0];
        for (int j : array) {
            ans = (ans & j);
        }
        return ans;
    }

    public static int findAndOfRange(int x, int y){
        int ans=x;
        //use while loop to traverse through user input range
        while (x < y){
            x++;
            ans = ans&x;
        }
        return ans;
    }
}

class FindMissingNumber{
    // Function to find
    //So the sum of all n elements, i.e sum of numbers from 1 to n can be calculated using the formula n*(n+1)/2
    public static int findNumber(int[] arr, int num){
        int sum = num+1;
        int sumTotal = sum * (sum+1)/2;
        System.out.println(sumTotal);
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        for (int j : arr) {
            sumTotal = sumTotal - j;
        }
        return sumTotal;
    }

    public static int findElement(int[] array, int num1) {
        Arrays.sort(array);
        int first = 0, last = num1 - 1;
        while (last > first) {
            int middle = first + (last - 1) / 2;
            // is middle element consistent
            if (array[middle] - middle == array[0]) {
                //is the missing number right after the middle number?
                if (array[middle + 1] - array[middle] > 1) {
                    return array[middle] + 1;
                } else {
                    //move right
                    first = middle + 1;
                }
            }else{
                //is missing number right before the middle number?
                if (array[middle] - array[middle - 1] > 1){
                    return array[middle] - 1;
                } else{
                    //move left
                    last = middle -1;
                }
            }
        }
        //No missing element found
        return -1;
    }
}

class Reverse{
    public static int[] reverseArray(int[] array, int num) {
        // assign the first and last numbers
        int first = 0, last = num - 1;
        //use a while loop to continuously cycle through numbers since we don't know how many numbers the user will enter
        while (first < last){
            //store first number of the array as temp
            int temp = array[first];
           // change the first number to the last number
            array[first] = array[last];
            //store the last number to temp file
            array [last] = temp;
            //increment the first number
            first++;
            //decrement the last number
            last --;
        }
        return array;
    }

    public static String reverseString(String string){
        //store the length to an int
        int arrayLength = string.length();
        //use the int to build a new array for the string
        char [] array =  new char[arrayLength];
        //assign string to array reversing the array
        for (int i = 0; i < string.length(); i++){
            array[--arrayLength] = string.charAt(i);
        }
        return new String(array);
    }
}

class Duplicate{
    public static int findDuplicateInArray(int [] array, int num){
        Arrays.sort(array);
        int first = 0, last = num - 1;
        while (last > first) {
            int middle = first + (last - 1) / 2;
            // is middle element consistent
            if (array[middle] - middle == array[0]) {
                //is the duplicate number right after the middle number?
                if (array[middle + 1] == array[middle]) {
                    return array[middle];
                } else {
                    //move right
                    first = middle + 1;
                }
            }else{
                //is duplicate number right before the middle number?
                if (array[middle] == array[middle - 1]){
                    return array[middle];
                } else{
                    //move left
                    last = middle -1;
                }
            }
        }
        //No missing element found
        return -1;
    }
}

class Solution{
    public static int evaluatePostFix(String string){
        Stack<Integer> stack = new Stack<Integer>();
        int result;
        for(int i = 0; i < string.length(); i++) {
            char character = string.charAt(i);
            //if the character at this index is a digit store as an it
            if(Character.isDigit(character)){
                stack.push(Integer.parseInt(String.valueOf(character)));
            } else {
                //character is an operator.  pop 2 digits off the stack and perform the operation then push the result
                // back to the stack
                int number1 = stack.pop();
                int number2 = stack.pop();
                switch (character) {
                    case '+':
                        stack.push(number1 + number2);
                        break;

                    case '-':
                        stack.push(number2 - number1);
                        break;

                    case '/':
                        stack.push(number2 / number1);
                        break;

                    case '*':
                        stack.push(number2 * number1);
                        break;

                    default:
                        System.out.println("Received unsupported operator: " + character);
                        break;
                }
            }
        }
        return stack.pop();
    }

    public static long count(int[] coinValueArray, int coinArraySum) {
        // Create the ways array to 1 plus the amount
        // to stop overflow
        long[] ways = new long[coinArraySum + 1];

        // Set the first way to 1 because its 0 and
        // there is 1 way to make 0 with 0 coins
        ways[0] = 1;

        // Go through all of the coins
        for (int i = 0; i < coinValueArray.length; i++) {

            // Make a comparison to each index value
            // of ways with the coin value.
            for (int j = 0; j < ways.length; j++) {
                if (coinValueArray[i] <= j) {

                    // Update the ways array
                    ways[j] += ways[j - coinValueArray[i]];
                }
            }
        }

        // return the value at the Nth position
        // of the ways array.
        return ways[coinArraySum];
    }

    public static int[] getMinimumValue(int[] array,  int num) {
        //use prefix sum technique
        //array to store values from 0 - num
        int [] temp1 = new int[num];
        temp1[0]=array[0];


        //array to store values from num - 0
        int [] temp2 = new int[num];
        temp2[num - 1] = array[num-1];

        //Traverse the array arr[] from i = 2 to num-1 and calculate min(arr[i], temp1[i-1] + 1).
        for(int i = 1; i < num; i++){
            temp1[i] = Math.min(array[i], temp1[i - 1] + 1);
        }
        System.out.println("temp1: "+Arrays.toString(temp1));

        //Traverse the array arr[] from i = num-1 to 1 and calculate min(arr[i], temp2[i+1] + 1).
        for (int i = num-2; i >= 0; i--){
            temp2[i] = Math.min(array[i], temp2[i + 1] + 1);
        }
        System.out.println("temp2: "+Arrays.toString(temp2));

        //Again traverse the array from 1 to N and print min(temp1[i], temp2[i]) at each iteration.
        int [] array1 = new int[num];
        for (int i = 0; i < num; i++){
            array1[i] = Math.min(temp1[i], temp2[i]);
        }
        return array1;
    }
}