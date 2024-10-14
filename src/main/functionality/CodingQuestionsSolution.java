package src.main.functionality;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class CodingQuestionsSolution {

    /*Amazon is building a way to help customers search reviews quicker by providing real-time suggestions to search terms when the customer starts typing.
    When given a minimum of two characters into the search field the system will suggest at most three keywords from the review word repository.
    As the customer continues to type in the reviews search bar the relevant keyword suggestions will update automatically.
    Write an algorithm that will output a maximum of three keyword suggestions after each character is typed by the customer in the search field.
    If there are more than three acceptable keywords, return the keywords that are first in alphabetical order.*/

    //Suggests maximum of 3 product for each character being typed
    public static List<List<String>> searchSuggestionOnTyping(String[] products, String searchWord) {
        products = Arrays.stream(products)
                .map(String::toLowerCase)
                .toArray(String[]::new);
        searchWord = searchWord.toLowerCase();
        Arrays.sort(products);

        List<List<String>> result = new ArrayList<>();
        String prefix = "";

        for (char ch : searchWord.toCharArray()) {

            prefix += ch;
            if (prefix.length() >= 2) { //Only suggest when user has typed at least 2 characters
                int index = Arrays.binarySearch(products, prefix);

                if (index < 0)
                    index = -index -1;

                List<String> suggestions = new ArrayList<>();
                for (int i= index; i< Math.min(products.length, index+3); i++) {
                    if (products[i].startsWith(prefix)) {
                        suggestions.add(products[i]);
                    } else {
                        break;
                    }

                }
                result.add(suggestions);
            }

        }
        return result;

    }


    /*Amazon Fresh is running a promotion in which customers receive prizes for purchasing a secret combination of fruits.
    The combination will change each day, and the team running the promotion wants to use a code list to make it easy to change the combination.
    The code list contains groups of fruits. Both the order of the groups within the code list and the order of the fruits within the groups matter.
    However, between the groups of fruits, any number, and type of fruit is allowable. The term "anything" is used to allow for any type of fruit to appear in that location within the group.
    */
    public static int amazonFreshPrizeWinner(List<List<String>> codeList, List<String> shoppingCart) {
        if (codeList == null || codeList.isEmpty()) return 1;

        int i = 0; //index for codeList
        int j = 0; //index for shoppingCart

        while (i< codeList.size() && j< shoppingCart.size()) {
            List<String> currentGroup = codeList.get(i);
            int k = 0; //index for the currentGroup

            //Try to match currentGroup with shoppingCart starting from j
            while(j<shoppingCart.size() && k< currentGroup.size()) {
                String codeFruit = currentGroup.get(k);
                String cartFruit = shoppingCart.get(j);
                if (codeFruit.equals("anything") || codeFruit.equals(cartFruit)) {
                    k++;
                }
                j++;
            }
            // If the whole group is matched, move to the next group
            if (k == currentGroup.size()) {
                i++;
            } else {
                // If not matched, it means the shoppingCart doesn't follow the order for the group.
                return 0;
            }

        }
        return i == codeList.size() ? 1 : 0;
    }


    /*Amazon Logistics has multiple delivery centers from which products are sent.
    In one such delivery center, parcels are placed in a sequence where the parcel has a weight of weight[i].
    A shipment is constituted of a contiguous segment of parcels.
    The shipment imbalance of a shipment is defined as the difference between the maximum and minimum weights within a shipment.
    Given the arrangement of parcels, find the sum of shipment imbalance of all the shipments that can be formed from the given sequence of parcels.*/
    public static long getTotalImbalance(int[] weight) {
        int n = weight.length;
        long totalImbalance = 0;

        for (int i = 0; i < n; i++) {
            int min = weight[i];
            int max = weight[i];

            for (int j=i+1; j<n; j++) {
                min = Math.min(min, weight[j]);
                max = Math.max(max, weight[j]);

                totalImbalance += (max - min);
            }

        }
        return totalImbalance;
    }


    /*
    You are provided with a set A. A good range is the largest range of elements that contain only one element from the set A.
    You are also given a range of numbers from 1 to N and M queries. In each query, an integer X is added to the set A.
    For each query, your task is to print the sum of left and right border indices of all the available good ranges.

    For example, N = 10 and in the first query, 2 is added to the set A. The good range contains the range [1, 10] and the sum is 11.
    Here, [2,2] is also a range that contains only one element from the set, but it is not the largest one. Now, suppose 5 is added to the set,
    then the largest range that contains only 2 is [1, 4] and largest set that contains only 5 is [3, 10], therefore, the sum is 1 + 4 + 3 + 10 = 18

    Note: The set contains only distinct elements. Queries may contain some numbers repeated.
     */
    public static List<Integer> calculateGoodRanges(int N, int[] queries) {
        List<Integer> result = new ArrayList<>();
        TreeSet<Integer> set = new TreeSet<>();

        for (int x: queries) {
            set.add(x);
            int sum = 0;
            int prev = 0;

            for (int curr : set) {
                int left = prev == 0 ? 1 : (prev+curr)/2 + 1;
                int right = set.higher(curr) == null ? N : (curr + set.higher(curr))/2;
                sum += left+right;
                prev = curr;
            }
            result.add(sum);
        }

        return result;
    }

}
