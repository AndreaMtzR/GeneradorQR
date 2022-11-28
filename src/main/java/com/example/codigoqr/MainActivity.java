package com.example.codigoqr;
//ANDREA MARTINEZ RUIZ 9/10/2022
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import com.google.zxing.BarcodeFormat;
import com.journeyapps.barcodescanner.BarcodeEncoder;


public class MainActivity extends AppCompatActivity {

    ImageView qrCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText txtDatos = findViewById(R.id.txtDatos);
        Button btnGenerar = findViewById(R.id.btnGenerar);
        qrCode = findViewById(R.id.qrCode);

        btnGenerar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                    Bitmap bitmap = barcodeEncoder.encodeBitmap(txtDatos.getText().toString(),BarcodeFormat.QR_CODE, 750,750);

                    qrCode.setImageBitmap(bitmap);



                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        });


    }
}