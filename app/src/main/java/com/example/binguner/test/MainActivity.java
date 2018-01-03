package com.example.binguner.test;

import android.graphics.Color;
import android.os.Build;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Toolbar mytoolbar;
    Button lBtn,rBtn;
    ListView listView;
    List<Messages> messages;
    EditText editText;
    MessageAdapter messageAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.myStyle);
        setContentView(R.layout.activity_main);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        initId();
        initViews();
        setListener();

       // transparentState();
    }

    private void setListener() {
        lBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = editText.getText().toString();
                messages.add(new Messages(s,0));
                messageAdapter.notifyDataSetChanged();
                listView.setSelection(messages.size());
                editText.setText("");
            }
        });

        rBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = editText.getText().toString();
                messages.add(new Messages(s,1));
                messageAdapter.notifyDataSetChanged();
                listView.setSelection(messages.size());
                editText.setText("");

            }
        });
    }

    private void initId() {
        mytoolbar = findViewById(R.id.mytoolbar);
        editText = findViewById(R.id.main_editText);
        lBtn = findViewById(R.id.main_btn_left_send);
        rBtn = findViewById(R.id.main_btn_right_send);
        messages = new ArrayList<>();
        listView = findViewById(R.id.main_listView);
    }


    private void transparentState() {

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            getWindow().getDecorView().setSystemUiVisibility(
                    //View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION|
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            //getWindow().setNavigationBarColor(Color.TRANSPARENT);
            getWindow().setStatusBarColor(Color.TRANSPARENT);

            Log.d("Taag","shit");
        }else if(Build.VERSION.SDK_INT  >= Build.VERSION_CODES.KITKAT){
           // StatusBarCompat.compat(this,getResources().getColor(R.color.colorStatus));

            Window window = getWindow();
            // Translucent status bar
            window.setFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }

    }

    private void initViews() {
        mytoolbar.setTitle("I am a toolbar");
        setSupportActionBar(mytoolbar);

        messageAdapter = new MessageAdapter(this,R.layout.conversations,messages);
        listView.setAdapter(messageAdapter);
    }
}
