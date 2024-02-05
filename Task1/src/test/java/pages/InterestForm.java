package pages;

import aquality.selenium.forms.Form;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import org.openqa.selenium.By;
import utils.RandomUtils;
import utils.UploadFileUtils;
import java.util.ArrayList;
import java.util.List;

public class InterestForm extends Form {

    private final static String FOR = "for";
    private final static String SELECT_ALL = "interest_selectall";
    private final static String UNSELECT_ALL = "interest_unselectall";
    private final static By INTEREST_CHECKBOX_LOCATOR = By.xpath("//span[contains(@class, 'checkbox small')]");
    private final IButton uploadButton = getElementFactory().getButton(By.xpath("//a[contains(@class,'upload-button')]"), "uploadButton");
    private final ICheckBox unselectAllCheckbox = getElementFactory().getCheckBox(By.xpath("//label[@for='" + UNSELECT_ALL + "']"),"unselectAllCheckbox");
    private final IButton nextButton = getElementFactory().getButton(By.xpath("//button[contains(@class,'button--white') and contains(text(),'Next')]"), "nextButton");

    public InterestForm() {
        super(By.xpath("//div[@class='avatar-and-interests__avatar-box']"), "InterestForm");
    }

    public void unselectAllCheckbox() {
        unselectAllCheckbox.click();
    }

    public void selectRandomInterests(int numberOfInterests) {
        List<ICheckBox> checkboxes = getElementFactory().findElements(INTEREST_CHECKBOX_LOCATOR, ICheckBox.class);

        List<Integer> selectedIndices = new ArrayList<>();

        for (int i = 0; i < numberOfInterests; i++) {
            int randomIndex;
            do {
                randomIndex = RandomUtils.getRandomNumber(checkboxes.size());
            } while (selectedIndices.contains(randomIndex) || isSelectAllOrUnselectAllCheckbox(checkboxes.get(randomIndex)));

            selectedIndices.add(randomIndex);
            checkboxes.get(randomIndex).click();
        }
    }

    private boolean isSelectAllOrUnselectAllCheckbox(ICheckBox checkBox) {
        String id = checkBox.getAttribute(FOR);
        return id != null && (id.equals(SELECT_ALL) || id.equals(UNSELECT_ALL));
    }

    public void clickUploadButton() {
        uploadButton.click();
    }

    public void clickNextButton() {
        nextButton.click();
    }

    public void uploadFile(String filePath) {
        UploadFileUtils.uploadFile(filePath);
    }
}
