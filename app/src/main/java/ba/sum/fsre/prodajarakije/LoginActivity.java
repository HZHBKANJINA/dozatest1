package ba.sum.fsre.prodajarakije;

import android.content.Intent;
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

public class LoginActivity extends AppCompatActivity {

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.mAuth=FirebaseAuth.getInstance();
        EditText customerEmailTxt=findViewById(R.id.customerLoginEmail);
        EditText customerPasswordTxt=findViewById(R.id.customerLoginPassword);

        Button customerLoginBtn=findViewById(R.id.customerLoginBtn);
        customerLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String customerEmail=customerEmailTxt.getText().toString();
                String customerPassword=customerPasswordTxt.getText().toString();
                mAuth.signInWithEmailAndPassword(customerEmail, customerPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(LoginActivity.this, "Uspješno ste se prijavili!", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(LoginActivity.this, "Greška prilikom prijave!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        Button goToRegister=findViewById(R.id.goToCustomerRegister);
        goToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), CustomerRegisterActivity.class);
                startActivity(intent);
            }
        });

        Button goToPwdReset=findViewById(R.id.goToPwdReset);
        goToPwdReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), ResetPasswordActivity.class);
                startActivity(intent);
            }
        });
    }
}