package mamori.honzon.checker.light;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import mamori.honzon.checker.light.Birthday.Input_Born_Year;
import me.drakeet.materialdialog.MaterialDialog;
public class mamori_honzon_checker_light extends Activity implements View.OnClickListener,TextToSpeech.OnInitListener{
    /** Called when the activity is first created. */
    // ダミーの識別子
    private static final int REQUEST_CODE = 0;
    final private Float SPEECH_SLOW = 0.5f;
    final private Float SPEECH_NORMAL = 1.0f;
    final private Float SPEECH_FAST = 1.5f;
    final private Float PITCH_LOW = 0.5f;
    final private Float PITCH_NORMAL = 1.0f;
    final private Float PITCH_HIGH = 1.5f;
    // 音声合成用
    TextToSpeech tts = null;
	//menu変数定義
            int VIBRATION=1;
    int defaultItem=0;
    int defaultItem2=0;
    int No=0;
    int count=0;
    int Year=0;
    int Month=0;
    int Day=0;
    int mode=0;
    int flag=0;
    int Eto_No=0;
    int MamoriHonzon_No=0; //守り本尊番号
    private AdView adView;
    private static final int MENU_ID_TEST1 = (Menu.FIRST + 1);
    private static final int MENU_ID_TEST2 = (Menu.FIRST + 2);

    //class 呼び出し 2017.11.2
    Input_Born_Year born_year = new Input_Born_Year();


    // private static final int MENU_ID_TEST3 = (Menu.FIRST + 3);
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
       // MobileAds.initialize(this, "ca-app-pub-7821909322657049/2722563316");
        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-7821909322657049/2722563316");
        MobileAds.initialize(this, getResources().getString(R.string.admob_banner_ad));
        adView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .build();
        adView.loadAd(adRequest);
        Button one_Button = (Button)findViewById(R.id.one_button);
        one_Button.setOnClickListener( (OnClickListener) this);
        Button two_Button = (Button)findViewById(R.id.two_button);
        two_Button.setOnClickListener((OnClickListener) this);
        Button three_Button = (Button)findViewById(R.id.three_button);
        three_Button.setOnClickListener((OnClickListener) this);
        Button four_Button = (Button)findViewById(R.id.four_button);
        four_Button.setOnClickListener((OnClickListener) this);
        Button five_Button = (Button)findViewById(R.id.five_button);
        five_Button.setOnClickListener((OnClickListener) this);
        Button six_Button = (Button)findViewById(R.id.six_button);
        six_Button.setOnClickListener((OnClickListener) this);
        Button seven_Button = (Button)findViewById(R.id.seven_button);
        seven_Button.setOnClickListener((OnClickListener) this);
        Button eight_Button = (Button)findViewById(R.id.eight_button);
        eight_Button.setOnClickListener((OnClickListener) this);
        
