package com.example.user.magnant.home.form_pemesanan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.user.magnant.MainActivity;
import com.example.user.magnant.R;

public class PembayaranActivity extends AppCompatActivity {
    Button btn_bayar;
    RadioGroup radioGroup;
    RadioButton transfer,dompet,virtual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pembayaran);

        transfer = findViewById(R.id.radioTransfer);
        dompet = findViewById(R.id.radioDompet);
        virtual = findViewById(R.id.radioVirtualAccount);
        radioGroup = findViewById(R.id.radio_group);
        btn_bayar = findViewById(R.id.btn_bayar);
        btn_bayar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                Toast.makeText(v.getContext(), "Fitur Controlling telah terbuka", Toast.LENGTH_SHORT).show();
                finish();
            }
        });


    }

    public void onRadioButtonClicked (View view){
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radioDompet:
                if (checked)
                    // Pirates are the best
                    break;
            case R.id.radioTransfer:
                if (checked)
                    // Ninjas rule
                    break;
            case R.id.radioVirtualAccount:
                if (checked)
                    // Ninjas rule
                    break;
        }
    }
}
