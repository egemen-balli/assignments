//Egemen Balli 15 Mar 2023
public class Publisher {
    private String Name;
    private String Address;
    private String Email;

    public Publisher(String name, String email, String address) {
        Name = name;
        Address = address;
        Email = email;
    }

    public String getName() {
        return Name;
    }

    public String getAddress() {
        return Address;
    }

    public String getEmail() {
        return Email;
    }

    @Override
    public String toString() {
        return Name + '\'' + Email + '\'' + Address;
    }
}
