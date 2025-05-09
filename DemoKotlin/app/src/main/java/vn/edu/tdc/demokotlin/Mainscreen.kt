package vn.edu.tdc.demokotlin

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView

class Mainscreen : AppCompatActivity() {
    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var imghaisan :ImageView
    private lateinit var imgbogavit:ImageView
    private lateinit var imgdouong:ImageView
    private lateinit var rvdexuat:RecyclerView
    private lateinit var viewpage2:ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.manhinhchinh)
        SetControl()
        SetEvent()

    }

    fun SetControl() {
        bottomNavigationView = findViewById(R.id.bottom_navigation)
        imghaisan = findViewById(R.id.imageView4)
        imgdouong=findViewById(R.id.imageView5)
        imgbogavit=findViewById(R.id.imageView6)
        rvdexuat = findViewById(R.id.rvdexuat)
        viewpage2=findViewById(R.id.viewPagerCarousel)


    }


    fun SetEvent() {
        val imageList = listOf(
            R.drawable.banner,
            R.drawable.icvitquay,
            R.drawable.icvittiem
        )

        val carouselAdapter = CarouselAdapter(imageList)
        viewpage2.adapter = carouselAdapter
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_home -> {
                    supportFragmentManager.popBackStack(null, androidx.fragment.app.FragmentManager.POP_BACK_STACK_INCLUSIVE)
                    hienhammain()
                    true

                }
                R.id.menu_notifications -> {
                    loadFragment(thongbaofragment())
                    anhammain()
                    true
                }
                R.id.menu_user_info -> {
                    loadFragment(userfragment())
                    anhammain()
                    true
                }
                R.id.menu_cart ->{
                    loadFragment(giohangfragment())
                    anhammain()
                    true
                }
                R.id.menu_order ->{
                    loadFragment(donhangfragment())
                    anhammain()
                    true
                }

                else -> false
            }
        }

    imgdouong.setOnClickListener {
        val intent = Intent(this,dsdouongactivity::class.java)
        startActivity(intent)
        true
    }
        imghaisan.setOnClickListener {
            val intent = Intent(this,dshaisanactivity::class.java)
            startActivity(intent)
            true
        }
        imgbogavit.setOnClickListener {
            val intent = Intent(this,dsbogavitactivity::class.java)
            startActivity(intent)
            true
        }

        val ds = mutableListOf<outDatacomota>()
        ds.add(outDatacomota(R.drawable.mamchungrau, "Măm Chưng Rau Sống", 35000.0, "Món ăn bao gồm rau sống tươi ngon, phù hợp cho bữa sáng nhẹ nhàng.","Hải Sản"))
        ds.add(outDatacomota(R.drawable.longgasuhao, "Lòng Gà Su Hào", 45000.0, "Lòng gà kết hợp với su hào, tạo nên món ăn giòn ngon, đậm đà hương vị.","Bò Gà Vịt"))
        ds.add(outDatacomota(R.drawable.trasuaphuclong, "Trà Sữa Phúc Long", 45000.0, "Trà sữa thơm ngon, đậm đà, phù hợp với mọi lứa tuổi.","Đồ Uống"))
        ds.add(outDatacomota(R.drawable.traolongmangcau, "Trà Ô Long Mãng Cầu", 42000.0, "Trà ô long pha với mãng cầu, tạo ra hương vị tươi mát, dễ chịu.","Đồ Uống"))
        ds.add(outDatacomota(R.drawable.travailai, "Trà Vải Lài", 35000.0, "Trà vải thơm ngọt kết hợp với hương lài tự nhiên.","Đồ Uống"))
        ds.add(outDatacomota(R.drawable.tradaocamsa, "Trà Đào Cam Sả", 40000.0, "Trà đào cam sả với vị chua ngọt hòa quyện, giúp thư giãn.","Đồ Uống"))

        val adapter = adapterdexuat(ds)
        rvdexuat.adapter=adapter
        rvdexuat.layoutManager= LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL,
            false
        )

        val message = intent.getStringExtra("MESSAGE")
        if (message != null) {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }
        // tu dong chuyen anh carousel
        val handler = Handler(Looper.getMainLooper())
        val runnable = object : Runnable {
            override fun run() {
                val currentItem = viewpage2.currentItem
                val nextItem = if (currentItem == imageList.size - 1) 0 else currentItem + 1
                viewpage2.setCurrentItem(nextItem, true)
                handler.postDelayed(this, 3000)
            }
        }
        handler.postDelayed(runnable, 3000)


    }
    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_layout, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    private fun anhammain() {
        findViewById<ConstraintLayout>(R.id.main_content).visibility = View.GONE

    }

    private fun hienhammain() {
        findViewById<ConstraintLayout>(R.id.main_content).visibility = View.VISIBLE

    }
}
