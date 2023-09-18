package io.avchain.rhymecard.fragment;

import static android.content.ContentValues.TAG;
import static android.content.Intent.getIntent;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import io.avchain.rhymecard.R;
import io.avchain.rhymecard.common.BasicFragment;
import io.avchain.rhymecard.createclub.CreateClub1Activity;
import io.avchain.rhymecard.databinding.FragmentHomeBinding;
import io.avchain.rhymecard.notification.NotificationActivity;

public class HomeFragment extends BasicFragment<FragmentHomeBinding> {

    private ViewFlipper viewFlipper;
    private ConstraintLayout includedLayout;
    private ImageButton flipperButton;
    private ImageButton backButton;
    private AnimatorSet rotate3DAnimator; // 3D 회전 애니메이션을 저장할 변수

    private ImageButton didCardFrontToogle,didCardFrontTooglehide;

    private boolean isToggleOn = true; // 토글 상태를 저장하는 변수


    @Override
    protected FragmentHomeBinding getBinding(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
        return FragmentHomeBinding.inflate(inflater, container, false);
    }

    @Override
    protected void initView() {

        viewFlipper = binding.fragmentHomeViewFlipper;
        includedLayout = binding.componentDidCardFrontRedHide.getRoot();

        includedLayout.setVisibility(View.GONE);

        flipperButton = binding.componentDidCardFrontRed.didCardFrontRedFlipperBtn;
        backButton = binding.componentDidCardBack.didCardBackRedResetTimeBtn;

        didCardFrontToogle = binding.componentDidCardFrontRed.didCardFrontRedToogle;

        didCardFrontTooglehide = binding.componentDidCardFrontRedHide.didCardFrontToogleHide;

        // 사용자 정의 회전 애니메이션을 로드합니다.
        rotate3DAnimator = (AnimatorSet) AnimatorInflater.loadAnimator(getContext(), R.anim.rotate_did_card);

        // 애니메이션을 ViewFlipper에 설정합니다.
        viewFlipper.setInAnimation(null); // XML에서 설정한 애니메이션을 사용하지 않습니다.
        viewFlipper.setOutAnimation(null); // XML에서 설정한 애니메이션을 사용하지 않습니다.

    }


    @Override
    protected void initEvent() {

        // fragment_home_alarm_btn 클릭 이벤트 처리
        binding.fragmentHomeAlarmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // NotificationActivity로 이동하는 인텐트 생성
                Intent intent = new Intent(getContext(), NotificationActivity.class);
                startActivity(intent); // NotificationActivity 시작
            }
        });

        // 앞면에서 뒷면으로 전환하는 버튼 클릭 이벤트 처리
        flipperButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ViewFlipper의 다음 뷰로 전환 (앞면 -> 뒷면)
                viewFlipper.showNext();
                // 3D 회전 애니메이션을 시작합니다.
                rotate3DAnimator.setTarget(viewFlipper);
                rotate3DAnimator.start();
            }
        });

        // 뒷면에서 앞면으로 전환하는 버튼 클릭 이벤트 처리
        binding.componentDidCardBack.componentDidCardBackRedBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ViewFlipper의 이전 뷰로 전환 (뒷면 -> 앞면)
                viewFlipper.showPrevious();
                // 3D 회전 애니메이션을 시작합니다.
                rotate3DAnimator.setTarget(viewFlipper);
                rotate3DAnimator.start();
            }
        });

        // 토글 버튼 클릭 이벤트 처리
        didCardFrontToogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 토글 상태를 변경
                isToggleOn = !isToggleOn;

                // 토글 상태에 따라 배경 이미지 변경
                if (isToggleOn) {
                    viewFlipper.setVisibility(View.VISIBLE);
                    includedLayout.setVisibility(View.GONE); // 숨김화면 숨기 //

                } else {
                    viewFlipper.setVisibility(View.GONE);
                    includedLayout.setVisibility(View.VISIBLE); // 숨김화면 숨기 //
                }
            }
        });

        didCardFrontTooglehide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 토글 상태를 변경
                isToggleOn = !isToggleOn;

                // 토글 상태에 따라 배경 이미지 변경
                if (isToggleOn) {
                    viewFlipper.setVisibility(View.VISIBLE);
                    includedLayout.setVisibility(View.GONE); // 숨김화면 숨기 //

                } else {
                    viewFlipper.setVisibility(View.GONE);
                    includedLayout.setVisibility(View.VISIBLE); // 숨김화면 숨기 //
                }
            }
        });

    }

    @Override
    public void onClick(View v) {
        // 클릭 이벤트 처리
    }
}