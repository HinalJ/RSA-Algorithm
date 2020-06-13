package RSA;

import java.math.BigInteger;

/**
 * Class calculating inverse mod to get decryption exponent.
 */
public class ExtendedEA {
    /**
     * Method implementing Extended Euclidean where input is public key (n,e)
     * @param e Encryption exponent
     * @param n Mod n
     * @return decryption exponent
     */
    public static BigInteger EEA(BigInteger e, BigInteger n)
    {
        int i = 0;
        BigInteger q0 = e, q1 = n, x = BigInteger.ZERO, y, quotient, rem;
        BigInteger x0 = BigInteger.ONE;
        BigInteger x1 = BigInteger.ZERO;

        while(true)
        {
            if((q0.mod(q1)).equals(BigInteger.ZERO)) {
                break;
            }
            else
                rem = q0.mod(q1);

            quotient = q0.divide(q1);
            x = x1.multiply(quotient).add(x0);
            q0 = q1;
            q1 = rem;
            x0 = x1;
            x1 = x;

            i+=1;
        }
        i+=1;
        BigInteger temp = new BigInteger("-1");
        x = x.multiply(temp.pow(i));

        return x;
    }
}

