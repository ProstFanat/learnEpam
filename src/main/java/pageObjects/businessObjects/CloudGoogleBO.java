package pageObjects.businessObjects;

import pageObjects.CloudGooglePage;
import pageObjects.SearchResultCloudPage;

public class CloudGoogleBO {
    private CloudGooglePage cloudGooglePage;
    public CloudGoogleBO(){cloudGooglePage = new CloudGooglePage();}

    public SearchResultCloudPage search(String text){
        cloudGooglePage.clickBtnSearch()
                .inputTextToSearchFilter(text);
        return new SearchResultCloudPage();
    }
}
