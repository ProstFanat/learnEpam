package pageObjects.businessObjects;

import org.testng.Assert;
import pageObjects.PastePage;

public class PasteBO {
    private PastePage pastePage;
    public PasteBO() {
        pastePage = new PastePage();
    }

    public PasteBO verifyThatPageHaveCorrectTitle(String title){
        Assert.assertTrue(pastePage.isPageContainsCorrectTitle(title));
        return this;
    }

    public PasteBO verifyThatPageHaveCorrectHighlighted(String highlighted){
        Assert.assertTrue(pastePage.isPageContainsCorrectHighlight(highlighted));
        return this;
    }

    public PasteBO verifyThatPageHaveCorrectText(String text){
        Assert.assertTrue(pastePage.isPageContainsCorrectText(text));
        return this;
    }
}
