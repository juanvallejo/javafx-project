package composite;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CompositeIcon implements Icon{
	List<Icon> holdIcons;
	List<Integer> xIcon;
	List<Integer> yIcon;
	//Icon icon;
	public CompositeIcon(){
		holdIcons=new ArrayList<Icon>();
		xIcon=new ArrayList<Integer>();
		yIcon=new ArrayList<Integer>();
	}
	public int getIconHeight() {
		int maxy=0;
		int maxSize=0;
		int z=0;
		int hold=0;
		for(int y:yIcon){
			if(y>maxSize){
				maxSize=y;
				hold=z;
			}
			z++;
		}
		Icon icon=holdIcons.get(hold);
		maxy=icon.getIconHeight();
		return maxSize+maxy;
	}

	public int getIconWidth() {
		int maxx=0;
		int maxSize=0;
		int hold=0;
		int z=0;
		for(int x:xIcon){
			if(x>maxSize){
				maxSize=x;
				hold=z;
			}
			z++;
		}
		Icon icon = holdIcons.get(hold);
		maxx=icon.getIconWidth();
		return maxSize + maxx;
		
	}

	public void paintIcon(Component c, Graphics g, int x, int y) {
		int z=0;
		for(Icon icon:holdIcons){
			icon.paintIcon(c, g, xIcon.get(z), yIcon.get(z));
			z++;
		}
	}
	private void addIcon(ImageIcon imageIcon, int i, int j) {
		holdIcons.add(imageIcon);
		xIcon.add(i);
		yIcon.add(j);
	}
	public static void main (String args[]) {

		JFrame frame = new JFrame();

		Container panel = frame.getContentPane();

		panel.setLayout(new BorderLayout());

		CompositeIcon icon = new CompositeIcon();

		try {

		icon.addIcon(new ImageIcon(new URL("http://th02.deviantart.net/fs71/150/f/2013/103/2/7/java_dock_icon_by_excurse-d61mi0t.png")), 10, 10);

		icon.addIcon(new ImageIcon(new URL("http://fc03.deviantart.net/fs20/f/2007/274/9/8/3D_Java_icon_by_BrightKnight.png")), 200, 200);

		icon.addIcon(new ImageIcon(new URL("http://www.bravegnu.org/blog/icons/java.png")), 5, 370);

		} catch (MalformedURLException e) {

		System.err.println("Apparently, somebody cannot type a URL");

		}

		panel.add(new JLabel(icon));

		frame.pack();

		frame.setVisible(true);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		}



}
