package com.shyam.springboottdddemo.service;

import org.springframework.stereotype.Service;

@Service
public class StringServiceImpl implements StringService {

	@Override
	public String patternSearch(String text, String pattern) {
		int M = pattern.length();
        int N = text.length();
        Boolean patternMatched = false;
        StringBuilder sb = new StringBuilder("Pattern found at index ");
        /* A loop to slide pat one by one */
        for (int i = 0; i <= N - M; i++) {
 
            int j;
 
            /* For current index i, check for pattern
              match */
            for (j = 0; j < M; j++)
                if (text.charAt(i + j) != pattern.charAt(j))
                    break;
 
            if (j == M) // if count of j ==M then i will be the matched index 
	    { 
            	sb.append(" "+i +" ,");
            	patternMatched = true;
            }
        }
		return patternMatched  ?  sb.toString() : "Pattern not found" ;
	}

	@Override
	public boolean isPalindromeString(String palindromeString) {
		
		boolean flag = true;
		String str = palindromeString.toLowerCase();
		
		for(int i =0;i<str.length()/2;i++) {
			if(str.charAt(i)!=str.charAt(str.length()-i-1)) {
				flag=false;
				break;
			}
		}
		return flag;  
	}

}
