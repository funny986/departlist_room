package com.departlistv3;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

import dataBases.Contacts;
import utils.DialogEditMember;

import static com.departlistv3.MainActivity.depName;
import static com.departlistv3.MainActivity.departDataBase;
import static utils.ListWork.*;

public class EditMember extends AddMember implements DialogEditMember.NoticeDialogListener {

    private  EditText firstNameEdit, lastNameEdit, positionNameEdit,
                            middleNameEdit, phoneNameEdit;
    private Intent intent = new Intent();
    private int editId;


    public void setEditId(int editId) {
        this.editId = editId;
    }

    @Override
    public void onDialogPositiveClick(DialogFragment dialog, @NonNull Contacts contact) {
        lastNameEdit.setText(contact.getLastName());
        firstNameEdit.setText(contact.getFirstName());
        middleNameEdit.setText(contact.getMiddleName());
        positionNameEdit.setText(contact.getPositionName());
        phoneNameEdit.setText(contact.getPhone());
        setEditId(contact.getId());
    }
    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {
        this.finish();
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            case R.id.check_mark:
                setDataNewMember(lastNameEdit.getText().toString(),
                        firstNameEdit.getText().toString(),
                        middleNameEdit.getText().toString(),
                        positionNameEdit.getText().toString(),
                        phoneNameEdit.getText().toString());
                if (!getResolution()) this.onRestart();
                else {
                    Contacts contactsEdit = new Contacts(
                            getIntent().getIntExtra("contantId", 1000),
                            getIntent().getIntExtra("departmentId", 0),
                            lastNameEdit.getText().toString(),
                            firstNameEdit.getText().toString(),
                            middleNameEdit.getText().toString(),
                            positionNameEdit.getText().toString(),
                            phoneNameEdit.getText().toString());
                    departDataBase.contactsDao().update(contactsEdit);
                    Toast.makeText(getApplicationContext(),
                            R.string.toast_editM,
                            Toast.LENGTH_SHORT)
                            .show();
                    finish();
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_member);
        lastNameEdit = findViewById(R.id.last_name);
        firstNameEdit = findViewById(R.id.first_name);
        middleNameEdit = findViewById(R.id.middle_name);
        phoneNameEdit = findViewById(R.id.phone_number);
        inputNumberPhoneMask(phoneNameEdit);
        positionNameEdit = findViewById(R.id.position_name);

        boolean con = getIntent().getBooleanExtra("contex", false);
        setEditId(getIntent().getIntExtra("id", 0));

        if (!con) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            DialogEditMember dialogEditMember = new DialogEditMember();
            dialogEditMember.setCancelable(false);
            dialogEditMember.show(fragmentManager, "Edit");
        }
        else {
            lastNameEdit.setText(getIntent().getStringExtra("lastname"));
            firstNameEdit.setText(getIntent().getStringExtra("firstname"));
            middleNameEdit.setText(getIntent().getStringExtra("middlename"));
            positionNameEdit.setText(getIntent().getStringExtra("position"));
            phoneNameEdit.setText(getIntent().getStringExtra("phone"));
        }
    }
}
