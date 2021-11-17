package com.example.ch07_dialog_android;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = findViewById(R.id.btn1);

        boolean checkArray[] = {false, false, false};

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dlg1 = new AlertDialog.Builder(MainActivity.this);

                dlg1.setTitle("다이얼로그");
                dlg1.setIcon(R.mipmap.ic_launcher);

                String versionArray[] = {"롤리팝","마시멜로","누가"};
//                boolean checkArray[] = {false, false, false};

//                dlg1.setMessage("안녕하세요!");
//                dlg1.setItems(versionArray,null);
//                dlg1.setSingleChoiceItems(versionArray, 1, null);
                dlg1.setMultiChoiceItems(versionArray, checkArray, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int position, boolean isChecked) {

                        String str1 = "";
                        int cnt = 0;

                        for(int i=0; i<versionArray.length; ++i)
                        {
                            if(checkArray[i])
                            {
                               if(cnt == 0)
                                   str1 = versionArray[i];
                               else
                                   str1 = str1 + "," + versionArray[i];

                               cnt++;
                            }
                        }

//                        btn1.setText(versionArray[position]);
                        btn1.setText(str1);
                    }
                });

                dlg1.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"확인누름!",Toast.LENGTH_SHORT).show();
                    }
                });
                dlg1.setNegativeButton("취소", null);
                
                dlg1.show();
            }
        });
    }
}