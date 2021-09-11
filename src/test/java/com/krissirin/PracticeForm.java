package com.krissirin;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class PracticeForm {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }
    @Test
    void PositivePass() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Kristina");
        $("#lastName").setValue("Still");
        $("#userEmail").setValue("kokoko@gmail.com");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("7908907653");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").$(byText("1993")).click();
        $(".react-datepicker__month-select").$(byText("July")).click();
        $(".react-datepicker__week").$(byText("3")).click();
        $("#subjectsInput").setValue("b");
        $("#subjectsContainer").$(byText("Biology")).click();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("001.jpeg");
        $("#currentAddress").setValue("All world");
        $("#stateCity-wrapper").scrollIntoView(true);
        $("#stateCity-wrapper").$(byText("Select State")).click();
        $("#state").$(byText("NCR")).click();
        $("#city").$(byText("Select City")).click();
        $("#city").$(byText("Noida")).click();
        $("#submit").click();
        $(".modal-body").shouldHave(text("Kristina Still"));
        $(".modal-body").shouldHave(text("Still"));
        $(".modal-body").shouldHave(text("kokoko@gmail.com"));
        $(".modal-body").shouldHave(text("7908907653"));
        $(".modal-body").shouldHave(text("Biology"));
        $(".modal-body").shouldHave(text("Sports"));
        $(".modal-body").shouldHave(text("All world"));
        $(".modal-body").shouldHave(text("NCR Noida"));

    }
}
