package io.avchain.rhymecard.createclub;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.widget.AppCompatButton;

import io.avchain.rhymecard.R;
import io.avchain.rhymecard.common.BasicActivity;
import io.avchain.rhymecard.databinding.ActivityCreateClub2Binding;

public class CreateClub2Activity extends BasicActivity<ActivityCreateClub2Binding> implements View.OnClickListener {

    private ActivityCreateClub2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCreateClub2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.activityCreateClub2Scrollview.activityCreateClub2ScrollviewConstraintLayout1Tabbtn1Name.setOnClickListener(this);
        binding.activityCreateClub2Scrollview.activityCreateClub2ScrollviewConstraintLayout1Tabbtn1ProfileImg.setOnClickListener(this);
        binding.activityCreateClub2Scrollview.activityCreateClub2ScrollviewConstraintLayout1Tabbtn1Background.setOnClickListener(this);
        binding.activityCreateClub2Scrollview.activityCreateClub2ScrollviewConstraintLayout1Tabbtn1Text.setOnClickListener(this);

        binding.activityCreateClub2Scrollview.activityCreateClub2ScrollviewConstraintLayout1Content3NameNextBtn.setOnClickListener(this::onClick);
        binding.activityCreateClub2Scrollview.activityCreateClub2ScrollviewConstraintLayout1Content3ProfileImgNextBtn.setOnClickListener(this::onClick);
        binding.activityCreateClub2Scrollview.activityCreateClub2ScrollviewConstraintLayout1Content3TermsNextBtn.setOnClickListener(this::onClick);

    }

    @Override
    protected ActivityCreateClub2Binding getBinding() {
        return ActivityCreateClub2Binding.inflate(getLayoutInflater());
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initEvent() {

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.activity_create_club2_scrollview_constraintLayout1_tabbtn1_name:

                binding.activityCreateClub2Scrollview.activityCreateClub2ScrollviewConstraintLayout1Content3ProfileImg.setVisibility(View.GONE);
                binding.activityCreateClub2Scrollview.activityCreateClub2ScrollviewConstraintLayout1Content3Terms.setVisibility(View.GONE);
                binding.activityCreateClub2Scrollview.activityCreateClub2ScrollviewConstraintLayout1Content3Background.setVisibility(View.GONE);
                binding.activityCreateClub2Scrollview.activityCreateClub2ScrollviewConstraintLayout1Content3Text.setVisibility(View.GONE);

                binding.activityCreateClub2Scrollview.activityCreateClub2ScrollviewConstraintLayout1Content3Name.setVisibility(View.VISIBLE);

                break;

            case R.id.activity_create_club2_scrollview_constraintLayout1_tabbtn1_profile_img:

                binding.activityCreateClub2Scrollview.activityCreateClub2ScrollviewConstraintLayout1Content3Terms.setVisibility(View.GONE);
                binding.activityCreateClub2Scrollview.activityCreateClub2ScrollviewConstraintLayout1Content3Background.setVisibility(View.GONE);
                binding.activityCreateClub2Scrollview.activityCreateClub2ScrollviewConstraintLayout1Content3Text.setVisibility(View.GONE);
                binding.activityCreateClub2Scrollview.activityCreateClub2ScrollviewConstraintLayout1Content3Name.setVisibility(View.GONE);

                binding.activityCreateClub2Scrollview.activityCreateClub2ScrollviewConstraintLayout1Content3ProfileImg.setVisibility(View.VISIBLE);

                break;

            case R.id.activity_create_club2_scrollview_constraintLayout1_tabbtn1_terms:

                binding.activityCreateClub2Scrollview.activityCreateClub2ScrollviewConstraintLayout1Content3Background.setVisibility(View.GONE);
                binding.activityCreateClub2Scrollview.activityCreateClub2ScrollviewConstraintLayout1Content3Text.setVisibility(View.GONE);
                binding.activityCreateClub2Scrollview.activityCreateClub2ScrollviewConstraintLayout1Content3Name.setVisibility(View.GONE);
                binding.activityCreateClub2Scrollview.activityCreateClub2ScrollviewConstraintLayout1Content3ProfileImg.setVisibility(View.GONE);

                binding.activityCreateClub2Scrollview.activityCreateClub2ScrollviewConstraintLayout1Content3Terms.setVisibility(View.VISIBLE);

                break;

            case R.id.activity_create_club2_scrollview_constraintLayout1_tabbtn1_background:

                binding.activityCreateClub2Scrollview.activityCreateClub2ScrollviewConstraintLayout1Content3Text.setVisibility(View.GONE);
                binding.activityCreateClub2Scrollview.activityCreateClub2ScrollviewConstraintLayout1Content3Name.setVisibility(View.GONE);
                binding.activityCreateClub2Scrollview.activityCreateClub2ScrollviewConstraintLayout1Content3ProfileImg.setVisibility(View.GONE);
                binding.activityCreateClub2Scrollview.activityCreateClub2ScrollviewConstraintLayout1Content3Terms.setVisibility(View.GONE);

                binding.activityCreateClub2Scrollview.activityCreateClub2ScrollviewConstraintLayout1Content3Background.setVisibility(View.VISIBLE);

                break;

            case R.id.activity_create_club2_scrollview_constraintLayout1_tabbtn1_text:

                binding.activityCreateClub2Scrollview.activityCreateClub2ScrollviewConstraintLayout1Content3Name.setVisibility(View.GONE);
                binding.activityCreateClub2Scrollview.activityCreateClub2ScrollviewConstraintLayout1Content3ProfileImg.setVisibility(View.GONE);
                binding.activityCreateClub2Scrollview.activityCreateClub2ScrollviewConstraintLayout1Content3Terms.setVisibility(View.GONE);
                binding.activityCreateClub2Scrollview.activityCreateClub2ScrollviewConstraintLayout1Content3Background.setVisibility(View.GONE);

                binding.activityCreateClub2Scrollview.activityCreateClub2ScrollviewConstraintLayout1Content3Text.setVisibility(View.VISIBLE);

                break;

            case R.id.activity_create_club2_scrollview_constraintLayout1_content3_name_next_btn:
            case R.id.activity_create_club2_scrollview_constraintLayout1_content3_profile_img_next_btn:
            case R.id.activity_create_club2_scrollview_constraintLayout1_content3_terms_next_btn:

                Intent intent = new Intent(this, CreateClub3Activity.class);
                startActivity(intent);
                break;
        }
    }
}
