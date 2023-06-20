package com.example.fooddelivery.Activity;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.fooddelivery.Model.Address;
import com.example.fooddelivery.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class AddLocationnActivity extends AppCompatActivity {

    private String Id;

    private ImageView imgBack;
    private Button btnSave;
    private TextView deleteText;
    EditText NameAddress, StreetName,
            CityName, SuburbName, Note;

    private String id = "";

    FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference reference = db.getReference().child("");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_add_locationn);

        imgBack = findViewById(R.id.imgBack);
        btnSave = findViewById(R.id.btnSave);
        NameAddress = findViewById(R.id.edittxtNameAddress);
        StreetName = findViewById(R.id.edittxtStreetName);
        CityName = findViewById(R.id.edittxtCityName);
        SuburbName = findViewById(R.id.edittxtSuburbName);
        Note = findViewById(R.id.edittxtNote);
        deleteText = findViewById(R.id.txtDeleteLocation);

        Intent intent = getIntent();

        if (intent != null) {

            Bundle bundle = intent.getExtras();
            if (bundle != null) {

                Address address = bundle.getParcelable("address");
                if (address != null) {
                    Log.d("onCreate: ", address + " ");
                    NameAddress.setText(address.getNameAddress());
                    StreetName.setText(address.getNameStreet());
                    CityName.setText(address.getCityname());
                    SuburbName.setText(address.getSuburName());
                    Note.setText(address.getNote());
                    id = address.getId();
                    Log.d("detailID =", id);
                }

            }

        }


        FirebaseFirestore db = FirebaseFirestore.getInstance();
        onLoad();
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Address = NameAddress.getText().toString();
                String Street = StreetName.getText().toString();
                String City = CityName.getText().toString();
                String suburb = SuburbName.getText().toString();
                String note = Note.getText().toString();

                Map<String, Object> locationmap = new HashMap<>();

                locationmap.put("nameAddress", Address);
                locationmap.put("nameStreet", Street);
                locationmap.put("Cityname", City);
                locationmap.put("suburName", suburb);
                locationmap.put("Note", note);
                reference.push().setValue(locationmap);
                Toast.makeText(AddLocationnActivity.this, "Data Saved", Toast.LENGTH_SHORT).show();
                db.collection("locationmap")
                        .add(locationmap)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                                startActivity(new Intent(AddLocationnActivity.this, AddressBookActivity.class));
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w(TAG, "Error adding document", e);
                            }
                        });
            }
        });
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToAddressBookPage();
            }
        });
//        btnSave.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                backToAddressBookPage();
//            }
//        });
//        NameAddress.setOnFocusChangeListener(new View.OnFocusChangeListener(){
//            @Override
//            public void onFocusChange(View v, boolean hasFocus){
//                if(!hasFocus){
//                    hideKeyboard(v);
//                }
//            }
//        });
//        StreetName.setOnFocusChangeListener(new View.OnFocusChangeListener(){
//            @Override
//            public void onFocusChange(View v, boolean hasFocus){
//                if(!hasFocus){
//                    hideKeyboard(v);
//                }
//            }
//        });
//        CityName.setOnFocusChangeListener(new View.OnFocusChangeListener(){
//            @Override
//            public void onFocusChange(View v, boolean hasFocus){
//                if(!hasFocus){
//                    hideKeyboard(v);
//                }
//            }
//        });
//        SuburbName.setOnFocusChangeListener(new View.OnFocusChangeListener(){
//            @Override
//            public void onFocusChange(View v, boolean hasFocus){
//                if(!hasFocus){
//                    hideKeyboard(v);
//                }
//            }
//        });
//        Note.setOnFocusChangeListener(new View.OnFocusChangeListener(){
//            @Override
//            public void onFocusChange(View v, boolean hasFocus){
//                if(!hasFocus){
//                    hideKeyboard(v);
//                }
//            }
//        });
        deleteText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (id.length() > 0) {
                    db.collection("locationmap")
                            .document(id).delete()
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    Log.d("TAG", "DELETED!!!!!");
                                    backToAddressBookPage();
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.d("TAG", "Failed!!!!");
                                }
                            });
                }
            }
        });
    }

    public void onLoad() {
        /*FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("locationmap")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            for(QueryDocumentSnapshot document :task.getResult()){
                                Id = document.getId();
                                Map<String,Object> data = document.getData();
                                NameAddress.setText(data.get("nameAddress").toString());
                                StreetName.setText(data.get("nameStreet").toString());
                                CityName.setText(data.get("Cityname").toString());
                                SuburbName.setText(data.get("suburName").toString());
                                Note.setText(data.get("Note").toString());
                            }
                        }
                    }
                });

         */
    }

    public void backToAddressBookPage() {
        Intent intent = new Intent(AddLocationnActivity.this, AddressBookActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_out_right, R.anim.slide_in_left);
    }

//    public void hideKeyboard(View view){
//        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
//        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
//    }
}