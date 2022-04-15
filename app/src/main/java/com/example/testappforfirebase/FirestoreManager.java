package com.example.testappforfirebase;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class FirestoreManager {
    private FirebaseFirestore mFirestore;
    final static String TAG = "FM_TEST";
    List<QueryDocumentSnapshot> queryDocumentSnapshotList;
    FirestoreManager(){
        mFirestore = FirebaseFirestore.getInstance();
        queryDocumentSnapshotList = new ArrayList<QueryDocumentSnapshot>();
    }
    public void AddData(String collection){

    }
    public void getDataAll(String collection, getCallback callback){
        mFirestore.collection(collection).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()){
                    queryDocumentSnapshotList = new ArrayList<QueryDocumentSnapshot>();
                    for(QueryDocumentSnapshot document : task.getResult()){
                        Log.i(TAG, "id: " + document.getId() + ", exists: " + document.exists());
                        if(document.exists()){
                            queryDocumentSnapshotList.add(document);
                        }
                        callback.onCallback(queryDocumentSnapshotList);
                    }
                } else {
                    Log.i(TAG, "task Failed! exception: " + task.getException());
                }
            }
        });
    }
    public List<DocumentSnapshot> getDataAll_2(String collection){
        return mFirestore.collection(collection).get().getResult().getDocuments();
    }
    public List<QueryDocumentSnapshot> getDatawithWhere(String collection, String key, String value){
        queryDocumentSnapshotList = new ArrayList<QueryDocumentSnapshot>();
        mFirestore.collection(collection).whereEqualTo(key, value).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()){
                    for(QueryDocumentSnapshot document : task.getResult()){
                        if(document.exists()){
                            queryDocumentSnapshotList.add(document);
                        }
                    }
                } else {
                    Log.i(TAG, "task Failed! exception: " + task.getException());
                }
            }
        });
        return queryDocumentSnapshotList;
    }
}
interface getCallback{
    void onCallback(List<QueryDocumentSnapshot> queryDocumentSnapshotList);
}