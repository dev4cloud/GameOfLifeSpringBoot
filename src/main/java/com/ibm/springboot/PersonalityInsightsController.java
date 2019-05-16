package com.ibm.springboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.watson.developer_cloud.personality_insights.v3.PersonalityInsights;
import com.ibm.watson.developer_cloud.personality_insights.v3.model.Profile;
import com.ibm.watson.developer_cloud.personality_insights.v3.model.ProfileOptions;

@RestController
public class PersonalityInsightsController {
	@RequestMapping("/watson")
    public String howAmI() {
        PersonalityInsights service = new PersonalityInsights("2016-10-19");
        service.setUsernameAndPassword("4c61ccdd-69a7-44de-ac37-87eabe69cfa3", "OO7k1otRBLIB");

        // Demo content from Moby Dick by Hermann Melville (Chapter 1)
        String text = "Call me Ishmael. Some years ago-never mind how long precisely-having "
            + "little or no money in my purse, and nothing particular to interest me on shore, "
            + "I thought I would sail about a little and see the watery part of the world. "
            + "It is a way I have of driving off the spleen and regulating the circulation. "
            + "Whenever I find myself growing grim about the mouth; whenever it is a damp, "
            + "drizzly November in my soul; whenever I find myself involuntarily pausing before "
            + "coffin warehouses, and bringing up the rear of every funeral I meet; and especially "
            + "whenever my hypos get such an upper hand of me, that it requires a strong moral "
            + "principle to prevent me from deliberately stepping into the street, and methodically "
            + "knocking people's hats off-then, I account it high time to get to sea as soon as I can. "
            + "This is my substitute for pistol and ball. With a philosophical flourish Cato throws himself "
            + "upon his sword; I quietly take to the ship. There is nothing surprising in this. "
            + "If they but knew it, almost all men in their degree, some time or other, cherish "
            + "very nearly the same feelings towards the ocean with me. There now is your insular "
            + "city of the Manhattoes, belted round by wharves as Indian isles by coral reefs-commerce surrounds "
            + "it with her surf. Right and left, the streets take you waterward.";

        ProfileOptions options = new ProfileOptions.Builder()
          .text(text)
          .build();

        Profile profile = service.profile(options).execute();
        System.out.println(profile);
        return profile.toString();
    }

}
