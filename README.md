# springboot-tdd-demo

Endpoint 1 -- findMatchingPattern

POST /string/pattern HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Cache-Control: no-cache

{"text": "AABAACAADAABAABAA", "pattern": "AABA"}


Endpoint 2 -- isPalindrome

POST /string/palindrome HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Cache-Control: no-cache

{"text": "RADAR", "pattern": ""}
