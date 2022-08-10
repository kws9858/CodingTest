package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class 반복문 {
	// 2739		구구단
	public void solution_2739() {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		if(A<1)
			A = sc.nextInt();
		for(int i=1; i<10; i++ ){
			System.out.println(A+" * "+i+" = "+A*i);
		}
	}
	
	// 10950	A+B - 3
	public void solution_10950() {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		if(T<1)
			T = sc.nextInt();
		for(int i=0; i<T; i++ ){
			int A = sc.nextInt();
			int B = sc.nextInt();
			System.out.println(A+B);
		}
	}
	
	// 8393		합
	public void solution_8393() {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		if(T<1||T>10000)
			T = sc.nextInt();
		int cnt=0;
		for(int i=1; i<T+1; i++ ){
			cnt= cnt + i;
		}
		System.out.println(cnt);
	}
	
	// 25304	영수증
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int totalPrice = sc.nextInt();
		int itemNum = sc.nextInt();
		String[] item = new String[itemNum];
		sc.nextLine(); // 개행문자 제거
		for(int i=0; i<itemNum; i++) {
			item[i] = sc.nextLine();
		}
		int sum = 0;
		for(int i=0; i<item.length; i++) {
			String[] temp = item[i].split(" ");
			sum += Integer.parseInt(temp[0]) * Integer.parseInt(temp[1]);
		}
		if(totalPrice == sum)
			System.out.println("Yes");
		else
			System.out.println("No");
		
	}
	
	// 15552	빠른 A+B
	public void solution_15552() {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int n = Integer.parseInt(br.readLine());
			for(int i=0; i<n; i++){		
				String[] temp = br.readLine().split(" ");
				bw.write(Integer.parseInt(temp[0])+Integer.parseInt(temp[1])+"\n");
			}
			bw.flush();
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}
	
	// 11021	A+B - 7
	public void solution_11021() {
		Scanner sc = new Scanner(System.in);
		
		int n= sc.nextInt();
		if(n<0){
			n = sc.nextInt();
		}
		for(int i = 0; i<n; i++){
			int A= sc.nextInt();
			if(A<0||A>10)
				A=sc.nextInt();
			int B= sc.nextInt();
			if(B<0||B>10)
				B=sc.nextInt();
			System.out.println("Case #"+(i+1)+": "+(A+B));
		}
	}
	
	// 	11022	A+B - 8
	public void solution_11022() {
		Scanner sc = new Scanner(System.in);
		
		int n= sc.nextInt();
		if(n<0){
			n = sc.nextInt();
		}
		for(int i = 0; i<n; i++){
			int A= sc.nextInt();
			if(A<0||A>10)
				A=sc.nextInt();
			int B= sc.nextInt();
			if(B<0||B>10)
				B=sc.nextInt();		
			System.out.println("Case #"+(i+1)+": "+A+" + "+B+" = "+(A+B));
		}
	}
	
	// 2438		별 찍기 - 1
	public void solution_2438() {
		Scanner sc = new Scanner(System.in);
		
		int n= sc.nextInt();
		if(n<0||n>100){
			n = sc.nextInt();
		}
		for(int i = 0; i<n; i++){
			for(int j=0;j<=i;j++)
				System.out.print("*");
			System.out.print("\n");
		}
	}
	
	// 2439		별 찍기 - 2
	public void solution_2439() {
		Scanner sc = new Scanner(System.in);
		
		int n= sc.nextInt();
		if(n<0||n>100){
			n = sc.nextInt();
		}
		for(int i = 0; i<n; i++){
			for(int j=n; j>i+1; j--){
				System.out.print(" ");
			}
			for(int j=0;j<=i;j++)
				System.out.print("*");
			System.out.print("\n");
		}
	}
	
	// 10871	X보다 작은 수
	public void solution_10871() {
		Scanner sc = new Scanner(System.in);
		
		int n= sc.nextInt();
		int x = sc.nextInt();
		
		int[] a= new int[n];
		for (int i = 0; i < a.length; ++i) {
            a[i] = sc.nextInt();
        }       
        for (int i = 0; i < a.length; ++i) {
            if (a[i] < x) {
                System.out.print(a[i] + " ");
            }
        }
	}
	
	// 10952	A+B - 5
	public void solution_10952() {
        Scanner sc = new Scanner(System.in);
		int x,y;
		while(true) {
			x = sc.nextInt();
			y = sc.nextInt();
			if(x == 0 && y == 0) break;
			System.out.println(x+y);
		}
	}
	
	// 10951	A+B - 4
	public void solution_10951() {
        Scanner sc = new Scanner(System.in);
		int x,y;
		while(sc.hasNextInt()) {
			x = sc.nextInt();
			y = sc.nextInt();
			System.out.println(x+y);
		}
	}
	
	// 1110		더하기 사이클
	public void solution_1110() {
        Scanner sc = new Scanner(System.in);
		int first = sc.nextInt();
		while (first < 0 && first > 99) {
			first = sc.nextInt();
		}
		int count = 0;
		String newValue = String.valueOf(first);
		while(true) {
			int first_val = Integer.parseInt(newValue)/10;
			int second_val = Integer.parseInt(newValue)%10;
			int sum_val = first_val + second_val;
			newValue = String.valueOf(second_val) + String.valueOf((sum_val%10));
			count++;
			if(first == Integer.parseInt(newValue)) {
				break;
			}
		}
		System.out.println(count);
	}
}
