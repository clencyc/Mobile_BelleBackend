package com.home.nature;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.home.nature.admin.CreateTransaction;
import com.home.nature.admin.UpdateTrans;
import com.home.nature.admin.dashboard;
import com.home.nature.entity.PaymentEntity;
import com.home.nature.repo.PaymentRepo;

import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView recyclerView;
    Button createTransactionBtn;
    TextInputLayout textInputLayout;
    ImageView my_Imageview;
    TextInputEditText textInputEditText;
    private List<PaymentEntity> paymentEntityList;
    private Adapter paymentAdapter;
    private PaymentRepo paymentRepo;
    TextView noData;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.main_rv);
        createTransactionBtn = findViewById(R.id.admin_d_create_t);
        noData = findViewById(R.id.no_data);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        paymentAdapter = new Adapter();
        recyclerView.setAdapter(paymentAdapter);
        getPayments();
        createTransactionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), CreateTransaction.class));
            }
        });
    }


    public void onClick(View my_Imageview) {
        // Create an Intent to start the UpdateTrans activity
        Intent intent = new Intent(MainActivity.this, UpdateTrans.class);
        // Start the UpdateTrans activity
        startActivity(intent);
    }

    private void getPayments(){
        paymentRepo = new PaymentRepo(getApplication());
        paymentRepo.getAllPayments().observe(MainActivity.this, new Observer<List<PaymentEntity>>() {
            @Override
            public void onChanged(List<PaymentEntity> paymentEntities) {
                if(paymentEntities.size() < 1){
                    recyclerView.setVisibility(View.GONE);
                    textInputLayout.setVisibility(View.GONE);
                    noData.setVisibility(View.VISIBLE);
                    return;
                }

                // update adapter with new list of payments
                paymentAdapter.setPaymentList(paymentEntities);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.login_as_admin, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.login_admin) {
            startActivity(new Intent(MainActivity.this, SignIn.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}