package com.example.apps;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    FirebaseFirestore db ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
db=FirebaseFirestore.getInstance();
// Creamos un usuario con sus datos
        Map<String, Object> user1= new HashMap<>();
        user1.put("nombre", "Marco");
        user1.put("edad", 45);
        user1.put("pais", "España");

// Añadir un documento generado con el id del usuario
        db.collection("users").add(user1)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "Documentto agregado con ID " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error añadiendo documento", e);
                    }
                });
// Agregar el usuario a la colección "users"
        Map<String, Object> user2 = new HashMap<>();
        user2.put("nombre", "Ana");
        user2.put("edad", 30);
        user2.put("pais", "España");

// // Añadir otro usuario con  un documento generado con el id del usuario
        db.collection("users").add(user2)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "Documentto agregado con ID " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error añadiendo documento", e);
                    }
                });

    }
}