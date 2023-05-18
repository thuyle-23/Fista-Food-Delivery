package com.example.fooddelivery.Activity;

import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fooddelivery.R;

public class VoucherInactivatedFragmentActivity extends Fragment {
    public VoucherInactivatedFragmentActivity(){

    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.layout_voucher_inactivated_fragment,container, false);
    }
}