package dp;

import java.util.Scanner;

public class N11055 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n+1];
		int dp[] = new int[n+1];
		int sum[] = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		for(int i=1; i<=n; i++) {
			dp[i] = 1;
		}
		for(int i=1; i<=n; i++) {
			sum[i] = arr[i];
		}
		
		for(int i=2; i<=n; i++) {
			for(int j=1; j<i; j++) {
				if(arr[j]<arr[i] && dp[i]<=dp[j]) {
					dp[i] = dp[j]+1;
				}
				if(dp[i]>dp[j] && arr[i]>arr[j]) {
					if(sum[i]< sum[j]+arr[i]) {
						sum[i] = sum[j]+arr[i];
					}
				}
			}
		}
		
		int max =0;
		for(int i=1; i<=n; i++) {
			max = Math.max(max, sum[i]);
		}
		System.out.println(max);
	}

}
