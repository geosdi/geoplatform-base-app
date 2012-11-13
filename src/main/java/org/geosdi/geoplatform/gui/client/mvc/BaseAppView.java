/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.geosdi.geoplatform.gui.client.mvc;

import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.extjs.gxt.ui.client.mvc.Controller;
import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import org.geosdi.geoplatform.gui.client.MapWidgetEvents;
import org.geosdi.geoplatform.gui.client.config.LayerModuleInjector;
import org.geosdi.geoplatform.gui.client.model.memento.save.IMementoSave;
import org.geosdi.geoplatform.gui.client.widget.login.GeoPortalLogin;
import org.geosdi.geoplatform.gui.client.widget.menu.MenuBarWidget;
import org.geosdi.geoplatform.gui.configuration.mvc.GeoPlatformView;
import org.geosdi.geoplatform.gui.impl.view.LayoutManager;
import org.geosdi.geoplatform.gui.utility.GeoPlatformUtils;
import org.geosdi.geoplatform.gui.view.event.GeoPlatformEvents;
import org.gwtopenmaps.openlayers.client.OpenLayers;

/**
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
public class BaseAppView extends GeoPlatformView {

    private GeoPortalLogin loginWidget = new GeoPortalLogin();
    private HandlerRegistration handlerRegistration;

    public BaseAppView(Controller controller) {
        super(controller);
        OpenLayers.setProxyHost("gwtOpenLayersProxy?targetURL=");
    }

    /**
     * (non-Javadoc)
     *
     * @see
     * org.geosdi.geoplatform.gui.configuration.mvc.GeoPlatformView#handleEvent(com.extjs.gxt.ui.client.mvc.AppEvent)
     */
    @Override
    protected void handleEvent(AppEvent event) {
        if (event.getType() == GeoPlatformEvents.INIT_GEO_PLATFORM) {
            initUI();
        } else if (event.getType() == GeoPlatformEvents.APPLICATION_FIRST_LOGIN) {
            this.showFirstLogin();
        } else if (event.getType() == GeoPlatformEvents.REMOVE_WINDOW_CLOSE_LISTENER) {
            this.handlerRegistration.removeHandler();
        }
    }

    private void showFirstLogin() {
        RootPanel.get().add(loginWidget);
    }

    private void initUI() {
        addComponentToNorth();
        addComponentToCenter();
        RootPanel.get().add(LayoutManager.getInstance().getViewport());
        this.addWindowClosingListener();
    }

    private void addWindowClosingListener() {
        this.handlerRegistration = Window.addWindowClosingHandler(new Window.ClosingHandler() {
            @Override
            public void onWindowClosing(Window.ClosingEvent closingEvent) {
                String message = new String();
                IMementoSave mementoSave = LayerModuleInjector.MainInjector.getInstance().getMementoSave();
                if (!mementoSave.isEmpty()) {
                    message = "Warning: There are unsaved operations on the tree. ";
                }
                message += "Do you really want to leave the application?";
                closingEvent.setMessage(message);
            }
        });
    }

    private void addComponentToNorth() {
        MenuBarWidget menuBar = new MenuBarWidget(
                GeoPlatformUtils.getInstance().getGlobalConfiguration().getMenuBarContainerTool());
        LayoutManager.getInstance().getNorth().setTopComponent(menuBar.getBar());
    }

    private void addComponentToCenter() {
        Dispatcher.forwardEvent(MapWidgetEvents.ATTACH_MAP_WIDGET);
        Dispatcher.forwardEvent(MapWidgetEvents.ATTACH_TOOLBAR);
    }
}
