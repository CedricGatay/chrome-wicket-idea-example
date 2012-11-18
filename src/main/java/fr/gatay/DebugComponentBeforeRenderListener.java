package fr.gatay;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Component;
import org.apache.wicket.application.IComponentOnBeforeRenderListener;
import org.apache.wicket.model.Model;

/**
 * Listener allowing to put the target classname in a HTML attribute in the generated page.
 * Be careful to plug this listener only when your application is in DEVELOPMENT mode
 * if you want to avoid performance issues (and an unnecessary network overhead)
 *
 * To get more information on extended usage : please check http://www.bloggure.info/?p=702
 *
 * User: cgatay
 * Date: 19/10/11
 * Time: 10:28
 */
public class DebugComponentBeforeRenderListener implements IComponentOnBeforeRenderListener {

    private final String prefix;

    /**
     *
     * @param packagePrefix prefix to consider, non matching classes will not show up in the markup
     */
    public DebugComponentBeforeRenderListener(final String packagePrefix) {
        prefix = packagePrefix;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void onBeforeRender(final Component component) {
        final String className = component.getClass().getName();
        if (className.startsWith(prefix)) {
            component.add(new DebugAttributeModifier(className));
        }
    }

    private static class DebugAttributeModifier extends AttributeModifier {
        public DebugAttributeModifier(final String className) {
            super("wktdbg", true, new Model<String>(className));
        }
    }
}