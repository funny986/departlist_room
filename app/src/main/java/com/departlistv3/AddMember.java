package com.departlistv3;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

import dataBases.Contacts;
import utils.DialogAddMember;

import static com.departlistv3.MainActivity.*;
import static utils.ListWork.*;

public class AddMember extends AppCompatActivity {

    private EditText firstNameNew, lastNameNew, positionNameNew, middleNameNew, phoneNameNew;
    public static    String fnn, lnn, mnn, pnn, phnn;
    public static ArrayList<Boolean> readyToAdd = new ArrayList<>();
    public static DialogAddMember dialogAddMember;

    private void makeDialog(){
        dialogAddMember = new DialogAddMember();
        dialogAddMember.setCancelable(false);
        dialogAddMember.show(getSupportFragmentManager(), "dialogerror");
    }
    private boolean checkFlags(ArrayList<Boolean> forcheck){
        for (int z = 0; z < forcheck.size(); z++){
            if (!forcheck.get(z)){
                switch (z){
                    case 0:
                        Toast.makeText(getApplicationContext(),
                                R.string.toast_addM,
                                Toast.LENGTH_SHORT)
                                .show();
                            setDialogTtl(getString(R.string.inter_lastname));
                            setTextToDialog(getString(R.string.dialog_txtname));
                            makeDialog();
                    break;
                    case 1:
                        Toast.makeText(getApplicationContext(),
                                R.string.toast_addM,
                                Toast.LENGTH_SHORT)
                                .show();
                        setDialogTtl(getString(R.string.inter_firstname));
                        setTextToDialog(getString(R.string.dialog_txtname));
                        makeDialog();
                        break;
                    case 2:
                        Toast.makeText(getApplicationContext(),
                                R.string.toast_addM,
                                Toast.LENGTH_SHORT)
                                .show();
                        setDialogTtl(getString(R.string.inter_middlename));
                        setTextToDialog(getString(R.string.dialog_txtname));
                        makeDialog();
                        break;
                    case 3:
                        Toast.makeText(getApplicationContext(),
                                R.string.toast_addM,
                                Toast.LENGTH_SHORT)
                                .show();
                        setDialogTtl(getString(R.string.inter_position));
                        setTextToDialog(getString(R.string.dialog_txtname));
                        makeDialog();
                        break;
                    case 4:
                        Toast.makeText(getApplicationContext(),
                                R.string.toast_addM,
                                Toast.LENGTH_SHORT)
                                .show();
                        setDialogTtl(getString(R.string.inter_phonenumber));
                        setTextToDialog(getString(R.string.dialog_txtphone));
                        makeDialog();
                        break;
                }
            return false;}
        }
        return  true;
    }

    public void setDataNewMember(String lnn, String fnn, String mnn, @NonNull String pnn, String phnn){
        AddMember.lnn = lnn;
        AddMember.fnn = fnn;
        AddMember.mnn = mnn;
        AddMember.pnn = pnn;
        AddMember.phnn = phnn;
        readyToAdd.set(0, checkEmpty(lnn));
        readyToAdd.set(1, checkEmpty(fnn));
        readyToAdd.set(2, checkEmpty(mnn));
        readyToAdd.set(3, !pnn.isEmpty());
        readyToAdd.set(4, checkPhone(phnn));
        setResolution(checkFlags(readyToAdd));
        if (!getResolution()) this.onRestart();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater Inflater = getMenuInflater();
        Inflater.inflate(R.menu.edit_menu, menu);
        return true;
    }
        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        public boolean onOptionsItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case android.R.id.home:
                    this.finish();
                    return true;
                case R.id.check_mark:
                    setDataNewMember(lastNameNew.getText().toString(),
                            firstNameNew.getText().toString(),
                            middleNameNew.getText().toString(),
                            positionNameNew.getText().toString(),
                            phoneNameNew.getText().toString());
                    if (!getResolution()) this.onRestart();
                    else {
                        Contacts contactsNew = new Contacts(getLastID() + 1,
                                getDepId(),
                                lastNameNew.getText().toString(),
                                firstNameNew.getText().toString(),
                                middleNameNew.getText().toString(),
                                positionNameNew.getText().toString(),
                                phoneNameNew.getText().toString());
                        setLastID(getLastID() + 1);
                        departDataBase.contactsDao().insert(contactsNew);
                        lstContact = departDataBase.departmentDao().getContactsList(getDepId());
                        Toast.makeText(getApplicationContext(),
                                R.string.toast_addM2,
                                Toast.LENGTH_SHORT)
                                .show();
                        FragmentContact.recycleViewAdapter.setmData(lstContact);
                        finish();
                    }
                    return true;
                default: {
                    return super.onOptionsItemSelected(item);
                }
            }
        }
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_member);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        setFalse(readyToAdd, getResources().getInteger(R.integer.length_editor));
        lastNameNew = findViewById(R.id.last_name);
        firstNameNew = findViewById(R.id.first_name);
        middleNameNew = findViewById(R.id.middle_name);
        phoneNameNew = findViewById(R.id.phone_number);
        positionNameNew = findViewById(R.id.position_name);
        inputNumberPhoneMask(phoneNameNew);
    }
}
