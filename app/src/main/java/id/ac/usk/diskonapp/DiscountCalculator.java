package id.ac.usk.diskonapp;

/* Kelas ini berisi fungsi untuk menghitung diskon */
public class DiscountCalculator {
    public static double calculateDiscountedPrice(double harga, double diskon) {
        return harga - (harga * (diskon / 100));
    }

    public static double calculateSavings(double harga, double diskon) {
        return harga * (diskon / 100);
    }
}
