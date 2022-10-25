import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author psj
 * @date 2022/10/25 9:34
 * @File: stream流.java
 * @Software: IntelliJ IDEA
 */
public class stream流 {
    static class Student {
        String name;
        String school;
        int age;

        public Student(String name, String school, int age) {
            this.name = name;
            this.school = school;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", school='" + school + '\'' +
                    ", age=" + age +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return age == student.age &&
                    Objects.equals(name, student.name) &&
                    Objects.equals(school, student.school);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, school, age);
        }
    }

    static List<Student> students = new ArrayList<>();

    static {
        students.add(new Student("学生A", "大学1", 18));
        students.add(new Student("学生A", "大学1", 18));
        students.add(new Student("学生A", "大学1", 18));
        students.add(new Student("学生A", "大学1", 18));
        students.add(new Student("学生B", "大学1", 18));
        students.add(new Student("学生C", "大学1", 19));
        students.add(new Student("学生D", "大学2", 20));
        students.add(new Student("学生E", "大学2", 21));
        students.add(new Student("学生F", "大学2", 20));
        students.add(new Student("学生G", "大学3", 22));
        students.add(new Student("学生H", "大学3", 23));
        students.add(new Student("学生I", "大学3", 19));
        students.add(new Student("学生J", "大学4", 20));
    }

    public static void main(String[] args) {
        // filter：过滤
        System.out.println("==============filter==================");
        // List<Student> list = students.stream().filter(new Predicate<Student>() {
        //     @Override
        //     public boolean test(Student student) {
        //            return student.getAge()<20;
        //     }
        // }).collect(Collectors.toList());
        List<Student> list1 = students.stream().filter(student -> student.age < 20).collect(Collectors.toList());
        list1.forEach(System.out::println);
        System.out.println("================================");

        // distinct: 去重
        System.out.println("==============distinct==================");
        List<Student> list2 = students.stream().distinct().collect(Collectors.toList());
        list2.forEach(System.out::println);
        System.out.println("================================");

        // limit：切片
        System.out.println("==============limit==================");
        List<Student> list3 = students.stream().limit(5).collect(Collectors.toList());
        list3.forEach(System.out::println);
        System.out.println("================================");

        // skip: 跳过元素(返回一个扔掉了前n个元素的流)
        System.out.println("==============skip==================");
        List<Student> list4 = students.stream().skip(2).collect(Collectors.toList());
        list4.forEach(System.out::println);
        System.out.println("================================");

        // sorted: 排序
        System.out.println("==============sorted==================");
        List<Student> list5 = students.stream().sorted((student1, student2) -> student2.age - student1.age).collect(Collectors.toList());
        list5.forEach(System.out::println);
        System.out.println("================================");

        // map: filter用来过滤元素的，而map是用来创建一个新的元素
        System.out.println("==============map==================");
        // 只需要集合中学生的名字
        List<String> list6 = students.stream().map(student -> student.name).distinct().collect(Collectors.toList());
        list6.forEach(System.out::println);
        System.out.println("================================");

        // any: 只有集合中含有满足条件的元素就返回true
        System.out.println("==============any==================");
        boolean match = students.stream().anyMatch(student -> student.age > 20);
        System.out.println(match);
        System.out.println("================================");

        // findAny: 返回当前流中的任意元素
        System.out.println("==============findAny==================");
        Optional<Student> o = students.stream().filter(student -> student.age > 20).findAny();
        Student student = o.get();
        System.out.println(student);
        System.out.println("================================");

        // reduce: 累加和
        System.out.println("==============reduce==================");
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        // 0是初始值
        Integer reduce = list.stream().reduce(0, (a, b) -> a + b);
        System.out.println(reduce);
        System.out.println("================================");
    }
}
