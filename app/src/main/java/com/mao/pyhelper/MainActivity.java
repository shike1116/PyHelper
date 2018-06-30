package com.mao.pyhelper;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.IntDef;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mao.baseapp.base.activity.LoadingFmgActivity;
import com.mao.pyhelper.find.FindFragment;
import com.mao.pyhelper.help.HelpFragment;
import com.mao.pyhelper.home.HomeFragment;
import com.mao.pyhelper.me.MeFragment;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class MainActivity extends LoadingFmgActivity implements View.OnClickListener{

    @IntDef({FT_HOME, FT_FIND, FT_HELPER, FT_ME})
    @Retention(RetentionPolicy.SOURCE)
    public @interface FgmType{}
    private static final int FT_HOME = 1;
    private static final int FT_FIND = 2;
    private static final int FT_HELPER = 3;
    private static final int FT_ME = 4;

    HomeFragment homeFragment;
    HelpFragment helpFragment;
    FindFragment findFragment;
    MeFragment meFragment;

    private TextView mTvHome;
    private TextView mTvHelp;
    private TextView mTvFind;
    private TextView mTvMe;

    private ImageView mIvHome;
    private ImageView mIvHelp;
    private ImageView mIvFind;
    private ImageView mIvMe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        changeFragment(FT_HOME);
    }
    private void initView() {
        homeFragment = (HomeFragment)getSupportFragmentManager().findFragmentById(R.id.fl_home);
        helpFragment = (HelpFragment)getSupportFragmentManager().findFragmentById(R.id.fl_help);
        findFragment = (FindFragment)getSupportFragmentManager().findFragmentById(R.id.fl_find);
        meFragment = (MeFragment)getSupportFragmentManager().findFragmentById(R.id.fl_me);

        findViewById(R.id.btn_home).setOnClickListener(this);
        findViewById(R.id.btn_helper).setOnClickListener(this);
        findViewById(R.id.btn_find).setOnClickListener(this);
        findViewById(R.id.btn_me).setOnClickListener(this);

        mTvHome = (TextView)findViewById(R.id.tv_home);
        mTvHelp = (TextView)findViewById(R.id.tv_helper);
        mTvFind = (TextView)findViewById(R.id.tv_find);
        mTvMe = (TextView)findViewById(R.id.tv_me);

        mIvHome = (ImageView)findViewById(R.id.iv_home);
        mIvHelp = (ImageView)findViewById(R.id.iv_helper);
        mIvFind = (ImageView)findViewById(R.id.iv_find);
        mIvMe = (ImageView)findViewById(R.id.iv_me);




    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_home:
                changeFragment(FT_HOME);
                break;
            case R.id.btn_helper:
                changeFragment(FT_HELPER);
                break;
            case R.id.btn_find:
                changeFragment(FT_FIND);
                break;
            case R.id.btn_me:
                changeFragment(FT_ME);
                break;
            default:
                changeFragment(FT_HOME);
                break;
        }
    }
    private void changeFragment(@FgmType int fgmType){
        switch (fgmType){
            case FT_HOME:
                getSupportFragmentManager().beginTransaction().show(homeFragment).hide(helpFragment).hide(findFragment).hide(meFragment).commit();
                break;
            case FT_FIND:
                getSupportFragmentManager().beginTransaction().hide(homeFragment).hide(helpFragment).show(findFragment).hide(meFragment).commit();
                break;
            case FT_HELPER:
                getSupportFragmentManager().beginTransaction().hide(homeFragment).show(helpFragment).hide(findFragment).hide(meFragment).commit();
                break;
            case FT_ME:
                getSupportFragmentManager().beginTransaction().hide(homeFragment).hide(helpFragment).hide(findFragment).show(meFragment).commit();
                break;
            default:
                getSupportFragmentManager().beginTransaction().show(homeFragment).hide(helpFragment).hide(findFragment).hide(meFragment).commit();
                break;
        }
        changeFragmentUi(fgmType);
    }

    private int drawSelected = R.drawable.shape_circle_app_color;
    private int drawNoSelect = R.drawable.shape_circle_white_ring;

    private int colorSelected  = Color.parseColor("#ddbc81");//Color.parseColor("#ddbc81")
    private int colorNoSelect   = Color.parseColor("#000000");

    private void changeFragmentUi(@FgmType int fgmType){
        mTvHome.setTextColor(colorNoSelect);
        mTvHelp.setTextColor(colorNoSelect);
        mTvFind.setTextColor(colorNoSelect);
        mTvMe.setTextColor(colorNoSelect);

        mIvHome.setBackgroundResource(drawNoSelect);
        mIvHelp.setBackgroundResource(drawNoSelect);
        mIvFind.setBackgroundResource(drawNoSelect);
        mIvMe.setBackgroundResource(drawNoSelect);

        switch (fgmType){
            case FT_HOME:
                mTvHome.setTextColor(colorSelected);
                mIvHome.setBackgroundResource(drawSelected);
                break;
            case FT_FIND:
                mTvFind.setTextColor(colorSelected);
                mIvFind.setBackgroundResource(drawSelected);
                break;
            case FT_HELPER:
                mTvHelp.setTextColor(colorSelected);
                mIvHelp.setBackgroundResource(drawSelected);
                break;
            case FT_ME:
                mTvMe.setTextColor(colorSelected);
                mIvMe.setBackgroundResource(drawSelected);
                break;
            default:
                mTvMe.setTextColor(colorSelected);
                mIvMe.setBackgroundResource(drawSelected);
                break;
        }
    }

}
