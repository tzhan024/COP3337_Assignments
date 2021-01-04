/**
	COPYRIGHT (C) 2018 Tinghui Zhang. All Rights Reserved.
	This code is used to compute the constant e.
	Solves for COP3337 assignment #1
	@author Tinghui Zhang
	@version 1.01 2018-09-06
*/
public class ComputeE
{
	public static void main (String[] args)
	{
		double e = 1;   //initialed for 0!			
		double nFactorial = 1;
		int n = 1;
		final double DELTA = 0.0000000000000001;
		final double ONE = 1.0;
		while (ONE / nFactorial >= DELTA)
		{
			nFactorial *= n;
			e += ONE / nFactorial;
			n++;
		}
		System.out.printf ("The computed value of e is: %.16f\n", e);
		System.out.printf ("The expected value of e is: %.16f\n", Math.E);
		System.out.println ("Required iterations: " + n);
	}
}