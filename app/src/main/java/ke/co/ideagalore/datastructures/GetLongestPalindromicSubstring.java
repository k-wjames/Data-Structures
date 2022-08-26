package ke.co.ideagalore.datastructures;

public class GetLongestPalindromicSubstring {
    //A palindrome is a word, phrase, number or other sequence of characters which reads the same as
    //backward as forward, such as taco cat or madam or racecar or the number 10801

    public String longestPalindrome(String s) {

        int length = s.length();

        if (s == null || length < 1) return "";
        int start = 0;
        int end = 0;
        for (int i = 0; i < length; i++) {

            int lengthOne = expendFromBeginning(s, i, i);// This will handle cases such as 'racecar'
            int lengthTwo = expendFromBeginning(s, i, i + 1);// This will handle cases such as 'aabbaa'
            int len = Math.max(lengthOne, lengthTwo);

            if (len > end - start) {
                //We found the longest palindromic substring
                start = i - ((len - 1) / 2);//Moving the index to the extreme left where the palindrome starts
                end = i + (len / 2);//Moving the index to the extreme right where the palindrome ends
            }
        }
        return s.substring(start, end + 1);
    }

    public int expendFromBeginning(String s, int left, int right) {

        if (s == null || left > right) return 0;

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }
}
