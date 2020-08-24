package com.example.sliderambulan;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class ListRSActivity extends AppCompatActivity {
    private FirebaseFirestore db12;
    private RecyclerView mFireStoreList;
    private FirestoreRecyclerAdapter adapter;




    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daftar_rs);


        db12 = FirebaseFirestore.getInstance();
        mFireStoreList = findViewById(R.id.firestore_list);


        //Query
        Query query = db12.collection("list_rs");


        //RecyclerOptions
        FirestoreRecyclerOptions<NamaModel> options = new FirestoreRecyclerOptions.Builder<NamaModel>()
                .setQuery(query, NamaModel.class)
                .build();
        adapter = new FirestoreRecyclerAdapter<NamaModel, NamaRSHolder>(options) {
            @NonNull
            @Override
            public NamaRSHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_rs, parent, false);
                return new NamaRSHolder(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull NamaRSHolder holder, int position, @NonNull NamaModel model) {
                holder.list_nama.setText(model.getNama());
                holder.list_alamat.setText(model.getAlamat());
                holder.cek_button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent goDetail = new Intent(ListRSActivity.this, DetailActivity.class);
                        startActivity(goDetail);
                        finish();
                    }
                });

            }
        };
        mFireStoreList.setHasFixedSize(true);
        mFireStoreList.setLayoutManager(new LinearLayoutManager(this));
        mFireStoreList.setAdapter(adapter);
        //ViewHolder
    }

    private class NamaRSHolder extends RecyclerView.ViewHolder{

        private TextView list_nama;
        private TextView list_alamat;
        Button cek_button;

        public NamaRSHolder(@NonNull View itemView) {
            super(itemView);

            list_nama = itemView.findViewById(R.id.list_name);
            list_alamat = itemView.findViewById(R.id.list_alamat);
            cek_button = itemView.findViewById(R.id.cek_button);

        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }
}
