import java.awt.Font;
import java.awt.Graphics;
import java.awt.Color;
import java.io.InputStreamReader;

import jpb.*;

import java.util.Scanner;

public class DrawNFL {

	public static void main(String[] args) {
		String playersNames = "";
		int numberOfPlayers = 0;
		String inputNames = "";
		String [] nameOfPlayers = new String[100];
		int i;
	

		// Enter in the number of players
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of players: ");
		numberOfPlayers = sc.nextInt();
		String num = Integer.toString(numberOfPlayers);
	
		for (i = 0; i < numberOfPlayers; i++) {
			System.out.println("Enter player name " + (i + 1) + ":");
			inputNames = sc.next();
			playersNames = playersNames+inputNames+",";
		}

		// test your drawing here
		DrawNFL drawNFL = new DrawNFL();
		// Create drawable frame
		DrawableFrame df = new DrawableFrame("team");
		df.show();
		df.setSize(1200, 600);

		// Obtain graphics context
		Graphics g = df.getGraphicsContext();
		// The green field size is: width=650 and height=450
		g.setColor(Color.GREEN);
		g.fillRect(50, 50, 650, 450);

		// draw polygon
		// Define coordinates of outer polygon (edge of sign) and
		// inner polygon (red portion)

		int[] xOuter = { 736, 787, 823, 823, 787, 736, 700, 700 };
		int[] yOuter = { 0, 0, 36, 87, 123, 123, 87, 36 };
		int[] xInner = { 737, 786, 818, 818, 786, 737, 705, 705 };
		int[] yInner = { 5, 5, 37, 86, 118, 118, 86, 37 };

		// Draw edge of sign in black
		g.setColor(Color.black);
		g.drawPolygon(xOuter, yOuter, xOuter.length);

		// Fill interior of sign with red
		g.setColor(Color.red);
		g.fillPolygon(xInner, yInner, xInner.length);

		// Display number in white
		g.setColor(Color.white);
		g.setFont(new Font("Helvetica", Font.BOLD, 76));
		g.drawString(num, 740, 76);

		// Display names under polygon
		g.setColor(Color.black);
		g.setFont(new Font("Sansterif", Font.BOLD, 16));
		int y = 150;
		nameOfPlayers = playersNames.split(",");
		for(i = 0; i < numberOfPlayers; i++){
			if(nameOfPlayers[i].toString() != null){
				g.drawString(nameOfPlayers[i].toString(), 740, y);
				y = y+20;
			}
				
		}
		

		// white lines
		g.setFont(new Font("Sansterif", Font.BOLD, 12));
		g.setColor(Color.WHITE);
		g.drawRect(100, 100, 550, 300);
		g.drawLine(180, 100, 180, 400);
		g.drawLine(220, 100, 220, 400);
		g.drawLine(260, 100, 260, 400);
		g.drawLine(300, 100, 300, 400);
		g.drawLine(340, 100, 340, 400);
		g.drawLine(380, 100, 380, 400);
		g.drawLine(420, 100, 420, 400);
		g.drawLine(460, 100, 460, 400);
		g.drawLine(500, 100, 500, 400);
		g.drawLine(540, 100, 540, 400);
		g.drawLine(580, 100, 580, 400);

		// field attributes
		g.drawString("Endzone", 105, 115);
		g.drawString("Endzone", 105, 395);
		g.drawString("Goal", 180, 95);
		g.drawString("Goal", 180, 415);
		g.drawString("10", 220, 95);
		g.drawString("10", 220, 415);
		g.drawString("20", 260, 95);
		g.drawString("20", 260, 415);
		g.drawString("30", 300, 95);
		g.drawString("30", 300, 415);
		g.drawString("40", 340, 95);
		g.drawString("40", 340, 415);
		g.drawString("50", 380, 95);
		g.drawString("50", 380, 415);
		g.drawString("40", 420, 95);
		g.drawString("40", 420, 415);
		g.drawString("30", 460, 95);
		g.drawString("30", 460, 415);
		g.drawString("20", 500, 95);
		g.drawString("20", 500, 415);
		g.drawString("10", 540, 95);
		g.drawString("10", 540, 415);
		g.drawString("Goal", 580, 95);
		g.drawString("Goal", 580, 415);
		g.drawString("Endzone", 600, 115);
		g.drawString("Endzone", 600, 395);

		// Repaint frame
		df.repaint();
	}
}
