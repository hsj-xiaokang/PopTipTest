package com.example.hsj.poptiptest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Arrays;

import me.kareluo.ui.OptionMenu;
import me.kareluo.ui.OptionMenuView;
import me.kareluo.ui.PopupMenuView;
import me.kareluo.ui.PopupView;

public class MainActivity extends AppCompatActivity {
    private Button poptip;
    private PopupMenuView menuView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        poptip = findViewById(R.id.poptip);


        // 根据menu资源文件创建
//        PopupMenuView menuView = new PopupMenuView(this, R.menu.menu_pop, new MenuBuilder(context));
        menuView = new PopupMenuView(this);
        menuView.setMenuItems(Arrays.asList(
                new OptionMenu("复制"), new OptionMenu("转发到朋友圈"),
                new OptionMenu("收藏"), new OptionMenu("翻译"),
                new OptionMenu("删除")));

        // 设置点击监听事件
        menuView.setOnMenuClickListener(new OptionMenuView.OnOptionMenuClickListener() {
            @Override
            public boolean onOptionMenuClick(int position, OptionMenu menu) {
                Toast.makeText(MainActivity.this, menu.getTitle(), Toast.LENGTH_SHORT).show();
                return true;
            }
        });
//        menuView.setSites(PopupView.SITE_BOTTOM, PopupView.SITE_LEFT, PopupView.SITE_TOP, PopupView.SITE_RIGHT);
        menuView.setSites(PopupView.SITE_BOTTOM);

        // 显示在mButtom控件的周围
//        menuView.show(poptip);

        poptip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 显示在mButtom控件的周围
                menuView.show(poptip);
            }
        });
    }
}
