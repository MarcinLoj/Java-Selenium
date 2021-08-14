package com.herokuapp.internet_the.testcases;

import com.herokuapp.internet_the.base.TestBase;
import com.herokuapp.internet_the.pages.FramesPage;
import com.herokuapp.internet_the.pages.HomePage;
import com.herokuapp.internet_the.pages.IFramePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class iFramePageTest extends TestBase {
    HomePage homePage;
    FramesPage framesPage;
    IFramePage iFramePage;
    iFramePageTest() {
        super();
    }
    @BeforeEach
    public void setUp() {
        initialization();
        homePage = new HomePage();
        framesPage = new FramesPage();
        iFramePage = new IFramePage();
        framesPage = homePage.navigateToFramesPage();
        iFramePage = framesPage.navigateToiFramePage();
    }
    @AfterEach
    public void tearDown() {
        driver.close();
    }
    @Test
    public void writeContentIntoIFrame() {
        iFramePage.sendKeysToTextInput();
        Assertions.assertEquals(iFramePage.inputContent,iFramePage.getTextFrom(iFramePage.textInput), "Unable to send content into text input");
    }
    @Test
    public void undoInputContent() {
        iFramePage.sendKeysToTextInput();
        iFramePage.undoChanges();
        Assertions.assertEquals(iFramePage.beginningInputContent,iFramePage.getTextFrom(iFramePage.textInput), "Content didn't undo");
    }
    @Test
    public void redoInputContent() {
        iFramePage.sendKeysToTextInput();
        iFramePage.undoChanges();
        iFramePage.redoChanges();
        Assertions.assertEquals(iFramePage.inputContent,iFramePage.getTextFrom(iFramePage.textInput), "Content didn't redo");
    }
    @Test
    public void checkRedoButtonIsDisabledWhenThereIsNoContentToUndo() {
        iFramePage.sendKeysToTextInput();
        iFramePage.undoChanges();
        iFramePage.redoChanges();
        Assertions.assertTrue(iFramePage.checkButtonAvailability(iFramePage.redoButtonDisabled), "Undo button has not been disabled");
    }
    @Test
    public void checkUndoButtonIsDisabledWhenThereIsNoContentToUndo() {
        iFramePage.sendKeysToTextInput();
        iFramePage.undoChanges();
        Assertions.assertTrue(iFramePage.checkButtonAvailability(iFramePage.undoButtonDisabled), "Undo button has not been disabled");
    }
    @Test
    public void checkIsFormatInformationChangesAfterBoldButtonClick() {
        iFramePage.clickButton(iFramePage.boldButton);
        Assertions.assertEquals("Bold",iFramePage.getTextFrom(iFramePage.formatInformation), "Format Info doesn't change on bold button");
    }
    @Test
    public void checkIsFormatInformationChangesAfterItalicButtonClick() {
        iFramePage.clickButton(iFramePage.italicButton);
        Assertions.assertEquals("Italic",iFramePage.getTextFrom(iFramePage.formatInformation),"Format Info doesn't change on italic button");
    }
    @Test
    public void checkIsItalicButtonSignedAsClicked() {
        iFramePage.clickButton(iFramePage.italicButton);
        Assertions.assertTrue(iFramePage.checkButtonAvailability(iFramePage.italicButtonDisabled),"Italic button is not signed as clicked in");
    }
    @Test
    public void checkIsBoldButtonSignedAsClicked() {
        iFramePage.clickButton(iFramePage.boldButton);
        Assertions.assertTrue(iFramePage.checkButtonAvailability(iFramePage.boldButtonDisabled), "Bold button is not signed as clicked in");
    }
    @Test
    public void checkTextIsBold() {
        iFramePage.sendKeysToTextInput();
        iFramePage.highlightText();
        iFramePage.clickButton(iFramePage.boldButton);
        Assertions.assertTrue(iFramePage.checkTextInputType(iFramePage.textInputBold),"Text content is not changed to bold");
    }
    @Test
    public void checkTextIsItalic() {
        iFramePage.sendKeysToTextInput();
        iFramePage.highlightText();
        iFramePage.clickButton(iFramePage.italicButton);
        Assertions.assertTrue(iFramePage.checkTextInputType(iFramePage.textInputItalic),"Text content is not changed to italic");
    }
    @Test
    public void checkTextIsItalicAndBold() {
        iFramePage.sendKeysToTextInput();
        iFramePage.highlightText();
        iFramePage.clickButton(iFramePage.italicButton);
        iFramePage.clickButton(iFramePage.boldButton);
        Assertions.assertTrue(iFramePage.checkTextInputType(iFramePage.textInputBold, iFramePage.textInputItalic),"Text content is not changed to italic and bold");
    }
    @Test
    public void checkTextIsAlignedToLeft() {
        iFramePage.sendKeysToTextInput();
        iFramePage.clickButton(iFramePage.textLeftAlignButton);
        Assertions.assertTrue(iFramePage.checkIsTextAlignedTo("left"), "Text is not aligned to left");
    }
    @Test
    public void checkTextIsAlignedToCenter() {
        iFramePage.sendKeysToTextInput();
        iFramePage.clickButton(iFramePage.textCenterAlignButton);
        Assertions.assertTrue(iFramePage.checkIsTextAlignedTo("center"), "Text is not aligned to center");
    }
    @Test
    public void checkTextIsAlignedToRight() {
        iFramePage.sendKeysToTextInput();
        iFramePage.clickButton(iFramePage.textRightAlignButton);
        Assertions.assertTrue(iFramePage.checkIsTextAlignedTo("right"), "Text is not aligned to right");
    }
    @Test
    public void checkTextIsJustifyAligned() {
        iFramePage.sendKeysToTextInput();
        iFramePage.clickButton(iFramePage.textJustifyButton);
        Assertions.assertTrue(iFramePage.checkIsTextAlignedTo("justify"), "Text is not justify aligned");
    }
    @Test
    public void checkIsTextLeftAlignButtonSignedAsClicked() {
        iFramePage.clickButton(iFramePage.textLeftAlignButton);
        Assertions.assertTrue(iFramePage.checkButtonAvailability(iFramePage.textLeftAlignButtonDisabled), "Text left align button is not disabled after click");
    }
    @Test
    public void checkIsTextCenterAlignButtonSignedAsClicked() {
        iFramePage.clickButton(iFramePage.textCenterAlignButton);
        Assertions.assertTrue(iFramePage.checkButtonAvailability(iFramePage.textCenterAlignButtonDisabled), "Text center align button is not disabled after click");
    }
    @Test
    public void checkIsTextRightAlignButtonSignedAsClicked() {
        iFramePage.clickButton(iFramePage.textRightAlignButton);
        Assertions.assertTrue(iFramePage.checkButtonAvailability(iFramePage.textRightAlignButtonDisabled), "Text right align button is not disabled after click");
    }
    @Test
    public void checkIsTextJustifyAlignButtonSignedAsClicked() {
        iFramePage.clickButton(iFramePage.textJustifyButton);
        Assertions.assertTrue(iFramePage.checkButtonAvailability(iFramePage.textJustifyButtonDisabled), "Text justify align button is not disabled after click");
    }
    @Test
    public void checkIsDecreaseIndentDisabledWhenThereIsNoIndentToDecrease() {
        iFramePage.clearTextInput();
        Assertions.assertTrue(iFramePage.checkButtonAvailability(iFramePage.decreaseIndentButtonDisabled), "Decrease indent button is not disabled when there is no content on page");
    }
    @Test
    public void checkIsContentIndentIncreased() {
        iFramePage.clickIncreaseButton(5);
        Assertions.assertTrue(iFramePage.checkIsIndentIncreased(),"Indent has not been increased by specifed count");
    }
    @Test
    public void checkIsContentIndentDecreased() {
        iFramePage.clickIncreaseButton(5);
        iFramePage.clickDecreaseButton(3);
        Assertions.assertTrue(iFramePage.checkIsIndentDecreased(),"Indent has not been decreased by specifed count");
    }
    /*
    @Test
    public void checkIsIncreaseIndentButtonDisabledWhenMaximumAmountOfIndentHasBeenReached() {
        iFramePage.clearTextInput();
        iFramePage.clickButton(iFramePage.increaseIndentButton);
        Assertions.assertTrue(iFramePage.checkButtonAvailability(iFramePage.increaseIndentButtonDisabled), "Decrease indent button is not disabled when there is no content on page");
    }

    // This test is disabled in case of the function is bugged and there is not limit in increasing indent

    */
}
