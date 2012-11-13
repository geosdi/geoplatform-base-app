/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.geosdi.geoplatform.gui.client;

import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.extjs.gxt.ui.client.widget.Info;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.rpc.AsyncCallback;
import org.geosdi.geoplatform.gui.client.action.BaseAppActions;
import org.geosdi.geoplatform.gui.client.mvc.BaseAppController;
import org.geosdi.geoplatform.gui.configuration.startup.IStartupConfigurationStrategy;
import org.geosdi.geoplatform.gui.global.IGeoPlatformGlobal;
import org.geosdi.geoplatform.gui.service.GeoPlatformConfiguration;
import org.geosdi.geoplatform.gui.utility.GeoPlatformUtils;
import org.geosdi.geoplatform.gui.view.event.GeoPlatformEvents;

/**
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
public class BaseApp implements EntryPoint {

    private Dispatcher dispatcher;

    public void onModuleLoad() {
        dispatcher = Dispatcher.get();

        dispatcher.addController(new BaseAppController());

        BaseAppActions.addActionToolbar();
        BaseAppActions.addMenuBarAction();
        this.initGeoPlatformConfiguration();
    }

    /**
     * Initialize GeoPlatformConfiguration.
     */
    private void initGeoPlatformConfiguration() {
        GeoPlatformConfiguration.Util.getInstance().initGeoPlatformConfiguration(
                new AsyncCallback<IGeoPlatformGlobal>() {
                    @Override
                    public void onSuccess(IGeoPlatformGlobal result) {
                        GeoPlatformUtils.getInstance().setGlobalConfiguration(
                                result);
                        IStartupConfigurationStrategy strategy = result.getStrategy();
                        if (strategy == null) {
                            Dispatcher.forwardEvent(
                                    GeoPlatformEvents.INIT_GEO_PLATFORM);
                        } else {
                            strategy.initGeoPlatformConfiguration();
                        }
                    }

                    @Override
                    public void onFailure(Throwable caught) {
                        Info.display("Configuration Service Error",
                                caught.getMessage());
                    }
                });
    }
}
