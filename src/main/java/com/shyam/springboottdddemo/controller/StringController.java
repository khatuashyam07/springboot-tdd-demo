package com.shyam.springboottdddemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shyam.springboottdddemo.model.InputString;
import com.shyam.springboottdddemo.service.StringService;

@RestController
@RequestMapping("/string")
public class StringController {

	@Autowired
	private StringService stringService;

	@PostMapping("/pattern")
	public String findMatchingPattern(@RequestBody InputString input) {

		String text = input.getText();
		String pattern = input.getPattern();

		return stringService.patternSearch(text, pattern);

	}

	@PostMapping("/palindrome")
	public boolean isPalindrome(@RequestBody InputString input) {

		String palindromeString = input.getText();

		return stringService.isPalindromeString(palindromeString);

	}
}
