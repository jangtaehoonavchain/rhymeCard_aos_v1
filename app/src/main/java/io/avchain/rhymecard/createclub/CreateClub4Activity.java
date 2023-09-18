package io.avchain.rhymecard.createclub;

import android.content.Intent;
import android.view.View;

import io.avchain.rhymecard.MainActivity;
import io.avchain.rhymecard.common.BasicActivity;
import io.avchain.rhymecard.databinding.ActivityCreateClub4Binding;

public class CreateClub4Activity extends BasicActivity<ActivityCreateClub4Binding> implements View.OnClickListener{
    @Override
    protected ActivityCreateClub4Binding getBinding() {
        return ActivityCreateClub4Binding.inflate(getLayoutInflater());
    }

    @Override
    protected void initView() {
        binding.activityCreateClub4Scrollview.activityCreateClub4ScrollviewConstraintLayout1ContentNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void initEvent() {

    }

    @Override
    public void onClick(View v) {

    }
}
