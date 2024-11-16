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

public class LoginMerchantActivity extends AppCompatActivity {

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_merchant);

        this.mAuth=FirebaseAuth.getInstance();

        EditText merchantEmailTxt=findViewById(R.id.merchantLoginEmail);
        EditText merchantPasswordTxt=findViewById(R.id.merchantLoginPassword);

        Button merchantLoginBtn=findViewById(R.id.merchantLoginBtn);
        merchantLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String merchantEmail=merchantEmailTxt.getText().toString();
                String merchantPassword=merchantPasswordTxt.getText().toString();
                mAuth.signInWithEmailAndPassword(merchantEmail,merchantPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(LoginMerchantActivity.this, "Uspješno ste se prijavili!", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(LoginMerchantActivity.this, "Greška prilikom prijave!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        Button goToPwdReset=findViewById(R.id.goToPwdReset);
        goToPwdReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),ResetPasswordActivity.class);
                startActivity(intent);
            }
        });

        Button goToMerchantRegister=findViewById(R.id.goToMerchantRegister);
        goToMerchantRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });

    }
}