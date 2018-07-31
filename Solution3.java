 import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution3 {
 static int[] totalCandidates = {0};
    static int totalThreads = 0;

    static int[] jobOffers(int[] scores, int[] lowerLimits, int[] upperLimits) {
        int queries;
        ArrayList<Thread> arrThreads = new ArrayList<Thread>();
        
        //Validation
        if(lowerLimits.length != upperLimits.length){
            System.out.println("Execution Exception");
            return totalCandidates;
        }
        queries = lowerLimits.length;
        totalCandidates = new int[queries];
        final int maxThread = 2;
        
        try{
            for(int i = 0; i < queries; i++){
                if(totalThreads < maxThread){
                    JobTask jobTask = new JobTask(i, scores, lowerLimits[i], upperLimits[i]);
                    Thread threadQuerie = new Thread(jobTask);
                    totalThreads++;
                    threadQuerie.start();
                    arrThreads.add(threadQuerie); 
                } else {
                    i--;
                }
               
            }
            
            //Wait thread ends
            for (int i = 0; i < arrThreads.size(); i++) {
                arrThreads.get(i).join(); 
            }
        } catch(Exception e){
            System.out.println("Error!");
            System.out.println(e.getStackTrace());
        }
        
        return totalCandidates;
    }

/*----------------------------------------------------------------------------- */
    public static class JobTask implements Runnable {

        int i; 
        int[] scores; 
        int lowerLimit; 
        int upperLimit;

        public JobTask( int i, int[] scores, int lowerLimit, int upperLimit) {
            System.out.println("New Thread for query: " + i);
            this.i = i;
            this.scores = scores;
            this.lowerLimit = lowerLimit;
            this.upperLimit = upperLimit;
        }

        @Override
        public void run() {

            int selected = 0;
            for(int j = 0; j < scores.length; j++){
                if(scores[j] >= lowerLimit && scores[j] <= upperLimit){
                    selected++;
                }
            }
            System.out.println("Query " + i +" has " + selected + " Candidates");
            totalCandidates[i] = selected;
            totalThreads--;
        }
    }
}