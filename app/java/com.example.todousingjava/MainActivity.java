package com.example.todousingjava;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.appcompat.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
    Button  add;
    AlertDialog dialog;
    LinearLayout Layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        add = findViewById(R.id.add);
        Layout = findViewById(R.id.container);

        buildDialog();
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
            }
        });


    }

    public void buildDialog(){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.dialog,null);

        final EditText name=view.findViewById(R.id.nameedit);

        builder.setView(view);
        builder.setTitle("Enter Your Task")
                .setPositiveButton("SAVE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        addcard(name.getText().toString());

                    }
                })
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

        dialog = builder.create();
    }
    private void addcard(String name){
        final View view = getLayoutInflater().inflate(R.layout.card,null);

        TextView nameView = view.findViewById(R.id.name);
        Button delete = view.findViewById(R.id.delete);
        nameView.setText(name);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Layout.removeView(view);

            }
        });
        Layout.addView(view);
    }

}
