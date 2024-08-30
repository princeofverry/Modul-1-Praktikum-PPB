package com.example.aplikasimodul1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

    private EditText etUsernameLogin, etpasswrdlogin;
    private Button btnSignUpLogin, btnSignInLogin;
    String username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            initView();
            login();
            register();
            return insets;
        });
    }
        private void initView() {
            etUsernameLogin = findViewById(R.id.etUsernameLogin);
            etpasswrdlogin = findViewById(R.id.etPasswdLogin);
            btnSignInLogin = findViewById(R.id.btnSignInLogin);
            btnSignUpLogin = findViewById(R.id.btnSignUpLogin);
        }
        private void register(){
        btnSignUpLogin.setOnClickListener(V -> {
            // step ini ganti sesuai intent-nya
            Intent reg = new Intent(this, RegisterAct.class);
            startActivity(reg);
            finish();
        });
        }

        private Boolean validation(){
        username = etUsernameLogin.getText().toString();
        password = etpasswrdlogin.getText().toString();
            if(username.isEmpty()){
                Toast.makeText(this, "Isi Username Kawan!", Toast.LENGTH_SHORT).show();
                Log.e("validation", "false");
                return false;
            }
            if(password.isEmpty()){
                Toast.makeText(this, "Isi Password Kawan!", Toast.LENGTH_SHORT).show();
                Log.e("validation", "false");
                return false;
            }
            Log.e("validation", "true");
            return true;
        }

        private boolean loginData(){
        username = "verry";

        if(password.equals("1234")){
            Log.e("LoginData", "true");
            return true;
        } else {
            Log.e("loginData", "false");
            return false;
        }
        }

        private void actLogin(){
            if(validation()){
                if(loginData()){
                    Log.e("actLogin", "true");
                    // ganti intentnya sendiri yak!
                    Intent main = new Intent(this, MainActivity.class);
                    startActivity(main);
                    finish();
                } else {
                    Log.e("actLogin", "false");
                    Toast.makeText(this, "login gagal", Toast.LENGTH_LONG).show();
                }
            }
        }

        private void login(){
        btnSignInLogin.setOnClickListener(v -> actLogin());
        }


}