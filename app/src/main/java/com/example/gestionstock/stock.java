package com.example.gestionstock;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class stock extends AppCompatActivity {
    EditText t1,t2,t3;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock);
        t1=(EditText)findViewById(R.id.t1);
        t2=(EditText)findViewById(R.id.t2);
        t3=(EditText)findViewById(R.id.t3);
        btn=(Button)findViewById(R.id.btn);
btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        addRecord(view);
    }
});
    }

public void addRecord(View view){
        DBManger db=new DBManger(this);
        String rs=db.addRecord(t1.getText().toString(),t2.getText().toString(),t3.getText().toString() );
        Toast.makeText(this,rs,Toast.LENGTH_LONG).show();
        t1.setText("");
        t2.setText("");
        t3.setText("");
    }
}