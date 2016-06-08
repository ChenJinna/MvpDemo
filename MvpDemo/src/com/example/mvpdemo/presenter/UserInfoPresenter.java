package com.example.mvpdemo.presenter;

import com.example.mvpdemo.bean.User;
import com.example.mvpdemo.model.GetUserInfo;
import com.example.mvpdemo.model.IGetUser;
import com.example.mvpdemo.model.OnUserInfoListener;
import com.example.mvpdemo.view.IShowUserView;

import android.os.Handler;

/****
 * @Project_Name:	MvpDemo
 * @Copyright:		Copyright © 2012-2016 G-emall Technology Co.,Ltd
 * @Version:		    1.0.0.1
 * @File_Name:		UserInfoPresenter.java
 * @CreateDate:		2016年6月8日 上午10:20:11
 * @Designer:		    g-emall
 * @Desc:			Presenter是Model和View之间交互的桥梁，里面有一些业务逻辑的操作。
 * @ModifyHistory:	
 ****/

public class UserInfoPresenter {
	private IGetUser iGetUser;
	private IShowUserView iShowUserView;
	private Handler mHandler = new Handler();
	public UserInfoPresenter(IShowUserView iShowUserView) {
		this.iShowUserView = iShowUserView;
		this.iGetUser = new GetUserInfo();
	}
	
	public void getUserInfoToShow(int id) {
		iShowUserView.showLoading();
		iGetUser.getUserInfo(id, new OnUserInfoListener() {
			
			@Override
			public void getUserInfoSuccess(final User user) {
				//需要在UI线程执行
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						iShowUserView.toMainActivity(user);;
						iShowUserView.hideLoading();
					}
				});
			}
			
			@Override
			public void getUserInfoFailed() {
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						iShowUserView.showFailedError();
						iShowUserView.hideLoading();
					}
				});
			}
		});
	}
	
}
