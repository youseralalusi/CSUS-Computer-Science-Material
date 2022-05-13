/*
 * Youser Alalusi
 * 12-03-2021
 * CSC 138 - 01 Programming 4
 */

import java.util.Scanner;
public class Prog4
{
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int n;
            String packets;
            //print the input 
            System.out.println("Input: ");
            //take user input for number of packets 'n'
            n = in.nextInt();   
          //take string input for packets to make length of packets divisible by 3
            packets = in.next();   
          //if remainder is 1
            if (n%3 == 1)         
            	//add 2 '#' characters
            	packets+="##"; 
          //if remainder is 2
            else if (n%3 == 2)   
            	//add 1 '#' characters
                packets+="#";   
           //print the output
           System.out.println("Output: ");
         //use outer for loop to select buffer of size 3 and inner for loop to iterate over the buffer
            for(int i = 0; i < n; i+=3){     
            	// iterate over the buffer and print packets that has 'High priority' 
                for(int j = 0; j < 3; j++){       
                	//if packet at index=i+j == 'H' 
                    if(packets.charAt(i + j)=='H')  
                    	//print its index 
                        System.out.print((i + j) + " ");  
                }
                //repeat the inner for loop, this time to print the index of packets with 'Low priority'
                for(int j = 0; j < 3; j++){
                    if(packets.charAt(i + j)=='L')
                        System.out.print((i + j)+" ");
                }
            }
        }
}
