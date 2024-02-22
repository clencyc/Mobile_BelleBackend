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
import com.home.nature.R;
import com.home.nature.entity.PaymentEntity;
import com.home.nature.entity.UserEntity;
import com.home.nature.repo.PaymentRepo;

import java.util.Date;

public class CreateTransaction extends AppCompatActivity {

    Button createTransactionBtn;
    ProgressBar progressBar;
    TextInputEditText firstName, lastName, amount;
    Spinner transactiontype;
    String selectedTransactionType;
    TextView goBackTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_transaction);

        createTransactionBtn = findViewById(R.id.create_transaction_btn);
        progressBar = findViewById(R.id.ct_pb);
        firstName = findViewById(R.id.firstname_et);
        lastName = findViewById(R.id.lastname_et);
        amount = findViewById(R.id.amount_et);
        transactiontype = findViewById(R.id.type_spinner);
        goBackTV = findViewById(R.id.go_back_tv);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.transaction_type, androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        transactiontype.setAdapter(adapter);

        transactiontype.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedTransactionType = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        createTransactionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adminCreateTransaction();
                bClicked(true);
            }
        });

        goBackTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    private void clearInput(){
        firstName.setText("");
        lastName.setText("");
        amount.setText("");
    }

    private void adminCreateTransaction(){
        String firstN = firstName.getText().toString().trim();
        String lastN = lastName.getText().toString().trim();
        String amntS = amount.getText().toString().trim();

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
            callInsertionInBg(firstN, lastN, Amount, type);
        }
    }

    private void callInsertionInBg(String firstN, String lastN, double amount, Character type) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                PaymentRepo paymentRepo = new PaymentRepo(getApplication());
                PaymentEntity payment = new PaymentEntity(amount,type,firstN,lastN, new Date());
                Log.e("E21",payment.toString());
                paymentRepo.insert(payment);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(CreateTransaction.this, "Payment added successfully.", Toast.LENGTH_LONG).show();
                        clearInput();
                        bClicked(false);
                    }
                });
            }
        }).start();
    }

    private void bClicked(boolean status){
        if(status){
            createTransactionBtn.setEnabled(false);
            createTransactionBtn.setVisibility(View.GONE);
            progressBar.setVisibility(View.VISIBLE);
        }else{
            createTransactionBtn.setEnabled(true);
            createTransactionBtn.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.GONE);
        }
    }

}