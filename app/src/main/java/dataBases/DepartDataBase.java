package dataBases;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Department.class, Contacts.class}, version = 1)

public abstract class DepartDataBase extends RoomDatabase {
    public abstract DepartmentDao departmentDao();
    public abstract ContactsDao contactsDao();
}
