package onboarding;

import java.util.*;

class Problem1 {
    static class PageGapException extends Exception {
        int pageGapException() {
            return -1;
        }
    }

    static class OverPageException extends Exception {
        int overPageException() {
            return -1;
        }
    }

//    페이지 초기화: 왼쪽 페이지, 오른쪽 페이지 각각 랜덤으로
//    private static List<Integer> initPages() throws PageException {
//        Random random = new Random();
//        int leftPage = random.nextInt(400) + 1;
//        int rightPage = random.nextInt(400) + 1;
//        if (rightPage - leftPage != 1) {
//            throw new PageException();
//        }
//        System.out.println("왼쪽 페이지= " + leftPage + "오른쪽 페이지= " + rightPage);
//        List<Integer> list = Arrays.asList(leftPage, rightPage);
//        return list;
//    }

    public static int returnResultNumber(List<Integer> pobi, List<Integer> crong) throws PageGapException, OverPageException {
        int[] pobiPageArray = new int[2];
        int[] crongPageArray = new int[2];
        int pobiIndex = 0;
        int crongIndex = 0;

        /*
         * 페이지가 1페이지 미만이거나 400페이지 초과일때 예외 발생
         *
         * 오른쪽 페이지에서 왼쪽 페이지를 뺐을때 무조건 1이어야
         * 연속된 페이지라고 볼 수 있으므로 1이 아니면 예외 발생
         * */
        for (Integer integer : pobi) {
            if (integer.intValue() < 1 || integer > 400) {
                throw new OverPageException();
            }
            pobiPageArray[pobiIndex++] = integer.intValue();

        }
        if (pobiPageArray[1] - pobiPageArray[0] != 1) {
            throw new PageGapException();
        }
        for (Integer integer : crong) {
            if (integer.intValue() < 1 || integer > 400) {
                throw new OverPageException();
            }
            crongPageArray[crongIndex++] = integer.intValue();
        }
        if (crongPageArray[1] - crongPageArray[0] != 1) {
            throw new PageGapException();
        }

        int pobiMaxResult = comparePage(pobiPageArray);
        int crongMaxResult = comparePage(crongPageArray);

        if (pobiMaxResult > crongMaxResult) {
            return 1;
        } else if (pobiMaxResult < crongMaxResult) {
            return 2;
        } else {
            return 0;
        }
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        try {
            int answer = returnResultNumber(pobi, crong);
            return answer;
        } catch (PageGapException exception) {
            return exception.pageGapException();
        } catch (OverPageException exception) {
            return exception.overPageException();
        }
    }

    private static int comparePage(int[] pageArray) {
        int maxResult = 0;
        int leftPageSum=CalculatePageSum(pageArray[0]);
        int rightPageSum=CalculatePageSum(pageArray[1]);
        int leftPageMultiply = CalculatePageMultiply(pageArray[0]);
        int rightPageMultiply = CalculatePageMultiply(pageArray[1]);
        int[] calculatePageSumAndMultiply = new int[]{leftPageSum, rightPageSum, leftPageMultiply, rightPageMultiply};

//        int maxResult = Arrays.stream(calculatePageSumAndMultiply).max().getAsInt();
        for (int value : calculatePageSumAndMultiply) {
            if (value > maxResult) {
                maxResult = value;
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
