package com.home.nature.admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.home.nature.MainActivity;
import com.home.nature.R;
import com.home.nature.SignIn;
import com.home.nature.entity.PaymentEntity;
import com.home.nature.repo.PaymentRepo;

import java.util.List;
import java.util.Objects;

public class dashboard extends AppCompatActivity {
    Toolbar toolbar;
    Button createTransactionBtn;
    RecyclerView recyclerView;
    private List<PaymentEntity> paymentEntityList;
    private Adapter paymentAdapter;
    private PaymentRepo paymentRepo;
    TextView noData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        toolbar = findViewById(R.id.admin_d_tb);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);

        createTransactionBtn = findViewById(R.id.admin_d_create_t);
        recyclerView = findViewById(R.id.admin_d_rv);
        noData = findViewById(R.id.admin_d_no_tv);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        paymentAdapter = new Adapter(dashboard.this);
        recyclerView.setAdapter(paymentAdapter);
        getPayments();

        createTransactionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(dashboard.this, CreateTransaction.class));
            }
        });

    }

    private void getPayments(){
        paymentRepo = new PaymentRepo(getApplication());
        paymentRepo.getAllPayments().observe(dashboard.this, new Observer<List<PaymentEntity>>() {
            @Override
            public void onChanged(List<PaymentEntity> paymentEntities) {
                if(paymentEntities.size() < 1){
                    recyclerView.setVisibility(View.GONE);
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
        getMenuInflater().inflate(R.menu.admin_logout, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.admin_logout){
            startActivity(new Intent(dashboard.this, MainActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}