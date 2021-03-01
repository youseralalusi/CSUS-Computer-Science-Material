 /**
 * Youser Alalusi
 * CSC 130 - Radix Sort Lab
 * 10/8/2020
 */
import java.util.Arrays;
//class
class Radix{
	static int getMax(int arr[], int n)
	{
		int mx = arr[0];
		for (int i = 1; i < n; i++)
			if (arr[i] > mx)
				mx = arr[i];
		return mx;
	}

	static void countSort(int arr[], int n, int exp)
	{
		int output[] = new int[n]; // output array
		int i;
		int count[] = new int[10];
		Arrays.fill(count,0);

		for (i = 0; i < n; i++)
			count[ (arr[i]/exp)%10 ]++;

		for (i = 1; i < 10; i++)
			count[i] += count[i - 1];

		for (i = n - 1; i >= 0; i--)
		{
			output[count[ (arr[i]/exp)%10 ] - 1] = arr[i];
			count[ (arr[i]/exp)%10 ]--;
		}

		for (i = 0; i < n; i++)
			arr[i] = output[i];
	}

	static void radixsort(int arr[], int n)
	{
		int m = getMax(arr, n);

		for (int exp = 1; m/exp > 0; exp *= 10)
			countSort(arr, n, exp);
	}


	static void print(int arr[], int n)
	{
		for (int i=0; i<n; i++)
			System.out.print(arr[i]+" ");
	}
	static void reverse(int a[], int n)
	{
		int[] b = new int[n];
		int j = n;
		for (int i = 0; i < n; i++) {
			b[j - 1] = a[i];
			j = j - 1;
		}

		//printing the reversed array
		for (int k = 0; k < n; k++) {
			System.out.print(b[k]+" ");
		}
	}

	//main method
	public static void main (String[] args)
	{
		int arr[] = {170, 45, 75, 90, 802, 24, 2, 66};
		int n = arr.length;
		System.out.println("Original Array");
		for (int i=0; i<n; i++)
			System.out.print(arr[i]+" ");
		System.out.println("\nAscending Order ");
		radixsort(arr, n);
		print(arr, n);
		int arr1[] = {170, 45, 75, 90, 802, 24, 2, 66};
		System.out.println("\nOriginal Array");
		for (int i=0; i<n; i++)
			System.out.print(arr1[i]+" ");
		System.out.println("\nDescending Order ");
		radixsort(arr, n);
		reverse(arr, n);
	}
}