package com.example.asd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button_true;
    private Button button_false;
    private Button button_next;
    private TextView textView_question;

    private Question[] questions = new Question[] {
            new Question(R.string.q_activity, true),
            new Question(R.string.q_version, false),
            new Question(R.string.q_listener, true),
            new Question(R.string.q_resources, true),
            new Question(R.string.q_find_resources, false)
    };

    private int currentQuestion = 0, points = 0, answered = 0;

    private void checkAnswer(boolean userAnswer) {
        boolean correctAnswer = questions[currentQuestion].getTrueAnswer();
        int resultMessageId = 0;

        if (questions[currentQuestion].getAnswered())
            resultMessageId = R.string.already_answered;
        else if (userAnswer == correctAnswer) {
            resultMessageId = R.string.corrent_answer;
            questions[currentQuestion].setAnswered();
            points++;
            answered++;
        }
        else {
            resultMessageId = R.string.incorrent_answer;
            questions[currentQuestion].setAnswered();
            answered++;
        }
        Toast.makeText(this, resultMessageId, Toast.LENGTH_SHORT).show();
    }

    private void setNextQuestion() {
        textView_question.setText(questions[currentQuestion].getQuestionId());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_true = findViewById(R.id.button_true);
        button_false = findViewById(R.id.button_false);
        button_next = findViewById(R.id.button_next);
        textView_question = findViewById(R.id.textView_question);

        button_true.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View w) {
                checkAnswer(true);
            }
        });
        button_false.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View w) {
                checkAnswer(false);
            }
        });
        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View w) {
                if (answered == 5) {
                    String cs = "Twoj wynik to : " + Integer.toString(points);
                    Toast.makeText(MainActivity.this, cs, Toast.LENGTH_SHORT).show();
                }
                else {
                    currentQuestion = ++currentQuestion%questions.length;
                    setNextQuestion();
                }
            }
        });

        setNextQuestion();
    }
}