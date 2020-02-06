package com.stn.lotto

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_test.*

// 안드로이드에서 버튼과 같은 View 객체에 이벤트 리스너를 설정하는 방법은 크게 2가지가 있다.
// 1. 코드에서 View 객체에 setOnClickListener() 메소드를 이용해 리스너를 설정하는 방법
// 2. XML 에서 메소드를 등록하는 방법
class TestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        // 코드에서 View 에 이벤트 리스너를 설정하는 방법
        // Kotlin 에서는 Android Extension 덕분에 findViewById 없이 바로 접근 가능하다.
        // 버튼과 같은 View 가 클릭되었을 때 실행될 listener 를 등록하는 메소드가 setOnClickListener 이다.
        button.setOnClickListener {
            // MainActivity 를 시작하는 Intent 를 생성한다.

            // Intent(Package Context, 타겟이 되는 구성요소의 Class)
            // Context - 애플리케이션이 가지고 있는 '환경 정보'에 대한 인터페이스
            // * 환경정보 : 애플리케이션의 패키지 이름, 리소스 정보 등 애플리케이션이 실행되고 있는 환경의 요소들
            // 아래의 경우, Activity 는 Context 를 상속받기 때문에 특정 Context 대신에 '자기 자신'을 전달한 것
            // 즉, 현재 'TestActivity'가 실행되고 있는 환경정보'가 전달되게 된다.

            // 다음 파라미터는 호출될 '타겟 구성 요소(Activity, Service 등)'의 클래스 이름
            val intent = Intent(this@TestActivity, MainActivity::class.java)
            // intent 를 사용하여 Activity 를 시작한다.
            startActivity(intent)
        }

        // CONSTELLATION ACTIVITY 버튼을 누른경우 동작하는 이벤트 리스너를 등록한다.
        button2.setOnClickListener {
            // ConstellationActivity 를 시작하는 Intent 를 생성한다.
            val intent = Intent(this@TestActivity, ConstellationActivity::class.java)

            // intent 를 사용하여 Activity 를 시작한다.
            startActivity(intent)
        }

        // NAME ACTIVITY 버튼을 누른경우 동작하는 이벤트 리스너를 등록한다.
        button3.setOnClickListener {
            // NameActivity 를 시작하는 Intent 를 생성한다.
            val intent = Intent(this@TestActivity, NameActivity::class.java)

            // intent 를 사용하여 Activity 를 시작한다.
            startActivity(intent)
        }

        // RESULT ACTIVITY 버튼을 누른경우 동작하는 이벤트 리스너를 등록한다.
        button4.setOnClickListener {
            // ResultActivity 를 시작하는 Intent 를 생성한다.
            val intent = Intent(this@TestActivity, ResultActivity::class.java)

            // intent 를 사용하여 Activity 를 시작한다.
            startActivity(intent)
        }

    }

    /**
     * XML 에서 참조할 수 있도록 메소드를 정의한다.
     */
    fun goConstellation(view: View) {
        // ConstellationActivity 로 화면전환을 하는 코드
        val intent = Intent(this@TestActivity, ConstellationActivity::class.java)
        startActivity(intent)
    }
    // 연결해주고 싶은 버튼의 Design 탭에서 'onClick' 항목을 연결해주거나,
    // Text 탭에 ' android:onClick="goConstellation"' 을 작성해주면 해당 function 이 연결된다.

    // 두 방식의 차이
    // 1. setOnClickListener
    // 장점 - 오류를 컴파일 시 확인할 수 있다.
    // 단점 - View 객체의 ID가 필수로 필요하다.

    // 2. XML
    // 장점 - View 객체의 ID를 지정해주지 않아도 연결이 가능하다.
    // 단점 - 오류가 Runtime(실행) 중 발생하고, 오류 시 앱이 종료된다.


    // 암시적 인텐트를 사용하여 웹브라우저를 호출한다.
    fun callWeb(view: View){
        // 암시적 Intent 는  Component Name 은 없고, 대신 작업 유형을 나타내는 Action 을 지정하다.
        // 암시적 Intent 호출 시의 Action 과 Data 정보를 기반으로, 안드로이드 시스템은 장치 내에 설치된 적합한 앱을 실행시킨다.
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.naver.com"))
        startActivity(intent)
    }
}
