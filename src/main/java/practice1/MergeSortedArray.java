package practice1;

import java.util.Arrays;

public class MergeSortedArray {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		System.arraycopy(nums2, 0, nums1, m, n);
		Arrays.sort(nums1);
	}

	//利用额外的空间，两个数组都从前往后比较，谁小放谁
	public void merge1(int[] nums1, int m, int[] nums2, int n) {
		int[] nums1_copy = new int[m];
		System.arraycopy(nums1, 0, nums1_copy, 0, m);
		int index1 = 0;
		int index2 = 0;
		int now = 0;
		while((index1<m) && (index2<n)) {
			nums1[now++] = nums1_copy[index1]<nums2[index2] ? nums1_copy[index1++] : nums2[index2++];
		}
		if(index1<m) {
			System.arraycopy(nums1_copy, index1, nums1, now, m-index1);
		}
		if(index2<n) {
			System.arraycopy(nums2, index2, nums1, now, n-index2);
		}
	}

	//不用多余的空间，从后往前走
	public void merge2(int[] nums1, int m, int[] nums2, int n) {
		int index1 = m-1;
		int index2 = n-1;
		int now = m+n-1;
		while((index1>=0) && (index2>=0)) {
			nums1[now--] = nums1[index1]>nums2[index2] ? nums1[index1--] : nums2[index2--];
		}
		if(index2>=0) {
			System.arraycopy(nums2, 0, nums1, 0, index2+1);
		}
		
	}

	public void sor() {
		int[] a = new int[7];
		a[0] = 1; a[1] = 2;
		int[] b = { 1,2, 3, 5, 6 };
		// merge(a, 3, b, 4);
		merge2(a, 2, b, 5);
		for (int num : a) {
			System.out.println(num);
		}
	}
}
