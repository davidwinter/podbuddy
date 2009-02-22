package podbuddy.controllers;

import podbuddy.views.AppWindow;

public abstract class ActionController
{
    protected static AppWindow appWindow;
    
    public ActionController(AppWindow appWindow)
    {
        this.appWindow = appWindow;
    }
}