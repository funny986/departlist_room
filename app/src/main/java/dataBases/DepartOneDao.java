package dataBases;

import androidx.room.*;

import java.util.List;

@Dao
public interface DepartOneDao {

    @Query("select * from departone")
    List<DepartOne> getAll();

    @Query("SELECT * FROM departone WHERE id = :id")
    DepartOne getById(int id);

    @Query("SELECT * FROM departone WHERE last_name = :lastName")
    DepartOne getLastName(String lastName);

    @Query("SELECT * FROM departone WHERE first_name = :firstName")
    DepartOne getFirstName(String firstName);

    @Query("SELECT * FROM departone WHERE middle_name = :middleName")
    DepartOne getMiddleName(String middleName);

    @Query("SELECT * FROM departone WHERE position_name = :positionName")
    DepartOne getPositionName(String positionName);

    @Query("SELECT * FROM departone WHERE phone = :phone")
    DepartOne getPhone(String phone);

    @Insert
    void insert(DepartOne departone);

    @Update
    void update(DepartOne departone);

    @Delete
    void delete(DepartOne departone);
}

