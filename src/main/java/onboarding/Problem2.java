package onboarding;

import java.util.Stack;

public class Problem2 {
    static final int MAX_LENGTH = 1000;
    static final int MIN_LENGTH = 1;
    static final char SMALL_LETTER_FIRST = 'a';
    static final char SMALL_LETTER_LAST = 'z';
    public static Stack<Character> stack;
    public static String answer="";

    public static void main(String[] args) {

    }

    public static String solution(String cryptogram) {
        try {
            validateAllConstraints(cryptogram);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Stack<Character> characters = checkAndDeleteDuplicatedLetters(cryptogram);
        String answer = stackToStringBuilder(characters);

        return answer;
    }

    /**
     * 제한 사항 한번에 검증
     * @param cryptogram
     */
    public static void validateAllConstraints(String cryptogram) {
        validateLength(cryptogram);
        validateSmallLetter(cryptogram);
    }

    /**
     * 입력된 문자열의 길이가 1이상 1000이하인지 검증
     * @param cryptogram
     */
    public static void validateLength(String cryptogram) {
        if (cryptogram.length() < MIN_LENGTH || cryptogram.length() > MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 입력된 문자열의 문자 하나 하나가 소문자 인지 검증
     * @param cryptogram
     */
    public static void validateSmallLetter(String cryptogram) {
        for (int i = 0; i < cryptogram.length(); i++) {
            checkSmallLetter(cryptogram.charAt(i));
        }
    }


    /**
     * 알파벳 하나가 소문자인지 확인
     * @param letter
     */
    private static void checkSmallLetter(char letter) {
        if (letter < SMALL_LETTER_FIRST || letter > SMALL_LETTER_LAST) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * cryptogram 문자 배열을 돌면서 중복된 문자 제거하는 기능
     * @param cryptogram
     */
    public static Stack<Character> checkAndDeleteDuplicatedLetters(String cryptogram) {
        stack = new Stack<>();
        char[] letters = cryptogram.toCharArray();
        for (char letter : letters) {
            deleteDuplicatedLetter(letter);
        }
        return stack;
    }

    /**
     * 입력된 문자 하나가 스택이 비어있지 않거나 스택에 젤 위에 있는 문자와 같으면 pop
     * 그렇지 않으면, push
     * @param letter
     */
    private static void deleteDuplicatedLetter(char letter) {
        if (!stack.isEmpty() && stack.peek() == letter) {
            stack.pop();
            return;
        }
        stack.push(letter);
    }

    public static String stackToStringBuilder(Stack<Character> stack) {
        StringBuilder sb = new StringBuilder();
        for (char letter : stack) {
            sb.append(letter);
        }
        return sb.toString();
    }


}
