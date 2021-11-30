
import java.awt.Color;
import java.awt.Graphics;
import java.util.Scanner;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class colorQuadrant {
	public static void draw(Graphics g)
	{  
		try (Scanner in = new Scanner(System.in)) {
			System.out.println("Enter Grid Dimension:");
			int GridDimension = 6, half = 3;
			GridDimension = in.nextInt();
			half = GridDimension / 2;
			for (int row = 0; row < half; row++)
			{
				for (int column = 0;column < half; column++)
			    {
					g.setColor(Color.green);
					g.fillOval(row*60 + 50, column*60 + 50, 50,50);	
			    }
			}
			
			for (int row = half; row < GridDimension; row++)
			{
				for (int column = 0;column < half; column++)
			    {
					g.setColor(Color.black);
					g.fillOval(row*60 + 50, column*60 + 50, 50,50);	
			    }
			}
			
			for (int row = 0; row < half; row++)
			{
				for (int column = half; column < GridDimension; column++)
			    {
					g.setColor(Color.black);
					g.fillOval(row*60 + 50, column*60 + 50, 50,50);	
			    }
			}
			
			for (int row = half; row < GridDimension; row++)
			{
				for (int column = half;column < GridDimension; column++)
			    {
					g.setColor(Color.red);
					g.fillOval(row*60 + 50, column*60 + 50, 50,50);	
			    }
			}
		}
	}

	public static void main(String[] args)
	{
		JFrame frame = new JFrame();

		final int FRAME_WIDTH = 800;
		final int FRAME_HEIGHT = 800;

		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JComponent component = new JComponent()
		{
			public void paintComponent(Graphics graph)
			{
				draw(graph);
			}
		};     
		frame.add(component);
		frame.setVisible(true);
   }   
}