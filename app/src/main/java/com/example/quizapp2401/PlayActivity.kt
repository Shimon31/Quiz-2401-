package com.example.quizapp2401

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quizapp2401.databinding.ActivityPlayBinding

class PlayActivity : AppCompatActivity() {

    lateinit var binding: ActivityPlayBinding


    val quizList = listOf<Quiz>(

        Quiz(
            "Victory Day of Bangladesh?",
            "21 February",
            "16 December",
            "5 August",
            "36 July",
            "16 December"
        ),
        Quiz(
            "International Mother Language Day?",
            "21 February",
            "16 December",
            "5 August",
            "36 July",
            "21 February"
        ),

        Quiz(
            "Independence Day Of Bangladesh?",
            "21 February",
            "16 December",
            "5 August",
            "26 March",
            "26 March"
        ),
        Quiz(
            "Valentine Day?",
            "21 February",
            "16 December",
            "14 February",
            "26 March",
            "14 February"
        )


    )

    var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initQuestion()


    }

    private fun initQuestion() {
        val quizQuestion = quizList[index]

        binding.apply {

            questionTv.text = quizQuestion.question
            option1Btn.text = quizQuestion.option1
            option2Btn.text = quizQuestion.option2
            option3Btn.text = quizQuestion.option3
            option4Btn.text = quizQuestion.option4

        }


    }
}