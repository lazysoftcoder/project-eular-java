package com.bughunter.projecteular.qs1to10;
/**
 * 
 * @author lazysoftcoder
 *
 *The prime factors of 13195 are 5, 7, 13 and 29.What is the largest prime factor of the number 600851475143 ?
 *Ans:6857
 */
public class QS3 {

	public static void main(String[] args) throws Exception{

		long num = 600851475143l;//600851475143l;//13195;//
		long startTime = System.currentTimeMillis();
		long maxPrimeFactor = 0;
		long maxFactor = num/2;//Logic:all the factors of a number n,except 1 & n, lies between 2 to n/2
		long minFactor = 2;
		//Logic:getting the factors from lower side & upper side at the same time
		//Time Complexity:O(nlogn)
		for(;minFactor<=maxFactor;minFactor++) {
			if(num%minFactor==0) { 
				
				maxFactor=num/minFactor;
				//Logic:checking both the factors for primeness.Whichever is higher,is the answer
				if(checkPrime(minFactor)) {
			  		maxPrimeFactor=minFactor>maxPrimeFactor?minFactor:maxPrimeFactor;
			  	}
				if(checkPrime(maxFactor)) {
			  		maxPrimeFactor=maxFactor>maxPrimeFactor?maxFactor:maxPrimeFactor;
			  	}
			}
		}
		System.out.println("maxPrimeFactor:"+maxPrimeFactor);
		System.out.println("Execution Time:"+(System.currentTimeMillis()-startTime)+" millisec");
		
		//Execution Time(Best) on a Ryzen3 2.60 GHz|8GB|256GB SSD system:14 millisec
	}
	
	static boolean checkPrime(long n) {
		System.out.print("factor value:"+n+":");
		long loopLimit = (n/2)%2==0?(long) ((n/2)+1):(long) (n/2);
		for(long i=2;i<loopLimit;i++) {
			if(n%i==0) {
				System.out.println("not prime, divisor:"+i);
				return false;
			}
		}
		System.out.println("prime");
		return true;
	}
}
