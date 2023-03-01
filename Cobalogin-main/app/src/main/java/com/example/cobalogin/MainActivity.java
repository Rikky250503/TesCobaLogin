package com.example.cobalogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tvSesi,tvname;
    private Button btnLogout;

    KendaliLogin KL = new KendaliLogin();
    public static String keySPusername = "gAdF4FJLGgqPAiHYkMCehw==_username";
    public static String keySPname = "gAdF4FJLGgqPAiHYkMCehw==_username";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(KL.isLogin(MainActivity.this,keySPusername)== true){
            setContentView(R.layout.activity_main);

            tvSesi = findViewById(R.id.tv_sesi);
            tvname = findViewById(R.id.tv_name);
            btnLogout = findViewById(R.id.btn_logout);

            tvSesi.setText(KL.getPref(MainActivity.this,keySPusername));
            tvname.setText(KL.getPref(MainActivity.this,keySPname));

            btnLogout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    KL.setPref(MainActivity.this,keySPusername,null);
                    KL.setPref(MainActivity.this,keySPname,null);
                    finish();
                }
            });
        }
        else {
            startActivity(new Intent(MainActivity.this,LoginActivity.class));
            finish();
        }
    }
}