package programers.level1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Level1_1 {
	//신고 결과 받기
	public int[] solution1(String[] id_list, String[] report, int k) {
	      List<String> list = Arrays.asList(id_list);
			
			Map<String,Map<String,String>> map = new HashMap<String, Map<String,String>>();
			for(String data : report) {
				String a = data.split(" ")[0]; // 신고한사람
				String b = data.split(" ")[1]; // 신고 당한 사람
				
				if(map.get(b) == null) {
					Map<String,String> datas = new HashMap<String, String>();
					datas.put(a,"");
					map.put(b, datas);
				}else {
					Map<String,String> datas = map.get(b);
					datas.put(a,"");
					map.put(b, datas);
				}
			}

			int[] answer = new int[id_list.length];
			for(int i=0; i<id_list.length; i++) {
				if(map.get(id_list[i]) != null) {
					Set<String> keys = map.get(id_list[i]).keySet();
					
					if(keys.size() >= k) {
						for(String key : keys) {
							answer[list.indexOf(key)]+= 1;
						}
					}
				}
			}
			
			return answer;
	    }
	
	//로또의 최고 순위와 최저 순위
	public int[] solution2(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int maxRank,minRank;
        int sameCnt =0;
        int zeroCnt =0;
        
        for(int i=0;i<win_nums.length;i++){
            for(int j=0;j<lottos.length;j++){
                if(win_nums[i] == lottos[j]){
                    sameCnt++;
                    break;
                }
            }
            if(lottos[i] == 0){
                zeroCnt++;
            }
        }
        maxRank = rankReturn(sameCnt + zeroCnt);
        minRank = rankReturn(sameCnt);
        answer[0] = maxRank;
        answer[1] = minRank;
        return answer;
    }
    
    public int rankReturn(int cnt){
        int rank;
        switch(cnt){
            case 6:
                rank = 1;
                break;
            case 5:
                rank = 2;
                break;
            case 4:
                rank = 3;
                break;
            case 3:
                rank = 4;
                break;
            case 2:
                rank = 5;
                break;
            default:
                rank=6;
                break;
        }
        return rank;
    }
    
    //신규 아이디 추천
    public String solution3(String new_id) {
        String answer ="";
         String step1 = new_id.toLowerCase();
         
         char[] seep1_arr = step1.toCharArray();
         StringBuilder step2 = new StringBuilder();
         for(char c : seep1_arr) {
         	if((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || c == '-' || c == '_' || c == '.')
         		step2.append(c);
         }
         String step3 = step2.toString().replace("..", ".");
         while(step3.contains(".."))
         	step3 = step3.replace("..", ".");
         
         if(step3.length() > 0) {
         	if(step3.indexOf(".") == 0) {
         		step3 =step3.substring(1,step3.length());
         	}
         }
         if(step3.length() > 0) {
         	if(step3.lastIndexOf(".") == step3.length()-1) {
         		step3 =step3.substring(0,step3.length()-1);
         	}
         }
         
         if(step3.equals(""))
             step3="a";
         
         if(step3.length() > 15) {
         	step3 = step3.substring(0,15);
         	if(step3.lastIndexOf(".") == step3.length()-1) {
         		step3 = step3.substring(0,step3.length()-1);
         	}
         }
         
         StringBuilder step4 = new StringBuilder(step3);
         if(step4.length() < 3) {
         	char last = step4.charAt(step4.length()-1);
         	while(step4.length() < 3) {
         		step4.append(last);
         	}
         }
         answer = String.valueOf(step4);
         return answer;
     }
    
    //숫자 문자열과 영단어
    public int solution4(String s) {
        String[] numString= {"zero","one","two","three","four","five","six","seven","eight","nine"};
        s = s.toLowerCase();
        
        for(int i=0; i<numString.length; i++){
            s = s.replaceAll(numString[i],String.valueOf(i));
        }
        int answer = Integer.parseInt(s);
        return answer;
    }
    
    //키패드 누르기
    public String solution5(int[] numbers, String hand) {
        StringBuffer sb = new StringBuffer();
        
        String left ="4,1";
        String right = "4,3";
        String LR = "";
        String coordinate = "";
        for(int i=0; i<numbers.length; i++){
            coordinate = getCoordinate(numbers[i]);
            LR = getLR(coordinate, left,right, hand);
            sb.append(LR);
            if(LR.equals("L"))
                left = coordinate;
            else
                right = coordinate;
        }
        return sb.toString();
    }
    
    public String getCoordinate(int num){
//        String coordinate = switch(num){
//                case 0 -> "4,2";
//                case 1 -> "1,1";
//                case 2 -> "1,2";
//                case 3 -> "1,3";
//                case 4 -> "2,1";
//                case 5 -> "2,2";
//                case 6 -> "2,3";
//                case 7 -> "3,1";
//                case 8 -> "3,2";
//                default -> "3,3";
//        };
        String coordinate = "";
        switch (num) {
			case 0 : coordinate = "4,2"; break;
	        case 1 : coordinate = "1,1"; break;
	        case 2 : coordinate = "1,2"; break;
	        case 3 : coordinate = "1,3"; break;
	        case 4 : coordinate = "2,1"; break;
	        case 5 : coordinate = "2,2"; break;
	        case 6 : coordinate = "2,3"; break;
	        case 7 : coordinate = "3,1"; break;
	        case 8 : coordinate = "3,2"; break;
	        default :coordinate =  "3,3";
		}
        return coordinate;
    }
    
    public String getLR(String num, String left, String right, String hand){
        String LR = "";
        switch(num){
//                case "1,1","2,1","3,1" -> LR = "L";
//                case "1,3","2,3","3,3" -> LR = "R";
        		case "1,1" : 
        		case "2,1" : 
        		case "3,1" : 
        			LR = "L"; 
        			break;
        		case "1,3" : 
        		case "2,3" : 
        		case "3,3" : 
        			LR = "R"; 
        			break;
//                default -> {
        		default : {
                    String[] numArr = num.split(",");
                    String[] leftArr = left.split(",");
                    String[] rightArr = right.split(",");
                    int leftDiff = Math.abs(Integer.parseInt(numArr[0]) - Integer.parseInt(leftArr[0])) + Math.abs(Integer.parseInt(numArr[1]) - Integer.parseInt(leftArr[1]));
                    int rightDiff = Math.abs(Integer.parseInt(numArr[0]) - Integer.parseInt(rightArr[0])) + Math.abs(Integer.parseInt(numArr[1]) - Integer.parseInt(rightArr[1]));
                    if((leftDiff-rightDiff) > 0)
                        LR = "R";
                    else if((leftDiff-rightDiff)<0)
                        LR = "L";
                    else
                        LR = hand.equals("right") ? "R" : "L";
                }
        }
        return LR;
    }
    
    //크레인 인형뽑기 게임
    public int solution6(int[][] board, int[] moves) {
        int result = 0;
        List<Integer> draws = new ArrayList<Integer>();
        int draw = 0;
        for(int i=0; i<moves.length; i++){
            draw = crain(board,moves[i]);
            if(draw == 0)
                continue;
            else if(draw != 0 && draws.isEmpty())
                draws.add(draw);
            else if(draw != 0 && !draws.isEmpty() ){
                if(draws.get(draws.size() -1) == draw){
                    draws.remove(draws.size() -1);
                    result += 2;
                }else
                    draws.add(draw);
            }
        }
        
        return result;
    }
    
    public int crain(int[][] board, int move){
        int draw = 0;
        move -= 1;
        for(int i = 0; i<board[move].length; i++){
            if(board[i][move] != 0){
                draw = board[i][move];
                board[i][move] = 0;
                break;
            }
        }
        return draw;
    }
    
    //없는 숫자 더하기
    public int solution7(int[] numbers) {
        int answer = 0;
        for(int i=0; i<=9; i++)
            answer += i;
        for(int i=0; i<numbers.length; i++)
            answer -= numbers[i];
        return answer;
    }
    
    //음양 더하기
    public int solution8(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for(int i = 0; i < absolutes.length; i++){
            if(signs[i])
                answer += absolutes[i];
            else
                answer -= absolutes[i];
        }
        return answer;
    }
    
    //내적
    public int solution9(int[] a, int[] b) {
        int answer = 0;
        for(int i=0; i< a.length; i++)
            answer += a[i]*b[i];
        return answer;
    }
    
    //소수 만들기
    public int solution10(int[] nums) {
        int answer = 0;
        
        ArrayList<Integer> plus = new ArrayList<Integer>();
        for(int i=0; i<nums.length; i++)
            for(int j=i+1; j<nums.length; j++)
                for(int k=j+1; k<nums.length; k++)
                    plus.add(nums[i]+nums[j]+nums[k]);
        
        for(Integer num : plus){
            for(int i=2; i<=num; i++){
                if(num%i == 0 && i != num){
                    break;
                }else if(i == num)
                    answer++;
            }
        }

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println(answer);

        return answer;
    }
    
    //폰켓몬
    public int solution11(int[] nums) {
        int answer = 0;
        Set<Integer> numsSet = new HashSet<>(Arrays.stream(nums).boxed().collect(Collectors.toList()));
		int setSize = numsSet.size();
		if(setSize >= nums.length/2 ) {
			answer = nums.length/2;
		}else {
			answer = setSize;
		}
        return answer;
    }
    
    //완주하지 못한 선수
    public String solution12(String[] participant, String[] completion) {
        String answer = "";
		Arrays.sort(participant);
		Arrays.sort(completion);
		for(int i=0; i<participant.length; i++) {
			if(i == participant.length-1) {
				answer = participant[i];
				break;
			}else if(!participant[i].equals(completion[i])) {
				answer = participant[i];
				break;
			}
			
		}
       
        return answer;
    }
    
    //K번째수
    public int[] solution13(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
		for(int i = 0; i<commands.length; i ++) {
			int[] rangeArr = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
			Arrays.sort(rangeArr);
			answer[i] = rangeArr[commands[i][2]-1];
		}
		
        return answer;
    }
    
    //모의고사
    public int[] solution14(int[] answers) {
        int[] stu1 = {1,2,3,4,5};
		int[] stu2 = {2,1,2,3,2,4,2,5};
		int[] stu3 = {3,3,1,1,2,2,4,4,5,5};
		int[] cnt = new int[3];
		
		for(int i=0; i<answers.length; i++) {
			if(answers[i] == stu1[i%stu1.length])
				cnt[0]++;
			if(answers[i] == stu2[i%stu2.length])
				cnt[1]++;
			if(answers[i] == stu3[i%stu3.length])
				cnt[2]++;
		}
		
		int maxCnt = Math.max(Math.max(cnt[0], cnt[1]),cnt[2]);
        List<Integer> answer = new ArrayList<Integer>();
        
        for(int i=0; i< cnt.length; i++) {
        	if(maxCnt == cnt[i]) {
        		answer.add(i+1);
        	}
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
    
    //체육복
    public int solution15(int n, int[] lost, int[] reserve) {
        int answer = n;
		ArrayList<Integer> reserveList = new ArrayList<Integer>();
		ArrayList<Integer> lostList = new ArrayList<Integer>();
		for(int i=0; i<lost.length; i++) {
			lostList.add(lost[i]);
		}
		for(int i=0; i<reserve.length; i++) {
			reserveList.add(reserve[i]);
		}
        reserveList.sort(Comparator.naturalOrder());
		lostList.sort(Comparator.naturalOrder());
        
		for(int i : lost) {
			if(reserveList.contains(i)) {
				reserveList.remove(reserveList.indexOf(i));
				lostList.remove(lostList.indexOf(i));
			}
		}
		for(int i  : lostList) {
			if(reserveList.contains(i-1)) {
				reserveList.remove(reserveList.indexOf(i-1));
			}else {
				if(reserveList.contains(i+1)) {
					reserveList.remove(reserveList.indexOf(i+1));
				}else {
					answer--;
				}
			}
			
		}
        return answer;
    }
    
    //실패율
    public int[] solution16(int N, int[] stages) {
        int[] answer = new int[N];
        int[] stageCnt = new int[N];
        Map<Integer,Float> rateMap = new HashMap<Integer, Float>();
        // stages.length -> 사용자 수
        float user = stages.length;
        
        for(int stage : stages) {
        	if(stage > N) {
        		continue;
        	}
        	stageCnt[stage-1] += 1;
        }
        
        for(int i=0; i<stageCnt.length; i++) {
        	float failRate = (float) (Float.isNaN(stageCnt[i]/user) ? 0.0 : (stageCnt[i]/user));
        	rateMap.put(i+1, failRate);
        	user -= stageCnt[i];
        }
     	List<Entry<Integer, Float>> list_entries = new ArrayList<Entry<Integer,Float>>(rateMap.entrySet());
     	Collections.sort(list_entries, new Comparator<Entry<Integer, Float>>() {
     		public int compare(Entry<Integer, Float> obj1, Entry<Integer, Float> obj2) {
     			return obj2.getValue().compareTo(obj1.getValue());
     		}
     	});
     	int i = 0;
        for(Entry<Integer, Float> data : list_entries) {
        	answer[i] = data.getKey();
        	i++;
        }
        return answer;
    }
    
    //약수의 개수와 덧셈
    public int solution17(int left, int right) {
        int answer = 0;
        for(int i = left; i <= right; i++) {
        	if(divisorCount(i))
        		answer += i;
        	else
        		answer -= i;
        }
        return answer;
    }
    public boolean divisorCount(int num) {
    	int cnt = 0;
    	for(int i=1; i<=num;i++) {
    		if(num%i == 0)
    			cnt++;
    	}
    	return cnt % 2 == 0;
    }
    
    //3진법 뒤집기
    public int solution18(int n) {
        String three = "";
        int answer = 0;
        int temp = n;
        while(temp > 0) {
        	three += Integer.toString( temp%3 );
        	temp = temp/3;
        }
        // three += temp;
        int combi = 1;
        for(int i = three.length()-1; i>=0; i--) {
        	answer += Integer.parseInt(String.valueOf(three.charAt(i))) * combi;
        	combi *= 3;
        }
         
        return answer;
    }
    
    //예산
    public int solution19(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        for(int i=0; i<d.length; i++) {
        	budget -= d[i];
        	if(budget >= 0) {
        		answer++;
        	}
        }
        return answer;
    }
    
    //두 개 뽑아서 더하기
    public int[] solution20(int[] numbers) {
        ArrayList<Integer> list = new ArrayList<Integer>();
    	for(int i = 0; i<numbers.length; i++) {
    		for(int j=i+1; j<numbers.length; j++) {
    			list.add(numbers[i]+numbers[j]);
    		}
    	}
    	
        return list.stream().distinct().sorted().mapToInt(i -> i).toArray();
    }
}
