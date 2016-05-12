package com.yfw.zlt.slidingmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.yfw.zlt.slidingmenu.view.SlidingLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    ImageView menuButton;
    SlidingLayout slidingLayout;
    LinearLayout content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();//初始化

    }
    private void init(){
        //点击
        menuButton=(ImageView) findViewById(R.id.menuButton);
        //侧滑
        slidingLayout=(SlidingLayout) findViewById(R.id.slidingLayout);
        content=(LinearLayout) findViewById(R.id.content);


        //监听事件
        //侧滑
        slidingLayout.setScrollEvent(content);
        //点击
        menuButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
       switch (v.getId()){
           // 点击侧滑菜单
           case R.id.menuButton:
               if(slidingLayout.isLeftLayoutVisible()){
                    slidingLayout.scrollToRightLayout();
               }else {
                    slidingLayout.scrollToLeftLayout();
               }
               break;
       }
    }
}
