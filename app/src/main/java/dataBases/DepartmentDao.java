package dataBases;

import androidx.room.*;
import java.util.List;

@Dao
public interface DepartmentDao {

    @Query("SELECT * FROM contacts WHERE department_id = :departmentID ORDER BY last_name")
    List<Contacts> getContactsList(int departmentID);

    @Query("SELECT * FROM contacts WHERE name = :name ORDER BY last_name")
    List<Contacts> getContactsListName(String name);


    @Query("SELECT * FROM department WHERE name = :name")
    Department getDepartmentName(String name);

    @Query("SELECT * FROM department WHERE id = :id")
    Department getDepartmentId(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Department department);

    @Update
    void update(Department department);

    @Delete
     void delete(Department department);
}
