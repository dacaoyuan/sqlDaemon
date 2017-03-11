package com.everyoo.ormlitedaemon;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.everyoo.localdata.sql.bean.MyBean;
import com.everyoo.localdata.sql.dao.MyDataDao;

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
    private MyBean myBean1;
    private MyBean myBean2;
    private MyBean myBean3;
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
        myBean1 = new MyBean();
        myBean1.setName("西游记");
        myBean1.setAuthor("罗贯中1");
        myBean1.setPages(180);
        myBean1.setPrice("80元");
        //myBean1.setBookType(123);
        beanArrayList.add(myBean1);

       /* myBean2 = new MyBean();
        myBean2.setName("红楼梦");
        myBean2.setAuthor("曹雪芹");
        myBean2.setPages(480);
        myBean2.setPrice("50元");
        beanArrayList.add(myBean2);*/


       /* myBean3 = new MyBean();
        myBean3.setName("三国");
        myBean3.setAuthor("诸葛亮");
        myBean3.setPages(430);
        myBean3.setPrice("90元");
        beanArrayList.add(myBean3);*/

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.create_sql:
                System.out.println("MainActivity.onClick create_sql");
                break;
            case R.id.delete_sql:
                // boolean b = MyDataDao.getInstance(this).delteDatabases(this, "BookStore.db");//删除数据库

                //int b = MyDataDao.getInstance(this).createTables(Constans.CREATE_BOOK);//创建表

                //int b = MyDataDao.getInstance(this).modifyTables("Book1", "Book");//修改表名

                int b = MyDataDao.getInstance(this).deleteTables("Book");//删除表

                System.out.println("MainActivity.onClick delete_sql b=" + b);
                break;

            case R.id.insert:
                System.out.println("MainActivity.onClick insert");
                MyDataDao.getInstance(this).insert(beanArrayList);
                beanArrayList.clear();


                //MyDataDao.getInstance(this).insert(myBean1);
                // MyDataDao.getInstance(this).insert(myBean2);
                //MyDataDao.getInstance(this).insert(myBean3);

                break;
            case R.id.edit:
                System.out.println("MainActivity.onClick edit");
                //MyDataDao.getInstance(this).update2("name", "西游记");
                MyDataDao.getInstance(this).update3("name", "西游记", "price", "33333元");


                break;
            case R.id.delete:
                System.out.println("MainActivity.onClick delete");
                //MyDataDao.getInstance(this).delete("西游记");

                int i = MyDataDao.getInstance(this).deleteAll();
                System.out.println("MainActivity.onClick i=" + i);

                break;
            case R.id.query:
                System.out.println("MainActivity.onClick query");

               /* ArrayList<String> arrayList = MyDataDao.getInstance(this).queryPrice("西游记");
                if (arrayList != null) {
                    StringBuffer stringBuffer = new StringBuffer();
                    for (String s : arrayList) {
                        stringBuffer.append(s + " ");
                    }
                    tv.setText("西游记的价格都有=" + stringBuffer);
                }*/


                /*String s = MyDataDao.getInstance(this).queryAuthor("西游记", "80元");
                System.out.println("MainActivity.onClick s=" + s);*/

                long number = MyDataDao.getInstance(this).queryCount();
                System.out.println("MainActivity.onClick number=" + number);

                ArrayList<MyBean> myBeanArrayList = MyDataDao.getInstance(this).queryId(3);
                if (myBeanArrayList != null) {
                    for (MyBean myBean : myBeanArrayList) {
                        System.out.println("MainActivity.onClick query=" + myBean.getPrice());
                        System.out.println("MainActivity.onClick query=" + myBean.getAuthor());
                        System.out.println("MainActivity.onClick query=" + myBean.getName());
                        System.out.println("MainActivity.onClick query=" + myBean.getPages());
                        System.out.println("    ");
                    }
                    myBeanArrayList.clear();

                }


                /*ArrayList<MyBean> beanArrayList = MyDataDao.getInstance(this).queryAll();
                if (beanArrayList != null) {
                    for (MyBean myBean : beanArrayList) {
                        System.out.println("MainActivity.onClick query=" + myBean.getPrice());
                        System.out.println("MainActivity.onClick query=" + myBean.getAuthor());
                        System.out.println("MainActivity.onClick query=" + myBean.getName());
                        System.out.println("MainActivity.onClick query=" + myBean.getPages());
                        System.out.println("    ");
                    }

                    beanArrayList.clear();
                }*/

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


    }
}
