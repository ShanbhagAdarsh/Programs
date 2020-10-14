package com.example.visionimpairment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class StartingActivity extends AppCompatActivity {
    private EditText uname,uemail;
    private Button regButton;
    private FirebaseAuth firebaseAuth;
    String userName,userEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting);

        uname = (EditText) findViewById(R.id.USERname);
        uemail = (EditText) findViewById(R.id.place);
        regButton = (Button) findViewById(R.id.button);

        firebaseAuth = FirebaseAuth.getInstance();

        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (validate()) {
                    //upload data to data base
                    String user_email = uemail.getText().toString().trim();
                    String user_password = uname.getText().toString().trim();

                    firebaseAuth.createUserWithEmailAndPassword(user_email, user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                sendEmailVerification();
                            } else {
                                Toast.makeText(StartingActivity.this, "error!", Toast.LENGTH_SHORT).show();
                            }

                        }

                    });
                }

            }
        });




    }


    private Boolean validate()
    {
        Boolean result = false;
        userName = uname.getText().toString();
        userEmail = uemail.getText().toString();

        if (userName.isEmpty() || userEmail.isEmpty())  //if required add imagePath == null
        {
            Toast.makeText(this, "Please Enter all the Details", Toast.LENGTH_SHORT).show();
        }
        else {
            result = true;
        }
        return result;
    }


    private void sendEmailVerification(){
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        if(firebaseUser!=null){
            firebaseUser.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if(task.isSuccessful()){
                        sendUserData();
                        Toast.makeText(StartingActivity.this,"Sucessfully Registered,Verification mailsent",Toast.LENGTH_SHORT).show();
                        //firebaseAuth.signOut();
                        finish();
                        startActivity(new Intent(StartingActivity.this,MainActivity.class));
                    }else {
                        Toast.makeText(StartingActivity.this,"Mail Verification has'nt been sent",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }


    private void sendUserData(){
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myRef = firebaseDatabase.getReference(firebaseAuth.getUid());
       // StorageReference imageReference = storageReference.child(firebaseAuth.getUid()).child("Images").child("Profile Pic");  //user id/Images/Profile_Pic.png
     //   UploadTask uploadTask = imageReference.putFile(imagePath);
        UserProfile userProfile = new UserProfile(userName,userEmail);
        myRef.setValue(userProfile);

    }
}
