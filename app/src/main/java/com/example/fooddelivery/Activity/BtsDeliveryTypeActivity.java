package com.example.fooddelivery.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.fooddelivery.R;

public class BtsDeliveryTypeActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private ImageView iv_edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_bts_delivery_type);
        iv_edit = (ImageView) findViewById(R.id.iv_edit);

        iv_edit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                BtsDeliveryTypeActivity.this.finish();
            }
        });
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioButton1:
                if (checked)
                    break;
            case R.id.radioButton2:
                if (checked)
                    break;
        }
    }
}