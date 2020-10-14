package com.example.imagetospeech;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;

public class Java_to_Python extends AppCompatActivity {
    EditText number1,number2;
    TextView Answer;
    Button ADDBTN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_to__python);

        number1 = (EditText) findViewById(R.id.num1);
        number2 = (EditText) findViewById(R.id.num2);
        Answer = (TextView) findViewById(R.id.answer);
        ADDBTN = (Button) findViewById(R.id.button);


        if(!Python.isStarted())
            Python.start(new AndroidPlatform(this));
        Python py = Python.getInstance();
        final PyObject pyobj = py.getModule("ADD");

        //final PyObject obj = null;

        ADDBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PyObject obj = pyobj.callAttr("main",number1.getText().toString(),number2.getText().toString());
                Answer.setText(obj.toString());
            }
        });


    }
}
