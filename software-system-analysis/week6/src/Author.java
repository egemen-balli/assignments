//Egemen Balli 15 Mar 2023
public class Author {
    private String name;
    private String email;
    private String biography;

    public Author(String name, String email, String biography) {
        this.name = name;
        this.email = email;
        this.biography = biography;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getBiography() {
        return biography;
    }

    @Override
    public String toString() {
        return name + '\'' + email + '\'' + biography;
    }
}
