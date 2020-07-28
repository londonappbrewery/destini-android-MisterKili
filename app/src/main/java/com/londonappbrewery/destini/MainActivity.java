package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    TextView storyTextView;
    Button topButton;
    Button bottomButton;
    private int mStoryIndex = 1;
    private int[] storyTexts = new int[] {
            R.string.T1_Story,
            R.string.T2_Story,
            R.string.T3_Story
    };

    private int[] ans1Texts = new int[] {
            R.string.T1_Ans1,
            R.string.T2_Ans1,
            R.string.T3_Ans1
    };

    private int[] ans2Texts = new int[] {
            R.string.T1_Ans2,
            R.string.T2_Ans2,
            R.string.T3_Ans2
    };

    private int[] endsTexts = new int[] {
            R.string.T4_End,
            R.string.T5_End,
            R.string.T6_End
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        storyTextView = (TextView) findViewById(R.id.storyTextView);
        topButton = (Button) findViewById(R.id.buttonTop);
        bottomButton = (Button) findViewById(R.id.buttonBottom);


        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        topButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mStoryIndex == 1 || mStoryIndex == 2) {
                    setTextsTo(3);
                    mStoryIndex = 3;
                } else if (mStoryIndex == 3) {
                    setTextsTo(6);
                    mStoryIndex = 6;
                }
            }
        });



        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        bottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mStoryIndex == 1) {
                    setTextsTo(2);
                    mStoryIndex = 2;
                } else if (mStoryIndex == 2) {
                    setTextsTo(4);
                    mStoryIndex = 4;
                } else if (mStoryIndex == 3) {
                    setTextsTo(5);
                    mStoryIndex = 5;
                }
            }
        });

    }

    private void setTextsTo(int stage) {
        if (stage <= 3) {
            storyTextView.setText(storyTexts[stage - 1]);
            topButton.setText(ans1Texts[stage - 1]);
            bottomButton.setText(ans2Texts[stage - 1]);
        } else if (stage <= 6) {
            storyTextView.setText(endsTexts[stage - 4]);
            topButton.setVisibility(View.INVISIBLE);
            bottomButton.setVisibility(View.INVISIBLE);
        }
    }
}
