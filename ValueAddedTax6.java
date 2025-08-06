package mironov.sergey;

public class ValueAddedTax6 {
    public static int taxEarnings(int earnings) {
        int tax1 = earnings / 100 * 6;
        if (tax1 >= 0) {
            return tax1;
        } else {

            return 0;
        }

    }
}
