package dataProvider;

import com.google.gson.Gson;
import testDataTypes.UserCredentials;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class JsonDataReader {
    private final List<UserCredentials> userCredentialsList;

    public JsonDataReader() throws IOException {
        userCredentialsList = getUserCredentialsData();
    }

    private List<UserCredentials> getUserCredentialsData() throws IOException {
        String loginDataFilePath = "src/test/resources/loginData.json";
        Gson gson = new Gson();
        try (BufferedReader bufferReader = new BufferedReader(new FileReader(loginDataFilePath))) {
            UserCredentials[] userCredentialsData = gson.fromJson(bufferReader, UserCredentials[].class);
            return Arrays.asList(userCredentialsData);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Json file not found at path : " + loginDataFilePath);
        }
    }

    public final UserCredentials getCredentialsSetByName(String name){
        return userCredentialsList.stream().filter(x -> x.credentialsSetName.equalsIgnoreCase(name)).findAny().get();
    }


}
