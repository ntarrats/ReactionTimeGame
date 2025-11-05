/*******************************************************************************
 * Author: Nicolas Tarrats
 * FileName: ReactionTimeGame.java
 * Purpose: Demonstrates usage of system clock data grabbing + variable storage
 *
 * Pseudocode
 * Wait random time
 * Output "Press 'enter' now"
 *      Record system time in double initialTime
 * Scan for user's enter input
 *      Record system time in double inputTime
 * Calculate user's reaction time using formula "inputTime - initialTime"
 *      Record in double reactionTime
 * Output reaction time to user
 *
 ******************************************************************************/
import java.util.*;

public class ReactionTimeGame {
    public static void main(String[] args) {
        boolean isPlaying = true;
        int count = 0;
        long[] speeds;
        speeds = new long[5];
        while (isPlaying == true && count <= 4) {
            int waitTime;
            long initialTime;
            long inputTime=0;
            long reactionTime;
            double waitTimeInSeconds;
            Random gen = new Random();
            Scanner scan = new Scanner (System.in);
            waitTime = gen.nextInt(4000)+1000;

            System.out.println("Get ready!");

            try {
                Thread.sleep(waitTime);
            }
            catch(Exception e) {}

            System.out.println("PRESS ENTER NOW!!!");
            initialTime = System.currentTimeMillis();

            if (scan.hasNextLine()) {
                inputTime = System.currentTimeMillis();
            }

            waitTimeInSeconds = (double)waitTime/1000;
            System.out.printf("The initial wait time was %.2f s\n",waitTimeInSeconds);

            reactionTime = inputTime - initialTime;
            
            speeds[count] = reactionTime;
            ++count;
            
            System.out.println("Your reaction time is " + reactionTime + " ms");
            
            if (count <= 4) { 
                System.out.println("Would you like to play again? (y/n)");
                
                if (scan.next().equalsIgnoreCase("y")) {
                System.out.println("Alright, let's play again.");
                }
                else {
                System.out.println("Thanks for playing. Goodbye.");
                isPlaying = false;
                }
            }
        }
        long reactionSpeedAvg = (speeds[0] + speeds[1] + speeds[2] + speeds[3] + 
                speeds[4])/5;
        System.out.println("Reaction Times:" +
                            "\n1. " + speeds[0] + " ms\n2. " + speeds[1] +
                            " ms\n3. " + speeds[2] + " ms\n4. " + speeds[3] +
                            " ms\n5. " + speeds[4] +
                            " ms\nAverage Speed: " + reactionSpeedAvg + " ms");
    }
}
