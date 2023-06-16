package com.example.fooddelivery.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fooddelivery.Adapter.AdapterAddressItem;
import com.example.fooddelivery.Model.Address;
import com.example.fooddelivery.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class AddressBookActivity extends AppCompatActivity implements AdapterAddressItem.IClickItem {
    private ImageView imgBack;
    private TextView txtviewAddNewLocation;
    private RecyclerView recyclerView;

    private AdapterAddressItem adapterAddressItem ;
    private List<String> listAddress = new ArrayList<>();
    private List<Address> addressList = new ArrayList<>();

    //FirebaseDatabase db = FirebaseDatabase.getInstance();
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_address_book);
        recyclerView = findViewById(R.id.rcv_recommend);
        imgBack = findViewById(R.id.imgBack);
        txtviewAddNewLocation = findViewById(R.id.txtviewAddNewLocation);

        adapterAddressItem = new AdapterAddressItem(this, R.layout.item_address, listAddress,this);

        recyclerView.setAdapter(adapterAddressItem);
        db.collection("locationmap").get().addOnSuccessListener(queryDocumentSnapshots ->{
            listAddress.clear();
            for (QueryDocumentSnapshot document : queryDocumentSnapshots) {

                String id = document.getId();
                Address obj = document.toObject(Address.class);
                obj.setId(id);


                listAddress.add(obj.getNameAddress()+", "+ obj.getNameStreet()+"\n"+
                        obj.getCityname()+", "+obj.getSuburName());

                addressList.add(obj);
            }

            adapterAddressItem.notifyDataSetChanged();
        });

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToAccountPage();
            }
        });
        txtviewAddNewLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddNewLocationPage();
            }
        });

    }
    public void onLoad(){

    }

    public void backToAccountPage() {
        Intent intent = new Intent(AddressBookActivity.this, AccountActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_out_right, R.anim.slide_in_left);
    }
    public void openAddNewLocationPage(){
        Intent intent = new Intent(AddressBookActivity.this, AddLocationnActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    @Override
    public void setPosition(int position) {

        Intent intent = new Intent(AddressBookActivity.this, AddLocationnActivity.class);

        Bundle bundle = new Bundle();
        bundle.putParcelable("address", addressList.get(position));

        intent.putExtras(bundle);

        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
}