package io.avchain.rhymecard.signup;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.beautycoder.pflockscreen.PFFLockScreenConfiguration;
import com.beautycoder.pflockscreen.fragments.PFLockScreenFragment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import io.avchain.rhymecard.R;
import io.avchain.rhymecard.common.BasicActivity;
import io.avchain.rhymecard.databinding.ActivitySignupCertification3Binding;

public class Certification3Activity extends BasicActivity<ActivitySignupCertification3Binding> implements View.OnClickListener {

    private EditText edPasscode1, edPasscode2, edPasscode3, edPasscode4, edPasscode5, edPasscode6;
    private List<Button> numberButtons;

    @Override
    protected ActivitySignupCertification3Binding getBinding() {
        return ActivitySignupCertification3Binding.inflate(getLayoutInflater());
    }

    @Override
    protected void initView() {
        // EditText 초기화
        edPasscode1 = findViewById(R.id.edPasscode1);
        edPasscode2 = findViewById(R.id.edPasscode2);
        edPasscode3 = findViewById(R.id.edPasscode3);
        edPasscode4 = findViewById(R.id.edPasscode4);
        edPasscode5 = findViewById(R.id.edPasscode5);
        edPasscode6 = findViewById(R.id.edPasscode6);

    }

    @Override
    protected void initEvent() {

        // 각 숫자 버튼에 대한 클릭 리스너 설정
        findViewById(R.id.btn1).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
        findViewById(R.id.btn3).setOnClickListener(this);
        findViewById(R.id.btn4).setOnClickListener(this);
        findViewById(R.id.btn5).setOnClickListener(this);
        findViewById(R.id.btn6).setOnClickListener(this);
        findViewById(R.id.btn7).setOnClickListener(this);
        findViewById(R.id.btn8).setOnClickListener(this);
        findViewById(R.id.btn9).setOnClickListener(this);
        findViewById(R.id.btn0).setOnClickListener(this);
        findViewById(R.id.btnClear).setOnClickListener(this);
        findViewById(R.id.btnErase).setOnClickListener(this);

        // 숫자 버튼들을 리스트에 추가
        numberButtons = new ArrayList<>();
        numberButtons.add((Button) findViewById(R.id.btn1));
        numberButtons.add((Button) findViewById(R.id.btn2));
        numberButtons.add((Button) findViewById(R.id.btn3));
        numberButtons.add((Button) findViewById(R.id.btn4));
        numberButtons.add((Button) findViewById(R.id.btn5));
        numberButtons.add((Button) findViewById(R.id.btn6));
        numberButtons.add((Button) findViewById(R.id.btn7));
        numberButtons.add((Button) findViewById(R.id.btn8));
        numberButtons.add((Button) findViewById(R.id.btn9));
        numberButtons.add((Button) findViewById(R.id.btn0));


        // 각 숫자 버튼에 대한 클릭 리스너 설정
        for (Button button : numberButtons) {
            button.setOnClickListener(this);
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                handleButtonClick("1");
                break;
            case R.id.btn2:
                handleButtonClick("2");
                break;
            case R.id.btn3:
                handleButtonClick("3");
                break;
            case R.id.btn4:
                handleButtonClick("4");
                break;
            case R.id.btn5:
                handleButtonClick("5");
                break;
            case R.id.btn6:
                handleButtonClick("6");
                break;
            case R.id.btn7:
                handleButtonClick("7");
                break;
            case R.id.btn8:
                handleButtonClick("8");
                break;
            case R.id.btn9:
                handleButtonClick("9");
                break;
            case R.id.btn0:
                handleButtonClick("0");
                break;
            case R.id.btnClear:
                shuffleNumberButtons();
                break;
            case R.id.btnErase:
                eraseLastDigit();
                break;
        }
    }

    private void handleButtonClick(String buttonText) {
        // EditText에 숫자 추가
        if (edPasscode1.getText().toString().isEmpty()) {
            edPasscode1.setText(buttonText);
        } else if (edPasscode2.getText().toString().isEmpty()) {
            edPasscode2.setText(buttonText);
        } else if (edPasscode3.getText().toString().isEmpty()) {
            edPasscode3.setText(buttonText);
        } else if (edPasscode4.getText().toString().isEmpty()) {
            edPasscode4.setText(buttonText);
        } else if (edPasscode5.getText().toString().isEmpty()) {
            edPasscode5.setText(buttonText);
        } else if (edPasscode6.getText().toString().isEmpty()) {
            edPasscode6.setText(buttonText);
        }
    }


    private void shuffleNumberButtons() {
        // 숫자 버튼들을 무작위로 섞음
        Collections.shuffle(numberButtons);

        // TableLayout에서 버튼 위치를 다시 지정
        TableLayout tableLayout = findViewById(R.id.tl_keys);
        tableLayout.removeAllViews(); // 기존 버튼들을 모두 제거

        // 새로 섞인 순서로 버튼들을 추가
        TableRow row = new TableRow(this);
        for (Button button : numberButtons) {
            TableRow.LayoutParams params = new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1);
            button.setLayoutParams(params);
            row.addView(button);
        }
        tableLayout.addView(row);
    }

    private void eraseLastDigit() {
        if (!edPasscode6.getText().toString().isEmpty()) {
            edPasscode6.setText("");
        } else if (!edPasscode5.getText().toString().isEmpty()) {
            edPasscode5.setText("");
        } else if (!edPasscode4.getText().toString().isEmpty()) {
            edPasscode4.setText("");
        } else if (!edPasscode3.getText().toString().isEmpty()) {
            edPasscode3.setText("");
        } else if (!edPasscode2.getText().toString().isEmpty()) {
            edPasscode2.setText("");
        } else if (!edPasscode1.getText().toString().isEmpty()) {
            edPasscode1.setText("");
        }
    }
}