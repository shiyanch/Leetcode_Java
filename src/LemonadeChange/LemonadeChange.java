package LemonadeChange;

/**
 * 860. Lemonade Change
 *
 * At a lemonade stand, each lemonade costs $5. Customers are standing in a queue to buy from you and order one at a
 * time (in the order specified by bills). Each customer will only buy one lemonade and pay with either a $5, $10,
 * or $20 bill. You must provide the correct change to each customer so that the net transaction is that the customer
 * pays $5.
 *
 * Note that you do not have any change in hand at first.
 *
 * Given an integer array bills where bills[i] is the bill the ith customer pays, return true if you can provide every
 * customer with the correct change, or false otherwise.
 */
public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int count5 = 0;
        int count10 = 0;

        for (int bill : bills) {
            switch (bill) {
                case 5:
                    count5++;
                    break;
                case 10:
                    if (count5 > 0) {
                        count5--;
                        count10++;
                        break;
                    } else {
                        return false;
                    }
                case 20:
                    if (count10 > 0 && count5 > 0) {
                        count10--;
                        count5--;
                        break;
                    }
                    if (count5 >= 3) {
                        count5 -= 3;
                        break;
                    }
                    return false;
                default:
                    return false;
            }
        }
        return true;
    }
}
