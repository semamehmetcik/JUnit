package day10_actionsClass;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

public class C06_FakerClass {

    @Test
    public void test01(){

        Faker faker = new Faker();

        System.out.println(faker.name().fullName()); // Taylor Hayes
        System.out.println(faker.name().fullName()); // Dr. Adriana Boehm
        System.out.println(faker.name().fullName()); // Kelsie Hammes

        System.out.println(faker.name().firstName()); // Gudrun

        System.out.println(faker.name().lastName()); // Yundt

        System.out.println(faker.internet().password()); // 6nzqploaqpsv

        System.out.println(faker.internet().emailAddress()); // grover.rohan@gmail.com

        System.out.println(faker.backToTheFuture().character()); // George McFly

        System.out.println(faker.gameOfThrones().city()); // Qarth


    }
}