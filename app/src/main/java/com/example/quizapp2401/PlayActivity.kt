package com.example.quizapp2401

import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.RadioButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quizapp2401.databinding.ActivityPlayBinding

class PlayActivity : AppCompatActivity() {

    lateinit var binding: ActivityPlayBinding

    var updateQuestion = 1

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
    var hasFinished = false
    var skip = -1
    var correct = 0
    var wrong = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initQuestion()

        binding.nextBtn.setOnClickListener {

            showNextQuestion()

        }


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

    private fun showNextQuestion() {
        checkAnswer()
        binding.apply {

            if (updateQuestion < quizList.size) {
                updateQuestion++
                initQuestion()
            } else if (index <= quizList.size - 1) {
                index++
            } else {
                hasFinished = true
            }

            radioGroup.clearCheck()

        }


    }

    private fun checkAnswer() {

        binding.apply {

            if (radioGroup.checkedRadioButtonId == -1) {

                skip++
            } else {
                val checkButton = findViewById<RadioButton>(radioGroup.checkedRadioButtonId)
                val checkAnswer = checkButton.text.toString()

                if (checkAnswer == quizList[index].answer) {

                    correct++
                    showAlertDialouge("Correct Answer")

                } else {
                    wrong++
                    showAlertDialouge("Wrong Answer")
                }


            }

            if (index <= quizList.size - 1) {
                index++
            } else {
                showAlertDialouge("Finished")
            }


        }

    }


    fun showAlertDialouge(message: String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(message)

        builder.setPositiveButton("ok", object : DialogInterface.OnClickListener {
            override fun onClick(p0: DialogInterface?, p1: Int) {

                if (message == "Finished") {
                    val intent = Intent(this@PlayActivity, ResultActivity::class.java)
                    intent.putExtra("skip", skip)
                    intent.putExtra("correct", correct)
                    intent.putExtra("wrong", wrong)



                    startActivity(intent)

                }

            }


        })

        var alertDialog = builder.create()
        alertDialog.show()


    }


}