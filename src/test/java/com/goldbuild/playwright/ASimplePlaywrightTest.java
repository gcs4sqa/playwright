package com.goldbuild.playwright;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.junit.UsePlaywright;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.goldbuild.playwright.config.MyOptions;

@UsePlaywright(MyOptions.class)
public class ASimplePlaywrightTest {

    @Test
    void shouldShowThePageTitle(Page page){
//        page.navigate("https://practicesoftwaretesting.com");
        page.navigate("/");
        String title = page.title();
        Assertions.assertTrue(title.contains("Practice Software Testing"));

    }

    @Test
    void shouldSearchByKeyword(Page page){
//        page.navigate("https://practicesoftwaretesting.com");
        page.navigate("/");
        page.locator("[placeholder=Search]").fill("Pliers");
        page.locator("button:has-text('Search')").click();

        int matchingSearchResults = page.locator(".card").count();

        Assertions.assertTrue(matchingSearchResults > 0);

    }

    @DisplayName("Get by Text")
    @Test
    void byText(Page page){
        page.navigate("/");
        page.getByText("Bolt Cutters").click();
        PlaywrightAssertions.assertThat(page.getByText("MightyCraft Hardware")).isVisible();
    }

    @DisplayName("Get by Alt Text")
    @Test
    void byAltText(Page page){
        page.navigate("/");
        page.getByAltText("Combination Pliers").click();
        PlaywrightAssertions.assertThat(page.getByText("ForgeFlex Tools")).isVisible();
    }

    @DisplayName("using the title")
    @Test
    void byTitle(Page page){
        page.navigate("/");
        page.getByText("Bolt Cutters").click();
        page.getByTitle("Practice Software Testing - Toolshop").click();
        PlaywrightAssertions.assertThat(page.getByText("Sort")).isVisible();

    }

    @DisplayName("using the lable selector")
    @Test
    void byLabel(Page page){
        page.navigate("/");
        page.getByLabel("Search").fill("Pliers");
        page.locator("button:has-text('Search')").click();
        int matchespagelocator = page.locator(".card").count();
        Assertions.assertTrue(matchespagelocator>0);


    }
    

}
