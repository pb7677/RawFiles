package com.example.rawfiles;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    TextView TV;
    EditText ET;
    Button Raw;
    Button Text;
    Intent cred;
    private final String FILENAME = "rawfile.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TV = findViewById(R.id.textView);
        ET = findViewById(R.id.editTextTextMultiLine);
        Raw = findViewById(R.id.button);
        Text = findViewById(R.id.button2);
        TV.setText("text");
        Raw.setText("Raw");
    }

    public void btnR(View view) {
        try {
            String fileName2 = FILENAME.substring(0, FILENAME.length() - 4);
            int Id = getResources().getIdentifier(fileName2, "raw", getPackageName());
            InputStream iS = getResources().openRawResource(Id);
            InputStreamReader iSR = new InputStreamReader(iS);
            BufferedReader bR = new BufferedReader(iSR);
            StringBuilder sB = new StringBuilder();
            String Line;
            while ((Line = bR.readLine()) != null) {
                sB.append(Line + '\n');
            }
            TV.setText(sB.toString());
        }catch (Exception e){
            Toast.makeText(this, "Error", Toast.LENGTH_LONG).show();
        }
    }

    public void btnT(View view) {
        String Text2 = ET.getText().toString();
        ET.setText(Text2);
    }
}