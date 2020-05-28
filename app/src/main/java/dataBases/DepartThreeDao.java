package dataBases;

import androidx.room.*;

import java.util.List;

@Dao
public interface DepartThreeDao {

    @Query("select * from departthree")
    List<DepartThree> getAll();

    @Query("SELECT * FROM departthree WHERE id = :id")
    DepartThree getById(int id);

    @Query("SELECT * FROM departthree WHERE last_name = :lastName")
    DepartThree getLastName(String lastName);

    @Query("SELECT * FROM departthree WHERE first_name = :firstName")
    DepartThree getFirstName(String firstName);

    @Query("SELECT * FROM departthree WHERE middle_name = :middleName")
    DepartThree getMiddleName(String middleName);

    @Query("SELECT * FROM departthree WHERE position_name = :positionName")
    DepartThree getPositionName(String positionName);

    @Query("SELECT * FROM departthree WHERE phone = :phone")
    DepartThree getPhone(String phone);

    @Insert
    void insert(DepartThree departthree);

    @Update
    void update(DepartThree departthree);

    @Delete
    void delete(DepartThree departthree);
}

