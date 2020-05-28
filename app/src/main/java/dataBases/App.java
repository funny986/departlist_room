package dataBases;

import android.app.Application;
import androidx.room.Room;

public class App extends Application {

    public static App instanse;

    private DepartDataBase dataBase;

    @Override
    public void onCreate() {
        super.onCreate();
        instanse = this;
        dataBase = Room.databaseBuilder(this, DepartDataBase.class, "database")
                .allowMainThreadQueries()
                .build();
    }
    public static App getInstance(){
        return instanse;
    }
    public DepartDataBase getDataBase(){
        return dataBase;
    }
}
