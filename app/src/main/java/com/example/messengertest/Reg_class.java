package com.example.messengertest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Reg_class extends AppCompatActivity {
    private FirebaseAuth mAuth;

    EditText username;
    EditText password;

    TextView change;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reg_layout);

        mAuth = FirebaseAuth.getInstance();
        change = findViewById(R.id.log_txt);
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Reg_class.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
    public void onReg(View view){
        username = findViewById(R.id.email_reg);
        password = findViewById(R.id.pass_reg);
        String user = String.valueOf(username.getText());
        String pass = String.valueOf(password.getText());
        mAuth.createUserWithEmailAndPassword(user,pass).addOnCompleteListener(Reg_class.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Intent intent = new Intent(Reg_class.this,Main_Screen.class);
                    startActivity(intent);
                    Toast.makeText(Reg_class.this,"Всё топ",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(Reg_class.this,"Всё не топ",Toast.LENGTH_LONG).show();

                }
            }
        });
    }

}
