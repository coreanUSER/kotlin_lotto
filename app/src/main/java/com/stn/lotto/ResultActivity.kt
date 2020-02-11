package com.stn.lotto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_result.*
import java.text.SimpleDateFormat
import java.util.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        // 전달받은 결과 배열을 가져온다.
        val result = intent.getIntegerArrayListExtra("result")

        // 전달받은 이름을 가져온다.
        val name = intent.getStringExtra("name")

        // 전달받은 별자리를 가져온다.
        val constellation = intent.getStringExtra("constellation")

        // 결과화면 기본 텍스트
        resultLabel.text = "랜덤으로 생성된\n 번호입니다."

        if(!TextUtils.isEmpty(name)){
            resultLabel.text = "${name} 님의\n${SimpleDateFormat("yyyy년 MM월 dd일").format(Date())}\n랜덤으로 생성된 번호입니다."
        }

        if(!TextUtils.isEmpty(constellation)){
            resultLabel.text = "${constellation}의\n${SimpleDateFormat("yyyy년 MM월 dd일").format(Date())}\n랜덤으로 생성된 번호입니다."
        }

        // 전달받은 결과가 있는 경우에만 실행
        result?.let {
            // 결가에 맞게 숫자를 업데이트한다.
            // 전달받은 결과는 정렬되어 있지 않으므로 정렬해서 전달한다.
            updateRandomNumber(result.sortedBy { it })
        }
    }

    /**
     * 결과에 따라 숫자를 업데이트한다.
     */
    fun updateRandomNumber(result: List<Int>){
        // 결과의 사이즈가 6개 미만일 경우 에러가 발생할 수 있으므로 바로 리턴한다.
        if(result.size < 6) return

        // 아이디의 순서대로 숫자를 업데이트 한다.
        textView1.setText("${result[0]}")
        textView2.setText("${result[1]}")
        textView3.setText("${result[2]}")
        textView4.setText("${result[3]}")
        textView5.setText("${result[4]}")
        textView6.setText("${result[5]}")
    }
}