        Button exe_Button = (Button)findViewById(R.id.exe_button);
        exe_Button.setOnClickListener((OnClickListener) this);
        Button Clear_Button = (Button)findViewById(R.id.clear_button);
        Clear_Button.setOnClickListener((OnClickListener) this);
        Button zero_Button = (Button)findViewById(R.id.zero_button);
        zero_Button.setOnClickListener((OnClickListener) this);
        Button nine_Button = (Button)findViewById(R.id.nine_button);
        nine_Button.setOnClickListener((OnClickListener) this);
        tts = new TextToSpeech(this, this);
        Talk_Message_Show1(R.string.Talk_Message_Start);
        //Title
        setTitle(R.string.app_name);
        @SuppressWarnings("unused")
		TextView screen_view =(TextView )findViewById(R.id.view_screen);
        //変数定義
        
    }
    @Override
    protected void onResume() {
        super.onResume();
        if (adView != null) adView.resume();

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();

        if( tts != null )
        {
            // 破棄
            tts.shutdown();
        }
        if (adView != null) adView.destroy();
    }
    @Override
    public void onPause() {
        super.onPause();
        if (adView != null) adView.pause();
    }
    @Override
    public void onInit(int status) {
        if (TextToSpeech.SUCCESS == status) {
            Locale locale = Locale.JAPANESE;
            if (tts.isLanguageAvailable(locale) >= TextToSpeech.LANG_AVAILABLE) {
                tts.setLanguage(locale);
                Talk_Message_Show1(R.string.Talk_Message_Start);
            } else {
                Log.d("", "Error SetLocale");
            }
        } else {
            Log.d("", "Error Init");
        }
    }
    public void All_Clear()
    {
        No=0;
        count=0;
        Year=0;
        Month=0;
        Day=0;
        mode=0;
        flag=0;
        born_year.clear();
        Talk_Message_Show1(R.string.AllClear_Message);
        show_screen1(R.string.StartMessage);
    }
 //画面の切り替え　ここから
    public void Change_Screen_bosatu_List1()
    {
        Intent it =new Intent();
        it.setClass(this, bosatsu_list1.class);
        startActivity(it);
    }
    public void Change_Screen_bosatu_List2()
    {
        Intent it =new Intent();
        it.setClass(this, bosatsu_list2.class);
        startActivity(it);
    }
    public void Change_Screen_bosatu_List3()
    {
        Intent it =new Intent();
        it.setClass(this, bosatsu_list3.class);
        startActivity(it);
    }
    public void Change_Screen_bosatu_List4()
    {
        Intent it =new Intent();
        it.setClass(this, bosatsu_list4.class);
        startActivity(it);
    }
    public void Change_Screen_bosatu_List5()
    {
        Intent it =new Intent();
        it.setClass(this, bosatsu_list5.class);
        startActivity(it);
    }
    public void Change_Screen_bosatu_List6()
    {
        Intent it =new Intent();
        it.setClass(this, bosatsu_list6.class);
        startActivity(it);
    }
    public void Change_Screen_bosatu_List7()
    {
        Intent it =new Intent();
        it.setClass(this, bosatsu_list7.class);
        startActivity(it);
    }
    public void Change_Screen_bosatu_List8()
    {
        Intent it =new Intent();
        it.setClass(this, bosatsu_list8.class);
        startActivity(it);
    }
    public void ShowManual_Screen()
    {
        Intent it =new Intent();
        it.setClass(this, Manual.class);
        startActivity(it);
    }
    public void Change_Screen()
    {
        switch(Eto_No)
        {
            case 0:
                   Change_Screen_bosatu_List8();
                   break;
            case 1:
                   Change_Screen_bosatu_List1();
                   break;
            case 2:
                   Change_Screen_bosatu_List2();
                   break;
            case 3:
                   Change_Screen_bosatu_List2();
                   break;
            case 4:
                   Change_Screen_bosatu_List3();
                   break;
            case 5:
                   Change_Screen_bosatu_List4();
                   break;
            case 6:
                    Change_Screen_bosatu_List4();
                   break;
            case 7:
                   Change_Screen_bosatu_List5();
                   break;
            case 8:
                  Change_Screen_bosatu_List6();
                  break;
            case 9:
                  Change_Screen_bosatu_List6();
                  break;
            case 10:
                  Change_Screen_bosatu_List7();
                  break;
            case 11:
                  Change_Screen_bosatu_List8();
                  break;

        }
        mode=0;
        flag=1;
        TopScreen_Menu();
    }
    //Topメニュー
    public void TopScreen_Menu()
    {
        switch(No)
        {
            case 0:
                   show_screen2(R.string.Top_menu_No_Select,No);
                   break;
            case 1:
                   show_screen2(R.string.Top_menu_Select1,No);
                   break;
            case 2:
                 //  show_screen2(R.string.Top_menu_Select2,No);
                   break;

        }
    }
    //Menu1 誕生日入力 生まれた年4桁
    public void Born_Year(int buffer_No)
    {
        born_year.Born_Year(buffer_No);
        this.Year=born_year.buffer_year;
        show_screen2(R.string.Input_Born_Year,this.Year);
                //Year=No;
    /*
       switch(buf_count%5)
       {
           case 0:
                born_year.Born_Year(buf_count,No);
               buf_count++;
                Year=born_year.buffer_year;
                show_screen2(R.string.Input_Born_Year,Year);
                break;
           case 1:
                born_year.Born_Year(buf_count,No);
                buf_count++;
                Year=born_year.buffer_year;
                show_screen2(R.string.Input_Born_Year,Year);
                break;
           case 2:
           case 3:
           case 4:
                born_year.Born_Year(buf_count,No);
                buf_count++;
                Year*=10;
                Year+=born_year.buffer_year;
                show_screen2(R.string.Input_Born_Year,Year);
                break;
       }
*/



      /*
        switch(count%5)
        {
            case 0:
                  count++;
                  Year=0;
                  show_screen2(R.string.Input_Born_Year,Year);
                  break;
            case 1:

                  Year=No;
                  count++;
                  show_screen2(R.string.Input_Born_Year,Year);
                  break;
            case 2:
            case 3:
            case 4:
                  Year*=10;
                  Year+=No;
                  count++;
                  show_screen2(R.string.Input_Born_Year,Year);
                  break;
        }
        */
    }
    public void Born_Month(int buf_No)
    {
        born_year.Born_Month(buf_No);
        this.Month=born_year.buffer_month;
        show_screen2(R.string.Input_Born_Month,this.Month);



        /*

        switch(count%3)
        {
            case 0:
                   Month=0;
                   count++;
                   show_screen2(R.string.Input_Born_Month,Month);
                   break;
            case 1:
                   Month=No;
                   count++;
                   show_screen2(R.string.Input_Born_Month,Month);
                   break;
            case 2:
                   Month*=10;
                   Month+=No;
                   count++;
                   show_screen2(R.string.Input_Born_Month,Month);
                   break;
        }
        */
    }
    public void Born_Day(int buf_No)
    {
        born_year.Born_Day(buf_No);
        this.Day=born_year.buffer_day;
        show_screen2(R.string.Input_Born_Day,this.Day);


        /*

        switch(count%3)
        {
            case 0:
                Day=0;
                count++;
                show_screen2(R.string.Input_Born_Day,Day);
                break;
            case 1:
                Day=No;
                count++;
                show_screen2(R.string.Input_Born_Day,Day);
                break;
            case 2:
                Day*=10;
                Day+=No;
                count++;
                show_screen2(R.string.Input_Born_Day,Day);
                break;
        }
        */
    }
    public void Result_Mamori_Honzon_List()
    {
        String[] buffer_MamoriHonzon_List = getResources().getStringArray(R.array.Mamori_Honzon_List);
        String[] buffer_Voice_MamoriHonzon_List = getResources().getStringArray(R.array.Voice_Mamori_Honzon_List);
        if(((Month == 1 && (Day >=1 && Day<=31)) || (Month == 2 && (Day>=1 && Day<=3))))
        {
            Year--;
            Eto_No=(Year+9)%12;
            Year++;

        }
        else {
            Eto_No = (Year + 9) % 12;
        }


        MamoriHonzon_No = Eto_No; //守り本尊番号
        Talk_Message_Show1(buffer_Voice_MamoriHonzon_List[MamoriHonzon_No]);
        show_screen4(buffer_MamoriHonzon_List[MamoriHonzon_No],Year,Month,Day);

    }
    //守り本尊　説明リスト
    //1.千手観音菩薩
    public void Mamorihonzon_List()
    {
        //MamoriHonzon_No 守り本尊番号)
        String[] buf_Mamorihonzon_List = getResources().getStringArray(R.array.mamoriHonzon_List);
      /*
        if(Eto_No==0)
        {
            //0.子 千手観音
            MamoriHonzon_No=0;

        }
        else if(Eto_No==1 || Eto_No==2)
        {
            //1.丑 寅
            MamoriHonzon_No=1;
        }
        else if (Eto_No==3)
        {
            //2.卯
            MamoriHonzon_No=2;
        }
        else if(Eto_No==4 || Eto_No==5)
        {
            //3.辰・巳
            MamoriHonzon_No=3;
        }
        else if(Eto_No==6)
        {
            //4.午
            MamoriHonzon_No=4;
        }
        else if(Eto_No==7 || Eto_No==8)
        {
            //5.未、申
            MamoriHonzon_No=5;
        }
        else if(Eto_No==9)
        {
            //6.酉
            MamoriHonzon_No=6;
        }
        else if(Eto_No==10 || Eto_No == 11)
        {
            //7.戌・亥
            MamoriHonzon_No=7;
        }

*/




        switch(Eto_No)
        {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                   show_screen1(buf_Mamorihonzon_List[Eto_No]);
                   break;
            default:
                   show_screen1("例外に入りました");
                   break;

        }

    }
