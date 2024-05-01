package com.home.nature.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.home.nature.R;
import com.home.nature.entity.PaymentEntity;
import com.home.nature.repo.PaymentRepo;
import java.util.Date;

public class UpdateTrans extends AppCompatActivity {

    Button updateBtn;
    TextInputLayout firstNameIL, lastNameIl, amountIl;
    TextInputEditText firstNameET, lastNameET, amountET;
    ProgressBar progressBar;
    TextView goBack;
    Spinner typeS;
    String selectedTransactionType;
    private PaymentEntity payment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_trans);

        if(getIntent() == null && getIntent().hasExtra("payment")){
            finish();
        }

        payment = (PaymentEntity) getIntent().getSerializableExtra("payment");

        updateBtn = findViewById(R.id.update_transaction_btn);
        firstNameIL = findViewById(R.id.firstname_il_u);
        lastNameIl = findViewById(R.id.lastname_il_u);
        firstNameET = findViewById(R.id.firstname_et_u);
        lastNameET = findViewById(R.id.lastname_et_u);
        amountIl = findViewById(R.id.amount_il_u);
        amountET = findViewById(R.id.amount_et_u);
        progressBar = findViewById(R.id.ct_pb_u);
        goBack = findViewById(R.id.go_back_tv);
        typeS = findViewById(R.id.type_spinner_u);

        firstNameET.setText(payment.getFirstName());
        lastNameET.setText(payment.getLastName());
        amountET.setText(String.valueOf(payment.getAmount()));

        // Set up the spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.transaction_type, androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeS.setAdapter(adapter);

        // Set the selected item in the spinner based on the transaction type
        if (payment.getTransactionType() != null) {
            int selectionIndex = adapter.getPosition(payment.getTransactionType().toString());
            typeS.setSelection(selectionIndex);
        }

        typeS.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedTransactionType = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateClicked();
                bClicked(true);
            }
        });
    }

    private void updateClicked(){
        String firstN = firstNameET.getText().toString().trim();
        String lastN = lastNameET.getText().toString().trim();
        String amntS = amountET.getText().toString().trim();

        if(firstN.isEmpty() || lastN.isEmpty() || amntS.isEmpty() || selectedTransactionType.isEmpty()){
            bClicked(false);
            Toast.makeText(this, "All fields are required.", Toast.LENGTH_LONG).show();
        }else{
            char type = ' ';
            if(selectedTransactionType.equals("Sent")){
                type='S';
            }else if(selectedTransactionType.equals("Received")){
                type='R';
            }
            double Amount = Double.parseDouble(amntS);
            firstN = firstN.substring(0, 1).toUpperCase() + firstN.substring(1);
            lastN = lastN.substring(0, 1).toUpperCase() + lastN.substring(1);
            callUpdateInBg(firstN, lastN, Amount, type);
        }
    }

    private void callUpdateInBg(String firstN, String lastN, double amount, char type) {
        Log.e("Update ", "call 1");
        new Thread(new Runnable() {
            @Override
            public void run() {
                PaymentRepo paymentRepo = new PaymentRepo(getApplication());
                PaymentEntity paymentObj = new PaymentEntity(amount,type,firstN,lastN, payment.getCreatedAt());
                paymentObj.setUpdatedAt(new Date());
                paymentObj.setPaymentID(payment.getPaymentID());
                paymentRepo.update(paymentObj);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.d("Update ", "call 2");
                        Toast.makeText(UpdateTrans.this, "Payment added successfully.", Toast.LENGTH_LONG).show();
                        bClicked(false);
                        finish();
                    }
                });
            }
        }).start();
    }


    private void bClicked(boolean status){
        if(status){
            updateBtn.setEnabled(false);
            updateBtn.setVisibility(View.GONE);
            progressBar.setVisibility(View.VISIBLE);
        }else{
            updateBtn.setEnabled(true);
            updateBtn.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.GONE);
        }
    }
}