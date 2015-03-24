package com.caimi.test;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabWidget;
import android.widget.TextView;

import com.robotium.solo.Solo;

@SuppressWarnings("rawtypes")
public class LoginTest extends ActivityInstrumentationTestCase2 {

	public Solo solo;
	public Activity activity;
	private static Class<?> launchActivityClass;
	// 对应re-sign.jar生成出来的信息框里的两个值
	private static String mainActiviy = "caimi.qidong.activity.MainTabActivity";
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
		this.solo = new Solo(getInstrumentation(), getActivity());

		TabWidget tab = (TabWidget) solo.getView("id/tabs");
		View login = tab.getChildAt(4);
		solo.clickOnView(login);

		solo.sleep(5000);

		EditText pass = (EditText) solo.getView("id/et_password");
		solo.enterText(pass,"hfr11171");
		Button btn = (Button) solo.getView("id/bt_login");
		solo.clickOnView(btn);

		solo.sleep(5000);

		solo.enterText(pass,"hfr111712");
		btn = (Button) solo.getView("id/bt_login");
		solo.clickOnView(btn);

		solo.sleep(5000);
	}

	public void testLoginWithIncorrentUsernameAndPassword() throws Exception {

	}

	@Override
	public void tearDown() throws Exception {
		TabWidget tab = (TabWidget) solo.getView("id/tabs");
		View login = tab.getChildAt(4);
		solo.clickOnView(login);

		solo.sleep(5000);

		TextView config = (TextView) solo.getView("id/tv_nickname");
		solo.clickOnView(config);
		solo.waitForActivity("caimi.gerenzhongxin.dengluzhuce.activity.NewMyCenterActivity");
		View logout = solo.getView("id/btn_tcdl");
		solo.clickOnView(logout);

		solo.sleep(5000);

		try {
			this.solo.finishOpenedActivities();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		this.activity.finish();
		super.tearDown();
	}

}
