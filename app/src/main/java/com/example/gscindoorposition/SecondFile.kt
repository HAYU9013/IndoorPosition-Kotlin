package com.example.gscindoorposition

class SecondFile {
    companion object {
        private var Cnt:Int = 0

        fun hello() {
            println("hello there")
        }
        fun goodbye(name: String){
            println("good bye " + name + " " + Cnt.toString())
            Cnt++
        }

        fun changeCnt(tmp: Int){
            Cnt = tmp;
        }
    }
}
