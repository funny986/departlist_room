package utils;

public class Contact {

    private String LastName;
    private String FirstName;
    private String MiddleName;
    private String Position;
    private String Phone;
    private int Id;

    //    private int Photo;
    private int DepartId;



    public Contact(String lastName, String firstName, String middleName, String position, String phone, int id) {
        LastName = lastName;
        FirstName = firstName;
        MiddleName = middleName;
        Position = position;
        Phone = phone;
        Id = id;

//        Photo = photo;
//        DepartId = depaertId;
    }
    public String getPhone() {
        return Phone;
    }

//    public int getDepaertId() {
//        return DepartId;
//    }
//
//    public int getPhoto() {
//        return Photo;
//    }

    public int getIdName() {
        return Id;
    }


    public String getLastName() {
        return LastName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getMiddleName() {
        return MiddleName;
    }

    public String getPosition() {
        return Position;
    }
}
