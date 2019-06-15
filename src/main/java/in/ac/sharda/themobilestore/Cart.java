package in.ac.sharda.themobilestore;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Cart extends AppCompatActivity {
    Button order;
    ArrayList arrayList;
    ListView list;
    FirebaseFirestore db= FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        order=(Button)findViewById(R.id.order);
        list=(ListView)findViewById(R.id.list);
        arrayList=new ArrayList();
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Cart.this, Order.class);
                startActivity(i);}});

                db.collection("userdetail")
                        .addSnapshotListener(new EventListener<QuerySnapshot>() {
                            @Override
                            public void onEvent(QuerySnapshot value, FirebaseFirestoreException e) {
                                for (QueryDocumentSnapshot doc : value) {
                                    String aa = doc.getString("ModelName");
                                    String bb = doc.getString("Price");
                                    arrayList.add(aa + "\n" + bb);
                                }
                                ArrayAdapter ad = new ArrayAdapter(Cart.this, android.R.layout.
                                        simple_list_item_1, arrayList);
                                list.setAdapter(ad);
                            }
                        });
    }
}
