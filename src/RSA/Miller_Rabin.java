package RSA;

import java.math.BigInteger;

/**
 * Class that determines that the following number is composite or not sure.
 */
public class Miller_Rabin {

    /**
     * Method implementing Miller-Rabin Primality test.
     * @param n The number put at test.
     * @param a The base used to test whether following number is composite.
     * @return True if it is probably prime, false if the number is composite.
     */
    public static boolean isprobableprime(BigInteger n, BigInteger a){
        BigInteger one = BigInteger.ONE;
        BigInteger two = BigInteger.TWO;
        BigInteger d = (n.subtract(one));

        int count = 0;
        //Counting the maximum power of 2 that can divide n-1; and the remaining odd number will be d.
        while(true)
        {
            if((!d.mod(two).equals(BigInteger.ZERO)))
                break;
            d = d.divide(two);
            count++;
        }

        int s = count;
        BigInteger res = FastModExpo.FME(a,d,n);

        //BigInteger res congruent -1 or res congruent to n - 1 belongs to same class that is why n-1
        if(res.equals(one) || res.equals(n.subtract(one))) {
            return true;
        }

        for(int i = 1; i<s; i++){
            res = res.multiply(res).mod(n);
            if(res.equals(n.subtract(one))) {
                return true;
            }
        }
        return false;
    }
}
