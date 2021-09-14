package com.krissirin;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;

public class SoftAssertionsSearch {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void CheckExampleForJUnit5() {
        open("https://github.com/selenide/selenide");
        $("#wiki-tab").pressEnter();
        $("#user-content-the-details-for-the-diablo").scrollIntoView(true);
        $(".js-wiki-more-pages-link").click();
        $(".wiki-pages-box").$(byText("SoftAssertions")).shouldBe(Condition.visible);
        $(byText("SoftAssertions")).click();
        $("#wiki-body").shouldHave(Condition.text("@ExtendWith({SoftAssertsExtension.class})\n" +
                "class Tests {\n" +
                "  @Test\n" +
                "  void test() {\n" +
                "    Configuration.assertionMode = SOFT;\n" +
                "    open(\"page.html\");\n" +
                "\n" +
                "    $(\"#first\").should(visible).click();\n" +
                "    $(\"#second\").should(visible).click();\n" +
                "  }\n" +
                "}"));
    }
}
