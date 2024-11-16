package ba.sum.fsre.prodajarakije;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AdminPanelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_panel);

        CardView goToProfile=findViewById(R.id.goToAdminProfile);
        goToProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),MerchantActivity.class);
                startActivity(intent);
            }
        });
        CardView goToStore=findViewById(R.id.goToStore);
        goToStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent=new Intent(getApplicationContext(),StoreActivity.class);
            startActivity(intent);
            }
        });

        CardView goToTransactions=findViewById(R.id.goToTransactions);
        goToTransactions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),TransactionsActivity.class);
                startActivity(intent);
            }
        });

        CardView goToStoreInfo=findViewById(R.id.goToInfo);
        goToStoreInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), StoreInfo.class);
                startActivity(intent);
            }
        });

        CardView goToCustomers=findViewById(R.id.goToCustomers);
        goToCustomers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), CustomersActivity.class);
                startActivity(intent);
            }
        });
    }
}