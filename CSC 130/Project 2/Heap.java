/**
 * Youser Alalusi
 * 12/14/2020
 * Heap
 */

import java.util.*;
import java.io.*;

class Heap

{
	public static void main( String args[]) throws FileNotFoundException, IOException

	{

		//initialize priority queue Object
		//priority queues can be used directly for min heaps
		PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();

		//declare and initialize file object
		File file = new File("demo.txt");

		//initialize buffered reader object
		BufferedReader br = new BufferedReader(new FileReader(file));

		//declare string object to store the data read from file
		String st ;

		//string array to store the split characters
		String[] sArr = new String[100];

		//integer array to store the string array as integers by converting them
		int[] iArr = new int[100];

		//read line by line
		while ((st = br.readLine()) != null)

		{

			//split using ','
			sArr = st.split(",");

		}

		//store as integer in integer array
		for(int i=0;i<sArr.length;i++)

		{

			iArr[i] = Integer.parseInt(sArr[i]);
			pQueue.add(iArr[i]);

		}

		// Print all the elements
		System.out.println("Status of heap:");

		//variable for level
		int count = 1;

		//iterator to iterate over priority queue
		Iterator it1 = pQueue.iterator();
		while (it1.hasNext())

		{

			System.out.println("Level " + (int)Math.floor(Math.log(count)/Math.log(2)) + ": " + it1.next());
			count++;

		}

		//now deleting 5 elements
		int itrCount = 1;
		while(itrCount <= 5)

		{

			//poll function of priority queue can be used for deleting the topmost(min) element
			pQueue.poll();
			System.out.println("After removing " + itrCount + " root element(s): ");

			// Print all the element
			System.out.println("Status of heap:");

			//iterator to iterate over priority queue
			Iterator<Integer> it2 = pQueue.iterator();

			//variable for level
			count = 1;
			while (it2.hasNext())

			{

				System.out.println("Level " + (int)Math.floor(Math.log(count)/Math.log(2)) + ": " + it2.next());
				count++;

			}

			itrCount++;

		}

	}

}