package onboarding;

import java.util.*;

class Problem1 {
    public static final int DRAW = 0;
    public static final int POBI_WIN = 1;
    public static final int POBI_LOSE = 2;
    public static final int EXCEPTIONS = -1;

    static class PageGapException extends Exception {
//        int pageGapException() {
//            return EXCEPTIONS;
//        }
    }

    static class OverPageException extends Exception {
//        int overPageException() {
//            return EXCEPTIONS;
//        }
    }


    public static int returnResultNumber(List<Integer> pobi, List<Integer> crong) throws PageGapException, OverPageException {
        int pobiMaxResult = comparePage(pobi.get(0),pobi.get(1));
        int crongMaxResult = comparePage(crong.get(0),crong.get(1));

        validateException(pobi, crong);

        if (pobiMaxResult > crongMaxResult) {
            return POBI_WIN;
        }
        if (pobiMaxResult < crongMaxResult) {
            return POBI_LOSE;
        }
        if(pobiMaxResult == crongMaxResult) {
            return DRAW;
        }
        return -2;
    }

    private static void validateException(List<Integer> pobi,List<Integer> crong) throws PageGapException,OverPageException{
        if (checkPageGapException(pobi.get(1), pobi.get(0)) == true) {
            throw new PageGapException();
        }
        if (checkOverPageException(pobi) == true || checkOverPageException(crong) == true) {
            throw new OverPageException();
        }
    }

    private static boolean checkPageGapException(int rightPageIndex,int leftPageIndex) {
        boolean pageGapIsNotOne = (rightPageIndex - leftPageIndex != 1);
        return pageGapIsNotOne;
    }

    private static boolean checkOverPageException(List<Integer> list) {
        boolean pageIsOverPage=false; //OverPage가 아니다가 기본값
        for (Integer integer : list) {
            if (integer.intValue() < 1 || integer.intValue() > 400) {
                pageIsOverPage = true;
            }}
        return pageIsOverPage;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        try {
            int answer = returnResultNumber(pobi, crong);
            return answer;
        } catch (PageGapException exception) {
//            return exception.pageGapException();
            return EXCEPTIONS;
        } catch (OverPageException exception) {
//            return exception.overPageException();
            return EXCEPTIONS;
        }
    }

    private static int comparePage(Integer getLeftPage,Integer getRightPage) {
        Integer leftPageSum=CalculatePageSum(getLeftPage);
        Integer rightPageSum=CalculatePageSum(getRightPage);
        Integer leftPageMultiply = CalculatePageMultiply(getLeftPage);
        Integer rightPageMultiply = CalculatePageMultiply(getRightPage);
        Integer[] calculatePageSumAndMultiply = new Integer[]{leftPageSum, rightPageSum, leftPageMultiply, rightPageMultiply};

        int maxResult=0;
        for (Integer integer : calculatePageSumAndMultiply) {
            if (integer.intValue() > maxResult) {
                maxResult = integer;
            }
        }
        return maxResult;
    }

    private static int CalculatePageSum(int page) {
        int pageSum = 0;
        while (page>0) {
            pageSum += page % 10;
            if (page < 10) {
                break;
            }
            page /= 10;
        }
        return pageSum;
    }
    private static int CalculatePageMultiply(int page) {
        int pageMultiply = 1;
        while (page>0) {
            pageMultiply *= page % 10;
            if (page < 10) {
                break;
            }
            page /= 10;
        }
        return pageMultiply;
    }
}
