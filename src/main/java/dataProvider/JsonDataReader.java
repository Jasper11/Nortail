package dataProvider;

import com.google.gson.Gson;
import testDataTypes.LoginTestData;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class JsonDataReader {
    private final List<LoginTestData> loginTestDataList;

    public JsonDataReader() throws IOException {
        loginTestDataList = getLoginData();
    }

    private List<LoginTestData> getLoginData() throws IOException {
        String loginDataFilePath = "src/test/resources/testData/loginData.json";
        Gson gson = new Gson();
        try (BufferedReader bufferReader = new BufferedReader(new FileReader(loginDataFilePath))) {
            LoginTestData[] loginTestData = gson.fromJson(bufferReader, LoginTestData[].class);
            return Arrays.asList(loginTestData);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Json file not found at path : " + loginDataFilePath);
        }
    }

    public final LoginTestData getTestDataSetSetByName(String name) {
        return loginTestDataList.stream().filter(x -> x.testDataSetName.equalsIgnoreCase(name)).findAny().get();
    }


}
