package de.zeroxtv.zcore.OtherUtil;

import java.text.DecimalFormat;

/**
 * Created by ZeroxTV
 */
public class NumberUtils {
    public static double parseDouble(double toParse, int decimals) {
        String pattern = "#.";
        for (int i = 0; i < decimals; i++) {
            pattern = pattern + "#";
        }
        DecimalFormat df = new DecimalFormat(pattern);
        return Double.valueOf(df.format(toParse));
    }
}
