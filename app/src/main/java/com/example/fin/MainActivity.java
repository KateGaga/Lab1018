package com.example.fin;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText ed_name;
    private TextView tv_text, tv_name, tv_winner, tv_mmora, tv_cmora;
    private RadioButton scissor, stone, paper;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ed_name = findViewById(R.id.ed_name);
        tv_text = findViewById(R.id.tv_text);
        tv_name = findViewById(R.id.tv_name);
        tv_winner = findViewById(R.id.tv_winner);
        tv_mmora = findViewById(R.id.tv_mmora);
        tv_cmora = findViewById(R.id.tv_cmora);
        scissor = findViewById(R.id.scissor);
        stone = findViewById(R.id.stone);
        paper = findViewById(R.id.paper);
        button = findViewById(R.id.button);

        button.setOnClickListener(view ->{
            if (ed_name.length() < 1){
                tv_text.setText("請輸入玩家姓名");
            }else{
                tv_name.setText(String.format("名字\n%s", ed_name.getText().toString()));

                if(scissor.isChecked()){
                    tv_mmora.setText("我方出拳\n剪刀");
                }else if(stone.isChecked()){
                    tv_mmora.setText("我方出拳\n石頭");
                }else{
                    tv_mmora.setText("我方出拳\n布");
                }

                int computer_random = (int) (Math.random() * 3);

                if(computer_random == 0){
                    tv_cmora.setText("電腦出拳\n剪刀");
                }else if(computer_random == 1){
                    tv_cmora.setText("電腦出拳\n石頭");
                }else{
                    tv_cmora.setText("電腦出拳\n布");
                }

                if((scissor.isChecked() && computer_random == 2) || (stone.isChecked() && computer_random == 0) || (paper.isChecked() && computer_random == 1)){
                    tv_winner.setText("勝利者\n" + ed_name.getText().toString());
                    tv_text.setText("恭喜您獲勝了!!!");
                }else if((scissor.isChecked() && computer_random == 1) || (stone.isChecked() && computer_random == 2) || (paper.isChecked() && computer_random == 0)){
                    tv_winner.setText("勝利者\n電腦");
                    tv_text.setText("可惜電腦獲勝了!");
                }else{
                    tv_winner.setText("勝利者\n平手");
                    tv_text.setText("平局，請再試一次!");
                }
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}