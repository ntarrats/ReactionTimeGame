package reactiongamev3;

import java.util.Random;
import java.util.Scanner;

public class ReactionGameV3 {
    public static void main(String[] args) {
        final int MAX_PLAYS = 5;
        long reactionSpeedAvg = 0;
        boolean isPlaying = true;
        long[] speeds;
        speeds = new long[5];
        int count = 0;   
        
        while (count < MAX_PLAYS && isPlaying == true) {
            int waitTime;
            long initialTime, reactionTime, inputTime = 0;
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

            if (count < MAX_PLAYS) {
                System.out.println("Would you like to play again? (y/n)");
                
                if (scan.next().equalsIgnoreCase("y")) {
                System.out.println("Alright, let's play again.");
                }
                else {
                System.out.println("Thanks for playing. Goodbye.");
                isPlaying = false;
                scan.close();
                }
            }
        }
        for (int i = 0; i < speeds.length; i++) {
            reactionSpeedAvg = reactionSpeedAvg + speeds[i];
        }
        reactionSpeedAvg = reactionSpeedAvg/count;
        System.out.println("Ending count: " + count);
        System.out.println("Reaction Times:" +
                            "\n1. " + speeds[0] + " ms\n2. " + speeds[1] +
                            " ms\n3. " + speeds[2] + " ms\n4. " + speeds[3] +
                            " ms\n5. " + speeds[4] +
                            " ms\nAverage Speed: " + reactionSpeedAvg + " ms");
    }
}
