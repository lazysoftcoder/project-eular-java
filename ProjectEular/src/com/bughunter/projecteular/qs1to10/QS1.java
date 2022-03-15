package com.bughunter.projecteular.qs1to10;

public class QS1 {

	/**
	 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. 
	 * The sum of these multiples is 23.Find the sum of all the multiples of 3 or 5 below 1000.
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		//method1
		 long fact1=3,fact2=5;
		 long lcm=fact1*fact2;
		 long limit=999;
		 long sum=0;
		 for(long i=lcm;i<=limit;i+=lcm) {
			 sum+=i%lcm==0?i:0;
		 }
		 for(long i=fact1;i<=limit;i+=fact1) {
			 sum+=i%lcm!=0?i:0;
		 }
		 for(long i=fact2;i<=limit;i+=fact2) {
			 sum+=i%lcm!=0?i:0;
		 }
		 System.out.println(sum);
		 
		 //method2
		 sum=getSumDivisibleBy(limit/fact1,fact1)+getSumDivisibleBy(limit/fact2,fact2)-getSumDivisibleBy(limit/lcm,lcm);
		 
		 System.out.println(sum);
	}
	
	
	/***
	 * Logic: let sum_n= sum of natural numbers from 1 to n = (n*(n+1))/2
	 * so divisible by x = x*sum_n
	 * hence output=getSumDivisibleBy(999,3)+getSumDivisibleBy(999,5)-getSumDivisibleBy(999,15)
	 * @param l
	 * @return
	 */
	public static long getSumDivisibleBy(long limit,long div) {
		return div*(limit*(limit+1))/2;
	}

}
