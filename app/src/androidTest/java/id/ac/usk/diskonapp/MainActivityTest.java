package id.ac.usk.diskonapp;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static androidx.test.espresso.assertion.ViewAssertions.matches;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    /*
     * Test Case 1: Menguji apakah perhitungan diskon di UI berfungsi dengan benar.
     * Langkah pengujian:
     * 1. Ketik harga "100000" di input harga.
     * 2. Ketik diskon "20" di input diskon.
     * 3. Tekan tombol "Hitung".
     * Expected Output: Hasil yang ditampilkan di UI harus "Harga setelah diskon: Rp80000.0\nHemat: Rp20000.0".
     */
    @Test
    public void testDiscountCalculation() {
        onView(withId(R.id.edtHarga)).perform(typeText("100000"), closeSoftKeyboard());
        onView(withId(R.id.edtDiskon)).perform(typeText("20"), closeSoftKeyboard());
        onView(withId(R.id.btnHitung)).perform(click());
        onView(withId(R.id.txtHasil)).check(matches(withText("Harga setelah diskon: Rp80000.0\nHemat: Rp20000.0")));
    }

    /*
     * Test Case 2: Memastikan validasi input bekerja jika field kosong.
     * Langkah pengujian:
     * 1. Langsung tekan tombol "Hitung" tanpa memasukkan input.
     * Expected Output: Pesan error "Mohon isi semua kolom!" harus muncul di UI.
     */
    @Test
    public void testEmptyInputValidation() {
        onView(withId(R.id.btnHitung)).perform(click());
        onView(withId(R.id.txtHasil)).check(matches(withText("Mohon isi semua kolom!")));
    }
}
