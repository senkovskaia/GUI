
package gui;

import javax.imageio.ImageIO;

import javax.swing.*;



import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;
import java.util.TimerTask;


public class MyPanel extends JPanel implements ActionListener{
	public final Image img;
	private final JPanel current;
	private final int width = 150;
	private final int height = 150;
	private int imagePosX = 225;
	private int imagePosY = 205; 
	boolean draw = true;
	public JButton Buttonlinks, Buttonrechts, Buttonup, Buttondown;
	
	public MyPanel() {
		setLayout(new BorderLayout()); 
		
		setBackground(Color.blue);
		current = this;
	    img = createImage(); 
		
		Buttonlinks  =  new JButton("links");
		Buttonrechts = new  JButton ("rechts");
		Buttonup  =  new JButton("oben");
		Buttondown = new  JButton ("unten");
		
		Buttonlinks.setPreferredSize(new Dimension(50,520));
		Buttonrechts.setPreferredSize(new Dimension(50,520));
		Buttonup.setPreferredSize(new Dimension(500,40));
		Buttondown.setPreferredSize(new Dimension(500,40));
		add(Buttonlinks, BorderLayout.WEST);
		add(Buttonrechts, BorderLayout.EAST);
		add(Buttonup, BorderLayout.NORTH);
		add(Buttondown, BorderLayout.SOUTH);
		
		Buttonlinks.setFocusable(false);
		Buttonrechts.setFocusable(false);
		Buttonup.setFocusable(false);
		Buttondown.setFocusable(false);
	
		Buttonlinks.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		
			MoveLeft();
				
				repaint(); 
			}
		});
		Buttonrechts.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		
			MoveRight();
				
				repaint(); 
			}
		});
		Buttonup.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		
			MoveUp();
				
				repaint(); 
			}
		});
		
		Buttondown.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		
			MoveDown();
				
				repaint(); 
			}
		});
		 this.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	                int mouseX = e.getX(); 
	                int mouseY = e.getY(); 
	                int posX = imagePosX;
	                int posY = imagePosY;
	                
	                if (mouseX >= posX && mouseX <= posX + width
	                        && mouseY >= posY && mouseY <= posY + height) {
	                    draw = false;
	                    repaint();
	                    new Timer().schedule(new TimerTask() {
	                        @Override
	                        public void run() {
	                            draw = true;
	                            repaint();
	                        }
	                    }, 3000);
	                }
	            }
	        });    
		
		
	}
	 @Override
     public void paintComponent(Graphics g) {
         super.paintComponent(g);
         if (draw) {
             g.drawImage(img, imagePosX, imagePosY, width, height, null);
         }
     }
	 
	 public Image createImage() {
         BufferedImage bufferedImage = null;
         try {
             bufferedImage = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResource("resources/siegel.jpg")));
         } catch (IOException e) {
        	 System.out.println("noimage");
             e.printStackTrace();
         }
         assert bufferedImage != null;
         return bufferedImage;
     }  
	 
	public void MoveLeft() {
		imagePosX-=50;
		
		repaint();
	}
	public void MoveRight() {
		imagePosX+=50;
		repaint();
	}
	public void MoveUp() {
		imagePosY-=50;
		repaint();
	}
	public void MoveDown() {
		imagePosY+=50;
		repaint();
	}
	
	
	 
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
