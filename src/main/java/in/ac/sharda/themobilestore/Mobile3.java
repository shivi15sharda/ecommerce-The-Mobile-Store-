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


public class Mobile3 extends AppCompatActivity {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    Button cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile3);
        cart = (Button) findViewById(R.id.cart);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Mobile3.this, Cart.class);
                startActivity(i);


                Map<String, Object> userdetail = new HashMap<>();
                userdetail.put("ModelName: ", "MI 9");
                userdetail.put("Price: ", "12,099/-");
                userdetail.put("Portal: ", "3G/4G LTE");
                userdetail.put("Company: ", "Redmi");
                userdetail.put("Warranty: ", "3 years");
                db.collection("userdetail").document("MI 9").set(userdetail).addOnSuccessListener(new OnSuccessListener<Void>() {
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