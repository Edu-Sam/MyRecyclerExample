package com.example.myrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myrecyclerview.models.DataModel;
import java.util.ArrayList;
import android.view.View;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private static ArrayList<DataModel> data;
    static View.OnClickListener myOnClickListener;
    private static ArrayList<Integer> removedItems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private static class MyOnClickListener implements View.OnClickListener{
        private final Context context;

        private MyOnClickListener(Context context){
            this.context=context;
        }

        @Override
        public  void onClick(View v){

        }
        private void removeItem(View v){
            int selectedItemPosition =recyclerView.getChildAdapterPosition(v);
            RecyclerView.ViewHolder viewHolder=recyclerView.findViewHolderForAdapterPosition(selectedItemPosition);
            TextView textViewName =(TextView)viewHolder.itemView.findViewById(R.id.textViewName);
            String selectedName=(String)textViewName.getText();
            int selectedItemId=-1;
            for(int i=0;i < MyData.nameArray.length;i++){
                   if(selectedName.equals(MyData.nameArray[i])){
                       selectedItemId=MyData.id_[i];

                   }
            }

            removedItems.add(selectedItemId);
            data.remove(selectedItemPosition);

            adapter.notifyItemRemoved(selectedItemPosition);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
             super.onCreateOptionsMenu(menu);
             getMenuInflater().inflate(R.menu.menu,menu);
             return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){
        super.onOptionsItemSelected(menuItem);
        return true;
    }
}