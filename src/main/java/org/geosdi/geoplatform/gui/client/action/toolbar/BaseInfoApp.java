/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.geosdi.geoplatform.gui.client.action.toolbar;

import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.mvc.Dispatcher;
import org.geosdi.geoplatform.gui.action.ToolbarApplicationAction;
import org.geosdi.geoplatform.gui.client.MapWidgetEvents;
import org.geosdi.geoplatform.gui.client.Resources;

/**
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
public class BaseInfoApp extends ToolbarApplicationAction {

    public BaseInfoApp() {
        super("Base App", Resources.ICONS.geoPortalInfo(), 
                "Basic Application");
    }

    @Override
    public void componentSelected(ButtonEvent ce) {
        Dispatcher.forwardEvent(MapWidgetEvents.ATTACH_MAP_WIDGET);
    }
}