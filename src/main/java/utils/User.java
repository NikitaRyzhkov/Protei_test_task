package utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Paths;

public class User {
    private String login;
    private String password;
    private String userDataPath = "src/main/java/utils/user.json";
    private User userFmJson() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.readValue(Paths.get(userDataPath).toFile(), User.class);
        return user;
    }
    public String getLogin() throws IOException{
        return userFmJson().login;
    }
    public String getPassword() throws IOException{
        return userFmJson().password;
    }
}

