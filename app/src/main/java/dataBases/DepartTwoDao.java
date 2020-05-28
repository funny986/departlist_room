package dataBases;

import androidx.room.*;

import java.util.List;

@Dao
public interface DepartTwoDao {

    @Query("select * from departtwo")
    List<DepartTwo> getAll();

    @Query("SELECT * FROM departtwo WHERE id = :id")
    DepartTwo getById(int id);

    @Query("SELECT * FROM departtwo WHERE last_name = :lastName")
    DepartTwo getLastName(String lastName);

    @Query("SELECT * FROM departtwo WHERE first_name = :firstName")
    DepartTwo getFirstName(String firstName);

    @Query("SELECT * FROM departtwo WHERE middle_name = :middleName")
    DepartTwo getMiddleName(String middleName);

    @Query("SELECT * FROM departtwo WHERE position_name = :positionName")
    DepartTwo getPositionName(String positionName);

    @Query("SELECT * FROM departtwo WHERE phone = :phone")
    DepartTwo getPhone(String phone);

    @Insert
    void insert(DepartTwo departtwo);

    @Update
    void update(DepartTwo departtwo);

    @Delete
    void delete(DepartTwo departtwo);
}

