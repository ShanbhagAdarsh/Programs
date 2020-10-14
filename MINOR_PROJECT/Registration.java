package com.example.lionkingleaders;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;

public class Registration extends AppCompatActivity {

    private EditText userName, userPassword, userEmail,userUsn;
    private Button regButton,selectpic;
    private TextView userLogin;
    private FirebaseAuth firebaseAuth;
    String username,userpassword,useremail,userusn;
    private FirebaseStorage firebaseStorage;
    private ImageView profilepic;
    private static final int PICK_IMAGE = 123;
    Uri imagePath;
    private StorageReference storageReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        setupUIVViews();

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseStorage =FirebaseStorage.getInstance();

        storageReference = firebaseStorage.getReference();


        selectpic.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent();
                intent.setType("image/*");  //application/* for documents
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent,"Select Image"),PICK_IMAGE);

            }
        });

        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validate()) {
                    //upload data to data base
                    String user_email = userEmail.getText().toString().trim();
                    String user_password = userPassword.getText().toString().trim();

                    firebaseAuth.createUserWithEmailAndPassword(user_email, user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                sendEmailVerification();
                            } else {
                                Toast.makeText(Registration.this, "error!", Toast.LENGTH_SHORT).show();
                            }

                        }

                    });


                }
            }
        });

        userLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Registration.this, MainActivity.class));
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == PICK_IMAGE &&  resultCode == RESULT_OK){
            imagePath = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), imagePath);
                profilepic.setImageBitmap(bitmap);
            }catch (IOException e){
                e.printStackTrace();
            }

        }
        super.onActivityResult(requestCode, resultCode, data);
    }




    private void setupUIVViews()
    {
        userName = (EditText) findViewById(R.id.username);
        userPassword = (EditText) findViewById(R.id.Password);
        userEmail = (EditText) findViewById(R.id.userEmail);
        regButton = (Button) findViewById(R.id.registerbutton);
        userLogin = (TextView) findViewById(R.id.loginbtntxt);
        userUsn = (EditText) findViewById(R.id.userUSN);
        profilepic =(ImageView)findViewById(R.id.picSelect);
        selectpic = (Button)findViewById(R.id.selectimgbtn);
    }

    private Boolean validate()
    {
        Boolean result = false;
         username = userName.getText().toString();
         userpassword = userPassword.getText().toString();
         useremail = userEmail.getText().toString();
         userusn = userUsn.getText().toString();

        if (username.isEmpty() || userpassword.isEmpty() || useremail.isEmpty() || userusn.isEmpty())  //if required add imagePath == null
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
                            Toast.makeText(Registration.this,"Sucessfully Registered,Verification mailsent",Toast.LENGTH_SHORT).show();
                            firebaseAuth.signOut();
                            finish();
                            startActivity(new Intent(Registration.this,MainActivity.class));
                        }else {
                            Toast.makeText(Registration.this,"Mail Verification has'nt been sent",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        }

        private void sendUserData(){
            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            DatabaseReference myRef = firebaseDatabase.getReference(firebaseAuth.getUid());
            StorageReference imageReference = storageReference.child(firebaseAuth.getUid()).child("Images").child("Profile Pic");  //user id/Images/Profile_Pic.png
            UploadTask uploadTask = imageReference.putFile(imagePath);
            uploadTask.addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(Registration.this,"Upload Failed",Toast.LENGTH_SHORT).show();
                }
            }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    Toast.makeText(Registration.this,"Upload Successful",Toast.LENGTH_SHORT).show();
                }
            });
            UserProfile userProfile = new UserProfile(username,userusn,useremail);
            myRef.setValue(userProfile);

        }

    }

