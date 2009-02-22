package podbuddy.controllers;

import java.net.URL;

import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.XmlReader;
import com.sun.syndication.feed.module.Module;
import com.sun.syndication.feed.module.itunes.FeedInformation;

import java.net.MalformedURLException;
import java.io.IOException;

import com.sun.syndication.io.FeedException;

import podbuddy.views.AppWindow;

public class InitController extends ActionController
{
    public InitController(AppWindow appWindow)
    {
        super(appWindow);
        
        System.out.println("Call dialog for feed URL");
                
        String podcastURL = this.appWindow.getPodcastDialog();
        
        try
        {
            SyndFeedInput input = new SyndFeedInput();
            SyndFeed podcast = 
                input.build(new XmlReader(new URL(podcastURL)));
                
            Module module = podcast.getModule("http://www.itunes.com/dtds/podcast-1.0.dtd");
            FeedInformation feedInfo = (FeedInformation) module;

            System.out.println(feedInfo.getSummary());
            System.out.println(feedInfo.getCategory());
            
        }
        catch (MalformedURLException e)
        {
            System.out.println("Bad URL");
        }
        catch (FeedException e)
        {
            System.out.println("Podcast can't be parsed.");
        }
        catch (IOException e)
        {
            System.out.println("Podcast can't be accessed.");
        }
        
        System.out.println(podcastURL);
    }
}