package Components.Panels;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

public class ImagePanel extends JPanel
{
    private Image image;
    private boolean repeat;
    public void setImage(Image image)
    {
        this.image = image;
        repeat = true;
    }
    public void setRepeat(boolean repeat)
    {
        this.repeat = repeat;
    }
    @Override
    protected void paintComponent(Graphics g)
    {
        if(image != null)
        {
            if(repeat)
            {
                int w = this.getWidth();
                int h = this.getHeight();
                int iw = image.getWidth(null);
                int ih = image.getHeight(null);
                int x = w/iw + 1;
                int y = h/ih + 1;
                int posx = -(x*iw-w)/2;
                int posy = -(y*ih-h)/2;
                for(int i = 0;i<x;i++)
                {
                    for(int j = 0;j<y;j++)
                    {
                        g.drawImage(image, i*iw + posx, j*ih + posy, null);
                    }
                }
            }
            else
                g.drawImage(image, 0, 0, null);
        }
    }
    
}
