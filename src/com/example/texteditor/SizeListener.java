package com.example.texteditor;


import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class SizeListener implements OnClickListener {
     private TextView tv;
     //��ʼ����Ҫ����Ŀؼ�
     public SizeListener(TextView tv){
    	 this.tv=tv;
     }
     public void onClick(View v){
    	 //��õ�ǰ�������С
    	 float f=tv.getTextSize();
    	 //�ж�����������С
    	 switch(v.getId()){
    	 case R.id.bigger:
    		 f=f+2;
    		 break;//����ÿ������2
    	 case R.id.smaller:
    		 f=f-2;
    		 break;//����ÿ�μ�С2	 
    	 }
    	 if(f>=72){ f=72; }//�ж������Ƿ����72
    	 if(f<=8){ f=8; }//�ж������Ƿ�С��8
    	 tv.setTextSize(TypedValue.COMPLEX_UNIT_PX,f);
     }
}
    	 
     
	