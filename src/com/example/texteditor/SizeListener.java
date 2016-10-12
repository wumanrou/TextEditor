package com.example.texteditor;


import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class SizeListener implements OnClickListener {
     private TextView tv;
     //初始化需要传入的控件
     public SizeListener(TextView tv){
    	 this.tv=tv;
     }
     public void onClick(View v){
    	 //获得当前的字体大小
    	 float f=tv.getTextSize();
    	 //判断是增大还是缩小
    	 switch(v.getId()){
    	 case R.id.bigger:
    		 f=f+2;
    		 break;//字体每次增大2
    	 case R.id.smaller:
    		 f=f-2;
    		 break;//字体每次减小2	 
    	 }
    	 if(f>=72){ f=72; }//判断字体是否大于72
    	 if(f<=8){ f=8; }//判断字体是否小于8
    	 tv.setTextSize(TypedValue.COMPLEX_UNIT_PX,f);
     }
}
    	 
     
	