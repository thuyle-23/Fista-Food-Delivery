package com.example.fooddelivery.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.fooddelivery.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ChangePasswordActivity extends AppCompatActivity {
    private ImageView imgBack;
    private Button btnSave ;
    private EditText edtPassword ;
    private EditText edtPasswrodConfirm ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_change_password);

        imgBack = findViewById(R.id.imgBack);
        btnSave = findViewById(R.id.btnChangePasssword);
        edtPassword = findViewById(R.id.edittxtInputNewPassword);
        edtPasswrodConfirm = findViewById(R.id.edittxtConfirmPassword);

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToEnterPasswordPage();
            }
        });


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pass  = edtPassword.getText().toString().trim();
                String passConfirm = edtPasswrodConfirm.getText().toString().trim();

                if (pass.length() >= 8 && pass.equals(passConfirm)){
                    FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
                    if (firebaseUser != null) {
                        
                        firebaseUser.updatePassword(pass).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                
                                if (task.isSuccessful()){
                                    Toast.makeText(ChangePasswordActivity.this, "Cập nhập mật khẩu thành công", Toast.LENGTH_SHORT).show();
                                }
                                
                            }
                        });
                        
                    }
                }
                else {
                    if (pass.length() < 8 ) {
                        Toast.makeText(ChangePasswordActivity.this, "Độ dài mật khẩu ít nhất 8 ký tự !", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(ChangePasswordActivity.this, "Mật khẩu không khớp", Toast.LENGTH_SHORT).show();

                    }
                }

            }
        });


    }
    public void backToEnterPasswordPage() {
        Intent intent = new Intent(ChangePasswordActivity.this, EnterPasswordActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_out_right, R.anim.slide_in_left);
    }
}