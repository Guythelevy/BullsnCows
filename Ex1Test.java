import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class Ex1Test {

    @Test
    public void NumberAvgMachine() //The function for testing 100 Games average for [2-6]

    {
        double TwoDigits = Ex1.AvgMachine(2);
        double ThreeDigits = Ex1.AvgMachine(3);
        double FourDigits = Ex1.AvgMachine(4);
        double FiveDigits = Ex1.AvgMachine(5);
        double SixDigits = Ex1.AvgMachine(6);

        double TotalSum=TwoDigits+ThreeDigits+FourDigits+FiveDigits+SixDigits;
        double TotalAvg=TotalSum/5;

        System.out.println("*");
        System.out.println("*");
        System.out.println("*");

        System.out.println("The TOTAL Avg of 2-6 is: "+TotalAvg);

    }


    @Test
    void makeAGuessTest()
    {
        int[] checkerArr={0,1,2,3,4};
        assertArrayEquals(checkerArr,Ex1.MakeAGuess(5));
    }


    @Test
    void trueTest() {

        System.out.println("Guess is: {2, 4, 1, 5}");
        int[] guess = {2, 4, 1, 5};

        System.out.println("The Number is: {1, 2, 3, 4} ");
        int[] curr = {1, 2, 3, 4};

        System.out.println("Expected outcome: 0 Bulls and 3 Cows");
        int[] outcome={0,3};

        int[] result = Ex1.trueTest(curr, guess);
        System.out.println("Bulls: "+result[0]+" Cows:"+result[1]);


        assertArrayEquals(Ex1.trueTest(curr,guess),outcome);

    }

}