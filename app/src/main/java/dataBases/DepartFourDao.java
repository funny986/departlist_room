package dataBases;

import androidx.room.*;

import java.util.List;

@Dao
public interface DepartFourDao {

    @Query("select * from departfour")
    List<DepartFour> getAll();

    @Query("SELECT * FROM departfour WHERE id = :id")
    DepartFour getById(int id);

    @Query("SELECT * FROM departfour WHERE last_name = :lastName")
    DepartFour getLastName(String lastName);

    @Query("SELECT * FROM departfour WHERE first_name = :firstName")
    DepartFour getFirstName(String firstName);

    @Query("SELECT * FROM departfour WHERE middle_name = :middleName")
    DepartFour getMiddleName(String middleName);

    @Query("SELECT * FROM departfour WHERE position_name = :positionName")
    DepartFour getPositionName(String positionName);

    @Query("SELECT * FROM departfour WHERE phone = :phone")
    DepartFour getPhone(String phone);

    @Insert
    void insert(DepartFour departfour);

    @Update
    void update(DepartFour departfour);

    @Delete
    void delete(DepartFour departfour);
}

