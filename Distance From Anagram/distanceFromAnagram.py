Given two equal-size strings s and t. In one step you can choose any character of t and replace it with another character.

Return the minimum number of steps to make t an anagram of s.

class Solution:
    def minSteps(self, s: str, t: str) -> int:
        # Find the difference in character counts
        charS = [0] * 26;
        charT = [0] * 26;
        
        for char in s:
            charS[ord(char) - ord('a')] += 1;
        
        for char in t:
            charT[ord(char) - ord('a')] += 1;

        diff = 0;
        
        for countS, countT in zip(charS, charT):
            diff += abs(countS - countT);
        
        return int(diff / 2);