package com.stn.lotto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

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

        // 랜덤으로 번호 생성 카드의 클릭 이벤트 리스너
        randomCard.setOnClickListener {
            // ResultActivity 를 시작하는 Intent 생성
            var intent = Intent(this@MainActivity, ResultActivity::class.java)

            // Intent 의 결과 데이터를 전달
            // int 의 리스트를 전달하므로 putIntegerArrayListExtra 를 사용
            intent.putIntegerArrayListExtra("result", ArrayList(RandomNumberMaker.getShuffeleRandomNumber()))

            // ResultActivity 를 시작하는 startActivity 로 실행
            startActivity(intent)
        }

        // 별자리로 번호 생성 카드의 클릭 이벤트 리스너
        constellationCard.setOnClickListener {
            // ConstellationActivity 를 시작하는 Intent 를 만들고 startActivity 로 실행
            startActivity(Intent(this@MainActivity, ConstellationActivity::class.java))
        }

        // 이름으로 번호 생성 카드의 클릭 이벤트 리스너
        nameCard.setOnClickListener {
            startActivity(Intent(this@MainActivity, NameActivity::class.java))
        }
    }

    /**
     * Random 하게 1 ~ 45 번호중 하나의 번호를 생성하는 함수
     */
    fun getRandomNumber(): Int {
        // Random.nextInt 는 0 ~ 전달받은 파라미터 값 미만의 번호를 생성
        // ex) Random().nextInt(10) 0 ~ 9 까지의 무작위 수를 반환
        // 1 ~ 45 까지의 번호를 생성하려면 파라미터의 45를 넣고 결과값의 1을 더한다.
        return Random().nextInt(45) + 1
    }

    /**
     * 6개의 번호를 Random 하게 추출해 리스트로 만드는 함수
     */
    fun getRandomNumbers(): MutableList<Int>{
        // 무작위로 생성된 번호를 저장할 가변 리스트 생성
        val randomNumbers = mutableListOf<Int>()

        // 6번 반복하는 for 문
        for(i in 1..6){
            // 랜덤한 번호를 임시로 저장할 변수 생성
            var number = 0

            do{
                number = getRandomNumber()
            } while(randomNumbers.contains(number))

            // 이미 뽑은 리스트에 없는 번호가 나올때까지 반복했으므로 중복이 없는 상태
            // 추출된 번호를 뽑은 리스트에 추가
            randomNumbers.add(getRandomNumber())
        }
        return randomNumbers
    }

    /**
     * Shuffle 을 사용해 랜덤한 번호 생성
     */
    fun getShuffeleRandomNumber(): MutableList<Int> {
        // 1 ~ 45 번에 로또 번호를 저장할 리스트 생성
        val list = mutableListOf<Int>()

        // 1 ~ 45 까지 for 문을 돌면서 리스트에 랜덤 번호 저장
        for(number in 1..45){
            list.add(number)
        }

        // 리스트를 무작위로 섞는다.
        list.shuffle()

        return list.subList(0,6)
    }
}



