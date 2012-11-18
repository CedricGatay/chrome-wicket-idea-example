package fr.gatay;

import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

    public HomePage(final PageParameters parameters) {
	super(parameters);

	add(new Label("version", "Disabled on classes not belonging to fr.gatay.*"));
	add(new MyLabel("myLabel", "Works with inner classes"));
    add(new Label("anonLabel", "Even works with anonymous inner classes"){

    });
    }

    public static class MyLabel extends Label{
        public MyLabel(String id, String label) {
            super(id, label);
        }
    }
}
