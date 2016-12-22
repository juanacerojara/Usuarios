package coursera.usuarios;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;

/**
 * Created by Juan on 19/12/2016.
 */

public class Person implements Parcelable {
    private String birthday;
    private String telephone;
    private String email;
    private String description;
    private String namePerson;

    public Person(String birthday, String telephone, String email, String description, String namePerson) {
        this.birthday = birthday;
        this.telephone = telephone;
        this.email = email;
        this.description = description;
        this.namePerson = namePerson;
    }

    /////Parcel OBJ
    public Person(Parcel source) {
        readFromParcel(source);
    }


    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }



    public String getNamePerson() {
        return namePerson;
    }

    public void setNamePerson(String namePerson) {
        this.namePerson = namePerson;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int describeContents() {
        return 0;
    }


    public static final Parcelable.Creator<Person> CREATOR = new Creator<Person>() {

        @Override
        public Person[] newArray(int size) {
            // TODO Auto-generated method stub
            return new Person[size];
        }

        @Override
        public Person createFromParcel(Parcel source) {
            // TODO Auto-generated method stub
            return new Person(source);
        }
    };
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(namePerson);
        parcel.writeString(birthday);
        parcel.writeString(telephone);
        parcel.writeString(email);
        parcel.writeString(description);
    }
    private void readFromParcel(Parcel in) {
        this.namePerson = in.readString();
        this.birthday   = in.readString();
        this.telephone  = in.readString();
        this.email      = in.readString();
        this.description = in.readString();
    }
}
