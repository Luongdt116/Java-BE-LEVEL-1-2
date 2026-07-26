public class Student {
    private String id;
    private String name;
    private int age;
    private String address;
    private String gender;
    private String email;

    public Student(){
    }

    public Student(String id, String name, int age, String address, String gender, String email){
        this.id = id;
        this.name =name;
        this.age = age;
        this.address = address;
        this.gender = gender;
        this.email=email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("ID: %s | Name: %s | Age: %d | Gender: %s | Address: %s | Email: %s",
                id, name, age, gender, address, email);
    }

}
