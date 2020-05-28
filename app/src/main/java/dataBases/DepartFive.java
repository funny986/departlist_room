package dataBases;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class DepartFive {
    @PrimaryKey
    public int id;
    @ColumnInfo(name = "last_name")
    public String lastName;
    @ColumnInfo(name = "first_name")
    public String firstName;
    @ColumnInfo(name = "middle_name")
    public String middleName;
    @ColumnInfo(name = "position_name")
    public String positionName;
    @ColumnInfo(name = "phone")
    public String phone;

    public DepartFive(int id, String lastName, String firstName, String middleName, String positionName, String phone){
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.positionName = positionName;
        this.phone = phone;
    }

}
