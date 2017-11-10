package com.example.administrator.study_parcelable;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button button = findViewById(R.id.btn1_menu);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        /* 전달된 intent를 받기위해서 getIntent()를 사용한다. */
        Intent passedIntent = getIntent();
        /* 메소드를 만들어서 전달된 인텐트를 처리하도록 한다. */
        processIntent(passedIntent);
    }

    private void processIntent(Intent intent) {
        if (intent != null) {
            ArrayList<String> names = (ArrayList<String>) intent.getSerializableExtra("names");
            /* getSerializableExtra()를 사용하는 이유는 ArrayList가 JAVA API에 기본으로 들어가 있고
             * 이것이 Serializable 인터페이스를 구현(implement)하기 때문에 ArrayList를 그대로 뽑아낼 수 있다. */
            if (names != null) {
                Toast.makeText(getApplicationContext(), "전달받은 이름 리스트 갯수" + names.size(), Toast.LENGTH_LONG).show();
            }

            BookData bookData = (BookData) intent.getParcelableExtra("bookData");
            if (bookData != null) {
                Toast.makeText(getApplicationContext(), "전달받은 BookData" + bookData.title, Toast.LENGTH_LONG).show();
            }
        }
    }
}
