package com.stn.lotto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

// 'Activity'는 안드로이드 애플리케이션을 구성하는 기본 단위이며, 사용자와 상호 작용하는 UI를 제공한다.
// 사용자게엑 보여지는 단일 화면으로 사용자와 상호 작용한다.
// 안드로이드 Application 의 기본 구성 요소이다.
// 시스템으로부터 애플리케이션이 시작되는 진입점이 될 수 있다.

// * 단일화면 : 사용자의 입력을 받을 수 있는 활성화된 유일한 화면
//            : Activity 는 동시에 하나만 '활성화(Focus)' 될 수 있고, 활성화된 Activity 만 사용자의 입력을 받을 수 있다.
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Toast.makeText(applicationContext, "MainActivity 입니다.", Toast.LENGTH_SHORT).show()
    }
}
