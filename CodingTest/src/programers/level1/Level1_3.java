package programers.level1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Level1_3 {
	//이상한 문자 만들기
	public String solution1(String s) {
	   StringBuilder sb = new StringBuilder();
		int flag = 0;
		for(int i=0; i<s.length(); i++) {
			String temp = String.valueOf(s.charAt(i));
			if(temp.equals(" ")) {
				sb.append(temp);
				flag = 0;
			}
			else if(flag == 0) {
				sb.append(temp.toUpperCase());
				flag++;
			}
			else if(flag == 1) {
				sb.append(temp.toLowerCase());
				flag--;
			}
		}
	    
	    return sb.toString();
	}
	 
	 //자릿수 더하기
	 public int solution2(int n) {
        int answer = 0;
        while(n>0){
            answer += n%10;
            n /= 10;
        }
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println(answer);

        return answer;
    }
	 
	 //자연수 뒤집어 배열로 만들기
	 public int[] solution3(long n) {
        String[] numArr = Long.toString(n).split("");
        int[] answer = new int[numArr.length];
        for(int i=0; i<answer.length; i++) {
        	answer[i] = Integer.parseInt(numArr[numArr.length-i-1]);
        }
        return answer;
    }
	 
	 //정수 내림차순으로 배치하기
	 public long solution4(long n) {
        char[] charArr = String.valueOf(n).toCharArray();
		int[] intArr = new int[charArr.length];
		for(int i=0; i<charArr.length; i++) {
			intArr[i] = charArr[i] -'0';
		}
		List<Integer> list = Arrays.stream(intArr).boxed().collect(Collectors.toList());
		
		Collections.sort(list);
		String answer = "";
		for(int i =list.size()-1; i>=0; i--) {
			answer += list.get(i);
		}
		
		return Long.valueOf(answer);
    }
	 
	 //정수 제곱근 판별
	 public long solution5(long n) {
        long sqrt = (int)Math.sqrt(n);
        long answer = -1;
        if(sqrt*sqrt == n) {
        	sqrt++;
        	answer = sqrt* sqrt ;
        }
        
        return answer;
    }
	 
	 //제일 작은 수 제거하기
     public int[] solution6(int[] arr) {
        if(arr.length == 1) {
			return new int[]{-1};
		}
		
		List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
		int temp = list.get(0), index=0;
		for(int i=1; i<list.size(); i++) {
			if(temp>list.get(i)) {
				temp = list.get(i);
				index = i;
			}
		}
		
		list.remove(index);
		
			
        return list.stream().mapToInt(i -> i).toArray();
     }
     
     //짝수와 홀수
     public String solution7(int num) {
         return num%2 ==0 ? "Even":"Odd";
     }
     
     //최대공약수와 최소공배수
     public int[] solution8(int n, int m) {
         int[] answer = new int[2];
         
         int big=n>m?n:m ,small = n>m? m:n;
         int temp;
         while(true) {
         	if(big%small == 0) {
         		answer[0] = small;
         		break;
         	}
         	temp = big%small;
         	big = small;
         	small = temp;
         }
         answer[1] = n*m/answer[0];
         return answer;
     }
     
     //콜라츠 추측
     public int solution9(int num) {
         int answer = 0;
         long n = num;
         while(true) {
         	if(n == 1) {
         		break;
         	}else if(answer >= 500) {
         		answer = -1;
         		break;
         	}
         	
         	if(n % 2 == 0) 
         		n = n / 2;
         	else 
         		n = n * 3 + 1;
         	answer++;
         }
         return answer;
     }
     
     //평균 구하기
     public double solution10(int[] arr) {
         double answer = 0;
         for(int i=0; i<arr.length; i++){
             answer += arr[i];
         }
         return answer/arr.length;
     }
     
     //하샤드 수
     public boolean solution11(int x) {
         int total = (x/10000) + (x/1000%10) + (x/100%10) + (x/10%10) + (x%10);
         //19183
         boolean answer = x%total == 0 ? true:false ;
         return answer;
     }
     
     //핸드폰 번호 가리기
     public String solution12(String phone_number) {
         StringBuffer answer = new StringBuffer();
         for(int i=0; i< phone_number.length(); i++){
             if(i<phone_number.length()-4){
                 answer.append("*");
             }else{
                 answer.append(phone_number.charAt(i)-'0');
             }
         }
         return answer.toString();
     }
     
     //행렬의 덧셈
     public int[][] solution13(int[][] arr1, int[][] arr2) {
         int[][] answer = arr1;
         for(int i =0; i< arr1.length; i++) {
         	for(int j=0; j<arr1[i].length; j++) {
         		answer[i][j] = arr1[i][j] + arr2[i][j];
         	}
         }
         return answer;
     }
     
     //x만큼 간격이 있는 n개의 숫자
     public long[] solution14(int x, int n) {
         long[] answer = new long[n];
         long data = x;
         for(int i=1; i<=n; i++){
             answer[i-1] = data * i;
         }
         
         return answer;
     }
     
     //직사각형 별찍기
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int a = sc.nextInt();
         int b = sc.nextInt();
         
         for( int i = 0; i < b; i++ ){ 
             for(int j = 0; j < a; j++){
                 System.out.print("*");
             }
             System.out.println();
         }

     }
}
