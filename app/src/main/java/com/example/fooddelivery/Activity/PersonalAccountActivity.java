package com.example.fooddelivery.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fooddelivery.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Map;

public class PersonalAccountActivity extends AppCompatActivity {
    private ImageView imgBack;
    private TextView txtLogOut , deleteAccount;
    private String Id;
    EditText fullname_edit , numberphone_edit ,email_edit, gender_edit,dateOfBirth_edit,Career_edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_personal_account);
        TextView txtInputPassword = findViewById(R.id.txtInputPassword);
        txtLogOut = findViewById(R.id.txtLogOut);
        imgBack = findViewById(R.id.imgBack);
        deleteAccount = findViewById(R.id.txtView);


        fullname_edit = findViewById(R.id.nameEditText);
        numberphone_edit = findViewById(R.id.edittxtphoneNumber);
        email_edit = findViewById(R.id.edittxtemailAddress);
        gender_edit = findViewById(R.id.edittxtGender);
        dateOfBirth_edit= findViewById(R.id.edittxtDOB);
        Career_edit = findViewById(R.id.edittxtJobOccupation);
        numberphone_edit = findViewById(R.id.edittxtphoneNumber);

//         show data profile
        gettingdata();

        deleteAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseFirestore db = FirebaseFirestore.getInstance();
                db.collection("users")
                                .document(Id).delete()
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        Log.d("TAG","DELETED ACCOUNT !!!");
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.d("TAG","Failed DELETED ACCOUNT !!!");
                            }
                        });
                backToAccountPage();
            }
        });

        txtInputPassword.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openChangePasswordPage();
            }
        });
        txtLogOut.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
        imgBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                backToAccountPage();
            }
        });
    }
    public void openChangePasswordPage(){
        Intent intent = new Intent(PersonalAccountActivity.this, ChangePasswordActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
    public void backToAccountPage(){
        Intent intent = new Intent(PersonalAccountActivity.this, AccountActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_out_right, R.anim.slide_in_left);
    }
    public void SignOut(){
        Intent intent = new Intent(PersonalAccountActivity.this, DashboardActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_out_right, R.anim.slide_in_left);
    }
    public void gettingdata(){
        Intent intent = getIntent();

        String nameUser = intent.getStringExtra("name");
        String emailUser = intent.getStringExtra("email");
        String PhoneUser = intent.getStringExtra("Phone");
        String genderUser = intent.getStringExtra("gender");
        String dateofBirth = intent.getStringExtra("date");
        String Career = intent.getStringExtra("Career");
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("users").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            for(QueryDocumentSnapshot document : task.getResult()){
                                Map<String,Object> data = document.getData();
                                Id = document.getId();
                                fullname_edit.setText(data.get("fullName").toString());
                                email_edit.setText(data.get("emailAddress").toString());
                                numberphone_edit.setText(data.get("phoneNumber").toString());
                                gender_edit.setText(data.get("gender").toString());
                                dateOfBirth_edit.setText(data.get("dateOfBirth").toString());
                                Career_edit.setText(data.get("jobOccupation").toString());
                            }
                        }else{
                            fullname_edit.setText("");
                            email_edit.setText("");
                            numberphone_edit.setText("");
                            gender_edit.setText("");
                            dateOfBirth_edit.setText("");
                            Career_edit.setText("");
                        }
                    }
                });


    }
}