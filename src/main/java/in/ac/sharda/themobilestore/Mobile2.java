package in.ac.sharda.themobilestore;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class Mobile2 extends AppCompatActivity {
    FirebaseFirestore db=FirebaseFirestore.getInstance();
    Button cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile2);
        cart=(Button)findViewById(R.id.cart);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Mobile2.this, Cart.class);
                startActivity(i);

                Map<String, Object> userdetail = new HashMap<>();
                userdetail.put("ModelName", "Vivo V9");
                userdetail.put("Price", "14,999/-");
                userdetail.put("Portal", "4G LTE");
                userdetail.put("Company", "Vivo");
                userdetail.put("Warranty", "1.5 years");
                db.collection("userdetail").document("Vivo V9").set(userdetail).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {


                    }
                })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                            }

                        });
            }
        });



    }
}
