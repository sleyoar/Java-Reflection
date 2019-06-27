package reflect20190627.work2.dao;

public class User {
    private int id;
    private String name;
    public User() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
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
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
