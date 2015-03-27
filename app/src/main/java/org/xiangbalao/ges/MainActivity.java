package org.xiangbalao.ges;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.xiangbalao.ges.view.NinePointLineView;

import cn.com.unfind.ges.R;

/**
 * 作用：测试九宫格手势密码
 * 作者：unfind
 * 时间：2013年10月29日 09:37:54
 * */
public class MainActivity extends Activity {
	
	private LinearLayout nine_con;//九宫格容器
	
	NinePointLineView nv;//九宫格View
	
	TextView showInfo;
	
	boolean isSetFirst = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);//设置标题不显示
		
		setContentView(R.layout.main);
		
		nv = new NinePointLineView(MainActivity.this);
		
		nine_con = (LinearLayout)findViewById(R.id.nine_con);
		
		nine_con.addView(nv);
		
		showInfo = (TextView)findViewById(R.id.show_set_info);
		
		getSetPwd();
	
	}

	
	/**
	 * 作用：获取现在密码的设置步骤
	 * 作者：unfind
	 * 时间：2013年10月29日 14:20:36
	 * */
	public void getSetPwd(){
		
		SharedPreferences shareDate = getSharedPreferences("GUE_PWD", 0);
		
		isSetFirst = shareDate.getBoolean("IS_SET_FIRST", false);
		
		if(!isSetFirst){
			
			showInfo.setText("请设置手势密码");
			
			shareDate.edit().clear().commit();
			
		}else{
			
			showInfo.setText("请再次确认手势密码");
			
		}
		
		boolean is_second_error = shareDate.getBoolean("SECOND_ERROR", false);
		
		if(is_second_error){
			
			showInfo.setText("和第一次输入手势密码不一致，重新输入");
			
		}
		
	}

}
