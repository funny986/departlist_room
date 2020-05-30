package com.departlistv3;

import android.annotation.SuppressLint;
import android.view.*;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import dataBases.Contacts;
import utils.*;

import static com.departlistv3.MainActivity.*;


public class OpenContact extends AppCompatActivity {

    @SuppressLint("StaticFieldLeak")
    public static SearchView searchView;
    public ArrayList<Contacts> searchList = new ArrayList<>();

    @Override
    public void onSaveInstanceState(Bundle outSt) {
        super.onSaveInstanceState(outSt);
    }

    Intent editmemder;

    public boolean onContextItemSelected(@NonNull MenuItem item) {
        String name;
        int pos = item.getGroupId();
        editmemder = new Intent(this, EditMember.class);
        switch (item.getItemId()) {
            case R.id.edit_context:
                if (!searchList.isEmpty()) {
                    editmemder.putExtra("contex", true);
                    editmemder.putExtra("id", searchList.get(pos).getId());
                    startActivity(editmemder);
                } else {
                    editmemder.putExtra("contex", true);
                    editmemder.putExtra("id", lstContact.get(pos).getId());
                    startActivity(editmemder);
                }
                break;
            case R.id.delete_context:
                int id;
                if (!searchList.isEmpty()) {
                    id = searchList.get(pos).getId();
                    name = " \n" + searchList.get(pos).getLastName() + " " +
                            searchList.get(pos).getFirstName() + " " +
                            searchList.get(pos).getMiddleName();
                } else {
                    id = lstContact.get(pos).getId();
                    name = " \n\n" + lstContact.get(pos).getLastName() + " " +
                            lstContact.get(pos).getFirstName() + " " +
                            lstContact.get(pos).getMiddleName();
                }
                DelFromContext del = new DelFromContext();
                del.setId_del(id, name);
                del.show(getSupportFragmentManager(), "NoticeDel");
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater Inflater = getMenuInflater();
        Inflater.inflate(R.menu.dpl_menu, menu);
        searchView = (SearchView) menu.findItem(R.id.search_member).getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return true;
            }

            @Override
            public boolean onQueryTextChange(String searchText) {
                ArrayList<Contacts> tempString = new ArrayList<>();
                searchList.clear();
                for (Contacts tempCont : lstContact) {
                    String temp = tempCont.getLastName();
                    if (temp.toLowerCase().contains(searchText.toLowerCase())) {
                        tempString.add(tempCont);
                    }
                }
                searchList = tempString;
                FragmentContact.recycleViewAdapter.setmData(searchList);
                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);
    } //optionMenu

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.anew_member:
                Intent addmemder = new Intent(this, AddMember.class);
                startActivity(addmemder);
                return true;
            case R.id.del_member:
                DialogDelMember dialogDelMember = new DialogDelMember();
                dialogDelMember.show(getSupportFragmentManager(), "NoticeDialogFragment");
                return true;
            case R.id.edit_member:
                editmemder = new Intent(this, EditMember.class);
                startActivity(editmemder);
                return true;
            case R.id.closing_app:
                finishAffinity();
                return true;
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_contact);
        setTitle(depName);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setElevation(0);

        TabLayout tableLayout = findViewById(R.id.tablayout_id);
        ViewPager viewPager = findViewById(R.id.viewpager_id);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), 0);
        adapter.AddFragment(new FragmentContact(), "Контакты");
        adapter.AddFragment(new FragmentFav(), "Информация");
        viewPager.setAdapter(adapter);
        tableLayout.setupWithViewPager(viewPager);
    }
}


