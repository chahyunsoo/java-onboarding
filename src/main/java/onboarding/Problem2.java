package onboarding;

public class Problem2 {
    static final int MAX_LENGTH = 1000;
    static final int MIN_LENGTH = 1;
    static final char SMALL_LETTER_FIRST = 'a';
    static final char SMALL_LETTER_LAST = 'z';

    public static String solution(String cryptogram) {
        try {
            validateAllConstraints(cryptogram);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return cryptogram;
    }

    /**
     * 제한사항 한번에 검증
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
        if (cryptogram.length() < MIN_LENGTH && cryptogram.length() > MAX_LENGTH) {
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
        if (letter < SMALL_LETTER_FIRST && letter > SMALL_LETTER_LAST) {
            throw new IllegalArgumentException();
        }
    }
}
