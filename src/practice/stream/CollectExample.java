package practice.stream;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class CollectExample {

    public static void main(String[] args) {

        List<Member> members = new LinkedList<>();
        members.add(new Member("김푸름", 25, "010-123-4562", "서울"));
        members.add(new Member("김하늘", 30, "010-803-6356", "부산"));
        members.add(new Member("오정임", 29, "010-264-4872", "대전"));

        System.out.println("<< List >>");
        List<Contact> list = members.stream().map((m) -> new Contact(m.getName(), m.getPhone())).collect(Collectors.toList());
        list.forEach(System.out::println);
    }

    static class Member {
        String name, phone, address;
        int age;
        public Member(String name, int age, String phone, String address) {
            this.name = name;
            this.age = age;
            this.phone = phone;
            this.address = address;
        }
        public String getName() {
            return name;
        }
        public String getPhone() {
            return phone;
        }
    }

    static class Contact {
        String name, phone;
        public Contact(String name, String phone) {
            this.name = name;
            this.phone = phone;
        }
        @Override
        public String toString() {
            return "Contact{" +
                    "name='" + name + '\'' +
                    ", phone='" + phone + '\'' +
                    '}';
        }
    }
}
