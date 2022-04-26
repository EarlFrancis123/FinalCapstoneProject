package com.evacuationapp.finalevacuationapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class SignUpActivity extends AppCompatActivity {

    private EditText emailSignUp , passSignUp, SingUpPhoneNumber,SignUpAddress;
    private Button signUpBtn;
    private TextView signINText;
    private FirebaseAuth auth;
    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference root = db.getReference().child("Staff");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        auth = FirebaseAuth.getInstance();

        emailSignUp = findViewById(R.id.sign_up_email);
        passSignUp = findViewById(R.id.sing_up_pass);
        SingUpPhoneNumber = findViewById(R.id.sing_up_phonenumber);
        SignUpAddress = findViewById(R.id.sing_up_address);
        signUpBtn = findViewById(R.id.sign_up_btn);
        signINText = findViewById(R.id.sign_in_text);



        signINText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUpActivity.this , SignInActivity.class));
            }
        });



        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailSignUp.getText().toString();
                String pass = passSignUp.getText().toString();

                if (!email.isEmpty() && !pass.isEmpty()){
                    auth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                String address = SignUpAddress.getText().toString();
                                String number = SingUpPhoneNumber.getText().toString();
                                String email = emailSignUp.getText().toString();
                                String password = passSignUp.getText().toString();
                                HashMap<String, String> userMap = new HashMap<>();


                                userMap.put("address", address);
                                userMap.put("number", number);
                                userMap.put("password", password);
                                userMap.put("email", email);

                                root.push().setValue(userMap);

                                Toast.makeText(SignUpActivity.this, "REgistered Successfully !!", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(SignUpActivity.this , SetUpActivity.class));
                                finish();
                            }else{
                                Toast.makeText(SignUpActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }else{
                    Toast.makeText(SignUpActivity.this, "Please Enter Email and Password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}