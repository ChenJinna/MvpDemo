package com.example.mvpdemo;

import com.example.mvpdemo.bean.User;
import com.example.mvpdemo.presenter.UserInfoPresenter;
import com.example.mvpdemo.view.IShowUserView;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements IShowUserView {
	
	private Button btn;
	private TextView name_tv, age_tv, sex_tv;
	private ProgressDialog pd = null;
	
	private UserInfoPresenter UserInfoPresenter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		UserInfoPresenter = new UserInfoPresenter(this);
		btn = (Button) findViewById(R.id.btn);
		name_tv = (TextView) findViewById(R.id.name_tv);
		age_tv = (TextView) findViewById(R.id.age_tv);
		sex_tv = (TextView) findViewById(R.id.sex_tv);
		pd = new ProgressDialog(this);
		pd.setMessage("正在加载......");
		
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				UserInfoPresenter.getUserInfoToShow(1);
			}
		});
	}

	@Override
	public void showLoading() {
		pd.show();
	}

	@Override
	public void hideLoading() {
		pd.cancel();
	}

	@Override
	public void toMainActivity(User user) {
		name_tv.setText(user.getName());
		age_tv.setText(user.getAge());
		sex_tv.setText(user.getSex());
	}

	@Override
	public void showFailedError() {
		Toast.makeText(this, "获取信息有误！", Toast.LENGTH_SHORT).show();
	}
}
