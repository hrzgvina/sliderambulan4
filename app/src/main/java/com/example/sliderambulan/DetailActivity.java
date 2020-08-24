package com.example.sliderambulan;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Map;

public class DetailActivity extends AppCompatActivity {
    TextView nama_rumahsakit, alamat_rumahsakit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);
        FirebaseFirestore db12 = FirebaseFirestore.getInstance();

        nama_rumahsakit = findViewById(R.id.nama_rumahsakit);
        alamat_rumahsakit = findViewById(R.id.alamat_rs);

        db12.collection("list_rs").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        String nama_rs, alamat_rs;

                        nama_rs = document.getString("nama");
                        alamat_rs = document.getString("alamat");

                        nama_rumahsakit.setText(nama_rs);
                        alamat_rumahsakit.setText(alamat_rs);

                    }

                }
            }
        });
    }
}
