package ba.sum.fsre.prodajarakije;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import ba.sum.fsre.prodajarakije.models.CustomerUser;

public class CustomerRegisterActivity extends AppCompatActivity {

    FirebaseAuth mAuth;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_register);

        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        EditText firstNameTxt=findViewById(R.id.customerRegisterFirstName);
        EditText lastNameTxt=findViewById(R.id.customerRegisterLastName);
        EditText emailTxt=findViewById(R.id.customerRegisterEmail);
        EditText phoneTxt=findViewById(R.id.customerRegisterPhone);
        EditText passwordTxt=findViewById(R.id.customerRegisterPassword);
        EditText confirmPasswordTxt=findViewById(R.id.customerRegisterConfirmPassword);
        Button customerRegisterBtn=findViewById(R.id.registerCustomerUser);

        customerRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstName=firstNameTxt.getText().toString();
                String lastName=lastNameTxt.getText().toString();
                String email=emailTxt.getText().toString();
                String phone=phoneTxt.getText().toString();
                String password=passwordTxt.getText().toString();
                String confirmPassword=confirmPasswordTxt.getText().toString();

                if(firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || phone.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()){
                    Toast.makeText(CustomerRegisterActivity.this, "Unesite sva polja", Toast.LENGTH_SHORT).show();
                }

                if(!password.equals(confirmPassword)){
                    Toast.makeText(CustomerRegisterActivity.this, "Lozinke se ne podudaraju", Toast.LENGTH_SHORT).show();
                }

                CustomerUser customerUser=new CustomerUser(firstName, lastName, email, phone);

                mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
                    if(task.isSuccessful()){
                        db.collection("customerUsers").document(mAuth.getCurrentUser().getUid()).set(customerUser);
                        Toast.makeText(CustomerRegisterActivity.this, "Uspješno ste se registrovali", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}