package ba.sum.fsre.prodajarakije;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.ktx.Firebase;

import ba.sum.fsre.prodajarakije.models.MerchantUser;

public class RegisterActivity extends AppCompatActivity {

    FirebaseAuth mAuth;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        EditText merchantFirstNameTxt=findViewById(R.id.merchantRegisterFirstName);
        EditText merchantLastNameTxt=findViewById(R.id.merchantRegisterLastName);
        EditText merchantEmailTxt=findViewById(R.id.merchantRegisterEmail);
        EditText merchantPhoneTxt=findViewById(R.id.merchantRegisterPhone);
        EditText merchantPasswordTxt=findViewById(R.id.merchantRegisterPassword);
        EditText merchantConfirmPasswordTxt=findViewById(R.id.merchantRegisterConfirmPassword);
        Button merchantRegisterBtn=findViewById(R.id.registerMerchantUser);

        merchantRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstName=merchantFirstNameTxt.getText().toString();
                String lastName=merchantLastNameTxt.getText().toString();
                String email=merchantEmailTxt.getText().toString();
                String phone=merchantPhoneTxt.getText().toString();
                String password=merchantPasswordTxt.getText().toString();
                String confirmPassword=merchantConfirmPasswordTxt.getText().toString();

                if(firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || phone.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()){
                    Toast.makeText(RegisterActivity.this, "Unesite sva polja", Toast.LENGTH_SHORT).show();
                }
                if(!password.equals(confirmPassword)){
                    Toast.makeText(RegisterActivity.this, "Lozinke se ne podudaraju", Toast.LENGTH_SHORT).show();
                }

                MerchantUser merchantUser=new MerchantUser(firstName, lastName, email, phone);
                mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(task -> {
                   if(task.isSuccessful()){
                       db.collection("merchantUsers").document(mAuth.getCurrentUser().getUid()).set(merchantUser);
                       Toast.makeText(RegisterActivity.this, "Uspješno ste se registrovali", Toast.LENGTH_SHORT).show();
                   }
                });
            }
        });

    }
}