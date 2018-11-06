package com.correro.alejandro.cacherepository_room_rxjava_retrofit

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.correro.alejandro.cacherepository_room_rxjava_retrofit.data.models.Result
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {


    private lateinit var array: Observable<ArrayList<Result>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var bdRepository = DBRepository.getInstance(application)
        array = bdRepository.getResults()
        array.observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(this::test, {})
    }

    fun test(arrayList: ArrayList<Result>) {
        test.text=arrayList.size.toString()

    }
}
