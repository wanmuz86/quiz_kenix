package com.itrainasia.guessthebandar;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    TextView textView1;
    TextView textView2;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    String[] questions;
    String[] answers;
    String[] options;
    String[] images;

    int position = 0;
    int score = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);
        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView)findViewById(R.id.textView2);
        button1 = (Button) findViewById(R.id.option1);
        button2 = (Button) findViewById(R.id.option2);
        button3 = (Button) findViewById(R.id.option3);
        button4 = (Button) findViewById(R.id.option4);
        button5 = (Button) findViewById(R.id.help);

        Resources res = getResources();

        questions = res.getStringArray(R.array.question);
        answers = res.getStringArray(R.array.answer);
        options = res.getStringArray(R.array.option);
        images = res.getStringArray(R.array.imagename);

        showNewQuestion();


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verifyAnswer(button1.getText().toString());

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verifyAnswer(button2.getText().toString());


            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verifyAnswer(button3.getText().toString());

            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verifyAnswer(button4.getText().toString());

            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    public void verifyAnswer(String answer){

        if (answer.equals(answers[position])){
            textView2.setText("Answer is correct");
            score++;
        }
        else {
            textView2.setText("Answer is wrong");
        }
        if (position < answers.length-1){
            position++;
            showNewQuestion();
        }
        else {
            Toast.makeText(getApplicationContext(),
                    "The end! Your score is "+score, Toast.LENGTH_LONG).show();
          //code to reset
            position = 0;
            score = 0;
            showNewQuestion();
        }


    }

    public void showNewQuestion(){
        int resId = getResources().getIdentifier(images[position],
                "drawable", getPackageName());
        imageView.setImageResource(resId);
        textView1.setText(questions[position]);
        button1.setText(options[4*position]);
        button2.setText(options[4*position+1]);
        button3.setText(options[4*position+2]);
        button4.setText(options[4*position+3]);

    }
}
