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
	
	//����
	private Button red,green,blue,bigger,smaller,bold,italic,moren;
	private TextView testText;
	private int flag=0;//��־����Ĭ��Ϊ0
	private EditText content;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);//���ý��沼���ļ�
		testText.setTypeface(Typeface.DEFAULT);//����������ʽ
		
		//����ID��ȡ�ؼ�
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
		
		//��������������
		ColorListener myColorListener=new ColorListener();
		SizeListener mysizeListener=new SizeListener(testText);
		//ע�������
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
				testText.setText(content.getText().toString());//�����ı�������
				return false;
			}
		});
		}
	
	//ʵ�ּ��������ڲ���
	private class ColorListener implements OnClickListener{
		public void onClick(View v){
			//�ж��¼�Դ
			switch(v.getId()){
			case R.id.red:
				testText.setTextColor(Color.RED);
				break;//����������Ϊ��ɫ
			case R.id.green:
				testText.setTextColor(Color.GREEN);
				break;//����������Ϊ��ɫ
			case R.id.blue:
				testText.setTextColor(Color.BLUE);
				break;//����������Ϊ��ɫ
			default:
				break;
			}
		}
	}
	
	
		//����Activity�౾��ʵ��OnClickListener�ӿ���Ϊ�¼�������
		public void onClick(View v){
			Typeface tf=testText.getTypeface();//��ȡ��ǰ������ʽ
			//�ж��ĸ���ť������
			switch(v.getId()){
			//�����Ӵְ�ť
			case R.id.bold:
				if(flag==1||flag==3){
					testText.setTypeface(Typeface.MONOSPACE,Typeface.BOLD_ITALIC);
					flag=3;
				}else{
					testText.setTypeface(Typeface.DEFAULT_BOLD,Typeface.BOLD);
					flag=2;
				}
				break;
			//������б��ť
		case R.id.italic:
			if(flag==2||flag==3){
				testText.setTypeface(Typeface.MONOSPACE,Typeface.BOLD_ITALIC);
				flag=3;
			}else{
				testText.setTypeface(Typeface.DEFAULT_BOLD,Typeface.ITALIC);
				flag=1;
			}
			break;
			//����Ĭ�ϰ�ť
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
