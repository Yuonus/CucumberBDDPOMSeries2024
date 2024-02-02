package parallel;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.pages.AccountsPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountsPageSteps {
	
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private AccountsPage accountsPage;
	
	@Given("user has already logged into application")
	public void user_has_already_logged_into_application(DataTable CredentialTable) {
		List<Map<String, String>> CredentialsList = CredentialTable.asMaps();
		String userName = CredentialsList.get(0).get("username");
		String password = CredentialsList.get(0).get("password");
		
		DriverFactory.getDriver().get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		accountsPage = loginPage.doLogin(userName, password);
	}

	@Given("user is on Accounts page")
	public void user_is_on_accounts_page() {
		String title = accountsPage.getAccountsPageTitle();
		System.out.println("Accounts Page title is: " + title);
		// For assertion: the assertion has already been retrun in Login page. but if you still wants, you can do it.
	}

	@Then("user gets accounts section")
	public void user_gets_accounts_section(DataTable AccountsPageSectionsTable) {
		List<String> expectedAccountSectionList = AccountsPageSectionsTable.asList();
		System.out.println("Expected Accounts section list: " + expectedAccountSectionList);
		List<String> actualAccountSectionList = accountsPage.getAccountsSectionsList();
		System.out.println("Actual Accounts section list: " + actualAccountSectionList);
		Assert.assertTrue(expectedAccountSectionList.containsAll(actualAccountSectionList));
		// Or
//		Assert.assertEquals(expectedAccountSectionList, actualAccountSectionList);
	}

	@Then("accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer expectedSectionCount) {
		Assert.assertTrue(accountsPage.getAccountsSectionCount() == expectedSectionCount);
	}
	
	/*		NOTE 	NOTE	NOTE 	NOTE 	NOTE	NOTE
	 * 1: We did delete the complete package name "io.cucumber.datatable." from where the data tables were present.
	 * 2: And we imported DataTable from "io.cucumber.datatable.DataTable"
	 * 
	 */

}
