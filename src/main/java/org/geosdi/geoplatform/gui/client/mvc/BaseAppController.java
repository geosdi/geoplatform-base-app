/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.geosdi.geoplatform.gui.client.mvc;

import com.extjs.gxt.ui.client.mvc.AppEvent;
import org.geosdi.geoplatform.gui.configuration.mvc.GeoPlatformController;
import org.geosdi.geoplatform.gui.view.event.GeoPlatformEvents;

/**
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
public class BaseAppController extends GeoPlatformController {

    public BaseAppController() {
        registerEventTypes(
                GeoPlatformEvents.APPLICATION_FIRST_LOGIN,
                GeoPlatformEvents.INIT_GEO_PLATFORM,
                GeoPlatformEvents.REMOVE_WINDOW_CLOSE_LISTENER);
    }

    @Override
    public void initialize() {
        view = new BaseAppView(this);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.geosdi.geoplatform.gui.configuration.mvc.GeoPlatformController#
     * handleEvent(com.extjs.gxt.ui.client.mvc.AppEvent)
     */
    @Override
    public void handleEvent(AppEvent event) {
        super.handleEvent(event);
    }
}
