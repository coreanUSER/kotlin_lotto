package com.stn.lotto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_name.*

class NameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name)

        // 번호 생성 버튼의 클릭이벤트 리스너 설정
        goButton.setOnClickListener {
            // ResultActivity 를 시작하는 인텐트늘 만들고 startActivity 로 실행
            startActivity(Intent(this, ResultActivity::class.java))
        }

        // 뒤로가기 버턴의 클릭이벤트 리스너 설정
        backButton.setOnClickListener {
            // 액티비티 종료
            finish()
        }
    }

    /**
     * 입력받은 이름에 대한 해시코드를 사용하여 랜덤한 번호를 섞고 결과를 반환한다.
     */
}
