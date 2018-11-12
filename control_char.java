/*
 * Programming Language Structures - Assignment 6 - Java version
 * -------------------------------------------------------------
 * Author: Kathleen Near
 * Course: CSC471-M01
 * Date: 10/29/18
 * 
 * Description:
 * You are given data that has been through a "backup" program which, at times, added extraneous data.
 * This added data has a pattern: it ALWAYS starts with a CONTROL-C and ends in a CONTROL-B.
 * After the CONTROL-C, there may be more Control-C characters as part of the extraneous data.
 * Write programs in PERL, JAVA, and PYTHON which remove these values from the text file.
 */

import java.io.*;
import java.util.*;
import java.lang.*;
import java.io.IOException;

public class control_char {

    public static void main(String[] args) {
	String filename = "control-char.txt";
        Remove_Ctrl_Chars(filename);
    }
    
    /* Method reads a file character by character and writes the contents to a new file "temp.txt" 
     * extraneous data following the pattern: starts with CONTROL-C and ends in a CONTROL-B, is omitted
     * 
     * @param filename	the name of the input file (String)
     */
    public static void Remove_Ctrl_Chars(String filename) {
	try {
		File inputFile = new File(filename);
		File writeFile = new File("temp.txt");
        	BufferedWriter bw = new BufferedWriter(new FileWriter(writeFile));
		BufferedReader br = new BufferedReader(new FileReader(inputFile));

		int input;
		boolean flag = false;	//flag is used to disable writing when extraneous data is found
		while((input = br.read()) != -1 /*EOF*/) {
			char c = (char) input;
			if (c == 3) //ASCII value for CONTROL-C
				flag = true;	//Do not write
			else if (c == 2) //ASCII value for CONTROL-B
				flag = false;	//Enable writing
			else
				if(!flag) bw.write(c);
			bw.flush();
		}
		//close reader & writer
		bw.close();
		br.close();
		System.out.println("File operation successful");

	} catch (IOException e) {
		e.printStackTrace();
	}
    }
}
