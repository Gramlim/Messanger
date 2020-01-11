package com.example.messengertest.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.messengertest.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Fragment_reg extends Fragment {
    private FirebaseAuth mAuth;

    EditText username;
    EditText password;
    Button reg;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_auth,
                container, false);

        mAuth = FirebaseAuth.getInstance();

        username = view.findViewById(R.id.username);
        password = view.findViewById(R.id.password);

       reg = view.findViewById(R.id.register);
       reg.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String user = String.valueOf(username.getText());
               String pass = String.valueOf(password.getText());
              mAuth.createUserWithEmailAndPassword(user,pass).addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                  @Override
                  public void onComplete(@NonNull Task<AuthResult> task) {
                      if(task.isSuccessful()){
                          Toast.makeText(getActivity(),"Всё топ",Toast.LENGTH_LONG).show();
                      }else{
                          Toast.makeText(getActivity(),"Всё не топ",Toast.LENGTH_LONG).show();

                      }
                  }
              });
           }
       });

       return view;
    }
}


