package dataBases;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {DepartOne.class, DepartTwo.class, DepartThree.class,
                    DepartFour.class, DepartFive.class}, version = 1)

public abstract class DepartDataBase extends RoomDatabase {
    public abstract DepartOneDao departOneDao();
    public abstract DepartTwoDao departTwoDao();
    public abstract DepartThreeDao departThreeDao();
    public abstract DepartFourDao departFourDao();
    public abstract DepartFiveDao departFiveDao();

}
