package com.everyoo.sqldaemon;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.everyoo.localdata.sql.bean.MyBean;
import com.everyoo.localdata.sql.userdao.MyUserDao;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @InjectView(R.id.create_sql)
    Button createSql;
    @InjectView(R.id.delete_sql)
    Button deleteSql;
    @InjectView(R.id.insert)
    Button insert;
    @InjectView(R.id.edit)
    Button edit;
    @InjectView(R.id.delete)
    Button delete;
    @InjectView(R.id.query)
    Button query;
    @InjectView(R.id.tv)
    TextView tv;
    @InjectView(R.id.replace)
    Button replace;


    private ArrayList<MyBean> beanArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        initEvent();
        initData();


    }

    private void initData() {

        beanArrayList = new ArrayList<>();

        MyBean myBean1 = new MyBean();

        myBean1.setName("西游记");
        myBean1.setAuthor("罗贯中");
        myBean1.setPages(180);
        myBean1.setPrice("80元");
        beanArrayList.add(myBean1);

        MyBean myBean2 = new MyBean();
        myBean2.setName("红楼梦");
        myBean2.setAuthor("曹雪芹");
        myBean2.setPages(480);
        myBean2.setPrice("50元");
        beanArrayList.add(myBean2);


        MyBean myBean3 = new MyBean();
        myBean3.setName("三国");
        myBean3.setAuthor("诸葛亮");
        myBean3.setPages(430);
        myBean3.setPrice("90元");
        beanArrayList.add(myBean3);


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.create_sql:
                System.out.println("MainActivity.onClick create_sql");
                MyUserDao.getInstance(this).getWritableDatabase();//这个操作一般不需要
                break;
            case R.id.delete_sql:
                boolean b = MyUserDao.getInstance(this).deleteDatabases(this, "BookStore.db");
                System.out.println("MainActivity.onClick delete_sql b=" + b);
                break;
            case R.id.insert:
                System.out.println("MainActivity.onClick insert");
                MyUserDao.getInstance(this).insert(beanArrayList);
                beanArrayList.clear();
                break;
            case R.id.edit:
                System.out.println("MainActivity.onClick edit");
                MyUserDao.getInstance(this).update("红楼梦", "1000元");

                break;
            case R.id.delete:
                System.out.println("MainActivity.onClick delete");
                MyUserDao.getInstance(this).delete("红楼梦");

                break;
            case R.id.query:
                System.out.println("MainActivity.onClick query");
                /*System.out.println("MainActivity.onClick 数据库总共的数据条数=" + MyUserDao.getInstance(this).queryCount());
                String price=MyUserDao.getInstance(this).queryPrice("西游记");
                tv.setText(price);*/

                ArrayList<MyBean> arrayList = MyUserDao.getInstance(this).queryAll();
                for (MyBean myBean : arrayList) {
                    System.out.println("MainActivity.onClick=" + myBean.getPrice());
                    System.out.println("MainActivity.onClick=" + myBean.getName());
                    System.out.println("MainActivity.onClick=" + myBean.getAuthor());
                    System.out.println("MainActivity.onClick=" + myBean.getPages());

                    System.out.println("  ");
                }


                break;
            case R.id.replace:
                System.out.println("MainActivity.onClick replace");

                MyBean myBean3 = new MyBean();
                myBean3.setName("西游记");
                myBean3.setAuthor("罗贯中");
                myBean3.setPages(180);
                myBean3.setPrice("80元");
                beanArrayList.add(myBean3);

                MyBean myBean4 = new MyBean();
                myBean4.setName("西游记");
                myBean4.setAuthor("罗贯中");
                myBean4.setPages(180);
                myBean4.setPrice("80元");
                beanArrayList.add(myBean4);

                MyUserDao.getInstance(this).transaction(beanArrayList);

                beanArrayList.clear();
                break;
            default:
                break;
        }

    }


    private void initEvent() {
        createSql.setOnClickListener(this);
        deleteSql.setOnClickListener(this);

        insert.setOnClickListener(this);
        edit.setOnClickListener(this);
        delete.setOnClickListener(this);
        query.setOnClickListener(this);
        replace.setOnClickListener(this);

    }
}
