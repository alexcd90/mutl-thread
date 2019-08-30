package com.icinfo.ch2;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年08月05
 */
public class TaxCalculatorMain {
    public static void main(String[] args) {
        TaxCalaculator calculator = new TaxCalaculator(10000d, 2000d, (s, b) -> s * 0.1 + b * 0.15);
        System.out.println(calculator.calculate());
    }
}
