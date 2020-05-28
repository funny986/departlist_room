package dataBases;

import androidx.room.*;
import utils.Contact;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface DepartmentDao {

    @Query("SELECT * FROM contacts WHERE department_id = :departmentID")
    public ArrayList<Contact> getContactsList(int departmentID);

    @Query("SELECT * FROM department WHERE name = :name")
    Department getDepartmentName(String name);

    @Query("SELECT * FROM department WHERE id = :id")
    Department getDepartmentId(int id);

    @Insert
    void insert(Department department);

    @Update
    void update(Department department);

    @Delete
    void delete(Department department);
}
