package guru.qa.tests;


import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;


public class HomeWork5_10 extends TestBase {

    private final String URL = "https://demoqa.com/automation-practice-form";
    private final String picture = "p1.png";

    @Disabled
    @Owner("KenyTae")
    @Feature("Заполнение регистрационной формы")
    @Story("Issues")
    @DisplayName("Lambda test")
    @Tag("Lambda test")
    @Test
    void studentsRegistration() {

        //Проект QA.Guru9_HW10RegistrationFormJenkins
        //Проект QA.Guru9_HW11RegistrationFormJenkin

        /*
        1. Доработать свой код:

        1.1 Передать из дженкинса адрес удаленного браузера

        1.2 Спрятать логин/пароль к удаленному браузеру в .properties файл, считывать его нужно в коде с owner

        2. Групповое дз:

        2.1 Сделать сборку в дженкинсе на код коллеги (тест должен успешно пройти)

        2.2 Подготовить код, чтобы на ваши тесты коллега сделал сборку с дженкинс.
         */

        step("Открываем страницы браузер " + URL + " ", () -> {
            registrationPage.openPage(URL);
        });
        step("Заполнение регистрационной формы", () -> {
            step("Заполнение основной информации", () -> {
                registrationPage
                        //.openPage(URL) // Открываем браузер и проверяем что страница загрузилась
                        .setFirstName(randomFaker.firstName) // Заполняем поле firstName
                        .setLastName(randomFaker.lastName) // Заполняем поле lastName
                        .setEmail("qa.guru@gmail.com") // Заполняем поле email
                        .selectGender("Male") // Кликаем Gender radio button
                        .setMobilePhone("7773557777"); // Заполняем поле Mobile(10 Digits)
            });
            step("Заполнение даты рождения", () -> {
                registrationPage.calendarComponent.setDateOfBirthday("5", "1982", randomFaker.day);
            });
            step("Заполнение поля subjects", () -> {
                registrationPage.setSubjects("e");
            });
            step("Заполнение поля hobby", () -> {
                registrationPage.hobbySelect("Sports");
            });
            step("Загрузка файла", () -> {
                registrationPage.setPicture("img/" + picture);
            });
            step("Заполнение поля адресс", () -> {
                registrationPage.setCurrentAddress(randomFaker.address);
            });
            step("Заполнение полей штата и города", () -> {
                registrationPage
                        .setState("NCR") // Select state
                        .setCity("Gurgaon"); //Select City
            });
        });
        step("Нажименм кнопку Subjects", () -> {
            registrationPage.setSubmit();
        });
        step("Валидация заполнения формы", () -> {
            registrationPage
                    .validate("Student Name", randomFaker.firstName + " " + randomFaker.lastName)
                    .validate("Student Email", "qa.guru@gmail.com")
                    .validate("Gender", "Male")
                    .validate("Mobile", "7773557777")
                    .validate("Date of Birth", randomFaker.day + " June,1982")
                    .validate("Subjects", "English")
                    .validate("Hobbies", "Sports")
                    .validate("Picture", "p1.PNG")
                    .validate("Address", randomFaker.address)
                    .validate("State and City", "NCR Gurgaon");
        });

    }

}
