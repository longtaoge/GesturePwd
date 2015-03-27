package org.xiangbalao.ges;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

import cn.com.unfind.ges.R;

/**
 * 作用：显示手势密码设置结果界面
 * 作者：unfind
 * 时间：2013年10月29日 16:34:59
 * */
public class SetPwdResActivity extends Activity {
	
	private TextView showInfo;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		setContentView(R.layout.res);
		
		showInfo = (TextView)findViewById(R.id.res_info);
		
		SharedPreferences shareDate = getSharedPreferences("GUE_PWD", 0);
		
		String pwd = shareDate.getString("GUE_PWD", "NO HAVE PWD !");
		
		showInfo.setText("设置成成功！您设置的手势密码是："+pwd);
	}
}
