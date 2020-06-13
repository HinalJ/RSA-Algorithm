package RSA;

import java.math.BigInteger;

/**
 * Class generating public and private keys.
 */
public class KeyGeneration {
    private BigInteger p;
    private BigInteger q;
    private static BigInteger n;
    private static BigInteger e;
    private static BigInteger d;

    /**
     * Generate public key (n,e) and private key d.
     */
    public KeyGeneration()
    {
        while (true) {
            p = GetRandom.getBigInteger();
            if (!Miller_Rabin.isprobableprime(p, new BigInteger("2")))
                continue;

            if (!Miller_Rabin.isprobableprime(p, new BigInteger("3")))
                continue;

            if (!Miller_Rabin.isprobableprime(p, new BigInteger("11")))
                continue;
            break;
        }

        while (true) {
            q = GetRandom.getBigInteger();
            if (!Miller_Rabin.isprobableprime(q, new BigInteger("2")))
                continue;

            if (!Miller_Rabin.isprobableprime(p, new BigInteger("3")))
                continue;

            if (!Miller_Rabin.isprobableprime(p, new BigInteger("11")))
                continue;
            break;
        }

        n = p.multiply(q);
        BigInteger fi_n = (p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE)));
        e = new BigInteger("3");

        while ((!e.gcd(fi_n).equals(BigInteger.ONE)))
            e = e.add(BigInteger.TWO);

        d = ExtendedEA.EEA(e, fi_n);

        while (d.compareTo(BigInteger.ZERO) < 0)
            d = d.add(fi_n);
    }
    public static BigInteger getN() {
        return n;
    }

    public static BigInteger getE() {
        return e;
    }

    public static BigInteger getD() {
        return d;
    }
}
