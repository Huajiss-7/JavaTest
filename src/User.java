import java.util.StringJoiner;

public class User implements Cloneable{
    private int id;
    private String username;
    private String password;
    private String path;
    private int[]data;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "角色编号:"+id+" 用户名:"+username+" 密码:"+password+" 图片路径:"+path+" 进度:"+arrToString();
    }

    public String arrToString(){
        StringJoiner sj=new StringJoiner(",","[","]");
        for (int i = 0; i < data.length; i++) {
            sj.add(data[i]+"");
        }
        return sj.toString();
    }

    public User() {
    }

    public User(int id, String username, String password, String path, int[] data) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.path = path;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPath() {
        return path;
    }

    public int[] getData() {
        return data;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setData(int[] data) {
        this.data = data;
    }
}
