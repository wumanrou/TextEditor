package com.example.texteditor;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

public class MainActivity extends Activity  implements OnClickListener {
	
	//声明
	private Button red,green,blue,bigger,smaller,bold,italic,moren;
	private TextView testText;
	private int flag=0;//标志量，默认为0
	private EditText content;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);//设置界面布局文件
		testText.setTypeface(Typeface.DEFAULT);//设置字体样式
		
		//根据ID获取控件
		testText=(TextView)findViewById(R.id.testText);
		red=(Button)findViewById(R.id.red);
		green=(Button)findViewById(R.id.green);
		blue=(Button)findViewById(R.id.blue);
		bigger=(Button)findViewById(R.id.bigger);
		smaller=(Button)findViewById(R.id.smaller);
		bold=(Button)findViewById(R.id.bold);
		italic=(Button)findViewById(R.id.italic);
		moren=(Button)findViewById(R.id.moren);
		content=(EditText)findViewById(R.id.content);
		
		//创建监听器对象
		ColorListener myColorListener=new ColorListener();
		SizeListener mysizeListener=new SizeListener(testText);
		//注册监听器
		red.setOnClickListener(myColorListener);
		green.setOnClickListener(myColorListener);
		blue.setOnClickListener(myColorListener);
		bigger.setOnClickListener(mysizeListener);
		smaller.setOnClickListener(mysizeListener);
		bold.setOnClickListener(this);
		italic.setOnClickListener(this);
		moren.setOnClickListener(this);
		
		content.setOnEditorActionListener(new OnEditorActionListener(){
			public boolean onEditorAction(TextView v,int actionId,KeyEvent event){
				testText.setText(content.getText().toString());//设置文本框内容
				return false;
			}
		});
		}
	
	//实现监听器的内部类
	private class ColorListener implements OnClickListener{
		public void onClick(View v){
			//判断事件源
			switch(v.getId()){
			case R.id.red:
				testText.setTextColor(Color.RED);
				break;//将字体设置为红色
			case R.id.green:
				testText.setTextColor(Color.GREEN);
				break;//将字体设置为绿色
			case R.id.blue:
				testText.setTextColor(Color.BLUE);
				break;//将字体设置为蓝色
			default:
				break;
			}
		}
	}
	
	
		//采用Activity类本身实现OnClickListener接口作为事件监听器
		public void onClick(View v){
			Typeface tf=testText.getTypeface();//获取当前字体样式
			//判断哪个按钮被单击
			switch(v.getId()){
			//单击加粗按钮
			case R.id.bold:
				if(flag==1||flag==3){
					testText.setTypeface(Typeface.MONOSPACE,Typeface.BOLD_ITALIC);
					flag=3;
				}else{
					testText.setTypeface(Typeface.DEFAULT_BOLD,Typeface.BOLD);
					flag=2;
				}
				break;
			//单击倾斜按钮
		case R.id.italic:
			if(flag==2||flag==3){
				testText.setTypeface(Typeface.MONOSPACE,Typeface.BOLD_ITALIC);
				flag=3;
			}else{
				testText.setTypeface(Typeface.DEFAULT_BOLD,Typeface.ITALIC);
				flag=1;
			}
			break;
			//单击默认按钮
		case R.id.moren:
			testText.setTypeface(Typeface.MONOSPACE,Typeface.NORMAL);
			flag=0;
			    break;
			default:
				break;
			}
		}

		
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
