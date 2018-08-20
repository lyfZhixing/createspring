package lyf.TDDdemo;

import java.util.Arrays;

/**
 * @Author: liyufeng
 * @Description:
 * @Date: Created in 23:05 2018/8/20
 * @Modified By:
 */
public class SearchPrime {

    public static int[] getPrimes(int max) {
        if (max <= 2) {
            return new int[] {};
        } else {
            int count = 0 , i = 0;
            int[] result = new int[max];
            for (int num = 2; num < max; num++) {
                if (isPrimes(num)){
                    result[count++] = num;
                }
            }
            return Arrays.copyOf(result,count);
        }
    }

    public static  boolean isPrimes(int num){
        for (int i = 2; i < num/2 + 1; i++) {
            if (num % i == 0){
                return false;
            }
        }
        return true;
    }
}
