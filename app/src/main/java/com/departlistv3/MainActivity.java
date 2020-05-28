package com.departlistv3;

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
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import utils.Contact;

import java.util.ArrayList;
import java.util.List;

import static utils.ListWork.*;

@SuppressWarnings("ALL")
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button[] butn;
    private String[] dep;
    public static String depName;
    String forToast;

    public static List<Contact> lstContact;

    public void onClick (@NonNull View v) {
        switch (v.getId()) {
            case R.id.btn_01:
                forToast = depName = dep[0];
                lstContact.clear();
                List<DepartOne> departOneList = departDataBase.departOneDao().getAll();
                for (DepartOne departOne : departOneList){
                    lstContact.add(new Contact(
                            departOne.lastName,
                            departOne.firstName,
                            departOne.middleName,
                            departOne.positionName,
                            departOne.phone,
                            departOne.id
                    ));
                }

                break;
            case R.id.btn_02:
                forToast = depName = dep[1];
                lstContact.clear();
                List<DepartTwo> departTwoList = departDataBase.departTwoDao().getAll();
                for (DepartTwo departTwo : departTwoList){
                    lstContact.add(new Contact(
                            departTwo.lastName,
                            departTwo.firstName,
                            departTwo.middleName,
                            departTwo.positionName,
                            departTwo.phone,
                            departTwo.id
                    ));
                }
                break;
            case R.id.btn_03:
                forToast = depName = dep[2];
                lstContact.clear();
                List<DepartThree> departThreeList = departDataBase.departThreeDao().getAll();
                for (DepartThree departThree : departThreeList){
                    lstContact.add(new Contact(
                            departThree.lastName,
                            departThree.firstName,
                            departThree.middleName,
                            departThree.positionName,
                            departThree.phone,
                            departThree.id
                    ));
                }
                break;
            case R.id.btn_04:
                forToast = depName = dep[3];
                lstContact.clear();
                List<DepartFour> departFourList = departDataBase.departFourDao().getAll();
                for (DepartFour departFour : departFourList){
                    lstContact.add(new Contact(
                            departFour.lastName,
                            departFour.firstName,
                            departFour.middleName,
                            departFour.positionName,
                            departFour.phone,
                            departFour.id
                    ));
                }
                break;
            case R.id.btn_05:
                forToast = depName = dep[4];
                lstContact.clear();
                List<DepartFive> departFiveList = departDataBase.departFiveDao().getAll();
                for (DepartFive departFive : departFiveList){
                    lstContact.add(new Contact(
                            departFive.lastName,
                            departFive.firstName,
                            departFive.middleName,
                            departFive.positionName,
                            departFive.phone,
                            departFive.id
                    ));
                }
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
        ActionBar bar = getSupportActionBar();
        resources = getResources();
        butn = new Button[getResources().getInteger(R.integer.quantity_departments)];
        butn[0] = findViewById(R.id.btn_01);
        butn[1] = findViewById(R.id.btn_02);
        butn[2] = findViewById(R.id.btn_03);
        butn[3] = findViewById(R.id.btn_04);
        butn[4] = findViewById(R.id.btn_05);
        dep = resources.getStringArray(R.array.lists);
        departDataBase = App.getInstance().getDataBase();
        setDataContactList(departDataBase, dep);
//        setDataContactList(departDataBase);
        lstContact = new ArrayList<>();
        for (int i=0; i < butn.length; i++) {
            butn[i].setText(dep[i]);
            butn[i].setOnClickListener(this);
        }
    }
}

