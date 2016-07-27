package com.li.listviewpic;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
     private ImageView mIamgeView=null;
     private TextView mTextView=null;
     private  List<Fruit> mFruitList;
     private ListView mlistview=null;
     private FruitAdapter mFruitAdapter=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        ///开始自己的代码
        mFruitList=new ArrayList<Fruit>();

        //生成FruitList
        String[] fr={"apple","banana","orange","watermelon","pear","grape"};
        int[] fruitImage={R.drawable.apple_pic,R.drawable.banana_pic,
                R.drawable.orange_pic,R.drawable.watermelon_pic,R.drawable.pear_pic,
                R.drawable.grape_pic };
        for(int i=0;i<fr.length;i++)
        {
            Fruit fruit=new Fruit(fruitImage[i],fr[i]);
            mFruitList.add(fruit);
        }
        //定义一个adapter
        final FruitAdapter fruitAdapter=new FruitAdapter(this,R.layout.list_item_fruit,
                mFruitList);
         mlistview= (ListView) findViewById(R.id.activitiy_mian_list_view);
         mlistview.setAdapter(fruitAdapter);
       //mlistview.setAdapter(fruitAdapter);
        mlistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "你点了"+fruitAdapter.getItem(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public  class  FruitAdapter extends ArrayAdapter<Fruit>
    {
        public FruitAdapter(Context context, int resource, List<Fruit> objects) {
            super(context, resource, objects);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //return super.getView(position, convertView, parent);

            View view;
            Fruit fruit=getItem(position);
            ViewHolder viewHolder;
            if(convertView==null) {

                //得到的view不仅仅是一个框架，还有框架中的list_item_fruit_text_view和list_item_fruit_image_view
                view = LayoutInflater.from(getContext()).inflate(R.layout.list_item_fruit, parent, false);
                viewHolder=new ViewHolder();
                viewHolder.fruitName= (TextView) view.findViewById(R.id.list_item_fruit_text_view);
                viewHolder.fruitImage= (ImageView)view.findViewById(R.id.list_item_fruit_image_view);
                view.setTag(viewHolder);
            }
            else
            {
                view=convertView;
                viewHolder= (ViewHolder) view.getTag();
            }
            viewHolder.fruitImage.setImageResource(fruit.getImageId());
            viewHolder.fruitName.setText(fruit.getName());
            return  view;
            //在定义adapter类中不能从主窗体中findViewById，而是需要从前面得到View中findViewById
           // if(convertView==null) {
           //mTextView= (TextView) view.findViewById(R.id.list_item_fruit_text_view);
           //mIamgeView= (ImageView)view.findViewById(R.id.list_item_fruit_image_view);
            //mTextView.setText(fruit.getName());
           // mIamgeView.setImageResource(fruit.getImageId());
            //return view;


            //if(convertView==null){
            //view= LayoutInflater.from(getContext()).inflate(R.layout.list_item_fruit,parent,false);}
           // else
            //{view=convertView;}
            //mTextView= (TextView) findViewById(R.id.list_item_fruit_text_view);
            //mIamgeView= (ImageView) findViewById(R.id.list_item_fruit_image_view);
            //mTextView.setText(fruit.getName());
            //mIamgeView.setImageResource(fruit.getImageId());
            //return  view;
        }
        class  ViewHolder{

            ImageView fruitImage;
            TextView fruitName;
        }
    }





}
