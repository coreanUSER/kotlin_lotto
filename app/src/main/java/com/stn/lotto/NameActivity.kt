package com.stn.lotto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import kotlinx.android.synthetic.main.activity_name.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList
import kotlin.random.Random

class NameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name)

        // 번호 생성 버튼의 클릭이벤트 리스너 설정
        goButton.setOnClickListener {
            // 입력한 이름이 없으면 트스트 메시지 출력후 리턴
            if (TextUtils.isEmpty(editText.text.toString())) return@setOnClickListener

            // ResultActivity 를 시작하는 인텐트를 만듦
            val intent = Intent(this, ResultActivity::class.java)

            // intent 에 결과 데이터를 전달
            // int 의 리스트를 전달하므로 putIntegerArrayListExtra 를 사용
            // 전달하는 리스트는 이름의 해시코드로 생성된 랜덤한 번호
            intent.putIntegerArrayListExtra("result", ArrayList(RandomNumberMaker.getRandomNumbersFromHash(editText.text.toString())))

            // 입력받은 이르을 추가로 전달
            intent.putExtra("name", editText.text.toString())

            // startActivity 로 ResultActivity 를 시작
            startActivity(intent)
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
    fun getRandomNumbersFromHash(name: String): MutableList<Int> {
        // 1 ~ 45 번에 랜덤 번호를 저장할 리스트 생성
        val list = mutableListOf<Int>()

        // 1 ~ 45 까지 for 문을 돌면서 리스트에 랜덤번호 저장
        for (number in 1..45) {
            list.add(number)
        }

        // SimpleDateFormat 은 날짜의 시간값을 포맷화된 텍스트 형태로 바꿔주는 클래스
        // 현재 Date 의 "yyyy-MM-dd" 문자열과 이름 문자열을 합침
        val targetString = SimpleDateFormat("yyyy-MM-dd", Locale.KOREA).format(Date()) + name

        // 리스트를 무작위로 섞음, 이때 섞는 기준으로 Random(SEED)를 사용
        // SEED 값은 전달받은 이름의 해시코드를 사용
        list.shuffle(Random(targetString.hashCode().toLong()))

        // 리스트를 앞에서부터 순서대로 6개를 잘라 결과 반환
        return list.subList(0, 6)
    }
}
