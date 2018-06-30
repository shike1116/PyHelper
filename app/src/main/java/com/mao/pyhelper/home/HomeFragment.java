package com.mao.pyhelper.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mao.baseapp.base.activity.LoadingFragment;
import com.mao.pyhelper.R;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * 2018/6/29
 *
 * @author wangjf
 */

public class HomeFragment extends LoadingFragment {
    Banner banner ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fmg_home, container, false);
        initView(rootView);
        return rootView;
    }

    private void initView(View rootView){
        banner = (Banner) rootView.findViewById(R.id.banner);
        initBanner();
    }
    private void initBanner(){
        List<String> imageList = new ArrayList<>();
        imageList.add("http://n.sinaimg.cn/sinacn/w640h360/20180209/75d8-fyrkuxs5571451.jpg");
        imageList.add("http://n.sinaimg.cn/sinacn/w640h360/20180209/12b4-fyrkuxs5571777.jpg");
        banner.setImages(imageList);
        banner.setBannerStyle(BannerConfig.RIGHT);
        banner.setImageLoader(new GlideImageLoader());
        banner.start();
    }
}
