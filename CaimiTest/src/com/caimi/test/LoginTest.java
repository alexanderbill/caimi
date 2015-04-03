package com.caimi.test;

import android.app.Activity;
import android.support.v4.view.ViewPager;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ListView;
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
	private static int DELAY = 1000;
	private static int LONG_DELAY = 5000;

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
	}

	public void testLogin1() throws Exception {
		TabWidget tab = (TabWidget) solo.getView("id/tabs");
		View login = tab.getChildAt(4);
		solo.clickOnView(login);

		solo.sleep(DELAY);

		EditText pass = (EditText) solo.getView("id/et_password");
		solo.enterText(pass,"hfr11171");
		Button btn = (Button) solo.getView("id/bt_login");
		solo.clickOnView(btn);

		solo.sleep(DELAY);

		solo.getView("id/et_password");
	}

	public void testLogin2() {
		TabWidget tab = (TabWidget) solo.getView("id/tabs");
		View login = tab.getChildAt(4);
		solo.clickOnView(login);

		solo.sleep(5000);
		EditText pass = (EditText) solo.getView("id/et_password");
		solo.enterText(pass,"hfr111712");
		Button btn = (Button) solo.getView("id/bt_login");
		solo.clickOnView(btn);

		solo.sleep(DELAY);

		solo.getView("id/tv_nickname");
	}

	public void testTab1JifenGet() {
		TabWidget tab = (TabWidget) solo.getView("id/tabs");
		View buyTab = tab.getChildAt(0);
		solo.clickOnView(buyTab);
		solo.sleep(DELAY);

		GridView grid = (GridView) solo.getView("id/jiFenGridView");
		View getJifen = grid.getChildAt(1);
		solo.clickOnView(getJifen);
		solo.waitForActivity("caimigame.AppActivity");

		solo.sleep(DELAY);
		solo.goBack();
	}

	public void testTab1JifenSpend() {
		TabWidget tab = (TabWidget) solo.getView("id/tabs");
		View buyTab = tab.getChildAt(0);
		solo.clickOnView(buyTab);
		solo.sleep(DELAY);

		GridView grid = (GridView) solo.getView("id/jiFenGridView");
		View getJifen = grid.getChildAt(3);
		solo.clickOnView(getJifen);
		solo.waitForActivity("caimi.faxian.jifenjingcai.activity.JiFenShangChengActivity");

		int time = 2;
		for (int i=0; i<time; i++) {

		    solo.sleep(LONG_DELAY);
		    GridView sc = (GridView) solo.getView("id/gv_shangcheng");
		    View item = sc.getChildAt(1);
		    solo.clickOnView(item);

		    solo.sleep(DELAY);
		    solo.waitForActivity("caimi.faxian.jifenjingcai.activity.JiFenShangChengActivity");
		    // FrameLayout select = (FrameLayout)solo.getView("id/content");
		    // int id = getRe("tv_title", "id");
		    // View selectY = select.findViewById(id);
		    solo.clickOnButton("确定");

		    solo.sleep(7000);
		    solo.waitForActivity("caimi.faxian.jifenjingcai.activity.JiFenShangChengActivity");
		    //View guojiang = solo.getView("id/bt_right");
		    solo.clickOnButton("立即刮奖");

		    solo.sleep(LONG_DELAY);
		    //View auto = solo.getView("id/auto_guojiang");
		    solo.clickOnButton("自动刮奖");
		    solo.goBack();
		}
		solo.goBack();
	}

	private int getRe(String type, String value) {
	    return this.activity.getResources().getIdentifier(value, type, this.activity.getPackageName());
	}

	public void testTab2Goucai0() { // tab2的第一个彩
		atestTab2Goucai(0);
	}

	public void testTab2Goucai1() {// tab2的第2个彩
		atestTab2Goucai(1);
	}

	public void atestTab2Goucai2() {// tab2的第3个彩
		atestTab2Goucai(2);
	}

	public void atestTab2Goucai3() {// tab2的第4个彩
		atestTab2Goucai(3);
	}

	public void atestTab2Goucai4() {// tab2的第5个彩
		atestTab2Goucai(4);
	}

	public void atestTab2Goucai5() {// tab2的第6个彩
		atestTab2Goucai(5);
	}

	public void atestTab2Goucai(int pos) {  //测试第2个tab的购彩
	  int time = 1;
	  for (int i=0; i<time; i++) {
		TabWidget tab = (TabWidget) solo.getView("id/tabs");
		View buyTab = tab.getChildAt(1);
		solo.clickOnView(buyTab);

		solo.sleep(DELAY);

		ListView buy = (ListView) solo.getView("id/lotteryListView");
		View v = buy.getChildAt(pos);
		solo.clickOnView(v);

		solo.waitForActivity("caimi.xuanhao.activity.XuanHaoActivity");
		View select = solo.getView("id/choice_bottom_select");
		solo.clickOnView(select);
		solo.sleep(DELAY);

		View selectY = solo.getView("id/bt_right");
		solo.clickOnView(selectY);

		solo.waitForActivity("caimi.shuzigaopin.activity.ShoppingCartActivity");

		View confirm = solo.getView("id/querentouzhu");
		solo.clickOnView(confirm);

		solo.waitForActivity("caimi.shuzigaopin.activity.JieSuanActivity");
		View pay = solo.getView("id/zhiFuButton");
		solo.clickOnView(pay);

		solo.waitForActivity("caimi.shuzigaopin.activity.JieSuanActivity");
		View close = solo.getView("id/close");
		solo.clickOnView(close);
	  }
		// solo.waitForActivity(mainActiviy);
	}

	public void testZ() {
		TabWidget tab = (TabWidget) solo.getView("id/tabs");
		View login = tab.getChildAt(3);
		solo.clickOnView(login);

		solo.sleep(DELAY);

		TextView config = (TextView) solo.getView("id/tv_nickname");
		solo.clickOnView(config);
		solo.waitForActivity("caimi.gerenzhongxin.dengluzhuce.activity.NewMyCenterActivity");
		View logout = solo.getView("id/btn_tcdl");
		solo.clickOnView(logout);

		solo.sleep(DELAY);
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
