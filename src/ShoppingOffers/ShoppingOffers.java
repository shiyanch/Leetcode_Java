package ShoppingOffers;

import java.util.List;

/**
 * 638. Shopping Offers
 *
 * In LeetCode Store, there are some kinds of items to sell. Each item has a price.
 * However, there are some special offers,
 * and a special offer consists of one or more different kinds of items with a sale price.
 *
 * You are given the each item's price, a set of special offers,
 * and the number we need to buy for each item.
 *
 * The job is to output the lowest price you have to pay for exactly certain items as given,
 * where you could make optimal use of the special offers.
 *
 * Each special offer is represented in the form of an array,
 * the last number represents the price you need to pay for this special offer,
 * other numbers represents how many specific items you could get if you buy this offer.
 * You could use any of special offers as many times as you want.
 */
public class ShoppingOffers {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int result = Integer.MAX_VALUE;
        for (List<Integer> offer: special) {
            boolean invalid = false;
            for (int i=0; i<needs.size(); i++) {
                int remain = needs.get(i) - offer.get(i);
                needs.set(i, remain);
                // 必须保证needs全部走完，否则后面不好恢复
                if (!invalid && remain < 0) {
                    invalid = true;
                }
            }
            if (!invalid) {
                result = Math.min(result, shoppingOffers(price, special, needs) + offer.get(needs.size()));
            }

            for (int i=0; i<needs.size(); i++) {
                needs.set(i, needs.get(i)+offer.get(i));
            }
        }

        int noOfferPrice = 0;
        for (int i=0; i<needs.size(); i++) {
            noOfferPrice += price.get(i) * needs.get(i);
        }

        return Math.min(noOfferPrice, result);
    }
}
