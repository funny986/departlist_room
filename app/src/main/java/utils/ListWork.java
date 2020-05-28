package utils;

import android.content.res.Resources;
import com.departlistv3.R;
import dataBases.*;
import android.widget.TextView;
import androidx.annotation.NonNull;
import ru.tinkoff.decoro.MaskImpl;
import ru.tinkoff.decoro.slots.PredefinedSlots;
import ru.tinkoff.decoro.watchers.FormatWatcher;
import ru.tinkoff.decoro.watchers.MaskFormatWatcher;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class ListWork {
    public static boolean resolution = false;
    public  static String dialogTtl = "", textToDialog="";


    public static boolean getResolution(){
        return resolution;
    }

    public static void setResolution(boolean resolutiontemp){resolution = resolutiontemp;}

    public static String getDialogTtl(){
        return dialogTtl;
    }

    public static void setDialogTtl(String dialogTtlIn){
        dialogTtl = dialogTtlIn;
    }

    public static void setTextToDialog(String text){
        String string = "\n" + text;
        textToDialog = string;}

    public static String getTextToDialog() {return textToDialog;}

    public static ArrayList<Boolean> setFalse(@NonNull ArrayList<Boolean> array, int length){
        if (array.isEmpty()) {
            for (int i = 0; i < length; i++) array.add(i, false);
        }else
        while (length != 0) {
            length--;
           array.set(length, false);
       }
        return array;
    }

    public static boolean checkEmpty(@NonNull String che){
       if (che.isEmpty() || che.contains(" ")) return false;
       else {
           char[] cir = che.toCharArray();
           for (char c : cir){
               if (Character.isDigit(c)) return false;
           }
            return che.length() == che.replaceAll("[a-zA-Z]", "").length();
        }
    }
    private static final Pattern checkPhones = Pattern.compile("^\\+\\d\\s\\(\\d{3}\\)\\s\\d{3}-\\d{2}-\\d{2}$");

    public static boolean checkPhone(String phone){
        return checkPhones.matcher(phone).find();
    }

    public static void inputNumberPhoneMask(TextView textView){
        MaskImpl mask = MaskImpl.createTerminated(PredefinedSlots.RUS_PHONE_NUMBER);
        mask.setForbidInputWhenFilled(false); // default value
        FormatWatcher formatWatcher = new MaskFormatWatcher(mask);
        formatWatcher.installOn(textView);
    }

    public static void setDataContactList(@NonNull DepartDataBase dataBase, String[] list){

        Department department1 = new Department(1, list[0]);
        Department department2 = new Department(2, list[1]);
        Department department3 = new Department(3, list[2]);
        Department department4 = new Department(4, list[3]);
        Department department5 = new Department(5, list[4]);



        dataBase.departmentDao().insert(department1);
        dataBase.departmentDao().insert(department2);
        dataBase.departmentDao().insert(department3);
        dataBase.departmentDao().insert(department4);
        dataBase.departmentDao().insert(department5);

        Contacts contacts01 = new Contacts(1,department1.getId(), "Андреев", "Сергей", "Анатольевич",                "Главный механик", "9190105002"));
        Contacts contacts02 = new Contacts(2, department1.getId(), "Андропов", "Виктор", "Анатольевич",                "Главный механик", "9190105002"));
        Contacts contacts03 = new Contacts(3, department1.getId(), "Васильев", "Сергей", "Анатольевич",                "Главный механик", "9190105002"));
        Contacts contacts04 = new Contacts(4, department1.getId(), "Кондратьев", "Петр", "Анатольевич",                "departOneDao()аник", "9190105002"));
        Contacts contacts05 = new Contacts(5, department1.getId(), "Кондратьев", "Сергей", "Анатольевич",               "departOneDao()аник", "9190105002"));
        Contacts contacts06 = new Contacts(6, department1.getId(), "Бахтин", "Сергей", "Анатольевич",                "departOneDao()аник", "9190105002"));
        Contacts contacts07 = new Contacts(7, department1.getId(), "Совельев", "Иван", "Анатольевич",                "departOneDao()аник", "9190105002"));
        Contacts contacts08 = new Contacts(8,department1.getId(), "Прохоров", "Сергей", "Анатольевич",                "departOneDao()аник", "9190105002"));
        Contacts contacts09 = new Contacts(9, department1.getId(), "Прокапенко", "Сергей", "Анатольевич",                "departOneDao()аник", "9190105002"))
        Contacts contacts10 = new Contacts(10, department1.getId(), "Хватов", "Сергей", "Анатольевич",                "departOneDao()аник", "9190105002"));
        Contacts contacts11 = new Contacts(11, department1.getId(), "Уланов", "Сергей", "Анатольевич",                "departOneDao()аник", "9190105002"));
        Contacts contacts12 = new Contacts(12, department1.getId(), "Жаров", "Сергей", "Анатольевич",                "departOneDao()аник", "9190105002"));
        Contacts contacts13 = new Contacts(13, department1.getId(), "Смирнов", "Сергей", "Анатольевич",                "departOneDao()аник", "9190105002"));
        Contacts contacts14 = new Contacts(14, department1.getId(), "Тополев", "Анатолий", "Анатольевич",                "departOneDao()аник", "9190105002"));
        Contacts contacts15 = new Contacts(15, department1.getId(), "Донской", "Тимофей", "Анатольевич",                "departOneDao()аник", "9190105002"));
        Contacts contacts16 = new Contacts(16, department1.getId(), "Егоров", "Савелий", "Анатольевич",                "departOneDao()аник", "9190105002"));
        Contacts contacts17 = new Contacts(17, department1.getId(), "Трофимов", "Сергей", "Анатольевич",                "departOneDao()аник", "9190105002"));
        Contacts contacts18 = new Contacts(18, department1.getId(), "Федоров", "Юрий", "Анатольевич",                "departOneDao()аник", "9190105002"));
        Contacts contacts19 = new Contacts(19, department1.getId(), "Петров", "Петр", "Анатольевич",                "departOneDao()аник", "9190105002"));
        Contacts contacts20 = new Contacts(20, department1.getId(), "Иванов", "Иван", "Анатольевич",                "departOneDao()аник", "9190105002"));
        Contacts contacts21 = new Contacts(21, department1.getId(), "Зиновьев", "Сергей", "Анатольевич",                "departOneDao()аник", "9190105002"));
        Contacts contacts22 = new Contacts(22, department1.getId(), "Игнатьев", "Сергей", "Анатольевич",                "departOneDao()аник", "9190105002"));
        Contacts contacts23 = new Contacts(23, department1.getId(), "Илюшин", "Константин", "Анатольевич",                "departOneDao()аник", "9190105002"))
        Contacts contacts24 = new Contacts(24, department1.getId(), "Леонтьев", "Сергей", "Анатольевич",                "departOneDao()аник", "9190105002"));
        Contacts contacts25 = new Contacts(25, department1.getId(), "Ломов", "Сергей", "Анатольевич",                "departOneDao()аник", "9190105002"));
        Contacts contacts26 = new Contacts(26, department1.getId(), "Митяев", "Сергей", "Анатольевич",                "departOneDao()аник", "9190105002"));
        Contacts contacts27 = new Contacts(27, department1.getId(), "Николаве", "Василий", "Анатольевич",                "departOneDao()аник", "9190105002"));
        Contacts contacts28 = new Contacts(28, department1.getId(), "Трошин", "Дмитрий", "Анатольевич",                "departOneDao()аник", "9190105002"));
        Contacts contacts29 = new Contacts(29, department1.getId(), "Харитонов", "Сергей", "Анатольевич",                "departOneDao()аник", "9190105002"));
        Contacts contacts30 = new Contacts(30, department2.getId(), "Цаплин", "Сергей", "Анатольевич",                "departOneDao()аник", "9190105002"));
        Contacts contacts31 = new Contacts(31, department2.getId(), "Яковлев", "Сергей", "Анатольевич",                "departOneDao()аник", "9190105002"));
        Contacts contacts32 = new Contacts(32, department2.getId(), "Яров", "Сергей", "Анатольевич",                "departOneDao()аник", "9190105002"));
        Contacts contacts33 = new Contacts(33, department2.getId(), "Чехов", "Сергей", "Анатольевич",                "departOneDao()аник", "9190105002"));
        Contacts contacts34 = new Contacts(34, department2.getId(), "Зиновьев", "Сергей", "Анатольевич",                "departOneDao()аник", "9190105002"));
        Contacts contacts35 = new Contacts(35, department2.getId(), "Тарасов", "Сергей", "Анатольевич",                "departOneDao()аник", "9190105002"));
        Contacts contacts36 = new Contacts(36, department2.getId(), "Михайлов", "Сергей", "Анатольевич",                "Главный механик", "9190105002"));
        Contacts contacts37 = new Contacts(37, department2.getId(), "Кротов", "Сергей", "Анатольевич",                "Главный механик", "9190105002"));
        Contacts contacts38 = new Contacts(38, department2.getId(), "Антонов", "Сергей", "Анатольевич",                "Главный механик", "9190105002"));
        Contacts contacts39 = new Contacts(39, department2.getId(), "Зайкин", "Сергей", "Анатольевич",                "Главный механик", "9190105002"));
        Contacts contacts40 = new Contacts(40, department2.getId(), "Дмитриев", "Сергей", "Анатольевич",                "Главный механик", "9190105002"));
        Contacts contacts41 = new Contacts(41, department2.getId(), "Хламов", "Сергей", "Анатольевич",                "Главный механик", "9190105002"));
        Contacts contacts42 = new Contacts(42, department2.getId(), "Фадеев", "Андрей", "Анатольевич",                "Главный механик", "9190105002"));
        Contacts contacts43 = new Contacts(43, department2.getId(), "Свалов", "Сергей", "Анатольевич",                "Главный механик", "9190105002"));
        Contacts contacts44 = new Contacts(44, department2.getId(), "Орефьев", "Сергей", "Анатольевич",                "Главный механик", "9190105002"));
        Contacts contacts45 = new Contacts(45, department3.getId(), "Ломакин", "Сергей", "Анатольевич",                "Главный механик", "9190105002"));
        Contacts contacts46 = new Contacts(46, department3.getId(), "Чаадаев", "Сергей", "Анатольевич",                "Главный механик", "9190105002"));
        Contacts contacts47 = new Contacts(47, department3.getId(), "Юрьев", "Сергей", "Анатольевич",                "Главный механик", "9190105002"));
        Contacts contacts48 = new Contacts(48, department3.getId(), "Бахтин", "Василий", "Анатольевич",                "Главный механик", "9190105002"));

        dataBase.contactsDao().insert(contacts01);
        dataBase.contactsDao().insert(contacts02);
        dataBase.contactsDao().insert(contacts03);
        dataBase.contactsDao().insert(contacts04);
        dataBase.contactsDao().insert(contacts05);
        dataBase.contactsDao().insert(contacts06);
        dataBase.contactsDao().insert(contacts07);
        dataBase.contactsDao().insert(contacts08);
        dataBase.contactsDao().insert(contacts09);
        dataBase.contactsDao().insert(contacts10);

        dataBase.contactsDao().insert(contacts11);
        dataBase.contactsDao().insert(contacts13);
        dataBase.contactsDao().insert(contacts12);
        dataBase.contactsDao().insert(contacts14);
        dataBase.contactsDao().insert(contacts15);
        dataBase.contactsDao().insert(contacts16);
        dataBase.contactsDao().insert(contacts17);
        dataBase.contactsDao().insert(contacts18);
        dataBase.contactsDao().insert(contacts19);
        dataBase.contactsDao().insert(contacts20);

        dataBase.contactsDao().insert(contacts21);
        dataBase.contactsDao().insert(contacts22);
        dataBase.contactsDao().insert(contacts23);
        dataBase.contactsDao().insert(contacts24);
        dataBase.contactsDao().insert(contacts25);
        dataBase.contactsDao().insert(contacts26);
        dataBase.contactsDao().insert(contacts27);
        dataBase.contactsDao().insert(contacts28);
        dataBase.contactsDao().insert(contacts29);
        dataBase.contactsDao().insert(contacts30);

        dataBase.contactsDao().insert(contacts31);
        dataBase.contactsDao().insert(contacts32);
        dataBase.contactsDao().insert(contacts33);
        dataBase.contactsDao().insert(contacts34);
        dataBase.contactsDao().insert(contacts35);
        dataBase.contactsDao().insert(contacts36);
        dataBase.contactsDao().insert(contacts37);
        dataBase.contactsDao().insert(contacts38);
        dataBase.contactsDao().insert(contacts39);
        dataBase.contactsDao().insert(contacts40);

        dataBase.contactsDao().insert(contacts41);
        dataBase.contactsDao().insert(contacts42);
        dataBase.contactsDao().insert(contacts43);
        dataBase.contactsDao().insert(contacts44);
        dataBase.contactsDao().insert(contacts45);
        dataBase.contactsDao().insert(contacts46);
        dataBase.contactsDao().insert(contacts47);
        dataBase.contactsDao().insert(contacts48);

    }
}//END MAIN CLASS
