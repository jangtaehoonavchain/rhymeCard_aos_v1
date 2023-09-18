package io.avchain.rhymecard.createclub;

import android.content.Intent;
import android.view.View;

import io.avchain.rhymecard.common.BasicActivity;
import io.avchain.rhymecard.databinding.ActivityCreateClub3Binding;

public class CreateClub3Activity extends BasicActivity<ActivityCreateClub3Binding> implements View.OnClickListener {
    @Override
    protected ActivityCreateClub3Binding getBinding() {
        return ActivityCreateClub3Binding.inflate(getLayoutInflater());
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initEvent() {
        binding.activityCreateClub3Scrollview.activityCreateClub3ScrollviewConstraintLayout3ContentNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CreateClub4Activity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onClick(View v) {

    }
}
