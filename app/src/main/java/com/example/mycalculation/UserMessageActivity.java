package com.example.mycalculation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class UserMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.usermessage);
        Intent intent = getIntent();
        String message = (String) intent.getSerializableExtra("message");
        switch (message) {
            case "message1": {
                System.out.println("message1输出");
                InputStream input1 = getResources().openRawResource(R.raw.privacypolicy);
                try {
                    readText(input1);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
            case "message2": {
                System.out.println("message2输出");
                InputStream input2 = getResources().openRawResource(R.raw.useragreement);
                try {
                    readText(input2);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            }
            case "message3": {
                System.out.println("message3输出");
                InputStream input3 = getResources().openRawResource(R.raw.contactcustomercervice);
                try {
                    readText(input3);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            }
            default: {
                Toast.makeText(UserMessageActivity.this, "请求出错", Toast.LENGTH_SHORT);
            }

        }

    }

    private void readText(InputStream inputStream) throws IOException {
      /*  Reader reader=new InputStreamReader(inputStream);
        StringBuffer stringBuffer=new StringBuffer();
        char b[]=new char[2048];
        int len=-1;
        try {
            while ((len = reader.read(b))!= -1){
                stringBuffer.append(b);
            }
        }catch (IOException e){
            Log.e("ReadingFile","IOException");
        }
        String string=stringBuffer.toString();

        TextView tv = (TextView)findViewById(R.id.usermessage);
        tv.setText(string.toString());
        System.out.println(string.toString());*/

        String content = "";
        if (inputStream != null){
            InputStreamReader inputreader = new InputStreamReader(inputStream);
            BufferedReader buffreader = new BufferedReader(inputreader);
            String line;
            //分行读取
            while ((line = buffreader.readLine()) != null) {
                content += line + "\n";
            }
            inputStream.close();
        }
        TextView tv = (TextView) findViewById(R.id.usermessage);
        tv.setText(content.toString());
        System.out.println(content.toString());
    }



    }
