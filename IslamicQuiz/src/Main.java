import java.util.Scanner;
/* Firstly, we will import java.util.Scanner which is one of
Java's classes that is essential for taking user's input via the console.
It allows interactive interaction between the user
and the program by allowing it to pause execution
and wait for the user to type something in.*/

public class Main {
//The above line represents this program which conduct a quiz game.

    public static void main(String[] args) {
        System.out.println("Welcome to the Islamic Quiz!");
        System.out.println("Please answer the following questions:");
        //The above two lines displays a welcome message for the user before starting the quiz.

        // Then, we will define the questions and their correct answers.
        String[][] questions = {
                {"What is the first pillar of Islam?", "A. Salah", "B. Shahadah", "C. Zakat", "D. Hajj"},
                {"What is the name of the Islamic holy book?", "A. Torah", "B. Bible", "C. Quran", "D. Psalms"},
                {"Who is the last prophet of Islam?", "A. Muhammad", "B. Jesus", "C. Moses", "D. Abraham"},
                {"What is the direction of prayer for Muslims?", "A. Towards the South", "B. Towards the East", "C. Towards the North", "D. Towards the Kaaba"},
                {"What is the name of the Islamic fasting month?", "A. Ramadan", "B. Shawwal", "C. Dhul Hijjah", "D. Muharram"},
        };
        String[] correctAnswers = {"B", "C", "A", "D", "A"};
         /*This declaration creates an array of arrays, where each inner array represents
        a single question and its associated options. */

        int score = 0;//This variable is used to keep track of the user's score as they answer questions in the quiz.

        Scanner scanner = new Scanner(System.in);
        /*The above line This line prepares the scanner object to read input from the user during the quiz game,
        enabling the program to gather user responses for each question. */

        for (int i = 0; i < questions.length; i++) {
            System.out.println((i + 1) + ". " + questions[i][0]);
            for (int j = 1; j < questions[i].length; j++) {

                System.out.println("   " + questions[i][j]);
            }
        /*The above code snippet allows the program to sequentially display each questions along with it corresponding
        answers options for the user*/


            System.out.print("Enter your answer (A, B, C, or D): ");
            // This will ask the user for their answer.

            char userAnswer = scanner.next().toUpperCase().charAt(0);
            /*This convert the user's input to uppercase for comparison, which means even if the user input is in lowercase letter,
            this will convert to the uppercase.*/

            switch (userAnswer) {  //The switch statement checks the value of userAnswer.
                case 'A':
                case 'B':
                case 'C':
                case 'D':
                    //If userAnswer is 'A', 'B', 'C', or 'D', it executes the corresponding case.
                    if (userAnswer == correctAnswers[i].charAt(0)) {
                        score++;
                        System.out.println("Correct!");
                    /*Check if the user's answer matches the correct answer for the current question
                    If it matches, increment the score and display Correct!*/
                    } else {
                        System.out.println("Incorrect. The correct answer is " + correctAnswers[i] + ".");
                        // If the user's answer does not match the correct answer, displays the correct answer
                    }
                    break; //Exitng the switch case after the process
                default:
                    // If the userAnswer is not A, B, C, or D, execute this block of code
                    System.out.println("Invalid input. Please enter A, B, C, or D.");
                    i--; //Repeats the current question if the input is invalid
                    break;
            }

            System.out.println(); //Line-breaker for the clarity
        }

        scanner.close();  // Close the scanner

        // Calculate and display the final score in percentage as instructed.
        double percentage = (double) score / questions.length * 100;
        System.out.println("Your final score is " + score + " out of " + questions.length + " (" + percentage + "%)");
    }
}
