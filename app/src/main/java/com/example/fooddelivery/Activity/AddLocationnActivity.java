package com.example.fooddelivery.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.fooddelivery.R;

public class AddLocationnActivity extends AppCompatActivity {
    private ImageView imgBack;
    private Button btnSave;
    private EditText edittxtNameAddress, edittxtStreetName,
            edittxtCityName, edittxtSuburbName, edittxtNote;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_add_locationn);

        imgBack = findViewById(R.id.imgBack);
        btnSave = findViewById(R.id.btnSave);
        edittxtNameAddress = findViewById(R.id.edittxtNameAddress);
        edittxtStreetName = findViewById(R.id.edittxtStreetName);
        edittxtCityName = findViewById(R.id.edittxtCityName);
        edittxtSuburbName = findViewById(R.id.edittxtSuburbName);
        edittxtNote = findViewById(R.id.edittxtNote);

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToAddressBookPage();
            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToAddressBookPage();
            }
        });
        edittxtNameAddress.setOnFocusChangeListener(new View.OnFocusChangeListener(){
            @Override
            public void onFocusChange(View v, boolean hasFocus){
                if(!hasFocus){
                    hideKeyboard(v);
                }
            }
        });
        edittxtStreetName.setOnFocusChangeListener(new View.OnFocusChangeListener(){
            @Override
            public void onFocusChange(View v, boolean hasFocus){
                if(!hasFocus){
                    hideKeyboard(v);
                }
            }
        });
        edittxtCityName.setOnFocusChangeListener(new View.OnFocusChangeListener(){
            @Override
            public void onFocusChange(View v, boolean hasFocus){
                if(!hasFocus){
                    hideKeyboard(v);
                }
            }
        });
        edittxtSuburbName.setOnFocusChangeListener(new View.OnFocusChangeListener(){
            @Override
            public void onFocusChange(View v, boolean hasFocus){
                if(!hasFocus){
                    hideKeyboard(v);
                }
            }
        });
        edittxtNote.setOnFocusChangeListener(new View.OnFocusChangeListener(){
            @Override
            public void onFocusChange(View v, boolean hasFocus){
                if(!hasFocus){
                    hideKeyboard(v);
                }
            }
        });
    }
    public void backToAddressBookPage() {
        Intent intent = new Intent(AddLocationnActivity.this, AddressBookActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_out_right, R.anim.slide_in_left);
    }

    public void hideKeyboard(View view){
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}