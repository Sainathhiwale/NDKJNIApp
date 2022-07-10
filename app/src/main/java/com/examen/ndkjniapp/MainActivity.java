package com.examen.ndkjniapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.examen.ndkjniapp.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
   private Button button;
   private TextView tvText;
   private EditText editText;
   private String txt;
    // Used to load the 'ndkjniapp' library on application startup.
    static {
        System.loadLibrary("ndkjniapp");
    }

  //  private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Example of a call to a native method
        TextView tv = binding.sampleText;
        EditText editText =binding.editText
        tv.setText(stringFromJNI());*/
        button = findViewById(R.id.button);
        editText = findViewById(R.id.editText);
        tvText = findViewById(R.id.tvtext);
        button.setOnClickListener(this);
    }

    /**
     * A native method that is implemented by the 'ndkjniapp' native library,
     * which is packaged with this application.
     */


   // public native String stringFromJNI();

    @Override
    public void onClick(View view) {
        if(view.getId() ==R.id.button){
          enterText();
        }
    }
    private void enterText(){
         txt = editText.getText().toString();
        int txtLen = getTxtLen(txt);
        tvText.setText("Text Length: " + txtLen);

    }
    //JNI method
    public native int getTxtLen(String txt);
    

}