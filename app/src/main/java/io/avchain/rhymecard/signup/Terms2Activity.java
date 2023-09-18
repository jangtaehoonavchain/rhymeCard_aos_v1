package io.avchain.rhymecard.signup;

import android.content.Intent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.appcompat.widget.AppCompatButton;

import io.avchain.rhymecard.R;
import io.avchain.rhymecard.common.BasicActivity;
import io.avchain.rhymecard.databinding.ActivitySignupTerms2Binding;

public class Terms2Activity extends BasicActivity<ActivitySignupTerms2Binding> implements View.OnClickListener {

    @Override
    protected ActivitySignupTerms2Binding getBinding() {
        return ActivitySignupTerms2Binding.inflate(getLayoutInflater());
    }

    @Override
    protected void initView() {
        // CheckBox 클릭 이벤트 처리
        CheckBox checkBox = findViewById(R.id.terms2_scrollview_cardview_ckbox_ic);
        final AppCompatButton agreeButton = findViewById(R.id.terms2_scrollview_btn_agree);

        // 체크박스 초기 상태에 따라 버튼의 배경색 설정
        if (checkBox.isChecked()) {
            agreeButton.setBackgroundResource(R.drawable.component_btn_long_lightblue);
        } else {
            agreeButton.setBackgroundResource(R.drawable.component_btn_long_gray);
        }

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // 체크박스 클릭 이벤트 처리
                if (isChecked) {
                    agreeButton.setBackgroundResource(R.drawable.combine_btn_long_blue);
                } else {
                    agreeButton.setBackgroundResource(R.drawable.component_btn_long_gray);
                }
            }
        });
    }

    @Override
    protected void initEvent() {
        // 버튼 클릭 이벤트 처리
        findViewById(R.id.terms2_scrollview_btn_agree).setOnClickListener(this);
        findViewById(R.id.terms2_scrollview_ckbox_btn).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.terms2_scrollview_cardview_ckbox_ic:
                Intent intent = new Intent(this, TermsDetailActivity.class);
                startActivity(intent);
                break;

            case R.id.terms2_scrollview_btn_agree:
                Intent intent1 = new Intent(this, Certification1Activity.class);
                startActivity(intent1);
                break;

            case R.id.terms2_scrollview_ckbox_btn:
                Intent intent2 = new Intent(this, TermsDetailActivity.class);
                startActivity(intent2);
                break;
        }
    }
}