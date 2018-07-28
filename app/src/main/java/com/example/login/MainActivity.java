package com.example.login;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener{

    //声明用于展示布局的Fragement
    private HomeFragement homeFragement;
    private CourseFragement courseFragement;
    private SearchFragement searchFragement;
    private TeacherFragement teacherFragement;
    private MyselfFragement myselfFragement;

    //声明五个布局对象
    private View homeLayout;
    private View courseLayout;
    private View searchLayout;
    private View teacherLayout;
    private View myselfLayout;

    //在标签上显示的图标
    private ImageView homeImage;
    private ImageView courseImage;
    private ImageView searchImage;
    private ImageView teacherImage;
    private ImageView myselfImage;

    //在标签上的文字对象
    private TextView homeText;
    private TextView courseText;
    private TextView searchText;
    private TextView teacherText;
    private TextView myselfText;

    //声明一个对Fragement管理的对象
    private FragmentManager fragementManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        fragementManager = getFragmentManager ();
        initViews();
        setTabSelection(0);
    }

    /**
     * 初始化
     */
    private void initViews(){
        //初始化标签
        homeLayout = (View) findViewById ( R.id.home_layout );
        courseLayout = (View)findViewById ( R.id.course_layout );
        searchLayout = (View)findViewById ( R.id.search_layout );
        teacherLayout = (View)findViewById ( R.id.teacher_layout );
        myselfLayout = (View)findViewById ( R.id.myself_layout );

        //初始化图标
        homeImage = (ImageView)findViewById ( R.id.home_image );
        courseImage = (ImageView)findViewById ( R.id.course_image );
        searchImage = (ImageView)findViewById ( R.id.search_image );
        teacherImage = (ImageView)findViewById ( R.id.teacher_image );
        myselfImage = (ImageView) findViewById ( R.id.myself_image );

        //初始化文字
        homeText = (TextView) findViewById ( R.id.home_text );
        courseText = (TextView)findViewById ( R.id.course_text );
        searchText = (TextView)findViewById ( R.id.search_text );
        teacherText = (TextView)findViewById ( R.id.teacher_text );
        myselfText = (TextView)findViewById ( R.id.myself_text );

        //设置标签的鼠标监听事件
        homeLayout.setOnClickListener ( this );
        courseLayout.setOnClickListener ( this );
        searchLayout.setOnClickListener ( this );
        teacherLayout.setOnClickListener ( this );
        myselfLayout.setOnClickListener ( this );
    }

    public void onClick(View v){
        switch (v.getId ()){
            case R.id.home_layout:
                setTabSelection ( 0 );
                break;
            case R.id.course_layout:
                setTabSelection ( 1 );
                break;
            case R.id.search_layout:
                setTabSelection ( 2 );
                break;
            case R.id.teacher_layout:
                setTabSelection ( 3 );
                break;
            case R.id.myself_layout:
                setTabSelection ( 4 );
                break;
                default:
                    break;
        }
    }

    private void setTabSelection(int index){
        //先清楚上次的显示状态
        clearSelection();
        FragmentTransaction transaction = fragementManager.beginTransaction ();
        hideFragement(transaction);
        switch (index){
            case 0:
                homeImage.setImageResource ( R.drawable.home );
                homeText.setTextColor ( Color.GREEN );

                if(homeFragement==null){
                    homeFragement = new HomeFragement ();
                    transaction.add ( R.id.content,homeFragement );
                }else{
                    transaction.show ( homeFragement );
                }
                break;

            case 1:
                courseImage.setImageResource ( R.drawable.kecheng );
                courseText.setTextColor ( Color.GREEN );

                if(courseFragement==null){
                    courseFragement = new CourseFragement ();
                    transaction.add ( R.id.content,courseFragement );
                }else{
                    transaction.show ( courseFragement );
                }
                break;

            case 2:
                searchImage.setImageResource ( R.drawable.search );
                searchText.setTextColor ( Color.GREEN );

                if(searchFragement==null){
                    searchFragement = new SearchFragement ();
                    transaction.add ( R.id.content,searchFragement );
                }else{
                    transaction.show ( searchFragement );
                }
                break;

            case 3:
                teacherImage.setImageResource ( R.drawable.teacher );
                teacherText.setTextColor ( Color.GREEN );

                if(teacherFragement==null){
                    teacherFragement = new TeacherFragement ();
                    transaction.add ( R.id.content,teacherFragement );
                }else{
                    transaction.show ( teacherFragement );
                }
                break;

            case 4:
                myselfImage.setImageResource ( R.drawable.myself );
                myselfText.setTextColor ( Color.GREEN );

                if(myselfFragement==null){
                    myselfFragement = new MyselfFragement ();
                    transaction.add ( R.id.content,homeFragement );
                }else{
                    transaction.show ( myselfFragement );
                }
                break;
        }
    }

    private void clearSelection(){
        homeImage.setImageResource ( R.drawable.home );
        homeText.setTextColor ( Color.parseColor ( "#ffffff" ) );

        courseImage.setImageResource ( R.drawable.kecheng );
        courseText.setTextColor ( Color.parseColor ( "#ffffff" ) );

        searchImage.setImageResource ( R.drawable.search);
        searchText.setTextColor ( Color.parseColor ( "#ffffff" ) );

        teacherImage.setImageResource ( R.drawable.teacher );
        teacherText.setTextColor ( Color.parseColor ( "#ffffff" ) );

        myselfImage.setImageResource ( R.drawable.myself );
        myselfText.setTextColor ( Color.parseColor ( "#ffffff" ) );
    }

    //隐藏过时的Fragement
    private void hideFragement(FragmentTransaction transaction){
        if(homeFragement != null){
            transaction.hide ( homeFragement );
        }
        if(courseFragement != null){
            transaction.hide ( courseFragement );
        }
        if(searchFragement != null){
            transaction.hide ( searchFragement );
        }
        if(teacherFragement != null){
            transaction.hide ( teacherFragement );
        }
        if(myselfFragement != null){
            transaction.hide ( myselfFragement );
        }
    }
}
