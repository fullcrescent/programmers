package programmers.level2;

import java.math.BigDecimal;
import java.math.MathContext;

public class 멀쩡한_사각형 {
	public static void main(String args[]) {
		int w = 8;
		int h = 12;
		long answer = solution(w, h);
		System.out.println(answer);
	}
	
	public static long solution(int w, int h) {
        long answer =(long)w*h;
        
        BigDecimal d1 = new BigDecimal(w);
        BigDecimal d2 = new BigDecimal(h);
        BigDecimal d ;
        
        boolean flag =false;
        long remainder;
        long remain =0;
        if(w>h){
            d= d1.divide(d2, MathContext.DECIMAL128);
            flag = d1.remainder(d2).longValue()>0 ? true : false;
            remainder = d1.remainder(d2).longValue();
        }else{
            d= d2.divide(d1, MathContext.DECIMAL128);
            flag = d2.remainder(d1).longValue()>0 ? true : false;
            remainder = d2.remainder(d1).longValue();
        }
 
        
        
        for(int i=0; i<(w>h ? h:w);i++){
            answer -= d.longValue() + (flag ? 1:0);
            remain += remainder;
            if(remain > (w>h ? h:w)){
                answer -= 1;
                remain -= (w>h ? h:w);
            }else if(remain == (w>h ? h:w)){
                remain =0;
            }
        }
        return answer;
    }
}
