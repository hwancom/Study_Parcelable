package com.example.administrator.study_parcelable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.btn1_main);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                /* MenuActivity로 전달하기 위해 Intent 만들때 파라미터로
                * getApplicationContext()로 context 객체를 넣고
                * 두번째로 MenuActivity의 class 인스턴스를 넣어준다. */

                ArrayList<String> names = new ArrayList<String>();
                /* 복잡한 형태의 데이터 타입을 전달하기 위해 ArrayList를 사용한다.
                * 특정한 타입(여기서는 String)의 데이터를 넣기위한 방법 */
                names.add("아무개");
                names.add("누구나");

                intent.putExtra("names", names);
                /* putExtra로 names 객체를 그대로 넣는다. */

                /* Parcelable 오브젝트를 인텐트로 보내는 경우 */
                BookData bookData = new BookData(
                        "영어회화 100일의 기적",
                        "문성현",
                        "넥서스",
                        "9791157528011",
                        "100일 후에는 나도 영어로 말한다!",
                        13500,
                        "https://www.nexusbook.com:446/fileData/thumbnail/books/thum_E-E15015_cover_215.jpg");
                intent.putExtra("bookData", bookData);

                startActivityForResult(intent, 101);
                /* 응답을 받기위해 startActivityForResult()를 사용한다. */
            }
        });
    }
}
