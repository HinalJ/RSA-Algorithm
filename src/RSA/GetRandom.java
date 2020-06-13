package RSA;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

/**
 * Class generating random numbers.
 */
public class GetRandom {
    /**
     * Method to generate BigInteger Odd random number.
     * @return the random generated number.
     */
    public static BigInteger getBigInteger(){
        BigInteger result = new BigInteger(128, new SecureRandom());
        if(result.mod(BigInteger.TWO).equals(BigInteger.ZERO))
            result = result.add(BigInteger.ONE);

        return result;
    }
}