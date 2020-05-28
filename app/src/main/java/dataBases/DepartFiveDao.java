package dataBases;

import androidx.room.*;

import java.util.List;

@Dao
public interface DepartFiveDao {

    @Query("select * from departfive")
    List<DepartFive> getAll();

    @Query("SELECT * FROM departfive WHERE id = :id")
    DepartFive getById(int id);

    @Query("SELECT * FROM departfive WHERE last_name = :lastName")
    DepartFive getLastName(String lastName);

    @Query("SELECT * FROM departfive WHERE first_name = :firstName")
    DepartFive getFirstName(String firstName);

    @Query("SELECT * FROM departfive WHERE middle_name = :middleName")
    DepartFive getMiddleName(String middleName);

    @Query("SELECT * FROM departfive WHERE position_name = :positionName")
    DepartFive getPositionName(String positionName);

    @Query("SELECT * FROM departfive WHERE phone = :phone")
    DepartFive getPhone(String phone);

    @Insert
    void insert(DepartFive departfive);

    @Update
    void update(DepartFive departfive);

    @Delete
    void delete(DepartFive departfive);
}

