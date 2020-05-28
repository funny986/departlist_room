package dataBases;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "department")
public class Department {

    public Department(int id, String name){
        this.id = id;
        this.name = name;
    }

    @PrimaryKey
    @ColumnInfo(name = "id")
    int id;

    @ColumnInfo(name = "name")
    String name;

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

}
