package com.example.kotlinfragmentchildtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


// FragmeLayout을 통해 Fragment의 화면을 변경해준다.
// ParentFragment에서 ChildFragment로, ChildFragment에서 ParentFragment로 Listener를 interface로 만들어서 값을 이동시켜준다.
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frameLayoutParent, ParentFragment()).commit()
    }
}