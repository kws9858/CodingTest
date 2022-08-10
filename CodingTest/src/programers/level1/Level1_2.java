package programers.level1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Level1_2 {
	//2016년
	public String solution1(int a, int b) {
        LocalDate date = LocalDate.of(2016, a, b);
    	int day = date.getDayOfWeek().getValue();
    	
        return day == 1 ? "MON" : day == 2 ? "TUE" : day == 3 ? "WED" : day == 4 ? "THU" : day == 5 ? "FRI" : day == 6 ? "SAT" : "SUN";
    }
	
	//최소직사각형
	public int solution2(int[][] sizes) {
        for(int i=0; i<sizes.length; i++) {
    		if(sizes[i][0] < sizes[i][1]) {
    			int temp = sizes[i][0];
    			sizes[i][0] = sizes[i][1];
    			sizes[i][1] = temp;
    		}
    	}
    	int w=0, h=0;
    	for(int i=0; i<sizes.length; i++) {
    		if(sizes[i][0] > w)
    			w = sizes[i][0];
    		if(sizes[i][1] > h)
    			h = sizes[i][1];
    	}
        
        return w*h;
    }
	
	//나머지가 1이 되는 수 찾기
	public int solution3(int n) {
        int answer = 0;
        for(int i=2; i<n; i++) {
        	if(n%i == 1) {
        		answer= i;
        		break;
        	}
        }
        return answer;
    }
	
	//부족한 금액 계산하기
	public long solution4(int price, int money, int count) {
        long answer = 0;
        for(int i=1; i<=count; i++) {
        	answer += price*i;
        }
        return answer - money > 0? answer-money: 0;
    }
	
	//[1차]비밀지도
	public String[] solution5(int n, int[] arr1, int[] arr2) {
    	String[] strArr = new String[arr1.length];
    	for(int i=0; i<arr1.length; i++) {
    		char[] strArr1 = positionNumber(Integer.toBinaryString(arr1[i]),n).toCharArray();
    		char[] strArr2 = positionNumber(Integer.toBinaryString(arr2[i]),n).toCharArray();
    		String data = "";
    		for(int j=0; j<strArr1.length; j++) {
    			data+= ((strArr1[j] - '0') + (strArr2[j]- '0'));
    		}
    		data = data.replaceAll("0", " ");
    		data = data.replaceAll("[12]", "#");
    		strArr[i] = data;
    		
    	}

        return strArr;
    }
    public String positionNumber(String data, int n) {
    	int cnt = n - data.length();
    	if(data.length() != n) {
			for(int i=0; i< cnt; i++) {
				data = "0"+data;
			}
    	}
    	return data;
    }
    
    //가운데 글자 가져오기
    public String solution6(String s) {
        return s.length() % 2 == 0 ? s.substring(s.length()/2 -1, s.length()/2+1) : s.substring(s.length()/2 , s.length()/2+1);
    }
    
    //[1차]다크 게임
    public int solution7(String dartResult) {
        int answer = 0;
       ArrayList<Integer> numList = new ArrayList<Integer>();
       ArrayList<String> strList = new ArrayList<String>();
       String[] split =  dartResult.split("");
       for(int i=0; i< split.length; i++) {
       	if(split[i].matches("[0-9]")) {
       		if(split[i].matches("1")) {
       			if(split[i+1].matches("[0-9]")) {
       				numList.add(10);
       				i++;
       			}else {
       				numList.add(1);
       			}
       		}else {
       			numList.add(Integer.parseInt(split[i]));
       		}
       	}else {
       		if(i+1 != split.length && !split[i+1].matches("[0-9]")){
       			strList.add(split[i]+split[i+1]);
       			i++;
       		}else {
       			strList.add(split[i]);
       		}
       	}
       }
       
       int su=0;
       int[] nums = new int[3];
       for(int i=0; i<numList.size(); i++) {
       	int iNum = numList.get(i);
       	String iStr = strList.get(i);
       	if(iStr.charAt(0) == 'S') {
       		nums[i] = iNum;
       	}else if(iStr.charAt(0) == 'D') {
       		nums[i] = (iNum*iNum);
       	}else {
       		nums[i] = (iNum*iNum*iNum);
       	}
       	if(iStr.length() > 1) {
       		if(iStr.charAt(1) == '*') {
       			if(i == 0) {
       				nums[i] *= 2;
       			}else {
       				nums[i-1] *= 2;
       				nums[i] *= 2;
       			}
       		}else {
       			nums[i] *= -1;
       		}
       	}
       }
       return nums[0] + nums[1] + nums[2];
   }
    
    //같은 숫자는 싫어
    public int[] solution8(int []arr) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(arr[0]);
        for(int i=1; i<arr.length; i++) {
        	if(arr[i-1] != arr[i])
        		list.add(arr[i]);
        }
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
        	answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    //나누어 떨어지는 숫자 배열
    public int[] solution9(int[] arr, int divisor) {
        ArrayList<Integer> list = new ArrayList<Integer>();
     	for(int data : arr) {
     		if(data % divisor == 0)
     			list.add(data);
     	}

     	list.sort(null);
     	int[] answer = new int[list.isEmpty() ? 1 : list.size()];
         if(list.isEmpty())
         	answer[0] = -1;
         else
         	for(int i=0; i<list.size(); i++) {
         		answer[i] = list.get(i);
         	}
         
         return answer;
     }
    
    //두 정수 사이의 합
    public long solution10(int a, int b) {
        long answer = 0;
        if(a == b)
        	return a;
        for(int i = a>b?b : a; i <= (a>b? a : b); i++ ) {
        	answer += i;
        }
        
        return answer;
    }
    
    //문자열 내 마음대로 정렬하기
    public String[] solution11(String[] strings, int n) {
        List<String> stringList = Arrays.asList(strings);
        List<Character> charList = new ArrayList<Character>();
        for(String data : stringList) {
        	charList.add(data.charAt(n));
        }
        for(int i = 0; i<charList.size(); i++) {
        	for(int j=i+1; j<charList.size(); j++) {
        		if(charList.get(i) - charList.get(j) > 0) {
        			char temp = charList.get(i);
        			charList.set(i, charList.get(j));
        			charList.set(j, temp);
      
        			String tempS = stringList.get(i);
        			stringList.set(i, stringList.get(j));
        			stringList.set(j, tempS);
        		}else if(charList.get(i) - charList.get(j) == 0 ) {
        			if(stringList.get(i).compareTo(stringList.get(j)) > 0) {
        				String tempS = stringList.get(i);
            			stringList.set(i, stringList.get(j));
            			stringList.set(j, tempS);
        			}
        		}
        	}
        }
        
        
        return stringList.toArray(new String[stringList.size()]);
    }
    
    //문자열 내 p와 y의 개수
    public boolean solution12(String s) {
        int pCnt=0,yCnt=0;
        String[] arr = s.toLowerCase().split("");
        for(String data : arr) {
        	if(data.equals("p")) 
        		pCnt++;
        	else if(data.equals("y"))
        		yCnt++;
        }
        return pCnt == yCnt ? true : false;
    }
    
    //문자열 내림차순으로 배치하기
    public String solution13(String s) {
        char[] arr = s.toCharArray();
    	for(int i=0; i<arr.length; i++) {
    		for(int j= i+1; j<arr.length; j++) {
    			if(arr[i] < arr[j]) {
    				char temp = arr[i];
    				arr[i] = arr[j];
    				arr[j] = temp;
    			}
    		}
    	}
        return new String(arr);
    }
    
    //문자열 다루기 기본
    public boolean solution14(String s) {
        if(s.length() != 4 && s.length() != 6)
    		return false;
       for(int i = 0; i<s.length(); i++) {
    		char temp = s.charAt(i);
    		if(!(temp >= '0' && temp <= '9')) {
    			return false;
    		}
    	}
        return true;
    }
    
    //서울에서 김서방 찾기
    public String solution15(String[] seoul) {
        String answer = "";
        int dist = -1;
        for(int i=0; i<seoul.length; i++){
            if(seoul[i].equals("Kim")){
                dist = i;
                break;
            }
                
        }
        return String.format("김서방은 %d에 있다",dist);
    }
    
    //소수 찾기
    public int solution16(int n) {
        int answer = 0;
        
        for(int i = 2; i<=n; i++) {
        	if(i == 2) {
        		answer++;
        		continue;
        	}
        	boolean flag = true;
        	for(int j=2; j<=Math.sqrt(i); j++ ) {
        		if(i % j == 0) {
        			flag =false ;
        			break;
        		}
        	}
        	if(flag) {
        		answer++;
        	}
        }
        return answer;
    }
    
    //수박수박수박수박수박수?
    public String solution17(int n) {
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<= n; i++){
            if(i%2 != 0)
                sb.append("수");
            else
                sb.append("박");
        }
        return sb.toString();
    }
    
    //문자열을 정수로 바꾸기
    public int solution18(String s) {
        int answer = Integer.parseInt(s);
        return answer;
    }
    
    //시저 암호
    public String solution19(String s, int n) {
        StringBuilder sb = new StringBuilder();
         for(int i=0; i<s.length(); i++) {
         	char charStr = s.charAt(i);
         	if(charStr == ' ') {
         		sb.append(charStr);
         	}else {
         		if(charStr >= 'a' && charStr <= 'z') {
         			int flag = charStr+n -'z';
         			if(flag >0 ) {
         				charStr = (char)('a' + flag -1 );
         			}
         			else {
         				charStr = (char)(charStr + n);
         			}
         		}else if(charStr >= 'A' && charStr <= 'Z') {
         			int flag = charStr+n -'Z';
         			if(flag >0 ) {
         				charStr = (char)('A' + flag -1);
         			}
         			else {
         				charStr = (char)(charStr + n);
         			}
         		}
         		sb.append(charStr);
         	}
         }
         return sb.toString();
     }
    
    //약수의 합
    public int solution20(int n) {
        int answer = 0;
        for(int i = 1; i<=n/2; i++) {
        	if(n % i == 0)
        		answer += i;
        }
        return answer + n;
    }
}
