package com.departlistv3;

import android.content.SharedPreferences;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import dataBases.*;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import static utils.ListWork.*;

@SuppressWarnings("ALL")
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button[] butn;
    private   String[] dep;
    public static String depName;
    String forToast;

    public static final String APP_PREFERENCE = "launch";
    public static final String APP_PREFERENCE_COUNT = "count";
    public static final String APP_PREFERENCE_ID_COUNT = "countID";
    private SharedPreferences preferences;
    private boolean count;
    private int lastIdCount;
    private final int VERSION = 1;

    public static List<Contacts> lstContact;

    protected void onResume(){
        super.onResume();
        if (preferences.contains(APP_PREFERENCE_COUNT)) {
            count = preferences.getBoolean(APP_PREFERENCE_COUNT, false);
            lastIdCount = preferences.getInt(APP_PREFERENCE_ID_COUNT, 1000);
            if (getLastID() <= lastIdCount) {
                setLastID(lastIdCount);
                if (VERSION != 1) { }
            }
        }
        if (!count) {
            setLastID(1);
            setDataContactList(departDataBase, dep);
            count = true;
            lastIdCount = getLastID();
        }
    }

    protected void onPause(){
        super.onPause();
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(APP_PREFERENCE_COUNT, count);
        editor.putInt(APP_PREFERENCE_ID_COUNT, getLastID());
        editor.apply();
    }

    public void onClick (@NonNull View v) {
        switch (v.getId()) {
            case R.id.btn_01:
                forToast = depName = dep[0];
                lstContact.clear();
                lstContact = departDataBase.departmentDao().getContactsList(1);
                setDepId(1);
                break;
            case R.id.btn_02:
                forToast = depName = dep[1];
                lstContact.clear();
                setDepId(2);
                lstContact = departDataBase.departmentDao().getContactsList(2);
                break;
            case R.id.btn_03:
                forToast = depName = dep[2];
                lstContact.clear();
                setDepId(3);
                lstContact = departDataBase.departmentDao().getContactsList(3);
                break;
            case R.id.btn_04:
                forToast = depName = dep[3];
                lstContact.clear();
                setDepId(4);
                lstContact = departDataBase.departmentDao().getContactsList(4);
                break;
            case R.id.btn_05:
                forToast = depName = dep[4];
                lstContact.clear();
                setDepId(5);
                lstContact = departDataBase.departmentDao().getContactsList(5);
                break;
        }
        Intent intent = new Intent(getApplicationContext(), OpenContact.class);
        Toast.makeText(getApplicationContext(),
                forToast,
                Toast.LENGTH_SHORT)
                .show();
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        switch (item.getItemId()){
            case R.id.closing_app :
                this.finishAffinity();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public static DepartDataBase departDataBase;
    private Resources resources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_action);
            setSupportActionBar(toolbar);
            TextView textView = findViewById(R.id.title_toolbar);
            textView.setText("Отделы:");
        resources = getResources();
        preferences = getSharedPreferences(APP_PREFERENCE, this.MODE_PRIVATE);
        butn = new Button[getResources().getInteger(R.integer.quantity_departments)];
            butn[0] = findViewById(R.id.btn_01);
            butn[1] = findViewById(R.id.btn_02);
            butn[2] = findViewById(R.id.btn_03);
            butn[3] = findViewById(R.id.btn_04);
            butn[4] = findViewById(R.id.btn_05);

        dep = resources.getStringArray(R.array.lists);
        departDataBase = App.getInstance().getDataBase();
        lstContact = new ArrayList<>();

        for (int i=0; i < butn.length; i++) {
            butn[i].setText(dep[i]);
            butn[i].setOnClickListener(this);
        }
    }
}

