package com.example.demo.util;

import com.example.demo.domain.Gender;
import com.example.demo.domain.MongoUser;
import com.example.demo.domain.MySqlUser;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Component
public class DataLoader {

    private final String fileUrl = "src/main/resources/MOCK_DATA.csv";

    public List<MySqlUser> readMySqlUsers() throws IOException {
        CSVParser csvParser = CSVParser.parse(Paths.get(fileUrl), Charset.defaultCharset(),
                CSVFormat.DEFAULT.withHeader("first_name", "last_name", "email", "gender", "ip_address"));

        Stream<CSVRecord> csvRecordStream = StreamSupport.stream(csvParser.spliterator(), false);

        return csvRecordStream
                .skip(1)
                .map(CSVRecord::toMap)
                .map(element -> {
                    MySqlUser user = new MySqlUser();
                    user.setFirstName(element.get("first_name"));
                    user.setLastName(element.get("last_name"));
                    user.setEmail(element.get("email"));
                    user.setGender(Gender.valueOf(element.get("gender")));
                    user.setIpAddress(element.get("ip_address"));
                    return user;
                }).collect(Collectors.toList());
    }

    public List<MongoUser> readMongoUsers() throws IOException {
        CSVParser csvParser = CSVParser.parse(Paths.get(fileUrl), Charset.defaultCharset(),
                CSVFormat.DEFAULT.withHeader("first_name", "last_name", "email", "gender", "ip_address"));

        Stream<CSVRecord> csvRecordStream = StreamSupport.stream(csvParser.spliterator(), false);

        return csvRecordStream
                .skip(1)
                .map(CSVRecord::toMap)
                .map(element -> {
                    MongoUser user = new MongoUser();
                    user.setFirstName(element.get("first_name"));
                    user.setLastName(element.get("last_name"));
                    user.setEmail(element.get("email"));
                    user.setGender(Gender.valueOf(element.get("gender")));
                    user.setIpAddress(element.get("ip_address"));
                    return user;
                }).collect(Collectors.toList());
    }
}
