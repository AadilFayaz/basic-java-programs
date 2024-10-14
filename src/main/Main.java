package src.main;

import src.main.functionality.CodingQuestionsSolution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //searchSuggestionOnTyping
        String[] products =  {"mobile", "mouse", "moneypot", "monitor", "mousepad" };
        String searchKey = "mouse";
        List<List<String>> result = CodingQuestionsSolution.searchSuggestionOnTyping(products, searchKey);
        for (List<String> ls : result)
            System.out.println(ls);

        //amazonFreshPrizeWinner
        //Fail case
        String[] g1 = {"apple", "apple"};
        String[] g2 = {"apple", "apple", "banana"};
        List<List<String>> codeList = new ArrayList<>();
        codeList.add(Arrays.asList(g1));
        codeList.add(Arrays.asList(g2));
        String[] sc = {"apple", "apple", "apple", "banana"};
        System.out.println("amazonFreshPrizeWinner:" + CodingQuestionsSolution.amazonFreshPrizeWinner(codeList, Arrays.asList(sc)));
        //Pass case
        String[] g3 = {"apple", "apple"};
        String[] g4 = {"banana", "anything", "banana"};
        List<List<String>> codeList2 = new ArrayList<>();
        codeList.add(Arrays.asList(g3));
        codeList.add(Arrays.asList(g4));
        String[] sc2 = {"apple", "apple", "orange", "orange", "banana", "apple", "banana", "banana"};
        System.out.println("amazonFreshPrizeWinner:" + CodingQuestionsSolution.amazonFreshPrizeWinner(codeList2, Arrays.asList(sc2)));

        //Amazon Logistics getTotalImbalance()
        System.out.println("Total weight Imbalance:" + CodingQuestionsSolution.getTotalImbalance(new int[]{1,2,3}));

        //Sum of available Good Ranges
        System.out.println("Sum of left&right values of good ranges:" + CodingQuestionsSolution.calculateGoodRanges(10, new int[]{2,7,5,9,6,1,8,10,3,4}));
    }
}
