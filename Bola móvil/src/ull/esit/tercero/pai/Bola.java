/*
 * Clase que representa una bola en la pantalla.
 * Asignatura: Programación de aplicaciones interactivas.
 */
package ull.esit.tercero.pai;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Clase que representa una bola/círculo en la pantalla.
 */
public class Bola{
	
	private Graphics graphics;
	private Integer posX;
	private Integer posY;
	private Integer radius;
	private Color color;
	private Boolean filled;
	
	
	/**
	 * Contructor de la clase <code>Bola</code>.
	 * @param g
	 * @param x coordenada x de la bola.
	 * @param y coordenada y de la bola.
	 * @param radius radio de la bola.
	 * @param color color de la bola.
	 */
	public Bola(Graphics g, Integer x, Integer y, Integer radius, Color color, Boolean filled){
		
		setGraphics(g);
		setPosX(x);
		setPosY(y);
		setRadius(radius);
		setColor(color);
		setFilled(filled);
	}

	/**
	 * Dibujo una bola
	 */
	public void draw(){
		
		getGraphics().setColor(getColor());
		if (getFilled()){
			getGraphics().fillOval(getPosX(), getPosY(), getRadius(), getRadius());;
		}
		else{
			getGraphics().drawOval(getPosX(), getPosY(), getRadius(), getRadius());
		}
	}
	
	/**
	 * Mueve la bola hacia la arriba. Si el último movimiento supone traspasar el borde de la pantalla,
	 * se situará la bola justo al borde de la misma y se impedirá que la bola siga moviéndose en 
	 * esa dirección.
	 * @gap número de pixeles que se desplaza la bola.
	 * @width ancho del panel en pixeles.
	 */
	public void moveUp(int gap){
		if((getPosY() - gap) >= 0){
			setPosY(getPosY() - gap);
		}
		else{
			setPosY(0);
		}
	}
	
	/**
	 * Mueve la bola hacia la abajo. Si el último movimiento supone traspasar el borde de la pantalla,
	 * se situará la bola justo al borde de la misma y se impedirá que la bola siga moviéndose en 
	 * esa dirección.
	 * @gap número de pixeles que se desplaza la bola.
	 * @width ancho del panel en pixeles.
	 */
	public void moveDown(int height, int gap){
		if((getPosY() + gap) + getRadius() <= height){
			setPosY(getPosY() + gap);
		}
		else{
			setPosY(height - getRadius());
		}
	}
	
	
	/**
	 * Mueve la bola hacia la derecha. Si el último movimiento supone traspasar el borde de la pantalla,
	 * se situará la bola justo al borde de la misma y se impedirá que la bola siga moviéndose en 
	 * esa dirección.
	 * @gap número de pixeles que se desplaza la bola.
	 * @width ancho del panel en pixeles.
	 */
	public void moveRight(int width, int gap){
		if((getPosX() + gap) + getRadius() <= width){
			setPosX(getPosX() + gap);
		}
		else{
			setPosX(width - getRadius());
		}
	}
	/**
	 * Mueve la bola hacia la izquierda. Si el último movimiento supone traspasar el borde de la pantalla,
	 * se situará la bola justo al borde de la misma y se impedirá que la bola siga moviéndose en 
	 * esa dirección.
	 * @gap número de pixeles que se desplaza la bola.
	 */
	public void moveLeft(int gap){
		if((getPosX() - gap) >= 0){
			setPosX(getPosX() - gap);
		}
		else{
			setPosX(0);
		}
	}
	

	/**
	 * @return the graphics
	 */
	public Graphics getGraphics() {
		return graphics;
	}

	/**
	 * @param graphics the graphics to set
	 */
	public void setGraphics(Graphics graphics) {
		this.graphics = graphics;
	}

	/**
	 * @return the posX
	 */
	public Integer getPosX() {
		return posX;
	}

	/**
	 * @param posX the posX to set
	 */
	public void setPosX(Integer posX) {
		this.posX = posX;
	}

	/**
	 * @return the posY
	 */
	public Integer getPosY() {
		return posY;
	}

	/**
	 * @param posY the posY to set
	 */
	public void setPosY(Integer posY) {
		this.posY = posY;
	}

	/**
	 * @return the radius
	 */
	public Integer getRadius() {
		return radius;
	}

	/**
	 * @param radius the radius to set
	 */
	public void setRadius(Integer radius) {
		this.radius = radius;
	}

	/**
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(Color color) {
		this.color = color;
	}

	/**
	 * @return the filled
	 */
	public Boolean getFilled() {
		return filled;
	}

	/**
	 * @param filled the filled to set
	 */
	public void setFilled(Boolean filled) {
		this.filled = filled;
	}
	
	

}
