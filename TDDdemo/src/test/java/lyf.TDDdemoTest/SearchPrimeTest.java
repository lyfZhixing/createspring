package lyf.TDDdemoTest;

import lyf.TDDdemo.SearchPrime;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Author: liyufeng
 * @Description:
 * @Date: Created in 22:56 2018/8/20
 * @Modified By:
 */
public class SearchPrimeTest {

    @Test
    public void testGetPrimesForEmptyRuestlt() {
        int[] excepted = {};
        Assert.assertArrayEquals(excepted, SearchPrime.getPrimes(2));
        Assert.assertArrayEquals(excepted, SearchPrime.getPrimes(1));
        Assert.assertArrayEquals(excepted, SearchPrime.getPrimes(0));
    }

    @Test
    public void testGetPrimesForNormal() {
        Assert.assertArrayEquals(new int[] {2,3,5,7,11}, SearchPrime.getPrimes(12));
        System.out.println("-----------------------------");
        Assert.assertArrayEquals(new int[] {2,3,5,7,11,13}, SearchPrime.getPrimes(15));
        Assert.assertArrayEquals(new int[] {2,3,5,7,11,13,17}, SearchPrime.getPrimes(19));
    }

}
