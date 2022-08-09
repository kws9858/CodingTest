package baekjoon;

import java.util.Scanner;

public class 조건문 {
	
	// 1330		두 수 비교하기
	public void solution_1330() {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
			
		if(A>B){
			System.out.println(">");
		}else if(A<B){
			System.out.println("<");
		}else
			System.out.println("==");
	}
	
	// 9498		시험 성적
	public void solution_9498() {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		if(A>100&&A<0)
			A = sc.nextInt();
			
		if(A>=90){
			System.out.println("A");
		}else if(A>=80&&A<90){
			System.out.println("B");
		}else if(A>=70&&A<80){
			System.out.println("C");
		}else if(A>=60&&A<70){
			System.out.println("D");
		}else {
			System.out.println("F");
		}
	}
	
	// 2753		윤년
	public void solution_2753() {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		if(A>4000&&A<1)
			A = sc.nextInt();
			
		if(A%4==0&&A%100!=0||A%400==0){
			System.out.println("1");
		}else{
			System.out.println("0");
		}
	}
	
	// 14681	사분면 고르기
	public void solution_14681() {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		if(x>0 && y>0) {
			System.out.println("1");
		}
		else if(x<0 && y>0) {
			System.out.println("2");
		}
		else if(x<0 && y<0) {
			System.out.println("3");
		}else {
			System.out.println("4");
		}
	}
	
	// 2884		알람 시계
	public void solution_2884() {
		Scanner sc = new Scanner(System.in);
		int H = sc.nextInt();
		if(H>23||H<0){
			H = sc.nextInt();
		}
		int M = sc.nextInt();
		if(M>59||M<0){
			M = sc.nextInt();
		}
		if(M>=45){
			System.out.println(H+" "+(M-45));
		}else{
			if(H==0){
				H=24;
				System.out.println((H-1)+" "+(60-(45-M)));
			}else
				System.out.println((H-1)+" "+(60-(45-M)));
		}
	}
	
	// 2525		오븐 시계
	public void solution_2525() {
		Scanner sc = new Scanner(System.in);
        String time = sc.nextLine();
        int cookingTime = sc.nextInt();
        String[] timeArr = time.split(" ");
        int[] endTimeArr = new int[2];
        endTimeArr[0] = cookingTime/60 + Integer.parseInt(timeArr[0]);
        endTimeArr[1] = cookingTime%60 + Integer.parseInt(timeArr[1]);
        if(endTimeArr[1] >= 60){
            endTimeArr[1] = endTimeArr[1] - 60;
            endTimeArr[0] = endTimeArr[0] + 1;
        }
        if(endTimeArr[0] >= 24){
            endTimeArr[0] = endTimeArr[0] -24;
        }
        
        System.out.println(endTimeArr[0] + " " + endTimeArr[1]);
	}
	
	// 2480		주사위 세개
	public void solution_2480() {
		Scanner sc = new Scanner(System.in);
		String dice = sc.nextLine();
		String[] diceArr = dice.split(" ");
		int[] numArr = new int[diceArr.length];
		for(int i = 0; i< diceArr.length; i++)
			numArr[i] = Integer.parseInt(diceArr[i]);
		
		// 입력이 3개 이상일경우 종료
		if(diceArr.length != 3)
			return;
		
		int reward = 0;
		if(numArr[0] == numArr[1] && numArr[0] == numArr[2]) {
			reward = 1000 * numArr[0] + 10000;
		}
		else if(numArr[0] != numArr[1] && numArr[1] != numArr[2] && numArr[0] != numArr[2]) {
			for(int i=0; i<diceArr.length; i++) {
				if(reward < numArr[i])
					reward = numArr[i];
			}
			reward *= 100;
		}
		else {
			if(numArr[0] == numArr[1] || numArr[0] == numArr[2])
				reward = 100 * numArr[0] + 1000;
			else
				reward = 100 * numArr[1] + 1000;
		}
		
		System.out.println(reward);
				
	}	
}
