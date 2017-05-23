package View;

import Drawing.controller.DrawingController;
import java.awt.Color;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;

public class DrawingPanel extends JPanel
{
	
	private ShapePanel shapePanel;
	private GraphPanel graphPanel;
	private JButton rectangleButton;
	private JButton circleButton;
	private JButton ellipseButton;
	private JButton triangleButton;
	private JButton polygonButton;
	private JButton resetButton;
	private JButton saveButton;
	private JButton randomArrayButton;
	private JButton sortArrayButton;
	private JButton buildButton;
	private SpringLayout baseLayout;
	private ImageIcon saveIcon;
	private DrawingController baseController;
	
public DrawingPanel(DrawingController baseController)
{
	super();
	this.baseController = baseController;
	
	baseLayout = new SpringLayout();
	graphPanel = new GraphPanel(setupArray());
	shapePanel = new ShapePanel(baseController);
	rectangleButton = new JButton("Draw Rectangles");
	baseLayout.putConstraint(SpringLayout.NORTH, rectangleButton, 10, SpringLayout.NORTH, this);
	baseLayout.putConstraint(SpringLayout.WEST, rectangleButton, 217, SpringLayout.WEST, this);
	ellipseButton = new JButton("Draw Ellipses");
	baseLayout.putConstraint(SpringLayout.NORTH, ellipseButton, 80, SpringLayout.NORTH, this);
	baseLayout.putConstraint(SpringLayout.WEST, ellipseButton, 10, SpringLayout.WEST, this);
	triangleButton = new JButton("Draw Triangles");
	baseLayout.putConstraint(SpringLayout.WEST, triangleButton, 10, SpringLayout.WEST, this);
	resetButton = new JButton("Reset");
	baseLayout.putConstraint(SpringLayout.WEST, resetButton, 10, SpringLayout.WEST, this);
	polygonButton = new JButton("Draw Polygons");
	baseLayout.putConstraint(SpringLayout.WEST, polygonButton, 10, SpringLayout.WEST, this);
	circleButton = new JButton("Draw Circles");
	baseLayout.putConstraint(SpringLayout.WEST, circleButton, 10, SpringLayout.WEST, this);
	baseLayout.putConstraint(SpringLayout.SOUTH, circleButton, -6, SpringLayout.NORTH, ellipseButton);
	saveButton = new JButton("Save");
	baseLayout.putConstraint(SpringLayout.NORTH, saveButton, 6, SpringLayout.SOUTH, resetButton);
	baseLayout.putConstraint(SpringLayout.WEST, saveButton, 0, SpringLayout.WEST, circleButton);
	randomArrayButton = new JButton("Random Array");
	baseLayout.putConstraint(SpringLayout.NORTH, randomArrayButton, 6, SpringLayout.SOUTH, rectangleButton);
	baseLayout.putConstraint(SpringLayout.WEST, randomArrayButton, 10, SpringLayout.WEST, rectangleButton);
	sortArrayButton = new JButton("Sort Array");
	baseLayout.putConstraint(SpringLayout.NORTH, sortArrayButton, 0, SpringLayout.NORTH, rectangleButton);
	baseLayout.putConstraint(SpringLayout.WEST, sortArrayButton, 13, SpringLayout.WEST, this);
	buildButton = new JButton("Build");

	
	
	setupPanel();
	setupLayout();
	setupListeners();
	
}

private int[] setupArray()
{
	int length = (int)(Math.random() * 10) + 3;
	int [] randomArray = new int [length];
	for(int index =0; index < length; index ++)
	{
		randomArray[index] = (int)(Math.random()* 50) + 3;
	}
	return randomArray;
}


private void setupPanel()
{
	this.setLayout(baseLayout);
	this.setBackground(Color.BLUE);
	this.setSize(new Dimension(600, 600));
	
	this.add(graphPanel);
	this.add(shapePanel);
	this.add(rectangleButton);
	this.add(circleButton);
	this.add(ellipseButton);
	this.add(triangleButton);
	this.add(polygonButton);
	this.add(resetButton);
	this.add(saveButton);
	this.add(randomArrayButton);
	this.add(sortArrayButton);
}

private void setupLayout()
{
	baseLayout.putConstraint(SpringLayout.NORTH, triangleButton, 8, SpringLayout.SOUTH, ellipseButton);
	baseLayout.putConstraint(SpringLayout.NORTH, polygonButton, 6, SpringLayout.SOUTH, triangleButton);
	baseLayout.putConstraint(SpringLayout.NORTH, resetButton, 6, SpringLayout.SOUTH, polygonButton);

}

private void setupListeners()
{
	rectangleButton.addActionListener(new ActionListener()
	{
	public void actionPerformed(ActionEvent clicked)
		{
			shapePanel.addRectangles();
		}
	}
);
	
	randomArrayButton.addActionListener(new ActionListener()
	{
	public void actionPerformed(ActionEvent clicked)
		{
			shapePanel.RandomArray();
		}
	}
);
	
	circleButton.addActionListener(new ActionListener()
	{
	public void actionPerformed(ActionEvent clicked)
		{
			shapePanel.addCircles();
		}
	}
);
	
	triangleButton.addActionListener(new ActionListener()
	{
	public void actionPerformed(ActionEvent clicked)
		{
			shapePanel.addTriangles();
		}
	}
);

	polygonButton.addActionListener(new ActionListener()
	{
	public void actionPerformed(ActionEvent clicked)
		{
			shapePanel.addPolygons();
		}
	}
);

	ellipseButton.addActionListener(new ActionListener()
	{
	public void actionPerformed(ActionEvent clicked)
		{
			shapePanel.addEllipses();
		}
	}
);

	resetButton.addActionListener(new ActionListener()
	{
	public void actionPerformed(ActionEvent clicked)
		{
			shapePanel.reset();
		}
	}
);

	saveButton.addActionListener(new ActionListener()
	{
	public void actionPerformed(ActionEvent clicked)
		{
			shapePanel.savePanel();
		}
	}
);

	
}

}
