package com.example.jcs.orderassistant.ui;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.jcs.orderassistant.R;
import com.example.jcs.orderassistant.app.OrderApplication;
import com.example.jcs.orderassistant.db.DatabaseHelper;
import com.example.jcs.orderassistant.db.DatabaseSchema;

import java.util.ArrayList;
import java.util.List;

public class BanlaceActivity extends Activity {

    private ListView listView = null;
    private List<MemberInfo> memberList = new ArrayList<MemberInfo>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banlace);

        listView = (ListView) findViewById(R.id.main_lv);
        getMemberInfo();
        MemberInfoAdapter adapter = new MemberInfoAdapter(BanlaceActivity.this,R.layout.balance_item,memberList);
        listView.setAdapter(adapter);
    }

    private void getMemberInfo()
    {
        memberList.clear();
        DatabaseHelper dbHelper = OrderApplication.getDbHelper();
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String query = "select * from " + DatabaseSchema.MemberEntry.TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);
        while (cursor.moveToNext()){
            MemberInfo info = new MemberInfo(cursor.getString(1),cursor.getInt(2));
            memberList.add(info);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_banlace, menu);
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
}
