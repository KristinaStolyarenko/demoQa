package com.krissirin;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class Lesson1 {
    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
    }
    @Test
    void firstTest(){
        File file = new File("src/test/java/resources/001.jpeg");
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Кристина");
        $("#lastName").setValue("Столяренко");
        $("#userEmail").setValue("kristina.sirin@gmail.com");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("79089076534");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").$(byText("1993")).click();
        $(".react-datepicker__month-select").$(byText("July")).click();
        $(".react-datepicker__week").$(byText("3")).click();
        $("#subjectsInput").setValue("b");
        $("#subjectsContainer").$(byText("Biology")).click();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFile(file);
        $("#currentAddress").setValue("Весь Мир");
        $("#stateCity-wrapper").scrollIntoView(true);
        $("#stateCity-wrapper").$(byText("Select State")).click();
        $("#state").$(byText("NCR")).click();
        $("#city").$(byText("Select City")).click();
        $("#city").$(byText("Noida")).click();
        $("#submit").click();
        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
        $("#closeLargeModal").click();
    }
}
