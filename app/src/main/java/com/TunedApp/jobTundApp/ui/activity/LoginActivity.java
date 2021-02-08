package com.TunedApp.jobTundApp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.TunedApp.jobTundApp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {


    static  boolean flagLogin=false;
    @BindView(R.id.ed_email)
    TextInputEditText edEmail;
    @BindView(R.id.ed_password)
    TextInputEditText edPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.txv_signUp)
    TextView txvSignUp;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();


    }

    @OnClick({R.id.btn_login, R.id.txv_signUp})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
//                String email = edEmail.getText().toString();
//                String password = edPassword.getText().toString();
//                if (email.isEmpty()) {
//                    Toast.makeText(LoginActivity.this, "Email is  Empty",
//                            Toast.LENGTH_SHORT).show();
//                    return;
//                }
//
//                if (password.isEmpty()) {
//                    Toast.makeText(LoginActivity.this, "password is  Empty",
//                            Toast.LENGTH_SHORT).show();
//                    return;
//                }
//                loginUser("email", "password");

                Intent intent2 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent2);
                finish();
                break;
            case R.id.txv_signUp:

                Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
                startActivity(intent);

                break;
        }
    }

    private void loginUser(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

//                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//                        startActivity(intent);
//                        finish();

//                        if (task.isSuccessful()) {
//                            // Sign in success, update UI with the signed-in user's information
//                            Log.d("result", "createUserWithEmail:success");
//                            Toast.makeText(LoginActivity.this, String.valueOf(task.getException()),
//                                    Toast.LENGTH_SHORT).show();
//                            flagLogin=true;
//                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//                            startActivity(intent);
//                            finish();
//
//
//                        } else {
//                            // If sign in fails, display a message to the user.
//                            Log.w("TAG", "createUserWithEmail:failure", task.getException());
//                            Toast.makeText(LoginActivity.this, String.valueOf(task.getException()),
//                                    Toast.LENGTH_SHORT).show();
//
//                        }


                    }
                });
    }


}
