package guru.qa.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CalendarComponent {

    private SelenideElement
            dateOfBirthClick = $("#dateOfBirthInput"),
            monthSelect = $(".react-datepicker__month-select"),
            yearSelect = $(".react-datepicker__year-select");
    ElementsCollection daySelect = $$(".react-datepicker__day");

    public void setDateOfBirthday(String month, String year, String day) {
        // Заполняем поле Date of Birth
        dateOfBirthClick.click();
        monthSelect.selectOptionByValue(month);
        yearSelect.selectOptionByValue(year);
        daySelect.find(text(day)).click();
    }
}
