package com.example.mvpdemo.model;

import com.example.mvpdemo.bean.User;

/****
 * @Project_Name:	MvpDemo
 * @Copyright:		Copyright © 2012-2016 G-emall Technology Co.,Ltd
 * @Version:		    1.0.0.1
 * @File_Name:		OnUserInfoListener.java
 * @CreateDate:		2016年6月8日 上午10:14:59
 * @Designer:		    g-emall
 * @Desc:			Model层抽象接口
 * @ModifyHistory:	
 ****/

public interface OnUserInfoListener {
	void getUserInfoSuccess(User user);
	void getUserInfoFailed();
}
