package utils;

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

    public static void setDataContactList(@NonNull DepartDataBase dataBase){


        dataBase.departOneDao().insert(new DepartOne(1, "Андреев", "Сергей", "Анатольевич",                "Главный механик", "9190105002"));
        dataBase.departOneDao().insert(new DepartOne(2, "Андропов", "Виктор", "Анатольевич",                "Главный механик", "9190105002"));
        dataBase.departOneDao().insert(new DepartOne(3, "Васильев", "Сергей", "Анатольевич",                "Главный механик", "9190105002"));
        dataBase.departOneDao().insert(new DepartOne(4, "Кондратьев", "Петр", "Анатольевич",                "departOneDao()аник", "9190105002"));
        dataBase.departOneDao().insert(new DepartOne(5, "Кондратьев", "Сергей", "Анатольевич",               "departOneDao()аник", "9190105002"));
        dataBase.departOneDao().insert(new DepartOne(6, "Бахтин", "Сергей", "Анатольевич",                "departOneDao()аник", "9190105002"));
        dataBase.departOneDao().insert(new DepartOne(7, "Совельев", "Иван", "Анатольевич",                "departOneDao()аник", "9190105002"));
        dataBase.departOneDao().insert(new DepartOne(8, "Прохоров", "Сергей", "Анатольевич",                "departOneDao()аник", "9190105002"));
        dataBase.departOneDao().insert(new DepartOne(10, "Прокапенко", "Сергей", "Анатольевич",                "departOneDao()аник", "9190105002"));
        dataBase.departOneDao().insert(new DepartOne(11, "Хватов", "Сергей", "Анатольевич",                "departOneDao()аник", "9190105002"));
        dataBase.departOneDao().insert(new DepartOne(12, "Уланов", "Сергей", "Анатольевич",                "departOneDao()аник", "9190105002"));
        dataBase.departOneDao().insert(new DepartOne(13, "Жаров", "Сергей", "Анатольевич",                "departOneDao()аник", "9190105002"));
        dataBase.departOneDao().insert(new DepartOne(14, "Смирнов", "Сергей", "Анатольевич",                "departOneDao()аник", "9190105002"));
        dataBase.departOneDao().insert(new DepartOne(15, "Тополев", "Анатолий", "Анатольевич",                "departOneDao()аник", "9190105002"));
        dataBase.departOneDao().insert(new DepartOne(16, "Донской", "Тимофей", "Анатольевич",                "departOneDao()аник", "9190105002"));
        dataBase.departOneDao().insert(new DepartOne(17, "Егоров", "Савелий", "Анатольевич",                "departOneDao()аник", "9190105002"));
        dataBase.departOneDao().insert(new DepartOne(18, "Трофимов", "Сергей", "Анатольевич",                "departOneDao()аник", "9190105002"));
        dataBase.departOneDao().insert(new DepartOne(19, "Федоров", "Юрий", "Анатольевич",                "departOneDao()аник", "9190105002"));
        dataBase.departOneDao().insert(new DepartOne(20, "Петров", "Петр", "Анатольевич",                "departOneDao()аник", "9190105002"));
        dataBase.departOneDao().insert(new DepartOne(21, "Иванов", "Иван", "Анатольевич",                "departOneDao()аник", "9190105002"));
        dataBase.departOneDao().insert(new DepartOne(22, "Зиновьев", "Сергей", "Анатольевич",                "departOneDao()аник", "9190105002"));
        dataBase.departOneDao().insert(new DepartOne(23, "Игнатьев", "Сергей", "Анатольевич",                "departOneDao()аник", "9190105002"));
        dataBase.departOneDao().insert(new DepartOne(24, "Илюшин", "Константин", "Анатольевич",                "departOneDao()аник", "9190105002"));
        dataBase.departOneDao().insert(new DepartOne(25, "Леонтьев", "Сергей", "Анатольевич",                "departOneDao()аник", "9190105002"));
        dataBase.departOneDao().insert(new DepartOne(26, "Ломов", "Сергей", "Анатольевич",                "departOneDao()аник", "9190105002"));
        dataBase.departOneDao().insert(new DepartOne(27, "Митяев", "Сергей", "Анатольевич",                "departOneDao()аник", "9190105002"));
        dataBase.departOneDao().insert(new DepartOne(28, "Николаве", "Василий", "Анатольевич",                "departOneDao()аник", "9190105002"));
        dataBase.departOneDao().insert(new DepartOne(29, "Трошин", "Дмитрий", "Анатольевич",                "departOneDao()аник", "9190105002"));
        dataBase.departOneDao().insert(new DepartOne(30, "Харитонов", "Сергей", "Анатольевич",                "departOneDao()аник", "9190105002"));
        dataBase.departOneDao().insert(new DepartOne(31, "Цаплин", "Сергей", "Анатольевич",                "departOneDao()аник", "9190105002"));
        dataBase.departOneDao().insert(new DepartOne(32, "Яковлев", "Сергей", "Анатольевич",                "departOneDao()аник", "9190105002"));
        dataBase.departOneDao().insert(new DepartOne(33, "Яров", "Сергей", "Анатольевич",                "departOneDao()аник", "9190105002"));
        dataBase.departOneDao().insert(new DepartOne(34, "Чехов", "Сергей", "Анатольевич",                "departOneDao()аник", "9190105002"));
        dataBase.departOneDao().insert(new DepartOne(35, "Зиновьев", "Сергей", "Анатольевич",                "departOneDao()аник", "9190105002"));
        dataBase.departOneDao().insert(new DepartOne(36, "Тарасов", "Сергей", "Анатольевич",                "departOneDao()аник", "9190105002"));
        dataBase.departOneDao().insert(new DepartOne(37, "Михайлов", "Сергей", "Анатольевич",                "Главный механик", "9190105002"));

        dataBase.departTwoDao().insert(new DepartTwo(38, "Кротов", "Сергей", "Анатольевич",                "Главный механик", "9190105002"));
        dataBase.departTwoDao().insert(new DepartTwo(39, "Антонов", "Сергей", "Анатольевич",                "Главный механик", "9190105002"));
        dataBase.departTwoDao().insert(new DepartTwo(40, "Зайкин", "Сергей", "Анатольевич",                "Главный механик", "9190105002"));
        dataBase.departTwoDao().insert(new DepartTwo(41, "Дмитриев", "Сергей", "Анатольевич",                "Главный механик", "9190105002"));
        dataBase.departTwoDao().insert(new DepartTwo(42, "Хламов", "Сергей", "Анатольевич",                "Главный механик", "9190105002"));
        dataBase.departTwoDao().insert(new DepartTwo(43, "Фадеев", "Андрей", "Анатольевич",                "Главный механик", "9190105002"));
        dataBase.departTwoDao().insert(new DepartTwo(44, "Свалов", "Сергей", "Анатольевич",                "Главный механик", "9190105002"));
        dataBase.departTwoDao().insert(new DepartTwo(45, "Орефьев", "Сергей", "Анатольевич",                "Главный механик", "9190105002"));


        dataBase.departThreeDao().insert(new DepartThree(47, "Ломакин", "Сергей", "Анатольевич",                "Главный механик", "9190105002"));
        dataBase.departThreeDao().insert(new DepartThree(48, "Чаадаев", "Сергей", "Анатольевич",                "Главный механик", "9190105002"));
        dataBase.departThreeDao().insert(new DepartThree(49, "Юрьев", "Сергей", "Анатольевич",                "Главный механик", "9190105002"));
        dataBase.departThreeDao().insert(new DepartThree(50, "Бахтин", "Василий", "Анатольевич",                "Главный механик", "9190105002"));

    }
}//END MAIN CLASS
