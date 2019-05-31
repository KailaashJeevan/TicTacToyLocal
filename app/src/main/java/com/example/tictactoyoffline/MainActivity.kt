package com.example.tictactoyoffline

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import android.app.AlarmManager
import android.content.Context.ALARM_SERVICE
import android.support.v4.content.ContextCompat.getSystemService
import android.app.PendingIntent
import android.content.Context

import android.content.Intent
import android.content.Context.ALARM_SERVICE
import android.support.v4.content.ContextCompat.getSystemService





class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buClicked(view:View){
        val buPointer: Button = view as Button
        var bid=0
        when(buPointer.id)
        {
            R.id.B00 -> {
                bid=1
            }
            R.id.B01 -> {
                bid=2
            }
            R.id.B02 -> {
                bid=3
            }
            R.id.B10 -> {
                bid=4
            }
            R.id.B11 -> {
                bid=5
            }
            R.id.B12 -> {
                bid=6
            }
            R.id.B20 -> {
                bid=7
            }
            R.id.B21 -> {
                bid=8
            }
            R.id.B22 -> {
                bid=9
            }
        }

        //Toast.makeText(this,"ID:$Bid",Toast.LENGTH_LONG).show()
        play(bid, buPointer)


    }
    private var actPly:Int =1
    private var playerOne=ArrayList<Int>()
    private var playerTwo=ArrayList<Int>()


    private fun play(cID:Int, bSelected:Button)
    {
        if(actPly==1)
        {   bSelected.text="X"
            bSelected.setBackgroundColor(Color.GREEN)
            playerOne.add(cID)
            actPly=2
            autoPlay()
        }
        else{
            bSelected.text="O"
            bSelected.setBackgroundColor(Color.BLUE)
            playerTwo.add(cID)
            actPly=1
        }
        bSelected.isEnabled=false
        win()
    }

    private fun win(){
        var winner:Int=-1
        if(playerOne.contains(1)&& playerOne.contains(2)&& playerOne.contains(3)){
            winner=1
        }
        else if(playerTwo.contains(1)&& playerTwo.contains(2)&& playerTwo.contains(3)){
            winner=2
        }
        else if(playerOne.contains(4)&& playerOne.contains(5)&& playerOne.contains(6)){
            winner=1
        }
        else if(playerTwo.contains(4)&& playerTwo.contains(5)&& playerTwo.contains(6)){
            winner=2
        }
        else if(playerOne.contains(7)&& playerOne.contains(8)&& playerOne.contains(9)){
            winner=1
        }
        else if(playerTwo.contains(7)&& playerTwo.contains(8)&& playerTwo.contains(9)){
            winner=2
        }

        else if(playerOne.contains(1)&& playerOne.contains(4)&& playerOne.contains(7)){
            winner=1
        }
        else if(playerTwo.contains(1)&& playerTwo.contains(4)&& playerTwo.contains(7)){
            winner=2
        }
        else if(playerOne.contains(2)&& playerOne.contains(5)&& playerOne.contains(8)){
            winner=1
        }
        else if(playerTwo.contains(2)&& playerTwo.contains(5)&& playerTwo.contains(8)){
            winner=2
        }
        else if(playerOne.contains(3)&& playerOne.contains(6)&& playerOne.contains(9)){
            winner=1
        }
        else if(playerTwo.contains(3)&& playerTwo.contains(6)&& playerTwo.contains(9)){
            winner=2
        }
        else{

        }
        if(winner!=-1){
            if(winner==1)
            {
                Toast.makeText(this,"THE WINNER IS PLAYER 1",Toast.LENGTH_LONG).show()

            }
            else{
                Toast.makeText(this,"THE WINNER IS PLAYER 2",Toast.LENGTH_LONG).show()

            }
        }else{


        }

    }

    fun autoPlay(){
        var emptyCell=ArrayList<Int>()
        for(a in 1..9){
            if(!(playerOne.contains(a)||playerTwo.contains(a))){
                emptyCell.add(a)
            }

        }
        val r =Random()
        val randIndex=r.nextInt(emptyCell.size-0)+0
        val cellId= emptyCell.get(randIndex)


        var buSelectCpu:Button?
        when(cellId) {
            1 -> buSelectCpu = B00
            2 -> buSelectCpu = B01
            3 -> buSelectCpu = B02
            4 -> buSelectCpu = B10
            5 -> buSelectCpu = B11
            6 -> buSelectCpu = B12
            7 -> buSelectCpu = B20
            8 -> buSelectCpu = B21
            9 -> buSelectCpu = B22
            else-> {
                buSelectCpu=B00
            }
        }
        play(cellId,buSelectCpu)



    }





    }


