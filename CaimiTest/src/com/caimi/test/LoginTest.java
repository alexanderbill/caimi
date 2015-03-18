package com.caimi.test;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;

import com.robotium.solo.Solo;

@SuppressWarnings("rawtypes")
public class LoginTest extends ActivityInstrumentationTestCase2 {

	public Solo solo;
	public Activity activity;
	private static Class<?> launchActivityClass;
	// 对应re-sign.jar生成出来的信息框里的两个值
	private static String mainActiviy = "caimi.qidong.activity.SplashActivity";
	private static String packageName = "com.caimi";

	static {
		try {
			launchActivityClass = Class.forName(mainActiviy);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	@SuppressWarnings("unchecked")
	public LoginTest() {
		super(packageName, launchActivityClass);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		this.activity = this.getActivity();
		// this.solo = new Solo(getInstrumentation(), getActivity());
	}

	public void testLoginWithIncorrentUsernameAndPassword() throws Exception {
		wait(5000);
		// 待完成
	}

	@Override
	public void tearDown() throws Exception {
		try {
			this.solo.finishOpenedActivities();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		this.activity.finish();
		super.tearDown();
	}

}
