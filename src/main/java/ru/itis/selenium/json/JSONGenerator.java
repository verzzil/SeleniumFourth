package ru.itis.selenium.json;

import com.google.gson.Gson;
import ru.itis.selenium.ApplicationManager;
import ru.itis.selenium.json.model.EditProfileData;
import ru.itis.selenium.json.model.LoginData;

import java.io.FileWriter;
import java.io.IOException;

public class JSONGenerator {
    private final Gson gson = new Gson();

    public void generateLoginData(LoginData data) {
        try (FileWriter writer = new FileWriter(ApplicationManager.LOGIN_DATA_PATH, false)) {
            writer.write(gson.toJson(data));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void generateEditProfileData(EditProfileData data) {
        try (FileWriter writer = new FileWriter(ApplicationManager.EDIT_PROFILE_DATA_PATH, false)) {
            writer.write(gson.toJson(data));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
