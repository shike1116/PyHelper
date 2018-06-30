package com.mao.pyhelper.me;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mao.baseapp.base.activity.LoadingFragment;
import com.mao.baseapp.common.ui.widget.FromItem;
import com.mao.pyhelper.R;

/**
 * 2018/6/29
 *
 * @author wangjf
 */

public class MeFragment extends LoadingFragment implements View.OnClickListener{

    private FromItem fiMoney;
    private FromItem fiCollection;
    private FromItem fiDownLoad;
    private FromItem fiShare;
    private FromItem fiAbout;
    private FromItem fiSetting;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fmg_me, container, false);
        initView(rootView);
        return rootView;
    }

    private void initView(View rootView){
        fiMoney = (FromItem)rootView.findViewById(R.id.fi_money);
        fiCollection = (FromItem)rootView.findViewById(R.id.fi_collection);
        fiDownLoad = (FromItem)rootView.findViewById(R.id.fi_download);
        fiShare = (FromItem)rootView.findViewById(R.id.fi_share);
        fiAbout = (FromItem)rootView.findViewById(R.id.fi_about);
        fiSetting = (FromItem)rootView.findViewById(R.id.fi_setting);

        fiMoney.setOnClickListener(this);
        fiCollection.setOnClickListener(this);
        fiDownLoad.setOnClickListener(this);
        fiShare.setOnClickListener(this);
        fiAbout.setOnClickListener(this);
        fiSetting.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fi_money:
                break;
            case R.id.fi_collection:
                break;
            case R.id.fi_download:
                break;
            case R.id.fi_share:
                break;
            case R.id.fi_about:
                break;
            case R.id.fi_setting:
                startActivity(new Intent(getActivity(), SettingActivity.class));
                break;
        }
    }
}
