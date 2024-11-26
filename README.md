# Bulls&Cows

Introduction

Bulls and Cows is a number-guessing game where one player thinks of a secret number, and the other player tries to guess it. The porject was made as my first assigment in "Intro to Java" course a Ariel University.
The feedback for each guess includes:

Bulls: Correct digits in the correct positions.
Cows: Correct digits in the wrong positions.
This project provides an automated solver for the game using logical filtering and a systematic guessing algorithm.

How It Works
Initialization:

The bot generates a guess using the MakeAGuess function.
It initializes a boolean array to track all potential solutions.
Gameplay Loop:

The bot submits its guess and receives feedback (Bulls & Cows).
Based on the feedback, the bot eliminates invalid solutions using the filter function.
Guess Refinement:

The bot selects the next possible solution from the refined list and repeats the process until the correct number is found.
Result Analysis:

The solver tracks the number of guesses needed and calculates the average performance for 100 games per digit length.
Performance
The bot achieves the following average number of guesses across different code lengths:

Code Length	Average Guesses:

2 Digits	5

3 Digits	7

4 Digits	7

5 Digits	8

6 Digits	8


Ex1Test:

Unit Testing for Bulls & Cows Auto Bot Solver
The Ex1Test file contains unit tests for key functions of the Bulls & Cows Auto Bot Solver, ensuring their correctness using JUnit 5.


Tests Overview
NumberAvgMachine

Purpose: Verifies the average number of guesses required for different code lengths (2-6 digits).
Output: Prints the average guess count for code lengths 2 through 6.
plaintext
Copy code
The TOTAL Avg of 2-6 is: 7.0  
makeAGuessTest

Purpose: Tests the MakeAGuess function by checking if it generates a correct guess for 5 digits.
Assertion: Verifies the generated array matches [0, 1, 2, 3, 4].
trueTest

Purpose: Validates the trueTest function by comparing a guess with a secret number.
Scenario: Guess: {2, 4, 1, 5} vs. Secret: {1, 2, 3, 4}.
Expected Outcome: 0 Bulls, 3 Cows.
plaintext
Copy code
Bulls: 0 Cows: 3  
