package io.avchain.rhymecard.signup;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;

import java.util.ArrayList;
import java.util.List;

import io.avchain.rhymecard.R;
import io.avchain.rhymecard.common.BasicActivity;

import io.avchain.rhymecard.databinding.ActivitySignupCertification1Binding;


public class Certification1Activity extends BasicActivity<ActivitySignupCertification1Binding> implements View.OnClickListener {

    private String[] telSpinnerItems;
    private List<CheckBox> checkBoxList;

    @Override
    protected ActivitySignupCertification1Binding getBinding() {
        return ActivitySignupCertification1Binding.inflate(getLayoutInflater());
    }

    @Override
    protected void initView() {

        telSpinnerItems = getResources().getStringArray(R.array.spinner_tel);

        ArrayAdapter<String> telSpinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, telSpinnerItems);
        telSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.activitySignupCertification1Scrollview.certification1ScrollviewConstraint1TelSpinner.setAdapter(telSpinnerAdapter);

        binding.activitySignupCertification1Scrollview.certification1ScrollviewConstraint1TelSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

                if (position == 0) {
                    String selectedValue = parentView.getItemAtPosition(position).toString();
                    if (selectedValue.equals("통신사 선택")) {
                    }
                } else {
                    String selectedValue = parentView.getItemAtPosition(position).toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

            }
        });

        checkBoxList = new ArrayList<>();
        checkBoxList.add(binding.activitySignupCertification1Scrollview.certification1ScrollviewConstraint3Certification2Ckbox);
        checkBoxList.add(binding.activitySignupCertification1Scrollview.certification1ScrollviewConstraint3Certification3Ckbox);
        checkBoxList.add(binding.activitySignupCertification1Scrollview.certification1ScrollviewConstraint3Certification4Ckbox);
        checkBoxList.add(binding.activitySignupCertification1Scrollview.certification1ScrollviewConstraint3Certification5Ckbox);


        EditText nameEditText = findViewById(R.id.certification1_scrollview_constraint1_name_section_content);
        final AppCompatButton button = findViewById(R.id.certification1_scrollview_constraint2_btn_ok);

        nameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // 텍스트 변경 전에 호출되는 메서드
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // 텍스트가 변경될 때 호출되는 메서드
                // 여기서 텍스트가 비어있지 않으면 버튼의 배경색을 변경할 수 있습니다.
                if (s.length() > 0) {
                    button.setBackgroundResource(R.drawable.combine_btn_long_blue);
                } else {
                    button.setBackgroundResource(R.drawable.component_btn_long_gray);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                // 텍스트 변경 후에 호출되는 메서드
            }
        });

    }

    @Override
    protected void initEvent() {
        binding.activitySignupCertification1Scrollview.certification1ScrollviewConstraint2BtnOk.setOnClickListener(this::onClick);

        binding.activitySignupCertification1Scrollview.certification1ScrollviewConstraint2Certification2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (CheckBox checkBox : checkBoxList) {
                    checkBox.setChecked(true);
                }

            }
        });

        // "OK" 버튼 클릭 이벤트
        binding.activitySignupCertification1Scrollview.certification1ScrollviewConstraint2BtnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // certification1_scrollview_constraint3 레이아웃을 보여주는 코드
                binding.activitySignupCertification1Scrollview.certification1ScrollviewConstraint3.setVisibility(View.VISIBLE);
            }
        });

        findViewById(R.id.Cettification1_Top_main_backbtn).setOnClickListener(this);



        // 모든 체크 박스가 체크되었는지 확인하기 위한 플래그 변수
        final boolean[] allChecked = {false};

        final AppCompatButton nextButton = findViewById(R.id.certification1_scrollview_constraint4_btn_next);

        // 각 체크 박스의 상태 변경 이벤트 리스너 설정
        for (CheckBox checkBox : checkBoxList) {
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    // 체크 박스 상태가 변경되었을 때 호출되는 메서드

                    // 모든 체크 박스가 체크되었는지 확인
                    allChecked[0] = true;
                    for (CheckBox cb : checkBoxList) {
                        if (!cb.isChecked()) {
                            allChecked[0] = false;
                            break;
                        }
                    }

                    // 모든 체크 박스가 체크되었을 때
                    if (allChecked[0]) {
                        nextButton.setBackgroundResource(R.drawable.combine_btn_long_blue);
                    } else {
                        nextButton.setBackgroundResource(R.drawable.component_btn_long_gray);
                    }
                }
            });
        }

        findViewById(R.id.certification1_scrollview_constraint4_btn_next).setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.certification1_scrollview_constraint4_btn_next:

                Intent intent1 = new Intent(this, Certification2Activity.class);
                startActivity(intent1);
                break;

            case R.id.Cettification1_Top_main_backbtn:
                finish();
                break;


        }

    }
}