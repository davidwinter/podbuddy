package podbuddy;

import javax.swing.UIManager;

import podbuddy.views.AppWindow;

public class PodBuddy
{
    public static void main(String[] args) 
    {
        try
        {
            UIManager.setLookAndFeel
                (UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        
        System.setProperty("apple.laf.useScreenMenuBar", "true");
        
        new AppWindow();
    }
}