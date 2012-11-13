/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.geosdi.geoplatform.gui.client.action;

import org.geosdi.geoplatform.configurator.gui.GuiComponentIDs;
import org.geosdi.geoplatform.gui.action.ToolbarAction;
import org.geosdi.geoplatform.gui.action.ToolbarActionCreator;
import org.geosdi.geoplatform.gui.action.ToolbarActionRegistar;
import org.geosdi.geoplatform.gui.action.ToolbarApplicationAction;
import org.geosdi.geoplatform.gui.action.menu.MenuAction;
import org.geosdi.geoplatform.gui.action.menu.MenuActionCreator;
import org.geosdi.geoplatform.gui.action.menu.MenuActionRegistar;
import org.geosdi.geoplatform.gui.client.action.toolbar.BaseInfoApp;
import org.geosdi.geoplatform.gui.client.action.toolbar.ChangeBaseLayerAction;
import org.geosdi.geoplatform.gui.client.config.BasicGinInjector;
import org.geosdi.geoplatform.gui.impl.map.GeoPlatformMap;

/**
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
public class BaseAppActions {

    public static void addMenuBarAction() {

        MenuActionRegistar menuRegistar = BasicGinInjector.MainInjector.getInstance().getMenuActionRegistar();

        menuRegistar.put(GuiComponentIDs.USER_LOGOUT,
                new MenuActionCreator() {
                    @Override
                    public MenuAction createAction() {
                        return new UserLogout();
                    }
                });
    }

    public static void addActionToolbar() {
        ToolbarActionRegistar toolbarRegistar = BasicGinInjector.MainInjector.getInstance().getToolbarActionRegistar();

        toolbarRegistar.put(GuiComponentIDs.GEO_PLATFORM_INFO_APP,
                new ToolbarActionCreator() {
                    @Override
                    public ToolbarApplicationAction createActionTool(
                            GeoPlatformMap mapWidget) {
                        return new BaseInfoApp();
                    }
                });

        toolbarRegistar.put(GuiComponentIDs.CHANGE_BASE_LAYER,
                new ToolbarActionCreator() {
                    @Override
                    public ToolbarAction createActionTool(
                            GeoPlatformMap mapWidget) {
                        return new ChangeBaseLayerAction(mapWidget);
                    }
                });
    }
}
