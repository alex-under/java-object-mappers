package org.example.data;

import org.example.data.entity.Group;
import org.example.data.entity.User;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class SampleData {

    private final List<User> users;
    private final Group group;


    public SampleData() {
        users = Arrays.asList(
                new User(0, UUID.fromString("4579ce65-78cf-4643-b0a7-b39d24dfc639"), "user1"),
                new User(1, UUID.fromString("1f1829e6-b0af-47b4-b56b-255c06281c38"), "user2"),
                new User(2, UUID.fromString("14cc8bd6-ab3c-45af-9c9c-28058acef5f0"), "user3"));

        group = new Group(0, UUID.fromString("6ca1a5a6-cbce-44ab-b27e-5fe728098467"), "group1", users);
    }

    public List<User> getUsers() {
        return users;
    }

    public Group getGroup() {
        return group;
    }
}
