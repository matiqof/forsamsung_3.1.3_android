package com.example.quest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static Character manager;
    public static Story story;
    public int i = 0;

    TextView Console;
    Button Option_1, Option_2, Option_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Console = findViewById(R.id.Console);
        Option_1 = findViewById(R.id.Option_1);
        Option_2 = findViewById(R.id.Option_2);
        Option_3 = findViewById(R.id.Option_3);

        manager = new Character("Default");
        story = new Story();

        /*Option_1.setOnClickListener(this);
        Option_2.setOnClickListener(this);
        Option_3.setOnClickListener(this);

        manager.A += story.current_situation.dA;
        manager.K += story.current_situation.dK;
        manager.R += story.current_situation.dR;
        Console.setText("\nКарьера:" + manager.K + "\tАктивы:"
                + manager.A + "\tРепутация:" + manager.R + "\n" + story.current_situation.subject
                + "\n" + story.current_situation.text);
        if (story.isEnd()) {
            Console.setText("the end!");
            Option_1.setEnabled(false);
            Option_2.setEnabled(false);
            Option_3.setEnabled(false);
        }*/

        Console.setText("\nКарьера:" + manager.K + "\tАктивы:"
                + manager.A + "\tРепутация:" + manager.R + "\n" + story.current_situation.subject
                + "\n" + story.current_situation.text);
        Option_1.setOnClickListener(this);
        Option_2.setOnClickListener(this);
        Option_3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == Option_1.getId() && !story.isEnd()){
            story.go(1);
            Console.setText("\nКарьера:" + manager.K + "\tАктивы:"
                    + manager.A + "\tРепутация:" + manager.R + "\n" + story.current_situation.subject
                    + "\n" + story.current_situation.text);
        }
        else if (v.getId() == Option_2.getId() && !story.isEnd()){
            story.go(2);
            Console.setText("\nКарьера:" + manager.K + "\tАктивы:"
                    + manager.A + "\tРепутация:" + manager.R + "\n" + story.current_situation.subject
                    + "\n" + story.current_situation.text);
        }
        else if (v.getId() == Option_3.getId() && !story.isEnd()){
            story.go(3);
            Console.setText("\nКарьера:" + manager.K + "\tАктивы:"
                    + manager.A + "\tРепутация:" + manager.R + "\n" + story.current_situation.subject
                    + "\n" + story.current_situation.text);
        }
        if (story.isEnd()){
            Console.setText("the end!");
        }
    }
}