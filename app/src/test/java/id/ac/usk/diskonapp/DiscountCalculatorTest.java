package id.ac.usk.diskonapp;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class DiscountCalculatorTest {

    /*
     * Test Case 1: Memeriksa apakah harga setelah diskon dihitung dengan benar.
     * Input: Harga = 100000, Diskon = 20%
     * Expected Output: 80000
     */
    @Test
    public void testCalculateDiscountedPrice() {
        double result = DiscountCalculator.calculateDiscountedPrice(100000, 20);
        assertEquals(80000, result, 0.01);
    }

    /*
     * Test Case 2: Memeriksa apakah jumlah diskon yang dikurangi benar.
     * Input: Harga = 200000, Diskon = 10%
     * Expected Output: 20000
     */
    @Test
    public void testCalculateSavings() {
        double result = DiscountCalculator.calculateSavings(200000, 10);
        assertEquals(20000, result, 0.01);
    }

    /*
     * Test Case 3: Memeriksa apakah harga tetap sama jika diskon adalah 0%.
     * Input: Harga = 50000, Diskon = 0%
     * Expected Output: 50000
     */
    @Test
    public void testNoDiscount() {
        double result = DiscountCalculator.calculateDiscountedPrice(50000, 0);
        assertEquals(50000, result, 0.01);
    }
}