//画面の切り替え　ここまで
 //Menu部分 ここから
    @Override  
    public boolean onCreateOptionsMenu(Menu menu) 
    {
        //String[] item_menuList = getResources().getStringArray(R.array.Menu_List);
       // int[] item_menuList = getResources().getIntArray(R.array.Menu_List);

        super.onCreateOptionsMenu(menu);

    	menu.add(Menu.NONE,MENU_ID_TEST1,Menu.NONE,R.string.Menu_List1);
        menu.add(Menu.NONE,MENU_ID_TEST2,Menu.NONE,R.string.Menu_List2);
        //menu.add(Menu.NONE,MENU_ID_TEST3,Menu.NONE,R.string.Menu_List3);
    	//menu.add(0,0,0,R.string.Version_Menu);     
    	return true;
    }
    public boolean onOptionsItemSelected(MenuItem item)
    {
    	boolean ret = true;
    	switch(item.getItemId())
    	{
    		 default:
    		  		ret = super.onOptionsItemSelected(item);
    		  		break;
    		 case MENU_ID_TEST1:
    		 //case 0:
                    //マテリアルデザイン
                    //Menu_List();
                     Help_Menu_List();

    		  		//Versiondialog();
    		  		ret=true;
    		  		break;
            case MENU_ID_TEST2:
                   //設定項目
                    Config_Menu_List();
                //case 0:
                //マテリアルデザイン
               // Menu_List();


                //Versiondialog();
                ret=true;
                break;
     //       case MENU_ID_TEST3:
                //case 0:
                //マテリアルデザイン
                //Menu_List();
                //マニュアル
              //  ShowManual_Screen();

                //Versiondialog();
           //     ret=true;
         //       break;
    	}

    	return ret;
    }
 //Menu部分 ここまで
 //Base file 共通class　ここから
 public void ON_OFF_Vibrate(int vibrate) {
     switch (vibrate) {
         case 1: //1:ONのとき、バイブを鳴らす
             vibration();
             break;
         case 0:
             break;
     }
 }

    //バイブレート
    public void vibration() {
        Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        long[] pattern = new long[]{0, 350, 500};
        vibrator.vibrate(pattern, -1);
    }
    public void clear()  //画面消去
    {
    	TextView screen_view = (TextView )findViewById(R.id.view_screen);
    	screen_view.setText(R.string.Clear);
    }
    public void show_screen1(int Message)
    {
    	TextView screen_view = (TextView )findViewById(R.id.view_screen);
    	screen_view.setText(Message);
    }
    public void show_screen1(String Message)
    {
        TextView screen_view = (TextView )findViewById(R.id.view_screen);
        screen_view.setText(Message);
    }
    public void show_screen2(int Message,int flag)
    {
    	TextView screen_view = (TextView )findViewById(R.id.view_screen);
    	String buf_screen=String.format(getString(Message),flag);
    	screen_view.setText(buf_screen);
    }
    public void show_screen3(int Message,int flag,int flag2)
    {
    	TextView screen_view = (TextView )findViewById(R.id.view_screen);
    	String buf_screen=String.format(getString(Message),flag,flag2);
    	screen_view.setText(buf_screen);
    }
    public void show_screen4(String Message,int flag,int flag2,int flag3)
    {
        TextView screen_view = (TextView )findViewById(R.id.view_screen);
        String buf_screen=String.format((Message),flag,flag2,flag3);
        screen_view.setText(buf_screen);
    }
    //テキストスピーチ　メソッド
    public void Talk_Message_Show1(String Message)
    {

        if (tts.isSpeaking()) {
            // 読み上げ中なら止める
            tts.stop();
        }

        String buf_screen=Message;
        // 読み上げ開始
        tts.speak(buf_screen,TextToSpeech.QUEUE_FLUSH, null);

    }
    public void Talk_Message_Show1(int Message)
    {

        if (tts.isSpeaking()) {
            // 読み上げ中なら止める
            tts.stop();
        }

        String buf_screen=String.format(getString(Message));
        // 読み上げ開始
        tts.speak(buf_screen,TextToSpeech.QUEUE_FLUSH, null);

    }
    public void Talk_Message_Show2(int Message,int flag1)
    {
        if (tts.isSpeaking()) {
            // 読み上げ中なら止める
            tts.stop();
        }
        String buf_screen=String.format(getString(Message),flag1);
        // 読み上げ開始
        tts.speak(buf_screen,TextToSpeech.QUEUE_FLUSH, null);
    }
    public void Talk_Message_Show3(int Message,int flag1,int flag2)
    {
        if (tts.isSpeaking()) {
            // 読み上げ中なら止める
            tts.stop();
        }
        String buf_screen=String.format(getString(Message),flag1,flag2);
        // 読み上げ開始
        tts.speak(buf_screen,TextToSpeech.QUEUE_FLUSH, null);
    }
    //エラーダイアログ
    public void Errordialog()
    {
    AlertDialog.Builder AlertDlgBldr = new AlertDialog.Builder(this);   
    AlertDlgBldr.setTitle(R.string.Error_dialog_Title);  
    AlertDlgBldr.setMessage(R.string.Error_dialog_Message);  
    AlertDlgBldr.setPositiveButton(R.string.OK, new DialogInterface.OnClickListener() {  

        public void onClick(DialogInterface dialog, int which) {
        	
        }  
          
    });
    	AlertDialog AlertDlg = AlertDlgBldr.create();  
    	AlertDlg.show();
    }
    //バージョン
    public void Versiondialog()
    {
    AlertDialog.Builder AlertDlgBldr = new AlertDialog.Builder(this);   
    AlertDlgBldr.setTitle(R.string.Version_Title);  
    AlertDlgBldr.setMessage(R.string.VersionMessage);

    AlertDlgBldr.setPositiveButton(R.string.OK, new DialogInterface.OnClickListener() {  
        public void onClick(DialogInterface dialog, int which) 
        {
        	
        }  
          
    });
    	AlertDialog AlertDlg = AlertDlgBldr.create();  
    	AlertDlg.show();
    }


    //Menu List

    public void Menu_List()
    {
        //String[] item_menuList = getResources().getStringArray(R.array.Menu_Top_List);

         final String[] items = {"item_0", "item_1", "item_2"};
        int defaultItem = 0; // デフォルトでチェックされているアイテム
        final List<Integer> checkedItems = new ArrayList<>();
       checkedItems.add(defaultItem);
        new AlertDialog.Builder(this)

                .setTitle("Test")
                .setSingleChoiceItems(items, defaultItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //checkedItems.clear();
                        //checkedItems.add(which);

                    }
                })
                .setPositiveButton(R.string.OK, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       //if (!checkedItems.isEmpty()) {
                            switch(which)
                            {
                                case 0:
                                   // VersionDialog_Material();
                                    break;
                            }
                            //Log.d("checkedItem:", "" + checkedItems.get(0));
                       // }
                    }
                })

                .show();
    }
    //1.Help List
    public void Help_Menu_List()
    {
        String[] item_menuList = getResources().getStringArray(R.array.Menu_HelpTop_List);
        String[] menuList_Title = getResources().getStringArray(R.array.Menu_Title_List);

        //final String[] items = {"item_0", "item_1", "item_2"};
        // final int defaultItem = 0; // デフォルトでチェックされているアイテム
        //final List<Integer> checkedItems = new ArrayList<>();
        //checkedItems.add(defaultItem);
        new AlertDialog.Builder(this)

                .setTitle(menuList_Title[0])
                .setSingleChoiceItems(item_menuList,defaultItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //checkedItems.clear();
                        //checkedItems.add(which);
                        defaultItem = which;
                    }
                })
                .setPositiveButton(R.string.OK, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //if (!checkedItems.isEmpty()) {
                       // final defaultItem = which;
                        switch(defaultItem)
                        {
                            case 1: //バージョン
                                VersionDialog_Material();
                                break;
                            case 2: //参考文献
                               // ReferenceBook_Dialog_Material();
                                break;
                        }
                        defaultItem = 0;
                        //Log.d("checkedItem:", "" + checkedItems.get(0));
                        // }
                    }
                })

                .show();
    }
    //設定メニュー
    public void Config_Menu_List()
    {
        String[] item_menuList = getResources().getStringArray(R.array.Menu_ConfigTop_List);
        String[] menuList_Title = getResources().getStringArray(R.array.Menu_Title_List);

        //final String[] items = {"item_0", "item_1", "item_2"};
        // final int defaultItem = 0; // デフォルトでチェックされているアイテム
        //final List<Integer> checkedItems = new ArrayList<>();
        //checkedItems.add(defaultItem);
        new AlertDialog.Builder(this)

                .setTitle(menuList_Title[1])
                .setSingleChoiceItems(item_menuList,defaultItem2, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //checkedItems.clear();
                        //checkedItems.add(which);
                        defaultItem2 = which;
                    }
                })
                .setPositiveButton(R.string.OK, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //if (!checkedItems.isEmpty()) {
                        // final defaultItem = which;
                        switch(defaultItem2)
                        {
                            case 1: //

                                break;
                            case 2: //
                                break;
                        }
                        defaultItem2 = 0;
                        //Log.d("checkedItem:", "" + checkedItems.get(0));
                        // }
                    }
                })

                .show();
    }
