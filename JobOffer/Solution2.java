import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution2 {
/*
     * Complete the function below.
     */
    static int[] jobOffers(int[] scores, int[] lowerLimits, int[] upperLimits) {
        int[] totalCandidates = {0};
        int queries;
        
        if(lowerLimits.length != upperLimits.length){
            System.out.println("Execution Exception");
            return totalCandidates;
        }
        queries = lowerLimits.length;
        totalCandidates = new int[queries];
        //queries
        for(int i = 0; i < queries; i++){
            int selected = 0;
            //scores
            for(int j = 0; j < scores.length; j++){
                if(scores[j] >= lowerLimits[i] && scores[j] <= upperLimits[i]){
                    selected++;
                }
                totalCandidates[i] = selected;
            }
        }
        
        return totalCandidates;
    }
public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = null;
        if (fileName != null) {
            bw = new BufferedWriter(new FileWriter(fileName));
        }
        else {
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        int[] res;
        int scores_size = 0;
        scores_size = Integer.parseInt(in.nextLine().trim());

        int[] scores = new int[scores_size];
        for(int i = 0; i < scores_size; i++) {
            int scores_item;
            scores_item = Integer.parseInt(in.nextLine().trim());
            scores[i] = scores_item;
        }

        int lowerLimits_size = 0;
        lowerLimits_size = Integer.parseInt(in.nextLine().trim());

        int[] lowerLimits = new int[lowerLimits_size];
        for(int i = 0; i < lowerLimits_size; i++) {
            int lowerLimits_item;
            lowerLimits_item = Integer.parseInt(in.nextLine().trim());
            lowerLimits[i] = lowerLimits_item;
        }

        int upperLimits_size = 0;
        upperLimits_size = Integer.parseInt(in.nextLine().trim());

        int[] upperLimits = new int[upperLimits_size];
        for(int i = 0; i < upperLimits_size; i++) {
            int upperLimits_item;
            upperLimits_item = Integer.parseInt(in.nextLine().trim());
            upperLimits[i] = upperLimits_item;
        }

        res = jobOffers(scores, lowerLimits, upperLimits);
        for(int res_i = 0; res_i < res.length; res_i++) {
            bw.write(String.valueOf(res[res_i]));
            bw.newLine();
        }

        bw.close();
    }
}