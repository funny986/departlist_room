package dataBases;

import android.database.Cursor;
import androidx.room.*;
import utils.Contact;

import java.util.ArrayList;

@Dao
public interface ContactsDao {

//    @Query("SELECT * FROM contacts WHERE department_id = :departmentID")
//    ArrayList<Contact> getContactsList(int departmentID);

    @Query("SELECT * FROM contacts WHERE last_name = :lastName")
    Contacts getLastName(String lastName);

    @Query("SELECT * FROM contacts WHERE first_name = :firstName")
    Contacts getFirstName(String firstName);

    @Query("SELECT * FROM contacts WHERE middle_name = :middleName")
    Contacts getMiddleName(String middleName);

    @Query("SELECT * FROM contacts WHERE position_name = :positionName")
    Contacts getPositionName(String positionName);

    @Query("SELECT * FROM contacts WHERE phone = :phone")
    Contacts getPhone(String phone);

    @Insert
    void insert(Contacts contacts);

    @Update
    void update(Contacts contacts);

    @Delete
    void delete(Contacts contacts);

}
