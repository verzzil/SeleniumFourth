package ru.itis.selenium.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import ru.itis.selenium.ApplicationManager;
import ru.itis.selenium.json.model.EditProfileData;
import ru.itis.selenium.json.model.LoginData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Type;

public class JSONParser {
    private final Gson gson = new Gson();

    public LoginData parseLoginJson() {
        try (BufferedReader br = new BufferedReader(new FileReader(ApplicationManager.LOGIN_DATA_PATH))) {
            Type type = new TypeToken<LoginData>(){}.getType();
            return gson.fromJson(br, type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new LoginData();
    }

    public EditProfileData parseEditProfileJson() {
        try (BufferedReader br = new BufferedReader(new FileReader(ApplicationManager.EDIT_PROFILE_DATA_PATH))) {
            Type type = new TypeToken<EditProfileData>(){}.getType();
            return gson.fromJson(br, type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new EditProfileData();
    }
}
