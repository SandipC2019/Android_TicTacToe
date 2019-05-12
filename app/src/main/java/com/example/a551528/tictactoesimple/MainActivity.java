package com.example.a551528.tictactoesimple;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    int turn = 0;
    int oldTurnVal = -1;
    private Map<Integer, Integer> gameMap = createMap();
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        resultText = (TextView) findViewById(R.id.resultText);
    }

    private static Map<Integer, Integer> createMap()
    {
        Map<Integer,Integer> myMap = new HashMap<Integer,Integer>();
        myMap.put(1, 0);
        myMap.put(2, 0);
        myMap.put(3, 0);
        myMap.put(4, 0);
        myMap.put(5, 0);
        myMap.put(6, 0);
        myMap.put(7, 0);
        myMap.put(8, 0);
        myMap.put(9, 0);
        return myMap;
    }

    public void onButton1(View view) {
        if(gameMap.get(1)==0) {
            turn++;
            oldTurnVal = turn;
            if (turn == 1 || turn % 2 != 0) {
                button1.setText("X");
                gameMap.put(1, 1);
            } else {
                button1.setText("O");
                gameMap.put(1, 2);
            }
            isResult();
        }

    }

    public void onButton2(View view) {
        if(gameMap.get(2)==0) {
            turn++;
            oldTurnVal = turn;
            if (turn == 1 || turn % 2 != 0) {
                button2.setText("X");
                gameMap.put(2, 1);
            } else {
                button2.setText("O");
                gameMap.put(2, 2);
            }
            isResult();
        }
    }

    public void onButton3(View view) {
        if(gameMap.get(3)==0) {
            turn++;
            oldTurnVal = turn;
            if (turn == 1 || turn % 2 != 0) {
                button3.setText("X");
                gameMap.put(3, 1);
            } else {
                button3.setText("O");
                gameMap.put(3, 2);
            }
            isResult();
        }
    }

    public void onButton4(View view) {
        if(gameMap.get(4)==0) {
            turn++;
            oldTurnVal = turn;
            if (turn == 1 || turn % 2 != 0) {
                button4.setText("X");
                gameMap.put(4, 1);
            } else {
                button4.setText("O");
                gameMap.put(4, 2);
            }
            isResult();
        }
    }

    public void onButton5(View view) {
        if(gameMap.get(5)==0) {
            turn++;
            oldTurnVal = turn;
            if (turn == 1 || turn % 2 != 0) {
                button5.setText("X");
                gameMap.put(5, 1);
            } else {
                button5.setText("O");
                gameMap.put(5, 2);
            }
            isResult();
        }
    }

    public void onButton6(View view) {
        if(gameMap.get(6)==0) {
            turn++;
            if (turn == 1 || turn % 2 != 0) {
                button6.setText("X");
                gameMap.put(6, 1);
            } else {
                button6.setText("O");
                gameMap.put(6, 2);
            }
            isResult();
        }
    }

    public void onButton7(View view) {
        if(gameMap.get(7)==0) {
            turn++;
            if (turn == 1 || turn % 2 != 0) {
                button7.setText("X");
                gameMap.put(7, 1);
            } else {
                button7.setText("O");
                gameMap.put(7, 2);
            }
            isResult();
        }
    }

    public void onButton8(View view) {
        if(gameMap.get(8)==0) {
            turn++;
            if (turn == 1 || turn % 2 != 0) {
                button8.setText("X");
                gameMap.put(8, 1);
            } else {
                button8.setText("O");
                gameMap.put(8, 2);
            }
            isResult();
        }
    }

    public void onButton9(View view) {
        if(gameMap.get(9)==0) {
            turn++;
            if (turn == 1 || turn % 2 != 0) {
                button9.setText("X");
                gameMap.put(9, 1);
            } else {
                button9.setText("O");
                gameMap.put(9, 2);
            }
            isResult();
        }
    }

    public void onClearClick(View view) {
        turn = 0;
        gameMap = createMap();
        button1.setEnabled(true);
        button2.setEnabled(true);
        button3.setEnabled(true);
        button4.setEnabled(true);
        button5.setEnabled(true);
        button6.setEnabled(true);
        button7.setEnabled(true);
        button8.setEnabled(true);
        button9.setEnabled(true);
        button1.setText("");
        button2.setText("");
        button3.setText("");
        button4.setText("");
        button5.setText("");
        button6.setText("");
        button7.setText("");
        button8.setText("");
        button9.setText("");
        resultText.setText("");
    }

    public void isResult()
    {
        int winner = decideWinner();
        if(winner>0)
        {
            if(winner==1)
                resultText.setText("Player 1 wins");
            else
                resultText.setText("Player 2 wins");
            button1.setEnabled(false);
            button2.setEnabled(false);
            button3.setEnabled(false);
            button4.setEnabled(false);
            button5.setEnabled(false);
            button6.setEnabled(false);
            button7.setEnabled(false);
            button8.setEnabled(false);
            button9.setEnabled(false);
        }
        else
        {
            if(turn==9)
            {
                resultText.setText("Match Draw");
            }
        }
    }

    public int decideWinner()
    {
        int match1 = calculateMatch(1,2,3);
        if(match1>0)
        {
            return match1;
        }
        int match2 = calculateMatch(4,5,6);
        if(match2>0)
        {
            return match2;
        }
        int match3 = calculateMatch(7,8,9);
        if(match3>0)
        {
            return match3;
        }
        int match4 = calculateMatch(1,4,7);
        if(match4>0)
        {
            return match4;
        }
        int match5 = calculateMatch(2,5,8);
        if(match5>0)
        {
            return match5;
        }
        int match6 = calculateMatch(3,6,9);
        if(match6>0)
        {
            return match6;
        }
        int match7 = calculateMatch(1,5,9);
        if(match7>0)
        {
            return match7;
        }
        int match8 = calculateMatch(3,5,7);
        if(match8>0)
        {
            return match8;
        }
        return 0;
    }

    public int calculateMatch(int pos1, int pos2, int pos3)
    {
        int winner = 0;
        if(turn>4)
        {
            if(gameMap.get(pos1)!=0 && gameMap.get(pos2)!=0 && gameMap.get(pos3)!=0)
            {
                if(gameMap.get(pos1) == gameMap.get(pos2) && gameMap.get(pos1) == gameMap.get(pos3))
                {
                    if(gameMap.get(pos1) == 1)
                        winner = 1;
                    else
                        winner = 2;
                }
            }
        }
        return winner;
    }
}
