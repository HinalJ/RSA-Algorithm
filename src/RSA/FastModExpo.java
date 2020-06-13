package RSA;

import java.math.BigInteger;

/**
 * Class calculates the (a^b)%n faster.
 */
public class FastModExpo {
    /**
     * Method implementing Fast Modular Exponentiation.
     * @param a A number whose powers are need to be calculated and then result modular n need
     *          to be calculated.
     * @param b Power b
     * @param m Modular n
     * @return
     */
    public static BigInteger FME(BigInteger a, BigInteger b, BigInteger m){
        BigInteger res = BigInteger.ONE, result = BigInteger.ONE;

        //radix = base
        String binary = b.toString(2);
        int length = binary.length()-1;
        res = a.mod(m);

        for(int i = 0; i<=length; i++){
            if(binary.charAt(length-i)=='1') {
                result = result.multiply(res);
            }
            res = res.multiply(res).mod(m);
        }
        return result.mod(m);
    }
}
