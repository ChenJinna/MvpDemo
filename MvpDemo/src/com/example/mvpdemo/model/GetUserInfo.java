package com.example.mvpdemo.model;

import com.example.mvpdemo.bean.User;

/****
 * @Project_Name:	MvpDemo
 * @Copyright:		Copyright © 2012-2016 G-emall Technology Co.,Ltd
 * @Version:		    1.0.0.1
 * @File_Name:		GetUserInfo.java
 * @CreateDate:		2016年6月8日 上午10:20:54
 * @Designer:		    g-emall
 * @Desc:			Model层抽象接口实现
 * @ModifyHistory:	
 ****/

public class GetUserInfo implements IGetUser {

	@Override
	public void getUserInfo(final int id, final OnUserInfoListener listener) {
		//模拟子线程的耗时操作
		new Thread(){
			public void run() {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}	//模拟信息获取成功
				if (id == 1) {
					User user = new User();
					user.setName("非著名程序员");
					user.setAge("26");
					user.setSex("男");
					user.setId("1");
					listener.getUserInfoSuccess(user);
				} else {
					listener.getUserInfoFailed();
				}
			};
		}.start();
	}

}
