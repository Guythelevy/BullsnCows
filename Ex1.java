import java.util.*;


/**
 * Introduction to Computer Science, Ariel University, Ex1 (manual Example + a Template for your solution)
 * See: https://docs.google.com/document/d/1C1BZmi_Qv6oRrL4T5oN9N2bBMFOHPzSI/edit?usp=sharing&ouid=113711744349547563645&rtpof=true&sd=true
 * <p>
 * Ex1 Bulls & Cows - Automatic solution.
 * ** Add a general readme text here **
 * Add your explanation here:
 * <p>Found below.
 * <p>
 * ** General Solution (algorithm) **
 * Add your explanation here:
 * <p> First, a guess is generated using the MakeAGuess function. an array is intilizied to track all possible solutions.
 * <p> We play the guess and count our Bulls & Cows, then we update our array accordingly.
 * <p> Then we roll another guess from the arr, count bulls and cows,update our array, and so on, untill we get our solution.
 * ** Results **
 * Make sure to state the average required guesses
 * for 2,3,4,5,6 digit code:
 * <p>
 * Average required guesses 2: 5
 * Average required guesses 3: 7
 * Average required guesses 4: 7
 * Average required guesses 5: 8
 * Average required guesses 6: 8
 */
public class Ex1 {
    public static final String Title = "Ex1 demo: manual Bulls & Cows game";

    public static void main(String[] args) {
        BP_Server game = new BP_Server();   // Starting the "game-server"
        long myID = 322317918;
        int numOfDigits = 6;
        GlobalNumOfDigits=numOfDigits;
        game.startGame(myID, numOfDigits);  // Starting a game
        System.out.println(Title + " with code of " + numOfDigits + " digits");
        //manualEx1Game(game);

        autoEx1Game(game); // you should implement this function )and any additional required functions).
    }


    public static double AvgMachine (int numOfDigits) //This is the loop for canculating the 100 games average
    {
        BP_Server game = new BP_Server(); //Function is called upon in the Test File
        long myID = 322317918;
        GlobalNumOfDigits=numOfDigits;
        game.startGame(myID, numOfDigits);
        System.out.println(Title + " with code of " + numOfDigits + " digits");

        for (int i = 0; i < 100; i++) {
            autoEx1Game(game);
            GuessNumArray[i] = GuessNum;
            System.out.println("inputed GuessNum:"+GuessNum+" in place:"+i);
        }

        int ArraySum=0;
        for (int i = 0; i <GuessNumArray.length ; i++) {
            ArraySum=ArraySum+GuessNumArray[i];
        }

        GuessNum=0;
        double GuessAverage=ArraySum/100.0;
        System.out.println("The Average Of 100 games with "+numOfDigits+" digits is: "+GuessAverage);

        return GuessAverage;
    }


    public static void manualEx1Game(BP_Server game) {
        Scanner sc = new Scanner(System.in);
        int ind = 1;      // Index of the guess
        int numOfDigits = 5;
        double max = Math.pow(10, numOfDigits);
        while (game.isRunning()) {           // While the game is running (the code has not been found yet
            System.out.println(ind + ") enter a guess: ");
            int g = sc.nextInt();
            if (g >= 0 && g < max) {
                int[] guess = toArray(g, numOfDigits); // int to digit array
                int[] res = game.play(guess); // Playing a round and getting the B,C
                if (game.isRunning()) {     // While the game is running
                    System.out.println(ind + ") B: " + res[0] + ",  C: " + res[1]); // Prints the Bulls [0], and the Cows [1]
                    ind += 1;               // Increasing the index
                }
            } else {
                System.out.println("ERR: wrong input, try again");
            }
        }
        System.out.println(game.getStatus());
    }


    /**
     * Simple parsing function that gets an int and returns an array of digits
     *
     * @param a    - a natural number (as a guess)
     * @param size - number of digits (to handle the 00 case).
     * @return an array of digits
     */
    private static int[] toArray(int a, int size) { //this function converts an integer to an array of digits
        int[] c = new int[size];
        for (int j = 0; j < c.length; j += 1) {
            c[j] = a % 10;
            a = a / 10;
        }
        return c;
    }
////////////////////////////////////////////////////


    /**
     * This function solves the Bulls & Cows game automatically.
     * You should implement
     * ** Add a specific explanation for each function **
     */




    public static int OptionGenerator(boolean[] arr) { //this function searches for the the last 'true' in the array, if theres none, it returns -1
        int ans = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]) {
                ans = i;
            }
        }
        return ans;

    }

    public static void filter(boolean[] arr, int[] g, int[] r, int DigitNum) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]) {
                int[] Correct = toArray(i, DigitNum);
                int[] mr = trueTest(Correct, g);
                if (mr[0] != r[0] || mr[1] != r[1]) { //checks that we got the needed result
                    arr[i] = false; //elimnates this possibility
                }
            }
        }
    }



    public static int[] trueTest(int[] curr, int[] guess) { //function for checking the bulls&cows
        int bulls = 0;
        int cows = 0;
        int[] guess1 = Arrays.copyOf(guess, guess.length);
        int[] curr1 = Arrays.copyOf(curr, curr.length);
        int[] BullsCowsArray = new int[2];


        for (int i = 0; i < curr1.length; i++) {
            if (guess1[i] == curr1[i] && curr1[i] != -1 && guess1[i] != -1) { //Checks our Bulls&Cows

                bulls++; //Bulls Counter
                guess1[i] = -1; //makes sure we wont hit it again
                curr1[i] = -1;
            }
        }

        for (int i = 0; i < curr1.length; i++) {
            for (int j = 0; j < guess1.length; j++) {
                if (i != j && curr1[i] == guess1[j] && curr1[i] != -1 && guess1[j] != -1) {

                    cows++; //Cows Counter
                    guess1[j] = -1;//makes sure we wont hit it again
                    curr1[i] = -1;
                }
            }
        }
        BullsCowsArray[0] = bulls; // inputs the bulls
        BullsCowsArray[1] = cows; // inputs the cows
        return BullsCowsArray;
    }
    public static int[] MakeAGuess(int numOfDigits) { //this function generates a guess according to our played digits num
        int []guess=new int[numOfDigits];
        for (int i = 0; i < numOfDigits; i++) {
            guess[i] = i;
        }
        return guess; //returns the guess
    }


    public static int GlobalNumOfDigits;//this are for a global AVG function
    public static int[] GuessNumArray=new int[100];
    public static int GuessNum=0;
    public static void autoEx1Game(BP_Server game) {
        int ind = 1;
        int DigitNum=game.getNumOfDigits();
        int[] guess = MakeAGuess(game.getNumOfDigits()); //generats a guess
        int ArraySize = (int) Math.pow(10, DigitNum); //amount of available options for the number
        boolean Arr[] = new boolean[ArraySize];
        for (int i = 0; i < Arr.length; i++) {
            Arr[i] = true;
        }

        while (game.isRunning()) {
            System.out.println(Arrays.toString(guess)); //prints the guess
            int[] Res = game.play(guess);
            filter(Arr, guess, Res, DigitNum); //filters the not needed options
            guess =toArray(OptionGenerator(Arr),DigitNum);
            GuessNum++; //this is a global Integer that checks the guess num
            if(ind>10) {
                break;
            }
            if (game.isRunning()) {
                System.out.println(ind + ") B: " + Res[0] + ",  C: " + Res[1]);
                ind += 1;
            }
        }
        System.out.println(game.getStatus());
    }

}


