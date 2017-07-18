package com.example.itrain.mymaterial;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    //private static final Object LOG_TAG = MainActivity.class.getSimpleName();
    EditText emailText =(EditText)findViewById(R.id.email);
    EditText passwordText = (EditText)findViewById(R.id.password);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        
        Button btn = (Button) findViewById(R.id.submit);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        FirebaseAuth auth =FirebaseAuth.getInstance();
        String email = emailText.getText().toString().trim();
        String password = passwordText.getText().toString().trim();
        auth.createUserWithEmailAndPassword(email,
                password).addOnCompleteListener(RegisterActivity.this, new
                OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Toast.makeText(RegisterActivity.this, "Authenticationsuccess", Toast.LENGTH_SHORT).show();
                        if (!task.isSuccessful()) {
                            Toast.makeText(RegisterActivity.this,
                                    "Authentication failed." + task.getException(),
                                    Toast.LENGTH_SHORT).show();
                        } else {
                        }
                    }
                });

    }
}

        /*Button button =(Button) findViewById(R.id.submit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder alertDialog2 = new AlertDialog.Builder(RegisterActivity.this);

// Setting Dialog Title
                alertDialog2.setTitle("Confirm Delete...");

// Setting Dialog Message
                alertDialog2.setMessage("Are you sure you want delete this file?");

// Setting Icon to Dialog
                alertDialog2.setIcon(R.mipmap.ic_launcher);

// Setting Positive "Yes" Btn
                alertDialog2.setPositiveButton("YES",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // Write your code here to execute after dialog
                                Toast.makeText(getApplicationContext(),
                                        "You clicked on YES", Toast.LENGTH_SHORT)
                                        .show();
                            }
                        });

// Setting Negative "NO" Btn
                alertDialog2.setNegativeButton("NO",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // Write your code here to execute after dialog
                                Log.d((String) LOG_TAG, "no");
                                //Toast.makeText(getApplicationContext(),
                                  //      "You clicked on NO", Toast.LENGTH_SHORT)
                                    //    .show();
                                dialog.cancel();
                            }
                        });

// Showing Alert Dialog
                alertDialog2.show();
            }
        });


    }
}*/
