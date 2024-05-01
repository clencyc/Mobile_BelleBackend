package com.home.nature;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.home.nature.admin.dashboard;
import com.home.nature.databinding.ActivitySignInBinding;
import com.home.nature.entity.UserEntity;
import com.home.nature.repo.UserRepository;

public class SignIn extends AppCompatActivity {

    ProgressBar progressBar;
    Button button;
    EditText emailAddress, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        progressBar = findViewById(R.id.signIn_pb);
        button = findViewById(R.id.signIn_btn);
        emailAddress = findViewById(R.id.signIn_e_et);
        password = findViewById(R.id.signIn_pwd_et);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bClicked(true);
                userClick();
                Intent intent = new Intent(SignIn.this, Home.class);
                // Start the HomeActivity
                startActivity(intent);
            }
        });
    }

    private void userClick(){
        String email = emailAddress.getText().toString().trim();
        String passwordValue = password.getText().toString().trim();

        if(email.isEmpty() || passwordValue.isEmpty()){
            bClicked(false);
            emailAddress.setError("Required");
            password.setError("Required");
            Toast.makeText(this, "All fields are required.", Toast.LENGTH_LONG).show();
        }else{
            // perform login asynchrously
            loginAdmin(email, passwordValue);
        }
    }

    private void loginAdmin(String email, String pwd){
        new Thread(new Runnable() {
            @Override
            public void run() {
                UserRepository userRepository = new UserRepository(getApplication());
                UserEntity adminUser = userRepository.login(email, pwd);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        bClicked(false);
                    }
                });
                if(adminUser == null){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(SignIn.this, "Wrong credentials", Toast.LENGTH_LONG).show();
                        }
                    });
                }else{
                    startActivity(new Intent(SignIn.this, Home.class));
                }
            }
        }).start();
    }

    private void bClicked(boolean status){
        if(status){
            button.setEnabled(false);
            button.setVisibility(View.GONE);
            progressBar.setVisibility(View.VISIBLE);
        }else{
            button.setEnabled(true);
            button.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.GONE);
        }
    }

}