/* Author: Kathleen Near
 * Date: 10/1/2018
 *
 * Problem description:
 * Write the Java equivalent of the provided Ada code complete with error handling.
 *
 * Input: A series of integer values followed by an invalid entry (0 > n > 100)
 * Output: A distribution of grade frequencies grouped by value (0-9, 10-19, ..., 90-100)
 */

import java.util.Scanner;

public class grade_distribution {

    public static void main(String[] args) {
    
        Scanner scan = new Scanner (System.in);
        int[] Freq = new int[10];       //Java array elements default to zero
        int newGrade = 0;               //Local variables must be initialized
        int index = 0;
        int limit_1 = 0;
        int limit_2= 0;
        
        try{
            while(true){    //Grade_Loop
                newGrade = scan.nextInt();
                if(newGrade < 0)    //newGrade must be a natural number (0, 1, ... n)
                    throw new IllegalArgumentException("Error -- new grade must be a natural number");

                index = newGrade/10;
                if(index > 9) {     //A score of 100 is to be grouped with the grade range 90-99
                    if(newGrade == 100) { 
                        Freq[9]++;
                        continue;
                    } else {        //newGrade > 100 is not accepted
                    	throw new ArrayIndexOutOfBoundsException("Error -- new grade: " + newGrade + " is out of range");
                    }
                }
                Freq[index]++;
            }
        } catch(Exception e) {
            System.out.println(e.toString());   //Output error name & message
            
            System.out.println("Limits    Frequency");
            for(index = 0; index < 10; index++) {
                 //Calculate grade ranges & output contents of the frequency distribution array
            	 limit_1 = 10 * index;
            	 limit_2 = limit_1 + 9;
            	 if(index == 9)
            		 limit_2 = 100;
            	 
            	 System.out.println(limit_1 + " " + limit_2 + "\t\t" + Freq[index]);
            }
        }
        try {
            scan.close();
        } catch(Exception e) {}
        
        System.exit(0);
    }
}
