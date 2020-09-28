package com.xkanuk.quizapp

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.xkanuk.quizapp.R.*
import com.xkanuk.quizapp.R.color.*
import kotlinx.android.synthetic.main.activity_quiz_questions.*

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition : Int = 1
    private var mQuestionsList : ArrayList<Question>? = null
    private var mSelectedOptionPosition : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_quiz_questions)

        mQuestionsList = Constants.getQuestions()

        setQuestion()

        tv_option_one.setOnClickListener(this)
        tv_option_two.setOnClickListener(this)
        tv_option_three.setOnClickListener(this)
        tv_option_four.setOnClickListener(this)

    }

    private fun setQuestion() {

        mCurrentPosition = 1
        val question  = mQuestionsList!![mCurrentPosition - 1]
        defaultOptionsView()

        progress_bar.progress = mCurrentPosition
        tv_progress.text= "$mCurrentPosition/" + progress_bar.max

        tv_question.text = question.question
        tv_option_one.text = question.optionOne
        tv_option_two.text = question.optionTwo
        tv_option_three.text = question.optionThree
        tv_option_four.text = question.optionFour

    }

    @SuppressLint("ResourceAsColor")
    private fun defaultOptionsView() {
        val options = ArrayList<TextView>()
        options.add(0, tv_option_one)
        options.add(1,tv_option_two)
        options.add(2, tv_option_three)
        options.add(3, tv_option_four)

        for (option in options) {

            option.setTextColor(R.color.questionText)
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                drawable.default_option_border_bg)
        }

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            id.tv_option_one -> {
                selectedOptionView(tv_option_one, 1)
            }
            id.tv_option_two -> {
                selectedOptionView(tv_option_two, 2)
            }
            id.tv_option_three -> {
                selectedOptionView(tv_option_three, 3)
            }
            id.tv_option_four -> {
                selectedOptionView(tv_option_four, 4)
            }
        }
    }

    @SuppressLint("ResourceAsColor")
    private fun selectedOptionView(tv: TextView,
                                   selectedOptionNumber : Int) {
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNumber

        tv.setTextColor(R.color.answerText)
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            drawable.selected_option_border_bg)
    }
}