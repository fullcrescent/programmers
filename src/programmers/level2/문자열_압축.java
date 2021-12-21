package programmers.level2;

public class 문자열_압축 {
    public static void main(String args[]) {
      String s = "abcabcabcabcdededededede";
      int answer = solution(s);
      System.out.println(answer);
    }
  
  
  public static int solution(String s) {
    int answer = s.length();
    int count =1;
    String pattern = "";
    int patternCount =0;

    while(count<=s.length()){
      int length = s.length();
      for(int i=0;i<s.length();i=i+count){
        if(i+count <= s.length()){
          if(pattern.equals(s.substring(i, i+count))){
            length -= count;
            patternCount++; 
            if(patternCount==2){
              length++;
            }else if(patternCount==10){
               length++;
            }else if(patternCount==100){
              length++;
            }else if(patternCount==1000){
              length++;
            }
          }else{
            pattern =s.substring(i , i+count);
            patternCount=1;
          }
        }
      }
      answer =Math.min(answer,length);
      count++;
    }
    return answer;
  }
}
