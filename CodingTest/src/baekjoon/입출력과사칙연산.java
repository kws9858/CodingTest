package baekjoon;

import java.util.Scanner;

public class 입출력과사칙연산 {

	// 2557 	Hello World
	public void solution_2557() {
		System.out.println("Hello World!");
	}
		
	// 10718 	We love kriii
	public void solution_10718() {
		System.out.println("강한친구 대한육군"+"\n"+"강한친구 대한육군");
	}
	
	// 1000 	A+B
	public void solution_1000() {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		System.out.println(A+B);
	}
	
	// 1001 	A-B
	public void solution_1001() {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		System.out.println(A-B);
	}
	
	// 10998 	A×B
	public void solution_10998() {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		System.out.println(A*B);
	}
	
	// 1008 	A/B
	public void solution_1008() {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		System.out.println((double)A/(double)B);
	}
	
	// 10869 	사칙연산
	public void solution_10869() {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		System.out.println((A+B)+"\n"+(A-B )+"\n"+(A*B)+"\n"+(A/B)+"\n"+(A%B));
	}
	
	// 10926 	??!
	public void solution_10926() {
		Scanner sc = new Scanner(System.in);
		String id = sc.nextLine();
        System.out.println(id+"??!");
	}
	
	// 18108 	1998년생인 내가 태국에서는 2541년생?!
	public void solution_18108() {
	        Scanner sc = new Scanner(System.in);
	        int year = sc.nextInt();
	        System.out.println((year - 543));
	}
	
	// 3003 킹, 퀸, 룩, 비숍, 나이트, 폰
	private int[] chess = {1,1,2,2,2,8};
	public void solution_3003() {
		Scanner sc = new Scanner(System.in);
		String num = sc.nextLine();
		String[] numArr = num.split(" ");
		int[] arr = new int[chess.length];
		
		for(int i=0; i<numArr.length; i++){
		    arr[i] = chess[i] - Integer.parseInt(numArr[i]);
		    if(i == 0)
		        System.out.print(arr[i]);
		    else
		        System.out.print(" "+arr[i]);
		}
	}
	
	// 10430	나머지
	public void solution_10430() {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
				
		System.out.println(((A+B)%C)+"\n"+
		((A%C+B%C)%C)+"\n"+
				((A*B)%C)+"\n"+
		((A%C * B%C)%C));
	}
	
	// 2588		곱셈
	public void solution_2588() {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
					
		System.out.println((A*(B%10))+"\n"+
		(A*((B/10)%10))+"\n"+
				(A*(((B/10)/10)%10))+"\n"+
		(A*B));	
	}
	
	// 10171	고양이
	public void solution_10171() {
		System.out.println("\\    /\\\n"+" )  ( ')\n"+"(  /  )\n"+" \\(__)|");	
	}
	
	// 10172	개
	public void solution_10172() {
		System.out.println("|\\_/|\n|q p|   /}\n( 0 )\"\"\"\\\n|\"^\"`    |\n||_/=\\\\__|");	
	}
	
	// 25083	새싹
	public void solution_25083() {
		System.out.println("         ,r'\"7");
        System.out.println("r`-_   ,'  ,/");
        System.out.println(" \\. \". L_r'");
        System.out.println("   `~\\/");
        System.out.println("      |");
        System.out.println("      |");	
	}
}
