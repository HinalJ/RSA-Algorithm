# RSA Algorithm
User can perform 3 actions:-
- Generate public and private keys
- Encrypt the message -> Public Key is required (n,e)
- Decrypt the cipher text -> Private and Public Key required (n,d)

## Option Provided
- Option to save in the file.
- Option to print on the console.
- Option to perform above both steps.

## Algorithms Implemented
1) Extended Euclidean
2) Fast Modular Exponentiation
3) Miller-Rabin Primality Test
4) RSA Key-Generation

## Generating Keys
- RSA Key Generation Algorithm and Miller Rabin(Primality Test) to get 2 prime numbers p and q using GetRandom class are used.

## Encrypting the message
- Fast Modular Exponentiation Algorithm
    c -> (m^e)%n 
    
## Decrypting the message
- To calculate decryption exponent -> Extended Euclidean Algorithm is used.
- Fast Modular Exponentiation Algorithm
    m -> (c^d)%n
