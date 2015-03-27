package com.bin.sanshanwuyuanlvyou.util;

import com.bin.sanshanwuyuanlvyou.R;
import com.bin.sanshanwuyuanlvyou.activity.MyMainActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * TitleLayout,Ӧ��title
 * @author BIN
 *
 */
public class TitleLayout extends LinearLayout {
    public TitleLayout(final Context context, AttributeSet attrs){
        super(context,attrs);
        LayoutInflater.from(context).inflate(R.layout.title,this);
        Button titleback = (Button)findViewById(R.id.bt_title_back);
        Button titleEdit = (Button)findViewById(R.id.bt_title_edit);
        
        //������ؼ���������һ��Activity
        titleback.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity)getContext()).finish();
            }
        });
//        ���ǰ������������˾��ע���
        titleEdit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getContext(),"You Cilck Edit Button",Toast.LENGTH_LONG).show();
            	Intent intent = new Intent(context,MyMainActivity.class);
            	context.startActivity(intent);
            }
        });
    }
}
