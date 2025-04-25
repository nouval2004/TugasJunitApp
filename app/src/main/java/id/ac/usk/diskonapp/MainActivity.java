package id.ac.usk.diskonapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edtHarga = findViewById(R.id.edtHarga);
        EditText edtDiskon = findViewById(R.id.edtDiskon);
        Button btnHitung = findViewById(R.id.btnHitung);
        TextView txtHasil = findViewById(R.id.txtHasil);

        btnHitung.setOnClickListener(v -> {
            String hargaStr = edtHarga.getText().toString();
            String diskonStr = edtDiskon.getText().toString();

            if (!hargaStr.isEmpty() && !diskonStr.isEmpty()) {
                double harga = Double.parseDouble(hargaStr);
                double diskon = Double.parseDouble(diskonStr);

                if (harga > 0 && diskon >= 0 && diskon <= 100) {
                    double hargaSetelahDiskon = DiscountCalculator.calculateDiscountedPrice(harga, diskon);
                    double jumlahDiskon = DiscountCalculator.calculateSavings(harga, diskon);

                    txtHasil.setText("Harga setelah diskon: Rp" + hargaSetelahDiskon + "\nHemat: Rp" + jumlahDiskon);
                } else {
                    txtHasil.setText("Masukkan angka yang valid!");
                }
            } else {
                txtHasil.setText("Mohon isi semua kolom!");
            }
        });
    }
}
