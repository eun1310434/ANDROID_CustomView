/*=====================================================================
□ Infomation
  ○ Data : 09.03.2018
  ○ Mail : eun1310434@naver.com
  ○ Blog : https://blog.naver.com/eun1310434
  ○ Reference : Do it android app Programming

□ Function
  ○ 뷰를 상속하여 새로운 뷰를 만들기
     - XML레이아웃으로 만든 것이 아닌 직접 만든 뷰 설정

□ Study
  ○
=====================================================================*/

package com.eun1310434.customview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 직접 만든 뷰 화면에 설정
        CustomView customView = new CustomView(this);
        setContentView(customView);
    }

}
