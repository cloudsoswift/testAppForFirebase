package com.example.testappforfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class WriteTest extends AppCompatActivity {
    private FirebaseFirestore mFirestore;
    private DatabaseReference mDatabase;
    List<QueryDocumentSnapshot> list;
    static final String TAG = "DB_TEST";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_test);
//        mFirestore = FirebaseFirestore.getInstance();
//        mFirestore.collection("users").whereEqualTo("first", "Ada").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                if(task.isSuccessful()){
//                    for(QueryDocumentSnapshot document : task.getResult()){
//                        if(document.exists()){
//                            Log.i(TAG, "DocumentSnapshot Data: " + document.getData().get("last"));
//                        } else {
//                            Log.i(TAG, "No Such Document");
//                        }
//                    }
//                } else {
//                    Log.i(TAG, "get failed with ", task.getException());
//                }
//            }
//        });
        FirestoreManager a = new FirestoreManager();
        list = new ArrayList<QueryDocumentSnapshot>();
        a.getDataAll("users", new getCallback(){
            @Override
            public void onCallback(List<QueryDocumentSnapshot> queryDocumentSnapshotList) {
                list = queryDocumentSnapshotList;
            }
        });
        Log.i(TAG, "onCreate: " + list.size());
    }
}