package podbuddy.views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JLabel;

import javax.swing.JOptionPane;

import java.awt.BorderLayout;

import podbuddy.controllers.*;

public class AppWindow extends JFrame
{
    public AppWindow()
    {
        super("PodBuddy");
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 600);
        setLocationRelativeTo(null);
        
        JPanel feedDetails = new JPanel();
        feedDetails.setLayout(new BorderLayout());
        JPanel feedAddress = new JPanel();
        feedAddress.add(new JTextField("http://test.com/podcast.xml"));
        feedAddress.add(new JButton("Grab"));
        feedDetails.add(feedAddress, BorderLayout.NORTH);
        JPanel feedExport = new JPanel();
        feedExport.add(new JLabel("Export feed for"));
        feedExport.add(new JCheckBox("iTunes"));
        feedExport.add(new JCheckBox("RSS"));
        feedDetails.add(feedExport, BorderLayout.SOUTH);
        add(feedDetails, BorderLayout.NORTH);
        
        JTabbedPane podcastEpisodes = new JTabbedPane();
        podcastEpisodes.addTab("Podcast", new JPanel());
        podcastEpisodes.addTab("Episodes", new JPanel());
        add(podcastEpisodes, BorderLayout.CENTER);
        
        JPanel createPanel = new JPanel();
        createPanel.add(new JButton("Create Podcast Feed"));
        add(createPanel, BorderLayout.SOUTH);
        
        setVisible(true);
        
        new InitController(this);
    }
    
    public String getPodcastDialog()
    {
        String podcastURL = (String) JOptionPane.showInputDialog(
            null,
            "Please enter a Podcast URL",
            "Podcast URL",
            JOptionPane.PLAIN_MESSAGE, null, null, null);
        
        return podcastURL;
    }
}