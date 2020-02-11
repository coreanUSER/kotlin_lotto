package com.stn.lotto

import java.text.SimpleDateFormat
import java.util.*

object RandomNumberMaker {
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
     * Random 하게 1 ~ 45 번호중 하나의 번호를 생성하는 함수
     */
    fun getRandomNumber(): Int {
        // Random.nextInt 는 0 ~ 전달받은 파라미터 값 미만의 번호를 생성
        // ex) Random().nextInt(10) 0 ~ 9 까지의 무작위 수를 반환
        // 1 ~ 45 까지의 번호를 생성하려면 파라미터의 45를 넣고 결과값의 1을 더한다.
        return Random().nextInt(45) + 1
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

        // 리스트를 앞에서부터 순서대로 6개를 짤라 결과 반환
        return list.subList(0,6)
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