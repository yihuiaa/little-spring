/**
 * ● @author: YiHui
 * ● @date: Created in 18:08  2023/2/20
 */
public class UserService {
    private String username;
    public UserService(String username) {
        this.username = username;
    }

    public String save() {
        System.out.println("save_success");
        return "save_success";
    }
}