//1-1.Version
public void VersionDialog_Material()
{

    final MaterialDialog mMaterialDialog = new MaterialDialog(this);

    mMaterialDialog.setTitle(R.string.Version_Title);
    mMaterialDialog.setMessage(R.string.VersionMessage);

    //mMaterialDialog.setBackgroundResource(R.color.primary);

    mMaterialDialog.setPositiveButton(R.string.OK, new OnClickListener() {
        @Override
        public void onClick(View v) {
            mMaterialDialog.dismiss();

        }
    });
    mMaterialDialog.show();

}
    //1-2.Reference Book
    public void ReferenceBook_Dialog_Material()
    {

        final MaterialDialog mMaterialDialog = new MaterialDialog(this);

        mMaterialDialog.setTitle(R.string.Reference_Book_Title);
        mMaterialDialog.setMessage(R.string.Reference_Book_Message);

        mMaterialDialog.setBackgroundResource(R.color.primary);

        mMaterialDialog.setPositiveButton(R.string.OK, new OnClickListener() {
            @Override
            public void onClick(View v) {
                mMaterialDialog.dismiss();

            }
        });
        mMaterialDialog.show();

    }
 //Base file 共通class ここまで
 
    public void onClick(View v)
   {
    	
    	Button one_Button = (Button)findViewById(R.id.one_button);
    	Button two_Button = (Button)findViewById(R.id.two_button);
    	Button three_Button = (Button)findViewById(R.id.three_button);
    	Button four_Button = (Button)findViewById(R.id.four_button);
    	Button five_Button = (Button)findViewById(R.id.five_button);
    	Button six_Button = (Button)findViewById(R.id.six_button);
    	Button seven_Button = (Button)findViewById(R.id.seven_button);
    	Button eight_Button = (Button)findViewById(R.id.eight_button);
    	Button nine_Button = (Button)findViewById(R.id.nine_button);
    	Button EXE_Button = (Button)findViewById(R.id.exe_button);
    	Button Clear_Button = (Button)findViewById(R.id.clear_button);
    	Button zero_Button = (Button)findViewById(R.id.zero_button);
    if(v.equals(one_Button))
    {
        No=1;
        ON_OFF_Vibrate(VIBRATION);
        switch(flag)
        {
            case 1:
                   mode=1;
                   TopScreen_Menu();
                   break;
            case 2:
                   mode=2;
                   Born_Year(No);
                   break;
            case 3:
                   mode=3;
                   Born_Month(No);
                   break;
            case 4:
                   mode=4;
                   Born_Day(No);
                   break;
        }
    }
    else if(v.equals(two_Button))
    {
        No=2;
        ON_OFF_Vibrate(VIBRATION);
        switch(flag)
        {
            case 1:

                // TopScreen_Menu();
                  break;
            case 2:
                mode=2;
                Born_Year(No);
                break;
            case 3:
                mode=3;
                Born_Month(No);
                break;
            case 4:
                mode=4;
                Born_Day(No);
                break;
        }
    }
    else if(v.equals(three_Button))
    {
        No=3;
        ON_OFF_Vibrate(VIBRATION);
        switch(flag)
        {
            case 2:
                mode=2;
                Born_Year(No);
                break;
            case 3:
                mode=3;
                Born_Month(No);
                break;
            case 4:
                mode=4;
                Born_Day(No);
                break;
        }
    }
    else if(v.equals(four_Button))
    {
        No=4;
        ON_OFF_Vibrate(VIBRATION);
        switch(flag)
        {
            case 2:
                mode=2;
                Born_Year(No);
                break;
            case 3:
                mode=3;
                Born_Month(No);
                break;
            case 4:
                mode=4;
                Born_Day(No);
                break;
        }
    }
    else if(v.equals(five_Button))
    {
        No=5;
        ON_OFF_Vibrate(VIBRATION);
        switch(flag)
        {
            case 2:
                mode=2;
                Born_Year(No);
                break;
            case 3:
                mode=3;
                Born_Month(No);
                break;
            case 4:
                mode=4;
                Born_Day(No);
                break;
        }
    }
    else if(v.equals(six_Button))
    {
        No=6;
        ON_OFF_Vibrate(VIBRATION);
        switch(flag)
        {
            case 2:
                mode=2;
                Born_Year(No);
                break;
            case 3:
                mode=3;
                Born_Month(No);
                break;
            case 4:
                mode=4;
                Born_Day(No);
                break;
        }
    }
    else if(v.equals(seven_Button))
    {
        No=7;
        ON_OFF_Vibrate(VIBRATION);
        switch(flag)
        {
            case 2:
                mode=2;
                Born_Year(No);
                break;
            case 3:
                mode=3;
                Born_Month(No);
                break;
            case 4:
                mode=4;
                Born_Day(No);
                break;
        }
    }
    else if(v.equals(eight_Button))
    {
        No=8;
        ON_OFF_Vibrate(VIBRATION);
        switch(flag)
        {
            case 2:
                mode=2;
                Born_Year(No);
                break;
            case 3:
                mode=3;
                Born_Month(No);
                break;
            case 4:
                mode=4;
                Born_Day(No);
                break;
        }
    }
    else if(v.equals(nine_Button))
    {
        No=9;
        ON_OFF_Vibrate(VIBRATION);
        switch(flag)
        {
            case 2:
                mode=2;
                Born_Year(No);
                break;
            case 3:
                mode=3;
                Born_Month(No);
                break;
            case 4:
                mode=4;
                Born_Day(No);
                break;
        }
    }
    else if(v.equals(zero_Button))
    {
        No=0;
        ON_OFF_Vibrate(VIBRATION);
        switch(flag)
        {
            case 2:
                mode=2;
                Born_Year(No);
                break;
            case 3:
                mode=3;
                Born_Month(No);
                break;
            case 4:
                mode=4;
                Born_Day(No);
                break;
        }
    }
    else if(v.equals(EXE_Button))
    {
        No=0;
        ON_OFF_Vibrate(VIBRATION);
    	//Change_Screen();
        switch(mode)
        {
            case 0:
                   flag=1;
                   TopScreen_Menu();
                   break;
            case 1:
                   flag=2;
                count=0;
                Born_Year(No);
                   break;
            case 2:
                   flag=3;
                   count=0;
                   Born_Month(No);
                   break;
            case 3:
                   flag=4;
                count=0;
                   Born_Day(No);
                   break;
            case 4:
                   //Menu1 診断結果　守り本尊表示
                   mode=5;
                   Result_Mamori_Honzon_List();
                   break;
            case 5:
                   mode=6;
                   Mamorihonzon_List();
                   break;
            case 6:

                   Change_Screen();
                   break;
        }
    }
    else if(v.equals(Clear_Button))
    {
        ON_OFF_Vibrate(VIBRATION);
        All_Clear();
    }

    /*
       if (buttonSlow == v) {
           // 再生速度の設定
           tts.setSpeechRate(SPEECH_SLOW);
       } else if (buttonNormal == v) {
           // 再生速度の設定
           tts.setSpeechRate(SPEECH_NORMAL);
       } else if (buttonFast == v) {
           // 再生速度の設定
           tts.setSpeechRate(SPEECH_FAST);
       } else if (buttonLowPitch == v) {
           // 再生ピッチの設定
           tts.setPitch(PITCH_LOW);
       } else if (buttonNormalPitch == v) {
           // 再生ピッチの設定
           tts.setPitch(PITCH_NORMAL);
       } else if (buttonHighPitch == v) {
           // 再生ピッチの設定
           tts.setPitch(PITCH_HIGH);
       }
       */
   }


}