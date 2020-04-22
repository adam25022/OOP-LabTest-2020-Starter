package ie.tudublin;

import processing.core.PApplet;

import java.util.ArrayList;
import processing.data.Table;
import processing.data.TableRow;

public class Gantt extends PApplet
{	
	public ArrayList<tasks> task = new ArrayList<tasks>();

	public void settings()
	{
		size(800, 600);
	}

	public void loadTasks()
	{
		Table t = loadTable("tasks.csv", "header");
		for(TableRow row:t.rows())
		{
			tasks c = new tasks(row);
			task.add(c);
		}
	}

	public void printTasks()
	{
		for(tasks Task : task)
        {
            println(Task);
        }
	}
	
	public void mousePressed()
	{
		println("Mouse pressed");	
	}

	public void mouseDragged()
	{
		println("Mouse dragged");
	}

	
	
	public void setup() 
	{
		loadTasks();
		printTasks();
		draw();
	}
	
	public void draw()
	{			
		background(0);
		colorMode(HSB);
		stroke(255);
		int color=0;
		int margin =width/25;
		fill(255);
		for(int i=0; i<9; i++)
		{
			float y = map(i, 0, task.size(), 2 * margin, height - margin);
			text(task.get(i).getTasks(), margin, y);
		}
		for(int i=1 ; i<=30; i++)
		{
			float x = map(i-1, 0 , 30, 100, width-50);
			if(color==1)
			{
				stroke(175);
			}
			else
			{
				stroke(255);
			}
			text(i, x-2, 35);
			line(x, height-50, x, 50);
			color=color+1;
			color=color%2;
		}
	}
}
