package io.avchain.rhymecard.createclub;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Calendar;
import java.util.GregorianCalendar;

import io.avchain.rhymecard.R;
import io.avchain.rhymecard.common.BasicActivity;
import io.avchain.rhymecard.databinding.ActivityCreateClub1Binding;

public class CreateClub1Activity extends BasicActivity<ActivityCreateClub1Binding> implements View.OnClickListener {


    @Override
    protected ActivityCreateClub1Binding getBinding() {
        return ActivityCreateClub1Binding.inflate(getLayoutInflater());
    }

    @Override
    protected void initView() {
        binding.activityCreateClub1Scrollview.createclub1ScrollviewContentMembershipFeeValidityDateCalendar.setOnClickListener(this);
        binding.activityCreateClub1Scrollview.createclub1ScrollviewContentClosingDateCalendar.setOnClickListener(this);
    }

    @Override
    protected void initEvent() {
        binding.activityCreateClub1Scrollview.createClub1ScrollviewBtnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CreateClub2Activity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.createclub1_scrollview_content_membership_fee_validity_date_calendar) {
            // 버튼이 클릭되면 DatePickerDialog를 표시합니다.
            Calendar today = new GregorianCalendar();
            int year = today.get(Calendar.YEAR);
            int month = today.get(Calendar.MONTH);
            int date = today.get(Calendar.DATE);
            DatePickerDialog dlg = new DatePickerDialog(this, (view, year1, month1, dayOfMonth) -> {
                binding.activityCreateClub1Scrollview.createclub1ScrollviewContentMembershipFeeValidityDateEditText.setText(year1 + ". " + (month1 + 1) + ". " + dayOfMonth);
            }, year, month, date);
            dlg.show();
        }

        if (v.getId() == R.id.createclub1_scrollview_content_closing_date_calendar) {
            // 버튼이 클릭되면 DatePickerDialog를 표시합니다.
            Calendar today = new GregorianCalendar();
            int year = today.get(Calendar.YEAR);
            int month = today.get(Calendar.MONTH);
            int date = today.get(Calendar.DATE);
            DatePickerDialog dlg = new DatePickerDialog(this, (view, year1, month1, dayOfMonth) -> {
                binding.activityCreateClub1Scrollview.createclub1ScrollviewContentClosingDateEditText.setText(year1 + ". " + (month1 + 1) + ". " + dayOfMonth);
            }, year, month, date);
            dlg.show();
        }
    }
}

