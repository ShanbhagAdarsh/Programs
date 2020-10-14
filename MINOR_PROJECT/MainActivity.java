package com.example.visionimpairment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    public static final int CAMERA_PERM_CODE = 100;
    public static final int CAMERA_REQUEST_CODE = 102;

    Button capturebtn;
    ImageView imagedisplay;
    String  currentPhotoPath;
    StorageReference storageReference;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      

        firebaseAuth = FirebaseAuth.getInstance();
        storageReference = FirebaseStorage.getInstance().getReference();


        capturebtn = (Button) findViewById(R.id.btn);
        imagedisplay = (ImageView) findViewById(R.id.image);


        capturebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                askCameraPermissions();
                

            }
        });

        
    }

    private void askCameraPermissions() {


        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(MainActivity.this,new String[] {Manifest.permission.CAMERA},CAMERA_PERM_CODE);
        }else {
            dispatchTakePictureIntent();
        }
    }
//&& grantResults[0] == PackageManager.PERMISSION_GRANTED   grantResults.length > 0
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == CAMERA_PERM_CODE){
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED ){
                dispatchTakePictureIntent();
            }else {
                Toast.makeText(this,"Camera Permission is Required to access Camera",Toast.LENGTH_SHORT).show();
            }
        }
       // super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

   

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST_CODE) {
            //Bitmap image = (Bitmap) data.getExtras().get("data");
            //imagedisplay.setImageBitmap(image);

            File f = new File(currentPhotoPath);
            imagedisplay.setImageURI(Uri.fromFile(f));
            Log.d("tag","Absolute url of image is"+Uri.fromFile(f));

            Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
            Uri contenturi = Uri.fromFile(f);
            mediaScanIntent.setData(contenturi);
            this.sendBroadcast(mediaScanIntent);
            uploadImageToFirebase(f.getName(),contenturi);
        }
    }


    private  File createImageFile() throws IOException{
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_"+timestamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,
                ".jpg",
                storageDir
        );
        currentPhotoPath = image.getAbsolutePath();
        return image;
    }

   // static final int REQUEST_TAKE_PHOTO = 1;
    private  void  dispatchTakePictureIntent(){
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(takePictureIntent.resolveActivity(getPackageManager())!=null){
            File photoFile = null;
            try{
                photoFile = createImageFile();

            }catch (IOException ex){

            }
            if(photoFile!=null){
                Uri photoURI = FileProvider.getUriForFile(this,"com.example.android.fileprovider",photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT,photoURI);
                startActivityForResult(takePictureIntent,CAMERA_REQUEST_CODE);
            }
        }
    }



    private void uploadImageToFirebase(final String name, Uri contenturi){
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
       // DatabaseReference myRef = firebaseDatabase.getReference(firebaseAuth.getUid());
        //final StorageReference image = storageReference.child("pictures/"+name);
        final StorageReference image = storageReference.child(firebaseAuth.getUid()).child(name);
        image.putFile(contenturi).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                image.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        Log.d("tag","Training"+uri.toString());
                    }
                });
                Toast.makeText(MainActivity.this,"Uploaded",Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(MainActivity.this,"error",Toast.LENGTH_SHORT).show();
            }
        });
    }


}


