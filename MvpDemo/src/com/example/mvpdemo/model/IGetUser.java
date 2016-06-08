package com.example.mvpdemo.model;

/****
 * @Project_Name:	MvpDemo
 * @Copyright:		Copyright © 2012-2016 G-emall Technology Co.,Ltd
 * @Version:		    1.0.0.1
 * @File_Name:		IGetUser.java
 * @CreateDate:		2016年6月8日 上午10:14:24
 * @Designer:		    g-emall
 * @Desc:			Model层抽象接口
 * @ModifyHistory:	
 ****/

public interface IGetUser {
	public void getUserInfo(int id, OnUserInfoListener listener);
}
