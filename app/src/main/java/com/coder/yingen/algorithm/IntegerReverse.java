package com.coder.yingen.algorithm;

import android.os.Build;
import android.support.annotation.RequiresApi;

/**
 * Create by Alex Chu on
 */
@RequiresApi(api = Build.VERSION_CODES.KITKAT)
public class IntegerReverse implements AutoCloseable {
    public static void main(String[] args) {
        System.out.println(reverse( 302) + "****");
    }

    public static int reverse(int x) {
        int rev = 0;
        while ( x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE /10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE /10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    @Override
    public void close() throws Exception {

    }
}
