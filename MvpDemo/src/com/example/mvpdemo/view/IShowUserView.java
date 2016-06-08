package com.example.mvpdemo.view;

import com.example.mvpdemo.bean.User;

/****
 * @Project_Name:	MvpDemo
 * @Copyright:		Copyright © 2012-2016 G-emall Technology Co.,Ltd
 * @Version:		    1.0.0.1
 * @File_Name:		IShowUserView.java
 * @CreateDate:		2016年6月8日 上午10:17:56
 * @Designer:		    g-emall
 * @Desc:			我们都知道Presenter与View交互是通过接口，所以我们需要定义一个IShowUserView的接口，这个接口封装的方法基本上都跟视图展示有关。
 * @ModifyHistory:	
 ****/

public interface IShowUserView {
	void showLoading();
	void hideLoading();
	void toMainActivity(User user);
	void showFailedError();
}
