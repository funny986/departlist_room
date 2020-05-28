package dataBases;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "contacts", foreignKeys =
            @ForeignKey(
                    entity = Department.class,
                    childColumns = "department_id",
                    parentColumns = "id"
            ))

public class Contacts {

    public Contacts(int id, int departmentID, String lastName, String firstName, String middleName, String positionName,
                                            String phone){
        this.id = id;
        this.departmentID = departmentID;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.positionName = positionName;
        this.phone = phone;
    }

    @PrimaryKey
    @ColumnInfo(name = "id")
    int id;

    @ColumnInfo(name = "department_id")
    int departmentID;

    @ColumnInfo(name = "last_name")
    String lastName;

    @ColumnInfo(name = "first_name")
    String firstName;

    @ColumnInfo(name = "middle_name")
    String middleName;

    @ColumnInfo(name = "position_name")
    String positionName;

    @ColumnInfo(name = "phone")
    String phone;

}
